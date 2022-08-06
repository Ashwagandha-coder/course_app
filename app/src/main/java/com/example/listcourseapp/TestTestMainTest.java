package com.example.listcourseapp;

import android.icu.text.AlphabeticIndex;


import com.example.listcourseapp.data.Record;
import com.example.listcourseapp.data.RequestRetrofit;


import java.util.List;

public class TestTestMainTest {


    public static void main(String[] args) {

        RequestRetrofit requestRetrofit = new RequestRetrofit();

        requestRetrofit.request();

        List<Record> list = requestRetrofit.getRecordList();

        System.out.println(list);
    }
}
