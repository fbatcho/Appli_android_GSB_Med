/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb.med;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                final String nom = inter.getStringExtra("nom");
                        final String prenom = inter.getStringExtra("prenom");



        TextView label = (TextView) findViewById(R.id.tel);
        label.setText(nom+" "+prenom+" "+tel+" ");
        Button telephone = (Button) findViewById(R.id.telephone);

        telephone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                Intent inter = getIntent();
                callIntent.setData(Uri.parse("tel:" + tel.toString()));
                startActivity(callIntent);
            }
        });
        Button mess = (Button) findViewById(R.id.message);
        mess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditText edit = (EditText) findViewById(R.id.sms);
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("5554", null, edit.getText().toString(), null, null);
                edit.setText("");
            }

        });
    }

}
