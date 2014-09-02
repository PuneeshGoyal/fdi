package net.txm.fdi;

import java.util.List;

import net.txm.fdi.constants.EncryptDecrypt;
import net.txm.fdi.constants.Question;
import net.txm.fdi.constants.SharedPreferenceConstant;
import net.txm.fdi.database.DBHelperQuiz;
import net.txm.fdi.database.DbHelperDentistDetail;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity implements View.OnTouchListener{

	List<Question> quesList;
	//int score			= 0;
	int qid				= 0;
	Question currentQ;
	TextView txtQuestion;
	Button btna,btnb,btnc,btnd;
	Button next;
	String AnswerByUser = "";
	private String jsonobj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// hide statusbar of Android
		// could also be done later
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_quiz_acitivity);
		/*RelativeLayout quiz =(RelativeLayout)findViewById(R.id.quizLayout);
        quiz.setOnTouchListener(this);*/

		DBHelperQuiz db	= new DBHelperQuiz(this);
		quesList		= db.getAllQuestions();
		currentQ		= quesList.get(qid);
		int k 			= db.rowcount();
		txtQuestion		= (TextView)findViewById(R.id.txtQuestion);
		btna			= (Button)findViewById(R.id.btnA);
		btnb			= (Button)findViewById(R.id.btnB);
		btnc			= (Button)findViewById(R.id.btnC);
		btnd			= (Button)findViewById(R.id.btnD);
		next			= (Button)findViewById(R.id.txtNext);

		SharedPreferenceConstant shF = new SharedPreferenceConstant(this);
		jsonobj 		= shF.getSharedPrefString(SharedPreferenceConstant.JSON);
		setQuestionView();

		btna.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View view) 
			{
				Button b = (Button)view;
				String buttonText = b.getText().toString();
				btnb.setEnabled(false);
				btnc.setEnabled(false);
				btnd.setEnabled(false);
				AnswerByUser = buttonText;
				if(currentQ.getANSWER().equals(buttonText))
				{
					Toast.makeText(getApplicationContext(),"Correct answer ",Toast.LENGTH_SHORT).show();
					btna.setBackgroundColor(btna.getContext().getResources().getColor(R.color.blue));
				}
				else
				{
					Toast.makeText(getApplicationContext(),"Incorrect answer ",Toast.LENGTH_SHORT).show();
					btna.setBackgroundColor(btna.getContext().getResources().getColor(R.color.darkgray));
					if(currentQ.getANSWER().equals(btnb.getText()) )
					{
						btnb.setBackgroundColor(btnb.getContext().getResources().getColor(R.color.blue));
					}
					else if(currentQ.getANSWER().equals(btnc.getText()))
					{
						btnc.setBackgroundColor(btnc.getContext().getResources().getColor(R.color.blue));
					}
					else
					{
						btnd.setBackgroundColor(btnd.getContext().getResources().getColor(R.color.blue));
					}
				}
			}
		});

		btnb.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View view) 
			{
				Button b = (Button)view;
				String buttonText = b.getText().toString();
				AnswerByUser = buttonText;
				btna.setEnabled(false);
				btnc.setEnabled(false);
				btnd.setEnabled(false);

				if(currentQ.getANSWER().equals(buttonText))
				{
					Toast.makeText(getApplicationContext(),"Correct answer ",Toast.LENGTH_SHORT).show();
					btnb.setBackgroundColor(btnb.getContext().getResources().getColor(R.color.blue));
				}
				else
				{
					Toast.makeText(getApplicationContext(),"Incorrect answer ",Toast.LENGTH_SHORT).show();
					btnb.setBackgroundColor(btnb.getContext().getResources().getColor(R.color.darkgray));
					if(currentQ.getANSWER().equals(btna.getText()))
					{
						btna.setBackgroundColor(btna.getContext().getResources().getColor(R.color.blue));
					}
					else if(currentQ.getANSWER().equals(btnc.getText()))
					{
						btnc.setBackgroundColor(btnc.getContext().getResources().getColor(R.color.blue));
					}
					else
					{
						btnd.setBackgroundColor(btnd.getContext().getResources().getColor(R.color.blue));
					}
				}
			}
		});
		btnc.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View view) {
				Button b = (Button)view;
				String buttonText = b.getText().toString();
				AnswerByUser = buttonText;
				btnb.setEnabled(false);
				btna.setEnabled(false);
				btnd.setEnabled(false);

				if(currentQ.getANSWER().equals(buttonText))
				{
					Toast.makeText(getApplicationContext(),"Correct answer ",Toast.LENGTH_SHORT).show();
					btnc.setBackgroundColor(btnc.getContext().getResources().getColor(R.color.blue));
				}
				else
				{
					Toast.makeText(getApplicationContext(),"Incorrect answer ",Toast.LENGTH_SHORT).show();
					btnc.setBackgroundColor(btnc.getContext().getResources().getColor(R.color.darkgray));

					if(currentQ.getANSWER().equals(btna.getText()))
					{
						btna.setBackgroundColor(btna.getContext().getResources().getColor(R.color.blue));
					}
					else if(currentQ.getANSWER().equals(btnb.getText()))
					{
						btnb.setBackgroundColor(btnb.getContext().getResources().getColor(R.color.blue));
					}
					else
					{
						btnd.setBackgroundColor(btnd.getContext().getResources().getColor(R.color.blue));
					}
				}
			}
		});

		btnd.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View view) 
			{
				Button b = (Button)view;
				String buttonText = b.getText().toString();
				AnswerByUser = buttonText;
				btnb.setEnabled(false);
				btnc.setEnabled(false);
				btna.setEnabled(false);

				if(currentQ.getANSWER().equals(buttonText))
				{
					Toast.makeText(getApplicationContext(),"Correct answer ",Toast.LENGTH_SHORT).show();
					btnd.setBackgroundColor(btnd.getContext().getResources().getColor(R.color.blue));
				}
				else
				{
					Toast.makeText(getApplicationContext(),"Incorrect answer ",Toast.LENGTH_SHORT).show();
					btnd.setBackgroundColor(btnd.getContext().getResources().getColor(R.color.darkgray));

					if(currentQ.getANSWER().equals(btnb.getText()))
					{
						btnb.setBackgroundColor(btnb.getContext().getResources().getColor(R.color.blue));
					}
					else if(currentQ.getANSWER().equals(btna.getText()))
					{
						btna.setBackgroundColor(btna.getContext().getResources().getColor(R.color.blue));
					}
					else
					{
						btnc.setBackgroundColor(btnc.getContext().getResources().getColor(R.color.blue));
					}
				}
			}
		});
		next.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View view) 
			{
				btna.setEnabled(true);
				btnb.setEnabled(true);
				btnc.setEnabled(true);
				btnd.setEnabled(true);
				btna.setBackgroundColor(btna.getContext().getResources().getColor(R.color.gray));
				btnb.setBackgroundColor(btnb.getContext().getResources().getColor(R.color.gray));
				btnc.setBackgroundColor(btnc.getContext().getResources().getColor(R.color.gray));
				btnd.setBackgroundColor(btnd.getContext().getResources().getColor(R.color.gray));
				try 
				{
					JSONObject jsonObj = new JSONObject(jsonobj);
					jsonObj.put("question"+qid, AnswerByUser);
					jsonobj = jsonObj.toString();
					//System.out.println(jsonObj.toString());
				}
				catch (JSONException e) 
				{
					e.printStackTrace();
				}
				if(qid < 5)
				{
					currentQ = quesList.get(qid);
					setQuestionView();
				}
				else
				{
					EncryptDecrypt cmF = new EncryptDecrypt();
					try 
					{
						byte[] bytes 	= cmF.encrypt(jsonobj);
						String aa 		= cmF.bytesToHex(bytes);
						DbHelperDentistDetail db = new DbHelperDentistDetail(QuizActivity.this);
						db.addDentistDetail(jsonobj.toString());
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					finish();
					Toast.makeText(getApplicationContext(),"Thank you...",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onTouch(View view, MotionEvent motionEvent)
	{
		Intent in = new Intent(getApplicationContext(),QuizSelectActivity.class);
		startActivity(in);
		return true;	
	}

	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQUESTION());
		btna.setText(currentQ.getOPTA());
		btnb.setText(currentQ.getOPTB());
		btnc.setText(currentQ.getOPTC());
		btnd.setText(currentQ.getOPTD());
		qid++;
	}
}