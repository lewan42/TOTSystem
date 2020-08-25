package com.test.xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "data")

public class Data {

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "rows")
    private Rows rows;

    public Data() { }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", rows=" + rows +
                '}';
    }

    public String getId() {
        return id;
    }

    public Rows getRows() {
        return rows;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRows(Rows rows) {
        this.rows = rows;
    }
}
