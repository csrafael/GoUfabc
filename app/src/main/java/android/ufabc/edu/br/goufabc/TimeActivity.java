package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.ufabc.edu.br.goufabc.dao.UserDAO;
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

        ListView lstTime = (ListView)findViewById(R.id.lstLivros);
        UserDAO timeDAO = new LivroDAO(this);
        listaLivros = livroDAO.readAll();

        ArrayAdapter<Livro> adaptador = new ArrayAdapter<Livro>(
                this,
                android.R.layout.simple_list_item_1,
                listaLivros);

        lstLivros.setAdapter(adaptador);
   }

}