package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.common.BaseTest;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.BankAccVO;

public class BankAccControllerTest extends BaseTest {
	BankAccController bankAccController = new BankAccController();
	BankAccVO bankAccVO = null;
	
	public void setVO() {
		try{
			context = getContext();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("set initiated");
		bankAccVO = new BankAccVO();
		bankAccVO.setAccountNbr("0402021619300163526");
		//bankAccVO.setBankAccountCd(332);
		bankAccVO.setBankBranchId("Shijiazhuang Gaoxin");
		bankAccVO.setBankId(429);
		bankAccVO.setCurrencyType("CNY");
		bankAccVO.setOriginationNbr(null);	
	}
	
	@Test
	public void testSetBankAcc() throws BusinessDelegateException{
		setVO();
		bankAccController.setBankAcc(bankAccVO);
		System.out.println("bank account code - "+bankAccVO.getBankAccountCd());
		try{
			super.tearDown();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetBankAcc() throws BusinessDelegateException{
		int bankAccountCd = 2500;
		bankAccController.getBankAcc(bankAccountCd);
	}
	
	@Test
	public void testGetDepositSlips() throws BusinessDelegateException{
		int bankAccountCd = 2500;
		bankAccController.getDepositSlips(bankAccountCd);
	}
	
	@Test
	public void testAddLocation() throws BusinessDelegateException{
		int bankAccountCd = 2500;
		String locationCd = "BOMA";
		bankAccController.addLocation(bankAccountCd, locationCd );
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException{
		int bankAccountCd = 2500;
		bankAccController.getLocations(bankAccountCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException{
		int bankAccountCd = 2500;
		String locationCd = "BOMA";
		bankAccController.removeLocation(bankAccountCd, locationCd);
	}
	
	@Test
	public void testGetAllBankAccs() throws BusinessDelegateException{
		bankAccController.getAllBankAccs();
	}
	
	@Test
	public void testGetBankAccByBankId() throws BusinessDelegateException{
		int bankId = 429;
		bankAccController.getBankAccByBankId(bankId);
	}
	
	@Test
	public void testUpdateBankAcc() throws BusinessDelegateException{
		setVO();
		bankAccVO.setBankAccountCd(2500);
		bankAccController.updateBankAcc(bankAccVO);
	}
	
	/*
	@Test
	public void testRemoveBankAcc() throws BusinessDelegateException{
		int bankAccountCd = 3552;
		bankAccController.removeBankAcc(bankAccountCd);
	}
	*/	
	
	@Test
	public void testGetBankAccManager() throws BusinessDelegateException{
		bankAccController.getBankAccManager();
	}
	
}
