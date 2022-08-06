package com.example.listcourseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.listcourseapp.data.Api;
import com.example.listcourseapp.data.CheckInChangeValue;
import com.example.listcourseapp.data.Record;
import com.example.listcourseapp.data.ValCurs;
import com.example.listcourseapp.domain.DateAdapter;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private DateAdapter dateAdapter;

    private List<Record> recordList;

    private String lastValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setProperties();
        other();
    }

    public void init() { recyclerView = findViewById(R.id.rv_main); }


    public void setProperties() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

    }
    public void other() {


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

                    Record record = recordList.get(recordList.size() - 1);

                    lastValue = record.getValue();

                    dateAdapter = new DateAdapter(recordList);
                    recyclerView.setAdapter(dateAdapter);


                    new CheckInChangeValue(MainActivity.this).request();

                }

            }

            @Override
            public void onFailure(Call<ValCurs> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Ошибка соединения", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public String getLastValue() {
        return lastValue;
    }

}