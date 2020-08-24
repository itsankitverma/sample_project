package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.TasksLogVO;

public class TasksLogControllerTest {

	TasksLogController tasksLogController = new TasksLogController();
	
	TasksLogVO tasksLogVO = getVO();
	
	public TasksLogVO getVO() {
		TasksLogVO tasksLogVO = new TasksLogVO();
		tasksLogVO.setTasksId(381);
		return tasksLogVO;
	}
	
	@Test
	public void testSetTasksLog() throws BusinessDelegateException {
		tasksLogController.setTasksLog(tasksLogVO);
	}

	@Test
	public void testGetTasksLog() throws BusinessDelegateException {
		int tasksLogId = 381;
		tasksLogController.getTasksLog(tasksLogId);
	}
	
	@Test
	public void testGetAllTasksLogs() throws BusinessDelegateException {
		tasksLogController.getAllTasksLogs();
	}
	
	@Test
	public void testRemoveTasksLog() throws BusinessDelegateException {
		int tasksLogId = 381;
		tasksLogController.removeTasksLog(tasksLogId);
	}
	
	@Test
	public void testUpdateTasksLog() throws BusinessDelegateException {
		tasksLogController.updateTasksLog(tasksLogVO);
	}
}
