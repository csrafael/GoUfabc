package android.ufabc.edu.br.goufabc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.ufabc.edu.br.goufabc.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;

public class RegActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        List<String> team = new ArrayList<String>();
        team.add("Instinct");
        team.add("Mystic");
        team.add("Valor");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, team);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
}
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void gravarUser(View view){
        EditText userNome  = (EditText)findViewById(R.id.userNome);
        EditText userLogin = (EditText)findViewById(R.id.userLogin);
        EditText userPwd   = (EditText)findViewById(R.id.userPwd);

        User user = new User();
        user.setName(userNome.getText().toString());
        user.setPwd(Integer.parseInt(userPwd.getText().toString()));
        user.setUser(userLogin.getText().toString());
        user.setTeam(item.toString());

        UserDAO userDAO = new UserDAO(this);
        userDAO.create(user);

        Toast.makeText(this, "Usuário Cadastrado", Toast.LENGTH_SHORT).show();

    }

}
