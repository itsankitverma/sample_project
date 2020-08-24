package com.fedex.lacitd.cashcontrol.prestier.tag;

/**
 * Created by IntelliJ IDEA.
 * User: paravena
 * Date: 31-may-2005
 * Time: 14:17:13
 * To change this template use File | Settings | File Templates.
 */
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.strutsel.taglib.utils.EvalHelper;
import org.apache.struts.util.ResponseUtils;
import org.apache.oro.text.perl.Perl5Util;

import java.util.Hashtable;

/**
 * Tag used to generate a Nav bar
 *
 * @author Pablo Aravena
 * @version 1.0
 */

public class PagingTag extends BodyTagSupport {
    private String varStatus;
    private String numberOfPages;
    private int count;
    private LoopTagStatus status;
    private String pageNumber;
    private StringBuffer results;
    private Hashtable bar;
    private String style;

    /////////////////////////////////
    // Getter and Setter methods
    /////////////////////////////////
    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getVarStatus() {
        return varStatus;
    }

    public void setVarStatus(String varStatus) {
        this.varStatus = varStatus;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public StringBuffer getResults() {
        return results;
    }

    public void setResults(StringBuffer results) {
        this.results = results;
    }

    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    /////////////////////////////////////
    // Tag callback methods
    /////////////////////////////////////
    public int doStartTag() throws JspException {
        init();
        evaluateVariables();
        exposeVariables();
        return EVAL_BODY_BUFFERED;
    }

    public void doInitBody() {
    }

    public int doAfterBody() throws JspException {
        Perl5Util perl = new Perl5Util();
        //////////////////////////////////////////
        // Getting the content
        //////////////////////////////////////////
        BodyContent content = getBodyContent();
        String link = content.getString().trim();
        link = perl.substitute("s/^<.*?\\\"//",link);
        link = perl.substitute("s/\\\".*?>$//",link);
        content.clearBody();
        bar.put(""+count+"",link);
        ////////////////////////////////////////////
        // increment the count by 1 for each round
        /////////////////////////////////////////////
        LoopTagStatus status = getLoopStatus();
        if (hasNext()) {
            count++;
            status.setCount(count);
        }
        else
            return SKIP_BODY;
        exposeVariables();
        return EVAL_BODY_AGAIN;
    }

    public int doEndTag() throws JspException {

        render(bar, pageNumber);
        return EVAL_PAGE;
    }

    private void render(Hashtable bar, String pageNumber) throws JspException {
        int page = Integer.parseInt(pageNumber);
        String styleAttr = "";
        if(style != null && style.trim().length() > 0)
            styleAttr = "style=\"" + style + "\"";
        if(count > 1) {
            if(page > 1) {
                results.append("<a "+styleAttr+" href=\""+bar.get(""+(page-1)+"")+"\">[&lt;&lt; Prev]</a>");
                results.append(" ");
            }
            for(int i = 1; i <= count; i++) {
                if(i != page)
                    results.append("<a \"+styleAttr+\" href=\""+bar.get(""+i+"")+"\">"+i+"</a>");
                else
                    results.append("<b>"+i+"</b>");
                results.append(" ");
            }
            if(page < count) {
                results.append("<a \"+styleAttr+\" href=\""+bar.get(""+(page+1)+"")+"\">[Next &gt;&gt;]</a>");
            }
            ResponseUtils.write(pageContext,results.toString());
        }
    }

    private void init() {
        count = 1;
        status = null;
        bar = new Hashtable();
        results = new StringBuffer("");
    }

    private LoopTagStatus getLoopStatus() {
        if(status == null) {
            status = new LoopTagStatus();
            status.setCount(count);
            return status;
        }
        return status;
    }

    private void setLoopTagStatus(LoopTagStatus status) {
        this.status = status;
    }

    public boolean hasNext() {
        LoopTagStatus status = getLoopStatus();
        return (status.getCount() < Integer.parseInt(numberOfPages))? true : false;
    }

    private void evaluateVariables() throws JspException {
        numberOfPages = EvalHelper.evalString("numberOfPages",getNumberOfPages().toString(),this,pageContext);
        pageNumber = EvalHelper.evalString("pageNumber",getPageNumber().toString(),this,pageContext);
        varStatus = EvalHelper.evalString("varStatus",getVarStatus(),this,pageContext);
        style = EvalHelper.evalString("style",getStyle(),this,pageContext);
    }

    private void exposeVariables() {
        if (varStatus != null) {
            if (getLoopStatus() == null)
                pageContext.removeAttribute(varStatus, PageContext.PAGE_SCOPE);
            else
                pageContext.setAttribute(varStatus, getLoopStatus());
        }
    }

    public void release() {
        super.release();
        this.setNumberOfPages(null);
        this.setVarStatus(null);
        this.setLoopTagStatus(null);
        this.setPageNumber(null);
        this.setResults(null);
        count = 1;
    }
}
