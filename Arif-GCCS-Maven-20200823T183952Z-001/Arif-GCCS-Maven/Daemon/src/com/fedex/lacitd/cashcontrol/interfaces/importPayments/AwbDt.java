//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.02 at 12:04:00 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.importPayments;


/**
 * Java content class for awb_dt element declaration.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/jwsdp-1.3/jaxb/bin/DataFeedOut.xsd line 21)
 * <p>
 * <pre>
 * &lt;element name="awb_dt" type="{http://www.w3.org/2001/XMLSchema}date"/>
 * </pre>
 * 
 */
public interface AwbDt
    extends javax.xml.bind.Element
{


    /**
     * 
     * @return
     *     possible object is
     *     {@link java.util.Calendar}
     */
    java.util.Calendar getValue();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.util.Calendar}
     */
    void setValue(java.util.Calendar value);

}
