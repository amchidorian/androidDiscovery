package tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.R;
import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.entities.Eleve;

public class ListeElevesAdapter extends ArrayAdapter {

    private Context activity;
    private int template;
    private List<Eleve> eleves;

    public ListeElevesAdapter(@NonNull Context context, int resource, @NonNull List<Eleve> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.template = resource;
        this.eleves = objects;
    }

    @Override
    public int getCount() {
        return this.eleves.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.eleves.get(position);
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return this.eleves.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Clonage  du template à appliquer à chaque item.
        LayoutInflater inflater = LayoutInflater.from(this.activity);
        convertView = inflater.inflate(R.layout.template_item_eleve, null);
        Eleve eleve = this.eleves.get(position);

        // On rempli chaque champs pour chaque item(eleve)
        TextView champNom = convertView.findViewById(R.id.nom);
        champNom.setText(eleve.getNom());

        TextView champStatut = convertView.findViewById(R.id.statut);
        champStatut.setText(eleve.getStatus());

        TextView firstSkill = convertView.findViewById(R.id.first_skill);
        firstSkill.setText(eleve.getSkills().get(0));

        TextView otherSkill = convertView.findViewById(R.id.liste_skill);
        String skills = "";
        for(int i=1; i<eleve.getSkills().size(); i++){
            String skill = eleve.getSkills().get(i).toString();
            if(i == eleve.getSkills().size()-1){
                skills += skill;
            }else{
                skills += skill + ", ";
            }
        }
        otherSkill.setText(skills);

        return convertView;
    }
}
