package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void AddPoke(View view) {
        EditText pkmNome = (EditText) findViewById(R.id.pkmNome);
        EditText pkmCp = (EditText) findViewById(R.id.pkmCp);
        EditText pkmHp = (EditText) findViewById(R.id.pkmHp);

        Intent intent = new Intent(this, TimeActivity.class);

        Bundle parametros = new Bundle();
        parametros.putString("pkmNome", pkmNome.getText().toString());
        parametros.putString("pkmHp", pkmCp.getText().toString());
        parametros.putString("pkmCp", pkmHp.getText().toString());

        intent.putExtras(parametros);

    }
}