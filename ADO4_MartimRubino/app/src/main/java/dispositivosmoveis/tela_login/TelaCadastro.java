package dispositivosmoveis.tela_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelaCadastro extends AppCompatActivity {

    EditText caixaNome;
    EditText caixaEmail;
    EditText caixaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
        caixaNome = (EditText)findViewById(R.id.cadastroNome);
        caixaEmail = (EditText)findViewById(R.id.cadastroEmail);
        caixaSenha = (EditText)findViewById(R.id.cadastroSenha);
    }

    protected void voltarLogin(View v){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
    }

    public void onClick(View v){
        String nome = caixaNome.getText().toString();
        String email = caixaEmail.getText().toString();
        String senha = caixaSenha.getText().toString();

        database db = new database(this);
        String cadastro = "INSERT INTO users (u_username, u_mail, u_password) VALUES ('"+nome+"', '"+email+"', '"+senha+"')";
        db.doNoQuery(cadastro);
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
    }
}
