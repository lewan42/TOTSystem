package com.test.xml;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "document")
public class FileXML {

    public FileXML() {
    }

    @XmlElement(name = "data")
    private List<Data> data;


    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "FileXML{" +
                "data=" + data +
                '}';
    }
}
