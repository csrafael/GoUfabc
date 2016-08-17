package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
    }
    public void clickAdd(View view){
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }
}
