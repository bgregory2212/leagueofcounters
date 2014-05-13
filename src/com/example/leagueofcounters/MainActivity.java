package com.example.leagueofcounters;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	JSONParser jParser = new JSONParser();
	JSONArray champions = null;
	
	MySQLiteHelper db;
	
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_TABLE = "champions";
	
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
	
	private static String url_all_champions = "http://csce.uark.edu/~kinthira/mobilePHP/get_all_champions.php";
	
	ArrayList<Champion> champList;
	Boolean homeScreen = true;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		db = new MySQLiteHelper(this);
		
		try
		{
			int c = db.getChampionCount();
			if(c == 0)
			{
				drawFromServer();
			}
			else
			{
				System.out.println("Champion Count:" + c);
			}
		}
		catch(Exception e)
		{
			
		}
		
		
		return true;
	}
	
	public void load(View v)
	{
		homeScreen = false;
		champList = db.getAllChampions();
		System.out.println("CLIST"+champList.size());
		EditText champQuery = (EditText)findViewById(R.id.editText1);
		String query = champQuery.getText().toString();
		
		for(Champion ci : champList)
		{
			if(ci.name.compareToIgnoreCase(query)==0)
			{
				System.out.println(ci.name);
				setContentView(R.layout.champion_info);
				
				TextView cName = (TextView)findViewById(R.id.textView1);
				cName.setText(ci.name);
				
				
				try{
						String uri = "drawable/"+ ci.cR;
					    int imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    Drawable image = getResources().getDrawable(imageResource);
						
					    ImageView l = (ImageView)findViewById(R.id.imageView1);
						l.setImageDrawable(image);
						
						TextView sName = (TextView)findViewById(R.id.textView3);
						sName.setText(ci.pStyle);
						
						TextView rName = (TextView)findViewById(R.id.textView5);
						rName.setText(ci.roles);
						
						uri = "drawable/"+ ci.i1R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView4);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.i2R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView2);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.i3R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView3);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.i4R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView11);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.i5R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView12);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.s1R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.ImageView01);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.s2R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView5);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.s3R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.ImageView02);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.w1R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView7);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.w2R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView6);
						l.setImageDrawable(image);
						
						uri = "drawable/"+ ci.w3R;
					    imageResource = getResources().getIdentifier(uri, null, getPackageName());
					    image = getResources().getDrawable(imageResource);
						l = (ImageView)findViewById(R.id.imageView21);
						l.setImageDrawable(image);
				}
				catch(Exception e)
				{
					
				}
				
				break;
			}
			
		}
		
		if(homeScreen == true)
			Toast.makeText(getBaseContext(), "Could not find champion", Toast.LENGTH_SHORT).show();	
		
		
	}

	
	class loadChamps extends AsyncTask<String, String, String>
    {
		
		ProgressDialog pDialog;
    	protected void onPreExecute()
    	{
    		super.onPreExecute();
    		pDialog = new ProgressDialog(MainActivity.this);
    		pDialog.setMessage("Loading champions from server...");
    		pDialog.setIndeterminate(false);
    		pDialog.setCancelable(false);
    		pDialog.show();
    		
    	}
    	
    	protected String doInBackground(String... args)
    	{
    		List<NameValuePair> params = new ArrayList<NameValuePair>();
    		
    		JSONObject json = jParser.makeHttpRequest(url_all_champions, "GET", params);
    		
    		try
    		{
    			int success = json.getInt(TAG_SUCCESS);
    			
    			if(success == 1)
    			{
    				champions = json.getJSONArray(TAG_TABLE);
    				
    				for(int i=0;i<champions.length();i++)
    				{
    					JSONObject c = champions.getJSONObject(i);
    					
    					db.addChampion(new Champion(c.getString(KEY_NAME), c.getString(KEY_CR), 
    												c.getString(KEY_PSTYLE), c.getString(KEY_ROLES),
    												c.getString(KEY_I1), c.getString(KEY_I1R),
    												c.getString(KEY_I2), c.getString(KEY_I2R),
    												c.getString(KEY_I3), c.getString(KEY_I3R),
    												c.getString(KEY_I4), c.getString(KEY_I4R),
    												c.getString(KEY_I5), c.getString(KEY_I5R),
    												c.getString(KEY_I6), c.getString(KEY_I6R),
    												c.getString(KEY_STR1), c.getString(KEY_S1R),
    												c.getString(KEY_STR2), c.getString(KEY_S2R),
    												c.getString(KEY_STR3), c.getString(KEY_S3R),
    											    c.getString(KEY_WEAK1), c.getString(KEY_W1R),
    											    c.getString(KEY_WEAK2), c.getString(KEY_W2R),
    											    c.getString(KEY_WEAK3), c.getString(KEY_W3R),
    											    Double.parseDouble(c.getString(KEY_RATING))
    											    
    												));
    					
    					System.out.println(c.getString(KEY_NAME));
    					
    					Log.d("SQL","Load from server success");
    				}
    			}
    			else
    			{
    				//FAIL TO LOAD FROM SERVER
    			}
    		}
    		catch(JSONException e)
    		{
    			e.printStackTrace();
    		}
    		
    		return null;
    	}
    	
    	 protected void onPostExecute(String file_url)
    	 {
			pDialog.dismiss();
		}
    }
	
	public void drawFromServer()
	{
		new loadChamps().execute();
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        switch(item.getItemId()) {
        case R.id.menu_settings:
            drawFromServer();
            break;

        default:
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
	    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) 
	    {
	    	if(homeScreen == true)
	    	{
	    		Intent intent = new Intent(Intent.ACTION_MAIN);
	    		intent.addCategory(Intent.CATEGORY_HOME);
	    		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    		startActivity(intent);
	    	}
	    	else
	    	{
	    		homeScreen = true;
	    		setContentView(R.layout.activity_main);
	    	}
	        return true;
	    }

	    return super.onKeyDown(keyCode, event);
	}
	

}
