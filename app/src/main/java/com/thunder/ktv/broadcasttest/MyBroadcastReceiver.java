package com.thunder.ktv.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by chengkai on 18-3-19.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"onReceive MyBroadcastReceiver",Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
