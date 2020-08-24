/**
 * RODProcessLastScanRunnable.java
 *
 * Created on September 28, 2002, 3:31 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.*;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.Ia5string;
import com.fedex.asn.IA5String.enhancedevent_.EnhancedEvent;
import com.fedex.asn.IA5String.masterlist_.MasterList;

import com.fedex.asn.IA5String.shipmentprofile_.ShipmentProfile;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;

import java.net.*;
import java.io.*;
import java.text.*;
import com.oss.asn1.*;

/**
 * This class is in charge of getting the scans from Cosmos
 * 
 * @author ccardenas
 */
public class CosmosScanUtils implements Serializable {
	/** Creates a new instance of CosmosScanUtils */
	public CosmosScanUtils() {
	}

	private static final int NONE = 0;
	private static final int HAVEPOD = 1;
	private static final int HAVEDDEX = 2;

	private static final int HAVEPUX = 1;

	/**
	 * It gets ROD the scans for the locations specified
	 * 
	 * 
	 * @param awbNbr
	 * @param tinUniqId
	 * @param colErrors
	 * @param cntryCd
	 * @param validLocations
	 * @param fullList
	 *            if true returns all the important scans. If true just the more
	 *            important ones.
	 */
	public Collection getRODScans(String awbNbr, String tinUniqId,
			Collection colErrors, String cntryCd, Collection validLocations,
			boolean fullList) {
		Collection allScans = getScans(awbNbr, tinUniqId, colErrors);
		Collection rodScans = new ArrayList();
		if (allScans == null)
			allScans = new ArrayList();

		int specialScans = NONE;

		Iterator iterAllScans = allScans.iterator();
		while (iterAllScans.hasNext()) {
			MasterList ml = (MasterList) iterAllScans.next();

			String trackType = ml.getTrack_type() == null ? null : ml
					.getTrack_type().stringValue();
			System.out.println("trackType==" + trackType);
			String codeType = ml.getTrack_exception_code() == null ? null : ml
					.getTrack_exception_code().stringValue();
			// System.out.println("codeType=="+codeType);
			String trackLocationCd = ml.getTrack_location_code() == null ? null
					: ml.getTrack_location_code().stringValue();
			// System.out.println("trackLocationCd=="+trackLocationCd);
			if (trackType == null
					|| (validLocations != null && !validLocations.isEmpty() && !validLocations
							.contains(trackLocationCd))) {
				iterAllScans.remove();
			} else {
				if ("11".equals(trackType) || // VAN SCAN
						("30".equals(trackType) && !"16".equals(codeType)) || // DEX
																				// !=16
						"31".equals(trackType) || // DDEX
						("07".equals(trackType) && "44".equals(codeType)) || // STAT44
						"02".equals(trackType) || // SIP
						"20".equals(trackType) || // POD SCAN
						"41".equals(trackType) || // HAL
						"90".equals(trackType) // COMM
				) {
					if (fullList)
						rodScans.add(ml);
					else {
						if ("31".equals(trackType)
								&& ("16".equals(codeType) || "99"
										.equals(codeType))) { // DDEX16
							rodScans.clear(); // if DDEX16, just return this
												// scan
							rodScans.add(ml);
							specialScans = HAVEDDEX;
						} else {
							if ("20".equals(trackType)
									&& specialScans != HAVEDDEX) { // if POD
																	// SCAN and
																	// not
																	// DDEX16
																	// return it
								rodScans.clear(); // if POD SCAN and not DDEX16
													// return it
								rodScans.add(ml);
								specialScans = HAVEPOD;
							} else {
								if (specialScans != HAVEDDEX
										&& specialScans != HAVEPOD
										&& !"90".equals(trackType)) {
									rodScans.add(ml);
								}
							}
						}
					}
				}
			}
		}
		return rodScans;
	}

