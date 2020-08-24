package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BankAccException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.BankAccVO;

public class BankAccManagerTest {
	BankAccManagerBean bankAccManager = new BankAccManagerBean();
	BankAccVO bankAccVO = null;
	
	private void setVO() {
		System.out.println("set initiated");
		bankAccVO = new BankAccVO();
		bankAccVO.setAccountNbr("0402021619300163526");
		bankAccVO.setBankAccountCd(332);
		bankAccVO.setBankBranchId("Shijiazhuang Gaoxin");
		bankAccVO.setBankId(429);
		bankAccVO.setCurrencyType("CNY");
		bankAccVO.setOriginationNbr(null);	
	}
	
	@Test
	public void testSetBankAcc() throws BankAccException{
		setVO();
		bankAccManager.setBankAcc(bankAccVO);
	}
	
	@Test
	public void testGetBankAcc() throws BankAccException, FinderException{
		int bankAccountCd = 332;
		bankAccManager.getBankAcc(bankAccountCd);
	}
	
	@Test
	public void testGetDepositSlips() throws BankAccException{
		int bankAccountCd = 332;
		bankAccManager.getDepositSlips(bankAccountCd);
	}
	
	@Test
	public void testAddLocation() throws BankAccException{
		int bankAccountCd = 332;
		String locationCd = "BOMA";
		bankAccManager.addLocation(bankAccountCd, locationCd );
	}
	
	@Test
	public void testRemoveLocation() throws BankAccException{
		int bankAccountCd = 332;
		String locationCd = "BOMA";
		bankAccManager.removeLocation(bankAccountCd, locationCd);
	}
	
	@Test
	public void testGetLocations() throws BankAccException{
		int bankAccountCd = 332;
		bankAccManager.getLocations(bankAccountCd);
	}
	
	@Test
	public void testGetAllBankAccs() throws BankAccException{
		bankAccManager.getAllBankAccs();
	}
	
	@Test
	public void testGetBankAccByBankId() throws BankAccException{
		int bankId = 429;
		bankAccManager.getBankAccByBankId(bankId);
	}
	
	@Test
	public void testRemoveBankAcc() throws BankAccException, RemoveException{
		int bankAccountCd = 332;
		bankAccManager.removeBankAcc(bankAccountCd);
	}	
	
	@Test
	public void testUpdateBankAcc() throws BankAccException{
		setVO();
		bankAccManager.updateBankAcc(bankAccVO);
	}
	
}
