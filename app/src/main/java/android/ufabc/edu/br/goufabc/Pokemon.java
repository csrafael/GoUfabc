package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Pokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        Intent intent = getIntent();
        //Bundle parametros = intent.getExtras();
        Long Ide;
        Ide = intent.getLongExtra("pokemon", 999);
        TextView txtDetalhes = (TextView)findViewById(R.id.textView9);
        txtDetalhes.setText(Ide.toString());
    }
    public void clickAdd(View view){
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }
}
