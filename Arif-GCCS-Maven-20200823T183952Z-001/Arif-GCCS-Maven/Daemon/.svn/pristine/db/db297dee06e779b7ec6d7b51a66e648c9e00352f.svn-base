package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;

public class CODScanProcessorSTAT44 implements Serializable
{
	private Collection threads = new ArrayList();
	private Collection errors = Collections
			.synchronizedCollection(new ArrayList());
	private Collection notProcessed = Collections
			.synchronizedCollection(new ArrayList());
	private Collection results;

	/** Creates a new instance of CODScanProcessor */
	public CODScanProcessorSTAT44()
	{
	}

	public Collection processLastScans(Collection awbs, Collection results)
			throws Exception
	{
		this.results = results;
		ArrayList colAwbs = (ArrayList) awbs;
		int threadsNumber = Constants.threadsNumber;
		if (!colAwbs.isEmpty())
		{
			if (colAwbs.size() < threadsNumber)
			{
				threadsNumber = colAwbs.size();
			}
			int j = colAwbs.size() / threadsNumber;
			int mod = colAwbs.size() % threadsNumber;
			int from = 0;
			int to = 0;
			errors.clear();
			for (int i = 1; i <= threadsNumber; i++)
			{
				CODProcessSTAT44Runnable rq = new CODProcessSTAT44Runnable();
				rq.setErrors(errors);
				rq.setNotProcessed(notProcessed);
				from = to;
				if (i <= mod) to = from + j + 1;
				else
					to = from + j;
				rq.setAwbs(colAwbs.subList(from, to));
				rq.setResults(results);
				Thread trh = new Thread(rq);
				threads.add(trh);
				trh.start();
			}
			boolean stop = false;
			do
			{
				Thread.sleep(1000);
				Iterator iter = threads.iterator();
				boolean running = false;
				while (iter.hasNext())
				{
					Thread aux = (Thread) iter.next();
					if (aux != null && aux.isAlive())
					{
						running = true;
					}
				}
				stop = !running;
			}
			while (!stop);
			if (errors.isEmpty())
			{
				Collection colAllNotProcessed = new ArrayList();
				Iterator iter = notProcessed.iterator();
				while (iter.hasNext())
					colAllNotProcessed.addAll((Collection) iter.next());
				return colAllNotProcessed;
			}
			else
			{
				String errorMessages = "Errors:\n";
				Iterator iter = errors.iterator();
				while (iter.hasNext())
				{
					errorMessages = errorMessages
							+ ((Exception) iter.next()).toString() + "\n";
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
