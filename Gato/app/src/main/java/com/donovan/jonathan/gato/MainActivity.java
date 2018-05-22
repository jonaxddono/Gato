package com.donovan.jonathan.gato;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button a1,a2,a3,b1,b2,b3,c1,c2,c3,rst;
    protected TextView texto;
    protected Button[] ArrButton;


    int[][] Matriz;
    boolean esTurno;

    protected int contador;

    public void inicializar(){
        Matriz = new int[3][3];
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                Matriz[i][j] = R.drawable.ic_launcher_background;
            }
        }
        esTurno=true;
        contador=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        c1 = (Button) findViewById(R.id.c1);
        c2 = (Button) findViewById(R.id.c2);
        c3 = (Button) findViewById(R.id.c3);
        rst = (Button) findViewById(R.id.BtnRST);
        texto = (TextView) findViewById (R.id.texto);

        this.inicializar();
        ArrButton = new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};


        for(Button b : ArrButton){
            b.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        this.click(b);
    }

    public void click(Button b){
        int x=0;
        if(esTurno){
            x = R.drawable.x;
            b.setBackgroundResource(x);
        }else{
            x = R.drawable.o;
            b.setBackgroundResource(x);
        }

        switch(b.getId()){
            case R.id.a1:
                Matriz[0][0]=x;
                break;
            case R.id.a2:
                Matriz[0][1]=x;
                break;
            case R.id.a3:
                Matriz[0][2]=x;
                break;
            case R.id.b1:
                Matriz[1][0]=x;
                break;
            case R.id.b2:
                Matriz[1][1]=x;
                break;
            case R.id.b3:
                Matriz[1][2]=x;
                break;
            case R.id.c1:
                Matriz[2][0]=x;
                break;
            case R.id.c2:
                Matriz[2][1]=x;
                break;
            case R.id.c3:
                Matriz[2][2]=x;
                break;
            case R.id.BtnRST:
                this.inicializar();
                a1.setBackgroundResource(R.drawable.ic_launcher_background);
                a2.setBackgroundResource(R.drawable.ic_launcher_background);
                a3.setBackgroundResource(R.drawable.ic_launcher_background);
                b1.setBackgroundResource(R.drawable.ic_launcher_background);
                b2.setBackgroundResource(R.drawable.ic_launcher_background);
                b3.setBackgroundResource(R.drawable.ic_launcher_background);
                c1.setBackgroundResource(R.drawable.ic_launcher_background);
                c2.setBackgroundResource(R.drawable.ic_launcher_background);
                c3.setBackgroundResource(R.drawable.ic_launcher_background);
                a1.setClickable(true);
                a2.setClickable(true);
                a3.setClickable(true);
                b1.setClickable(true);
                b2.setClickable(true);
                b3.setClickable(true);
                c1.setClickable(true);
                c2.setClickable(true);
                c3.setClickable(true);
                break;
        }

        esTurno = !esTurno;
        b.setClickable(false);
        contador++;
        if(contador>=9){
            texto.setText("No gano Nadie!");
            this.finalizar();
        }else{
            this.verificarMatriz();
        }

    }

    public void verificarMatriz(){
        for(int i=0;i<3;i++){
            if(Matriz[i][0]==R.drawable.x && Matriz[i][1]==R.drawable.x && Matriz[i][2]==R.drawable.x){
                texto.setText("GANO X!!");
                this.finalizar();
            }
        }
        for(int i=0;i<3;i++){
            if(Matriz[0][i]==R.drawable.x && Matriz[1][i]==R.drawable.x && Matriz[2][i]==R.drawable.x){
                texto.setText("GANO X!!");
                this.finalizar();
            }
        }

        if(Matriz[0][0]==R.drawable.x && Matriz[1][1]==R.drawable.x && Matriz[2][2]==R.drawable.x){
            texto.setText("GANO X!!");
            this.finalizar();
        }

        if(Matriz[0][3]==R.drawable.x && Matriz[1][2]==R.drawable.x && Matriz[2][0]==R.drawable.x){
            texto.setText("GANO X!!");
            this.finalizar();
        }



        for(int i=0;i<3;i++){
            if(Matriz[i][0]==R.drawable.o && Matriz[i][1]==R.drawable.o && Matriz[i][2]==R.drawable.o){
                texto.setText("GANO O!!");
                this.finalizar();
            }
        }
        for(int i=0;i<3;i++){
            if(Matriz[0][i]==R.drawable.o && Matriz[1][i]==R.drawable.o && Matriz[2][i]==R.drawable.o){
                texto.setText("GANO O!!");
                this.finalizar();
            }
        }

        if(Matriz[0][0]==R.drawable.o && Matriz[1][1]==R.drawable.o && Matriz[2][2]==R.drawable.o){
            texto.setText("GANO O!!");
            this.finalizar();
        }

        if(Matriz[0][3]==R.drawable.o && Matriz[1][2]==R.drawable.o && Matriz[2][0]==R.drawable.o){
            texto.setText("GANO O!!");
            this.finalizar();
        }
    }
    public void finalizar(){
        a1.setClickable(false);
        a2.setClickable(false);
        a3.setClickable(false);
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        c1.setClickable(false);
        c2.setClickable(false);
        c3.setClickable(false);
    }
}
