//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.03 at 04:46:07 CLT 
//


package com.fedex.lacitd.cashcontrol.interfaces.clearance.impl;

public class ExchRateImpl implements com.fedex.lacitd.cashcontrol.interfaces.clearance.ExchRate, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallableObject, com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializable, com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.ValidatableObject
{

    protected java.math.BigDecimal _Value;
    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    public ExchRateImpl() {
    }

    public ExchRateImpl(java.math.BigDecimal value) {
        _Value = value;
    }

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.fedex.lacitd.cashcontrol.interfaces.clearance.ExchRate.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "exchRate";
    }

    public java.math.BigDecimal getValue() {
        return _Value;
    }

    public void setValue(java.math.BigDecimal value) {
        _Value = value;
    }

    public com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingContext context) {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ExchRateImpl.Unmarshaller(context);
    }

    public void serializeBody(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "exchRate");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(javax.xml.bind.DatatypeConverter.printDecimal(((java.math.BigDecimal) _Value)), "Value");
        } catch (java.lang.Exception e) {
            com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
    }

    public void serializeAttributes(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeURIs(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.fedex.lacitd.cashcontrol.interfaces.clearance.ExchRate.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilon"
+"Reducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xp\u0003\"0Up"
+"p\u0000sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun."
+"msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~"
+"\u0000\u0004\u0003\"0Jppsr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLo"
+"rg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0003L\u0000\u0004namet\u0000\u001dLcom/su"
+"n/msv/util/StringPair;xq\u0000~\u0000\u0004\u0001\u00c5\u0005\u0017ppsr\u0000#com.sun.msv.datatype.x"
+"sd.NumberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.Builtin"
+"AtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteTy"
+"pe\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000\u0012L"
+"\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor"
+";xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0007decimalsr\u00005com.sun."
+"msv.datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,"
+"com.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u0000"
+"0com.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000"
+"xq\u0000~\u0000\u0004\u0000\u0000\u0000\nppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tloc"
+"alNameq\u0000~\u0000\u0012L\u0000\fnamespaceURIq\u0000~\u0000\u0012xpq\u0000~\u0000\u0016q\u0000~\u0000\u0015sr\u0000\u001dcom.sun.msv.g"
+"rammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\b\u0001]+.ppsr\u0000 com.sun.msv.gramm"
+"ar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0003L\u0000\tnameClassq\u0000~\u0000\u0001xq\u0000~\u0000\u0004"
+"\u0001]+#sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psq\u0000~\u0000\n\u0000\u00f1\u008e\u009epp"
+"sr\u0000\"com.sun.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u000fq\u0000~\u0000\u0015"
+"t\u0000\u0005QNameq\u0000~\u0000\u0019q\u0000~\u0000\u001bsq\u0000~\u0000\u001cq\u0000~\u0000\'q\u0000~\u0000\u0015sr\u0000#com.sun.msv.grammar.Si"
+"mpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0012L\u0000\fnamespaceURIq\u0000~\u0000"
+"\u0012xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)htt"
+"p://www.w3.org/2001/XMLSchema-instancesr\u00000com.sun.msv.gramma"
+"r.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004\u0000\u0000\u0000\tsq\u0000~\u0000\"\u0001ps"
+"q\u0000~\u0000)t\u0000\bexchRatet\u0000\u0000sr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$Cl"
+"osedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash"
+"\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u00005[\u0000\u0005tablet\u0000![Lco"
+"m/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\u0002\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.gr"
+"ammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpppppppppppppppppppppppppp"
+"pppppppppppppppppppppppppppppppq\u0000~\u0000\tpppppppppppppppppppppppp"
+"pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp"
+"ppppppppppppppppppppppppppppppq\u0000~\u0000\u001fpppppppppppppppppp"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingContext context) {
            super(context, "----");
        }

        protected Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ExchRateImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        if (("exchRate" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        break;
                    case  3 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
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
                        if (("exchRate" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  3 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
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
                    case  3 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
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
                    case  3 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
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
                        case  1 :
                            eatText1(value);
                            state = 2;
                            return ;
                        case  3 :
                            revertToParentFromText(value);
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Value = javax.xml.bind.DatatypeConverter.parseDecimal(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}
