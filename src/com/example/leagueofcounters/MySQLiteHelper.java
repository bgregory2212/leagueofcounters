package com.example.leagueofcounters;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper 
{

	  private static final int DATABASE_VERSION = 1;
	  private static final String DATABASE_NAME = "Champs";
	  private static final String TABLE_CHAMPIONS = "champions";
	 
	  private static final String KEY_ID = "id";
	  
	  private static final String KEY_NAME = "name";
	  private static final String KEY_CR = "cR";
	  
	  private static final String KEY_PSTYLE = "pStyle";
	  private static final String KEY_ROLES = "roles";
	  
	  private static final String KEY_I1 = "i1";
	  private static final String KEY_I1R = "i1R";
	  
	  private static final String KEY_I2 = "i2";
	  private static final String KEY_I2R = "i2R";
	  
	  private static final String KEY_I3 = "i3";
	  private static final String KEY_I3R = "i3R";
	  
	  private static final String KEY_I4 = "i4";
	  private static final String KEY_I4R = "i4R";
	  
	  private static final String KEY_I5 = "i5";
	  private static final String KEY_I5R = "i5R";
	  
	  private static final String KEY_I6 = "i6";
	  private static final String KEY_I6R = "i6R";
	  
	  private static final String KEY_STR1 = "str1";
	  private static final String KEY_S1R = "s1R";
	  
	  private static final String KEY_STR2 = "str2";
	  private static final String KEY_S2R = "s2R";
	  
	  private static final String KEY_STR3 = "str3";
	  private static final String KEY_S3R = "s3R";
	  
	  private static final String KEY_WEAK1 = "weak1";
	  private static final String KEY_W1R = "w1R";
	  
	  private static final String KEY_WEAK2 = "weak2";
	  private static final String KEY_W2R = "w2R";
	  
	  private static final String KEY_WEAK3 = "weak3";
	  private static final String KEY_W3R = "w3R";
	  
	  private static final String KEY_RATING = "rating";
	  

	  public MySQLiteHelper(Context context)
	  {
		  super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }
	  
	  @Override
	  public void onCreate(SQLiteDatabase db)
	  {
		  String CREATE_CHAMPIONS_TABLE = "CREATE TABLE " + TABLE_CHAMPIONS + "(" + KEY_ID+ " INTEGER PRIMARY KEY," 
				  						 + KEY_NAME + " TEXT,"
				  						 + KEY_CR + " TEXT,"
				  						 + KEY_PSTYLE + " TEXT,"
				  						 + KEY_ROLES + " TEXT,"
				  						 + KEY_I1 + " TEXT,"
				  						 + KEY_I1R + " TEXT,"
				  						 + KEY_I2 + " TEXT,"
				  						 + KEY_I2R + " TEXT,"
				  						 + KEY_I3 + " TEXT,"
				  						 + KEY_I3R + " TEXT,"
				  						 + KEY_I4 + " TEXT,"
				  						 + KEY_I4R + " TEXT,"
				  						 + KEY_I5 + " TEXT,"
				  						 + KEY_I5R + " TEXT,"
				  						 + KEY_I6 + " TEXT,"
				  						 + KEY_I6R + " TEXT,"
				  						 + KEY_STR1 + " TEXT,"
				  						 + KEY_S1R + " TEXT,"
				  						 + KEY_STR2 + " TEXT,"
				  						 + KEY_S2R + " TEXT,"
				  						 + KEY_STR3 + " TEXT,"
				  						 + KEY_S3R + " TEXT,"
				  						 + KEY_WEAK1 + " TEXT,"
				  						 + KEY_W1R + " TEXT,"
				  						 + KEY_WEAK2 + " TEXT,"
				  						 + KEY_W2R + " TEXT,"
				  						 + KEY_WEAK3 + " TEXT," 
				  						 + KEY_W3R + " TEXT,"
				  						 + KEY_RATING + " DOUBLE"
				  						 + ")";
		  
		  db.execSQL(CREATE_CHAMPIONS_TABLE);
	  }
	  
	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	  {
		  db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAMPIONS);
		  
		  onCreate(db);
	  }
	  

	  //////////////////////////////
	  //////////////////////////////
	  
	  
	  
	  public void addChampion(Champion champ)
	  {
		  
		 
		  SQLiteDatabase db = this.getWritableDatabase();
		  
		  ContentValues values = new ContentValues();
		  values.put(KEY_NAME, champ.name);
		  values.put(KEY_CR, champ.cR);
		  
		  values.put(KEY_PSTYLE, champ.pStyle);
		  values.put(KEY_ROLES, champ.roles);
		  
		  values.put(KEY_I1, champ.i1);
		  values.put(KEY_I1R, champ.i1R);
		  
		  values.put(KEY_I2, champ.i2);
		  values.put(KEY_I2R, champ.i2R);
		  
		  values.put(KEY_I3, champ.i3);
		  values.put(KEY_I3R, champ.i3R);
		  
		  values.put(KEY_I4, champ.i4);
		  values.put(KEY_I4R, champ.i4R);
		  
		  values.put(KEY_I5, champ.i5);
		  values.put(KEY_I5R, champ.i5R);
		  
		  values.put(KEY_I6, champ.i6);
		  values.put(KEY_I6R, champ.i6R);
		  
		  values.put(KEY_STR1, champ.str1);
		  values.put(KEY_S1R, champ.s1R);
		  
		  values.put(KEY_STR2, champ.str2);
		  values.put(KEY_S2R, champ.s2R);
		  
		  values.put(KEY_STR3, champ.str3);
		  values.put(KEY_S3R, champ.s3R);
		  
		  
		  values.put(KEY_WEAK1, champ.weak1);
		  values.put(KEY_W1R, champ.w1R);
		  
		  
		  values.put(KEY_WEAK2, champ.weak2);
		  values.put(KEY_W2R, champ.w2R);
		  
		  values.put(KEY_WEAK3, champ.weak3);
		  values.put(KEY_W3R, champ.w3R);
		  
		  values.put(KEY_RATING, champ.rating);
		  
		  db.insert(TABLE_CHAMPIONS, null, values);
		  db.close();
		  	  
	  }
	  
	  public Champion getChampion(String champName)
	  {
		  SQLiteDatabase db = this.getReadableDatabase();
		  String query = "SELECT * FROM champions WHERE name = '" + champName + "'";
		  Cursor cursor = db.rawQuery(query,null);
		  

			  Champion champ = new Champion(cursor.getString(1),cursor.getString(2),
										    cursor.getString(3),cursor.getString(4),
											
										    cursor.getString(5),cursor.getString(6),
											cursor.getString(7),cursor.getString(8),
											cursor.getString(9),cursor.getString(10),
											cursor.getString(11),cursor.getString(12),
											cursor.getString(13),cursor.getString(14),
											cursor.getString(15),cursor.getString(16),
											
											cursor.getString(17),cursor.getString(18),
											cursor.getString(19),cursor.getString(20),
											cursor.getString(21),cursor.getString(22),
											cursor.getString(23),cursor.getString(24),
											cursor.getString(25),cursor.getString(26),
											cursor.getString(27),cursor.getString(28),
											
											cursor.getDouble(29));
			  
			  return champ;
		  
		  
		  
	  }
	  
	  public Champion getChampion(int id)
	  {
		  SQLiteDatabase db = this.getReadableDatabase();
		  
		  Cursor cursor = db.query(TABLE_CHAMPIONS, new String[] {KEY_NAME, KEY_CR, 
				  											      KEY_PSTYLE, KEY_ROLES, 
				  											      KEY_I1, KEY_I1R, 
				  											      KEY_I2, KEY_I2R, 
				  											      KEY_I3, KEY_I3R, 
				  											      KEY_I4, KEY_I4R, 
				  											      KEY_I5, KEY_I5R, 
				  											      KEY_I6, KEY_I6R, 
				  											      KEY_STR1, KEY_S1R, 
				  											      KEY_STR2, KEY_S2R, 
				  											      KEY_STR3, KEY_S3R, 
				  											      KEY_WEAK1, KEY_W1R, 
				  											      KEY_WEAK2, KEY_W3R, 
				  											      KEY_WEAK3, 
				  											      KEY_RATING},
				  			      KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
		  if(cursor!=null)
			  cursor.moveToFirst();
		  
		  Champion champ = new Champion(cursor.getString(1),cursor.getString(2),
										cursor.getString(3), cursor.getString(4),
						
										cursor.getString(5), cursor.getString(6), cursor.getString(7),
										cursor.getString(8), cursor.getString(9), cursor.getString(10),
										cursor.getString(11), cursor.getString(12),
										cursor.getString(13), cursor.getString(14),
										cursor.getString(15), cursor.getString(16),
						
										cursor.getString(17), cursor.getString(18),
										cursor.getString(19), cursor.getString(20),
										cursor.getString(21), cursor.getString(22),
										cursor.getString(23), cursor.getString(24),
										cursor.getString(25), cursor.getString(26),
										cursor.getString(27), cursor.getString(28),
						
										cursor.getDouble(29));
		  
		  return champ;
		  
	  }
	  
	  public ArrayList<Champion> getAllChampions()
	  {
		  ArrayList<Champion> checkinList = new ArrayList<Champion>();
		  
		  String selectQuery = "SELECT * FROM " + TABLE_CHAMPIONS;
		  
		  SQLiteDatabase db = this.getWritableDatabase();
		  Cursor cursor = db.rawQuery(selectQuery, null);
		  
		  if(cursor.moveToFirst())
		  {
			  do{
				  Champion champ = new Champion(cursor.getString(1),cursor.getString(2),
											    cursor.getString(3),cursor.getString(4),
												
											    cursor.getString(5),cursor.getString(6),
												cursor.getString(7),cursor.getString(8),
												cursor.getString(9),cursor.getString(10),
												cursor.getString(11),cursor.getString(12),
												cursor.getString(13),cursor.getString(14),
												cursor.getString(15),cursor.getString(16),
												
												cursor.getString(17),cursor.getString(18),
												cursor.getString(19),cursor.getString(20),
												cursor.getString(21),cursor.getString(22),
												cursor.getString(23),cursor.getString(24),
												cursor.getString(25),cursor.getString(26),
												cursor.getString(27),cursor.getString(28),
												
												cursor.getDouble(29));
				  
				  checkinList.add(champ);  
			  } while (cursor.moveToNext());
		  }
		  
		  return checkinList;
	  }
	  
	  public int getChampionCount()
	  {
		  String countQuery = "SELECT * FROM " + TABLE_CHAMPIONS;
		  SQLiteDatabase db = this.getReadableDatabase();
		  Cursor cursor = db.rawQuery(countQuery, null);
		  int value = cursor.getCount();
		  cursor.close();
		  
		  return value;
	  }

}