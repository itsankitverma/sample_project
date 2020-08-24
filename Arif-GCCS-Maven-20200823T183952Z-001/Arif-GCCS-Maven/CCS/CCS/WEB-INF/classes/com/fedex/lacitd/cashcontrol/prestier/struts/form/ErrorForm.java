package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.ActionForm;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 25, 2008
 * Time: 9:47:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorForm  extends ActionForm implements java.io.Serializable{

  private String message;

  public  String getMessage()
  {
      return message;
  }

  public void setMessage(String newMessage)
  {
      this.message = newMessage;
  }
}
