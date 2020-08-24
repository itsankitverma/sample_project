package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.common.BaseTest;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.BankVO;

public class BankControllerTest extends BaseTest {
	
	BankController bankController = new BankController();
	
	BankVO bankVO = null;
	
	public void setVO() {
		bankVO = new BankVO();
		bankVO.setBankCd("279");
		//bankVO.setBankId(454);
		bankVO.setBankNm("Citibank");
		bankVO.setBankShtDesc("CHHB");
		bankVO.setCountryCd("TW");
	}
	
	@Test
	public void testSetBank() throws BusinessDelegateException{
		setVO();
		bankController.setBank(bankVO);
	}

	@Test
	public void testGetBank() throws BusinessDelegateException{
		int bankId = 451;
		bankController.getBank(bankId);
	}
	
	@Test
	public void testGetBankAccs() throws BusinessDelegateException{
		int bankId = 451;
		bankController.getBankAccs(bankId);
	}
	
	@Test
	public void testGetAllBanks() throws BusinessDelegateException{
		bankController.getAllBanks();
	}
	
	@Test
	public void testGetBankByCountryCd() throws BusinessDelegateException{
		String countryCd = "BR";
		bankController.getBankByCountryCd(countryCd);
	}
	
	@Test
	public void testUpdateBank() throws BusinessDelegateException{
		setVO();
		bankVO.setBankId(451);
		bankController.updateBank(bankVO);
	}
	
	/*
	@Test
	public void testRemoveBank() throws BusinessDelegateException{
		int bankId = 454;
		bankController.removeBank(bankId);
	}*/
	
	
}
