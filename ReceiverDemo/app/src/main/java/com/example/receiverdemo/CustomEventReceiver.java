package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomEventReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context contexte, Intent intention) {

        if ("com.example.receiverdemo.CUSTOM_EVENT".equals(intention.getAction())) {

            String messageRecu = intention.getStringExtra("message");

            Toast.makeText(contexte,
                    "Reçu : " + messageRecu,
                    Toast.LENGTH_LONG).show();
        }
    }
}