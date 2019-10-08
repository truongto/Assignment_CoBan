package com.example.assignment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.model.OObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnxemdanhsach;
    private List<OObject> classList;
    private SqliteStudent sqliteStudent;
    private OObject aClass = new OObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnxemdanhsach = findViewById(R.id.btndanhsach);
        btnxemdanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DanhSachClass.class);
                startActivity(intent);
            }
        });
    }

    public void themlop(final View view) {
//        show dig log
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View alert = LayoutInflater.from(this).inflate(R.layout.dialogclass, null);
        builder.setView(alert);
//        khai bao
        final Dialog dialog = builder.show();
        final EditText edtid;
        final EditText edtname;
        Button btnxoa;
        Button btnthem;
        // tham chieu cac doi tuong co tren giao dien dialog vua duoc set
        edtid = alert.findViewById(R.id.edit_id);
        edtname = alert.findViewById(R.id.edit_name);
        btnxoa = alert.findViewById(R.id.bt_xoatrang);
        btnthem = alert.findViewById(R.id.bt_themlop);

//        builder.create().show();

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             lay du lieu tu edittex
//                int id = Integer.parseInt(edtid.getText().toString().trim());
                String id = edtid.getText().toString();
                String name = edtname.getText().toString();

//         dieu kien khong bo trong
                if (edtid.getText().toString().equals("")) {
                    edtid.setError("không được bỏ trống");
                }
                if (name.equals("")) {
                    edtname.setError("không được bỏ trống");
                }
//                them du lieu vao databas va thong bao
                aClass.setId(id);
                aClass.setNameClass(name);
                sqliteStudent = new SqliteStudent(MainActivity.this);
                long result = sqliteStudent.inserClass(aClass);

                if (result > 0) {
                    Toast.makeText(MainActivity.this, "Thêm Thành Công", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Thêm Thất Bại", Toast.LENGTH_LONG).show();

                }
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                dialog.dismiss();
            }


        });


        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtid.getText().clear();
                edtname.getText().clear();

            }
        });


    }

    public void qlsinhvien(View view) {
        Intent intent = new Intent(MainActivity.this, ManageStudent.class);
        startActivity(intent);
    }


}
