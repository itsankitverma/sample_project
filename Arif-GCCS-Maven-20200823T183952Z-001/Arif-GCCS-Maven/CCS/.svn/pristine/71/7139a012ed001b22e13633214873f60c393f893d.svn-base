package com.fedex.lacitd.cashcontrol.prestier.tag;
 
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;
import org.apache.struts.taglib.nested.NestedPropertyHelper;
import org.apache.struts.taglib.nested.NestedNameSupport;
import org.apache.struts.util.MessageResources;
import org.apache.struts.taglib.html.Constants;
import java.util.Map;
import java.util.Collection;
import java.lang.reflect.Array;
import org.apache.oro.text.perl.Perl5Util;



/**
 *  Generated tag class.
 */
public class PagesNavTag extends TagSupport implements NestedNameSupport{
    
    protected static MessageResources messages =
                         MessageResources.getMessageResources(Constants.Package + ".LocalStrings");

    /** property declaration for tag attribute: collection.
     *It can used to get the collection from a JSP Scripting variable
     */    
    private java.lang.Object collection;    

    /** property declaration for tag attribute: page.
     *Holds the current page.
     */    
    private java.lang.String page = "1";
    
    /** property declaration for tag attribute: length.
     *Holds the record count per page.
     */    
    private java.lang.String length = "10";
    
    /** property declaration for tag attribute: showPage.
     *It holds the URL to be used to get every page.
     *It can use "scripting variables" as parameters for the URL.
     *    ${page}: will replace the value of the page represented by the link
     *    ${length}: will replace the value of the length variable.
     *    ${indexLength}: will replace the value of the indexLength variable.
     */    
    private java.lang.String showPage = "ShowPage";
    
    /** Holds value of property indexLength. 
     *  Holds the length of the index of pages
     */
    private java.lang.String indexLength = "10";
    
    /** Holds value of property name. */
    private java.lang.String name;
    
    /** Holds value of property scope. */
    private java.lang.String scope;
    
    /** Holds value of property property. */
    private java.lang.String property;
    
    public PagesNavTag() {
        super();
    }
    
    
    ////////////////////////////////////////////////////////////////
    ///                                                          ///
    ///   User methods.                                          ///
    ///                                                          ///
    ///   Modify these methods to customize your tag handler.    ///
    ///                                                          ///
    ////////////////////////////////////////////////////////////////
    
    
    //
    // methods called from doStartTag()
    //
    /**
     *  
     * Fill in this method to perform other operations from doStartTag().
     * 
     */
    public void otherDoStartTagOperations() throws JspException {

	// Acquire the collection we are going to iterate over
        int size=0;
   
        Object collection = this.collection;
	if (collection == null){
            if(name==null){
                NestedPropertyHelper.setNestedProperties((HttpServletRequest)pageContext.getRequest(),this);            
            }        
            collection = RequestUtils.lookup(pageContext, name, property, scope);
        }
        
        if (collection == null) {
            JspException e = new JspException
                (messages.getMessage("iterate.collection"));
            RequestUtils.saveException(pageContext, e);
            throw e;
        }

	// Construct an iterator for this collection
	if (collection.getClass().isArray()) {
            size = Array.getLength(collection);
	} else if (collection instanceof Collection)
	    size=((Collection) collection).size();
	else if (collection instanceof Map)
	    size = ((Map) collection).entrySet().size();
   	else {
	    JspException e = new JspException
	        (messages.getMessage("iterate.iterator"));
            RequestUtils.saveException(pageContext, e);
            throw e;
        }

        int lengthValue=20;

        if (this.length!=null){
         
            try {
                lengthValue = Integer.parseInt(this.length);
            } catch (NumberFormatException e) {
                 Integer lengthObj = (Integer) RequestUtils.lookup(pageContext, this.length, null);
                 if (lengthObj == null)
                     lengthValue = 20;
                 else
                     lengthValue = lengthObj.intValue();
            }
        }       
        
      
        if (lengthValue < size){
         
            int indexLengthValue=20;

            if (this.indexLength!=null){
                try {
                    indexLengthValue = Integer.parseInt(this.indexLength);
                } catch (NumberFormatException e) {
                     Integer indexLengthObj = (Integer) RequestUtils.lookup(pageContext, this.indexLength, null);
                     if (indexLengthObj == null)
                         indexLengthValue = 20;
                     else
                         indexLengthValue = indexLengthObj.intValue();
                }
            } 

            int pageValue=1;

            if (this.page!=null){
                try {
                    pageValue = Integer.parseInt(this.page);
                } catch (NumberFormatException e) {
                     Integer pageObj = (Integer) RequestUtils.lookup(pageContext, this.page, null);
                     if (pageObj == null)
                         pageValue = 1;
                     else
                         pageValue = pageObj.intValue();
                }
            }
            
            int totalPages=(size/lengthValue)+((size%lengthValue)==0?0:1);
            
            StringBuffer sb=new StringBuffer();
            sb.append("<font face='Helvetica' size='-1'>\n");
            
            Perl5Util p5u=new Perl5Util();
            
            showPage=p5u.substitute("s/\\${indexLength}/"+indexLengthValue+"/g",showPage);
            showPage=p5u.substitute("s/\\${length}/"+lengthValue+"/g",showPage);
            
            if(pageValue>1){                  
                  sb.append("<a href=\"" + p5u.substitute("s/\\${page}/"+(pageValue-1)+"/g",showPage) + "\">[<< Prev]</a>&nbsp;\n");
            }
            
            int fromPage=pageValue-(indexLengthValue/2);
            if(fromPage<1) fromPage=1;
            
            int toPage=fromPage+indexLengthValue-1;
            if(toPage>totalPages) toPage=totalPages;
            
            
            
  
            for(int i=fromPage;i<=toPage;i++){
                if (i == pageValue) {
                      sb.append("&nbsp;<b>"+i+"</b>\n");
                } else {
                      sb.append("&nbsp;<a href=\"" + p5u.substitute("s/\\${page}/"+i+"/g",showPage) + "\">"+i+"</a>\n");
                }
            }


            if(pageValue < totalPages) {
                sb.append("&nbsp;<a href=\"" + p5u.substitute("s/\\${page}/"+(pageValue+1)+"/g",showPage) + "\">[Next >>]</a>\n");
            }

            sb.append("</font>");
            
            ResponseUtils.write(pageContext,sb.toString());            

        }
     }     
    
