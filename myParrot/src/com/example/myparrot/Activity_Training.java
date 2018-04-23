package com.example.myparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Activity_Training extends Activity {

	TextView link ,train;
	int size = 17 , max_size = 35, min_size = 8;
	
	SharedPreferences prefs;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String SizeText = "SizeOfText";
	
	public final static String ColorTheme = "the color themes" ;
	LinearLayout train_layout;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_training);
        
        
        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        
        
        
        train_layout = (LinearLayout) findViewById(R.id.train_layout);
        train_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        
        train = (TextView) findViewById(R.id.train);
        
        size = prefs.getInt(SizeText, 0);
        setTextSize(size);
    }

    private void setTextSize(int size){
    	train.setTextSize(size);
	}
	
	@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                	if(size < max_size)
                		size = size+1;
                		setTextSize(size);
                		
                		SharedPreferences.Editor editor = prefs.edit();
			            editor.putInt( SizeText , size);
			            editor.commit();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(size > min_size)
            		size = size-1;
            		setTextSize(size);
            		
            		SharedPreferences.Editor editor = prefs.edit();
		            editor.putInt( SizeText , size);
		            editor.commit();
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }
	
	private final static String SUBJECT = "the subject to email";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {  
       case R.id.send: {
    	    Intent i = new Intent(Activity_Training.this , Activity_Email.class);
			i.putExtra(SUBJECT, "אילוף וחינוך");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}
