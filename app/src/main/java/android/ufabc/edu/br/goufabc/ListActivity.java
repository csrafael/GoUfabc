package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import android.ufabc.edu.br.goufabc.Matrix;

public class ListActivity extends AppCompatActivity {

    public Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        View view = this.getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.setBackgroundResource (R.drawable.projeto_android_background_landscape);
        } else {
            view.setBackgroundResource (R.drawable.projeto_android_background_landscape);
        }

        ctx = ListActivity.this;

        ListView lstPokemon = (ListView)findViewById(R.id.lstPokemon);
        ArrayAdapter<String> adaptador;

        ArrayList<String> listaPokemon = null;
        try {
            listaPokemon = matrixToList(Matrix.readFromAssets(ctx));
        } catch (IOException e) {
            e.printStackTrace();
        }

        adaptador = new ArrayAdapter<String>(this,           //activity que contém a listView
                android.R.layout.simple_list_item_1, // estilo dos itens
                listaPokemon);              // a lista de elementos ALTERAR COM A LISTA CERTA

        lstPokemon.setAdapter(adaptador);

        lstPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adaptador, View v, int pos, long id){
                //Toast.makeText(ListActivity.this, "Pokemon="+pos, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListActivity.this, Pokemon.class);
                intent.putExtra("pokemon", id);
                startActivity(intent);

            }
        });
    }


    public static <String> ArrayList<String> matrixToList(String[][] twod_array){
        int j = 0;
        int k = 1;

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < twod_array.length; i++) {
            list.add((String) (twod_array[i][j] + " " + twod_array[i][k].toString()));
        }
        
        return list;
    }

}