/*
 * PrepaidScanProcessor.java
 *
 * Created on September 28, 2002, 3:12 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.biztier.common.*;
import java.util.*; 

/**
 * This class is in charge of manage the different threads
 * triggered to process the scans from Cosmos for the 
 * Add Prepaid feature. 
 * @author  ccardenas
 */
public class PrepaidScanProcessor implements java.io.Serializable {
	/**
	 * collection containing all the Threads triggered.
	 */
    private Collection threads=new ArrayList();

    /**
     * collection containing all the errors.
     */    
    private Collection errors=Collections.synchronizedCollection(new ArrayList());
    /**
     * collection containing all the not processed AWBs.
     */
    private Collection notProcessed=Collections.synchronizedCollection(new ArrayList());
    
    /**
     * collection containing all the results obtained.
     */    
    private Collection results;

    /** Creates a new instance of RODScanProcessor */
    public PrepaidScanProcessor() {
    }

    /**
     * This method process prepaid scans for
     * a list of AWBs by dividing the list in 
     * n parts and assigning every sublist to 
     * a diferent thread
     *
     * @param     awbs to be processed
     * @param     the collection where the results will be added
     * @param     location where the user is working
     * @param     current courier id
     * @param     current currency
     * @param     time zone of the location 
     * @return    the non-processed AWBs.
     * @exception java.lang.Exception
     */
    public Collection processLastScans(Collection awbs,Collection results,String locationCd,String courierId,String currentCurrency,String tzName,int scanLocalDecs,int scanUsdDecs,Collection validLocations) throws Exception{
            this.results=results;
            
            
            ArrayList colAwbs=new ArrayList(awbs);
            int threadsNumber=Constants.threadsNumber;
            
            
            if(!colAwbs.isEmpty()){
                if(colAwbs.size()<threadsNumber){
                    threadsNumber=colAwbs.size();
                }
                //splitting the list on sublists
                //and assigning every sublist to a thread
                int j=colAwbs.size()/threadsNumber;
                int mod=colAwbs.size()%threadsNumber;
                int from=0;
                int to=0;                
                errors.clear();
                for(int i=1;i<=threadsNumber;i++){
                    PrepaidScanRunnable rq=new PrepaidScanRunnable();                
                    rq.setErrors(errors);
                    rq.setCourierId(courierId);
                    rq.setNotProcessed(notProcessed);
                    rq.setLocationCd(locationCd);
                    rq.setCurrentCurrency(currentCurrency);
                    rq.setTzName(tzName);
                    rq.setScansLocalDecs(scanLocalDecs);
                    rq.setScansUsdDecs(scanUsdDecs);
                    rq.setValidLocations(validLocations);

                    from=to;
                    if(i<=mod)
                        to=from+j+1;
                    else
                        to=from+j;

                    rq.setAwbs(colAwbs.subList(from,to));
                    rq.setResults(results);
                    
                    Thread trh=new Thread(rq);
                    threads.add(trh);
                    trh.start();
                }
                
                //waiting for the last thread 
                //to stop
                boolean stop=false;
                do{
                    Thread.sleep(1000);
                    Iterator iter=threads.iterator();
                    boolean running=false;
                    while(iter.hasNext()){
                        Thread aux=(Thread)iter.next();
                        if(aux!=null && aux.isAlive()){
                           running=true;
                        }
                    }
                    stop=!running;
                }while(!stop);

                //collecting the errors
                if(errors.isEmpty()){
                    Collection colAllNotProcessed=new ArrayList();
                    Iterator iter=notProcessed.iterator();
                    while(iter.hasNext()) colAllNotProcessed.addAll((Collection)iter.next());
                    return colAllNotProcessed;
                }else{
                    String errorMessages="Errors:\n";
                    Iterator iter=errors.iterator();
                    while(iter.hasNext()){
                        errorMessages=errorMessages+((Exception)iter.next()).toString()+"\n";
                    }
                    throw new Exception(errorMessages);
                }
            }else{
                return new ArrayList();
            }   
    }
     
    
}
