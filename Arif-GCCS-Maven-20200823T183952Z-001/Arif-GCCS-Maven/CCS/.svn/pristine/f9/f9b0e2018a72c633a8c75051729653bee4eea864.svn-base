<%@page contentType="text/html"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="java.sql.*,
                javax.mail.Session,
                javax.mail.internet.InternetAddress,
                javax.mail.Message,
                javax.mail.internet.MimeMessage,
                java.util.Date,
                javax.mail.internet.MimeBodyPart,
                javax.mail.Multipart,
                javax.mail.internet.MimeMultipart,
                javax.mail.Transport" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import="java.util.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.datatier.manager.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.datatier.common.*" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%
if (request.getParameter("address")!=null){
            InitialContext ic = new InitialContext();
            Session session1 = (Session) ic.lookup(Constants.MAILSession);

            InternetAddress internetAddress = InternetAddress.getLocalAddress(session1);

            Message msg = new MimeMessage(session1);

            msg.setFrom(null);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getParameter("address"), false));


            msg.setSubject("aaaaa");
            msg.setSentDate(new Date());

            // Content is stored in a MIME multi-part message
            // with one body part
            MimeBodyPart mbp = new MimeBodyPart();
            if("text/html".equals("text/html"))
                mbp.setContent("aaaa", "text/html");
            else
                mbp.setText("bbbbb");
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);
            msg.setContent(mp);


            //Send the message.
            Transport.send(msg);
}
%>
<form>
<input type="text" name="address" value="cristian.cardenas@fedex.com,cristiancard@hotmail.com">
<input type="submit">
</form>