package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.util.Date;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.CosmosScanException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CosmosScanVO;

public class CosmosScanManagerBeanTest {
	
	CosmosScanManagerBean cosmosScanManagerBean = new CosmosScanManagerBean();
	
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
	public void testSetCosmosScan() throws BusinessDelegateException, CosmosScanException {
		cosmosScanManagerBean.setCosmosScan(cosmosScanVO);
	}
	
	@Test
	public void testGetCosmosScan() throws BusinessDelegateException, FinderException {
		int scanId = 14780884;
		cosmosScanManagerBean.getCosmosScan(scanId);
	}
	
	@Test
	public void testGetAllCosmosScans() throws BusinessDelegateException {
		cosmosScanManagerBean.getAllCosmosScans();
	}
	
	@Test
	public void testRemoveCosmosScan() throws BusinessDelegateException, RemoveException {
		int scanId = 14780884;
		cosmosScanManagerBean.removeCosmosScan(scanId);
	}
	
	@Test
	public void testUpdateCosmosScan() throws BusinessDelegateException, CosmosScanException {
		cosmosScanManagerBean.updateCosmosScan(cosmosScanVO);
	}
	
}
