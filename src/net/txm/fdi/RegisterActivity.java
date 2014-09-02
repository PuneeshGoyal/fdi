package net.txm.fdi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.txm.fdi.constants.RegisterDentalDetail;
import net.txm.fdi.constants.SharedPreferenceConstant;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
/*import net.txm.fdi.util.JsonObj;*/
//import net.txm.fdi.util.JsonObj;

//import  com.google.android.gms.R;

//@SuppressLint("ShowToast")
public class RegisterActivity extends Activity {

	EditText edtName,edtEmail,edtOcc,edtLoc;
	Spinner spOccupation, spDentalWork,spWhereFrom,spWebDentist;


	Boolean temp = false;
	Boolean temp1 = false;
	Boolean temp2 = false;
	Boolean temp3 = false;
	Boolean check = false;
	Boolean check1 = false;
	Boolean check2 = false;
	Boolean check3 = false;
	TextView txt_occu,txt_dental,txt_location,txt_webdentist;

	RegisterDentalDetail rdd;
	//Button btnNext;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		edtName         = (EditText)findViewById(R.id.edtNme);
		edtEmail        = (EditText)findViewById(R.id.edteml);
		edtOcc        = (EditText)findViewById(R.id.edtocc);
		edtLoc        = (EditText)findViewById(R.id.edtwhere);
		spOccupation    = (Spinner)findViewById(R.id.occupation_spinner);
		spDentalWork    = (Spinner)findViewById(R.id.dentalwork_spinner);
		spWhereFrom     = (Spinner)findViewById(R.id.wherefrom_spinner);
		spWebDentist    = (Spinner)findViewById(R.id.webdentist_spinner);
		txt_occu        = (TextView) findViewById(R.id.txtOccu);
		txt_dental      = (TextView) findViewById(R.id.txtDental);
		txt_location    = (TextView) findViewById(R.id.txtLocation);
		txt_webdentist  = (TextView) findViewById(R.id.txtWebDentist);

		spOccupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				if(temp)
				{
					check = true;
					txt_occu.setVisibility(View.GONE);
				}
				temp = true;
				if(arg2==2){
					edtOcc.setVisibility(View.VISIBLE);
					edtOcc.setFocusableInTouchMode(true);
				}
				else{
					edtOcc.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				check = false;
			}
		});

		spDentalWork.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				if(temp1)
				{
					check1 = true;
					txt_dental.setVisibility(View.GONE);
				}
				temp1 = true;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				check1 = false;
			}
		});

		spWhereFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				if(temp2)
				{
					check2 = true;
					txt_location.setVisibility(View.GONE);
				}
				temp2 = true;
				if(arg2==2){
					edtLoc.setVisibility(View.VISIBLE);
					edtLoc.setFocusableInTouchMode(true);
				}
				else{
					edtLoc.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				check2 = false;
			}
		});

		spWebDentist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				if(temp3)
				{
					 check3 = true;
					txt_webdentist.setVisibility(View.GONE);
				}
				temp3 = true;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				check3 = false;
			}
		});
		ArrayAdapter<CharSequence> Occupationadapter = ArrayAdapter.createFromResource(this, R.array.occupation_select, android.R.layout.simple_spinner_item);
		Occupationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	
		spOccupation.setAdapter(new NothingSelectedSpinnerAdapter(Occupationadapter,
				R.layout.occupation_spinner_row_nothing_selected,
				// R.layout.contact_spinner_nothing_selected_dropdown, // Optional
				this));

		ArrayAdapter<CharSequence> dentalWorkadapter = ArrayAdapter.createFromResource(this, R.array.dentalwork_select, android.R.layout.simple_spinner_item);
		dentalWorkadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spDentalWork.setAdapter(new NothingSelectedSpinnerAdapter(
				dentalWorkadapter,
				R.layout.dentalwork_spinner_row_nothing_selected,
				// R.layout.contact_spinner_nothing_selected_dropdown, // Optional
				this));

		ArrayAdapter<CharSequence> wherefromadapter = ArrayAdapter.createFromResource(this, R.array.wherefrom_select, android.R.layout.simple_spinner_item);
		wherefromadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//  spOccupation.setPrompt("What is ur occupation");

		spWhereFrom.setAdapter(new NothingSelectedSpinnerAdapter(
				wherefromadapter,
				R.layout.wherefrom_spinner_row_nothing_selected,
				// R.layout.contact_spinner_nothing_selected_dropdown, // Optional
				this));
		ArrayAdapter<CharSequence> webdentistadapter = ArrayAdapter.createFromResource(this, R.array.webdentist_select, android.R.layout.simple_spinner_item);
		webdentistadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//  spOccupation.setPrompt("What is ur occupation");

		spWebDentist.setAdapter(new NothingSelectedSpinnerAdapter(webdentistadapter,
				R.layout.webdentist_spinner_row_nothing_selected,
				// R.layout.contact_spinner_nothing_selected_dropdown, // Optional
				this));
	}

	/* private class SendDataTask extends AsyncTask<RegisterDentalDetail, Void, String> {
        @Override
        protected String doInBackground(RegisterDentalDetail... params) {
            HttpClient client = new HttpClient();
            String result = client.postJsonData(JsonObj.toJSon(params[0]));
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ((TextView) RegisterActivity.this.findViewById(R.id.txt)).setText(result);
        }
    }*/

	public void buttonOnClick(View v)
	{
		String name		= edtName.getText().toString();
		String email 	= edtEmail.getText().toString();

		int flag=1;
		for(int i=0;i<1;i++)
		{
			if (name.equals(""))
			{
				edtName.setError("This field cannot be blank");
			}
			else
				edtName.setError(null);

			if (!isValidEmail(email))
			{
				edtEmail.setError("Invalid Email Id");
			}
			else
				edtEmail.setError(null);
			if (!check)
			{
				txt_occu.setVisibility(View.VISIBLE);
				txt_occu.setText("* Choose one");
			}
			else
			{
				txt_occu.setVisibility(View.GONE);
			}
			if (!check1)
			{
				txt_dental.setVisibility(View.VISIBLE);
				txt_dental.setText("* Choose one");
			}
			else
			{
				txt_dental.setVisibility(View.GONE);
			}
			if (!check2)
			{
				txt_location.setVisibility(View.VISIBLE);
				txt_location.setText("* Choose one");
			}
			else
			{
				txt_location.setVisibility(View.GONE);
			}

			if (!check3)
			{
				txt_webdentist.setVisibility(View.VISIBLE);
				txt_webdentist.setText("* Choose one");
			}
			else
			{
				txt_webdentist.setVisibility(View.GONE);
			}
		}

		
		/*rdd.setName(edtName.getText().toString());
            rdd.setEmail(edtEmail.getText().toString());
            SendDataTask task = new SendDataTask();
            task.execute(new RegisterDentalDetail[] {rdd});*/
		//DecodeText();
		if((!name.equals("")) && isValidEmail(email) && check==true && check1==true && check2==true && check3==true )
		{
			RegisterDentalDetail rgsterDetail = new RegisterDentalDetail();
			rgsterDetail.setName(edtName.getText().toString());
			rgsterDetail.setEmail(edtEmail.getText().toString());
			rgsterDetail.setDentalPractice(spDentalWork.getSelectedItem().toString());
			rgsterDetail.setWebDentist(spWebDentist.getSelectedItem().toString());
			rgsterDetail.setCountry(spWhereFrom.getSelectedItem().toString());
			rgsterDetail.setProfession(spOccupation.getSelectedItem().toString());
			JSONObject ToJson = toJSon(rgsterDetail);
			new SharedPreferenceConstant(this).SaveSharedPrefString(SharedPreferenceConstant.JSON, ToJson.toString());
			Intent in = new Intent(getApplicationContext(), Instruction1Activity.class);
			in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(in);
		}
	}

	private boolean isValidEmail(String email)
	{
		String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public JSONObject toJSon(RegisterDentalDetail rgsterDetail) 
	{
	      try 
	      {
	        // Here we convert Java Object to JSON 
	        JSONObject jsonObj = new JSONObject();
	        jsonObj.put("name", rgsterDetail.getName());
	        jsonObj.put("email", rgsterDetail.getEmail());
	        jsonObj.put("occupation", rgsterDetail.getProfession());
	        jsonObj.put("webdentist", rgsterDetail.getWebDentist());
	        jsonObj.put("country", rgsterDetail.getCountry());
	        jsonObj.put("dental", rgsterDetail.getDentalPractice());
	        return jsonObj;
	    }
	    catch(JSONException ex) 
	    {
	        ex.printStackTrace();
	    }
	    return null;

	}
}