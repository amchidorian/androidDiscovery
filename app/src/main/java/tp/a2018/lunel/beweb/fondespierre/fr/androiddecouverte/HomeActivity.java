package tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte;

import android.app.Activity;
import android.app.admin.SystemUpdateInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testRequest();
        setContentView(R.layout.home_activity);
        //On récupere la reference du composant button avec l'id go
        Button b = (Button) findViewById(R.id.go);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // a defaut d'utiliser this pour referencer l'objet courant  qu'on considere etre le bouton
                // l'objet Listener passer en argument implemente la méthode onClick qui prend en argument
                // un objet de type de la super classe (View) le bouton est une spécialisation de la classe View
                Button b = (Button) v; // on caste l'objet v en Button

                TextInputEditText c = (TextInputEditText) findViewById(R.id.txt);
                String retour = c.getText().toString();

                TextView d = (TextView) findViewById(R.id.textView);
                d.setText(retour);

                String texte = b.getText().toString();
                System.err.println("le bouton à été clické " + texte + "\n" + retour);
                Intent j = new Intent(getApplicationContext(), ListeActivity.class);
                startActivity(j);
            }
        });

        TextInputEditText edit = (TextInputEditText) findViewById(R.id.txt);


        edit.setOnKeyListener(new TextView.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                System.err.println(((TextInputEditText) v).getText().toString());
                return false;
            }
        });
    }

    public void testRequest(){
        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "http://192.168.1.10/beWeb/api_beweb/index.php/api/test/message";
        Response.Listener<String> res = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);;
            }
        };
        Response.ErrorListener err = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Un problème est survenue. Veuillez vérifier votre connexion.");
            }
        };
        StringRequest request = new StringRequest(Request.Method.GET,url, res, err);

        rq.add(request);
    }


}
