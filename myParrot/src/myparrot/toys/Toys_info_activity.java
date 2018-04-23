package myparrot.toys;

import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Toys_info_activity extends Activity {
	
	TextView text , link;
	ImageView image;
	int size = 13 , max_size = 35, min_size = 8;
	
	
	
	
	String s1 = "http://tukipedia.com";
	
	final String CHOOSE = "choose what the button show";
	public final static String ColorTheme = "the color themes" ;
	LinearLayout toy_info_layout;
	
	SharedPreferences prefs;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String SizeText = "SizeOfText";
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toys_information);
        
        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        
        
        toy_info_layout = (LinearLayout) findViewById(R.id.toy_info_layout);
        toy_info_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        text = (TextView) findViewById(R.id.toy_info_text);
        link = (TextView) findViewById(R.id.toy_info_link);
        link.setTextColor(Color.BLUE);
        
        image = (ImageView) findViewById(R.id.toy_info_image);
        
        	link.setText(s1);
        	text.setText(this.getString(R.string.toy_info_text));
        	image.setVisibility(View.VISIBLE);
        	
        	link.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                    myWebLink.setData(Uri.parse(link.getText().toString()));
                    startActivity(myWebLink);
                 }
            });
        	
        	size = prefs.getInt(SizeText, 0);
            setTextSize(size);
	}
        	
        	private void setTextSize(int size){
        		text.setTextSize(size);
                
        	}
        	
        	@Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                int action = event.getAction();
                int keyCode = event.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.KEYCODE_VOLUME_UP:
                        if (action == KeyEvent.ACTION_DOWN) {
                        	if(size<max_size)
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

	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
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
    	    Intent i = new Intent(Toys_info_activity.this , Activity_Email.class);
			i.putExtra(SUBJECT, "מידע על משחקים לתוכים");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
	
}
