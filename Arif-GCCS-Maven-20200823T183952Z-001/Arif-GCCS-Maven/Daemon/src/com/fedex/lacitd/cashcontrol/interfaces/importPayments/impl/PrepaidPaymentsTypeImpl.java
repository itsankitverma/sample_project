//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.02 at 12:04:00 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl;

public class PrepaidPaymentsTypeImpl implements com.fedex.lacitd.cashcontrol.interfaces.importPayments.PrepaidPaymentsType, com.sun.xml.bind.JAXBObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallableObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializable, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.ValidatableObject
{

    protected com.sun.xml.bind.util.ListImpl _PrepaidPayment = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.PrepaidPaymentsType.class);
    }

    public java.util.List getPrepaidPayment() {
        return _PrepaidPayment;
    }

    public com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingContext context) {
        return new com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentsTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = _PrepaidPayment.size();
        while (idx1 != len1) {
            if (_PrepaidPayment.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _PrepaidPayment.get(idx1 ++)), "PrepaidPayment");
            } else {
                context.startElement("", "prepaid_payment");
                int idx_0 = idx1;
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _PrepaidPayment.get(idx_0 ++)), "PrepaidPayment");
                context.endNamespaceDecls();
                int idx_1 = idx1;
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _PrepaidPayment.get(idx_1 ++)), "PrepaidPayment");
                context.endAttributes();
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _PrepaidPayment.get(idx1 ++)), "PrepaidPayment");
                context.endElement();
            }
        }
    }

    public void serializeAttributes(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = _PrepaidPayment.size();
        while (idx1 != len1) {
            if (_PrepaidPayment.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _PrepaidPayment.get(idx1 ++)), "PrepaidPayment");
            } else {
                idx1 += 1;
            }
        }
    }

    public void serializeURIs(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = _PrepaidPayment.size();
        while (idx1 != len1) {
            if (_PrepaidPayment.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _PrepaidPayment.get(idx1 ++)), "PrepaidPayment");
            } else {
                idx1 += 1;
            }
        }
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.PrepaidPaymentsType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun."
+"msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gramm"
+"ar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expression"
+"\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/l"
+"ang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0002xp\u0005dh\u00f7ppsr\u0000 com.sun.msv.gramm"
+"ar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0005dh\u00ecsr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002"
+"\u0000\u0001Z\u0000\u0005valuexp\u0000psq\u0000~\u0000\u0000\u0005dh\u00e9q\u0000~\u0000\npsr\u0000\'com.sun.msv.grammar.trex.E"
+"lementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/"
+"NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aig"
+"noreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u008e\u00d7\u009cq\u0000~\u0000\np"
+"\u0000sq\u0000~\u0000\u0000\u0001\u008e\u00d7\u0091ppsq\u0000~\u0000\u0006\u0001\u008e\u00d7\u0086q\u0000~\u0000\npsr\u0000 com.sun.msv.grammar.Attribu"
+"teExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\rxq\u0000~\u0000\u0003\u0001\u008e\u00d7\u0083q\u0000~\u0000\np"
+"sr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\bsq\u0000~\u0000\t\u0001psr\u0000 com.sun.msv.grammar.AnyNameClass\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000"
+"com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000x"
+"q\u0000~\u0000\u0003\u0000\u0000\u0000\tq\u0000~\u0000\u0016psr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000\u001dxq"
+"\u0000~\u0000\u0018t\u0000Ecom.fedex.lacitd.cashcontrol.interfaces.importPayment"
+"s.PrepaidPaymentt\u0000+http://java.sun.com/jaxb/xjc/dummy-elemen"
+"tssq\u0000~\u0000\f\u0003\u00d5\u0091Kq\u0000~\u0000\np\u0000sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001\u0003\u00d5\u0091@ppsq\u0000~\u0000\f\u0001\u008e\u00d7\u009cpp\u0000sq\u0000~\u0000\u0000\u0001\u008e\u00d7\u0091ppsq\u0000~\u0000\u0006\u0001\u008e\u00d7\u0086q\u0000~\u0000\npsq"
+"\u0000~\u0000\u0012\u0001\u008e\u00d7\u0083q\u0000~\u0000\npq\u0000~\u0000\u0015q\u0000~\u0000\u0019q\u0000~\u0000\u001bsq\u0000~\u0000\u001ct\u0000Icom.fedex.lacitd.cashc"
+"ontrol.interfaces.importPayments.PrepaidPaymentTypeq\u0000~\u0000 sq\u0000~"
+"\u0000\u0000\u0002F\u00b9\u009fppsq\u0000~\u0000\u0012\u0002F\u00b9\u0094q\u0000~\u0000\npsr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L"
+"\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0003\u0001\u00e9\u0003\u00e5ppsr\u0000\"com.su"
+"n.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000*com.sun.msv.datat"
+"ype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype"
+".xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSD"
+"atatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUriq\u0000~\u0000\u001dL\u0000\btypeNameq\u0000~\u0000\u001dL\u0000"
+"\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;"
+"xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0005QNamesr\u00005com.sun.msv"
+".datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com"
+".sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000co"
+"m.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000"
+"~\u0000\u0003\u0000\u0000\u0000\nppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalN"
+"ameq\u0000~\u0000\u001dL\u0000\fnamespaceURIq\u0000~\u0000\u001dxpq\u0000~\u00007q\u0000~\u00006sq\u0000~\u0000\u001ct\u0000\u0004typet\u0000)http"
+"://www.w3.org/2001/XMLSchema-instanceq\u0000~\u0000\u001bsq\u0000~\u0000\u001ct\u0000\u000fprepaid_p"
+"aymentt\u0000\u0000q\u0000~\u0000\u001bsr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedH"
+"ash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef"
+"\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000F[\u0000\u0005tablet\u0000![Lcom/sun"
+"/msv/grammar/Expression;xp\u0000\u0000\u0000\t\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar"
+".Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfppppppppppppppppppppppppppppppp"
+"pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp"
+"pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp"
+"q\u0000~\u0000\u000bq\u0000~\u0000\u0011q\u0000~\u0000&q\u0000~\u0000\bq\u0000~\u0000#pppppppq\u0000~\u0000\u0010q\u0000~\u0000%q\u0000~\u0000\u0005pq\u0000~\u0000*ppppppp"
+"pppppppppppppppp"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingContext context) {
            super(context, "----");
        }

        protected Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentsTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("awb" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("awb_dt" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("courier_id" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("cust_name" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("chk_agent_id" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("pymt_dt" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("pymt_tot_amt" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("pymt_cash_amt" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("pymt_doc_amt" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("pymt_doc_nbr" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("pymt_doc_type" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("pymt_curr_cd" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("exch_rate" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                        return ;
                    case  1 :
                        if (("prepaid_payment" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentImpl.class), 1, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("prepaid_payment" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 2;
                            return ;
                        }
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  0 :
                        if (("prepaid_payment" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentImpl.class), 1, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("prepaid_payment" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 2;
                            return ;
                        }
                        state = 1;
                        continue outer;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromLeaveElement((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname)));
                        return ;
                    case  3 :
                        if (("prepaid_payment" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 1;
                            return ;
                        }
                        break;
                    case  1 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  0 :
                        state = 1;
                        continue outer;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        if (("num" == ___local)&&("" == ___uri)) {
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterAttribute((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname)));
                            return ;
                        }
                        _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromEnterAttribute((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname)));
                        return ;
                    case  1 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  0 :
                        state = 1;
                        continue outer;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromLeaveAttribute((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, ___uri, ___local, ___qname)));
                        return ;
                    case  1 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  0 :
                        state = 1;
                        continue outer;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  2 :
                            attIdx = context.getAttribute("", "num");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            _PrepaidPayment.add(((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl) spawnChildFromText((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PrepaidPaymentTypeImpl.class), 3, value)));
                            return ;
                        case  1 :
                            revertToParentFromText(value);
                            return ;
                        case  0 :
                            state = 1;
                            continue outer;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}