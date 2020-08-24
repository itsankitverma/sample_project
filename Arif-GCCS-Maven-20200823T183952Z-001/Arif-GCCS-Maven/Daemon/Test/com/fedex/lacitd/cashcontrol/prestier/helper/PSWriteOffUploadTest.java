package com.fedex.lacitd.cashcontrol.prestier.helper;

import org.junit.Test;
import com.bea.httppubsub.util.*;
import com.maverick.util.Base64.InputStream;

import java.io.FileInputStream;
import java.util.*;

public class PSWriteOffUploadTest {
	
	PSWriteOffUpload ps = new PSWriteOffUpload();
	
	
	@Test
	public void TestuploadJournalEntries(){
		
		ps.uploadJournalEntries();
	}
	
	@Test
	public void TestsendFile(){
		
		ArrayList <String> list = new ArrayList<String>();
		
		ps.sendFile(list);
	}
	
	@Test
	public void TestsendFile2(){
		
		ArrayList <String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		
		ps.sendFile(list);
	}
}
