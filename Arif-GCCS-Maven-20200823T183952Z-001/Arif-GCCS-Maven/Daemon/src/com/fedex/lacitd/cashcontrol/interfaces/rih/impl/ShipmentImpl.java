//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2004.05.13 at 11:11:44 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.rih.impl;

public class ShipmentImpl
    extends com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl
    implements com.fedex.lacitd.cashcontrol.interfaces.rih.Shipment, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.UnmarshallableObject, com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.XMLSerializable, com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.ValidatableObject
{

    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.rih.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.fedex.lacitd.cashcontrol.interfaces.rih.Shipment.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "Shipment";
    }

    public com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.UnmarshallingContext context) {
        return new com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.Unmarshaller(context);
    }

    public void serializeBody(com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "Shipment");
        super.serializeURIs(context);
        context.endNamespaceDecls();
        super.serializeAttributes(context);
        context.endAttributes();
        super.serializeBody(context);
        context.endElement();
    }

    public void serializeAttributes(com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeURIs(com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.fedex.lacitd.cashcontrol.interfaces.rih.Shipment.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilon"
+"Reducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xp\u001a\u00e1\u00a8sp"
+"p\u0000sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun."
+"msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~"
+"\u0000\u0004\u001a\u00e1\u00a8hppsq\u0000~\u0000\u0007\u0019\r\u00dc\u00a0ppsq\u0000~\u0000\u0007\u0016t\u00ab\u00beppsq\u0000~\u0000\u0007\u00143\u00d8Gppsq\u0000~\u0000\u0007\u0010\n\u000fnppsq\u0000~"
+"\u0000\u0007\fc\u00e2\u009appsq\u0000~\u0000\u0007\t\u001d\u0092\u00b6ppsq\u0000~\u0000\u0007\u0006\u00a4\u0019\u001fppsq\u0000~\u0000\u0007\u0004\u0094U\u00d1ppsr\u0000\u001dcom.sun.msv."
+"grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\b\u0002`\u0087tppsq\u0000~\u0000\u0000\u0002`\u0087isr\u0000\u0011java.l"
+"ang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000p\u0000sq\u0000~\u0000\u0007\u0002`\u0087^ppsr\u0000\u001bcom.sun.m"
+"sv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/D"
+"atatype;L\u0000\u0006exceptq\u0000~\u0000\u0003L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair"
+";xq\u0000~\u0000\u0004\u0000Y\u00fb1ppsr\u0000#com.sun.msv.datatype.xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0001Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.datatype.xsd.BuiltinAtomi"
+"cType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002"
+"\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000 L\u0000\nwhi"
+"teSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000"
+" http://www.w3.org/2001/XMLSchemat\u0000\u0006stringsr\u00005com.sun.msv.da"
+"tatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.su"
+"n.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001sr\u00000com."
+"sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000"
+"\u0004\u0000\u0000\u0000\nppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNam"
+"eq\u0000~\u0000 L\u0000\fnamespaceURIq\u0000~\u0000 xpq\u0000~\u0000$q\u0000~\u0000#sq\u0000~\u0000\u0012\u0002\u0006\u008c(ppsr\u0000 com.su"
+"n.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0003L\u0000\tnameClass"
+"q\u0000~\u0000\u0001xq\u0000~\u0000\u0004\u0002\u0006\u008c\u001dq\u0000~\u0000\u0016psq\u0000~\u0000\u0018\u0001\u009f7Fppsr\u0000\"com.sun.msv.datatype.xs"
+"d.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001dq\u0000~\u0000#t\u0000\u0005QNamesr\u00005com.sun.msv.dat"
+"atype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000&q\u0000~\u0000)"
+"sq\u0000~\u0000*q\u0000~\u00002q\u0000~\u0000#sr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000 L\u0000\fnamespaceURIq\u0000~\u0000 xr\u0000\u001dcom.sun.msv.g"
+"rammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)http://www.w3.org/200"
+"1/XMLSchema-instancesr\u00000com.sun.msv.grammar.Expression$Epsil"
+"onExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004\u0000\u0000\u0000\tsq\u0000~\u0000\u0015\u0001psq\u0000~\u00006t\u0000\u0006awbNbrt\u0000\u0000q"
+"\u0000~\u0000<sq\u0000~\u0000\u0012\u00023\u00ceXppsq\u0000~\u0000\u0000\u00023\u00ceMq\u0000~\u0000\u0016p\u0000sq\u0000~\u0000\u0007\u00023\u00ceBppq\u0000~\u0000\u001bsq\u0000~\u0000\u0012\u0001\u00d9\u00d3\f"
+"ppsq\u0000~\u0000-\u0001\u00d9\u00d3\u0001q\u0000~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006q\u0000~\u00009q\u0000~\u0000:q\u0000~\u0000<sq\u0000~\u00006t\u0000\forigLoc"
+"ationq\u0000~\u0000@q\u0000~\u0000<sq\u0000~\u0000\u0012\u0002\u000f\u00c3Ippsq\u0000~\u0000\u0000\u0002\u000f\u00c3>q\u0000~\u0000\u0016p\u0000sq\u0000~\u0000\u0007\u0002\u000f\u00c33ppq\u0000~\u0000"
+"\u001bsq\u0000~\u0000\u0012\u0001\u00b5\u00c7\u00fdppsq\u0000~\u0000-\u0001\u00b5\u00c7\u00f2q\u0000~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006q\u0000~\u00009q\u0000~\u0000:q\u0000~\u0000<sq\u0000~\u0000"
+"6t\u0000\fdestLocationq\u0000~\u0000@q\u0000~\u0000<sq\u0000~\u0000\u0012\u0002yy\u0092ppsq\u0000~\u0000\u0000\u0002yy\u0087q\u0000~\u0000\u0016p\u0000sq\u0000~\u0000"
+"\u0007\u0002yy|ppq\u0000~\u0000\u001bsq\u0000~\u0000\u0012\u0002\u001f~Fppsq\u0000~\u0000-\u0002\u001f~;q\u0000~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006q\u0000~\u00009q\u0000~\u0000"
+":q\u0000~\u0000<sq\u0000~\u00006t\u0000\u0006shipDtq\u0000~\u0000@q\u0000~\u0000<sq\u0000~\u0000\u0012\u0003FO\u00dfppsq\u0000~\u0000\u0000\u0003FO\u00d4q\u0000~\u0000\u0016p\u0000"
+"sq\u0000~\u0000\u0007\u0003FO\u00c9ppq\u0000~\u0000\u001bsq\u0000~\u0000\u0012\u0002\u00ecT\u0093ppsq\u0000~\u0000-\u0002\u00ecT\u0088q\u0000~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006q\u0000~\u0000"
+"9q\u0000~\u0000:q\u0000~\u0000<sq\u0000~\u00006t\u0000\u000borigCountryq\u0000~\u0000@q\u0000~\u0000<sq\u0000~\u0000\u0012\u0003\u00a6,\u00cfppsq\u0000~\u0000\u0000\u0003"
+"\u00a6,\u00c4q\u0000~\u0000\u0016p\u0000sq\u0000~\u0000\u0007\u0003\u00a6,\u00b9ppq\u0000~\u0000\u001bsq\u0000~\u0000\u0012\u0003L1\u0083ppsq\u0000~\u0000-\u0003L1xq\u0000~\u0000\u0016pq\u0000~\u0000/"
+"sq\u0000~\u00006q\u0000~\u00009q\u0000~\u0000:q\u0000~\u0000<sq\u0000~\u00006t\u0000\u000bdestCountryq\u0000~\u0000@q\u0000~\u0000<sq\u0000~\u0000\u0012\u0004)\u00c8"
+"\u00d4ppsq\u0000~\u0000\u0000\u0004)\u00c8\u00c9q\u0000~\u0000\u0016p\u0000sq\u0000~\u0000\u0007\u0004)\u00c8\u00beppsq\u0000~\u0000\u0018\u0000\u00fd\u00b0\u001dppsr\u0000#com.sun.msv."
+"datatype.xsd.NumberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001dq\u0000~\u0000#t\u0000\u0007decimalq\u0000~\u00004"
+"q\u0000~\u0000)sq\u0000~\u0000*q\u0000~\u0000oq\u0000~\u0000#sq\u0000~\u0000\u0012\u0003,\u0018\u009cppsq\u0000~\u0000-\u0003,\u0018\u0091q\u0000~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006"
+"q\u0000~\u00009q\u0000~\u0000:q\u0000~\u0000<sq\u0000~\u00006t\u0000\u0010freightChargeAmtq\u0000~\u0000@q\u0000~\u0000<sq\u0000~\u0000\u0012\u0002@\u00d3r"
+"ppsq\u0000~\u0000\u0000\u0002@\u00d3gq\u0000~\u0000\u0016p\u0000sq\u0000~\u0000\u0007\u0002@\u00d3\\ppq\u0000~\u0000\u001bsq\u0000~\u0000\u0012\u0001\u00e6\u00d8&ppsq\u0000~\u0000-\u0001\u00e6\u00d8\u001bq\u0000"
+"~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006q\u0000~\u00009q\u0000~\u0000:q\u0000~\u0000<sq\u0000~\u00006t\u0000\u000eshipperCompanyq\u0000~\u0000@q\u0000"
+"~\u0000<sq\u0000~\u0000\u0012\u0002\u00990\u00ddppsq\u0000~\u0000\u0000\u0002\u00990\u00d2q\u0000~\u0000\u0016p\u0000sq\u0000~\u0000\u0007\u0002\u00990\u00c7ppq\u0000~\u0000\u001bsq\u0000~\u0000\u0012\u0002?5\u0091p"
+"psq\u0000~\u0000-\u0002?5\u0086q\u0000~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006q\u0000~\u00009q\u0000~\u0000:q\u0000~\u0000<sq\u0000~\u00006t\u0000\tshipperN"
+"mq\u0000~\u0000@q\u0000~\u0000<sq\u0000~\u0000\u0012\u0001\u00d3\u00cb\u00c3ppsq\u0000~\u0000-\u0001\u00d3\u00cb\u00b8q\u0000~\u0000\u0016pq\u0000~\u0000/sq\u0000~\u00006q\u0000~\u00009q\u0000~\u0000:"
+"q\u0000~\u0000<sq\u0000~\u00006t\u0000\bShipmentq\u0000~\u0000@sr\u0000\"com.sun.msv.grammar.Expressio"
+"nPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/Expressio"
+"nPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$Cl"
+"osedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000\u008c[\u0000\u0005tabl"
+"et\u0000![Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000%\u0000\u0000\u00009pur\u0000![Lcom.su"
+"n.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpppppppq\u0000~\u0000\u0081ppq\u0000~\u0000"
+"Sppppppq\u0000~\u0000Kpppppq\u0000~\u0000\rpppppq\u0000~\u0000\u0011ppq\u0000~\u0000Qppppppq\u0000~\u0000Ippppq\u0000~\u0000,q"
+"\u0000~\u0000ypq\u0000~\u0000Cppppppppppq\u0000~\u0000kppq\u0000~\u0000\tpppq\u0000~\u0000\u0086ppq\u0000~\u0000\u000bq\u0000~\u0000Apppq\u0000~\u0000\u0010"
+"pppppq\u0000~\u0000cq\u0000~\u0000ipq\u0000~\u0000\\ppppq\u0000~\u0000\u0080pppppppppppppq\u0000~\u0000appppppq\u0000~\u0000\u000eq"
+"\u0000~\u0000\fq\u0000~\u0000\u000fq\u0000~\u0000~pppppppppq\u0000~\u0000Tppq\u0000~\u0000\u0017q\u0000~\u0000xppq\u0000~\u0000Lppppppppppppp"
+"ppppq\u0000~\u0000\u0013q\u0000~\u0000qq\u0000~\u0000vpppppppppq\u0000~\u0000Dpppq\u0000~\u0000[ppppppppppppppppppp"
+"q\u0000~\u0000\npq\u0000~\u0000Ypppppq\u0000~\u0000d"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.UnmarshallingContext context) {
            super(context, "----");
        }

        protected Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.rih.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this;
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
                    case  0 :
                        if (("Shipment" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 1;
                            return ;
                        }
                        break;
                    case  1 :
                        if (("awbNbr" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("origLocation" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("destLocation" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("shipDt" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("origCountry" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("destCountry" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("freightChargeAmt" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("shipperCompany" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("shipperNm" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        spawnHandlerFromEnterElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname, __atts);
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
                        if (("Shipment" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  1 :
                        spawnHandlerFromLeaveElement((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                        spawnHandlerFromEnterAttribute((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                        spawnHandlerFromLeaveAttribute((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, ___uri, ___local, ___qname);
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
                            spawnHandlerFromText((((com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentTypeImpl)com.fedex.lacitd.cashcontrol.interfaces.rih.impl.ShipmentImpl.this).new Unmarshaller(context)), 2, value);
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
