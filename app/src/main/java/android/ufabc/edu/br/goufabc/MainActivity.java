package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = this.getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.setBackgroundResource (R.drawable.projeto_android_background_landscape);
        } else {
            view.setBackgroundResource (R.drawable.projeto_android_background_portrait);
        }

        new SplashThread().start();
    }

    private class SplashThread extends Thread{
        public void run(){
            try{
                Thread.sleep(2000);
                Intent intent = new Intent(MainActivity.this, InitActivity.class);
                startActivity(intent);
                MainActivity.this.finish();

            }
            catch(Exception ex){
                Log.d("THREAD_ACTIVITY","Não foi possível abrir a activity inicial.");
            }
        }
    }
}
