/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb.med;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import Modele.DAO;
import Modele.Medecin;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

/**
 *
 * @author sio
 */
public class LesMedActivity extends ListActivity {

    private String tel;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.autrevue);

        Intent inter = getIntent();
        String dep = inter.getStringExtra("leDep");
        TextView label = (TextView) findViewById(R.id.label);
        label.setText("Les médecins du " + dep);
        final List<Medecin> lesMeds;
        lesMeds = DAO.getLesMeds(dep);
        MedAdapter adapter = new MedAdapter(lesMeds, this);
        setListAdapter(adapter);
        Button button = (Button) findViewById(R.id.filtrer);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditText edit = (EditText) findViewById(R.id.edit);
                List<Medecin> lesMedsFiltre = new ArrayList<Medecin>();

                for (Medecin unMed : lesMeds) {
                    if (unMed.getNom().startsWith(edit.getText().toString())) {
                        lesMedsFiltre.add(unMed);
                    }
                }
                MedAdapter adapter = new MedAdapter(lesMedsFiltre, getApplicationContext());
                setListAdapter(adapter);
            }
        });

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent inter = new Intent(this, TelmessActivity.class);
        inter.putExtra("tel", (((Medecin) l.getItemAtPosition(position)).getTel()));
        inter.putExtra("nom", (((Medecin) l.getItemAtPosition(position)).getNom()));
        inter.putExtra("prenom", (((Medecin) l.getItemAtPosition(position)).getPrenom()));

        startActivity(inter);
    }

}
