package com.example.listcourseapp.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listcourseapp.R;
import com.example.listcourseapp.data.Record;
import com.example.listcourseapp.data.ValCurs;
import com.example.listcourseapp.data.RequestRetrofit;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.CustomViewHolder> {


    private List<Record> list;

    public DateAdapter(List<Record> list) {
        this.list = list;


    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int Id = R.layout.inflater_recyclerview;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(Id,parent,false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);



        return customViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Record record = list.get(position);

        holder.textViewDate.setText(record.getDate());
        holder.textViewCourse.setText(record.getValue());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewDate;
        private TextView textViewCourse;



        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            init(itemView);



        }

        public void init(@NonNull View view) {

            textViewDate = view.findViewById(R.id.tv_date);
            textViewCourse = view.findViewById(R.id.tv_course);

        }

        public void bind(int position) {

            RequestRetrofit retrofit = new RequestRetrofit();

            retrofit.request();
          //  List<ValCurs> arrayList = retrofit.getRecordList();

        //    int date = arrayList.get(position).getDate();
         //   int course = arrayList.get(position).getValue();


        //    textViewDate.setText(date);
        //    textViewCourse.setText(course);



        }


    }


}
