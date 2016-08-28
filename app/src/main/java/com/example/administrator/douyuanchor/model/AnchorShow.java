package com.example.administrator.douyuanchor.model;

/**
 * Created by Administrator on 2016/8/26.
 */
public class AnchorShow {
    private String showName;
    private String showStartTime;
    private String showStatus;
    private String showRoomId;

/*    public AnchorShow(){

    }

    public AnchorShow(String showName,String showStartTime,String showStatus,String showRoomId){
        this.showName = showName;
        this.showStartTime = showStartTime;
        this.showStatus = showStatus;
        this.showRoomId = showRoomId;
    }*/
    public void setShowName(String showName){
        this.showName = showName;
    }

    public String getShowName(){
        return showName;
    }

    public void setShowStartTime(String showStartTime){
        this.showStartTime = showStartTime;
    }

    public String getShowStartTime(){
        return showStartTime;
    }

    public void setShowStatus(String showStatus){
        this.showStatus = showStatus;
    }

    public String getShowStatus(){
        return showStatus;
    }

    public void setShowRoomId(String showRoomId){
        this.showRoomId = showRoomId;
    }

    public String getShowRoomId(){
        return showRoomId;
    }
}
