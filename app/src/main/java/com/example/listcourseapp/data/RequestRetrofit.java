package com.example.listcourseapp.data;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RequestRetrofit {

    private List<Record> recordList;

    public void request() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cbr.ru/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Record>> call = api.getMonthCourse();

        call.enqueue(new Callback<List<Record>>() {

            @Override
            public void onResponse(Call<List<Record>> call, Response<List<Record>> response) {

                if(response.isSuccessful()) {

                    List<Record> list = response.body();

                    recordList = list;
                }
                else
                    response.errorBody();


            }

            @Override
            public void onFailure(Call<List<Record>> call, Throwable t) {

            }
        });


    }

    public List<Record> getRecordList() {
        return recordList;
    }


}
