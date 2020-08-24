/*
 * RODScanProcessor.java
 *
 * Created on September 28, 2002, 3:12 PM
 */
package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;


/**
 *
 * @author  ccardenas
 */
public class PrepNotCheckedScanProc implements java.io.Serializable
{
    private Collection threads = new ArrayList();
    private Collection errors = Collections.synchronizedCollection(new ArrayList());
    private Collection notProcessed = Collections.synchronizedCollection(new ArrayList());
    private Collection results;

    /** Creates a new instance of RODScanProcessor */
    public PrepNotCheckedScanProc ()
    {
    }

    /**
     * This methods is in charge of manage the threads
     * triggered when processing the prepaid scans
     * for the non checked-in AWBs for Prepaid
     *
     * @param the list of AWBs to be processed
     * @param the list of results from the scan processing
     * @exception java.lang.Exception
     */
    public Collection processLastScans (Collection awbs, Collection results)
        throws Exception
    {
        this.results = results;

        ArrayList colAwbs = new ArrayList(awbs);

        //getting the number of threads to be used
        int threadsNumber = Constants.threadsNumber;

        if(!colAwbs.isEmpty())
        {
            //adjusting the number of threads to the number of AWBs
            if(colAwbs.size() < threadsNumber)
            {
                threadsNumber = colAwbs.size();
            }

            //distributing the list into the sublists for every thread
            //and starting the threads
            int j = colAwbs.size() / threadsNumber;
            int mod = colAwbs.size() % threadsNumber;
            int from = 0;
            int to = 0;
            errors.clear();

            for(int i = 1; i <= threadsNumber; i++)
            {
                PrepNotCheckedScanRunn rq = new PrepNotCheckedScanRunn();
                rq.setErrors(errors);
                rq.setNotProcessed(notProcessed);

                from = to;

                if(i <= mod)
                {
                    to = from + j + 1;
                }
                else
                {
                    to = from + j;
                }

                rq.setAwbs(colAwbs.subList(from, to));
                rq.setResults(results);

                Thread trh = new Thread(rq);
                threads.add(trh);
                trh.start();
            }

            //monitoring all the threads until all of them are done
            boolean stop = false;

            do
            {
                Thread.sleep(1000);

                Iterator iter = threads.iterator();
                boolean running = false;

                while(iter.hasNext())
                {
                    Thread aux = (Thread) iter.next();

                    if((aux != null) && aux.isAlive())
                    {
                        running = true;
                    }
                }

                stop = !running;
            }
            while(!stop);

            //collecting the errors produced
            if(errors.isEmpty())
            {
                Collection colAllNotProcessed = new ArrayList();
                Iterator iter = notProcessed.iterator();

                while(iter.hasNext())
                    colAllNotProcessed.addAll((Collection) iter.next());

                return colAllNotProcessed;
            }
            else
            {
                String errorMessages = "Errors:\n";
                Iterator iter = errors.iterator();

                while(iter.hasNext())
                {
                    errorMessages = errorMessages + ((Exception) iter.next()).toString() + "\n";
                }

                throw new Exception(errorMessages);
            }
        }
        else
        {
            return new ArrayList();
        }
    }
}