	/**
	 * It gets COD the scans for the locations specified
	 * 
	 * 
	 * @param awbNbr
	 * @param tinUniqId
	 * @param colErrors
	 * @param cntryCd
	 * @param validLocations
	 * @param fullList
	 *            if true returns all the important scans. If true just the more
	 *            important ones.
	 */
	public Collection getCODScans(String awbNbr, String tinUniqId,
			Collection colErrors, String cntryCd, Collection validLocations,
			boolean fullList) {
		Collection allScans = getScans(awbNbr, tinUniqId, colErrors);
		Collection codScans = new ArrayList();
		if (allScans == null)
			allScans = new ArrayList();
		int specialScans = NONE;
		Iterator iterAllScans = allScans.iterator();
		while (iterAllScans.hasNext()) {
			MasterList ml = (MasterList) iterAllScans.next();
			String trackType = ml.getTrack_type() == null ? null : ml
					.getTrack_type().stringValue();
			String codeType = ml.getTrack_exception_code() == null ? null : ml
					.getTrack_exception_code().stringValue();
			String trackLocationCd = ml.getTrack_location_code() == null ? null
					: ml.getTrack_location_code().stringValue();
			if ("20".equals(trackType) || "11".equals(trackType)
					|| "31".equals(trackType)) {
				System.out.println("*******The Details are " + trackType + " "
						+ codeType + " " + " " + trackLocationCd);
			}// Arjun
			validLocations.add(trackLocationCd);
			if (trackType == null
					|| (validLocations != null && !validLocations.isEmpty() && !validLocations
							.contains(trackLocationCd))) {
				iterAllScans.remove();
			} else {
				if ("11".equals(trackType) || // VAN SCAN
						("30".equals(trackType) && !"11".equals(codeType)) || // DEX
																				// !=11
						"31".equals(trackType) || // DDEX
						("07".equals(trackType) && "44".equals(codeType)) || // STAT44
						"02".equals(trackType) || // SIP
						"20".equals(trackType) || // POD SCAN
						"41".equals(trackType) || // HAL
						"90".equals(trackType) // COMM
				) {
					if (fullList) {
						codScans.add(ml);
					} else {
						if ("31".equals(trackType)
								&& ("11".equals(codeType) || "99"
										.equals(codeType))) { // DDEX16
							codScans.clear(); // if DDEX16, just return this
												// scan
							codScans.add(ml);
							specialScans = HAVEDDEX;
						} else {
							if ("20".equals(trackType)
									&& specialScans != HAVEDDEX) {
								// if POD SCAN and not DDEX16 return it
								codScans.clear(); // if POD SCAN and not DDEX16
													// return it
								codScans.add(ml);
								specialScans = HAVEPOD;
							} else {
								if (specialScans != HAVEDDEX
										&& specialScans != HAVEPOD
										&& !"90".equals(trackType)) {
									codScans.add(ml);
								}
							}
						}
					}
				}
			}
		}
		if (codScans != null) {
			System.out.println("The Scan type is " + specialScans
					+ " HAVEPOD = 1,HAVEDDEX = 2;");
			System.out.println("The COD Scans are " + codScans);
		}
		return codScans;
	}

	/**
	 * It gets the PREPAID scans for the locations specified
	 * 
	 * 
	 * @param awbNbr
	 * @param tinUniqId
	 * @param colErrors
	 * @param cntryCd
	 * @param validLocations
	 *            a
	 * @param fullList
	 *            if true returns all the important scans. If true just the more
	 *            important ones.
	 */
	public Collection getPrepaidScans(String awbNbr, String tinUniqId,
			Collection colErrors, String cntryCd, Collection validLocations,
			boolean fullList) {
		Collection allScans = getScans(awbNbr, tinUniqId, colErrors);
		Collection prpScans = new ArrayList();
		if (allScans == null)
			allScans = new ArrayList();

		int specialScans = NONE;

		Iterator iterAllScans = allScans.iterator();
		while (iterAllScans.hasNext()) {
			MasterList ml = (MasterList) iterAllScans.next();

			String trackType = ml.getTrack_type() == null ? null : ml
					.getTrack_type().stringValue();
			String codeType = ml.getTrack_exception_code() == null ? null : ml
					.getTrack_exception_code().stringValue();
			String trackLocationCd = ml.getTrack_location_code() == null ? null
					: ml.getTrack_location_code().stringValue();
			if (trackType == null
					|| (validLocations != null && !validLocations.isEmpty() && !validLocations
							.contains(trackLocationCd))) {
				iterAllScans.remove();
			} else {

				if ("08".equals(trackType) || // PUP
						("29".equals(trackType) && "16".equals(codeType)) || // PUX16
						("29".equals(trackType) && "23".equals(codeType)) || // PUX23
																				// //PUX23
						"90".equals(trackType) // COMM
				) {
					if (fullList)
						prpScans.add(ml);
					else {
						if ("29".equals(trackType) && "16".equals(codeType)) { // DDEX16
							prpScans.clear(); // if PUX16, just return this scan
							prpScans.add(ml);
							specialScans = HAVEPUX;
						} else {
							if (specialScans != HAVEPUX
									&& !"90".equals(trackType)) {
								prpScans.add(ml);
							}
						}
					}
				}
			}
		}
		return prpScans;
	}

