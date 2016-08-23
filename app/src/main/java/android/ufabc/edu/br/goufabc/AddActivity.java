package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.ufabc.edu.br.goufabc.dao.TimeDAO;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        View view = this.getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.setBackgroundResource (R.drawable.projeto_android_background_landscape);
        } else {
            view.setBackgroundResource (R.drawable.projeto_android_background_portrait);
        }

        EditText edit_txt = (EditText) findViewById(R.id.pkmHp);
        final ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        edit_txt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    btnAdd.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    public void gravarPokemon(View view){
        Intent intent = getIntent();
        int id = intent.getIntExtra("pokemon", 999);
        String trainer = intent.getStringExtra("trainer");
        EditText pkmNome  = (EditText)findViewById(R.id.pkmNome);
        EditText pkmCp = (EditText)findViewById(R.id.pkmCp);
        EditText pkmHp   = (EditText)findViewById(R.id.pkmHp);

        Time time = new Time();
        time.setTrainer(trainer);
        time.setNumero(String.valueOf(id+1));
        time.setNome(pkmNome.getText().toString());
        time.setCP(pkmCp.getText().toString());
        time.setHP(pkmHp.getText().toString());

        TimeDAO timeDAO = new TimeDAO(this);
        timeDAO.create(time);

        Toast.makeText(this, "Pokemon adicionado ao seu Time.", Toast.LENGTH_SHORT).show();
        intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }
}
