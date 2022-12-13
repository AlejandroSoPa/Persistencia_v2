package com.example.persistencia_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = findViewById(R.id.butt);

        try{
            File direc = comprovante();
            actualizarTxt();
            but.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    actualizaArc();
                    actualizarTxt();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private File comprovante() {
        File dir = getFilesDir();
        File archivo=new File(dir,"dades.txt");
        try {
            if (!archivo.exists()) {
                FileWriter escribir = new FileWriter(archivo);
                String mensaje = "Este es el mensaje por defecto de el archivo dades\n";
                escribir.write(mensaje);
                escribir.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dir;
    }

    private void actualizarTxt(){
        File dir = getFilesDir();
        File archivo = new File(dir,"dades.txt");
        EditText edit=findViewById(R.id.edi);
        edit.setText("");
        try {
            Scanner scn = new Scanner(archivo);

            while (scn.hasNextLine()) {
                edit.append(scn.nextLine() + "\n");
            }
        } catch (IOException e) {

        }
    }

    private void actualizaArc(){
        try {
            EditText edit=findViewById(R.id.edi);
            File dir= getFilesDir();
            File archivo=new File(dir,"dades.txt");
            FileWriter escribir=new FileWriter(archivo);
            escribir.write(edit.getText().toString());
            escribir.flush();
            escribir.close();

        } catch(Exception e){

        }
    }
}