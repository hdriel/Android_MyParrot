package com.example.myparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class Activity_Food extends Activity {

	TextView link , text1, text2, text3 , text4 , text5 , text6, text7, text8, text9, text10;
	ImageView image1, image2, image3, image4,image5,image6,image7,image8,image9, image10, image11;
    
    Intent im;
	int size = 17 , max_size = 35, min_size = 8;
	private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";
	
	LinearLayout food_layout;
	public final static String ColorTheme = "the color themes" ;
	
	
	SharedPreferences prefs;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String SizeText = "SizeOfText";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_food);
        
        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        
        
        food_layout = (LinearLayout) findViewById(R.id.food_layout);
        food_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        text1   = (TextView) findViewById(R.id.food1);
        text2   = (TextView) findViewById(R.id.food2);
        text3   = (TextView) findViewById(R.id.food3);
        text4   = (TextView) findViewById(R.id.food4);
        text5   = (TextView) findViewById(R.id.food5);
        text6   = (TextView) findViewById(R.id.food6); 
        text7   = (TextView) findViewById(R.id.food7);
        text8   = (TextView) findViewById(R.id.food8);
        text9   = (TextView) findViewById(R.id.food9); 
        text10  = (TextView) findViewById(R.id.food10);
        
        link = (TextView)findViewById(R.id.food_url);
        link.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(link.getText().toString()));
                startActivity(myWebLink);
             }
        });
        
        size = prefs.getInt(SizeText, size);
        setTextSize(size);
        
        image1  = (ImageView) findViewById(R.id.food_image_1);
        image1.setTag(R.drawable.food1);
        
        image2  = (ImageView) findViewById(R.id.food_image_2);
        image2.setTag(R.drawable.food2);
        
        image3  = (ImageView) findViewById(R.id.food_image_3);
        image3.setTag(R.drawable.food3);
        
        image4  = (ImageView) findViewById(R.id.food_image_4);
        image4.setTag(R.drawable.food4);
        
        image5  = (ImageView) findViewById(R.id.food_image_5);
        image5.setTag(R.drawable.food5);
        
        image6  = (ImageView) findViewById(R.id.food_image_6);
        image6.setTag(R.drawable.food6);
        
        image7  = (ImageView) findViewById(R.id.food_image_7);
        image7.setTag(R.drawable.food7);
        
        image8  = (ImageView) findViewById(R.id.food_image_8);
        image8.setTag(R.drawable.food8);
        
        image9  = (ImageView) findViewById(R.id.food_image_9);
        image9.setTag(R.drawable.food9);
        
        image10 = (ImageView) findViewById(R.id.food_image_10);
        image10.setTag(R.drawable.food10);
        
        image11 = (ImageView) findViewById(R.id.food_image_11);
        image11.setTag(R.drawable.food11);
        
        im = new Intent(Activity_Food.this, ActivityImageToZoom.class);
        
        image1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image1));
				startActivity(im);
			}
		});
        image2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image2));
				startActivity(im);
			}
		});
        image3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image3));
				startActivity(im);
			}
		});
        image4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image4));
				startActivity(im);
			}
		});
        image5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image5));
				startActivity(im);
			}
		});
        image6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image6));
				startActivity(im);
			}
		});
        image7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image7));
				startActivity(im);
			}
		});
        image8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image8));
				startActivity(im);
			}
		});
        image9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image9));
				startActivity(im);
			}
		});
        image10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image10));
				startActivity(im);
			}
		});
        image11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.putExtra(IMAGE_ZOOM, getDrawableId(image11));
				startActivity(im);
			}
		});
        
 }
	
    
	private void setTextSize(int size){
        text2.setTextSize(size);
        text3.setTextSize(size);
        text4.setTextSize(size);
        text5.setTextSize(size);
        text6.setTextSize(size);
        text7.setTextSize(size);
        text8.setTextSize(size);
        text9.setTextSize(size);
        text10.setTextSize(size);
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
    	    Intent i = new Intent(Activity_Food.this , Activity_Email.class);
			i.putExtra(SUBJECT, "ъжерд");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}
