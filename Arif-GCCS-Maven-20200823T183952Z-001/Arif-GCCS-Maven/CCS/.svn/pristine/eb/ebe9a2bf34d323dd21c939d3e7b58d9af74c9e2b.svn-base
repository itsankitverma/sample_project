/**
 * FTCScanProcessor.java
 *
 * Created on September 28, 2002, 3:12 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.biztier.common.*;

import java.util.*;

/**
 *
 * @author  ccardenas
 */
public class FTCScanProcessor implements java.io.Serializable {
        
    private Collection threads=new ArrayList();
    private Collection errors=Collections.synchronizedCollection(new ArrayList());
    private Collection notProcessed=Collections.synchronizedCollection(new ArrayList());
    private Collection results;

    /** Holds value of property keepWhenNotFound. */
    private boolean keepWhenNotFound;
    
    /** Creates a new instance of FTCScanProcessor */
    public FTCScanProcessor() {
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
     * @param     collection of valid locations
     * @return    the non-processed AWBs.
     * @exception java.lang.Exception
     */    
    public Collection processLastScans(Collection awbs,Collection results,String locationCodePk,Collection validLocations,int scanLocalDecs,int scanUsdDecs) throws Exception{
            
    		if(awbs==null){
    			Constants.logger.debug("FTCScanProcessor.java > processLastScans: awbs == null ");
    		}
    		if(results==null){
    			Constants.logger.debug("FTCScanProcessor.java > processLastScans: results == null ");
    		}
    		if(locationCodePk==null){
    			Constants.logger.debug("FTCScanProcessor.java > processLastScans: locationCodePk == null ");
    		}
    		if(validLocations==null){
    			Constants.logger.debug("FTCScanProcessor.java > processLastScans: validLocations == null ");
    		}
    		
   			//Constants.logger.debug("FTCScanProcessor.java > processLastScans: scanLocalDecs = "+scanLocalDecs);
   			//Constants.logger.debug("FTCScanProcessor.java > processLastScans: scanUsdDecs = "+scanUsdDecs);

    		this.results=results;        
            ArrayList colAwbs=(ArrayList)awbs;

            
            int threadsNumber=Constants.threadsNumber;
            //splitting the list on sublists
            //and assigning every sublist to a thread
            if(!colAwbs.isEmpty()){
            	if(colAwbs.size()<threadsNumber){
                    threadsNumber=colAwbs.size();
                }

                int j=colAwbs.size()/threadsNumber;
                int mod=colAwbs.size()%threadsNumber;
                int from=0;
                int to=0;                
                errors.clear();
                for(int i=1;i<=threadsNumber;i++){
                    FTCProcessLastScanRunnable rq=new FTCProcessLastScanRunnable();                
                    rq.setErrors(errors);
                    rq.setNotProcessed(notProcessed);
                    rq.setLocationCodePk(locationCodePk);                    
                    rq.setKeepWhenNotFound(this.keepWhenNotFound);
                    rq.setValidLocations(validLocations);
                    rq.setScansLocalDecs(scanLocalDecs);
                    rq.setScansUsdDecs(scanUsdDecs);                    


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
     
    /** Getter for property keepWhenNotFound.
     * @return Value of property keepWhenNotFound.
     */
    public boolean isKeepWhenNotFound() {
        return this.keepWhenNotFound;
    }    
    
    /** Setter for property keepWhenNotFound.
     * @param keepWhenNotFound New value of property keepWhenNotFound.
     */
    public void setKeepWhenNotFound(boolean keepWhenNotFound) {
        this.keepWhenNotFound = keepWhenNotFound;
    }
    
}
