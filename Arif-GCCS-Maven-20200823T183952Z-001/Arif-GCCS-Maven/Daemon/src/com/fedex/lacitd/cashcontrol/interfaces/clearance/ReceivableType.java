//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.03 at 04:46:07 CLT 
//


package com.fedex.lacitd.cashcontrol.interfaces.clearance;


/**
 * Java content class for anonymous complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/Trabajo/CashControlWSP/CCS/CCS/schema/RODXML.xsd line 16)
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{}location" minOccurs="0"/>
 *         &lt;element ref="{}mtn" minOccurs="0"/>
 *         &lt;element ref="{}customer" minOccurs="0"/>
 *         &lt;element ref="{}recDate" minOccurs="0"/>
 *         &lt;element ref="{}recNumber" minOccurs="0"/>
 *         &lt;element ref="{}recCurrency" minOccurs="0"/>
 *         &lt;element ref="{}exchRate" minOccurs="0"/>
 *         &lt;element ref="{}recAmount" minOccurs="0"/>
 *         &lt;element ref="{}rodAmount" minOccurs="0"/>
 *         &lt;element ref="{}anchargeAmount" minOccurs="0"/>
 *         &lt;element ref="{}recPrepAmt" minOccurs="0"/>
 *         &lt;element ref="{}receiptNo" minOccurs="0"/>
 *         &lt;element ref="{}surcharges" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="num" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface ReceivableType {


    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMtn();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMtn(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getCustomer();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setCustomer(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getRecPrepAmt();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setRecPrepAmt(java.math.BigDecimal value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getRecAmount();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setRecAmount(java.math.BigDecimal value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getRecNumber();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setRecNumber(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getRodAmount();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setRodAmount(java.math.BigDecimal value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getReceiptNo();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setReceiptNo(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.util.Calendar}
     */
    java.util.Calendar getRecDate();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.util.Calendar}
     */
    void setRecDate(java.util.Calendar value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getAnchargeAmount();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setAnchargeAmount(java.math.BigDecimal value);

    /**
     * 
     */
    int getNum();

    /**
     * 
     */
    void setNum(int value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargesType}
     *     {@link com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharges}
     */
    com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargesType getSurcharges();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargesType}
     *     {@link com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharges}
     */
    void setSurcharges(com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargesType value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getRecCurrency();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setRecCurrency(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getLocation();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setLocation(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getExchRate();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setExchRate(java.math.BigDecimal value);

}