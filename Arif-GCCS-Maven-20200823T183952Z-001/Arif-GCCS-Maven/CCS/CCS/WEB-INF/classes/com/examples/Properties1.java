package com.examples;
import java.io.*;
import java.util.*;

/**
 *
 * @author  ccardenas
 */
public class Properties1 {



    /**
     * @param args the command line arguments
     */
public static void main(String[] args)throws Exception
{
	Properties prop=new Properties();
	Properties propNew=new Properties();
	prop.load(new  FileInputStream("J:\\CCS\\WEB-INF\\classes\\ApplicationResources_ko.properties"));
	
	System.out.println("app.js.mainMenu"+"="+prop.get("app.mainMenu")+"<br>");
	System.out.println("app.js.messages.AddPrepaidAwb"+"="+prop.get("app.messages.AddPrepaidAwb")+"<br>");
	System.out.println("app.js.messages.AddReceivable"+"="+prop.get("app.messages.AddReceivable")+"<br>");
	System.out.println("app.js.messages.AssignReceivable"+"="+prop.get("app.messages.AssignReceivable")+"<br>");
	System.out.println("app.js.messages.AssignReceivable"+"="+prop.get("app.messages.AssignReceivable")+"<br>");
	System.out.println("app.js.messages.FindReceivable"+"="+prop.get("app.messages.FindReceivable")+"<br>");
	System.out.println("app.js.messages.ListOfReceivables"+"="+prop.get("app.messages.ListOfReceivables")+"<br>");
	System.out.println("app.js.messages.PoaAddPayment"+"="+prop.get("app.messages.PoaAddPayment")+"<br>");
	System.out.println("app.js.messages.PoaSummaryTitle"+"="+prop.get("app.messages.PoaSummaryTitle")+"<br>");
	System.out.println("app.js.messages.RodAddAwb"+"="+prop.get("app.messages.RodAddAwb")+"<br>");
	System.out.println("app.js.messages.ViewAddComment"+"="+prop.get("app.messages.ViewAddComment")+"<br>");
	System.out.println("app.js.messages.ViewAddComment"+"="+prop.get("app.messages.ViewAddComment")+"<br>");
	System.out.println("app.js.PagesTitles.LoginPage"+"="+prop.get("app.PagesTitles.LoginPage")+"<br>");
	System.out.println("app.js.PagesTitles.SelectLocation"+"="+prop.get("app.PagesTitles.SelectLocation")+"<br>");
	System.out.println("app.js.title.AdminCountryCurrency"+"="+prop.get("app.title.AdminCountryCurrency")+"<br>");
	System.out.println("app.js.title.AdminEnterEmployeeId"+"="+prop.get("app.title.AdminEnterEmployeeId")+"<br>");
	System.out.println("app.js.title.Administration"+"="+prop.get("app.title.Administration")+"<br>");
	System.out.println("app.js.title.AdminLocationSetup"+"="+prop.get("app.title.AdminLocationSetup")+"<br>");
	System.out.println("app.js.title.AdminNewEditUser"+"="+prop.get("app.title.AdminNewEditUser")+"<br>");
	System.out.println("app.js.title.AdminNewLocationRole"+"="+prop.get("app.title.AdminNewLocationRole")+"<br>");
	System.out.println("app.js.title.AdminUserListByCountry"+"="+prop.get("app.title.AdminUserListByCountry")+"<br>");
	System.out.println("app.js.title.CashRecapReport"+"="+prop.get("app.title.CashRecapReport")+"<br>");
	System.out.println("app.js.title.ChangePassword"+"="+prop.get("app.title.ChangePassword")+"<br>");
	System.out.println("app.js.title.CheckingAgentCashRecap"+"="+prop.get("app.title.CheckingAgentCashRecap")+"<br>");
	System.out.println("app.js.title.CourierCashRecap"+"="+prop.get("app.title.CourierCashRecap")+"<br>");
	System.out.println("app.js.title.CourierCashRecap"+"="+prop.get("app.title.CourierCashRecap")+"<br>");
	System.out.println("app.js.title.CreditCardPymtGeneration"+"="+prop.get("app.title.CreditCardPymtGeneration")+"<br>");
	System.out.println("app.js.title.CreditPaymentsReport"+"="+prop.get("app.title.CreditPaymentsReport")+"<br>");
	System.out.println("app.js.title.DepositSlipGeneration"+"="+prop.get("app.title.DepositSlipGeneration")+"<br>");
	System.out.println("app.js.title.DepoTemplatesAdmin"+"="+prop.get("app.title.DepoTemplatesAdmin")+"<br>");
	System.out.println("app.js.title.ExceptionReceivablesReport"+"="+prop.get("app.title.ExceptionReceivablesReport")+"<br>");
	System.out.println("app.js.title.ForgotPassword"+"="+prop.get("app.title.ForgotPassword")+"<br>");
	System.out.println("app.js.title.LockedUser"+"="+prop.get("app.title.LockedUser")+"<br>");
	System.out.println("app.js.title.OtherPaymentsReceived"+"="+prop.get("app.title.OtherPaymentsReceived")+"<br>");
	System.out.println("app.js.title.PaymentTypesAdmin"+"="+prop.get("app.title.PaymentTypesAdmin")+"<br>");
	System.out.println("app.js.title.PoaBreakout"+"="+prop.get("app.title.PoaBreakout")+"<br>");
	System.out.println("app.js.title.PoaFindInvoices"+"="+prop.get("app.title.PoaFindInvoices")+"<br>");
	System.out.println("app.js.title.PODNoPaymentReport"+"="+prop.get("app.title.PODNoPaymentReport")+"<br>");
	System.out.println("app.js.title.PrepaidBreakout"+"="+prop.get("app.title.PrepaidBreakout")+"<br>");
	System.out.println("app.js.title.PrepaidDiscrepancies"+"="+prop.get("app.title.PrepaidDiscrepancies")+"<br>");
	System.out.println("app.js.title.ProcessLastCosmosScans"+"="+prop.get("app.title.ProcessLastCosmosScans")+"<br>");
	System.out.println("app.js.title.PymtImportStatus"+"="+prop.get("app.title.PymtImportStatus")+"<br>");
	System.out.println("app.js.title.PymtImportStatus"+"="+prop.get("app.title.PymtImportStatus")+"<br>");
	System.out.println("app.js.title.ReportSelector"+"="+prop.get("app.title.ReportSelector")+"<br>");
	System.out.println("app.js.title.RODBreakout"+"="+prop.get("app.title.RODBreakout")+"<br>");
	System.out.println("app.js.title.RodFilesImpStatus"+"="+prop.get("app.title.RodFilesImpStatus")+"<br>");
	System.out.println("app.js.title.ViewReceivableDetails"+"="+prop.get("app.title.ViewReceivableDetails")+"<br>");
	

}

}