package com.fedex.lacitd.cashcontrol.prestier.servlets.daemons;

import org.junit.Test;

public class LoadApplicationDaemonsTest {
	
	LoadApplicationDaemons load = new LoadApplicationDaemons();
	
	@Test
	public void destroyTest(){
		
		load.destroy();
	}
	
	
}
