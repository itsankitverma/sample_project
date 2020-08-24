package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO;

public class ReceivablesControllerTest {
	
	ReceivablesController receivablesController = new ReceivablesController();

	ReceivablesVO receivablesVO = getVO();
	
	public ReceivablesVO getVO() {
		ReceivablesVO receivablesVO = new ReceivablesVO();
		receivablesVO.setAwbNbr("798346262366");
		receivablesVO.setRecId(14569365);
		return receivablesVO;
	}
	
	@Test
	public void testSetReceivables() throws BusinessDelegateException {
		receivablesController.setReceivables(receivablesVO);
	}

	@Test
	public void testGetReceivables() throws BusinessDelegateException {
		int recId = 14569365;
		receivablesController.getReceivables(recId);
	}
	
	@Test
	public void testGetAllReceivables() throws BusinessDelegateException {
		receivablesController.getAllReceivables();
	}
	
	@Test
	public void testGetReceivablesReceivablesByAwbNbr() throws BusinessDelegateException {
		String awbNbr = "798346262366";
		receivablesController.getReceivablesReceivablesByAwbNbr(awbNbr);
	}
	
	@Test
	public void testGetReceivablesByEodId() throws BusinessDelegateException {
		int eodId = 942194;
		receivablesController.getReceivablesByEodId(eodId);
	}
	
	@Test
	public void testRemoveReceivables() throws BusinessDelegateException {
		int recId = 14569365;
		receivablesController.removeReceivables(recId);
	}
	
	@Test
	public void testUpdateReceivables() throws BusinessDelegateException {
		ReceivablesVO receivablesVO = new ReceivablesVO();
		receivablesController.updateReceivables(receivablesVO);
	}
	
	@Test
	public void testGetReceivablesManager() throws BusinessDelegateException {
		receivablesController.getReceivablesManager();
	}
}
