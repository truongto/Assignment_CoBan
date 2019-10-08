package com.example.assignment.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.OObject;

import java.util.List;

public class SpinnerAdapter implements android.widget.SpinnerAdapter {

    private Context context;
    private List<OObject> spinnerList;

    public SpinnerAdapter(Context context, List<OObject> spinnerList) {
        this.context = context;
        this.spinnerList = spinnerList;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.hienthispinner, parent, false);

        TextView textView;

        textView = convertView.findViewById(R.id.tv_spinner);

        textView.setText(spinnerList.get(position).getNameClass());


        return convertView;
    }






    @Override
    public int getCount() {
        return spinnerList.size();
    }

    @Override
    public Object getItem(int position) {
        return spinnerList.get(position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.hienthispinner, parent, false);

        TextView textView;

        textView = convertView.findViewById(R.id.tv_spinner);

        textView.setText(spinnerList.get(position).getNameClass());

        textView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));

        return convertView;
    }







    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {

        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
