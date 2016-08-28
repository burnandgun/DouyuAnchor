package com.example.administrator.douyuanchor.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.douyuanchor.R;
import com.example.administrator.douyuanchor.adapter.AnchorAdapter;
import com.example.administrator.douyuanchor.model.Anchor;
import com.example.administrator.douyuanchor.model.AnchorDB;
import com.example.administrator.douyuanchor.model.AnchorShow;
import com.example.administrator.douyuanchor.util.HttpCallbackListener;
import com.example.administrator.douyuanchor.util.HttpUtil;
import com.example.administrator.douyuanchor.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ListView listView;
    private ArrayAdapter<Anchor> adapter;
    private List<Anchor> anchorList = new ArrayList<Anchor>();
    private AnchorDB anchordb;
    private Utility utility;
    private ProgressDialog progressDialog;
    public List<AnchorShow> anchorShowList = new ArrayList<AnchorShow>();
    private List<String> addressList = new ArrayList<String>();
    private List<String> codeList = new ArrayList<String>();
    public AnchorShow anchorShow = new AnchorShow();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codeList.add("58428");
        codeList.add("inflame");
        codeList.add("67554");
        codeList.add("chuan967");
        codeList.add("27836");
        codeList.add("319598");
        codeList.add("ZSMJ");
        for(String code : codeList){
            addressList.add("http://open.douyucdn.cn/api/RoomApi/room/" + code);
        }
        for(String address : addressList){
                queryFromServer(address);
        }
        /*for(int i = 0; i < addressList.size() ; i++){
            queryFromServer(addressList.get(i));
        }*/
        showAnchor();
    }


    public void queryFromServer(String address){
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                utility.handleAnchorResponse(anchorShowList,response);
            }
            @Override
            public void onError(Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    private void showAnchor(){
        AnchorAdapter adapter = new AnchorAdapter(MainActivity.this,R.layout.anchor_item,anchorShowList);
        listView = (ListView) findViewById(R.id.anchor_list);
        listView.setAdapter(adapter);
    }

}
