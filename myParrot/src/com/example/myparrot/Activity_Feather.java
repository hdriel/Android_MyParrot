package com.example.myparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;


public class Activity_Feather extends Activity {

	ToggleButton tgl_btn;
	LinearLayout lay_feather, lay_nail;
	ScrollView sv_feather, sv_nail;
	int size = 17 , max_size = 35, min_size = 8 , to_button_color;
	TextView feather0,feather1,feather2,feather3,nail0,nail1,nail2;
	ImageView imagef1 ,imagef2 ,imagef3 ,imagef4 ,imagef5 ,imagen1 ,imagen2 ,imagen3 ,imagen4;
	Intent im;
	
	SharedPreferences prefs;
	public static final String MyPREFERENCES = "MyPrefs" ;
	
	private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";
	public static final String SizeText = "SizeOfText";
	public final static String ColorTheme = "the color themes" ;
	public static final String BACKGROUND_BUTTON_feather = "BACKGROUND BUTTON FEATHER" ;
	LinearLayout feather;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_feather);
        
        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        
        feather = (LinearLayout) findViewById(R.id.feather_layout);
        feather.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        
        
        feather0 = (TextView) findViewById(R.id.fea_0);
        feather1 = (TextView) findViewById(R.id.fea_1);
        feather2 = (TextView) findViewById(R.id.fea_2);
        feather3 = (TextView) findViewById(R.id.fea_3);
        nail0    = (TextView) findViewById(R.id.nail_0);
        nail1    = (TextView) findViewById(R.id.nail_1);
        nail2    = (TextView) findViewById(R.id.nail_2);
        
        imagef1 = (ImageView) findViewById(R.id.fea_image_1);
        imagef1.setTag(R.drawable.f1);
        imagef2 = (ImageView) findViewById(R.id.fea_image_2);
        imagef2.setTag(R.drawable.f2);
        imagef3 = (ImageView) findViewById(R.id.fea_image_3);
        imagef3.setTag(R.drawable.f3);
        imagef4 = (ImageView) findViewById(R.id.fea_image_4);
        imagef4.setTag(R.drawable.f4);
        imagef5 = (ImageView) findViewById(R.id.fea_image_5);
        imagef5.setTag(R.drawable.f5);
        
        imagen1 = (ImageView) findViewById(R.id.nail_image_1);
        imagen1.setTag(R.drawable.n1);
        imagen2 = (ImageView) findViewById(R.id.nail_image_2);
        imagen2.setTag(R.drawable.n2);
        imagen3 = (ImageView) findViewById(R.id.nail_image_3);
        imagen3.setTag(R.drawable.n3);
        imagen4 = (ImageView) findViewById(R.id.nail_image_4);
        imagen4.setTag(R.drawable.n4);
        
        
        tgl_btn = (ToggleButton) findViewById(R.id.fea_toggle_btn);
        tgl_btn.setBackgroundResource(getIntent().getIntExtra(BACKGROUND_BUTTON_feather, 0));
        
        lay_feather = (LinearLayout) findViewById(R.id.fea_lay);
        lay_nail = (LinearLayout) findViewById(R.id.nail_lay);
        sv_feather = (ScrollView) findViewById(R.id.nail_scrol);
        sv_nail  = (ScrollView) findViewById(R.id.nail_scrol); 
        
        size = prefs.getInt(SizeText, size);
        setTextSize(size);
        
        im = new Intent(Activity_Feather.this, ActivityImageToZoom.class);
        
        //tgl_btn.setChecked(prefs.getBoolean(ModeToggle, prefsMode));
	    
	    if (tgl_btn.isChecked()) {
	    	lay_feather.setVisibility(View.VISIBLE);
	    	lay_nail.setVisibility(View.GONE);
		}
    	else {
    		lay_feather.setVisibility(View.GONE);
    		lay_nail.setVisibility(View.VISIBLE);
		}
	    
	    tgl_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	if (tgl_btn.isChecked()) {
            		lay_feather.setVisibility(View.VISIBLE);
            		lay_nail.setVisibility(View.GONE);
				}
            	else {
            		lay_feather.setVisibility(View.GONE);
            		lay_nail.setVisibility(View.VISIBLE);
				}
            }
	        });
    
	    
	    imagef1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagef1));
				startActivity(im);
			}
		});
	    imagef2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagef2));
				startActivity(im);
			}
		});
	    imagef3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagef3));
				startActivity(im);
			}
		});
	    imagef4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagef4));
				startActivity(im);
			}
		});
	    imagef5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagef5));
				startActivity(im);
			}
		});
	    imagen1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagen1));
				startActivity(im);
			}
		});
	    imagen2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagen2));
				startActivity(im);
			}
		});
	    imagen3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagen3));
				startActivity(im);
			}
		});
	    imagen4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(imagen4));
				startActivity(im);
			}
		});
	    
	    
	    
    }
    
    private void setTextSize(int size){
    	feather0.setTextSize(size);
        feather1.setTextSize(size);
        feather2.setTextSize(size);
        feather3.setTextSize(size);
        nail0.setTextSize(size);
        nail1.setTextSize(size);
        nail2.setTextSize(size);
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
    
    private int getDrawableId(ImageView iv) {
	    return (Integer) iv.getTag();
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
    	    Intent i = new Intent(Activity_Feather.this , Activity_Email.class);
			i.putExtra(SUBJECT, "גזירת נוצות וציפורנייה");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}
