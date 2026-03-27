package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context contexte, Intent intention) {

        if (Intent.ACTION_BOOT_COMPLETED.equals(intention.getAction())) {

            Toast.makeText(contexte,
                    "Démarrage du système détecté 🚀",
                    Toast.LENGTH_LONG).show();
        }
    }
}