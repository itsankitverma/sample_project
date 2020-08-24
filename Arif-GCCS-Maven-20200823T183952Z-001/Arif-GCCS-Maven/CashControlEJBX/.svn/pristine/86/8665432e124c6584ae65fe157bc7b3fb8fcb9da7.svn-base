package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.TasksVO;

public class TasksControllerTest {
	
	TasksController tasksController = new TasksController();

	TasksVO tasksVO = getVO();
	
	public TasksVO getVO() {
		TasksVO tasksVO = new TasksVO();
		tasksVO.setTasksId(281);
		return tasksVO;
	}
	
	@Test
	public void testSetTasks() throws BusinessDelegateException {
		tasksController.setTasks(tasksVO);
	}
	
	@Test
	public void testGetTasks() throws BusinessDelegateException {
		int tasksId = 281;
		tasksController.getTasks(tasksId);
	}
	
	@Test
	public void testGetAllTasks() throws BusinessDelegateException {
		tasksController.getAllTasks();
	}
	
	@Test
	public void testRemoveTasks() throws BusinessDelegateException {
		int tasksId = 281;
		tasksController.removeTasks(tasksId);
	}
	
	@Test
	public void testUpdateTasks() throws BusinessDelegateException {
		tasksController.updateTasks(tasksVO);
	}
	
	@Test
	public void testGetTasksManager() throws BusinessDelegateException {
		tasksController.getTasksManager();
	}
}