	/**
	 * It gets the scans from COSMOS Returns a Collection with collections of
	 * Scans. It will have just one collection object except the AWB have
	 * duplicates
	 * 
	 * @param awbNbr
	 *            Collection of collections objects containing the AWB scans
	 * @param tinUniqId
	 *            where the user is working
	 */
	public Collection getScans(String awbNbr, String tinUniqId,
			Collection colErrors) {
		Collection colShiprof = null;
		Collection colMasterList = null;

		if (colErrors == null) {
			colErrors = new ArrayList();
		} else {
			colErrors.clear();
		}
		int att = 1;
		// try{
		/*---Trying 3 times to get the shipment profile---*/
		att = 1;
		do {
			try {
				/*----Getting Scans using DetailUid (if tinUniqId is not null) or Detail Full Query (if tinUniqId is null)---*/
				colMasterList = getScansDetails(awbNbr, tinUniqId);
				if (colMasterList != null && !colMasterList.isEmpty()) {
					break;
				}
			} catch (DecodeFailedException e) {
				Constants.logger.debug("\n Error 1 : "
						+ Utils.stackTraceToString(e));
				if (att >= 3)
					colErrors.add(new ScansProcessingError(awbNbr,
							"app.messages.DecodingError", null, "", "", ""));
			} catch (DecodeNotSupportedException e) {
				Constants.logger.debug("\n Error 2 : "
						+ Utils.stackTraceToString(e));
				if (att >= 3)
					colErrors.add(new ScansProcessingError(awbNbr,
							"app.messages.DecodingError", null, "", "", ""));
			} catch (Exception e) {
				Constants.logger.debug("\n Error 3 : "
						+ Utils.stackTraceToString(e));
				if (att >= 3)
					colErrors.add(new ScansProcessingError(awbNbr,
							"app.messages.UnknownError", e.getMessage(), "",
							"", ""));
			}
			att++;
		} while (att <= 3);

		/*** Retry using Detail Full Query (if it was not done in the last query) **/
		if (colMasterList == null && tinUniqId != null) {
			att = 1;
			do {
				try {
					/*----Getting Scans using Detail Full Query---*/
					colMasterList = getScansDetails(awbNbr, null);
					if (colMasterList != null && !colMasterList.isEmpty()) {
						break;
					}
				} catch (DecodeFailedException e) {
					Constants.logger.debug("\n Error 4 : "
							+ Utils.stackTraceToString(e));
					if (att >= 3)
						colErrors
								.add(new ScansProcessingError(awbNbr,
										"app.messages.DecodingError", null, "",
										"", ""));
				} catch (DecodeNotSupportedException e) {
					Constants.logger.debug("\n Error 5 : "
							+ Utils.stackTraceToString(e));
					if (att >= 3)
						colErrors
								.add(new ScansProcessingError(awbNbr,
										"app.messages.DecodingError", null, "",
										"", ""));
				} catch (Exception e) {
					Constants.logger.debug("\n Error 6 : "
							+ Utils.stackTraceToString(e));
					if (att >= 3)
						colErrors.add(new ScansProcessingError(awbNbr,
								"app.messages.UnknownError", e.getMessage(),
								"", "", ""));
				}

				att++;
			} while (att <= 3);

		}

		if (colMasterList == null || colMasterList.isEmpty()) {
			att = 1;
			do {
				try {
					/*----Getting ShipmentProfile---*/
					colShiprof = getShipmentProfile(awbNbr);
					if (colShiprof == null || colShiprof.isEmpty())
						att++;
					else {
						Iterator iterShipProf = colShiprof.iterator();
						while (iterShipProf.hasNext()) {
							ShipmentProfile shiprof = (ShipmentProfile) iterShipProf
									.next();
							tinUniqId = shiprof.getTracking_item_unique_id() == null ? null
									: shiprof.getTracking_item_unique_id()
											.stringValue();

							int att1 = 1;
							do {
								try {
									/*----Getting Scans using DetailUid ---*/
									Collection col = getScansDetails(awbNbr,
											tinUniqId);
									if (col == null || col.isEmpty()) {
										att1++;
									} else {// if it is not null, get tuid and
											// stop retrying.
										if (colMasterList == null)
											colMasterList = new ArrayList();
										colMasterList.addAll(col);
										break;
									}
								} catch (DecodeFailedException e) {
									Constants.logger.debug("\n Error 7 : "
											+ Utils.stackTraceToString(e));
									if (att1 >= 3)
										colErrors.add(new ScansProcessingError(
												awbNbr,
												"app.messages.DecodingError",
												null, "", "", ""));
								} catch (DecodeNotSupportedException e) {
									Constants.logger.debug("\n Error 8 : "
											+ Utils.stackTraceToString(e));
									if (att1 >= 3)
										colErrors.add(new ScansProcessingError(
												awbNbr,
												"app.messages.DecodingError",
												null, "", "", ""));
								} catch (Exception e) {
									Constants.logger.debug("\n Error 9 : "
											+ Utils.stackTraceToString(e));
									if (att1 >= 3)
										colErrors.add(new ScansProcessingError(
												awbNbr,
												"app.messages.UnknownError", e
														.getMessage(), "", "",
												""));
								}

								att1++;
							} while (att1 <= 3);
						}
						break;
					}
				} catch (DecodeFailedException e) {
					Constants.logger.debug("\n Error 10 : "
							+ Utils.stackTraceToString(e));
					if (att >= 3)
						colErrors
								.add(new ScansProcessingError(awbNbr,
										"app.messages.DecodingError", null, "",
										"", ""));
				} catch (DecodeNotSupportedException e) {
					Constants.logger.debug("\n Error 11 : "
							+ Utils.stackTraceToString(e));
					if (att >= 3)
						colErrors
								.add(new ScansProcessingError(awbNbr,
										"app.messages.DecodingError", null, "",
										"", ""));
				} catch (Exception e) {
					Constants.logger.debug("\n Error 12 : "
							+ Utils.stackTraceToString(e));
					if (att >= 3)
						colErrors.add(new ScansProcessingError(awbNbr,
								"app.messages.UnknownError", e.getMessage(),
								"", "", ""));
				}

				att++;
			} while (att < 3);
		}

		if (colMasterList == null || colMasterList.isEmpty()) {
			Iterator iterErrors = colErrors.iterator();
			while (iterErrors.hasNext()) {
				ScansProcessingError spe = (ScansProcessingError) iterErrors
						.next();
				Constants.logger.debug("Scan Processing AWB "
						+ spe.getAwbNumber()
						+ ": "
						+ (spe.getErrorMessage() == null ? "" : spe
								.getErrorMessage())
						+ (spe.getErrorDetails() == null ? "" : "\n"
								+ spe.getErrorDetails()));
			}
			return colMasterList == null ? new ArrayList() : colMasterList;
		} else {
			return colMasterList;
		}
	}

