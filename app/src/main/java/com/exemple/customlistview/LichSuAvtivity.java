package com.exemple.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LichSuAvtivity extends AppCompatActivity {

    SQLiteDatabase database;
    ListView lvLichsu;
    ArrayList<anhviet> anhvietArrayList;
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_avtivity);

        lvLichsu = findViewById(R.id.lichsulv);
        anhvietArrayList = new ArrayList<>();
        loadData();
        adapter = new ListAdapter(this,R.layout.items,anhvietArrayList);



    }

    private void loadData() {
        int id;
        String anh,viet;
        anhviet av;
        database = Database.initDatabase(this, "anh_vietz.sqlite");
        Cursor cursor = database.rawQuery("SELECT * FROM  lich_su",null);

        while(cursor.moveToNext())
        {
            id = cursor.getInt(0);
            anh = cursor.getString(1);
            viet = cursor.getString(2);

            av = new anhviet(id,anh,viet);
            anhvietArrayList.add(av);
        }
        database.close();

    }
}
