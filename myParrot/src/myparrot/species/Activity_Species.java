package myparrot.species;

import java.util.ArrayList;

import myparrot.stands.ActivityToCall;
import myparrot.stands.Activity_Stands;

import com.example.myparrot.Activity_About;
import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class Activity_Species extends Activity {

	public static final String EXTRA_RES_ID = "name";
	public static final String JAKO = "ג\'אקו", TOCON= "תוכון" , COCKOTAIL = "קוקטייל" , 
			   DRARA = "דררה" , CONURE = "קוניור", COCKATOO = "קאקדו", 
			   LOVE_BIRD = "תוכי אהבה", ARA = "ארה", LORY = "לורי";
	
	private GridviewAdapter mAdapter;
	private ArrayList<String> listParrot;
	private ArrayList<Integer> listIconParrot;
	
	private GridView gridView;
	
	public final static String ColorTheme = "the color themes" ;
	LinearLayout species;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_species);
    
        species = (LinearLayout) findViewById(R.id.species_layout);
        species.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        prepareList();
        
        // prepared arraylist and passed it to the Adapter class
        mAdapter = new GridviewAdapter(this,listParrot, listIconParrot);
        
        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.species_gridView);
        gridView.setAdapter(mAdapter);
        
        // Implement On Item click listener
        gridView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(Activity_Species.this,	ActivityItemToCall.class);
				
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, mAdapter.getItem(position));
				intent.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
				// Start the ImageViewActivity
				startActivity(intent);
			
			}
		});
        
    }
    
    public void prepareList()
    {
    	  listParrot = new ArrayList<String>();
    	  
    	  listParrot.add(JAKO);
    	  listParrot.add(TOCON);
          listParrot.add(DRARA);
          listParrot.add(COCKOTAIL);
          listParrot.add(COCKATOO);
          listParrot.add(CONURE);
          listParrot.add(ARA);
          listParrot.add(LOVE_BIRD);
          listParrot.add(LORY);
          
          listIconParrot = new ArrayList<Integer>();
          listIconParrot.add(R.drawable.i_jako);
          listIconParrot.add(R.drawable.i_tucon2);
          listIconParrot.add(R.drawable.i_drara);
          listIconParrot.add(R.drawable.i_cockatail);
          listIconParrot.add(R.drawable.i_cockatoo);
          listIconParrot.add(R.drawable.i_conure);
          listIconParrot.add(R.drawable.i_hara);
          listIconParrot.add(R.drawable.i_love);
          listIconParrot.add(R.drawable.i_lory);
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
    	    Intent i = new Intent(Activity_Species.this , Activity_Email.class);
			i.putExtra(SUBJECT, "זנים וסוגים שונים");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
   
}
