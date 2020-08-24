package com.fedex.lacitd.cashcontrol.prestier.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bea.httppubsub.util.*;
import com.maverick.util.Base64.InputStream;

import java.io.FileInputStream;
import java.util.*;

public class PrepNotCheckedScanProcTest {
	
	PrepNotCheckedScanProc prep = new PrepNotCheckedScanProc();
	@Test
	public void TestprocessLastScans() throws Exception{
		
		ArrayList<String> colErrors = new ArrayList<String>();
		colErrors.add("1");
		colErrors.add("2");
		
		ArrayList<String> colErrors2 = new ArrayList<String>();
		colErrors2.add("1");
		colErrors2.add("2");
		
		prep.processLastScans(colErrors,colErrors2);

	}

}