    /**
     *  
     * Fill in this method to determine if the tag body should be evaluated
     * Called from doStartTag().
     * 
     */
    public boolean theBodyShouldBeEvaluated()  {

        //
        //       code that determines whether the body should be
        //       evaluated should be placed here.
        //       Called from the doStartTag() method.
        //
        return false;

    }
    
    
    //
    // methods called from doEndTag()
    //
    /**
     *  
     * Fill in this method to perform other operations from doEndTag().
     * 
     */
    public void otherDoEndTagOperations()  {
    
        //
        //       code that performs other operations in doEndTag
        //       should be placed here.
        //       It will be called after initializing variables, 
        //       finding the parent, setting IDREFs, etc, and 
        //       before calling shouldEvaluateRestOfPageAfterEndTag(). 
        //
        

    }
    
    /**
     *  
     * Fill in this method to determine if the rest of the JSP page
     * should be generated after this tag is finished.
     * Called from doEndTag().
     * 
     */
    public boolean shouldEvaluateRestOfPageAfterEndTag()  {

        //
        //       code that determines whether the rest of the page
        //       should be evaluated after the tag is processed
        //       should be placed here.
        //       Called from the doEndTag() method.
        //
        return true;

    }
    
    
    ////////////////////////////////////////////////////////////////
    ///                                                          ///
    ///   Tag Handler interface methods.                         ///
    ///                                                          ///
    ///   Do not modify these methods; instead, modify the       ///
    ///   methods that they call.                                ///
    ///                                                          ///
    ////////////////////////////////////////////////////////////////
    
    
    /** .//GEN-BEGIN:doStartTag
     *
     * This method is called when the JSP engine encounters the start tag,
     * after the attributes are processed.
     * Scripting variables (if any) have their values set here.
     * @return EVAL_BODY_INCLUDE if the JSP engine should evaluate the tag body, otherwise return SKIP_BODY.
     * This method is automatically generated. Do not modify this method.
     * Instead, modify the methods that this method calls.
     *
     */
    public int doStartTag() throws JspException, JspException {
        otherDoStartTagOperations();
        
        if (theBodyShouldBeEvaluated()) {
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }//GEN-END:doStartTag
    
    /** .//GEN-BEGIN:doEndTag
     *
     *
     * This method is called after the JSP engine finished processing the tag.
     * @return EVAL_PAGE if the JSP engine should continue evaluating the JSP page, otherwise return SKIP_PAGE.
     * This method is automatically generated. Do not modify this method.
     * Instead, modify the methods that this method calls.
     *
     */
    public int doEndTag() throws JspException, JspException {
        otherDoEndTagOperations();
        
        if (shouldEvaluateRestOfPageAfterEndTag()) {
            return EVAL_PAGE;
        } else {
            return SKIP_PAGE;
        }
    }//GEN-END:doEndTag
    
    public java.lang.Object getCollection() {
        return collection;
    }
    
    public void setCollection(java.lang.Object value) {
        collection = value;
    }
    
    public java.lang.String getPage() {
        return page;
    }
    
    public void setPage(java.lang.String value) {
        page = value;
    }
    
    public java.lang.String getLength() {
        return length;
    }
    
    public void setLength(java.lang.String value) {
        length = value;
    }
    
    public java.lang.String getShowPage() {
        return showPage;
    }
    
    public void setShowPage(java.lang.String value) {
        showPage = value;
    }
    
    /** Getter for property indexLength.
     * @return Value of property indexLength.
     */
    public java.lang.String getIndexLength() {
        return this.indexLength;
    }
    
    /** Setter for property indexLength.
     * @param indexLength New value of property indexLength.
     */
    public void setIndexLength(java.lang.String indexLength) {
        this.indexLength = indexLength;
    }
    
    /** Getter for property name.
     * @return Value of property name.
     */
    public java.lang.String getName() {
        return this.name;
    }
    
    /** Setter for property name.
     * @param name New value of property name.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    /** Getter for property scope.
     * @return Value of property scope.
     */
    public java.lang.String getScope() {
        return this.scope;
    }
    
    /** Setter for property scope.
     * @param scope New value of property scope.
     */
    public void setScope(java.lang.String scope) {
        this.scope = scope;
    }
    
    /** Getter for property property.
     * @return Value of property property.
     */
    public java.lang.String getProperty() {
        return this.property;
    }
    
    /** Setter for property property.
     * @param property New value of property property.
     */
    public void setProperty(java.lang.String property) {
        this.property = property;
    }
    
    
    /**
     * Release all allocated resources.
     */
    public void release() {

	super.release();
        
        id = null;
        collection = null;
        length = "10";
        name = null;
        property = null;
        scope = null;
        page="1";
        indexLength="10";
        showPage="ShowPage";
    }    
    
    
}
