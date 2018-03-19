package com.thunder.ktv.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private IntentFilter intentFilter = null;
    private NetWorkChangeReceiver netWorkChangeReceiver = null;
    private LocalBroadcastManager localBroadcastManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        netWorkChangeReceiver = new NetWorkChangeReceiver();
//        registerReceiver(netWorkChangeReceiver,intentFilter);
        findViewById(R.id.button).setOnClickListener(this);
        intentFilter.addAction("com.thunder.ktv.broadcasttest.LOCAL_BROADCAST");
        LocalReceiver localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangeReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:{
                Intent intent = new Intent("com.thunder.ktv.broadcasttest.LOCAL_BROADCAST");
//                sendBroadcast(intent);
//                sendOrderedBroadcast(intent,null);
                localBroadcastManager.sendBroadcast(intent);
                break;
            }
        }
    }

    class NetWorkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"NetWorkChangeReceiver",Toast.LENGTH_SHORT).show();
        }
    }
    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"LocalReceiver",Toast.LENGTH_SHORT).show();
        }
    }
}
