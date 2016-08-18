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
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


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
        String url = listaPokemon[id][2];
        
        new LoadImagefromUrl( ).execute((ImageView) findViewById(R.id.imgPkmn), listaPokemon[id][2].toString());

        new LoadImagefromUrl( ).execute((ImageView) findViewById(R.id.imgType1), listaPokemon[id][3].toString());

        if (listaPokemon[id][4] != "null"){
            new LoadImagefromUrl( ).execute((ImageView) findViewById(R.id.imgType2), listaPokemon[id][4].toString());
        }
    }

    public void clickAdd(View view){
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    private class LoadImagefromUrl extends AsyncTask< Object, Void, Bitmap > {
        ImageView ivPreview = null;

        @Override
        protected Bitmap doInBackground( Object... params ) {
            this.ivPreview = (ImageView) params[0];
            String url = (String) params[1];
            System.out.println(url);
            return loadBitmap( url );
        }

        @Override
        protected void onPostExecute( Bitmap result ) {
            super.onPostExecute( result );
            ivPreview.setImageBitmap( result );
        }
    }

    public Bitmap loadBitmap( String url ) {
        URL newurl = null;
        Bitmap bitmap = null;
        try {
            newurl = new URL( url );
            bitmap = BitmapFactory.decodeStream( newurl.openConnection( ).getInputStream( ) );
        } catch ( MalformedURLException e ) {
            e.printStackTrace( );
        } catch ( IOException e ) {

            e.printStackTrace( );
        }
        return bitmap;
    }
}
