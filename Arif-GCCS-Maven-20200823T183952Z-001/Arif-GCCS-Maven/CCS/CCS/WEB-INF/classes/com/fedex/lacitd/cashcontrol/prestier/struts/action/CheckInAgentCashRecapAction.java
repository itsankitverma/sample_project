/**
 * CheckInAgentCashRecapAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */
package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.PaymentReceiveDataFeed;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;

import org.apache.struts.action.*;

import java.util.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.PaymentTypeController;

import com.fedex.common.j2ee.mcd.MCD;
import com.fedex.lacitd.cashcontrol.prestier.helper.AppInit;
//import com.fedex.lacitd.cashcontrol.prestier.helper.McDUtils;
//import com.fedex.lacitd.cashcontrol.prestier.helper.AppUtils;
//import com.fedex.lacitd.cashcontrol.prestier.helper.AppLogger;

/**
 * This class is used to manage the request for the Summary Screen.
 * 
 * @author ccardenas
 */
public class CheckInAgentCashRecapAction extends Action implements
		java.io.Serializable
{
	private static final String defaulPageDefault = "ROD";

	public CheckInAgentCashRecapAction()
	{
	}

	/**
	 * This methods is executed by Struts framework when a request to the
	 * related URI is done.
	 * 
	 * @param Struts
	 *            action mapping object
	 * @param Struts
	 *            action form object
	 * @param http
	 *            request object
	 * @param http
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		AppInit.startMcd();
		if (request.getSession().getAttribute("userProfile") == null) return mapping
				.findForward("logout");
		System.out.println("request.getParameter(\"action\"): "
				+ request.getParameter("action"));
		if ("CloseCourier".equals(request.getParameter("action")))
		{
			return closeCourier(mapping, form, request, response);
		}
		else if ("ProcessEndDay".equals(request.getParameter("action")))
		{
			return processEndDay(mapping, form, request, response);
		}
		else if ("ReassignPayments".equals(request.getParameter("action")))
		{
			return reassignPayments(mapping, form, request, response);
		}
		else if ("ReopenEndDay".equals(request.getParameter("action")))
		{
			return reopenEndDay(mapping, form, request, response);
		}
		else if ("quickCollectLaters".equals(request.getParameter("action")))
		{
			return quickCollectLaters(mapping, form, request, response);
		}
		else if ("quickClear".equals(request.getParameter("action")))
		{
			return quickClear(mapping, form, request, response);
		}
		else if ("showMultipleInvoices".equals(request.getParameter("action")))
		{
			return showMultipleInvoices(mapping, form, request, response);
		}
		else if ("saveMultipleInvoices".equals(request.getParameter("action")))
		{
			return saveMultipleInvoices(mapping, form, request, response);
		}
		else if ("GoDetails".equals(request.getParameter("action")))
		{
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			if ((ep.getDefaultDetailPage() == null)
					|| (ep.getDefaultDetailPage().length() < 3))
			{
				return mapping.findForward(defaulPageDefault);
			}
			else
			{
				return mapping.findForward(ep.getDefaultDetailPage());
			}
		}
		else if ("goMorePayments".equals(request.getParameter("action")))
		{
			return showMorePayments(mapping, form, request, response);
		}
		else
		{
			return show(mapping, form, request, response);
		}
	}

	/**
	 * This methods is executed when the user select the Close Courier option on
	 * the Summary Screen.
	 * 
	 * @param Struts
	 *            action mapping object
	 * @param Struts
	 *            action form object
	 * @param http
	 *            request object
	 * @param http
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward closeCourier(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		try
		{
			CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			CheckInAgentCashRecapForm checkAgent = (CheckInAgentCashRecapForm) form;
			Iterator iterSummary = checkAgent.getEmployeeSummaries().iterator();
			// get the selected couriers to be closed
			Collection closeCouriers = new ArrayList();
			while (iterSummary.hasNext())
			{
				ExpressCheckinTableVO ec = (ExpressCheckinTableVO) iterSummary
						.next();
				if (ec.isCloseCourier())
				{
					closeCouriers.add(ec.getEmployeeId());
				}
			}
			// if there are not couriers selected, show an error message
			if (closeCouriers.isEmpty())
			{
				ActionErrors ae = new ActionErrors();
				ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
						"errors.messages.MustSelectCourierToClose"));
				saveErrors(request, ae);
				return show(mapping, form, request, response);
			}
			// close the selected couriers
			if (!bizComm.closeCouriers(ep.getEmployeeId(), ep.getLocationCd(),
					closeCouriers))
			{
				// if an error ocurred when trying to close the couriers
				ActionErrors ae = new ActionErrors();
				ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
						"errors.messages.CouldNotCloseCourier"));
				saveErrors(request, ae);
			}
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		return show(mapping, form, request, response);
	}

	/**
	 * This methods is executed when the user select to move payment from one
	 * courier to another.
	 * 
	 * @param Struts
	 *            action mapping object
	 * @param Struts
	 *            action form object
	 * @param http
	 *            request object
	 * @param http
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward reassignPayments(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		try
		{
			CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			CheckInAgentCashRecapForm checkAgent = (CheckInAgentCashRecapForm) form;
			Iterator iterSummary = checkAgent.getEmployeeSummaries().iterator();
			while (iterSummary.hasNext())
			{
				ExpressCheckinTableVO ec = (ExpressCheckinTableVO) iterSummary
						.next();
				if (!ec.isSelected())
				{
					iterSummary.remove();
				}
			}
			if (checkAgent.getEmployeeSummaries().size() > 1) checkAgent
					.setNewEmployeeId(null);
			if (checkAgent.getNewReassLocationCd() == null
					|| "".equals(checkAgent.getNewReassLocationCd())) checkAgent
					.setNewReassLocationCd(ep.getLocationCd());
			iterSummary = checkAgent.getEmployeeSummaries().iterator();
			while (iterSummary.hasNext())
			{
				ExpressCheckinTableVO ec = (ExpressCheckinTableVO) iterSummary
						.next();
				bizComm.reassignPayments(ec.getEmployeeId(),
						checkAgent.getNewEmployeeId(), ep.getLocationCd(),
						checkAgent.getNewReassLocationCd(), ep.getEmployeeId(),
						checkAgent.isReassROD(), checkAgent.isReassPRP(),
						checkAgent.isReassPOA(), checkAgent.isReassGRN());
			}
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		return show(mapping, form, request, response);
	}

	/**
	 * This methods is run by Struts framework when a request to the related URI
	 * is done. It has the code to change the location of the logger user.
	 * 
	 * @param mapping
	 *            object
	 * @param form
	 *            object
	 * @param request
	 *            object
	 * @param response
	 *            object
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		try
		{
			/* Start- For Mcd start for Checkin Agent Summary page */
			long startTime = System.currentTimeMillis();
			try
			{
				System.out.println("Mcd in CheckInAgentSummary");
				// System.out.println("AppInit.getHostname()=="+AppInit.getHostname());
				// Beginning of request. Inform McD
				MCD.processEvent("server", "GCCS",
						"CheckInAgentCashRecapAction",
						// AppUtils.getHostname(),
						AppInit.getHostname(), null, "OR",
						"CheckInAgentSummaryScreen", null, null, -1, null);
			}
			catch (Exception e)
			{
				System.out
						.println("McD Exception while processing GCCS.CheckinAgentSummary");
				e.printStackTrace();
				// AppLogger.error("McD Exception while processing GCCS.CheckinAgentSummary",
				// e) ;
			}
			/* End- For Mcd start for Checkin Agent Summary page */
			CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			CheckInAgentCashRecapForm checkAgent = new CheckInAgentCashRecapForm();
			List listSummary = (List) bizComm.getPaymentsSummaryByEmp(ep
					.getLocationCd());
			Iterator iterSummary = listSummary.iterator();
			boolean firstTime = true;
			while (iterSummary.hasNext())
			{
				ExpressCheckinTableVO ec = (ExpressCheckinTableVO) iterSummary
						.next();
				// this if manage the first object in the collection containing
				// the totals for Other Payments
				if (firstTime && "XXXXXX".equals(ec.getEmployeeId()))
				{
					checkAgent.setLocalOtherPaymentAmt(ec
							.getLocalAppliedAmount());
					checkAgent.setUsdOtherPaymentAmt(ec.getUsdAppliedAmount());
					iterSummary.remove();
					firstTime = false;
				}
				else
				{
					checkAgent.setTotalLocalExpectedAmount(checkAgent
							.getTotalLocalExpectedAmount()
							+ ec.getLocalExpectedAmount());
					checkAgent.setTotalLocalAppliedAmount(checkAgent
							.getTotalLocalAppliedAmount()
							+ ec.getLocalAppliedAmount());
					checkAgent.setTotalUsdExpectedAmount(checkAgent
							.getTotalUsdExpectedAmount()
							+ ec.getUsdExpectedAmount());
					checkAgent.setTotalUsdAppliedAmount(checkAgent
							.getTotalUsdAppliedAmount()
							+ ec.getUsdAppliedAmount());
					checkAgent.setTotalLocalExpectedAmount_COD(checkAgent
							.getTotalLocalExpectedAmount_COD()
							+ ec.getLocalExpectedAmount_COD());
					checkAgent.setTotalLocalAppliedAmount_COD(checkAgent
							.getTotalLocalAppliedAmount_COD()
							+ ec.getLocalAppliedAmount_COD());
					checkAgent.setTotalUsdExpectedAmount_COD(checkAgent
							.getTotalUsdExpectedAmount_COD()
							+ ec.getUsdExpectedAmount_COD());
					checkAgent.setTotalUsdAppliedAmount_COD(checkAgent
							.getTotalUsdAppliedAmount_COD()
							+ ec.getUsdAppliedAmount_COD());
					checkAgent.setTotalLocalExpectedAmount_FTC(checkAgent
							.getTotalLocalExpectedAmount_FTC()
							+ ec.getLocalExpectedAmount_FTC());
					checkAgent.setTotalLocalAppliedAmount_FTC(checkAgent
							.getTotalLocalAppliedAmount_FTC()
							+ ec.getLocalAppliedAmount_FTC());
					checkAgent.setTotalUsdExpectedAmount_FTC(checkAgent
							.getTotalUsdExpectedAmount_FTC()
							+ ec.getUsdExpectedAmount_FTC());
					checkAgent.setTotalUsdAppliedAmount_FTC(checkAgent
							.getTotalUsdAppliedAmount_FTC()
							+ ec.getUsdAppliedAmount_FTC());
					checkAgent.setTotalPrepaidLocal(checkAgent
							.getTotalPrepaidLocal()
							+ ec.getPrepaidLocalAmount());
					checkAgent.setTotalPrepaidUsd(checkAgent
							.getTotalPrepaidUsd() + ec.getPrepaidUsdAmount());
					checkAgent.setTotalPoaLocal(checkAgent.getTotalPoaLocal()
							+ ec.getPoaLocalAmount());
					checkAgent.setTotalPoaUsd(checkAgent.getTotalPoaUsd()
							+ ec.getPoaUsdAmount());
					checkAgent.setTotalGroundLocal(checkAgent
							.getTotalGroundLocal() + ec.getGroundLocalAmount());
					checkAgent.setTotalGroundUsd(checkAgent.getTotalGroundUsd()
							+ ec.getGroundUsdAmount());
				}
			}
			checkAgent.setEmployeeSummaries(listSummary);
			/* Start- For Mcd End for Checkin Agent Summary page */
			try
			{
				MCD.processEvent("server",
						"GCCS",
						"CheckInAgentCashRecapAction",
						// AppUtils.getHostname(),
						AppInit.getHostname(), null, "IP",
						"CheckInAgentSummaryScreen", null, null,
						System.currentTimeMillis() - startTime, null);
			}
			catch (Exception e)
			{
				// AppLogger.error("McD exception while processing GCCS.CheckinAgentSummary",
				// e) ;
				System.out
						.println("McD Exception while processing GCCS.CheckinAgentSummary");
				e.printStackTrace();
			}
			/* End- For Mcd End for Checkin Agent Summary page */
			if ("sortTable".equals(request.getParameter("action")))
			{
				sortTable(checkAgent, request);
			}
			request.setAttribute("CheckInAgentCashRecapForm", checkAgent);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		if (!"ProcessEndDay".equals(request.getParameter("action")))
		{
			// save token
			saveToken(request);
		}
		return mapping.findForward("Success");
	}

	/**
	 * This methods is executed when the user select the Process End of Day
	 * option of the Summary Screen.
	 * 
	 * @param mapping
	 *            action mapping object
	 * @param form
	 *            action form object
	 * @param request
	 *            request object
	 * @param response
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward processEndDay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		try
		{
			if (isTokenValid(request))
			{
				resetToken(request);
				CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
				EmployeeProfile ep = (EmployeeProfile) request.getSession()
						.getAttribute("userProfile");
				CheckInAgentCashRecapForm checkAgent = (CheckInAgentCashRecapForm) form;
				// check if all the couriers are closed or selected to be closed
				Iterator iterSummary = checkAgent.getEmployeeSummaries()
						.iterator();
				boolean haveToClose = false;
				while (iterSummary.hasNext())
				{
					ExpressCheckinTableVO ec = (ExpressCheckinTableVO) iterSummary
							.next();
					if (!ec.isClosed() && !ec.isCloseCourier())
					{
						ActionErrors ae = new ActionErrors();
						ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
								"errors.messages.ThereAreNotClosedCouriers"));
						saveErrors(request, ae);
						return show(mapping, form, request, response);
					}
					if (ec.isCloseCourier()) haveToClose = true;
				}
				// if some couriers must be closed go to closeCourier() method.
				if (haveToClose) closeCourier(mapping, form, request, response);
				long startTime = System.currentTimeMillis();
				try
				{
					System.out.println("Mcd In process End Of Day");
					// Beginning of request. Inform McD
					MCD.processEvent("server", "GCCS",
							"CheckInAgentCashRecapAction",
							// AppUtils.getHostname(),
							AppInit.getHostname(), null, "OR", "processEndDay",
							null, null, -1, null);
				}
				catch (Exception e)
				{
					// AppLogger.error("McD Exception while processing GCCS.processEOD",
					// e) ;
					System.out
							.println("McD Exception while processing GCCS.processEOD");
					e.printStackTrace();
				}
				// Process the End of the Day
				int eodId = bizComm.processEndOfDay(ep.getLocationCd(),
						ep.getEmployeeId());
				try
				{
					MCD.processEvent("server",
							"GCCS",
							"CheckInAgentCashRecapAction",
							// AppUtils.getHostname(),
							AppInit.getHostname(), null, "IP", "processEndDay",
							null, null, System.currentTimeMillis() - startTime,
							null);
				}
				catch (Exception e)
				{
					// AppLogger.error("McD exception while processing GCCS.processEOD",
					// e) ;
					System.out
							.println("McD Exception while processing GCCS.processEOD");
					e.printStackTrace();
				}
				if (eodId == -1)
				{
					// eodId=-1 indicates the system could not end the day
					// because of the non-closed couriers
					ActionErrors ae = new ActionErrors();
					ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
							"errors.messages.ThereAreNotClosedCouriers"));
					saveErrors(request, ae);
				}
				else
				{
					if (eodId > 0)
					{
						// if the day was successfully closed, create the
						// Data Feed Out file.
						PaymentReceiveDataFeed outXMLGen = new PaymentReceiveDataFeed(
								getServlet().getServletContext());
						if (!outXMLGen.getDataToXmlFile(
								new java.sql.Date(Utils.changeDateToTZ(
										new java.util.Date(),
										ep.getLocationTimeZone()).getTime()),
								ep.getLocationCd(), eodId))
						{
							ActionErrors ae = new ActionErrors();
							ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
									"errors.messages.ErrorGeneratingXML"));
							saveErrors(request, ae);
						}
					}
				}
				removeRefreshLocation(ep.getLocationCd());
			}
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		request.setAttribute("ProcessEndDay", "yes");
		return show(mapping, form, request, response);
	}

	/**
	 * This methods is executed when the user select the Show Multiple Invoices
	 * option of the Summary Screen.
	 * 
	 * @param mapping
	 *            action mapping object
	 * @param form
	 *            action form object
	 * @param request
	 *            request object
	 * @param response
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward showMultipleInvoices(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		try
		{
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			CheckInAgentCashRecapForm frm = (CheckInAgentCashRecapForm) form;
			frm.setNewReassLocationCd(ep.getLocationCd());
			Collection paymentTypes = new PaymentTypeController()
					.getPaymentTypeByPoaLocation(ep.getLocationCd()); // we use
																		// POA
																		// because
																		// it
																		// has
																		// all
																		// the
																		// payment
																		// types
			frm.setRodPymtTypes(paymentTypes);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		return mapping.findForward("MultiInvoices");
	}

	/**
	 * This methods is executed when the user select the Save Multiple Invoices
	 * option of the Summary Screen.
	 * 
	 * @param mapping
	 *            action mapping object
	 * @param form
	 *            action form object
	 * @param request
	 *            request object
	 * @param response
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward saveMultipleInvoices(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		long startTime = System.currentTimeMillis();
		try
		{
			RODBizDelegate biz = new RODBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			CheckInAgentCashRecapForm frm = (CheckInAgentCashRecapForm) form;
			Collection colAwbsInvEnt = frm.getAwbInv();
			Collection colAwbsInv = new ArrayList();
			Iterator iterAwbsInv = colAwbsInvEnt.iterator();
			while (iterAwbsInv.hasNext())
			{
				Entry awbInv = (Entry) iterAwbsInv.next();
				if (awbInv != null && awbInv.getValue() != null
						&& !"".equals(awbInv.getValue().toString()))
				{
					colAwbsInv.add(awbInv.getValue().toString());
				}
			}
			try
			{
				// Beginning of request. Inform McD
				MCD.processEvent("server", "GCCS",
						"CheckInAgentCashRecapAction",
						// AppUtils.getHostname(),
						AppInit.getHostname(), null, "OR",
						"applyPaymentToInvoices", null, null, -1, null);
			}
			catch (Exception e)
			{
				// AppLogger.error("McD Exception while processing GCCS.applyPaymentToInvoices",
				// e) ;
				System.out
						.println("McD Exception while processing GCCS.applyPaymentToInvoices");
				e.printStackTrace();
			}
			Collection notFound = biz.applyPaymentToInvoices(
					frm.getNewEmployeeId(), frm.getNewReassLocationCd(),
					ep.getCountryCd(), frm.getCurrencyCd(),
					frm.getPaymentType(), frm.getDocNbr(),
					(frm.getPaymentType() == 5), frm.isFindByAwb(), colAwbsInv);
			Iterator iterNF = notFound.iterator();
			ActionErrors ae = new ActionErrors();
			while (iterNF.hasNext())
			{
				String nf = (String) iterNF.next();
				ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
						"errors.messages.InvAwbNotFound", nf));
			}
			saveErrors(request, ae);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		try
		{
			MCD.processEvent("server", "GCCS",
					"CheckInAgentCashRecapAction",
					// AppUtils.getHostname(),
					AppInit.getHostname(), null, "IP",
					"applyPaymentToInvoices", null, null,
					System.currentTimeMillis() - startTime, null);
		}
		catch (Exception e)
		{
			// AppLogger.error("McD exception while processing GCCS.applyPaymentToInvoices",
			// e) ;
			System.out
					.println("McD Exception while processing GCCS.applyPaymentToInvoices");
			e.printStackTrace();
		}
		return showMultipleInvoices(mapping, form, request, response);
	}

	/**
	 * This methods is executed when the user select the Quick Clear Button
	 * 
	 * @param mapping
	 *            action mapping object
	 * @param form
	 *            action form object
	 * @param request
	 *            request object
	 * @param response
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward quickClear(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		try
		{
			CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			// Clear PUX and DEX
			bizComm.quickClear(ep.getLocationCd());
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		return show(mapping, form, request, response);
	}

	/**
	 * This methods is executed when the user select the Quick Collect Laters
	 * option of the Summary Screen.
	 * 
	 * @param Struts
	 *            action mapping object
	 * @param Struts
	 *            action form object
	 * @param http
	 *            request object
	 * @param http
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward quickCollectLaters(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		try
		{
			CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			// Reopen the End of the Day
			bizComm.quickCollectLaters(ep.getLocationCd());
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		return show(mapping, form, request, response);
	}

	/**
	 * This methods is executed when the user select the Reopen End of Day
	 * option of the Summary Screen.
	 * 
	 * @param Struts
	 *            action mapping object
	 * @param Struts
	 *            action form object
	 * @param http
	 *            request object
	 * @param http
	 *            response object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private ActionForward reopenEndDay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		try
		{
			CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			// Reopen the End of the Day
			int result = bizComm.openEndOfDay(ep.getLocationCd(),
					ep.getEmployeeId(),
					Integer.parseInt(request.getParameter("reopenDeposits")));
			if (result == 0)
			{
				ActionErrors ae = new ActionErrors();
				ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
						"app.messages.CouldNotReopenLastEOD"));
				saveErrors(request, ae);
			}
			else
			{
				if (result == 2)
				{
					ActionErrors ae = new ActionErrors();
					ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
							"app.messages.NoEODForToday"));
					saveErrors(request, ae);
				}
			}
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		return show(mapping, form, request, response);
	}

	/**
	 * This methods is executed when the user wants to sort the information for
	 * a specified criteria.
	 * 
	 * @param Struts
	 *            action form object
	 * @param http
	 *            request object
	 * @return Struts action forward
	 * @throws Exception
	 */
	private void sortTable(ActionForm form, HttpServletRequest request)
			throws Exception
	{
		CheckInAgentCashRecapForm ccrForm = null;
		if (form == null)
		{
			ccrForm = new CheckInAgentCashRecapForm();
		}
		else
		{
			ccrForm = (CheckInAgentCashRecapForm) form;
		}
		// sorting by descending values
		if ("desc".equals(request.getParameter("SummSortDirection")))
		{
			// sorting by courier name
			if ("employeeNm".equals(request.getParameter("SummSortColumn")))
			{
				Collections.sort(ccrForm.getEmployeeSummaries(),
						new Comparator()
						{
							public int compare(Object obj1, Object obj2)
							{
								ExpressCheckinTableVO ccrVO1 = (ExpressCheckinTableVO) obj1;
								ExpressCheckinTableVO ccrVO2 = (ExpressCheckinTableVO) obj2;
								return ccrVO2
										.getEmployeeName()
										.toLowerCase()
										.compareTo(
												ccrVO1.getEmployeeName()
														.toLowerCase());
							}
						});
			}
			else
			{
				// sorting by courier Id
				Collections.sort(ccrForm.getEmployeeSummaries(),
						new Comparator()
						{
							public int compare(Object obj1, Object obj2)
							{
								ExpressCheckinTableVO ccrVO1 = (ExpressCheckinTableVO) obj1;
								ExpressCheckinTableVO ccrVO2 = (ExpressCheckinTableVO) obj2;
								return (ccrVO2.getEmployeeId().compareTo(ccrVO2
										.getEmployeeId()));
							}
						});
			}
			// sorting by ascending values
		}
		else
		{
			// sorting by courier name
			if ("employeeNm".equals(request.getParameter("SummSortColumn")))
			{
				Collections.sort(ccrForm.getEmployeeSummaries(),
						new Comparator()
						{
							public int compare(Object obj1, Object obj2)
							{
								ExpressCheckinTableVO ccrVO1 = (ExpressCheckinTableVO) obj1;
								ExpressCheckinTableVO ccrVO2 = (ExpressCheckinTableVO) obj2;
								return ccrVO1
										.getEmployeeName()
										.toLowerCase()
										.compareTo(
												ccrVO2.getEmployeeName()
														.toLowerCase());
							}
						});
				// sorting by courier id
			}
			else
			{
				Collections.sort(ccrForm.getEmployeeSummaries(),
						new Comparator()
						{
							public int compare(Object obj1, Object obj2)
							{
								ExpressCheckinTableVO ccrVO1 = (ExpressCheckinTableVO) obj1;
								ExpressCheckinTableVO ccrVO2 = (ExpressCheckinTableVO) obj2;
								return (ccrVO1.getEmployeeId().compareTo(ccrVO2
										.getEmployeeId()));
							}
						});
			}
		}
	}

	private void removeRefreshLocation(String locationCd)
	{
		TreeSet ts = (TreeSet) getServlet().getServletContext().getAttribute(
				"refreshLocations");
		if (ts == null)
		{
			ts = new TreeSet();
		}
		if (ts.contains(locationCd))
		{
			ts.remove(locationCd);
		}
	}

	/**
	 * Method to show payments different to ROD, Prepaid and POA
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	private ActionForward showMorePayments(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		try
		{
			CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
			EmployeeProfile ep = (EmployeeProfile) request.getSession()
					.getAttribute("userProfile");
			CheckInAgentCashRecapForm checkAgent = new CheckInAgentCashRecapForm();
			List listSummary = (List) bizComm.getMorePaymentsSummaryByEmp(ep
					.getLocationCd());
			Iterator iterSummary = listSummary.iterator();
			boolean firstTime = true;
			while (iterSummary.hasNext())
			{
				ExpressCheckinTableVO ec = (ExpressCheckinTableVO) iterSummary
						.next();
				// this if manage the first object in the collection containing
				// the totals for Other Payments
				if (firstTime && "XXXXXX".equals(ec.getEmployeeId()))
				{
					checkAgent.setLocalOtherPaymentAmt(ec
							.getLocalAppliedAmount());
					checkAgent.setUsdOtherPaymentAmt(ec.getUsdAppliedAmount());
					iterSummary.remove();
					firstTime = false;
				}
				else
				{
					checkAgent.setTotalGroundLocal(checkAgent
							.getTotalGroundLocal() + ec.getGroundLocalAmount());
					checkAgent.setTotalGroundUsd(checkAgent.getTotalGroundUsd()
							+ ec.getGroundUsdAmount());
				}
			}
			checkAgent.setEmployeeSummaries(listSummary);
			if ("sortTable".equals(request.getParameter("action")))
			{
				sortTable(checkAgent, request);
			}
			request.setAttribute("CheckInAgentCashRecapForm", checkAgent);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.messages.CouldNotGetDataFromDB"));
			saveErrors(request, ae);
		}
		return mapping.findForward("MorePayments");
	}
}