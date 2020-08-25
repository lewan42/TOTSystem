package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.xml.Row;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Transactional
@Entity
@Table(name = "informationSecurities", uniqueConstraints = {@UniqueConstraint(columnNames = "_secid")})
public class InformationSecurities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_secid")
    private String secid;

    @JsonIgnore
    @OneToMany(mappedBy = "is", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TradingHistory> th = new ArrayList<>();

    @Column(name = "_shortname")
    private String shortname;

    @Column(name = "_regnumber")
    private String regnumber;

    @Column(name = "_name")
    private String name;

    @Column(name = "_isin")
    private String isin;

    @Column(name = "_is_traded")
    private int is_traded;

    @Column(name = "_emitent_id")
    private int emitent_id;

    @Column(name = "_emitent_title")
    private String emitent_title;

    @Column(name = "_emitent_inn")
    private String emitent_inn;

    @Column(name = "_emitent_okpo")
    private String emitent_okpo;

    @Column(name = "_gosreg")
    private String gosreg;

    @Column(name = "_type")
    private String type;

    @Column(name = "_group")
    private String group;

    @Column(name = "_primary_boardid")
    private String primary_boardid;

    @Column(name = "_marketprice_boardid")
    private String marketprice_boardid;


    public InformationSecurities(Long id, String secid, String shortname, String regnumber, String name, String isin, int is_traded, int emitent_id, String emitent_title, String emitent_inn, String emitent_okpo, String gosreg, String type, String group, String primary_boardid, String marketprice_boardid) {
        this.id = id;
        this.secid = secid;
        this.shortname = shortname;
        this.regnumber = regnumber;
        this.name = name;
        this.isin = isin;
        this.is_traded = is_traded;
        this.emitent_id = emitent_id;
        this.emitent_title = emitent_title;
        this.emitent_inn = emitent_inn;
        this.emitent_okpo = emitent_okpo;
        this.gosreg = gosreg;
        this.type = type;
        this.group = group;
        this.primary_boardid = primary_boardid;
        this.marketprice_boardid = marketprice_boardid;
    }

    public InformationSecurities(Long id, String secid, String shortname, String regnumber, String name, String isin, String is_traded, String emitent_id, String emitent_title, String emitent_inn, String emitent_okpo, String gosreg, String type, String group, String primary_boardid, String marketprice_boardid) {
        this.id = id;
        this.secid = secid;
        this.shortname = shortname;
        this.regnumber = regnumber;
        this.name = name;
        this.isin = isin;
        this.is_traded = Integer.parseInt(is_traded);
        this.emitent_id = Integer.parseInt(emitent_id);
        this.emitent_title = emitent_title;
        this.emitent_inn = emitent_inn;
        this.emitent_okpo = emitent_okpo;
        this.gosreg = gosreg;
        this.type = type;
        this.group = group;
        this.primary_boardid = primary_boardid;
        this.marketprice_boardid = marketprice_boardid;
    }


    public InformationSecurities(Row row) {
        this.id = row.getId();
        this.secid = row.getSecid();
        this.shortname = row.getShortname();
        this.regnumber = row.getRegnumber();
        this.name = row.getName();
        this.isin = row.getIsin();
        this.is_traded = Integer.parseInt(row.getIs_traded());
        this.emitent_id = Integer.parseInt(row.getEmitent_id());
        this.emitent_title = row.getEmitent_title();
        this.emitent_inn = row.getEmitent_inn();
        this.emitent_okpo = row.getEmitent_okpo();
        this.gosreg = row.getGosreg();
        this.type = row.getType();
        this.group = row.getGroup();
        this.primary_boardid = row.getPrimary_boardid();
        this.marketprice_boardid = row.getMarketprice_boardid();
    }

    public InformationSecurities() {
    }

    public InformationSecurities(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public int getIs_traded() {
        return is_traded;
    }

    public void setIs_traded(int is_traded) {
        this.is_traded = is_traded;
    }

    public int getEmitent_id() {
        return emitent_id;
    }

    public void setEmitent_id(int emitent_id) {
        this.emitent_id = emitent_id;
    }

    public String getEmitent_title() {
        return emitent_title;
    }

    public void setEmitent_title(String emitent_title) {
        this.emitent_title = emitent_title;
    }

    public String getEmitent_inn() {
        return emitent_inn;
    }

    public void setEmitent_inn(String emitent_inn) {
        this.emitent_inn = emitent_inn;
    }

    public String getEmitent_okpo() {
        return emitent_okpo;
    }

    public void setEmitent_okpo(String emitent_okpo) {
        this.emitent_okpo = emitent_okpo;
    }

    public String getGosreg() {
        return gosreg;
    }

    public void setGosreg(String gosreg) {
        this.gosreg = gosreg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPrimary_boardid() {
        return primary_boardid;
    }

    public void setPrimary_boardid(String primary_boardid) {
        this.primary_boardid = primary_boardid;
    }

    public String getMarketprice_boardid() {
        return marketprice_boardid;
    }

    public void setMarketprice_boardid(String marketprice_boardid) {
        this.marketprice_boardid = marketprice_boardid;
    }

    @Transactional
    public List<TradingHistory> getTh() {
        return th;
    }


    public void setTh(TradingHistory th) {
        if (this.th == null) this.th = new ArrayList<>(Collections.singletonList(th));
        else {
            this.th.add(th);
        }
    }

    @Override
    public String toString() {
        return "InformationSecurities{" +
                "id=" + id +
                ", secid='" + secid + '\'' +
//                ", th=" + th +
                ", shortname='" + shortname + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", is_traded=" + is_traded +
                ", emitent_id=" + emitent_id +
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
}
