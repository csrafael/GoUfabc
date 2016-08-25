package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;

public class ListActivity extends AppCompatActivity {

    public Context ctx;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        View view = this.getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.setBackgroundResource(R.drawable.projeto_android_background_landscape);
        } else {
            view.setBackgroundResource(R.drawable.projeto_android_background_landscape);
        }

        ctx = ListActivity.this;

        ListView lstPokemon = (ListView) findViewById(R.id.lstPokemon);
        ArrayAdapter<String> adaptador;

        ArrayList<String> listaPokemon = null;
        try {
            listaPokemon = matrixToList(Matrix.readFromAssets(ctx));
        } catch (IOException e) {
            e.printStackTrace();
        }


        adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listaPokemon);

        lstPokemon.setAdapter(adaptador);

        lstPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adaptador, View v, int pos, long id) {
                Intent trainerIntent = getIntent();
                String trainer = trainerIntent.getStringExtra("trainer");
                Intent intent = new Intent(ListActivity.this, Pokemon.class);
                intent.putExtra("pokemon", id);
                intent.putExtra("trainer", trainer);
                startActivity(intent);
            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void abrirTime(View view){
        Intent trainerIntent = getIntent();
        String trainer = trainerIntent.getStringExtra("trainer");
        Intent intent = new Intent(this, TimeActivity.class);
        intent.putExtra("trainer", trainer);
        startActivity(intent);
    }


    public static <String> ArrayList<String> matrixToList(String[][] twod_array) {
        int j = 0;
        int k = 1;

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < twod_array.length; i++) {
            list.add((String) (twod_array[i][j] + " " + twod_array[i][k].toString()));
        }

        return list;
   }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "List Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://android.ufabc.edu.br.goufabc/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "List Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://android.ufabc.edu.br.goufabc/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}