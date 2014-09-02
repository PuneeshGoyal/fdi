package net.txm.fdi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class CameraActivity extends Activity implements View.OnTouchListener {

	 ImageView mImageView;    //reference to the ImageView
     //private Camera mCamera;
     //private CameraPreview mPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide statusbar of Android
        // could also be done later
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.cameramain);
//        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.imagePlaceHolder);
//        relativeLayout.setOnTouchListener(this);
//	    mImageView=(ImageView)findViewById(R.id.imageView1);



	}

    /*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next, menu);
		return true;
	}
*/


    /*



                                 mCamera = getCameraInstance();

               // Create our Preview view and set it as the content of our activity.
               mPreview = new CameraPreview(this, mCamera);
               FrameLayout frameLayout = (FrameLayout) findViewById(R.id.camera_preview);
               frameLayout.addView(mPreview);

               RelativeLayout relativeLayoutControls = (RelativeLayout) findViewById(R.id.controls_layout);
               relativeLayoutControls.bringToFront();

               RelativeLayout relativeLayoutSensorsData = (RelativeLayout) findViewById(R.id.sensors_data_layout);
               relativeLayoutSensorsData.bringToFront();

           }

           public void logSensorData(View view)
           {
               Toast.makeText(getApplicationContext(), "Logged", Toast.LENGTH_SHORT).show();
           }

           @Override
           protected void onPause()
           {
               super.onPause();
               releaseCamera();

           }
           /** A safe way to get an instance of the Camera object. */
      /*  public static Camera getCameraInstance() {
            Camera c = null;
            try {
                c = Camera.open();
            }
            catch (Exception e){
                // Camera is not available (in use or does not exist)
            }
            return c; // returns null if camera is unavailable
        }

        private void releaseCamera(){
            if (mCamera != null){
                mCamera.release();        // release the camera for other applications
                mCamera = null;
            }
        }

    }

*/




    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);

        return true;
    }
}
