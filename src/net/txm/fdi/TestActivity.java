package net.txm.fdi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;




public class TestActivity extends Activity {

    ListView lstLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        lstLink =(ListView)findViewById(R.id.lstTestLink);

        String []mainLink = new String[]{"Camera Activity","Theater Activity","Tag Activity","Quiz Activity", "Media Activity", "InfoActivity", "Image #1", "Image #2", "Image #3", "Image #4", "Image #5", "Image #6", "Image #7", "Image #8"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.custom_test_list,mainLink);
        lstLink.setAdapter(arrayAdapter);
        lstLink.setOnItemClickListener(new onListListener());
    }

    class onListListener implements AdapterView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           Intent in=null;
            switch (i)
            {
                case 0:
                    in = new Intent(getApplicationContext(),CameraActivity.class);
                    break;
                case 1:
                    in = new Intent(getApplicationContext(),TheaterActivity.class);
                    break;
                case 2:
                    in = new Intent(getApplicationContext(),TagActivity.class);
                    break;
                case 3:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 4:
                    in = new Intent(getApplicationContext(),MediaActivity.class);
                    break;

                case 5:
                    in = new Intent(getApplicationContext(),InfoActivity.class);
                    break;

                case 6:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 7:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 8:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 9:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 10:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 11:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 12:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

                case 13:
                    in = new Intent(getApplicationContext(),QuizActivity.class);
                    break;

            }
            startActivity(in);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
