package android.ufabc.edu.br.goufabc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.ufabc.edu.br.goufabc.dao.UserDAO;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
    }

    public void clickLogin(View view){
        Intent intent = new Intent(this, ListActivity.class);
        String[][] Compara = new String[1000][2];
        UserDAO dao = new UserDAO(this);
        Compara = dao.readAll();

        EditText editLogin  = (EditText)findViewById(R.id.editLogin);
        EditText editPwd  = (EditText)findViewById(R.id.editPwd);
        String login = editLogin.getText().toString();
        String pwd = editPwd.getText().toString();

        for(int i=0; i<999 ; i++){
            if (login.equals(Compara[i][0])){
                if(pwd.equals(Compara[i][1])){
                    startActivity(intent);
                    break;
                }else{
                    Toast.makeText(this, "Senha Inválida.", Toast.LENGTH_SHORT).show();
                    break;
                }
            }else{
                Toast.makeText(this, "Usuário Inexistente.", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    public void clickReg(View view){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }

}
