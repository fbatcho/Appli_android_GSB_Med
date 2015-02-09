/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gsb.med;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 *
 * @author sio
 */
public class LesMedActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.lemed);
       TextView label=(TextView) findViewById(R.id.label);
       Intent inter=getIntent();
       String dep=inter.getStringExtra("leDep");
       label.setText(dep);
    }
    
    
}
