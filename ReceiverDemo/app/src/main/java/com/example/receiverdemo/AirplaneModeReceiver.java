package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context contexte, Intent intention) {

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intention.getAction())) {

            boolean etatAvion = intention.getBooleanExtra("state", false);

            String texte = etatAvion
                    ? "Mode avion ACTIVÉ ✈️"
                    : "Mode avion DÉSACTIVÉ 📶";

            Toast.makeText(contexte, texte, Toast.LENGTH_LONG).show();
        }
    }
}