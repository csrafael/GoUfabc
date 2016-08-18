package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class Pokemon extends AppCompatActivity {

    public Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        ctx = Pokemon.this;
        String[][] listaPokemon = null;

        try {
            listaPokemon = Matrix.readFromAssets(ctx);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        //Bundle parametros = intent.getExtras();
        Long Ide;
        int id;
        Ide = intent.getLongExtra("pokemon", 999);
        id = Ide.intValue();
        TextView txtDetalhes = (TextView)findViewById(R.id.nomePokemon);
        txtDetalhes.setText(listaPokemon[id][0].toString()+" "+listaPokemon[id][1].toString());
    }

    public void clickAdd(View view){
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }
}
