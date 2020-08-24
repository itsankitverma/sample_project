package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.RecExpSrchgException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RecExpSrchgVO;
public class RecExpSrchgManagerBeanTest {
	
	RecExpSrchgManagerBean recExpSrchgManagerBean = new RecExpSrchgManagerBean();

	RecExpSrchgVO recExpSrchgVO = getVO();
	
	public RecExpSrchgVO getVO() {
		RecExpSrchgVO recExpSrchgVO = new RecExpSrchgVO();
		recExpSrchgVO.setRecId(14660836);
		recExpSrchgVO.setAppliedAmt(300);
		recExpSrchgVO.setSurchargeCd("SERVTAX");
		return recExpSrchgVO;
	}
	
	@Test
	public void testSetRecExpSrchg() throws BusinessDelegateException, RecExpSrchgException {
		recExpSrchgManagerBean.setRecExpSrchg(recExpSrchgVO);
	}
	
	@Test
	public void testGetRecExpSrchg() throws BusinessDelegateException, FinderException {
		com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK = new RecExpSrchgPK();
		recExpSrchgPK.setRecId(14660836);
		recExpSrchgPK.setSurchargeCd("SERVTAX");
		recExpSrchgManagerBean.getRecExpSrchg(recExpSrchgPK);
	}
	
	@Test
	public void testGetAllRecExpSrchgs() throws BusinessDelegateException {
		recExpSrchgManagerBean.getAllRecExpSrchgs();
	}
	
	@Test
	public void testGetRecExpSrchgByReceivable() throws BusinessDelegateException {
		int recId = 14660836;
		recExpSrchgManagerBean.getRecExpSrchgByReceivable(recId);
	}
	
	@Test
	public void testRemoveRecExpSrchg() throws BusinessDelegateException, RemoveException {
		RecExpSrchgPK recExpSrchgPK = new RecExpSrchgPK();
		recExpSrchgPK.setRecId(14660836);
		recExpSrchgPK.setSurchargeCd("SERVTAX");
		recExpSrchgManagerBean.removeRecExpSrchg(recExpSrchgPK);
	}
	
	@Test
	public void testUpdateRecExpSrchg() throws BusinessDelegateException, RecExpSrchgException {
		recExpSrchgManagerBean.updateRecExpSrchg(recExpSrchgVO);
	}
}
