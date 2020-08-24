/**
 * InCageExceptionsRunnable.java
 *
 * Created on 20 de diciembre de 2002, 16:02
 */
package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CODBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.RODBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;

import com.fedex.common.j2ee.mcd.MCD;

/**
 * 
 * @author ccardenas
 */
public class InCageExceptionsRunnable implements java.io.Serializable,
		java.lang.Runnable
{
	/** Holds value of property thread. */
	private java.lang.Thread thread;

	/** Creates a new instance of InCageExceptionsRunnable */
	public InCageExceptionsRunnable()
	{
	}

	/**
	 * This methods is started in his own thread. This code is running all the
	 * time monitoring if the task to collect In Cage exceptions has to be run
	 * in any location.
	 */
	public void run()
	{
		while (!"STOP_THREAD".equals(thread.getName()))
		{
			rodInCageExceptions();
			codInCageExceptions();
		}
	}

	/**
	 * In-cage Exceptions for ROD
	 */
	private void rodInCageExceptions()
	{
		try
		{
			// find stat44 and run scans for them
			findNewStat44Scans();
			AppInit.startMcd();
			/* Start- For Mcd start */
			long startTime = System.currentTimeMillis();
			try
			{
				System.out.println("Mcd in InCageExceptiondRunnable");
				// Beginning of request. Inform McD
				MCD.processEvent("server", "GCCS", "InCageExceptiondRunnable",
						AppInit.getHostname(), null, "OR",
						"runInCageExceptionsTask", null, null, -1, null);
			}
			catch (Exception e)
			{
				System.out
						.println("McD Exception while processing GCCS.runInCageExceptionsTask");
				e.printStackTrace();
			}
			// collect the exceptions produced in the ops
			new RODBizDelegate().runInCageExceptionsTask();
			/* Start- For Mcd End */
			try
			{
				MCD.processEvent("server", "GCCS",
						"InCageExceptiondRunnable",
						// AppUtils.getHostname(),
						AppInit.getHostname(), null, "IP",
						"runInCageExceptionsTask", null, null,
						System.currentTimeMillis() - startTime, null);
			}
			catch (Exception e)
			{
				System.out
						.println("McD Exception while processing GCCS.runInCageExceptionsTask");
				e.printStackTrace();
			}
			/* End- For Mcd End */
			Thread.sleep(Constants.InCageExceptionsTaskInterval);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			try
			{
				Thread.sleep(Constants.InCageExceptionsTaskInterval);
			}
			catch (Exception e2)
			{
			}
		}
	}

	/**
	 * Incage Exceptions for COD
	 */
	private void codInCageExceptions()
	{
		try
		{
			// find stat44 and run scans for them
			findNewCODStat44Scans();
			AppInit.startMcd();
			/* Start- For Mcd start */
			long startTime = System.currentTimeMillis();
			try
			{
				System.out.println("Mcd in InCageExceptiondRunnable");
				// Beginning of request. Inform McD
				MCD.processEvent("server", "GCCS", "InCageExceptiondRunnable",
						AppInit.getHostname(), null, "OR",
						"runInCageExceptionsTask", null, null, -1, null);
			}
			catch (Exception e)
			{
				System.out
						.println("McD Exception while processing GCCS.CODrunInCageExceptionsTask");
				e.printStackTrace();
			}
			// collect the exceptions produced in the ops
			new CODBizDelegate().runInCageExceptionsTask(); // RODBizDelegate().runInCageExceptionsTask();
			/* Start- For Mcd End */
			try
			{
				MCD.processEvent("server", "GCCS",
						"InCageExceptiondRunnable",
						// AppUtils.getHostname(),
						AppInit.getHostname(), null, "IP",
						"runInCageExceptionsTask", null, null,
						System.currentTimeMillis() - startTime, null);
			}
			catch (Exception e)
			{
				System.out
						.println("McD Exception while processing COD GCCS.runInCageExceptionsTask");
				e.printStackTrace();
			}
			/* End- For Mcd End */
			Thread.sleep(Constants.InCageExceptionsTaskInterval);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
			try
			{
				Thread.sleep(Constants.InCageExceptionsTaskInterval);
			}
			catch (Exception e2)
			{
			}
		}
	}

	/**
	 * This methods get the ROD in cage awbs, processes his scans and save the
	 * updated AWBs.
	 */
	private void findNewStat44Scans()
	{
		try
		{
			RODBizDelegate biz = new RODBizDelegate();
			Collection awbs = biz.getAwbToQuerySTAT44();
			Collection results = Collections
					.synchronizedCollection(new ArrayList());
			RODScanProcessorSTAT44 sp = new RODScanProcessorSTAT44();
			sp.processLastScans(awbs, results);
			biz.saveSTAT44Scans(results);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
		}
	}

	/**
	 * Find the COD In cage AWBS, processes the scans and saves the updated AWBs
	 */
	private void findNewCODStat44Scans()
	{
		try
		{
			CODBizDelegate biz = new CODBizDelegate();
			Collection awbs = biz.getAwbToQuerySTAT44();
			Collection results = Collections
					.synchronizedCollection(new ArrayList());
			CODScanProcessorSTAT44 sp = new CODScanProcessorSTAT44();
			sp.processLastScans(awbs, results);
			biz.saveSTAT44Scans(results);
		}
		catch (Exception e)
		{
			Constants.logger.debug(Utils.stackTraceToString(e));
		}
	}

	/**
	 * Getter for property thread.
	 * 
	 * @return Value of property thread.
	 */
	public java.lang.Thread getThread()
	{
		return this.thread;
	}

	/**
	 * Setter for property thread.
	 * 
	 * @param thread
	 *            New value of property thread.
	 */
	public void setThread(java.lang.Thread thread)
	{
		this.thread = thread;
	}
}
