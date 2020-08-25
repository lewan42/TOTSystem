package com.test.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Row {
    @XmlAttribute(name = "BOARDID")
    private String BOARDID;

    @XmlAttribute(name = "TRADEDATE")
    private String TRADEDATE;

    @XmlAttribute(name = "SHORTNAME")
    private String SHORTNAME;

    @XmlAttribute(name = "SECID")
    private String SECID;

    @XmlAttribute(name = "NUMTRADES")
    private String NUMTRADES;

    @XmlAttribute(name = "VALUE")
    private String VALUE;

    @XmlAttribute(name = "OPEN")
    private String OPEN;

    @XmlAttribute(name = "LOW")
    private String LOW;

    @XmlAttribute(name = "HIGH")
    private String HIGH;

    @XmlAttribute(name = "LEGALCLOSEPRICE")
    private String LEGALCLOSEPRICE;

    @XmlAttribute(name = "WAPRICE")
    private String WAPRICE;

    @XmlAttribute(name = "CLOSE")
    private String CLOSE;

    @XmlAttribute(name = "VOLUME")
    private String VOLUME;

    @XmlAttribute(name = "MARKETPRICE2")
    private String MARKETPRICE2;

    @XmlAttribute(name = "MARKETPRICE3")
    private String MARKETPRICE3;

    @XmlAttribute(name = "ADMITTEDQUOTE")
    private String ADMITTEDQUOTE;

    @XmlAttribute(name = "MP2VALTRD")
    private String MP2VALTRD;

    @XmlAttribute(name = "MARKETPRICE3TRADESVALUE")
    private String MARKETPRICE3TRADESVALUE;

    @XmlAttribute(name = "ADMITTEDVALUE")
    private String ADMITTEDVALUE;

    @XmlAttribute(name = "WAVAL")
    private String WAVAL;

    @XmlAttribute(name = "id")
    private Long id;

    @XmlAttribute(name = "secid")
    private String secid;

    @XmlAttribute(name = "shortname")
    private String shortname;

    @XmlAttribute(name = "regnumber")
    private String regnumber;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "isin")
    private String isin;

    @XmlAttribute(name = "is_traded")
    private String is_traded;

    @XmlAttribute(name = "emitent_id")
    private String emitent_id;

    @XmlAttribute(name = "emitent_title")
    private String emitent_title;

    @XmlAttribute(name = "emitent_inn")
    private String emitent_inn;

    @XmlAttribute(name = "emitent_okpo")
    private String emitent_okpo;

    @XmlAttribute(name = "gosreg")
    private String gosreg;

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "group")
    private String group;

    @XmlAttribute(name = "primary_boardid")
    private String primary_boardid;

    @XmlAttribute(name = "marketprice_boardid")
    private String marketprice_boardid;

    public Row() {
    }

    @Override
    public String toString() {
        return "Row{" +
                "BOARDID='" + BOARDID + '\'' +
                ", TRADEDATE='" + TRADEDATE + '\'' +
                ", SHORTNAME='" + SHORTNAME + '\'' +
                ", SECID='" + SECID + '\'' +
                ", NUMTRADES='" + NUMTRADES + '\'' +
                ", VALUE='" + VALUE + '\'' +
                ", OPEN='" + OPEN + '\'' +
                ", LOW='" + LOW + '\'' +
                ", HIGH='" + HIGH + '\'' +
                ", LEGALCLOSEPRICE='" + LEGALCLOSEPRICE + '\'' +
                ", WAPRICE='" + WAPRICE + '\'' +
                ", CLOSE='" + CLOSE + '\'' +
                ", VOLUME='" + VOLUME + '\'' +
                ", MARKETPRICE2='" + MARKETPRICE2 + '\'' +
                ", MARKETPRICE3='" + MARKETPRICE3 + '\'' +
                ", ADMITTEDQUOTE='" + ADMITTEDQUOTE + '\'' +
                ", MP2VALTRD='" + MP2VALTRD + '\'' +
                ", MARKETPRICE3TRADESVALUE='" + MARKETPRICE3TRADESVALUE + '\'' +
                ", ADMITTEDVALUE='" + ADMITTEDVALUE + '\'' +
                ", WAVAL='" + WAVAL + '\'' +
                ", id=" + id +
                ", secid='" + secid + '\'' +
                ", shortname='" + shortname + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", is_traded='" + is_traded + '\'' +
                ", emitent_id='" + emitent_id + '\'' +
                ", emitent_title='" + emitent_title + '\'' +
                ", emitent_inn='" + emitent_inn + '\'' +
                ", emitent_okpo='" + emitent_okpo + '\'' +
                ", gosreg='" + gosreg + '\'' +
                ", type='" + type + '\'' +
                ", group='" + group + '\'' +
                ", primary_boardid='" + primary_boardid + '\'' +
                ", marketprice_boardid='" + marketprice_boardid + '\'' +
                '}';
    }

    public void setBOARDID(String BOARDID) {
        this.BOARDID = BOARDID;
    }

    public void setTRADEDATE(String TRADEDATE) {
        this.TRADEDATE = TRADEDATE;
    }

    public void setSHORTNAME(String SHORTNAME) {
        this.SHORTNAME = SHORTNAME;
    }

    public void setSECID(String SECID) {
        this.SECID = SECID;
    }

    public void setNUMTRADES(String NUMTRADES) {
        this.NUMTRADES = NUMTRADES;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    public void setOPEN(String OPEN) {
        this.OPEN = OPEN;
    }

    public void setLOW(String LOW) {
        this.LOW = LOW;
    }

    public void setHIGH(String HIGH) {
        this.HIGH = HIGH;
    }

    public void setLEGALCLOSEPRICE(String LEGALCLOSEPRICE) {
        this.LEGALCLOSEPRICE = LEGALCLOSEPRICE;
    }

    public void setWAPRICE(String WAPRICE) {
        this.WAPRICE = WAPRICE;
    }

    public void setCLOSE(String CLOSE) {
        this.CLOSE = CLOSE;
    }

    public void setVOLUME(String VOLUME) {
        this.VOLUME = VOLUME;
    }

    public void setMARKETPRICE2(String MARKETPRICE2) {
        this.MARKETPRICE2 = MARKETPRICE2;
    }

    public void setMARKETPRICE3(String MARKETPRICE3) {
        this.MARKETPRICE3 = MARKETPRICE3;
    }

    public void setADMITTEDQUOTE(String ADMITTEDQUOTE) {
        this.ADMITTEDQUOTE = ADMITTEDQUOTE;
    }

    public void setMP2VALTRD(String MP2VALTRD) {
        this.MP2VALTRD = MP2VALTRD;
    }

    public void setMARKETPRICE3TRADESVALUE(String MARKETPRICE3TRADESVALUE) {
        this.MARKETPRICE3TRADESVALUE = MARKETPRICE3TRADESVALUE;
    }

    public void setADMITTEDVALUE(String ADMITTEDVALUE) {
        this.ADMITTEDVALUE = ADMITTEDVALUE;
    }

    public void setWAVAL(String WAVAL) {
        this.WAVAL = WAVAL;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setIs_traded(String is_traded) {
        this.is_traded = is_traded;
    }

    public void setEmitent_id(String emitent_id) {
        this.emitent_id = emitent_id;
    }

    public void setEmitent_title(String emitent_title) {
        this.emitent_title = emitent_title;
    }

    public void setEmitent_inn(String emitent_inn) {
        this.emitent_inn = emitent_inn;
    }

    public void setEmitent_okpo(String emitent_okpo) {
        this.emitent_okpo = emitent_okpo;
    }

    public void setGosreg(String gosreg) {
        this.gosreg = gosreg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPrimary_boardid(String primary_boardid) {
        this.primary_boardid = primary_boardid;
    }

    public void setMarketprice_boardid(String marketprice_boardid) {
        this.marketprice_boardid = marketprice_boardid;
    }

    public String getBOARDID() {
        return BOARDID;
    }

    public String getTRADEDATE() {
        return TRADEDATE;
    }

    public String getSHORTNAME() {
        return SHORTNAME;
    }

    public String getSECID() {
        return SECID;
    }

    public String getNUMTRADES() {
        return NUMTRADES;
    }

    public String getVALUE() {
        return VALUE;
    }

    public String getOPEN() {
        return OPEN;
    }

    public String getLOW() {
        return LOW;
    }

    public String getHIGH() {
        return HIGH;
    }

    public String getLEGALCLOSEPRICE() {
        return LEGALCLOSEPRICE;
    }

    public String getWAPRICE() {
        return WAPRICE;
    }

    public String getCLOSE() {
        return CLOSE;
    }

    public String getVOLUME() {
        return VOLUME;
    }

    public String getMARKETPRICE2() {
        return MARKETPRICE2;
    }

    public String getMARKETPRICE3() {
        return MARKETPRICE3;
    }

    public String getADMITTEDQUOTE() {
        return ADMITTEDQUOTE;
    }

    public String getMP2VALTRD() {
        return MP2VALTRD;
    }

    public String getMARKETPRICE3TRADESVALUE() {
        return MARKETPRICE3TRADESVALUE;
    }

    public String getADMITTEDVALUE() {
        return ADMITTEDVALUE;
    }

    public String getWAVAL() {
        return WAVAL;
    }

    public Long getId() {
        return id;
    }

    public String getSecid() {
        return secid;
    }

    public String getShortname() {
        return shortname;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public String getName() {
        return name;
    }

    public String getIsin() {
        return isin;
    }

    public String getIs_traded() {
        return is_traded;
    }

    public String getEmitent_id() {
        return emitent_id;
    }

    public String getEmitent_title() {
        return emitent_title;
    }

    public String getEmitent_inn() {
        return emitent_inn;
    }

    public String getEmitent_okpo() {
        return emitent_okpo;
    }

    public String getGosreg() {
        return gosreg;
    }

    public String getType() {
        return type;
    }

    public String getGroup() {
        return group;
    }

    public String getPrimary_boardid() {
        return primary_boardid;
    }

    public String getMarketprice_boardid() {
        return marketprice_boardid;
    }
}