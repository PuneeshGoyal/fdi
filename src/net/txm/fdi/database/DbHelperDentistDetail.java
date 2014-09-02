package net.txm.fdi.database;

import java.util.ArrayList;
import java.util.List;

import net.txm.fdi.constants.Question;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelperDentistDetail extends SQLiteOpenHelper
{


	public static final String KEY_NAME				="name";
	public static final String KEY_EMAIL			="email";
	public static final String KEY_PROFESSION		="profession"; 
	public static final String KEY_DENTAL_PRACTICE	="denpractice";
	public static final String KEY_COUNTRY			="country";
	public static final String KEY_WEB_DENTIST		="webdentist";
	public static final String KEY_ID 				="_id";

	public static final String DATABASE_NAME		="Pepsodent";
	public static final String TABLE_NAME			="dentalDetail";
	public static final int DATABASE_VERSION 		= 2;
	private SQLiteDatabase dbase;

	public DbHelperDentistDetail(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String CREATE_TABLE= "CREATE TABLE "+TABLE_NAME+ "( "+KEY_ID+ " integer, "+KEY_NAME+" text, "+KEY_EMAIL+ " text , "+KEY_PROFESSION+ " text, " +
				""+KEY_DENTAL_PRACTICE+" text, "+KEY_COUNTRY+" text, "+KEY_WEB_DENTIST+" text )";
		db.execSQL(CREATE_TABLE);
		dbase = db;
		Log.e("Create table", " "+CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
		onCreate(db);
	}

	public void addDentistDetail(String json) 
	{
		dbase	= this.getReadableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, json);
		long aa = -1;
		if(dbase != null)
			 aa  = dbase.insert(TABLE_NAME, null, values);
		else
			System.out.println("No databse found....");
		System.out.println("Row Id === "+aa);
	}

	public List<Question> getAllQuestions() 
	{
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_NAME;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);

		System.out.println("Count db  == "+cursor.getCount());
		/*		if (cursor.moveToFirst()) 
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
		 */		return quesList;
	}
}