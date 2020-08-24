package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.util.Date;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.DepositSlipException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepositSlipVO;

public class DepositSlipManagerBeanTest {
	
	DepositSlipManagerBean depositSlipManagerBean = new DepositSlipManagerBean();
	
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
	public void testSetDepositSlip() throws BusinessDelegateException, DepositSlipException {
		depositSlipManagerBean.setDepositSlip(depositSlipVO);
	}
	
	@Test
	public void testGetDepositSlip() throws BusinessDelegateException, FinderException {
		int depositSlipCd = 2332165;
		depositSlipManagerBean.getDepositSlip(depositSlipCd);
	}
	
	@Test
	public void testGetAllDepositSlips() throws BusinessDelegateException {
		depositSlipManagerBean.getAllDepositSlips();
	}
	
	@Test
	public void testGetDepositSlipByBankAccountCd() throws BusinessDelegateException {
		int bankAccountCd = 126;
		depositSlipManagerBean.getDepositSlipByBankAccountCd(bankAccountCd);
	}
	
	@Test
	public void testGetDepositSlipByEmployeeId() throws BusinessDelegateException {
		String employeeId = "298550";
		depositSlipManagerBean.getDepositSlipByEmployeeId(employeeId);
	}
	
	@Test
	public void testGetDepositSlipByEodId() throws BusinessDelegateException {
		int eodId = 298550;
		depositSlipManagerBean.getDepositSlipByEodId(eodId);
	}
	
	@Test
	public void testRemoveDepositSlip() throws BusinessDelegateException, RemoveException {
		int depositSlipCd = 2332165;
		depositSlipManagerBean.removeDepositSlip(depositSlipCd);
	}
	
	@Test
	public void testUpdateDepositSlip() throws BusinessDelegateException, DepositSlipException {
		depositSlipManagerBean.updateDepositSlip(depositSlipVO);
	}
}

