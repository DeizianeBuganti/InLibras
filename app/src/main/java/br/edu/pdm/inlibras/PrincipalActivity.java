package br.edu.pdm.inlibras;

/*
*
*   Tela principal do aplicativo InLibras
*
* */


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.edu.pdm.inlibras.LibrasActivity;
import br.edu.pdm.inlibras.R;
import br.edu.pdm.inlibras.SobreActivity;
import br.edu.pdm.inlibras.model.Usuario;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // recebe os dados de usuário que vem da Intent LoginActivity
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        TextView txtUsuario = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtUsuario);
        TextView txtEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtEmail);
        // seta os dados do usuário na barra lateral presente na tela principal do app
        txtUsuario.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //no menu superior do app tem-se a opção Meus Dados, que é chamada abaixo
        if (id == R.id.mnMeusDados) {
            // pegando os dados do usuário que veio da LoginActivity
            Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
            Intent itMD = new Intent(this, MeusDadosActivity_.class);
            // passando os dados do usuário para a MeusDadosActivity
            itMD.putExtra("usuario", usuario);
            startActivity(itMD);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        // no menu lateral tem-se algumas opções que quando clicadas redirecionarão o usuário para algumas telas especifícas
        if (id == R.id.mnLibras) {
            // clicando na opção de menu Libras abre-se a Intent LibrasActivity_
            Intent itL = new Intent(this, LibrasActivity_.class);
            startActivity(itL);
        } else if (id == R.id.mnSobre) {
            // clicando na opção de menu Sobre abre-se a Intent SobreActivity_
            Intent itS = new Intent(this, SobreActivity_.class);
            startActivity(itS);
        } else if (id == R.id.mnSair) {
            // clicando na opção de menu Sair chama o método sair
            sair();
        } else if (id == R.id.mnCriancas) {
            // clicando na opção de menu Crianças Surdas abre-se a Intent CriancasActivity
            Intent itC = new Intent(this, CriancasActivity.class);
            startActivity(itC);
        } else if (id == R.id.mnPais) {
            // clicando na opção de menu Pais Ouvintes abre-se a Intent PaisActivity
            Intent itP = new Intent(this, PaisActivity.class);
            startActivity(itP);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
