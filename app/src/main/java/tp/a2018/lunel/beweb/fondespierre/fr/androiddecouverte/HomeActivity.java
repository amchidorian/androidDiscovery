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


public class HomeActivity extends AppCompatActivity {
    //final Intent intent = getParentActivityIntent();
    public HomeActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
};
//TextView d = (TextView) findViewById(R.id.textView);
//String retour = d.getText().toString();

// TextView e = (TextView) findViewById(R.id.textView);
//  e.setText(((TextInputEditText)v).getText().toString());
// @Override
//   public boolean onKey(View v, int keyPode, KeyEvent event){
//         System.err.println( ((TextInputEditText)v).getText().toString() );
//           return false;
//         }
//       });
