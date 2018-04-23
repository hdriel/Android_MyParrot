package myparrot.vets;

import com.example.myparrot.ActivityImageToZoom;
import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityToCallVets extends Activity {
	 
	final static String CITY = "name_of_city"; 
	final static String CLINIC = "name_of_clinic"; 
	final static String HOURS = "Hours_information"; 
	final static String NOTE = "note"; 
	final static String PHONE = "num_of_phone"; 
	final static String ADRESS = "the adress";
	final static String LINK = "the link";
	final static String IMAGE = "image_of_clinic";
	
	private TextView city , clinic, hours, note, phone, adress, link;
	private ImageView image;
	private Button btn_call, btn_waze;
	
	private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";
	public final static String ColorTheme = "the color themes" ;
	LinearLayout vet_item;
	
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.vet_list_item_leanerlayout_activity);
	        
	        vet_item = (LinearLayout) findViewById(R.id.vet_item_layout);
	        vet_item.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
	        
	        city    = (TextView) findViewById(R.id.vet_city_name);
	        clinic  = (TextView) findViewById(R.id.vet_clinic_name);
	        hours   = (TextView) findViewById(R.id.vet_hoursOpen_contain);
	        note    = (TextView) findViewById(R.id.vet_note_contain);
	        phone   = (TextView) findViewById(R.id.vet_phone_num);
	        adress  = (TextView) findViewById(R.id.vet_adress_name);
	        link 	= (TextView) findViewById(R.id.vet_link_name);
	        image   = (ImageView)findViewById(R.id.vet_image);
	        btn_call = (Button) findViewById(R.id.vet_phone_call);
	        btn_waze = (Button) findViewById(R.id.vet_adress_call);
	        
	        
	        
	        city.setText(getIntent().getStringExtra(CITY));
	        clinic.setText(getIntent().getStringExtra(CLINIC));
	        hours.setText(getIntent().getStringExtra(HOURS));
	        note.setText(getIntent().getStringExtra(NOTE));
	        phone.setText(getIntent().getStringExtra(PHONE));
	        adress.setText(getIntent().getStringExtra(ADRESS));
	        link.setText(getIntent().getStringExtra(LINK));
	        image.setImageResource(getIntent().getIntExtra(IMAGE, 0));
	        image.setTag(getIntent().getIntExtra(IMAGE, 0));
	        
	        
	        if(link.getText().toString()!="לא נמצא קישור לאתר המרפאה"){
	        	link.setTextColor(Color.BLUE);
	        }
	        btn_call.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					try {
						// set the data
						String uri = "tel:"+phone.getText().toString();
						Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
						startActivity(callIntent);
					}catch(Exception e) {
						Toast.makeText(getApplicationContext(),"Your call has failed...",
							Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
					
				}
			});
	        
	        btn_waze.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
	        
	        link.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	                myWebLink.setData(Uri.parse(link.getText().toString()));
	                startActivity(myWebLink);
	             }
	        });
	        
	        
	        image.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent im = new Intent(ActivityToCallVets.this, ActivityImageToZoom.class);
					im.putExtra(IMAGE_ZOOM, getDrawableId(image));
					startActivity(im);
				}
			});
	}
	
	private int getDrawableId(ImageView iv) {
	    return (Integer) iv.getTag();
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
	    	    Intent i = new Intent(ActivityToCallVets.this , Activity_Email.class);
				i.putExtra(SUBJECT, "פריט - וטרינרים לבעלי כנף");
				i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
				startActivity(i);
	       }
	         return true; 
	          default:  
	            return super.onOptionsItemSelected(item);  
	        }
	    }		
}
