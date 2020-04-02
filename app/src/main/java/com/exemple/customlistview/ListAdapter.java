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

public class DiadanhApdater extends BaseAdapter {

   Context mycontext;
   int myLayout;
   List<diadanh> diadanhList;

   public DiadanhApdater(Context context, int layout, List<diadanh> diadanhs)
    {
     mycontext = context;
     myLayout = layout;
     diadanhList = diadanhs;
    }


    @Override
    public int getCount() {
        return diadanhList.size();
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
       TextView txtTen,txtID,edd,ndd;

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

        diadanh DDanh = diadanhList.get(position);

        if (DDanh != null)
        {
            hoder.txtTen = convertView.findViewById(R.id.tendd);
            hoder.edd = convertView.findViewById(R.id.edd);
            hoder.txtID = convertView.findViewById(R.id.iddd);
            hoder.ndd = convertView.findViewById(R.id.ndd);

            hoder.txtID.setText(String.valueOf(DDanh.id));
            hoder.txtTen.setText(String.valueOf(DDanh.ten));
            hoder.edd.setText(String.valueOf(DDanh.e));
            hoder.ndd.setText(String.valueOf(DDanh.n));



        }

        return convertView;
    }
}
