package com.example.missa.juegonumero;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private double num;
    private TextView aleatorio;
    private TextView numero;
    private double num2;
    private String cad;
    private String cad2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (float)(Math.random()*2)+(1.1);
        cad = ""+num;
        aleatorio = (TextView)findViewById(R.id.textView2);
        aleatorio.setText(cad.substring(0,3));

        numero = (TextView)findViewById(R.id.textView3);
        tim();
    }

    public void tim(){
        num2 = 1.0;
        new CountDownTimer(100000,500) {
            @Override
            public void onTick(long l) {

                if(num2<3.1) {
                    cad2 = num2+"";
                    numero.setText(cad2.substring(0,3));
                    num2 = num2 + 0.1;
                }else{
                    num2=1.0;
                }
            }

            public void onFinish() {

            }

        }.start();
    }

    public void compara(View v){
        float numero1 = Float.parseFloat((String) aleatorio.getText());
        float numero2 = Float.parseFloat((String) numero.getText());
        if(numero1-numero2==0){
            Toast.makeText(getApplicationContext(),"Has Ganado",Toast.LENGTH_LONG).show();
            reinicio(this);
        }else{
            Toast.makeText(getApplicationContext(),"Perdiste",Toast.LENGTH_LONG).show();
            reinicio(this);
        }
    }

    public static void reinicio(Activity a){
        Intent intent = new Intent();
        intent.setClass(a,a.getClass());
        a.startActivity(intent);
        a.finish();
    }


}
