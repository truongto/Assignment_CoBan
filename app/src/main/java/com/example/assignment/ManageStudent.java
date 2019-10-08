package com.example.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.Adapter.ClassAdapter;
import com.example.assignment.Adapter.StudentAdapter;
import com.example.assignment.model.OObject;
import com.example.assignment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ManageStudent extends AppCompatActivity {

    private AppCompatSpinner spinner;
    private ListView listView;
    private List<OObject> spinnerList;
    private List<Student> studentList;
    private SqliteStudent sqliteStudent;
    private EditText edittenSV, editngaysinh;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);
        button = findViewById(R.id.bt_themsv);
//        student
        edittenSV = findViewById(R.id.edit_tensv);
        editngaysinh = findViewById(R.id.edit_ngaysinh);

        listView = findViewById(R.id.litsv);
        studentList = new ArrayList<>();
        sqliteStudent = new SqliteStudent(this);
        studentList = sqliteStudent.getAllStudent();
        final StudentAdapter studentAdapter = new StudentAdapter(this, studentList);
        listView.setAdapter(studentAdapter);

        //        Spinner
        spinner = findViewById(R.id.spinner);
        spinnerList = new ArrayList<>();
        sqliteStudent = new SqliteStudent(this);
        spinnerList = sqliteStudent.getAllClass();
        ClassAdapter classAdapter = new ClassAdapter(this, spinnerList);
        spinner.setAdapter(classAdapter);


//        empty.setId("");
        OObject empty = new OObject();
        empty.setNameClass("---SHOW ALL");
        spinnerList.add(0, empty);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                OObject oObject = spinnerList.get(position);
                Toast.makeText(ManageStudent.this, oObject.getNameClass(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OObject oObject = (OObject) spinner.getSelectedItem();
                String name = edittenSV.getText().toString();
                String ngaysinh = editngaysinh.getText().toString();


//                if (oObject.getNameClass().equals("SHOW ALL")) {
////
////                    Toast.makeText(ManageStudent.this, "Vui Lòng Chọn Lớp", Toast.LENGTH_SHORT).show();
////                }

//                if (name.equals("")) {
//                    edittenSV.setError("Khong bo trong");
//
//                }
//                if (ngaysinh.equals("")) {
//                    editngaysinh.setError("không được bỏ trống");
//                }
//
//                if (editngaysinh.getText().equals("")) {
//                    editngaysinh.setError("khong bo trong");

                Student student = new Student();

//                for (int i = 0; i < 1; i++) {

//                    student.setId(""+i);
//                }


                student.setName(name);
                student.setBirthday(ngaysinh);
                studentList.add(student);
                sqliteStudent = new SqliteStudent(ManageStudent.this);
                studentAdapter.notifyDataSetChanged();

                long result = sqliteStudent.inserStudent(student);

                if (oObject.getNameClass().equals("---SHOW ALL")) {
                    Toast.makeText(ManageStudent.this, "Vui Lòng Chọn Lớp", Toast.LENGTH_SHORT).show();
                }
                if (name.equals("")) {
                    edittenSV.setError("KhÔng bỏ trỐng");

                } else if (ngaysinh.equals("")) {
                    editngaysinh.setError("không được bỏ trống");
                } else if (result > 0) {
                    Toast.makeText(ManageStudent.this, "them thanh cong", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ManageStudent.this, "them that bai", Toast.LENGTH_SHORT).show();
                }

            }


        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//        OObject oObject = (OObject) spinner.getSelectedItem();
//        if (oObject.getNameClass().equals("--SHOW ALL---")) {
//            Toast.makeText(ManageStudent.this, "Vui Lòng Chọn Lớp", Toast.LENGTH_SHORT).show();
//        }

//        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Student student = studentList.get(position);
                sqliteStudent.deleteStudent(studentList.get(position).getId());
                studentList.get(position);
                studentList.remove(student);
                studentAdapter.notifyDataSetChanged();

                Toast.makeText(ManageStudent.this, "Da xoa", Toast.LENGTH_SHORT);

            }
        });
    }


}


