package com.exemple.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity {

    ListView lvDiaDanh;
    ArrayList<anhviet> anhvietArrayList;
    public SQLiteDatabase database;
    public static String DATABASE_NAME = "anh_vietz.sqlite";
    LichSuDatabase db;

    ImageButton imgSearch;
    EditText edtSearch;
    ListAdapter adapter;
    ArrayList<anhviet> arrayData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        lvDiaDanh = findViewById(R.id.listview);

        imgSearch = findViewById(R.id.imgsearch);
        edtSearch = findViewById(R.id.tvsearch);

        Funtion_Search();



//        lvDiaDanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(this,Chitietdiadanh.class));
//            }
//        });


    }
    private void Funtion_Search()
    {
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayData = new ArrayList<>();
                String search = edtSearch.getText().toString().trim();

                database = Database.initDatabase(Search_Activity.this, "anh_vietz.sqlite");
                Log.e("Ten",search);

                if (!search.equalsIgnoreCase("")) {
                    Cursor cursor = database.rawQuery("Select * from  anh_viet where anh like '%" + search + "%'", null);
                   cursor.moveToFirst();
                    anhvietArrayList = new ArrayList<>();
                        anhviet dd = new anhviet(
                                cursor.getString(1),
                                cursor.getString(2)

                        );
                        Log.e("ten", cursor.getString(1));
                        arrayData.add(dd);

//                        if (dd != null) {
//                            db.themLichSu(dd);
//                            Toast.makeText(Search_Activity.this, "Bạn Đã thêm thành công!", Toast.LENGTH_LONG).show();
//                        }
//                    }

                    adapter = new ListAdapter(Search_Activity.this, R.layout.items, arrayData);
                    adapter.notifyDataSetChanged();
                    lvDiaDanh.setAdapter(adapter);

                }
                database.close();
            }
        });
    }
}

//        database = Database.initDatabase(this, "anhviet.sqlite");
//        Cursor cursor = database.rawQuery("SELECT * FROM anh_viet" ,null);
//        // Báo lỗi ở đâu
//        // đầu tiên thì id bằng 1 là đúng rồi
//        // đọc dc tên rồi
//        // đã đọc dc 3 cái trong sql
//        while (cursor.moveToNext()) {
//            diadanh dd =  new diadanh(
//                    cursor.getInt(0),
//                    cursor.getString(1),
//                    cursor.getString(2)
//            );
//            diadanhArrayList.add(dd);
//            Log.e("ten", dd.getTen());
//        }
//        database.close();
//        cursor.close();
//    }
