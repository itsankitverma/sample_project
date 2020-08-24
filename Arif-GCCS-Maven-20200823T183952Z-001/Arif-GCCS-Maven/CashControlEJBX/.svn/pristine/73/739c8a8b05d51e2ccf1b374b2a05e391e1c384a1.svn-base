package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.EmployeeClearingException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeClearingVO;
public class EmployeeClearingManagerBeanTest {

	EmployeeClearingManagerBean employeeClearingManagerBean = new EmployeeClearingManagerBean();
	
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
	public void testSetEmployeeClearing() throws BusinessDelegateException, EmployeeClearingException {
		employeeClearingManagerBean.setEmployeeClearing(employeeClearingVO);
	}
	
	@Test
	public void testGetEmployeeClearing() throws BusinessDelegateException, FinderException {
		EmployeeClearingPK employeeClearingPK = new EmployeeClearingPK();
		try {
			employeeClearingPK.setEmpClearDt(new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employeeClearingPK.setEmployeeId("177209");
		employeeClearingManagerBean.getEmployeeClearing(employeeClearingPK);
	}
	
	@Test
	public void testGetAllEmployeeClearings() throws BusinessDelegateException {
		employeeClearingManagerBean.getAllEmployeeClearings();
	}
	
	@Test
	public void testRemoveEmployeeClearing() throws BusinessDelegateException, RemoveException {
		EmployeeClearingPK employeeClearingPK = new EmployeeClearingPK();
		try {
			employeeClearingPK.setEmpClearDt(new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employeeClearingPK.setEmployeeId("177209");
		employeeClearingManagerBean.removeEmployeeClearing(employeeClearingPK);
	}
	
	@Test
	public void testUpdateEmployeeClearing() throws BusinessDelegateException, EmployeeClearingException {
		employeeClearingManagerBean.updateEmployeeClearing(employeeClearingVO);
	}
}
