//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.02 at 12:04:00 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl;

public class OacPaymentImpl
    extends com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl
    implements com.fedex.lacitd.cashcontrol.interfaces.importPayments.OacPayment, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallableObject, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializable, com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.ValidatableObject
{

    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.OacPayment.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "oac_payment";
    }

    public com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.UnmarshallingContext context) {
        return new com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.Unmarshaller(context);
    }

    public void serializeBody(com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "oac_payment");
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
        return (com.fedex.lacitd.cashcontrol.interfaces.importPayments.OacPayment.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilon"
+"Reducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xp#\u00ea\u00b5\u00b7p"
+"p\u0000sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun."
+"msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~"
+"\u0000\u0004#\u00ea\u00b5\u00acppsq\u0000~\u0000\u0007!A\u0093\u001dppsq\u0000~\u0000\u0007 \u007f\u00c6\u00aappsq\u0000~\u0000\u0007\u001bf\u00eb\u00d9ppsq\u0000~\u0000\u0007\u0017\u0000#\"ppsq\u0000~"
+"\u0000\u0007\u0012\u00f9\u00e7\u000fppsq\u0000~\u0000\u0007\r\u00f2$\u008dppsq\u0000~\u0000\u0007\t\u00da\u00e2\u0011ppsr\u0000\u001dcom.sun.msv.grammar.Choi"
+"ceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\b\u0004g\u000b9ppsq\u0000~\u0000\u0000\u0004g\u000b.sr\u0000\u0011java.lang.Boolean\u00cd"
+" r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000p\u0000sq\u0000~\u0000\u0007\u0004g\u000b#ppsr\u0000\u001bcom.sun.msv.grammar.D"
+"ataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datatype;L\u0000\u0006e"
+"xceptq\u0000~\u0000\u0003L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0004\u0001M\u00d7hp"
+"psr\u0000!com.sun.msv.datatype.xsd.DateType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000)com.sun"
+".msv.datatype.xsd.DateTimeBaseType\u0014W\u001a@3\u00a5\u00b4\u00e5\u0002\u0000\u0000xr\u0000*com.sun.msv"
+".datatype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.da"
+"tatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.x"
+"sd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/Str"
+"ing;L\u0000\btypeNameq\u0000~\u0000 L\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xs"
+"d/WhiteSpaceProcessor;xpt\u0000 http://www.w3.org/2001/XMLSchemat"
+"\u0000\u0004datesr\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Colla"
+"pse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcess"
+"or\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$NullSetExp"
+"ression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004\u0000\u0000\u0000\nppsr\u0000\u001bcom.sun.msv.util.StringPai"
+"r\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000 L\u0000\fnamespaceURIq\u0000~\u0000 xpq\u0000~\u0000$q\u0000~\u0000"
+"#sq\u0000~\u0000\u0011\u0003\u00193\u00b6ppsr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002"
+"L\u0000\u0003expq\u0000~\u0000\u0003L\u0000\tnameClassq\u0000~\u0000\u0001xq\u0000~\u0000\u0004\u0003\u00193\u00abq\u0000~\u0000\u0015psq\u0000~\u0000\u0017\u0001\u00e9\u0003\u00e5ppsr\u0000\""
+"com.sun.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001dq\u0000~\u0000#t\u0000\u0005Q"
+"Nameq\u0000~\u0000\'q\u0000~\u0000)sq\u0000~\u0000*q\u0000~\u00002q\u0000~\u0000#sr\u0000#com.sun.msv.grammar.Simple"
+"NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000 L\u0000\fnamespaceURIq\u0000~\u0000 xr\u0000"
+"\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)http://"
+"www.w3.org/2001/XMLSchema-instancesr\u00000com.sun.msv.grammar.Ex"
+"pression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004\u0000\u0000\u0000\tsq\u0000~\u0000\u0014\u0001psq\u0000~\u0000"
+"4t\u0000\u0006oac_dtt\u0000\u0000q\u0000~\u0000:sq\u0000~\u0000\u0011\u0005s\u00d6\u00d3ppsq\u0000~\u0000\u0000\u0005s\u00d6\u00c8q\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0007\u0005s\u00d6\u00bdpps"
+"q\u0000~\u0000\u0017\u0001\u00a6h_ppsr\u0000 com.sun.msv.datatype.xsd.IntType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr"
+"\u0000+com.sun.msv.datatype.xsd.IntegerDerivedType\u0099\u00f1]\u0090&6k\u00be\u0002\u0000\u0001L\u0000\nb"
+"aseFacetst\u0000)Lcom/sun/msv/datatype/xsd/XSDatatypeImpl;xq\u0000~\u0000\u001dq"
+"\u0000~\u0000#t\u0000\u0003intq\u0000~\u0000\'sr\u0000*com.sun.msv.datatype.xsd.MaxInclusiveFace"
+"t\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun.msv.datatype.xsd.RangeFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002"
+"\u0000\u0001L\u0000\nlimitValuet\u0000\u0012Ljava/lang/Object;xr\u00009com.sun.msv.datatype"
+".xsd.DataTypeWithValueConstraintFacet\"\u00a7Ro\u00ca\u00c7\u008aT\u0002\u0000\u0000xr\u0000*com.sun."
+"msv.datatype.xsd.DataTypeWithFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacetFixed"
+"Z\u0000\u0012needValueCheckFlagL\u0000\bbaseTypeq\u0000~\u0000EL\u0000\fconcreteTypet\u0000\'Lcom/"
+"sun/msv/datatype/xsd/ConcreteType;L\u0000\tfacetNameq\u0000~\u0000 xq\u0000~\u0000\u001fppq"
+"\u0000~\u0000\'\u0000\u0001sr\u0000*com.sun.msv.datatype.xsd.MinInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0000xq\u0000~\u0000Ippq\u0000~\u0000\'\u0000\u0000sr\u0000!com.sun.msv.datatype.xsd.LongType\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Dq\u0000~\u0000#t\u0000\u0004longq\u0000~\u0000\'sq\u0000~\u0000Hppq\u0000~\u0000\'\u0000\u0001sq\u0000~\u0000Oppq\u0000~\u0000\'\u0000\u0000s"
+"r\u0000$com.sun.msv.datatype.xsd.IntegerType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Dq\u0000~\u0000"
+"#t\u0000\u0007integerq\u0000~\u0000\'sr\u0000,com.sun.msv.datatype.xsd.FractionDigitsF"
+"acet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\u0005scalexr\u0000;com.sun.msv.datatype.xsd.DataType"
+"WithLexicalConstraintFacetT\u0090\u001c>\u001azb\u00ea\u0002\u0000\u0000xq\u0000~\u0000Lppq\u0000~\u0000\'\u0001\u0000sr\u0000#com."
+"sun.msv.datatype.xsd.NumberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001dq\u0000~\u0000#t\u0000\u0007deci"
+"malq\u0000~\u0000\'q\u0000~\u0000]t\u0000\u000efractionDigits\u0000\u0000\u0000\u0000q\u0000~\u0000Wt\u0000\fminInclusivesr\u0000\u000eja"
+"va.lang.Long;\u008b\u00e4\u0090\u00cc\u008f#\u00df\u0002\u0000\u0001J\u0000\u0005valuexr\u0000\u0010java.lang.Number\u0086\u00ac\u0095\u001d\u000b\u0094\u00e0\u008b\u0002"
+"\u0000\u0000xp\u0080\u0000\u0000\u0000\u0000\u0000\u0000\u0000q\u0000~\u0000Wt\u0000\fmaxInclusivesq\u0000~\u0000a\u007f\u00ff\u00ff\u00ff\u00ff\u00ff\u00ff\u00ffq\u0000~\u0000Rq\u0000~\u0000`sr\u0000\u0011"
+"java.lang.Integer\u0012\u00e2\u00a0\u00a4\u00f7\u0081\u00878\u0002\u0000\u0001I\u0000\u0005valuexq\u0000~\u0000b\u0080\u0000\u0000\u0000q\u0000~\u0000Rq\u0000~\u0000dsq\u0000~"
+"\u0000f\u007f\u00ff\u00ff\u00ffq\u0000~\u0000)sq\u0000~\u0000*q\u0000~\u0000Gq\u0000~\u0000#sq\u0000~\u0000\u0011\u0003\u00cdnYppsq\u0000~\u0000-\u0003\u00cdnNq\u0000~\u0000\u0015pq\u0000~\u0000/"
+"sq\u0000~\u00004q\u0000~\u00007q\u0000~\u00008q\u0000~\u0000:sq\u0000~\u00004t\u0000\ncourier_idq\u0000~\u0000>q\u0000~\u0000:sq\u0000~\u0000\u0011\u0004\u0017Bw"
+"ppsq\u0000~\u0000\u0000\u0004\u0017Blq\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0007\u0004\u0017Bappq\u0000~\u0000\u001asq\u0000~\u0000\u0011\u0002\u00c9j\u00f4ppsq\u0000~\u0000-\u0002\u00c9j\u00e9q\u0000"
+"~\u0000\u0015pq\u0000~\u0000/sq\u0000~\u00004q\u0000~\u00007q\u0000~\u00008q\u0000~\u0000:sq\u0000~\u00004t\u0000\u0007pymt_dtq\u0000~\u0000>q\u0000~\u0000:sq\u0000~"
+"\u0000\u0011\u0005\u0007\u00c2}ppsq\u0000~\u0000\u0000\u0005\u0007\u00c2rq\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0007\u0005\u0007\u00c2gppsq\u0000~\u0000\u0017\u0001\u00d8\u00c58ppq\u0000~\u0000]q\u0000~\u0000)s"
+"q\u0000~\u0000*q\u0000~\u0000^q\u0000~\u0000#sq\u0000~\u0000\u0011\u0003.\u00fd*ppsq\u0000~\u0000-\u0003.\u00fd\u001fq\u0000~\u0000\u0015pq\u0000~\u0000/sq\u0000~\u00004q\u0000~\u00007q"
+"\u0000~\u00008q\u0000~\u0000:sq\u0000~\u00004t\u0000\fpymt_doc_amtq\u0000~\u0000>q\u0000~\u0000:sq\u0000~\u0000\u0011\u0004\u0006<\u000eppsq\u0000~\u0000\u0000\u0004\u0006"
+"<\u0003q\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0007\u0004\u0006;\u00f8ppsq\u0000~\u0000\u0017\u0001>\n\u00cappsr\u0000#com.sun.msv.datatype.xs"
+"d.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxq\u0000~\u0000\u001dq\u0000~\u0000#t\u0000\u0006strings"
+"r\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000&\u0001q\u0000~\u0000)sq\u0000~\u0000*q\u0000~\u0000\u0087q\u0000~\u0000#sq\u0000~\u0000\u0011\u0002\u00c81)ppsq\u0000~\u0000-\u0002\u00c81\u001eq\u0000~"
+"\u0000\u0015pq\u0000~\u0000/sq\u0000~\u00004q\u0000~\u00007q\u0000~\u00008q\u0000~\u0000:sq\u0000~\u00004t\u0000\fpymt_doc_nbrq\u0000~\u0000>q\u0000~\u0000:"
+"sq\u0000~\u0000\u0011\u0004f\u00c8\u00b2ppsq\u0000~\u0000\u0000\u0004f\u00c8\u00a7q\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0007\u0004f\u00c8\u009cppq\u0000~\u0000Bsq\u0000~\u0000\u0011\u0002\u00c0`8ppsq"
+"\u0000~\u0000-\u0002\u00c0`-q\u0000~\u0000\u0015pq\u0000~\u0000/sq\u0000~\u00004q\u0000~\u00007q\u0000~\u00008q\u0000~\u0000:sq\u0000~\u00004t\u0000\rpymt_doc_ty"
+"peq\u0000~\u0000>q\u0000~\u0000:sq\u0000~\u0000\u0011\u0005\u0018\u00da\u00ccppsq\u0000~\u0000\u0000\u0005\u0018\u00da\u00c1q\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0007\u0005\u0018\u00da\u00b6ppq\u0000~\u0000\u0084sq"
+"\u0000~\u0000\u0011\u0003\u00da\u00cf\u00e7ppsq\u0000~\u0000-\u0003\u00da\u00cf\u00dcq\u0000~\u0000\u0015pq\u0000~\u0000/sq\u0000~\u00004q\u0000~\u00007q\u0000~\u00008q\u0000~\u0000:sq\u0000~\u00004t\u0000"
+"\fpymt_curr_cdq\u0000~\u0000>q\u0000~\u0000:sq\u0000~\u0000\u0011\u0000\u00c1\u00ccnppsq\u0000~\u0000-\u0000\u00c1\u00cccq\u0000~\u0000\u0015psq\u0000~\u0000\u0017\u0000q}"
+"\u00a1ppsr\u0000$com.sun.msv.datatype.xsd.BooleanType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001d"
+"q\u0000~\u0000#t\u0000\u0007booleanq\u0000~\u0000\'q\u0000~\u0000)sq\u0000~\u0000*q\u0000~\u0000\u00a5q\u0000~\u0000#sq\u0000~\u00004t\u0000\u0003numq\u0000~\u0000>q\u0000"
+"~\u0000:sq\u0000~\u0000\u0011\u0002\u00a9\"\u008appsq\u0000~\u0000-\u0002\u00a9\"\u007fq\u0000~\u0000\u0015pq\u0000~\u0000/sq\u0000~\u00004q\u0000~\u00007q\u0000~\u00008q\u0000~\u0000:sq\u0000"
+"~\u00004t\u0000\u000boac_paymentq\u0000~\u0000>sr\u0000\"com.sun.msv.grammar.ExpressionPool"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool"
+"$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedH"
+"ash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000\u00af[\u0000\u0005tablet\u0000!["
+"Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\u001f\u0000\u0000\u00009pur\u0000![Lcom.sun.msv"
+".grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpppppppq\u0000~\u0000\u000bpq\u0000~\u0000qpppq\u0000"
+"~\u0000jppppppppq\u0000~\u0000\rppppppppq\u0000~\u0000oq\u0000~\u0000\u009apppppppq\u0000~\u0000rpppppq\u0000~\u0000\u00a0pppp"
+"pppq\u0000~\u0000\u0098ppq\u0000~\u0000\u00a9q\u0000~\u0000\nppppppq\u0000~\u0000|ppppppppq\u0000~\u0000\u009bpppq\u0000~\u0000\u0083pppppppp"
+"pppq\u0000~\u0000\u0092pppppppppq\u0000~\u0000\u0081ppq\u0000~\u0000yppppq\u0000~\u0000\u000epppq\u0000~\u0000\u0090pppppppq\u0000~\u0000\u008bq\u0000"
+"~\u0000\tq\u0000~\u0000\u0016ppq\u0000~\u0000wpppppppq\u0000~\u0000\u0010pppppq\u0000~\u0000\fpq\u0000~\u0000\u0093ppq\u0000~\u0000\u0012ppppppppq\u0000"
+"~\u0000,q\u0000~\u0000Appppppppppppppq\u0000~\u0000\u000fpppppq\u0000~\u0000?ppppppppppppppp"));
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
            return com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        if (("oac_payment" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 1;
                            return ;
                        }
                        break;
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
                        if (("oac_dt" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("courier_id" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("pymt_dt" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("pymt_doc_amt" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("pymt_doc_nbr" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("pymt_doc_type" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("pymt_curr_cd" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
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
                        if (("oac_payment" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  3 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  1 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        spawnHandlerFromLeaveElement((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                            spawnHandlerFromEnterAttribute((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
                            return ;
                        }
                        spawnHandlerFromEnterAttribute((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                        spawnHandlerFromLeaveAttribute((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                            spawnHandlerFromText((((com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.importPayments.impl.OacPaymentImpl.this).new Unmarshaller(context)), 2, value);
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
