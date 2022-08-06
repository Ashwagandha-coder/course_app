package com.example.listcourseapp.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Record")
public class Record {

    public String getDate() {
        return Date;
    }

    public String getId() {
        return Id;
    }

    public int getNominal() {
        return Nominal;
    }

    public String getValue() {
        return Value;
    }

    @Attribute(name = "Date",required = true)
    private String Date;


    @Attribute(name = "Id",required = false)
    private String Id;

    @Element(name = "Nominal")
    private int Nominal;

    @Element(name = "Value")
    private String Value;

    public Record() {}


}
