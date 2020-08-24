package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.TasksException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.TasksVO;

public class TasksManagerBeanTest {
	
	TasksManagerBean tasksManagerBean = new TasksManagerBean();

	TasksVO tasksVO = getVO();
	
	public TasksVO getVO() {
		TasksVO tasksVO = new TasksVO();
		tasksVO.setTasksId(281);
		return tasksVO;
	}
	
	@Test
	public void testSetTasks() throws BusinessDelegateException, TasksException {
		tasksManagerBean.setTasks(tasksVO);
	}
	
	@Test
	public void testGetTasks() throws BusinessDelegateException, FinderException {
		int tasksId = 281;
		tasksManagerBean.getTasks(tasksId);
	}
	
	@Test
	public void testGetAllTasks() throws BusinessDelegateException {
		tasksManagerBean.getAllTasks();
	}
	
	@Test
	public void testRemoveTasks() throws BusinessDelegateException, RemoveException {
		int tasksId = 281;
		tasksManagerBean.removeTasks(tasksId);
	}
	
	@Test
	public void testUpdateTasks() throws BusinessDelegateException, TasksException {
		tasksManagerBean.updateTasks(tasksVO);
	}
}
