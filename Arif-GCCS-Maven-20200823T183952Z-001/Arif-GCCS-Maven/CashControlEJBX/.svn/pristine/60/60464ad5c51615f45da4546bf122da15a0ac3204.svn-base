package com.fedex.lacitd.cashcontrol.datatier.controller;

import java.util.Date;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepositSlipVO;

public class DepositSlipControllerTest {
	
	DepositSlipController depositSlipController = new DepositSlipController();
	
	DepositSlipVO depositSlipVO = getVO();
	
	public DepositSlipVO getVO() {
		DepositSlipVO depositSlipVO = new DepositSlipVO();
		depositSlipVO.setActualAmt(100);
		depositSlipVO.setBankAccountCd(126);
		depositSlipVO.setBankDepoDt(new Date());
		depositSlipVO.setCloseDt(new Date());
		depositSlipVO.setComments("test data");
		depositSlipVO.setCurrencyCd("ALL");
		depositSlipVO.setDepoDt(new Date());
		depositSlipVO.setDepositSlipCd(2332165);
		depositSlipVO.setDepositSlipDt(new Date());
		depositSlipVO.setEmployeeId("298550");
		depositSlipVO.setEodId(298550);
		depositSlipVO.setFedexDepositId("100");
		depositSlipVO.setLocationCd("TSJX");
		depositSlipVO.setPymtType(5);
		depositSlipVO.setSrcType(null);
		depositSlipVO.setStatusId(0);
		depositSlipVO.setTemplCd("DPSMISC");
		depositSlipVO.setTemplId(51);
		return depositSlipVO;
	}

	@Test
	public void testSetDepositSlip() throws BusinessDelegateException {
		depositSlipController.setDepositSlip(depositSlipVO);
	}
	
	@Test
	public void testGetDepositSlip() throws BusinessDelegateException {
		int depositSlipCd = 2332165;
		depositSlipController.getDepositSlip(depositSlipCd);
	}
	
	@Test
	public void testGetAllDepositSlips() throws BusinessDelegateException {
		depositSlipController.getAllDepositSlips();
	}
	
	@Test
	public void testGetDepositSlipByBankAccountCd() throws BusinessDelegateException {
		int bankAccountCd = 126;
		depositSlipController.getDepositSlipByBankAccountCd(bankAccountCd);
	}
	
	@Test
	public void testGetDepositSlipByEmployeeId() throws BusinessDelegateException {
		String employeeId = "298550";
		depositSlipController.getDepositSlipByEmployeeId(employeeId);
	}
	
	@Test
	public void testGetDepositSlipByEodId() throws BusinessDelegateException {
		int eodId = 298550;
		depositSlipController.getDepositSlipByEodId(eodId);
	}
	
	@Test
	public void testRemoveDepositSlip() throws BusinessDelegateException {
		int depositSlipCd = 2332165;
		depositSlipController.removeDepositSlip(depositSlipCd);
	}
	
	@Test
	public void testUpdateDepositSlip() throws BusinessDelegateException {
		depositSlipController.updateDepositSlip(depositSlipVO);
	}
	
	@Test
	public void testGetDepositSlipManager() throws BusinessDelegateException {
		depositSlipController.getDepositSlipManager();
	}
}
