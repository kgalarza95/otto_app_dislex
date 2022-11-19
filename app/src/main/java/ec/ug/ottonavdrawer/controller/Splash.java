package ec.ug.ottonavdrawer.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ec.ug.ottonavdrawer.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int millSegDuracion = 3000;
        //tiempo de duracion de splash, modificar por llamada a la abase de datos o conexion con el servidor
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MenuProfEstud.class);
                startActivity(intent);
            }
        }, millSegDuracion);
    }
}