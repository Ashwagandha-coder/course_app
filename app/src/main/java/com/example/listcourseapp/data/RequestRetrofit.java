package com.example.listcourseapp.data;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listcourseapp.domain.DateAdapter;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RequestRetrofit {


    private DateAdapter dateAdapter;
    private RecyclerView recyclerView;


    private List<Record> recordList;

    public void request() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cbr.ru/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ValCurs> call = api.getCourse();

        call.enqueue(new Callback<ValCurs>() {
            @Override
            public void onResponse(Call<ValCurs> call, Response<ValCurs> response) {

                if (response.isSuccessful()) {

                    ValCurs valCurs = response.body();
                    recordList = valCurs.getList();



                }
                else {

                }

            }

            @Override
            public void onFailure(Call<ValCurs> call, Throwable t) {

            }
        });

    }


    public List<Record> getRecordList() {
        return recordList;
    }



}
