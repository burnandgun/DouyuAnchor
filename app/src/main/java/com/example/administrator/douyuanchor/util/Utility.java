package com.example.administrator.douyuanchor.util;

import android.content.Context;
import android.util.Log;

import com.example.administrator.douyuanchor.activity.MainActivity;
import com.example.administrator.douyuanchor.model.Anchor;
import com.example.administrator.douyuanchor.model.AnchorDB;
import com.example.administrator.douyuanchor.model.AnchorShow;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Utility {
    //解析和处理服务器返回的JSON数据
    public static void handleAnchorResponse(List<AnchorShow> anchorShowList,String response){
        try{
            JSONObject anchorData = new JSONObject(response).getJSONObject("data");
            String roomId = anchorData.getString("room_id");
            String anchorName = anchorData.getString("owner_name");
            int roomStatus = anchorData.getInt("room_status");
            String showStatus;
            if(roomStatus == 1){
                showStatus = "直播中";
            }else{
                showStatus = "X";
            }
            String startTime = anchorData.getString("start_time");
            /*Anchor anchor = new Anchor();
            anchor.setRoomId(roomId);
            anchor.setAnchorName(anchorName);
            anchor.setRoomStatus(roomStatus);
            anchor.setStartTime(startTime);
            anchordb.saveAnchor(anchor);*/
            AnchorShow anchorShow = new AnchorShow();
            anchorShow.setShowName(anchorName);
            anchorShow.setShowStartTime(startTime);
            anchorShow.setShowStatus(showStatus);
            anchorShow.setShowRoomId(roomId);
      /*      Log.e("MainActivity","roomId is " +anchorShow.getShowRoomId());
            Log.e("MainActivity","anchorName is " +anchorShow.getShowName());
            Log.e("MainActivity","showStatus is " +anchorShow.getShowStatus());
            Log.e("MainActivity","startTime is " + anchorShow.getShowStartTime());*/
            anchorShowList.add(anchorShow);
            //测试anchorShowList中的参数
           /* for(AnchorShow anchorShow1 : anchorShowList){
                Log.e("MainActivity","roomId is " +anchorShow1.getShowRoomId());
                Log.e("MainActivity","anchorName is " +anchorShow1.getShowName());
                Log.e("MainActivity","showStatus is " +anchorShow1.getShowStatus());
                Log.e("MainActivity","startTime is " + anchorShow1.getShowStartTime());
                Log.e("MainActivity","----------------------------");
            }*/
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
