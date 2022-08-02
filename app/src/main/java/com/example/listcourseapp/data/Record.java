package com.example.listcourseapp.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Record")
public class Record {

    public int getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getNominal() {
        return nominal;
    }

    public int getValue() {
        return value;
    }

    @Element(name = "Date")
    private int date;

    @Element(name = "Id")
    private int id;

    @Element(name = "Nominal")
    private int nominal;

    @Element(name = "Value")
    private int value;


}
