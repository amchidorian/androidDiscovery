package tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.R;
import tp.a2018.lunel.beweb.fondespierre.fr.androiddecouverte.entities.Eleve;

public class DetailElevesAdapter extends ArrayAdapter {


    private Context activity;
    private int template;
    private Eleve eleve;

    public DetailElevesAdapter(@NonNull Context context, int resource, Eleve eleve) {
        super(context, resource);
        this.activity = context;
        this.template = resource;
        this.eleve = eleve;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Clonage  du template à appliquer à chaque item.
        LayoutInflater inflater = LayoutInflater.from(this.activity);
        convertView = inflater.inflate(R.layout.template_detail_eleve, null);

        // On rempli chaque champs pour chaque item(eleve)


        return convertView;
    }
}
