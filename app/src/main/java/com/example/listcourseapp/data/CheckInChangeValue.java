package com.example.listcourseapp.data;

import android.content.Context;
import android.widget.Toast;

import com.example.listcourseapp.MainActivity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CheckInChangeValue {

    private MainActivity context;

    public CheckInChangeValue(MainActivity context) {
        this.context = context;
    }

    private List<Record> list;

    public void request() {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run() {

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
                            list = valCurs.getList();

                            checkChange(list.get(list.size() - 1).getValue());

                        }

                    }

                    @Override
                    public void onFailure(Call<ValCurs> call, Throwable t) {

                        Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        };
        timer.schedule(timerTask, 3000, 10000);


    }

    public void checkChange(String value) {


        String oldValue = context.getLastValue();


        if (oldValue.equals(value)) {

            Toast.makeText(context, "Изменений нет", Toast.LENGTH_SHORT).show();

        }
        else {

            Toast.makeText(context, "Значение изменилось", Toast.LENGTH_SHORT).show();

        }



    }


}
