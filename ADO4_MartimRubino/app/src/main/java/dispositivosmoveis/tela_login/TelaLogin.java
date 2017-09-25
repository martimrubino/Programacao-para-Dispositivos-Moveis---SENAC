package dispositivosmoveis.tela_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity {

    EditText caixaNome;
    EditText caixaSenha;

    String dbnome, dbsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        caixaNome = (EditText)findViewById(R.id.loginNome);
        caixaSenha = (EditText)findViewById(R.id.loginSenha);
    }

    protected void mudaTela(View v){
        Intent intent = new Intent(this, TelaCadastro.class);
        startActivity(intent);
    }

    public void verificaDados(View v){
        String nome = caixaNome.getText().toString();
        String senha = caixaSenha.getText().toString();
        database db = new database(this);
        String cadastro = "SELECT * FROM users WHERE u_username='"+nome+"' AND u_password='"+senha+"'";
        String[][] result = db.doQuery(cadastro);
        if(result.length == 0){
            Toast.makeText(this, "Login Inválido", Toast.LENGTH_SHORT).show();
        } else {
            if(result.length > 1){
                Toast.makeText(this, "Mais de um usuário encontrado", Toast.LENGTH_SHORT).show();
            } else {
                Intent menu = new Intent(this, TelaMenu.class);
                startActivity(menu);
            }
        }
    }
}








































