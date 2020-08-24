package com.fedex.lacitd.cashcontrol.prestier.helper;
import org.junit.Test;
import static org.junit.Assert.*;

public class WriteOffRunnableTest {
	
	WriteOffRunnable wr = new WriteOffRunnable();
	
	
	@Test
	public void getThreadTest(){
		
		wr.getThread();
		
	}
	
	@Test
	public void setThreadTest(){
		
		Thread tr = null;
		
		wr.setThread(tr);
	}
	
	@Test
	public void markWriteOffTest() throws Exception{
		wr.markWriteOff();
		
	}
}
