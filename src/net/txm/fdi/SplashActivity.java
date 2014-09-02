package net.txm.fdi;

import net.txm.fdi.constants.EncryptDecrypt;
import net.txm.fdi.database.DbHelperDentistDetail;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class SplashActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("SplashActivity");
        setContentView(R.layout.activity_splash);
        
        /*try
        {
			EncryptDecrypt cmF = new EncryptDecrypt();
			byte[] bytes 	= cmF.encrypt("Hello World");
			String aa 		= cmF.bytesToHex(bytes);
			System.out.println(aa+"  \naaaaaaaaaaa\naa  "+bytes.toString());

			String aa1 = cmF.decrypt(aa);
			//String aa1 = new String(bytes);
			System.out.println(aa1+"  \naaaaaaaaaaa\naaa  "+bytes.toString());
		}
        catch (Exception e) 
        {
			e.printStackTrace();
		}*/
        DbHelperDentistDetail db = new DbHelperDentistDetail(this);
       // db.onCreate(db);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) 
    {
        Intent in  = new Intent(getApplicationContext(),RegisterActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
        return true;
    }
}