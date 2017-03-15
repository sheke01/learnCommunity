package com.example.sheke.communitylearing;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by SHEKE on 3/10/2017.
 */
public class CustomAdapter extends BaseAdapter {
    private List<Response.ItemsBean> mitems;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext, List<Response.ItemsBean> mitems) {
        this.mContext = mContext;
        this.mitems = mitems;
    }


    @Override
    public int getCount() {
        return mitems.size();
    }

    @Override
    public Object getItem(int position) {
        return mitems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View aView= inflater.inflate(R.layout.list_item,parent,false);
        Response.ItemsBean item = (Response.ItemsBean)getItem(position);
        ImageView imma = (ImageView)aView.findViewById(R.id.imma);
        TextView tess = (TextView)aView.findViewById(R.id.tess);
        tess.setText(item.getLogin());
        String imageUrl = item.getAvatar_url();
        Picasso.with(mContext).load(imageUrl).into(imma);

        return aView;
    }
}
