package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        /*ListView lstTime = (ListView)findViewById(R.id.lstTime);
        ArrayAdapter<String> adaptador;

        adaptador = new ArrayAdapter<String>(this,           //activity que contém a listView
                android.R.layout.simple_list_item_1, // estilo dos itens
                listaTime);              // a lista de elementos ALTERAR COM A LISTA CERTA

        lstTime.setAdapter(adaptador);

        lstTime.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adaptador, View v, int pos, long id){
                //Toast.makeText(ListActivity.this, "Pos="+pos+" Id="+id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListActivity.this, Time.class);
                String itemClicked = lstTime[position];
                intent.putExtra("country", itemClicked);
                startActivity(intent);
            }
        });*/
    }
}
