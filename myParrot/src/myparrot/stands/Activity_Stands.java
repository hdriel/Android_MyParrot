package myparrot.stands;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

import myparrot.species.ActivityItemToCall;

import com.example.myparrot.ActivityImageToZoom;
import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;




public class Activity_Stands extends Activity
{
	private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";
	
	private ArrayList<Integer> mThumbIdsFlowers = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.s1, R.drawable.s2,R.drawable.s3, R.drawable.s4, R.drawable.s5,
				  R.drawable.s6, R.drawable.s7, R.drawable.s8,R.drawable.s9, R.drawable.s10,
				  R.drawable.s11,R.drawable.s12 ,R.drawable.s13, R.drawable.s14,R.drawable.s15,
				  R.drawable.s16, R.drawable.s17, R.drawable.s18,R.drawable.s19, R.drawable.s20,
				  R.drawable.s21,R.drawable.s22,R.drawable.s23, R.drawable.s24,R.drawable.s25,
				  R.drawable.s26, R.drawable.s27, R.drawable.s28,R.drawable.s29, R.drawable.s30,
				  R.drawable.s31, R.drawable.s32
				));
	
	protected static final String EXTRA_RES_ID = "POS";
	public final static String ColorTheme = "the color themes" ;
	LinearLayout stands;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_stands);

        stands = (LinearLayout) findViewById(R.id.stands_layout);
        stands.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        GridView gridview = (GridView) findViewById(R.id.gridview_stands);

		// Create a new ImageAdapter and set it as the Adapter for this GridView
		gridview.setAdapter(new ImageAdapter(this, mThumbIdsFlowers));

		// Set an setOnItemClickListener on the GridView
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
				 
	   			//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(Activity_Stands.this,	ActivityImageToZoom.class);
				
				// Add the ID of the thumbnail to display as an Intent Extra
	   			intent.putExtra(IMAGE_ZOOM, (int) id);
				
				// Start the ImageViewActivity
				startActivity(intent);
				
				
			}
		});
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
    	    Intent i = new Intent(Activity_Stands.this , Activity_Email.class);
			i.putExtra(SUBJECT, "מעמדים לתוכים");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}