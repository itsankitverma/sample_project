package com.fedex.lacitd.cashcontrol.prestier.helper;


/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.masterlist_.MasterList;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;

import java.util.*;
/**
 * This class implements a Comparator for MasterList objects.
 * @author  ccardenas 
 */
public class MasterListComparator implements java.util.Comparator,java.io.Serializable{
		/**
		 * Compare two MasterList
		 * @return    <0 if MasterList1 < MasterList2
		 * 			  0  if MasterList1 = MasterList2
		 * 			  >0  if MasterList1 > MasterList2 
		 */
        public int compare(Object obj1, Object obj2) {
            try{
            	MasterList ml1=(MasterList)obj1;
            	MasterList ml2=(MasterList)obj2;                
                long seq1=Long.parseLong(ml1.getEvent_sequence_nbr()==null?"0":ml1.getEvent_sequence_nbr().stringValue());
                long seq2=Long.parseLong(ml2.getEvent_sequence_nbr()==null?"0":ml2.getEvent_sequence_nbr().stringValue());
                               
                if (ml1.getTrack_date()==null || ml2.getTrack_date()==null){ 
                	//If I can't use date I use just the sequence numbers
                    return ((seq1>seq2)?1:(seq1<seq2)?-1:0);                    
                }else{
                	//If I can use date, I do a deeper analysis
                    Date date1=CosmosScanUtils.parseDatesFromCosmos(ml1.getTrack_date().stringValue(),ml1.getTrack_scan_time().stringValue());
                    Date date2=CosmosScanUtils.parseDatesFromCosmos(ml2.getTrack_date().stringValue(),ml2.getTrack_scan_time().stringValue());
                    return date1.compareTo(date2);
                }
                    /*
                    int retValue=date1.compareTo(date2);
                    if(retValue!=0){ //if they are from different days order it by date
                        return retValue;
                    }else{

                    }
                }
                    }else{
                    	//if they are from the same day, order it by type of scan
                            String trackType1=ml1.getTrack_type()==null?null:ml1.getTrack_type().stringValue();
                            String codeType1=ml1.getTrack_exception_code()==null?null:ml1.getTrack_exception_code().stringValue();
                            String trackType2=ml2.getTrack_type()==null?null:ml2.getTrack_type().stringValue();
                            String codeType2=ml2.getTrack_exception_code()==null?null:ml2.getTrack_exception_code().stringValue();                        

                            int w1=0,w2=0;
                            //Assigning weights to the MasterList1 scan
                            if("20".equals(trackType1)) w1=5;
                            else if("31".equals(trackType1) && "16".equals(codeType1)) w1=4;
                                 else if("07".equals(trackType1) && "44".equals(codeType1)) w1=3;
                                      else if("30".equals(trackType1) && !"16".equals(codeType1)) w1=2;                            
                                           else if("11".equals(trackType1)) w1=1;                
                                                else w1=0;
                            
                            //Assigning weights to the MasterList2 scan
                            if("20".equals(trackType2)) w2=5;
                            else if("31".equals(trackType2) && "16".equals(codeType2)) w2=4;
                                 else if("07".equals(trackType2) && "44".equals(codeType2)) w2=3;
                                      else if("30".equals(trackType2) && !"16".equals(codeType2)) w2=2;                            
                                           else if("11".equals(trackType2)) w2=1;                                
                                                else w2=0;
                            
                            if(w1>0 && w2>0){
                            	 //If both has weights assigned greater than 0
                                 if(w1>w2){
                                 	 //If w1>w2 MasterList1 is greater than MasterList2
                                     return 1;
                                 }else if(w1<w2){
                                 	      //If w2>w1 MasterList2 is greater than MasterList1
                                          return -1;
                                       }else{
                                       		//If both has the same weight use sequence number to sort
                                            return ((seq1>seq2)?1:(seq1<seq2)?-1:0);    
                                       }   
                                 
                            }else{
                            	 //If both has weights assigned equal to 0 use sequence number to sort
                                 return ((seq1>seq2)?1:(seq1<seq2)?-1:0);                                
                            }
                    }
                }            */
            }catch(Exception pe){
                Constants.logger.debug(Utils.stackTraceToString(pe));
                return -1;
            }
        }
        
}
