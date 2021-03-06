package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.ufabc.edu.br.goufabc.dao.TimeDAO;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TimeActivity extends AppCompatActivity {

    public Context ctx;
    ArrayList<Time> listaTimes = null;
    public int delid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        View view = this.getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.setBackgroundResource (R.drawable.projeto_android_background_landscape);
        } else {
            view.setBackgroundResource (R.drawable.projeto_android_background_portrait);
        }


        ListView lstTimes = (ListView)findViewById(R.id.lstTimes);
        final TimeDAO timeDAO = new TimeDAO(this);

        Intent trainintent = getIntent();
        String trainer = trainintent.getStringExtra("trainer");
        System.out.println(trainer);
        Time time = new Time();
        time.setTrainer(trainer);
        System.out.println(String.valueOf(time.getTrainer()));
        listaTimes = (ArrayList<Time>) timeDAO.read(time.getTrainer());

        if (listaTimes == null){
            Toast.makeText(TimeActivity.this,"Seu time está vazio. Adicione um pokémon.", Toast.LENGTH_LONG).show();

        }else {
            ArrayAdapter<Time> adaptador = new ArrayAdapter<Time>(
                    this,
                    android.R.layout.simple_list_item_1,
                    listaTimes);

            lstTimes.setAdapter(adaptador);
            final Intent intent = new Intent(this, TimeActivity.class);
            intent.putExtra("trainer", trainer);
            lstTimes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Time time = listaTimes.get(position);
                    delid = time.getID();
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(TimeActivity.this);
                    mensagem.setTitle("Pokémon");
                    mensagem.setMessage("Número:   " + time.getNumero() + "\n" +
                            "Nome: " + time.getNome() + "\n" +
                            "CP:  " + time.getCP() + "\n" +
                            "HP: " + time.getHP());
                    mensagem.setNeutralButton("Cancelar", null);
                    mensagem.setPositiveButton("Remover", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            timeDAO.delete(delid);
                            finish();
                            startActivity(intent);
                        }
                    });
                    mensagem.show();

                }
            });
        }
   }
}