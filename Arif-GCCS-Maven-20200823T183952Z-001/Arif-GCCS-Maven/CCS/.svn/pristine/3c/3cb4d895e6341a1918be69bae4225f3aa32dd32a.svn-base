package com.fedex.lacitd.cashcontrol.prestier.tag;

import javax.servlet.jsp.JspException;

import org.apache.struts.util.ResponseUtils;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.taglib.html.BaseHandlerTag;
import org.apache.struts.taglib.html.Constants;

/**
 * Tag used to generate a calendar control.
 *
 * @author Pablo Aravena
 * @version 1.0
 */

public class CalendarTag extends BaseHandlerTag {
    private String name = null;
    private String property = null;
    private StringBuffer results = null;
    private String srcKey = null;
	private String format = null;
	private String srcIcon = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getSrcKey() {
        return srcKey;
    }

    public void setSrcKey(String srcKey) {
        this.srcKey = srcKey;
    }

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSrcIcon() {
		return this.srcIcon;
	}

	public void setSrcIcon(String srcIcon) {
		this.srcIcon = srcIcon;
	}

    public int doEndTag() throws JspException {
        if(name == null) name = Constants.BEAN_KEY;
        if(srcKey == null) srcKey = "image.icon.calendar";
		if(format == null) format="%d-%m-%Y";
        results = new StringBuffer();
        Object value = RequestUtils.lookup(pageContext, name, property, "request");
		if(value == null) value = new String("");
com.fedex.lacitd.cashcontrol.biztier.common.Constants.logger.debug(srcIcon);
        String srcCalendarIcon = null;
		if(srcIcon != null){
			srcCalendarIcon = srcIcon;
        }else{
            srcCalendarIcon = RequestUtils.message(pageContext, getBundle(), getLocale(), this.srcKey);
        }
com.fedex.lacitd.cashcontrol.biztier.common.Constants.logger.debug(srcIcon);

		results.append("<input type=\"text\" name=\""+ property + "\" id=\""+property+"\" value=\""+value+"\" maxlength=\"10\" size=\"12\">");
        results.append("&nbsp;<a href=\"#\"><img id=\"trigger"+property+"\" src=\""+srcCalendarIcon+"\" border=\"0\"/></a>");
		results.append("<script type=\"text/javascript\">\n");
		results.append("Calendar.setup({\n");
		results.append("inputField     :    \""+property+"\",\n");
        results.append("ifFormat       :    \""+format+"\",\n");      
        results.append("button         :    \"trigger"+property+"\",\n");  
        results.append("align          :    \"Bl\",\n");
        results.append("singleClick    :    true\n");
		results.append("});</script>");
		ResponseUtils.write(pageContext, results.toString());
        return EVAL_PAGE;
    }

    public void release() {
        super.release();
        this.name = null;
        this.property = null;
        this.results = null;
        this.srcKey = null;
    }
}
