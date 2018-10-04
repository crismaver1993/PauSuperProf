package com.example.legendary.pauproject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.texto); // Referencia a vista y la asigno a la variable
        Button btnCheckInternet = findViewById(R.id.btn_check_internet);


        btnCheckInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkConnectivity()){
                    texto.setText("Internet");  // nuevo valor a mi texto
                    texto.setTextColor(getResources().getColor(R.color.green));
                }else{
                    texto.setText("Sin Internet");  // nuevo valor a mi texto
                    texto.setTextColor(getResources().getColor(R.color.red));
                }
            }
        });


        texto.setText("Paulina");  // nuevo valor a mi texto

        if(checkConnectivity()){
            texto.setTextColor(getResources().getColor(R.color.green));
        }else{
            texto.setTextColor(getResources().getColor(R.color.red));
        }


    }


    private boolean checkConnectivity() {
        boolean enabled = true;

        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = null;
        if (connectivityManager != null) {
            info = connectivityManager.getActiveNetworkInfo();
        }

        if ((info == null || !info.isConnected() || !info.isAvailable())) {
            Toast toast = Toast.makeText(MainActivity.this, getResources().getString(R.string.no_internet), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            enabled = false;
        }
        return enabled;
    }


}
