package myparrot.main;


import com.example.myparrot.Activity_About;
import com.example.myparrot.Activity_Email;
import com.example.myparrot.Activity_Feather;
import com.example.myparrot.Activity_Food;
import com.example.myparrot.Activity_Training;
import com.example.myparrot.R;

import myparrot.diseases.Activity_Diseases;
import myparrot.list.food.Activity_Food_List;
import myparrot.species.Activity_Species;
import myparrot.stands.Activity_Stands;
import myparrot.toys.Activity_Toys;
import myparrot.vets.Activity_Vets;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.DialogInterface;
import android.app.AlertDialog;

public class MainActivity extends Activity {
	
	Intent i;
	Button bt_about, bt_diseases , bt_food_list , bt_feather , bt_profile,
	       bt_stands, bt_toys, bt_training, bt_vet, bt_species;
	int background_layout , background_button , vet_childColor , vet_parentColor , feather_button;
	TextView title;
	Typeface type1, type2, type3;
	Animation vanish ;
    AnimatorSet setRightOut , setLeftIn;
	LinearLayout lay_main;
	Context c;
    MediaPlayer soundclick;
	SharedPreferences prefs;
	
	private final static String SUBJECT = "the subject to email";
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String BACKGROUND = "BACKGROUND LAYOUT" ;
	public static final String BACKGROUND_BUTTON_feather = "BACKGROUND BUTTON FEATHER" ;
	public static final String BACKGROUND_BUTTON = "BACKGROUND BUTTON" ;
	public final static String ColorTheme = "the color themes" ;
	public final static String ColorThemechild = "the color themes of child list" ;
	public final static String ColorThemeparent = "the color themes of parent list" ;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AudioManager mgr = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        mgr.setStreamMute(AudioManager.STREAM_SYSTEM, true);
        
        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        
        c = this;
        
        title        = (TextView) findViewById(R.id.main_title);
        bt_about     = (Button)findViewById(R.id.lay_btn_about);
        bt_diseases  = (Button)findViewById(R.id.lay_btn_diseases);
        bt_food_list = (Button)findViewById(R.id.lay_btn_list_food);
        bt_feather   = (Button)findViewById(R.id.lay_btn_feather_and_nails);
        bt_profile   = (Button)findViewById(R.id.lay_btn_profile);
	    bt_stands    = (Button)findViewById(R.id.lay_btn_stands);
	    bt_toys      = (Button)findViewById(R.id.lay_btn_toys);
	    bt_training  = (Button)findViewById(R.id.lay_btn_training);
	    bt_vet       = (Button)findViewById(R.id.lay_btn_vet_parrot);
	    bt_species   = (Button)findViewById(R.id.lay_btn_species);
	    
	    type1 = Typeface.createFromAsset(getAssets(),"migdalfontwin-webfont.ttf"); 
	    type2 = Typeface.createFromAsset(getAssets(),"retper-webfont.ttf"); 
	    type3 = Typeface.createFromAsset(getAssets(),"trashimclm-bold-webfont.ttf"); 
	    
	    
	    lay_main = (LinearLayout) findViewById(R.id.layouy_main);
	    
	    setTypefaceForAll(type3,type2);
	    
	    vanish = AnimationUtils.loadAnimation(this,R.anim.flip_button);
	    
	    background_layout = R.drawable.background_gradient_blue;
 	    background_button = R.drawable.buttonshape_blue;
 	    vet_childColor    = R.drawable.line_item_blue;
 	    vet_parentColor   = R.drawable.line_item_blue_center;
 	    feather_button     = R.drawable.button_blue;
 	    
