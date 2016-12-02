package br.edu.pdm.inlibras;

/*
*
* Tela de Meus Dados do app InLibras
*
* */


import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import br.edu.pdm.inlibras.R;
import br.edu.pdm.inlibras.model.Usuario;

@EActivity(R.layout.activity_meus_dados)
public class MeusDadosActivity extends AppCompatActivity {
    @ViewById
    protected TextView txtNome;
    @ViewById
    protected TextView txtLogin;
    @ViewById
    protected TextView txtEmail;

    // método executado depois da amarração dos componentes
    @AfterViews
    public void carregaDados() {
        // carrega os dados, nos campos de texto da tela, do usuário que foi enviado entre as Intent
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        txtNome.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());
        txtLogin.setText(usuario.getLogin());
    }
}
