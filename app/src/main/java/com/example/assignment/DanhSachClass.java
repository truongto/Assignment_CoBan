package com.example.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assignment.Adapter.ClassAdapter;
import com.example.assignment.model.OObject;

import java.util.ArrayList;
import java.util.List;

public class DanhSachClass extends AppCompatActivity {
    private ListView listView;
    private List<OObject> oObjectList;
    private SqliteStudent sqliteStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_class);
        listView = findViewById(R.id.listV_class);
//        hien thi tren listview
        oObjectList = new ArrayList<>();
        sqliteStudent = new SqliteStudent(this);
        oObjectList = sqliteStudent.getAllClass();

        final ClassAdapter classAdapter = new ClassAdapter(this, oObjectList);
        listView.setAdapter(classAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final OObject oObject = oObjectList.get(position);
                sqliteStudent.deleteClass(oObjectList.get(position).getId());
                oObjectList.get(position);
                oObjectList.remove(oObject);
//                notifyDataSetChanged();
                classAdapter.notifyDataSetChanged();
                Toast.makeText(DanhSachClass.this, "Đã Xóa", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
