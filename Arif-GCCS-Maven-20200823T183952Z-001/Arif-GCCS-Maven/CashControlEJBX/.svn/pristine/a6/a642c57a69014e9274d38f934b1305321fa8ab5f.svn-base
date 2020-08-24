package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ChkinAgtCommentException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ChkinAgtCommentVO;

public class ChkinAgtCommentManagerBeanTest {

	ChkinAgtCommentManagerBean chkinAgtCommentManagerBean = new ChkinAgtCommentManagerBean();
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
	public void testSetChkinAgtComment() throws ChkinAgtCommentException {
		chkinAgtCommentManagerBean.setChkinAgtComment(chkinAgtCommentVO);
	}

	@Test
	public void testGetChkinAgtComment() throws FinderException {
		Integer commentId = 252;
		chkinAgtCommentManagerBean.getChkinAgtComment(commentId);
	}
	
	@Test
	public void testGetAllChkinAgtComments() throws BusinessDelegateException {
		chkinAgtCommentManagerBean.getAllChkinAgtComments();
	}
	
	@Test
	public void testRemoveChkinAgtComment() throws RemoveException {
		Integer commentId = 252;
		chkinAgtCommentManagerBean.removeChkinAgtComment(commentId);
	}
	
	@Test
	public void testUpdateChkinAgtComment() throws BusinessDelegateException, ChkinAgtCommentException {
		chkinAgtCommentManagerBean.updateChkinAgtComment(chkinAgtCommentVO);
	}

}
