package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.TasksLogException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.TasksLogVO;
public class TasksLogManagerBeanTest {

	TasksLogManagerBean tasksLogManagerBean = new TasksLogManagerBean();
	
	TasksLogVO tasksLogVO = getVO();
	
	public TasksLogVO getVO() {
		TasksLogVO tasksLogVO = new TasksLogVO();
		tasksLogVO.setTasksId(381);
		return tasksLogVO;
	}
	
	@Test
	public void testSetTasksLog() throws BusinessDelegateException, TasksLogException {
		tasksLogManagerBean.setTasksLog(tasksLogVO);
	}

	@Test
	public void testGetTasksLog() throws BusinessDelegateException, FinderException {
		int tasksLogId = 381;
		tasksLogManagerBean.getTasksLog(tasksLogId);
	}
	
	@Test
	public void testGetAllTasksLogs() throws BusinessDelegateException {
		tasksLogManagerBean.getAllTasksLogs();
	}
	
	@Test
	public void testRemoveTasksLog() throws BusinessDelegateException, RemoveException {
		int tasksLogId = 381;
		tasksLogManagerBean.removeTasksLog(tasksLogId);
	}
}
