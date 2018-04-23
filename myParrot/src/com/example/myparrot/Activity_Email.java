package com.example.myparrot;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Activity_Email extends Activity {

	//Declare GUI variables to store user data for sending email
	EditText editTextEailNickname;
	EditText editTextEmailSubject;
	EditText editTextEmailContent;
	String emailTo = "hdriel@gmail.com";
	
	private final static String SUBJECT = "the subject to email";
	public final static String ColorTheme = "the color themes" ;
	LinearLayout email_layout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		
		email_layout  = (LinearLayout) findViewById(R.id.email_layout);
		email_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
		
		//get reference of GUI controls for retrieving user data from screen  
		editTextEailNickname     = (EditText) findViewById(R.id.email_editText_EmailFrom);
		editTextEmailSubject = (EditText) findViewById(R.id.email_editText_EmailSubject);
		editTextEmailContent = (EditText) findViewById(R.id.email_editText_EmailContent);
		
		String subject = getIntent().getStringExtra(SUBJECT);
		editTextEmailSubject.setText(subject);
	}

	public void onButtonClickSend(View v)
	{
	   //get to, subject and content from the user input and store as string.
		  //String emailTo 		= editTextEailFrom.getText().toString();
		  String emailSubject 	= "לגבי המסך: " + editTextEmailSubject.getText().toString();
		  
		  String emailContent 	= 	"מאת: " + editTextEailNickname.getText().toString() + "\n"
				  					+"גולש ממכשיר: " + getDeviceName() + "\n"
		                            + editTextEmailContent.getText().toString();

		  Intent emailIntent = new Intent(Intent.ACTION_SEND);
		  emailIntent.putExtra(Intent.EXTRA_EMAIL,  new String[]{ emailTo});
		  emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
		  emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);
	  /// use below 2 commented lines if need to use BCC an CC feature in email
		  //emailIntent.putExtra(Intent.EXTRA_CC, new String[]{ to});
		  //emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{to});
	  ////use below 3 commented lines if need to send attachment
		  //emailIntent .setType("image/jpeg");
		  //emailIntent .putExtra(Intent.EXTRA_SUBJECT, "My Picture");
		  //emailIntent .putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard/captureimage.png"));

		  //need this to prompts email client only
		  emailIntent.setType("message/rfc822");
		  
		  startActivity(Intent.createChooser(emailIntent, "Select an Email Client:"));
		  
	}

	public void onButtonClickCancel(View v)
	{
		finish();
	}
	
	public String getDeviceName() {
	    String manufacturer = Build.MANUFACTURER;
	    String model = Build.MODEL;
	    if (model.startsWith(manufacturer)) {
	        return capitalize(model);
	    } else {
	        return capitalize(manufacturer) + " " + model;
	    }
	}


	private String capitalize(String s) {
	    if (s == null || s.length() == 0) {
	        return "";
	    }
	    char first = s.charAt(0);
	    if (Character.isUpperCase(first)) {
	        return s;
	    } else {
	        return Character.toUpperCase(first) + s.substring(1);
	    }
	} 
	
}