	/**
	 * Get all the Shipment Profiles from eCQS for the AWB.
	 * 
	 * @param the
	 *            AWB number
	 * @param the
	 *            location where the user is working
	 * @return the Shipment Profile.
	 */
	private Collection getShipmentProfile(String awbNumber)
			throws MalformedURLException, IOException, ProtocolException,
			DecodeFailedException, DecodeNotSupportedException {
		String urlString = Constants.urlECQS+"tokenId="+getEQSToken()+"&qName=detailRecent&trkNo="+awbNumber;
        URL url = new URL(urlString);
		/*----Creating the params string----*/

		// eCQS Request Rhondalyn Svoboda 01/07/2009 Jorge Quiroz

		// String params=
		// Constants.qNameParamName+"="+Constants.qNameSummaryValue+"&"+Constants.tinParamName+"="+awbNumber;
		String params = Constants.qNameParamName + "="
				+ Constants.qNameDetailRecent + "&" + Constants.tinParamName
				+ "=" + awbNumber;
		// Constants.logger.debug("using --->" + params);

		/*----Opening the connection and sending the paramters to the eCQS web server ----*/
		URLConnection con = url.openConnection();
		//con.setRequestMethod("POST");
		//byte[] bytes = params.getBytes();
		//con.setDoOutput(true);
		//con.setDoInput(true);
		//OutputStream out = con.getOutputStream();
		//out.write(bytes);
		//out.flush();

		//con.connect();
		/*----Receiving and printing headers----*/
		//int code = con.getResponseCode();
		//String msg = con.getResponseMessage();
		// System.out.println("response-message " + code + " " + msg);
		for (int n = 1;; ++n) {
			if (con.getHeaderFieldKey(n) == null)
				break;
			// System.out.println(
			// con.getHeaderFieldKey(n) + " " +
			// con.getHeaderField(n));
		}
		/*----Creating the ASN.1 decoder----*/
		InputStream is = con.getInputStream();
		EnhancedEvent sink = new EnhancedEvent();
		Coder coder = Ia5string.getDefaultCoder();
		coder.disableDecoderConstraints();

		final int contentLength = con.getHeaderFieldInt("Content-Length", 0);
		/*----Receiving the response----*/
		byte[] buffer = new byte[contentLength];
		int bytesCopied = 0;
		while (bytesCopied < contentLength) {
			int result = is.read(buffer, bytesCopied, contentLength
					- bytesCopied);
			// System.out.println(result);
			if (result == -1)
				break;
			bytesCopied += result;
		}
		is.close();
		is = new ByteArrayInputStream(buffer);
		/*------Decoding the octec stram comming from eCQS-------*/
		Collection colEE = new ArrayList();
		while (is.available() > 0) {
			EnhancedEvent result = (EnhancedEvent) coder.decode(is, sink);
			colEE.add(result);
		}

		Collection colShipProf = new ArrayList();
		Iterator iterEE = colEE.iterator();
		while (iterEE.hasNext()) {
			EnhancedEvent ee = (EnhancedEvent) iterEE.next();
			if (ee.hasShipment_profile()) {
				colShipProf.add(ee.getShipment_profile());
			}
		}
		return colShipProf;

	}

