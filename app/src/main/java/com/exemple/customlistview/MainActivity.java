package com.exemple.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvDiaDanh;
    ArrayList<diadanh> diadanhArrayList;
    public SQLiteDatabase database;
    DiadanhApdater adapter;
    public static String DATABASE_NAME = "anhviet.sqlite";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDiaDanh = findViewById(R.id.listview);
        diadanhArrayList = new ArrayList<>();
        getData();
        adapter = new DiadanhApdater(this,R.layout.items,diadanhArrayList);
        lvDiaDanh.setAdapter(adapter);
//        getData();
// // bắt sự kiện khi clik vào list
//        lvDiaDanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this,ChitietDiaDanh.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("id",diadanhArrayList.get(position).getId());
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });

    }

    private void getData() {
        database = Database.initDatabase(this, "anhviet.sqlite");
        Cursor cursor = database.rawQuery("SELECT * FROM anh_viet" ,null);
        cursor.moveToFirst();
        // Báo lỗi ở đâu
        // đầu tiên thì id bằng 1 là đúng rồi
        // đọc dc tên rồi
        // đã đọc dc 3 cái trong sql
        while (cursor.moveToNext()) {
            diadanh dd =  new diadanh(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            diadanhArrayList.add(dd);
            Log.e("ten", dd.getTen());
        }
        database.close();
        cursor.close();
    }
}
