package com.example.receiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver receiverAvion;
    private boolean estEnregistre = false;

    private Button btnGestionReceiver, btnBroadcastPerso;
    private TextView txtEtat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiverAvion = new AirplaneModeReceiver();

        txtEtat = findViewById(R.id.tvStatus);
        btnGestionReceiver = findViewById(R.id.btnToggleAirplane);
        btnBroadcastPerso = findViewById(R.id.btnSendCustom);

        btnGestionReceiver.setOnClickListener(v -> gererReceiver());
        btnBroadcastPerso.setOnClickListener(v -> envoyerBroadcast());
    }

    private void gererReceiver() {

        if (!estEnregistre) {

            IntentFilter filtre = new IntentFilter();
            filtre.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

            registerReceiver(receiverAvion, filtre);

            estEnregistre = true;

            txtEtat.setText("Receiver activé (dynamique)");
            btnGestionReceiver.setText("Désactiver Receiver");
        } else {

            unregisterReceiver(receiverAvion);

            estEnregistre = false;

            txtEtat.setText("Receiver désactivé");
            btnGestionReceiver.setText("Activer Receiver");
        }
    }

    private void envoyerBroadcast() {

        Intent intentPerso = new Intent("com.example.receiverdemo.CUSTOM_EVENT");

        intentPerso.putExtra("message",
                "Message envoyé depuis l'application 📢");

        sendBroadcast(intentPerso);

        Toast.makeText(this,
                "Broadcast personnalisé envoyé",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {

        if (estEnregistre) {
            unregisterReceiver(receiverAvion);
        }

        super.onDestroy();
    }
}