package br.edu.pdm.inlibras;

/*
*
* Tela de Login do app InLibras
*
* */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import br.edu.pdm.inlibras.R;
import br.edu.pdm.inlibras.helper.DatabaseHelper;
import br.edu.pdm.inlibras.model.Usuario;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById
    protected EditText edtLogin;
    @ViewById
    protected EditText edtSenha;
    @ViewById
    protected ImageButton btnLogin;
    @ViewById
    protected ImageButton btnSair;
    @ViewById
    protected Button btnCadastro;
    // método onClick amarrado aos botões Sair, Login e Cadastro
    @Click({R.id.btnSair, R.id.btnLogin, R.id.btnCadastro})
    public void onClick(View view) {
        DatabaseHelper dh = new DatabaseHelper(this);
        switch (view.getId()) {
            case R.id.btnLogin:
                // quando o botão Login for clicado o app recupera os valores da tela
                String strLogin = edtLogin.getText().toString();
                String strSenha = edtSenha.getText().toString();
                // com esses valores é chamado a função que valida o login no banco
                Usuario u = dh.getUsuarioByLoginSenha(strLogin, strSenha);
                if (u != null) {
                    // se for validado o login é efetuado e a tela PrincipalActivity é chamada
                    Intent it = new Intent(this, PrincipalActivity.class);
                    // passando-se o usuário para ela
                    it.putExtra("usuario", u);
                    startActivity(it);
                    finish();

                } else {
                    // se o login não for validado limpa os campos da tela
                    edtLogin.setText("");
                    edtSenha.setText("");
                    // mostra uma mensagem de login ou senha inválidos
                    Toast.makeText(this,R.string.msgLoginErro, Toast.LENGTH_LONG);
                    // e coloca o foco para o primeiro campo de texto
                    edtLogin.requestFocus();
                }
            break;
            case R.id.btnCadastro:
                // quando o botão Cadastro for clicado o usuário é direcionado para a tela de Cadastro
                Intent it = new Intent(this, CadastroActivity_.class);
                startActivityForResult(it, 100);
                finish();
            break;
            case R.id.btnSair:
                // quando o botão Sair for clicado o método sair é chamado
                sair();
            break;
        }
    }

    // método sair, implementado para solicitar ao usuário a confirmação por meio do AlertDialog, se a escolha do usuário for Sim
    // o app é fechado, se a escolha for Não o app permanece
    private void sair() {
        AlertDialog.Builder dialogoSair = new AlertDialog.Builder(this);
        dialogoSair.setTitle(R.string.dlgSair);
        dialogoSair.setMessage(R.string.msgSair);
        dialogoSair.setNegativeButton(R.string.opNao, null);
        dialogoSair.setPositiveButton(R.string.opSim, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);
            }
        });
        dialogoSair.show();
    }
}