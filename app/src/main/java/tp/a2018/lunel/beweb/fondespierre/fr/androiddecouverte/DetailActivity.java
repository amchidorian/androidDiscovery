package tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.adapters.ListeElevesAdapter;
import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.entities.Eleve;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.template_detail_eleve);

        Eleve eleve = (Eleve) getIntent().getExtras().getSerializable("eleve");

        TextView champNom = findViewById(R.id.detailNom);
        champNom.setText(eleve.getNom());

        TextView champPrenom = findViewById(R.id.detailPrenom);
        champPrenom.setText(eleve.getPrenom());

        TextView champAdresse = findViewById(R.id.detailAdresse);
        champAdresse.setText(eleve.getAdresse());

        TextView champCodePostal = findViewById(R.id.detailCodePostal);
        champCodePostal.setText(eleve.getCode_postal());

        TextView champVille = findViewById(R.id.detailVille);
        champVille.setText(eleve.getVille());

        TextView champEmail = findViewById(R.id.detailEmail);
        champEmail.setText(eleve.getEmail());

        TextView champTel = findViewById(R.id.detailTelephone);
        champTel.setText(eleve.getTelephone());

        TextView champSexe = findViewById(R.id.detailSexe);
        champSexe.setText(eleve.getSexe());

        TextView champDate = findViewById(R.id.detailDateNaissance);
        champDate.setText(eleve.getDate_de_naissance());

    }
}
