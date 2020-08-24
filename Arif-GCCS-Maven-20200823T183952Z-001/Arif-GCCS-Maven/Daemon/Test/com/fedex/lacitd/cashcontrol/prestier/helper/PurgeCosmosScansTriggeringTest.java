package com.fedex.lacitd.cashcontrol.prestier.helper;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class PurgeCosmosScansTriggeringTest {
	
	PurgeCosmosScansTriggering purge = new PurgeCosmosScansTriggering();
	
	
	@Test
	public void TestschedulePurgeCosmosScans() throws Exception{
		
		purge.schedulePurgeCosmosScans();
		
		
	}

}
