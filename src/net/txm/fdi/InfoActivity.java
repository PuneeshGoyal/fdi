package net.txm.fdi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.RelativeLayout;

/**
 * Created by Paridhi on 8/23/2014.
 */
public class InfoActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide statusbar of Android
        // could also be done later
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_instructions2);
        RelativeLayout instruction2 = (RelativeLayout)findViewById(R.id.instruct2Layout);
       instruction2.setOnTouchListener(new OnTouchListener() 
		{
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Intent in = new Intent(getApplicationContext(), TestActivity.class);
				in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(in);		
				return false;
			}
		});
    }
}
