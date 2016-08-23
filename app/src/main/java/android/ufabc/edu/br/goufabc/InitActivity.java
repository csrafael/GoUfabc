package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.ufabc.edu.br.goufabc.dao.UserDAO;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        View view = this.getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.setBackgroundResource (R.drawable.projeto_android_background_landscape);
        } else {
            view.setBackgroundResource (R.drawable.projeto_android_background_portrait);
        }

        EditText edit_txt = (EditText) findViewById(R.id.editPwd);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);


        edit_txt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    btnLogin.performClick();
                    return true;
                }
                return false;
            }
        });

    }

    public void clickLogin(View view){
        Intent intent = new Intent(this, ListActivity.class);
        String[][] Compara;
        UserDAO dao = new UserDAO(this);
        Compara = dao.readAll();

        EditText editLogin  = (EditText)findViewById(R.id.editLogin);
        EditText editPwd  = (EditText)findViewById(R.id.editPwd);
        String login = editLogin.getText().toString();
        String pwd = editPwd.getText().toString();

        for(int i=0; i<999 ; i++){
            if (login.equals(Compara[i][0])){
                if(pwd.equals(Compara[i][1])){
                    intent.putExtra("trainer", Compara[i][0]);
                    startActivity(intent);
                    finish();
                    break;
                }else{
                    Toast.makeText(this, "Senha Inválida.", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            if (i == 998){
                Toast.makeText(this, "Usuário Inexistente.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void clickReg(View view){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
        finish();
    }

}
