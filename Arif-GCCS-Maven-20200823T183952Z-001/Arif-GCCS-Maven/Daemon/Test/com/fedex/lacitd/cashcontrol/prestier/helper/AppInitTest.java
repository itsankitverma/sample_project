package com.fedex.lacitd.cashcontrol.prestier.helper;


import static org.junit.Assert.*;

import org.junit.Test;

public class AppInitTest{
AppInit appInit= new AppInit();

@Test
public void testStartMcd() {

	AppInit.startMcd();
}
@Test
public void getHostnameTest() {
	
	AppInit.getHostname();
}

}