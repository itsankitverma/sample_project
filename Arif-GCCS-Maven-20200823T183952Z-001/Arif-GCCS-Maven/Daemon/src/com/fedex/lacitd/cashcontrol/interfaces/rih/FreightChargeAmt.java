//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2004.05.13 at 11:11:44 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.rih;


/**
 * Java content class for freightChargeAmt element declaration.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/jwsdp-1.3/jaxb/bin/RIHResults.xsd line 29)
 * <p>
 * <pre>
 * &lt;element name="freightChargeAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 * </pre>
 * 
 */
public interface FreightChargeAmt
    extends javax.xml.bind.Element
{


    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getValue();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setValue(java.math.BigDecimal value);

}
