package net.txm.fdi.database;

import java.util.ArrayList;
import java.util.List;

import net.txm.fdi.constants.Question;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelperQuiz extends SQLiteOpenHelper
{

	private static final int DATABASE_VERSION = 2;
	// Database Name
	 private static final String DATABASE_NAME = "QuizNew";
	// tasks table name
	static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	static final String KEY_ID = "id";
	static final String KEY_QUES = "question";
	static final String KEY_ANSWER = "answer"; //correct option
	static final String KEY_OPTA= "opta"; //option a
	static final String KEY_OPTB= "optb"; //option b
	static final String KEY_OPTC= "optc"; //option c
	static final String KEY_OPTD= "optd"; //option d
	SQLiteDatabase dbase;
	// QuizFunction qf;

	public DBHelperQuiz(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase)
	{
		dbase	= sqLiteDatabase;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
		sqLiteDatabase.execSQL(sql);
		addQuestions();
	}

	private void addQuestions() {
		Question q1 = new Question("Which of the following benefits does pepsodent expert protection provide?","Clinically proven superior antibacterial and anti plaque action",
				"Improve gum health","Fight plaque acid formation","All of these benefits","All of these benefits" );
		addQuestion(q1);

		Question q2 = new Question("Pepsodents's brush day and night campaign aims to educate children in good oral health care and also" +
				"empower children as ambassadors in their homes.Our campaign focus this year is to engage children to :", "Just Brush only once a day",
				"Brush day and night and not worry about their parents", "Brush day and night and also insprie their parents do so", "None","Brush day and night and also insprie their parents do so");
		this.addQuestion(q2);

		Question q3 = new Question("Which of the following is not " +
				"an operating system?", "SuSe", "BIOS", "DOS", "ABC","BIOS");
		addQuestion(q3);

		Question q4 = new Question("Question 4 :- ans one ", "one", "two", "three", "four","one");
		addQuestion(q4);

		Question q5 = new Question("Question 5 :- ", "abc", "pqr", "xyz", "mnq","pqr");
		this.addQuestion(q5);
		System.out.println("Adding Questions");
	}

	public void addQuestion(Question quest)
	{
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) 
		{
			do 
			{
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quest.setOPTD(cursor.getString(6));
				quesList.add(quest);
			}
			while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}

	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) 
	{

	}
}