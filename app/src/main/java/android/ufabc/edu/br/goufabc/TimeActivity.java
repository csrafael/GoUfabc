package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class TimeActivity extends AppCompatActivity {

    public Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
/*
        ctx = TimeActivity.this;

        ListView lstTime = (ListView)findViewById(R.id.lstTime);
        ArrayAdapter<String> adaptador;


        ArrayList<String> listaPokemon = null;
        try {
            listaPokemon = matrixToList(Matrix.readFromAssets(ctx));
        } catch (IOException e) {
            e.printStackTrace();
        }

        adaptador = new ArrayAdapter<String>(this,           //activity que contém a listView
                android.R.layout.simple_list_item_1, // estilo dos itens
                listaTime);              // a lista de elementos ALTERAR COM A LISTA CERTA

        lstTime.setAdapter(adaptador);

        lstTime.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adaptador, View v, int pos, long id){
                Intent intent = new Intent(TimeActivity.this, Pokemon.class);
                */
/*Toast.makeText(ListActivity.this, "Pokemon="+pos, Toast.LENGTH_LONG).show();
                intent.putExtra("pokemon", id);
                *//*

                startActivity(intent);

            }
        });*/
    }

}