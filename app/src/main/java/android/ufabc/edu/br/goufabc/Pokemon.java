package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.AsyncTask;
import java.io.IOException;


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

        ImageView pkmnImage = (ImageView)findViewById(R.id.imgPkmn);
        new ImageLoadTask(listaPokemon[id][2], pkmnImage).execute();

        ImageView tipeOneImage = (ImageView)findViewById(R.id.imgType1);
        new ImageLoadTask(listaPokemon[id][3], pkmnImage).execute();

        ImageView tipeTwoImage = (ImageView)findViewById(R.id.imgType2);
        if (listaPokemon[id][4] != "null"){
            new ImageLoadTask(listaPokemon[id][4], pkmnImage).execute();
        }
    }

    public void clickAdd(View view){
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }
}
