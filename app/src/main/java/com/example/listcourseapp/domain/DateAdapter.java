package com.example.listcourseapp.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listcourseapp.R;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.CustomViewHolder> {

    private int item;
    private Context context;

    public DateAdapter(int item, Context context) {
        this.item = item;
        this.context = context;
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



    }

    @Override
    public int getItemCount() {
        return item;
    }

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

        public void bind(int date, int course) {

            textViewDate.setText(date);
            textViewCourse.setText(course);

        }


    }


}
