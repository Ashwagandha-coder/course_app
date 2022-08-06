package com.example.listcourseapp.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String URL = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=02/07/2022&date_req2=02/08/2022&VAL_NM_RQ=R01235";

    @GET(URL)
    Call<ValCurs> getCourse();

}
