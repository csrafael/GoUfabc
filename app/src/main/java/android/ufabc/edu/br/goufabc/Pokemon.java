package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
        ImageView pkmnImage = (ImageView)findViewById(R.id.imgPkmn);
        pkmnImage.setImageBitmap(getBitmapFromURL(listaPokemon[id][2]));
        ImageView tipeOneImage = (ImageView)findViewById(R.id.imgType1);
        tipeOneImage.setImageBitmap(getBitmapFromURL(listaPokemon[id][3]));
        ImageView tipeTwoImage = (ImageView)findViewById(R.id.imgType2);
        if (listaPokemon[id][4] != "null"){
            tipeTwoImage.setImageBitmap(getBitmapFromURL(listaPokemon[id][4]));
        }
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }

    public void clickAdd(View view){
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }
}
