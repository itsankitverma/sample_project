package com.fedex.lacitd.cashcontrol.datatier.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import weblogic.utils.ParsingException;

import com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeClearingVO;

public class EmployeeClearingControllerTest {

	EmployeeClearingController employeeClearingController = new EmployeeClearingController();
	
	EmployeeClearingVO employeeClearingVO = getVO();
	
	public EmployeeClearingVO getVO(){
		EmployeeClearingVO employeeClearingVO = new EmployeeClearingVO();
		try {
			employeeClearingVO.setEmpClearDt(new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employeeClearingVO.setEmpClearStatus(1);
		employeeClearingVO.setEmployeeId("177209");
		return employeeClearingVO;
	}
	
	@Test
	public void testSetEmployeeClearing() throws BusinessDelegateException {
		employeeClearingController.setEmployeeClearing(employeeClearingVO);
	}
	
	@Test
	public void testGetEmployeeClearing() throws BusinessDelegateException {
		EmployeeClearingPK employeeClearingPK = new EmployeeClearingPK();
		try {
			employeeClearingPK.setEmpClearDt(new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employeeClearingPK.setEmployeeId("177209");
		employeeClearingController.getEmployeeClearing(employeeClearingPK);
	}
	
	@Test
	public void testGetAllEmployeeClearings() throws BusinessDelegateException {
		employeeClearingController.getAllEmployeeClearings();
	}
	
	@Test
	public void testRemoveEmployeeClearing() throws BusinessDelegateException {
		EmployeeClearingPK employeeClearingPK = new EmployeeClearingPK();
		try {
			employeeClearingPK.setEmpClearDt(new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employeeClearingPK.setEmployeeId("177209");
		employeeClearingController.removeEmployeeClearing(employeeClearingPK);
	}
	
	@Test
	public void testUpdateEmployeeClearing() throws BusinessDelegateException {
		employeeClearingController.updateEmployeeClearing(employeeClearingVO);
	}
	
	@Test
	public void testGetEmployeeClearingManager() throws BusinessDelegateException {
		employeeClearingController.getEmployeeClearingManager();
	}
	
}
