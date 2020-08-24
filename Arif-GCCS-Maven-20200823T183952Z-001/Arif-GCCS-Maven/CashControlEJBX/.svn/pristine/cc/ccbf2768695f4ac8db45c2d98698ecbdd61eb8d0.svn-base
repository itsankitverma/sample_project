package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BankException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.BankVO;

public class BankManagerBeanTest {
	
	BankManagerBean bankManagerBean = new BankManagerBean();
	
	BankVO bankVO = null;
	
	public void setVO() {
		bankVO = new BankVO();
		bankVO.setBankCd("279");
		bankVO.setBankId(454);
		bankVO.setBankNm("Citibank");
		bankVO.setBankShtDesc("CHHB");
		bankVO.setCountryCd("TW");
	}
	
	@Test
	public void testSetBank() throws BankException{
		setVO();
		bankManagerBean.setBank(bankVO);
	}

	@Test
	public void testGetBank() throws BankException, FinderException{
		int bankId = 454;
		bankManagerBean.getBank(bankId);
	}
	
	@Test
	public void testGetBankAccs() throws BankException{
		int bankId = 454;
		bankManagerBean.getBankAccs(bankId);
	}
	
	@Test
	public void testGetAllBanks() throws BankException{
		bankManagerBean.getAllBanks();
	}
	
	@Test
	public void testGetBankByCountryCd() throws BankException{
		String countryCd = null;
		bankManagerBean.getBankByCountryCd(countryCd);
	}
	
	@Test
	public void testRemoveBank() throws BankException, RemoveException{
		int bankId = 454;
		bankManagerBean.removeBank(bankId);
	}	
	
	@Test
	public void testUpdateBank() throws BankException{
		setVO();
		bankManagerBean.updateBank(bankVO);
	}
	
	
}
