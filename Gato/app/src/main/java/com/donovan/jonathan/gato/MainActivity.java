package com.donovan.jonathan.gato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button A1,A2,A3,B1,B2,B3,C1,C2,C3;
    protected Button[] ArrButton;

    Object[][] Matriz;
    boolean esTurno;

    protected int contador;

    public void inicializar(){
        Matriz = new Object[3][3];
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

        A1 = (Button) findViewById(R.id.A1);
        A2 = (Button) findViewById(R.id.A2);
        A3 = (Button) findViewById(R.id.A3);
        B1 = (Button) findViewById(R.id.A1);
        B2 = (Button) findViewById(R.id.A2);
        B3 = (Button) findViewById(R.id.A3);
        C1 = (Button) findViewById(R.id.C1);
        C2 = (Button) findViewById(R.id.C2);
        C3 = (Button) findViewById(R.id.C3);

        ArrButton = new Button[]{A1,A2,A3,B1,B2,B3,C1,C2,C3};

        for(Button b : ArrButton){
            b.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
    }
}
