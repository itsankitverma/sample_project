package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ReceivablesException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO;

public class ReceivablesManagerBeanTest {
	
	ReceivablesManagerBean receivablesManagerBean = new ReceivablesManagerBean();

	ReceivablesVO receivablesVO = getVO();
	
	public ReceivablesVO getVO() {
		ReceivablesVO receivablesVO = new ReceivablesVO();
		receivablesVO.setAwbNbr("798346262366");
		receivablesVO.setRecId(14569365);
		return receivablesVO;
	}
	
	@Test
	public void testSetReceivables() throws BusinessDelegateException, ReceivablesException {
		receivablesManagerBean.setReceivables(receivablesVO);
	}

	@Test
	public void testGetReceivables() throws BusinessDelegateException, FinderException {
		int recId = 14569365;
		receivablesManagerBean.getReceivables(recId);
	}
	
	@Test
	public void testGetAllReceivables() throws BusinessDelegateException {
		receivablesManagerBean.getAllReceivables();
	}
	
	@Test
	public void testGetReceivablesReceivablesByAwbNbr() throws BusinessDelegateException {
		String awbNbr = "798346262366";
		receivablesManagerBean.getReceivablesReceivablesByAwbNbr(awbNbr);
	}
	
	@Test
	public void testGetReceivablesByEodId() throws BusinessDelegateException {
		int eodId = 942194;
		receivablesManagerBean.getReceivablesByEodId(eodId);
	}
	
	@Test
	public void testRemoveReceivables() throws BusinessDelegateException, RemoveException {
		int recId = 14569365;
		receivablesManagerBean.removeReceivables(recId);
	}
	
	@Test
	public void testUpdateReceivables() throws BusinessDelegateException, ReceivablesException {
		ReceivablesVO receivablesVO = new ReceivablesVO();
		receivablesManagerBean.updateReceivables(receivablesVO);
	}
}

