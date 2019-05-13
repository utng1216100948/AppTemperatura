package com.example.apptemperaturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ingresarTemp=null;
    Spinner seleccionarTemp=null;
    Button convertit=null;
    TextView mostrarTemp=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Relacionar clase con elementos XML
        ingresarTemp=(EditText) findViewById(R.id.edt_temperatura);
        seleccionarTemp=(Spinner) findViewById(R.id.spn_temperatura);
        convertit=(Button) findViewById(R.id.btn_convertir);
        mostrarTemp=(TextView) findViewById(R.id.txt_mostrarTemp);

        String[] op={"Seleccione una opción","°C a °F","°F a °C"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,op);
        seleccionarTemp.setAdapter(adapter);

        convertit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ingresarTemp.getText().toString().equals("")){
                    Toast mensage=Toast.makeText(getApplicationContext(),"Ingrese la cantidad",Toast.LENGTH_SHORT);
                    mensage.show();
                }else{
                    Double c=Double.parseDouble(ingresarTemp.getText().toString());
                    Double res=null;
                    int select=seleccionarTemp.getSelectedItemPosition();

                    switch(select){
                        case 0:
                            res=0.0;
                            Toast.makeText(getApplicationContext(),"Seleccione alguna opción",Toast.LENGTH_SHORT).show();
                            break;

                        case 1:
                            res=1.8*c+32;
                            break;

                        case 2:
                            res=(c-32) / 1.8;
                            break;
                    }
                    mostrarTemp.setText(res.toString());
                }
            }
        });
    }
}/*End*/