        background_layout = prefs.getInt(BACKGROUND, 0);
 	    background_button = prefs.getInt(BACKGROUND_BUTTON, 0);
 	    vet_childColor    = prefs.getInt(ColorThemechild, 0);
 	    vet_parentColor   = prefs.getInt(ColorThemeparent, 0);
 	    feather_button     = prefs.getInt(BACKGROUND_BUTTON_feather, 0);
 	    setTheme(background_layout , background_button);
	    
 	    
 	    soundclick = MediaPlayer.create(c, R.raw.birds);
 	  
 	   
	    // Activity_About 
        bt_about.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_About.class);
				i.putExtra(ColorTheme, background_layout);
				//findViewById(R.id.lay_btn_about).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Diseases
        bt_diseases.setOnClickListener(new OnClickListener() {
					
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Diseases.class);
				i.putExtra(ColorTheme, background_layout);
				//findViewById(R.id.lay_btn_diseases).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Food_List
        bt_food_list.setOnClickListener(new OnClickListener() {
			
			public void onClick(final View v) {
				soundclick.start();
				// TODO Auto-generated method stub
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(c);
					// set title
					alertDialogBuilder.setTitle(getResources().getString(R.string.popup_listfood_title));
					// set dialog message
					alertDialogBuilder
						.setMessage(getResources().getString(R.string.popup_listfood_contain))
						.setCancelable(false)
						.setPositiveButton("מסכים",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								i = new Intent(MainActivity.this , Activity_Food_List.class);
								i.putExtra(ColorTheme, background_layout);
								//findViewById(R.id.lay_btn_list_food).startAnimation(vanish);
								zoomAnimation(v);
								soundclick.start();
								startActivity(i);
							}
						  })
						.setNegativeButton("לא מסכים",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						});
						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
						// show it
						alertDialog.show();
					}
				});
				
        // Activity_Feather
        bt_feather.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Feather.class);
				i.putExtra(ColorTheme, background_layout);
				i.putExtra(BACKGROUND_BUTTON_feather, feather_button);
				//findViewById(R.id.lay_btn_feather_and_nails).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Food
        bt_profile.setOnClickListener(new OnClickListener() {
					
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Food.class);
				i.putExtra(ColorTheme, background_layout);
				//findViewById(R.id.lay_btn_profile).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Stands
        bt_stands.setOnClickListener(new OnClickListener() {
					
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Stands.class);
				i.putExtra(ColorTheme, background_layout);
				//findViewById(R.id.lay_btn_stands).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Toys
        bt_toys.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Toys.class);
				i.putExtra(ColorTheme, background_layout);
				//findViewById(R.id.lay_btn_toys).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Training
        bt_training.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Training.class);
				i.putExtra(ColorTheme, background_layout);
				//findViewById(R.id.lay_btn_training).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Vets
        bt_vet.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Vets.class);
				i.putExtra(ColorTheme, background_layout);
				i.putExtra(ColorThemechild  , vet_childColor);
				i.putExtra(ColorThemeparent , vet_parentColor);
				//findViewById(R.id.lay_btn_vet_parrot).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
        // Activity_Species
        bt_species.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , Activity_Species.class);
				i.putExtra(ColorTheme, background_layout);
				//findViewById(R.id.lay_btn_species).startAnimation(vanish);
				zoomAnimation(v);
				soundclick.start();
				startActivity(i);
			}
		});
        
    }

    private void zoomAnimation(View view) {
		   Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
		   view.startAnimation(animation);
	   }
    
    public void setTypefaceForAll(Typeface t){
    	title.setTypeface(t);
    	bt_about.setTypeface(t);
    	bt_diseases.setTypeface(t);
    	bt_food_list.setTypeface(t);
    	bt_feather.setTypeface(t);
    	bt_profile.setTypeface(t);
        bt_stands.setTypeface(t);
        bt_toys.setTypeface(t);
        bt_training.setTypeface(t);
        bt_species.setTypeface(t);
        bt_vet.setTypeface(t);
    }
    public void setTypefaceForAll(Typeface t1,Typeface t2){
    	title.setTypeface(t1);
    	bt_about.setTypeface(t2);
    	bt_diseases.setTypeface(t2);
    	bt_food_list.setTypeface(t2);
    	bt_feather.setTypeface(t2);
    	bt_profile.setTypeface(t2);
        bt_stands.setTypeface(t2);
        bt_toys.setTypeface(t2);
        bt_training.setTypeface(t2);
        bt_species.setTypeface(t2);
        bt_vet.setTypeface(t2);
    }
    
    public void setTheme( int colorDrawableLayout ,int colorDrawableButton){
    	lay_main.setBackgroundResource(colorDrawableLayout);
    	bt_about.setBackgroundResource(colorDrawableButton);
    	bt_diseases.setBackgroundResource(colorDrawableButton);
    	bt_food_list.setBackgroundResource(colorDrawableButton);
    	bt_feather.setBackgroundResource(colorDrawableButton);
    	bt_profile.setBackgroundResource(colorDrawableButton);
        bt_stands.setBackgroundResource(colorDrawableButton);
        bt_toys.setBackgroundResource(colorDrawableButton);
        bt_training.setBackgroundResource(colorDrawableButton);
        bt_species.setBackgroundResource(colorDrawableButton);
        bt_vet.setBackgroundResource(colorDrawableButton);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {  
       case R.id.send: {
    	    i = new Intent(MainActivity.this , Activity_Email.class);
			i.putExtra(SUBJECT, "מסך ראשי");
			i.putExtra(ColorTheme, background_layout);
			
			SharedPreferences.Editor editor = prefs.edit();
            editor.putInt( BACKGROUND , background_layout);
            editor.putInt( BACKGROUND_BUTTON , background_button);
            editor.commit();
            
            startActivity(i);
            
       }
    	   return true;
       case R.id.menu_background:{
    	   
       }
          return true;
       case R.id.sub_blue:{
    	   background_layout = R.drawable.background_gradient_blue; 
    	   background_button = R.drawable.buttonshape_blue;
    	   vet_childColor    = R.drawable.line_item_blue; 
    	   vet_parentColor   = R.drawable.line_item_blue_center; 
    	   feather_button    = R.drawable.button_blue; 
    	   setTheme(background_layout , background_button);
    	   
    	   SharedPreferences.Editor editor = prefs.edit();
           editor.putInt( BACKGROUND , background_layout);
           editor.putInt( BACKGROUND_BUTTON , background_button);
           editor.putInt( ColorThemechild , vet_childColor);
           editor.putInt( ColorThemeparent , vet_parentColor);
           editor.putInt( BACKGROUND_BUTTON_feather , feather_button);
           editor.commit();
    	   
       }
         return true; 
       case R.id.sub_green:{
    	   background_layout = R.drawable.background_gradient_green; 
    	   background_button = R.drawable.buttonshape_green;
    	   vet_childColor    = R.drawable.line_item_green; 
    	   vet_parentColor   = R.drawable.line_item_green_center;
    	   feather_button    = R.drawable.button_green; 
    	   setTheme(background_layout , background_button);
    	   
    	   SharedPreferences.Editor editor = prefs.edit();
           editor.putInt( BACKGROUND , background_layout);
           editor.putInt( BACKGROUND_BUTTON , background_button);
           editor.putInt( ColorThemechild , vet_childColor);
           editor.putInt( ColorThemeparent , vet_parentColor);
           editor.putInt( BACKGROUND_BUTTON_feather , feather_button);
           editor.commit();
    	   
       }
         return true;  
       case R.id.sub_purple:{
    	   background_layout = R.drawable.background_gradient_purple; 
    	   background_button = R.drawable.buttonshape_purple;
    	   vet_childColor    = R.drawable.line_item_purple; 
    	   vet_parentColor   = R.drawable.line_item_purple_center;
    	   feather_button    = R.drawable.button_purple; 
    	   setTheme(background_layout , background_button);
    	   
    	   SharedPreferences.Editor editor = prefs.edit();
           editor.putInt( BACKGROUND , background_layout);
           editor.putInt( BACKGROUND_BUTTON , background_button);
           editor.putInt( ColorThemechild , vet_childColor);
           editor.putInt( ColorThemeparent , vet_parentColor);
           editor.putInt( BACKGROUND_BUTTON_feather , feather_button);
           editor.commit();
       }
         return true; 
       case R.id.sub_orenge:{
    	   background_layout = R.drawable.background_gradient_orange; 
    	   background_button = R.drawable.buttonshape_orange;
    	   vet_childColor    = R.drawable.line_item_orange; 
    	   vet_parentColor   = R.drawable.line_item_orange_center; 
    	   feather_button    = R.drawable.button_orange; 
    	   setTheme(background_layout , background_button);
    	   
    	   SharedPreferences.Editor editor = prefs.edit();
           editor.putInt( BACKGROUND , background_layout);
           editor.putInt( BACKGROUND_BUTTON , background_button);
           editor.putInt( ColorThemechild , vet_childColor);
           editor.putInt( ColorThemeparent , vet_parentColor);
           editor.putInt( BACKGROUND_BUTTON_feather , feather_button);
           editor.commit();
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    
}