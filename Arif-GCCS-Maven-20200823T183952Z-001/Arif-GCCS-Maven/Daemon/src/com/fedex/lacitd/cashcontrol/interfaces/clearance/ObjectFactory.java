//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.03 at 04:46:07 CLT 
//


package com.fedex.lacitd.cashcontrol.interfaces.clearance;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fedex.lacitd.cashcontrol.interfaces.clearance package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
public class ObjectFactory
    extends com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.DefaultJAXBContextImpl
{

    private static java.util.HashMap defaultImplementations = new java.util.HashMap();
    private static java.util.HashMap rootTagMap = new java.util.HashMap();
    public final static com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.GrammarInfo grammarInfo = new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.GrammarInfoImpl(rootTagMap, defaultImplementations, (com.fedex.lacitd.cashcontrol.interfaces.clearance.ObjectFactory.class));
    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.JAXBVersion.class);

    static {
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.RecDate.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecDateImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceiptNo.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceiptNoImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.RecAmount.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecAmountImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableType.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargesType.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargesTypeImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableListType.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableListTypeImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.Mtn.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.MtnImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.RecPrepAmt.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecPrepAmtImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.RodAmount.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RodAmountImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.Location.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.LocationImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.RecCurrency.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecCurrencyImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.RecNumber.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecNumberImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.Receivable.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargeType.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargeTypeImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharge.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargeImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharges.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargesImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableList.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableListImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.Customer.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.CustomerImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.ExchRate.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ExchRateImpl");
        defaultImplementations.put((com.fedex.lacitd.cashcontrol.interfaces.clearance.AnchargeAmount.class), "com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.AnchargeAmountImpl");
        rootTagMap.put(new javax.xml.namespace.QName("", "recAmount"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.RecAmount.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "surcharge"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharge.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "recCurrency"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.RecCurrency.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "receivable"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.Receivable.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "recDate"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.RecDate.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "customer"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.Customer.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "recPrepAmt"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.RecPrepAmt.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "anchargeAmount"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.AnchargeAmount.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "surcharges"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharges.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "receiptNo"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceiptNo.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "recNumber"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.RecNumber.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "receivableList"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableList.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "mtn"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.Mtn.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "location"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.Location.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "rodAmount"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.RodAmount.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "exchRate"), (com.fedex.lacitd.cashcontrol.interfaces.clearance.ExchRate.class));
    }

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fedex.lacitd.cashcontrol.interfaces.clearance
     * 
     */
    public ObjectFactory() {
        super(grammarInfo);
    }

    /**
     * Create an instance of the specified Java content interface.
     * 
     * @param javaContentInterface
     *     the Class object of the javacontent interface to instantiate
     * @return
     *     a new instance
     * @throws JAXBException
     *     if an error occurs
     */
    public java.lang.Object newInstance(java.lang.Class javaContentInterface)
        throws javax.xml.bind.JAXBException
    {
        return super.newInstance(javaContentInterface);
    }

    /**
     * Get the specified property. This method can only be
     * used to get provider specific properties.
     * Attempting to get an undefined property will result
     * in a PropertyException being thrown.
     * 
     * @param name
     *     the name of the property to retrieve
     * @return
     *     the value of the requested property
     * @throws PropertyException
     *     when there is an error retrieving the given property or value
     */
    public java.lang.Object getProperty(java.lang.String name)
        throws javax.xml.bind.PropertyException
    {
        return super.getProperty(name);
    }

    /**
     * Set the specified property. This method can only be
     * used to set provider specific properties.
     * Attempting to set an undefined property will result
     * in a PropertyException being thrown.
     * 
     * @param value
     *     the value of the property to be set
     * @param name
     *     the name of the property to retrieve
     * @throws PropertyException
     *     when there is an error processing the given property or value
     */
    public void setProperty(java.lang.String name, java.lang.Object value)
        throws javax.xml.bind.PropertyException
    {
        super.setProperty(name, value);
    }

    /**
     * Create an instance of RecDate
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecDate createRecDate()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecDateImpl();
    }

    /**
     * Create an instance of RecDate
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecDate createRecDate(java.util.Calendar value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecDateImpl(value);
    }

    /**
     * Create an instance of ReceiptNo
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceiptNo createReceiptNo()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceiptNoImpl();
    }

    /**
     * Create an instance of ReceiptNo
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceiptNo createReceiptNo(java.lang.String value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceiptNoImpl(value);
    }

    /**
     * Create an instance of RecAmount
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecAmount createRecAmount()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecAmountImpl();
    }

    /**
     * Create an instance of RecAmount
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecAmount createRecAmount(java.math.BigDecimal value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecAmountImpl(value);
    }

    /**
     * Create an instance of ReceivableType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableType createReceivableType()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl();
    }

    /**
     * Create an instance of SurchargesType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargesType createSurchargesType()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargesTypeImpl();
    }

    /**
     * Create an instance of ReceivableListType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableListType createReceivableListType()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableListTypeImpl();
    }

    /**
     * Create an instance of Mtn
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Mtn createMtn()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.MtnImpl();
    }

    /**
     * Create an instance of Mtn
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Mtn createMtn(java.lang.String value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.MtnImpl(value);
    }

    /**
     * Create an instance of RecPrepAmt
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecPrepAmt createRecPrepAmt()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecPrepAmtImpl();
    }

    /**
     * Create an instance of RecPrepAmt
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecPrepAmt createRecPrepAmt(java.math.BigDecimal value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecPrepAmtImpl(value);
    }

    /**
     * Create an instance of RodAmount
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RodAmount createRodAmount()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RodAmountImpl();
    }

    /**
     * Create an instance of RodAmount
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RodAmount createRodAmount(java.math.BigDecimal value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RodAmountImpl(value);
    }

    /**
     * Create an instance of Location
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Location createLocation()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.LocationImpl();
    }

    /**
     * Create an instance of Location
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Location createLocation(java.lang.String value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.LocationImpl(value);
    }

    /**
     * Create an instance of RecCurrency
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecCurrency createRecCurrency()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecCurrencyImpl();
    }

    /**
     * Create an instance of RecCurrency
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecCurrency createRecCurrency(java.lang.String value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecCurrencyImpl(value);
    }

    /**
     * Create an instance of RecNumber
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecNumber createRecNumber()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecNumberImpl();
    }

    /**
     * Create an instance of RecNumber
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.RecNumber createRecNumber(java.lang.String value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.RecNumberImpl(value);
    }

    /**
     * Create an instance of Receivable
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Receivable createReceivable()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableImpl();
    }

    /**
     * Create an instance of SurchargeType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargeType createSurchargeType()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargeTypeImpl();
    }

    /**
     * Create an instance of Surcharge
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharge createSurcharge()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargeImpl();
    }

    /**
     * Create an instance of Surcharges
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Surcharges createSurcharges()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.SurchargesImpl();
    }

    /**
     * Create an instance of ReceivableList
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableList createReceivableList()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableListImpl();
    }

    /**
     * Create an instance of Customer
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Customer createCustomer()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.CustomerImpl();
    }

    /**
     * Create an instance of Customer
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.Customer createCustomer(java.lang.String value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.CustomerImpl(value);
    }

    /**
     * Create an instance of ExchRate
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.ExchRate createExchRate()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ExchRateImpl();
    }

    /**
     * Create an instance of ExchRate
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.ExchRate createExchRate(java.math.BigDecimal value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ExchRateImpl(value);
    }

    /**
     * Create an instance of AnchargeAmount
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.AnchargeAmount createAnchargeAmount()
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.AnchargeAmountImpl();
    }

    /**
     * Create an instance of AnchargeAmount
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.fedex.lacitd.cashcontrol.interfaces.clearance.AnchargeAmount createAnchargeAmount(java.math.BigDecimal value)
        throws javax.xml.bind.JAXBException
    {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.AnchargeAmountImpl(value);
    }

}
