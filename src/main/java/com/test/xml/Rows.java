package com.test.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rows")
public class Rows {

    private Row[] row;

    @XmlElement(name = "row")
    public Row[] getRow() {
        return row;
    }

    public void setRow(Row[] row) {
        this.row = row;
    }
}
