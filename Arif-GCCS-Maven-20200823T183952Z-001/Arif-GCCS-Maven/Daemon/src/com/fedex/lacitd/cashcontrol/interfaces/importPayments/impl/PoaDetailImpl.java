//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.02 at 12:04:00 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl;

public class PoaDetailImpl
    extends com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl
    implements com.fedex.lacitd.cashcontrol.interfaces.importPayments.PoaDetail, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallableObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializable, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.ValidatableObject
{

    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.PoaDetail.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "poa_detail";
    }

    public com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingContext context) {
        return new com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.Unmarshaller(context);
    }

    public void serializeBody(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "poa_detail");
        super.serializeURIs(context);
        context.endNamespaceDecls();
        super.serializeAttributes(context);
        context.endAttributes();
        super.serializeBody(context);
        context.endElement();
    }

    public void serializeAttributes(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeURIs(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.PoaDetail.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilon"
+"Reducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xp\u0013M1\u0007p"
+"p\u0000sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun."
+"msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~"
+"\u0000\u0004\u0013M0\u00fcppsq\u0000~\u0000\u0007\u000f\u0082\u00fd\u0099ppsq\u0000~\u0000\u0007\rkpzppsq\u0000~\u0000\u0007\t\u00a7\u00002ppsr\u0000\u001dcom.sun.msv."
+"grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\b\u0004.\u00cb\u00e3ppsq\u0000~\u0000\u0000\u0004.\u00cb\u00d8sr\u0000\u0011java.l"
+"ang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000p\u0000sq\u0000~\u0000\u0007\u0004.\u00cb\u00cdppsr\u0000\u001bcom.sun.m"
+"sv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/D"
+"atatype;L\u0000\u0006exceptq\u0000~\u0000\u0003L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair"
+";xq\u0000~\u0000\u0004\u0001>\n\u00cappsr\u0000#com.sun.msv.datatype.xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0001Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.datatype.xsd.BuiltinAtomi"
+"cType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002"
+"\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000\u001bL\u0000\nwhi"
+"teSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000"
+" http://www.w3.org/2001/XMLSchemat\u0000\u0006stringsr\u00005com.sun.msv.da"
+"tatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.su"
+"n.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001sr\u00000com."
+"sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000"
+"\u0004\u0000\u0000\u0000\nppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNam"
+"eq\u0000~\u0000\u001bL\u0000\fnamespaceURIq\u0000~\u0000\u001bxpq\u0000~\u0000\u001fq\u0000~\u0000\u001esq\u0000~\u0000\r\u0002\u00f0\u00c0\u00feppsr\u0000 com.su"
+"n.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0003L\u0000\tnameClass"
+"q\u0000~\u0000\u0001xq\u0000~\u0000\u0004\u0002\u00f0\u00c0\u00f3q\u0000~\u0000\u0011psq\u0000~\u0000\u0013\u0001\u00e9\u0003\u00e5ppsr\u0000\"com.sun.msv.datatype.xs"
+"d.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0018q\u0000~\u0000\u001et\u0000\u0005QNamesr\u00005com.sun.msv.dat"
+"atype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000!q\u0000~\u0000$"
+"sq\u0000~\u0000%q\u0000~\u0000-q\u0000~\u0000\u001esr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u001bL\u0000\fnamespaceURIq\u0000~\u0000\u001bxr\u0000\u001dcom.sun.msv.g"
+"rammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)http://www.w3.org/200"
+"1/XMLSchema-instancesr\u00000com.sun.msv.grammar.Expression$Epsil"
+"onExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004\u0000\u0000\u0000\tsq\u0000~\u0000\u0010\u0001psq\u0000~\u00001t\u0000\u0007inv_nbrt\u0000\u0000"
+"q\u0000~\u00007sq\u0000~\u0000\r\u0005x4Jppsq\u0000~\u0000\u0000\u0005x4?q\u0000~\u0000\u0011p\u0000sq\u0000~\u0000\u0007\u0005x44ppsq\u0000~\u0000\u0013\u0001\u00d8\u00c58ppsr"
+"\u0000#com.sun.msv.datatype.xsd.NumberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0018q\u0000~\u0000\u001et"
+"\u0000\u0007decimalq\u0000~\u0000/q\u0000~\u0000$sq\u0000~\u0000%q\u0000~\u0000Bq\u0000~\u0000\u001esq\u0000~\u0000\r\u0003\u009fn\u00f7ppsq\u0000~\u0000(\u0003\u009fn\u00ecq\u0000~"
+"\u0000\u0011pq\u0000~\u0000*sq\u0000~\u00001q\u0000~\u00004q\u0000~\u00005q\u0000~\u00007sq\u0000~\u00001t\u0000\u0007inv_amtq\u0000~\u0000;q\u0000~\u00007sq\u0000~\u0000"
+"\r\u0003\u00c4pCppsq\u0000~\u0000\u0000\u0003\u00c4p8q\u0000~\u0000\u0011p\u0000sq\u0000~\u0000\u0007\u0003\u00c4p-ppq\u0000~\u0000?sq\u0000~\u0000\r\u0001\u00eb\u00aa\u00f0ppsq\u0000~\u0000(\u0001"
+"\u00eb\u00aa\u00e5q\u0000~\u0000\u0011pq\u0000~\u0000*sq\u0000~\u00001q\u0000~\u00004q\u0000~\u00005q\u0000~\u00007sq\u0000~\u00001t\u0000\u000einv_coupon_amtq\u0000"
+"~\u0000;q\u0000~\u00007sq\u0000~\u0000\r\u0002\u0017\u008d\u001appsq\u0000~\u0000(\u0002\u0017\u008d\u000fq\u0000~\u0000\u0011psq\u0000~\u0000\u0013\u0001\u00a6h_ppsr\u0000 com.sun."
+"msv.datatype.xsd.IntType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com.sun.msv.datatype."
+"xsd.IntegerDerivedType\u0099\u00f1]\u0090&6k\u00be\u0002\u0000\u0001L\u0000\nbaseFacetst\u0000)Lcom/sun/ms"
+"v/datatype/xsd/XSDatatypeImpl;xq\u0000~\u0000\u0018q\u0000~\u0000\u001et\u0000\u0003intq\u0000~\u0000/sr\u0000*com."
+"sun.msv.datatype.xsd.MaxInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun"
+".msv.datatype.xsd.RangeFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\nlimitValuet\u0000\u0012Ljava"
+"/lang/Object;xr\u00009com.sun.msv.datatype.xsd.DataTypeWithValueC"
+"onstraintFacet\"\u00a7Ro\u00ca\u00c7\u008aT\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.DataTy"
+"peWithFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacetFixedZ\u0000\u0012needValueCheckFlagL\u0000"
+"\bbaseTypeq\u0000~\u0000VL\u0000\fconcreteTypet\u0000\'Lcom/sun/msv/datatype/xsd/Co"
+"ncreteType;L\u0000\tfacetNameq\u0000~\u0000\u001bxq\u0000~\u0000\u001appq\u0000~\u0000/\u0000\u0001sr\u0000*com.sun.msv.d"
+"atatype.xsd.MinInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Zppq\u0000~\u0000/\u0000\u0000sr\u0000!c"
+"om.sun.msv.datatype.xsd.LongType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Uq\u0000~\u0000\u001et\u0000\u0004lon"
+"gq\u0000~\u0000/sq\u0000~\u0000Yppq\u0000~\u0000/\u0000\u0001sq\u0000~\u0000`ppq\u0000~\u0000/\u0000\u0000sr\u0000$com.sun.msv.datatype"
+".xsd.IntegerType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Uq\u0000~\u0000\u001et\u0000\u0007integerq\u0000~\u0000/sr\u0000,com"
+".sun.msv.datatype.xsd.FractionDigitsFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\u0005scale"
+"xr\u0000;com.sun.msv.datatype.xsd.DataTypeWithLexicalConstraintFa"
+"cetT\u0090\u001c>\u001azb\u00ea\u0002\u0000\u0000xq\u0000~\u0000]ppq\u0000~\u0000/\u0001\u0000q\u0000~\u0000Aq\u0000~\u0000At\u0000\u000efractionDigits\u0000\u0000\u0000\u0000"
+"q\u0000~\u0000ht\u0000\fminInclusivesr\u0000\u000ejava.lang.Long;\u008b\u00e4\u0090\u00cc\u008f#\u00df\u0002\u0000\u0001J\u0000\u0005valuexr\u0000"
+"\u0010java.lang.Number\u0086\u00ac\u0095\u001d\u000b\u0094\u00e0\u008b\u0002\u0000\u0000xp\u0080\u0000\u0000\u0000\u0000\u0000\u0000\u0000q\u0000~\u0000ht\u0000\fmaxInclusivesq"
+"\u0000~\u0000o\u007f\u00ff\u00ff\u00ff\u00ff\u00ff\u00ff\u00ffq\u0000~\u0000cq\u0000~\u0000nsr\u0000\u0011java.lang.Integer\u0012\u00e2\u00a0\u00a4\u00f7\u0081\u00878\u0002\u0000\u0001I\u0000\u0005val"
+"uexq\u0000~\u0000p\u0080\u0000\u0000\u0000q\u0000~\u0000cq\u0000~\u0000rsq\u0000~\u0000t\u007f\u00ff\u00ff\u00ffq\u0000~\u0000$sq\u0000~\u0000%q\u0000~\u0000Xq\u0000~\u0000\u001esq\u0000~\u00001t"
+"\u0000\u0003numq\u0000~\u0000;q\u0000~\u00007sq\u0000~\u0000\r\u0003\u00ca3^ppsq\u0000~\u0000(\u0003\u00ca3Sq\u0000~\u0000\u0011pq\u0000~\u0000*sq\u0000~\u00001q\u0000~\u00004q"
+"\u0000~\u00005q\u0000~\u00007sq\u0000~\u00001t\u0000\npoa_detailq\u0000~\u0000;sr\u0000\"com.sun.msv.grammar.Exp"
+"ressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/Exp"
+"ressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionP"
+"ool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000\u0080["
+"\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\u000f\u0000\u0000\u00009pur\u0000![L"
+"com.sun.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpq\u0000~\u0000\u0012pppppp"
+"pppppppppppppppq\u0000~\u0000\u000epppppppppppppppppppq\u0000~\u0000\'pq\u0000~\u0000Lpppppppppp"
+"ppppppppppppq\u0000~\u0000Dppppppq\u0000~\u0000\u000bpppppppq\u0000~\u0000Kpppppppppppppppppppp"
+"q\u0000~\u0000Qq\u0000~\u0000Iq\u0000~\u0000>ppppppppppppppppq\u0000~\u0000\tpq\u0000~\u0000zppq\u0000~\u0000<ppppppppppp"
+"ppppppppppppppppq\u0000~\u0000\fpppppppppppppppppppppppppppq\u0000~\u0000\npppppp"));
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
            return com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  3 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  1 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("inv_nbr" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("inv_amt" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("inv_coupon_amt" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                        return ;
                    case  0 :
                        if (("poa_detail" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 1;
                            return ;
                        }
                        break;
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
                        if (("poa_detail" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  1 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        spawnHandlerFromLeaveElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                    case  1 :
                        if (("num" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterAttribute((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
                            return ;
                        }
                        spawnHandlerFromEnterAttribute((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                    case  1 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        spawnHandlerFromLeaveAttribute((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                            attIdx = context.getAttribute("", "num");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            spawnHandlerFromText((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.PoaDetailImpl.this).new Unmarshaller(context)), 2, value);
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}