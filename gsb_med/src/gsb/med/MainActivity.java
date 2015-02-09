package gsb.med;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import modele.DAO;

public class MainActivity extends ListActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent inter = new Intent(this, LesMedActivity.class);
        inter.putExtra("leDep", (String) l.getItemAtPosition(position));
        startActivity(inter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        List<String> lesDeps;
        lesDeps = DAO.getlesDeps();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesDeps);
        setListAdapter(adapter);

    }

}
