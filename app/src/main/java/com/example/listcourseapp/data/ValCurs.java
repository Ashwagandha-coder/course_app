package com.example.listcourseapp.data;

import android.icu.text.AlphabeticIndex;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs")
public class ValCurs {
    public String getID() {
        return ID;
    }

    public String getDataRange1() {
        return DataRange1;
    }

    public String getDataRange2() {
        return DataRange2;
    }

    public String getName() {
        return name;
    }

    @Attribute(name = "ID",required = false)
    private String ID;


    @Attribute(name = "DateRange1",required = false)
    private String DataRange1;


    @Attribute(name = "DateRange2",required = false)
    private String DataRange2;


    @Attribute(name = "name",required = false)
    private String name;

    @ElementList(name = "Record",inline = true)
    private List<Record> list;

    public ValCurs() {}

    public List<Record> getList() {
        return list;
    }
}

