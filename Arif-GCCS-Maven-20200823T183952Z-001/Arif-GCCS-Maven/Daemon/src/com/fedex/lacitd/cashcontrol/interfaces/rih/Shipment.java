//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2004.05.13 at 11:11:44 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.rih;


/**
 * Java content class for Shipment element declaration.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/jwsdp-1.3/jaxb/bin/RIHResults.xsd line 11)
 * <p>
 * <pre>
 * &lt;element name="Shipment">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}awbNbr" minOccurs="0"/>
 *           &lt;element ref="{}origLocation" minOccurs="0"/>
 *           &lt;element ref="{}destLocation" minOccurs="0"/>
 *           &lt;element ref="{}shipDt" minOccurs="0"/>
 *           &lt;element ref="{}origCountry" minOccurs="0"/>
 *           &lt;element ref="{}destCountry" minOccurs="0"/>
 *           &lt;element ref="{}freightChargeAmt" minOccurs="0"/>
 *           &lt;element ref="{}shipperCompany" minOccurs="0"/>
 *           &lt;element ref="{}shipperNm" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 */
public interface Shipment
    extends javax.xml.bind.Element, com.fedex.lacitd.cashcontrol.interfaces.rih.ShipmentType
{


}
