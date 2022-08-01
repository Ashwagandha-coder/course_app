package com.example.listcourseapp.domain;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listcourseapp.R;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.CustomViewHolder> {


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewDate;
        private TextView textViewCourse;



        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            init(itemView);


        }

        public void init(View view) {

            textViewDate = view.findViewById(R.id.tv_date);
            textViewCourse = view.findViewById(R.id.tv_course);

        }

        public void bind(int date, int course) {

            textViewDate.setText(date);
            textViewCourse.setText(course);

        }


    }


}
