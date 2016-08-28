package com.example.administrator.douyuanchor.model;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Anchor {
    private int room_id;
    private String anchor_name;
    private int room_status;
    private String start_time;

 /*   public Anchor(int room_id,String anchor_name,int room_status,String start_time){
        this.room_id = room_id;
        this.anchor_name = anchor_name;
        this.room_status = room_status;
        this.start_time = start_time;
    }*/

    public int getRoomId(){
        return room_id;
    }

    public void setRoomId(int room_id){
        this.room_id = room_id;
    }

    public String getAnchorName(){
        return anchor_name;
    }

    public void setAnchorName(String anchor_name){
        this.anchor_name = anchor_name;
    }

    public int getRoomStatus(){
        return room_status;
    }

    public void setRoomStatus(int room_status){
        this.room_status = room_status;
    }

    public String getStartTime(){
        return start_time;
    }

    public void setStartTime(String start_time){
        this.start_time = start_time;
    }
}