	/**
	 * Get the scans from eCQS for the AWB.
	 * 
	 * @param the
	 *            AWB number
	 * @param the
	 *            Tracking Item Unique Id that allows us to identify the correct
	 *            AWB.
	 * @return the collection of scans applied to the AWB.
	 */
	private Collection getScansDetails(String awbNumber, String tuid)
			throws MalformedURLException, IOException, ProtocolException,
			DecodeFailedException, DecodeNotSupportedException {
		String urlString = Constants.urlECQS+"tokenId="+getEQSToken()+"&qName=detailRecent&trkNo="+awbNumber;
		URL url = new URL(urlString);
        //HttpURLConnection con = (HttpURLConnection)url.openConnection();
		URLConnection con = url.openConnection();
		
		//con.setRequestMethod("GET");
		Collection colMasterList = new ArrayList();
		/*----Creating the params string----*/
		//String params = null;
		//if (tuid != null) {
			/*
			// params=
			// Constants.qNameParamName+"="+Constants.qNameDetailValue+"&"+Constants.tinParamName+"="+awbNumber+"&"+Constants.tuidParamName+"="+tuid;
			params = Constants.qNameParamName + "="
					+ Constants.qNameDetailRecent + "&"
					+ Constants.tinParamName + "=" + awbNumber + "&"
					+ Constants.tuidParamName + "=" + tuid;
			*/
		//} else {
			/*
			params = Constants.qNameParamName + "="
					+ Constants.qNameDetailRecent + "&"
					+ Constants.tinParamName + "=" + awbNumber;
			*/
		//}

		// Constants.logger.debug("params : " + params);

		/*----Opening the connection and sending the paramters to the eCQS web server ----*/
		//byte[] bytes = params.getBytes();
		//con.setDoOutput(true);
		//con.setDoInput(true);
		//OutputStream out = con.getOutputStream();
		//out.write(bytes);
		//out.flush();

		//con.connect();

		/*----Receiving and printing headers----*/
		//int code = con.getResponseCode();
		//String msg = con.getResponseMessage();
		//System.out.println("response code msg ==" + msg);

		for (int n = 1;; ++n) {
			if (con.getHeaderFieldKey(n) == null)
				break;
			System.out.println(con.getHeaderFieldKey(n) + " "
					+ con.getHeaderField(n));
		}
		/*----Creating the ASN.1 decoder----*/
		InputStream is = con.getInputStream();
		EnhancedEvent sink = new EnhancedEvent();
		Coder coder = Ia5string.getDefaultCoder();
		coder.disableDecoderConstraints();
		final int contentLength = con.getHeaderFieldInt("Content-Length", 0);

		/*----Receiving the response----*/
		byte[] buffer = new byte[contentLength];
		int bytesCopied = 0;
		while (bytesCopied < contentLength) {
			int result = is.read(buffer, bytesCopied, contentLength
					- bytesCopied);
			// System.out.println(result);
			if (result == -1)
				break;
			bytesCopied += result;
		}
		is.close();
		is = new ByteArrayInputStream(buffer);
		Collection col = new ArrayList();
		EnhancedEvent result = null;
		while (is.available() > 0) {
			result = (EnhancedEvent) coder.decode(is, sink);
			/*------Decoding the octec stream comming from eCQS-------*/
			if (result.hasMaster_list_history()) {
				EnhancedEvent.Master_list_history mlh = result
						.getMaster_list_history();
				Enumeration scanList = mlh.elements();
				while (scanList.hasMoreElements()) {
					MasterList scan = (MasterList) scanList.nextElement();
					colMasterList.add(scan);
				}

			} else {
				System.out
						.println("ERROR! got back a blob with no ML history!");
			}
		}
		return colMasterList;
	}

