package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
    }

    public void clickLogin(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void clickReg(View view){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }

}
