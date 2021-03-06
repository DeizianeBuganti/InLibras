package br.edu.pdm.inlibras;

/*
*
* Tela de Cadastro do app InLibras
*
* */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import br.edu.pdm.inlibras.R;
import br.edu.pdm.inlibras.helper.DatabaseHelper;

@EActivity(R.layout.activity_cadastro)
public class CadastroActivity extends AppCompatActivity {

    @ViewById
    protected EditText edtNomeUsu;
    @ViewById
    protected EditText edtLoginUsu;
    @ViewById
    protected EditText edtSenhaUsu;
    @ViewById
    protected EditText edtEmailUsu;
    @ViewById
    protected ImageButton btnCadastrar;
    @ViewById
    protected ImageButton btnVoltar;
    @ViewById
    protected ImageView imgFoto;
    // método onClick amarrado aos botões Cadastrar e Voltar
    @Click({R.id.btnCadastrar, R.id.btnVoltar})
    public void onClick(View view) {
        DatabaseHelper dh = new DatabaseHelper(this);
        switch (view.getId()) {
            case R.id.btnCadastrar:
                // quando o botão Cadastrar for clicado o app recupera os valores da tela
                String strNome = edtNomeUsu.getText().toString();
                String strLogin = edtLoginUsu.getText().toString();
                String strSenha = edtSenhaUsu.getText().toString();
                String strEmail = edtEmailUsu.getText().toString();
                // com esses valores é chamado a função que realiza o cadastro no banco
                dh.cadastrarUsuario(strNome, strLogin, strSenha, strEmail);
                // e é chamado a tela LoginActivity_
                Intent it1 = new Intent(this, LoginActivity_.class);
                startActivity(it1);
                finish();
                break;
            case R.id.btnVoltar:
                // quando o botão Voltar for clicado abre-se a LoginActivity_ e fecha a atual
                Intent it = new Intent(this, LoginActivity_.class);
                startActivity(it);
                finish();
                break;
        }
    }
}
