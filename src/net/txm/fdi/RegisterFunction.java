package net.txm.fdi;

import net.txm.fdi.database.DbHelperDentistDetail;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RegisterFunction {

	Context context;
	public RegisterFunction(Context context) 
	{
		this.context= context;
	}

	public long addDetail(String json)
	{   
		DbHelperDentistDetail dbHelper = new DbHelperDentistDetail(context);
		SQLiteDatabase db	= dbHelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		//cv.put(DbHelperDentistDetail.KEY_ID, dentalDetail.getId());
		cv.put(DbHelperDentistDetail.KEY_NAME, json);
		cv.put(DbHelperDentistDetail.KEY_EMAIL, "");
		/*	cv.put(DbHelperDentistDetail.KEY_PROFESSION, dentalDetail.getProfession());
		cv.put(DbHelperDentistDetail.KEY_COUNTRY, dentalDetail.getCountry());
		cv.put(DbHelperDentistDetail.KEY_WEB_DENTIST, dentalDetail.getWebDentist());
		cv.put(DbHelperDentistDetail.KEY_DENTAL_PRACTICE, dentalDetail.getDentalPractice());*/
		long i	= 	db.insert(DbHelperDentistDetail.TABLE_NAME,null, cv);
		Log.e("Inserted values", i+"");
		return i;
	}
}