	/**
	 * Determine if a String is a number.
	 * 
	 * @param string
	 *            to parse
	 * @return true is number; false is not number
	 */
	private boolean isNumber(String txt) {
		try {
			new Float(txt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private static String getEQSToken(){
 		
	 	//========= Token thing ============================///////
			  String token_code="";
			  String token_filepath = null;
			  String str="";
			  Properties prop=null;
			  try {
				prop= Utils.getProperties("P");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  token_filepath= prop.getProperty("eqs.token.filepath");
			  System.out.println("eqs.token.filepath from database=="+token_filepath);

			  try {
		
				  BufferedReader in = new BufferedReader(new FileReader(token_filepath));
				  while ((str = in.readLine()) != null) {
					  token_code = str;
					  token_code = ""+URLEncoder.encode(token_code,"ISO-8859-1");
				  }//end while
				  in.close();
			 } catch (IOException e) {
				 e.printStackTrace();
			 }//end try
		//================= End Token Code ================/////////
			 return token_code;
	}

	public static java.util.Date parseDatesFromCosmos(String datepart,
			String timepart) {
		if (datepart != null) {
			if (timepart == null)
				timepart = "0000";
			datepart = datepart.substring(0, 8);
			timepart = timepart.substring(0, 4);
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmm");
				return sdf.parse(datepart + " " + timepart);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
