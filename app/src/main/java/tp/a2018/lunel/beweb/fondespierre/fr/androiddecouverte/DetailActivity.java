package tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.entities.Eleve;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.template_detail_eleve);
        Eleve e = (Eleve) getIntent().getExtras().getSerializable("eleve");
        TextView nom = findViewById(R.id.detail_nom);
        nom.setText(e.getNom());
    }
}
