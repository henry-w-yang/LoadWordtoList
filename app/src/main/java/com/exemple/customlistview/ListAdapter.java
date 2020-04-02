package com.exemple.customlistview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {

   Context mycontext;
   int myLayout;
   List<anhviet> anhvietList;

   public ListAdapter(Context context, int layout, List<anhviet> anhviets)
    {
     mycontext = context;
     myLayout = layout;
     anhvietList = anhviets;
    }


    @Override
    public int getCount() {
        return anhvietList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
private class ViewHoder{
       TextView anh,viet;

}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder hoder;

        if (convertView == null) {
            hoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.items, null);

            convertView.setTag(hoder);

        } else {
            hoder = (ViewHoder) convertView.getTag();
        }

        anhviet av = anhvietList.get(position);

        if (av != null)
        {
            hoder.anh = convertView.findViewById(R.id.tvAnh);
            hoder.viet = convertView.findViewById(R.id.tvViet);

            hoder.anh.setText(String.valueOf(av.A));
            hoder.viet.setText(String.valueOf(av.v));


        }

        return convertView;
    }
}
