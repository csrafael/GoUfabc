package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.ufabc.edu.br.goufabc.dao.TimeDAO;
import android.ufabc.edu.br.goufabc.dao.TimeDAO;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class TimeActivity extends AppCompatActivity {

    public Context ctx;
    ArrayList<Time> listaTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        View view = this.getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.setBackgroundResource (R.drawable.projeto_android_background_landscape);
        } else {
            view.setBackgroundResource (R.drawable.projeto_android_background_portrait);
        }


        ListView lstTimes = (ListView)findViewById(R.id.lstTimes);
        TimeDAO timeDAO = new TimeDAO(this);
        listaTimes = timeDAO.readAll();

        ArrayAdapter<Time> adaptador = new ArrayAdapter<Time>(
                this,
                android.R.layout.simple_list_item_1,
                listaTimes);

        lstTimes.setAdapter(adaptador);
   }
}