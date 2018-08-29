package tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.adapters.ListeElevesAdapter;
import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.entities.Eleve;

public class ListeActivity extends AppCompatActivity {

    final Activity activity = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bind de la vue avec le controller
        setContentView(R.layout.liste_apprenant);
        getAllApprenants();

        //  Equivalent à : var liste = $("#liste_dynamique")
        ListView liste = (ListView) findViewById(R.id.liste_dynamic);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // On envoie l'éleve sélectionner vers l'activity DetailActivity
                //  Faire un startActivity
                Eleve e = (Eleve) parent.getItemAtPosition(position);
                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("eleve", e);
                startActivity(i);
            }
        });


    }

    public void getAllApprenants() {

        // Récupérer une RequestQueue venant de Volley
        RequestQueue rq = Volley.newRequestQueue(this);
        // Initialisation de l'URL
        String url = "http://192.168.1.10/beWeb/api_beweb/index.php/api/eleves";
        // Initialisation d'un tableau au format JSONArray
        JSONArray list = new JSONArray();
        // Instance d'un Response.Listener<JSONArray>
        Response.Listener<JSONArray> res = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Création Liste d'éleves
                final ArrayList<Eleve> listeEleves = new ArrayList<>();
                Integer size = response.length();
                for (int i = 0; i < size; i++) {
                    // Déclaration Eleves
                    Eleve eleve = new Eleve();
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        eleve.setNom(obj.get("nom").toString());
                        eleve.setPrenom(obj.get("prenom").toString());
                        eleve.setAdresse(obj.get("adresse").toString());
                        eleve.setDate_de_naissance(obj.get("date_de_naissance").toString());
                        eleve.setVille(obj.get("ville").toString());
                        eleve.setCode_postal(obj.get("code_postal").toString());
                        eleve.setSexe(obj.get("genre").toString());
                        eleve.setEmail(obj.get("email").toString());
                        eleve.setTelephone(obj.get("telephone").toString());
                        listeEleves.add(eleve);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                ListView liste = (ListView) findViewById(R.id.liste_dynamic);
                // On instancie un custom Adapter qui prends un custom tempate et la liste des éleves.
                ListeElevesAdapter elevesAdapter = new ListeElevesAdapter(getApplicationContext(), R.layout.template_item_eleve, listeEleves);
                //On envoie le custom Adapter dans la ListeView pour créer le rendu.
                liste.setAdapter(elevesAdapter);
            }
        };
        Response.ErrorListener err = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Un problème est survenue. Veuillez vérifier votre connexion.");
            }
        };
        JsonArrayRequest request = new JsonArrayRequest(url, res, err);

        rq.add(request);
    }
}
