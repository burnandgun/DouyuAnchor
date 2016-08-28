package com.example.administrator.douyuanchor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.douyuanchor.R;
import com.example.administrator.douyuanchor.model.Anchor;
import com.example.administrator.douyuanchor.model.AnchorShow;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class AnchorAdapter extends ArrayAdapter<AnchorShow> {

    private int resourceId;

    public AnchorAdapter(Context context, int textViewResourceId, List<AnchorShow> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        AnchorShow anchorShow = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView anchorName = (TextView) view.findViewById(R.id.anchor_name);
        TextView roomStatus = (TextView) view.findViewById(R.id.room_status);
        TextView startTime  = (TextView) view.findViewById(R.id.start_time);
        TextView roomId     = (TextView) view.findViewById(R.id.room_id);
        anchorName.setText(anchorShow.getShowName());
        roomStatus.setText(anchorShow.getShowStatus());
        startTime.setText(anchorShow.getShowStartTime());
        roomId.setText(anchorShow.getShowRoomId());
        return view;
    }
}
