package tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.adapters.ListeElevesAdapter;
import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.entities.Eleve;

public class ListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bind de la vue avec le controller
        setContentView(R.layout.liste_apprenant);

        //  Equivalent à : var liste = $("#liste_dynamique")
        ListView liste = (ListView)findViewById(R.id.liste_dynamic);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // On envoie l'éleve sélectionner vers l'activity DetailActivity
                //  Faire un startActivity
                Eleve e = (Eleve)parent.getItemAtPosition(position);
                System.out.println(e.getNom());
                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("eleve", e);
                startActivity(i);
            }
        });

        //Création Liste d'éleves
        ArrayList<Eleve> listeEleves = new ArrayList<>();
        // Déclaration Eleves
        Eleve eleve;

        //Création différent eleve.
        eleve = new Eleve("Test","Icule", "Etudiant");
        eleve.addSkill("html").addSkill("css").addSkill("js").addSkill("php");
        listeEleves.add(eleve);

        eleve = new Eleve("Balais","Couilles", "Formateur");
        eleve.addSkill("android").addSkill("swift").addSkill("java").addSkill("jquery");
        listeEleves.add(eleve);

        eleve = new Eleve("Monty","Cules", "Etudiant");
        eleve.addSkill("html / css").addSkill("php").addSkill("symfony").addSkill("jquery");
        listeEleves.add(eleve);

        eleve = new Eleve("Toma","ok", "Formateur");
        eleve.addSkill("lancer de couteaux").addSkill("armes de jet");
        listeEleves.add(eleve);

        // On instancie un custom Adapter qui prends un custom tempate et la liste des éleves.
        ListeElevesAdapter elevesAdapter = new ListeElevesAdapter(getApplicationContext(), R.layout.template_item_eleve, listeEleves);
        //On envoie le custom Adapter dans la ListeView pour créer le rendu.
        liste.setAdapter(elevesAdapter);
    }
}
