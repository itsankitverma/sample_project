package com.fedex.lacitd.cashcontrol.biztier.mdb;


import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Properties;

/**
 * @author ccardenas
 */
public class RIHMessageListener implements MessageDrivenBean, MessageListener {

    /**
     * This method is called by the JMS provider when it is delivering a JMS message.
     * This method is part of the MessageListener interface.
     *
     * @param message
     */
    public void onMessage(Message message) {

        try {
            Properties prop = Utils.getProperties("P");

            if (message instanceof TextMessage) {
                TextMessage mesg = (TextMessage) message;
                if (mesg.getText().startsWith("Error") || mesg.getText().startsWith("Warn")) {
                    Constants.logger.debug("RIH Request Problem.: " + mesg.getJMSCorrelationID() + " | " + mesg.getText());
                    Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"), "RIH Request Problem.", mesg.getJMSCorrelationID() + " | " + mesg.getText());
                } else {
                    Constants.logger.debug("RIH Request Event.: " + mesg.getJMSCorrelationID() + " | " + mesg.getText());
                }
            }

        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
    }

    /*
     * The following 3 methods are all part of The Message Driven EJB life cycle and are called by an EJB container.
     * Goto Sun's web site for more info about Message Driven Beans and their lifecycle.
     */
    public void setMessageDrivenContext(MessageDrivenContext messageDrivenContext) throws EJBException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void ejbRemove() throws EJBException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void ejbCreate() {
    }
}
