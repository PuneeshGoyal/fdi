package net.txm.fdi.constants;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPreferenceConstant 
{
	public static final String JSON 		= "JSON";
	private SharedPreferences appSharedPrefs;
	
	public SharedPreferenceConstant(Context ctx) 
	{
		appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
	}
	
	public boolean getSharedPrefBoolean(String para)
	{
		return appSharedPrefs.getBoolean(para, false);
	}

	public void SaveSharedPrefBoolean(String para, Boolean val)
	{
		Editor prefsEditor = appSharedPrefs.edit();
		prefsEditor.putBoolean(para, val);
		prefsEditor.commit();
	}
	
	public void SaveSharedPrefString(String para, String val)
	{
		Editor prefsEditor = appSharedPrefs.edit();
		prefsEditor.putString(para, val);
		prefsEditor.commit();
	}
	
	public String getSharedPrefString(String para)
	{
		return appSharedPrefs.getString(para, "");
	}

	public void SaveSharedPrefInt(String para, int val)
	{
		Editor prefsEditor = appSharedPrefs.edit();
		prefsEditor.putInt(para, val);
		prefsEditor.commit();
	}

	public int getSharedPrefInt(String para)
	{
		return appSharedPrefs.getInt(para, -1);
	}

	public long getSharedPrefLong(String para)
	{
		return appSharedPrefs.getLong(para, -1);
	}
	
	public void SaveSharedPrefLong(String para, long val)
	{
		Editor prefsEditor = appSharedPrefs.edit();
		prefsEditor.putLong(para, val);
		prefsEditor.commit();
	}
}