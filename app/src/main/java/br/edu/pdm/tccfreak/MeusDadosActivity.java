package br.edu.pdm.tccfreak;

/*
*
* Tela de Meus Dados do app InLibras
*
* */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

import br.edu.pdm.tccfreak.helper.DatabaseHelper;
import br.edu.pdm.tccfreak.model.Usuario;

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
