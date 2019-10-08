package com.example.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.OObject;

import java.util.List;

public class ClassAdapter extends BaseAdapter {
    private Context context;
    private List<OObject> classList;


    public ClassAdapter(Context context, List<OObject> classList) {
        this.classList = classList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return classList.size();
    }

    @Override
    public java.lang.Object getItem(int position) {
        return classList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


//        ViewHolde viewHolder= null;
        OObject oObject = new OObject();
        ViewHolde viewHolde = new ViewHolde();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.hienthiclass, parent, false);

            viewHolde.tvid = convertView.findViewById(R.id.tv_idClass);

            viewHolde.tvname = convertView.findViewById(R.id.tv_nameClass);
            convertView.setTag(viewHolde);

        } else {
            viewHolde = (ViewHolde) convertView.getTag();
        }

//        OObject aClass = classList.get(position);
        viewHolde.tvid.setText(classList.get(position).getId());
        viewHolde.tvname.setText(classList.get(position).getNameClass());


        return convertView;
    }

    private class ViewHolde {
        TextView tvid;
        TextView tvname;
    }
}
