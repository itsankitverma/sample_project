//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.02 at 12:04:00 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl;

public class CourierIdImpl implements com.fedex.lacitd.cashcontrol.interfaces.importPayments.CourierId, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallableObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializable, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.ValidatableObject
{

    protected boolean has_Value;
    protected int _Value;
    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    public CourierIdImpl() {
    }

    public CourierIdImpl(int value) {
        _Value = value;
        has_Value = true;
    }

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.CourierId.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "courier_id";
    }

    public int getValue() {
        return _Value;
    }

    public void setValue(int value) {
        _Value = value;
        has_Value = true;
    }

    public com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingContext context) {
        return new com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.CourierIdImpl.Unmarshaller(context);
    }

    public void serializeBody(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (!has_Value) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Value"));
        }
        context.startElement("", "courier_id");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(javax.xml.bind.DatatypeConverter.printInt(((int) _Value)), "Value");
        } catch (java.lang.Exception e) {
            com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
    }

    public void serializeAttributes(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (!has_Value) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Value"));
        }
    }

    public void serializeURIs(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (!has_Value) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Value"));
        }
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.CourierId.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilon"
+"Reducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xp\u0004\u00e7V\u00aap"
+"p\u0000sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun."
+"msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~"
+"\u0000\u0004\u0004\u00e7V\u009fppsr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLo"
+"rg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0003L\u0000\u0004namet\u0000\u001dLcom/su"
+"n/msv/util/StringPair;xq\u0000~\u0000\u0004\u0001\u00a6h_ppsr\u0000 com.sun.msv.datatype.x"
+"sd.IntType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com.sun.msv.datatype.xsd.IntegerDer"
+"ivedType\u0099\u00f1]\u0090&6k\u00be\u0002\u0000\u0001L\u0000\nbaseFacetst\u0000)Lcom/sun/msv/datatype/xsd"
+"/XSDatatypeImpl;xr\u0000*com.sun.msv.datatype.xsd.BuiltinAtomicTy"
+"pe\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L"
+"\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000\u0014L\u0000\nwhiteS"
+"pacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000 ht"
+"tp://www.w3.org/2001/XMLSchemat\u0000\u0003intsr\u00005com.sun.msv.datatype"
+".xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv."
+"datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u0000*com.sun.msv"
+".datatype.xsd.MaxInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun.msv.da"
+"tatype.xsd.RangeFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\nlimitValuet\u0000\u0012Ljava/lang/O"
+"bject;xr\u00009com.sun.msv.datatype.xsd.DataTypeWithValueConstrai"
+"ntFacet\"\u00a7Ro\u00ca\u00c7\u008aT\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.DataTypeWithF"
+"acet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacetFixedZ\u0000\u0012needValueCheckFlagL\u0000\bbaseTy"
+"peq\u0000~\u0000\u0010L\u0000\fconcreteTypet\u0000\'Lcom/sun/msv/datatype/xsd/ConcreteT"
+"ype;L\u0000\tfacetNameq\u0000~\u0000\u0014xq\u0000~\u0000\u0013ppq\u0000~\u0000\u001b\u0000\u0001sr\u0000*com.sun.msv.datatype"
+".xsd.MinInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001dppq\u0000~\u0000\u001b\u0000\u0000sr\u0000!com.sun."
+"msv.datatype.xsd.LongType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u000fq\u0000~\u0000\u0017t\u0000\u0004longq\u0000~\u0000\u001bs"
+"q\u0000~\u0000\u001cppq\u0000~\u0000\u001b\u0000\u0001sq\u0000~\u0000#ppq\u0000~\u0000\u001b\u0000\u0000sr\u0000$com.sun.msv.datatype.xsd.In"
+"tegerType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u000fq\u0000~\u0000\u0017t\u0000\u0007integerq\u0000~\u0000\u001bsr\u0000,com.sun.ms"
+"v.datatype.xsd.FractionDigitsFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\u0005scalexr\u0000;com"
+".sun.msv.datatype.xsd.DataTypeWithLexicalConstraintFacetT\u0090\u001c>"
+"\u001azb\u00ea\u0002\u0000\u0000xq\u0000~\u0000 ppq\u0000~\u0000\u001b\u0001\u0000sr\u0000#com.sun.msv.datatype.xsd.NumberTyp"
+"e\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0011q\u0000~\u0000\u0017t\u0000\u0007decimalq\u0000~\u0000\u001bq\u0000~\u00001t\u0000\u000efractionDigits"
+"\u0000\u0000\u0000\u0000q\u0000~\u0000+t\u0000\fminInclusivesr\u0000\u000ejava.lang.Long;\u008b\u00e4\u0090\u00cc\u008f#\u00df\u0002\u0000\u0001J\u0000\u0005valu"
+"exr\u0000\u0010java.lang.Number\u0086\u00ac\u0095\u001d\u000b\u0094\u00e0\u008b\u0002\u0000\u0000xp\u0080\u0000\u0000\u0000\u0000\u0000\u0000\u0000q\u0000~\u0000+t\u0000\fmaxInclusi"
+"vesq\u0000~\u00005\u007f\u00ff\u00ff\u00ff\u00ff\u00ff\u00ff\u00ffq\u0000~\u0000&q\u0000~\u00004sr\u0000\u0011java.lang.Integer\u0012\u00e2\u00a0\u00a4\u00f7\u0081\u00878\u0002\u0000\u0001I\u0000"
+"\u0005valuexq\u0000~\u00006\u0080\u0000\u0000\u0000q\u0000~\u0000&q\u0000~\u00008sq\u0000~\u0000:\u007f\u00ff\u00ff\u00ffsr\u00000com.sun.msv.grammar."
+"Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004\u0000\u0000\u0000\nppsr\u0000\u001bcom.s"
+"un.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0014L\u0000\fnamespa"
+"ceURIq\u0000~\u0000\u0014xpq\u0000~\u0000\u0018q\u0000~\u0000\u0017sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\b\u0003@\u00ee;ppsr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0003L\u0000\tnameClassq\u0000~\u0000\u0001xq\u0000~\u0000\u0004\u0003@\u00ee0sr\u0000\u0011java.lang.Boo"
+"lean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psq\u0000~\u0000\n\u0001\u00e9\u0003\u00e5ppsr\u0000\"com.sun.msv.datat"
+"ype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0011q\u0000~\u0000\u0017t\u0000\u0005QNameq\u0000~\u0000\u001bq\u0000~\u0000>sq\u0000"
+"~\u0000?q\u0000~\u0000Jq\u0000~\u0000\u0017sr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0014L\u0000\fnamespaceURIq\u0000~\u0000\u0014xr\u0000\u001dcom.sun.msv.gram"
+"mar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)http://www.w3.org/2001/X"
+"MLSchema-instancesr\u00000com.sun.msv.grammar.Expression$EpsilonE"
+"xpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004\u0000\u0000\u0000\tsq\u0000~\u0000E\u0001psq\u0000~\u0000Lt\u0000\ncourier_idt\u0000\u0000"
+"sr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTable"
+"t\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com."
+"sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005count"
+"I\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000X[\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/E"
+"xpression;xp\u0000\u0000\u0000\u0002\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar.Expression;\u00d68"
+"D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpppppppppppppppppppppppppppppppppppppppppppq\u0000"
+"~\u0000\tppppppppppppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000Bpp"
+"pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp"
+"pppppppppppppppppppppppppppppppppp"));
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
            return com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.CourierIdImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        if (("courier_id" == ___local)&&("" == ___uri)) {
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
                    case  3 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  2 :
                        if (("courier_id" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
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
                        case  3 :
                            revertToParentFromText(value);
                            return ;
                        case  1 :
                            eatText1(value);
                            state = 2;
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
                _Value = javax.xml.bind.DatatypeConverter.parseInt(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                has_Value = true;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}
