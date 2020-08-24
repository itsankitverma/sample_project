package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.common.BaseTest;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ChkinAgtCommentVO;

public class ChkinAgtCommentControllerTest extends BaseTest {

	ChkinAgtCommentController chkinAgtCommentController = new ChkinAgtCommentController();
	ChkinAgtCommentVO chkinAgtCommentVO = getVO();
	
	public ChkinAgtCommentVO getVO() {
		ChkinAgtCommentVO chkinAgtCommentVO = new ChkinAgtCommentVO();
		chkinAgtCommentVO.setApplyTo("ROD");
		chkinAgtCommentVO.setCommentCd("CBSA");
		chkinAgtCommentVO.setCommentDesc("Canada Border  Services Agency/Seized by Customs");
		chkinAgtCommentVO.setCommentId(252);
		chkinAgtCommentVO.setStatus("0");
		return chkinAgtCommentVO;
	}

	@Test
	public void testSetChkinAgtComment() throws BusinessDelegateException {
		chkinAgtCommentController.setChkinAgtComment(chkinAgtCommentVO);
	}

	@Test
	public void testGetChkinAgtComment() throws BusinessDelegateException {
		Integer commentId = 252;
		chkinAgtCommentController.getChkinAgtComment(commentId);
	}
	
	@Test
	public void testGetAllChkinAgtComments() throws BusinessDelegateException {
		chkinAgtCommentController.getAllChkinAgtComments();
	}
	
	@Test
	public void testUpdateChkinAgtComment() throws BusinessDelegateException {
		chkinAgtCommentController.updateChkinAgtComment(chkinAgtCommentVO);
	}
	
	@Test
	public void testGetChkinAgtCommentManager() throws BusinessDelegateException {
		chkinAgtCommentController.getChkinAgtCommentManager();
	}
	
	@Test
	public void testRemoveChkinAgtComment() throws BusinessDelegateException {
		Integer commentId = 252;
		chkinAgtCommentController.removeChkinAgtComment(commentId);
	}
	
}
