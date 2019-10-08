package com.example.assignment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.assignment.ManageStudent;
import com.example.assignment.R;
import com.example.assignment.model.Student;

import java.util.List;


public class StudentAdapter extends BaseAdapter {
    private List<Student> studentList;
    private Context context;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.hienthistudent, parent, false);
            viewHolder.tvid = convertView.findViewById(R.id.tv_idstuden);
            viewHolder.tvname = convertView.findViewById(R.id.tv_namestuden);
            viewHolder.tvbirthday = convertView.findViewById(R.id.tv_birthdaystuden);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvid.setText(String.valueOf(position));

        viewHolder.tvname.setText(studentList.get(position).getName());
        viewHolder.tvbirthday.setText(studentList.get(position).getBirthday());

        return convertView;
    }

    private class ViewHolder {
        TextView tvid;
        TextView tvname;
        TextView tvbirthday;
        Button button;
    }
}
