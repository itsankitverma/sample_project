package com.fedex.lacitd.cashcontrol.datatier.controller;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.manager.CosmosScanManager;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CosmosScanVO;

public class CosmosScanControllerTest {
	
	CosmosScanController cosmosScanController = new CosmosScanController();
	
	CosmosScanVO cosmosScanVO = getVO();
	
	public CosmosScanVO getVO() {
		CosmosScanVO cosmosScanVO = new CosmosScanVO();
		cosmosScanVO.setAwbNbr("960393618600");
		cosmosScanVO.setCourierId("670504");
		cosmosScanVO.setScanDt(new Date());
		cosmosScanVO.setScanId(14780884);
		cosmosScanVO.setScanLocationCd("YAZA");
		cosmosScanVO.setScanSeqNbr("260378351988");
		cosmosScanVO.setScanType("SIP");
		cosmosScanVO.setTinUniqId(null);
		
		return cosmosScanVO;
	}
	
	@Test
	public void testSetCosmosScan() throws BusinessDelegateException {
		cosmosScanController.setCosmosScan(cosmosScanVO);
	}
	
	@Test
	public void testGetCosmosScan() throws BusinessDelegateException {
		int scanId = 14780884;
		cosmosScanController.getCosmosScan(scanId);
	}
	
	@Test
	public void testGetAllCosmosScans() throws BusinessDelegateException {
		cosmosScanController.getAllCosmosScans();
	}
	
	@Test
	public void testRemoveCosmosScan() throws BusinessDelegateException {
		int scanId = 14780884;
		cosmosScanController.removeCosmosScan(scanId);
	}
	
	@Test
	public void testUpdateCosmosScan() throws BusinessDelegateException {
		cosmosScanController.updateCosmosScan(cosmosScanVO);
	}
	
	@Test
	public void testGetCosmosScanManager() throws BusinessDelegateException {
		cosmosScanController.getCosmosScanManager();
	}
	
}
