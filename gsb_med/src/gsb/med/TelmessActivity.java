/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb.med;

import Modele.Medecin;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 * @author sio
 */
public class TelmessActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.telmess);
        Intent inter = getIntent();

        final String tel = inter.getStringExtra("tel");

         TextView label = (TextView) findViewById(R.id.tel);
        label.setText(tel);
        Button button = (Button) findViewById(R.id.telephone);
       
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                Intent inter = getIntent();
                callIntent.setData(Uri.parse("tel:"+tel.toString()));
                startActivity(callIntent);
            }
        });
    }

}
