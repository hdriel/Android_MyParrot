package myparrot.toys;

import java.util.ArrayList;

import myparrot.stands.Activity_Stands;


import com.example.myparrot.ActivityImageToZoom;
import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;



public class Activity_Toys extends Activity {

	 ListView list;
     public  ArrayList<ListModelToys> CustomListViewValuesArr = new ArrayList<ListModelToys>();
     private ToggleButton btn_gone_gallery;
     private TextView titltGallery;
     private Gallery gallery;
     private Button btn_info , btn_info_game;
     private Context c;
     private Dialog dialog;
     
     
     Intent i = new Intent(Activity_Toys.this,	ActivityImageToZoom.class);;
     
     private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";
     final String CHOOSE = "choose what the button show";
     public static final String EXTRA_RES_ID_TOY = "POS";
     public final static String ColorTheme = "the color themes" ;
 	 LinearLayout toy_layout;
     
     private Integer[] pic = {
	            R.drawable.toy_home1,
	            R.drawable.toy_home2,
	            R.drawable.toy_home3,
	            R.drawable.toy_home4,
	            R.drawable.toy_home5,
	            R.drawable.toy_home6,
	            R.drawable.toy_home7,
	            R.drawable.toy_home8,
	            R.drawable.toy_home9,
	            R.drawable.toy_home10
	    };
     
     
     
     ToyCustomAdapter dataAdapter = null;
     
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_toys);
        
        
        
        c = this;
        
        toy_layout = (LinearLayout) findViewById(R.id.toy_layout);
        toy_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        titltGallery = (TextView) findViewById(R.id.toy_title);
        
        btn_gone_gallery = (ToggleButton) findViewById(R.id.toy_btn_gallery_gone);
        btn_gone_gallery.setOnCheckedChangeListener(toggleButtonChangeListener);
        
        
        gallery = (Gallery) findViewById(R.id.toy_gallery_home);
        gallery.setSpacing(1);
        gallery.setAdapter(new ToyImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {
            //@Override
        	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
             try{
            	 i = new Intent(Activity_Toys.this,	ActivityImageToZoom.class);
            	 //ImageView im = null;
    			 //im.setImageResource(pic[position]);
            	 i.putExtra(IMAGE_ZOOM, pic[position]);
                 startActivity(i);
             }catch(Exception e){
            	 Toast.makeText(c,"לא הצליח לטעון תמונה",Toast.LENGTH_SHORT).show();
        	 }
        	}
        });
        
        
        btn_info = (Button) findViewById(R.id.toy_btn_info);
        btn_info.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					Intent info = new Intent(Activity_Toys.this, Toys_info_activity.class);
					info.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
					startActivity(info);
				}catch(Exception e){
				}
			}
		});
        btn_info_game = (Button) findViewById(R.id.toy_btn_info_game);
        btn_info_game.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					Intent info_game = new Intent(Activity_Toys.this, Toys_info_game_activity.class);
					info_game.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
					startActivity(info_game);
				}catch(Exception e){
					
				}
			}
		});
        
        list = (ListView) findViewById(R.id.toy_activity_listView);
        
        displayListView();
    }          
        
        private void displayListView() {
        	  Log.d("activity toy", "נכנס לשיטה displayListView");
        	  //Array list of countries
        	  String decription = "";
        	  ArrayList<ListModelToys> ToyList = new ArrayList<ListModelToys>();
        	  decription = "בעזרת חליפת טיסה לתוכי וחליפת האימון שלנו תוכלו לגדל את התוכים שלכם בראש \'\'נקי\'\'." +"\n"+
							"מהי חליפת טיסה לתוכי?"+"\n"+
							"חליפת הטיסה היא ביגוד חכם ורב פעמי בעל  \'\'כיס ניקיון \'\' שאוגר ושומר על צרכי התוכי (הרחק מגופו) ובכך אתם שומרים על ניקיון הסביבה שלכם."+"\n"+ "יש אותו במגוון צבעים לבחירה";
        	  ListModelToys toy1 = new ListModelToys("חליפת טיסה",decription,R.drawable.toy_item1, "http://www.avianfashions.co.il/רכישה.htm");
        	  
        	  decription ="בזכות רתמות לתוכים היום ניתן לבלות עם התוכי האהוב שלכם מחוץ לבית ללא החשש שיברח. ניתן להלביש את הרתמה על הגוף של התוכי, באותו עיקרון של רתמה לכלב, ולכן אין סכנה לפיגועה בכנפיים או רגליים."+"\n"+
					  	  "כבעלי תוכים אנו אוהבים מאוד את בעלי הכנף המיוחדים האלה אז למה לא לחלוק עם העולם קצת מהאהבה. העניקו להם את הזכות לאוויר צח ושמש חמימה. " +"\n"+
						  "טיולים בחוץ הם דרך מצוינת להעניק לתוכים שלכם אפשרות לגירויים מוחיים. כל מראה, חפץ או יצור חדש שהתוכי נחשף אליו גורמים לו סקרנות ועניין. חשיפה זאת מלבד הפגת השיעמום גם עוזרת לפיתוח הביטחון העצמי של התוכי. תוכי עם ביטחון עצמי גבוה הוא תוכי שלא ינשך אף אחד, ואחד כזה שישחק עם כולם."+"\n"+
						  "הרתמה מושלמת לטיולים בטוחים בחוץ - פשוט מלבישים ויוצאים. הרתמה לא לוכדת את הצרכים של התוכי. אם אתם רוצים לצאת עם התוכי אבל דואגים על הלכלוך, יש את הרצועת טיולים שמחוברת לחליפת טיסה.";
        	  ListModelToys toy2 = new ListModelToys("רתמה לתוכים" ,decription, R.drawable.toy_item2, "http://www.avianfashions.co.il/רתמה-לתוכים.htm");
        	  decription = "קילקר לאילוף תוכים נחשב כיום לטכנולוגיה הכי מתקדמת לאילוף תוכים. טכנולוגיה פשוטה אמנם, אך טומנת בתוכה רעיון גדול."+"\n"+
        			  		"תפקידו של הקליקר הוא לעשות \'\'קליק\'\', מעין צליל ברור בתדר אחיד. המטרה: למשמש דרך תקשורת (חד משמעית) בינינו לתוכים שלנו בזמן האילוף. הקולות שלנו משתנים, הטון, והמילים לא תמיד באותו הקשר. \'\'הקליק\'\' שהקליקר לאילוף תוכים משמיע הוא קבוע ואינו מבלבל את התוכים." +"\n"+
        			  		"הקליקר שלנו מעוצב בצורה הנוחה לאחיזת אילוף (אחיזה מיוחדת) המאפשרת לכם שימוש בשתי הידיים בזמן האילוף. "+"\n"+"מיטב מאלפי התוכים בעולם נוהגים להשתמש בקליקר מהסוג הזה.";
        	  ListModelToys toy3 = new ListModelToys("קליקר לאילוף תוכים",decription, R.drawable.toy_item3, "http://www.avianfashions.co.il/קליקר-לאילוף-תוכים.htm");
        	  
        	  decription = "משמש מעין נדנדה בתוך הכלוב או בסטנד כלשהו";
        	  ListModelToys toy4 = new ListModelToys("צעצוע טבעת חבל לתוכים טריקסי במגוון מידות",decription, R.drawable.toy_item4, "http://www.buldog.co.il/cat/623-צעצועים-לתוכי");
        	  
        	  decription = "מקל שיוף לציפורים ולתוכים קטנים, בינוניים וגדולים. מיועד לשיוף מקור וציפורניים. מתאים לתלייה לכל סוגי הכלובים. מעצב לאחיזה נכונה ובריאה (למניעת פטריות ברגליים).";
        	  ListModelToys toy5 = new ListModelToys("מקל שיוף לתוכים",decription,R.drawable.toy_item5, "http://www.gag-lachayot.co.il/product.asp?id=3447&catcode=89&parentId=");
        	  
        	  decription = "חבל טיפוס ומשחק לתוכים עם פעמון, בצורת ספירלה";
        	  ListModelToys toy6 = new ListModelToys("צעצוע חבל ספירלי לתוכי",decription,R.drawable.toy_item6, "http://www.zoocenter.co.il/en/221-צעצוע-חבל-ספירלי-לתוכי-trixie.html");
        	  
        	  decription = "סולם טיפוס לתוכים.";
        	  ListModelToys toy7 = new ListModelToys("סולם עץ לתוכים",decription,R.drawable.toy_item7, "http://www.miniinthebox.com/he/wooden-ladder-bird-toy-for-parrots_p651662.html");
        	  
        	  decription = "התוכים נהנים לפרק את הקש ואת העץ, צעצוע מתכלה אך מהנה לתוכים";
        	  ListModelToys toy8 = new ListModelToys("צעצוע תלויה למשחק",decription,R.drawable.toy_item8, "http://www.ebay.com/itm/Parrot-Bird-Wooden-Loofah-Sponge-Cage-Ladder-Swings-Bell-Climb-Hanging-Toy-/271560872146?hash=item3f3a4a10d2");
        	  
        	  decription = "משחק לתוכי";
        	  ListModelToys toy9 = new ListModelToys("2 צעצוע תלויה למשחק",decription,R.drawable.toy_item9, "http://www.ebay.com/itm/Pet-Bird-Bites-Toy-Parrot-Climb-Chew-Toys-Swing-Cage-Cockatiel-Parakeet-/161721896850?hash=item25a7604f92");
        	  
        	  
        	  ToyList.add(toy1);
        	  ToyList.add(toy2);
        	  ToyList.add(toy3);
        	  ToyList.add(toy4);
        	  ToyList.add(toy5);
        	  ToyList.add(toy6);
        	  ToyList.add(toy7);
        	  ToyList.add(toy8);
        	  ToyList.add(toy9);
        	  
        	  
        	  /*
        	   * add item to ToylistView
        	  toy = new ListModelToys("title","description",R.drawable.toy_item2, "http://www.xxx.co.il");
        	  ToyList.add(toy);
        	  */
        	  
        	  //create an ArrayAdaptar from the String Array
        	  dataAdapter = new ToyCustomAdapter(this, this, R.layout.list_item_toys, ToyList);
        	  
        	  list.setAdapter(dataAdapter);
        	  
        	  list.setOnItemClickListener(new OnItemClickListener() {
        		  @Override
        	   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	    // When clicked, show a toast with the TextView text
        		   ListModelToys toys_item = (ListModelToys) parent.getItemAtPosition(position);
        		   
        		   dialog = new Dialog(c);
        		   dialog.setContentView(R.layout.toy_list_view_details);
        		   dialog.setTitle(toys_item.getTitle());
        		   
        		   TextView description = (TextView) dialog.findViewById(R.id.toy_detail_description);
        		   description.setText(toys_item.getDescreption());

        		   final TextView link = (TextView) dialog.findViewById(R.id.toy_detail_link);
        		   link.setTextColor(0xFF0000FF);
        		   link.setText(toys_item.getUrl());
        		   
        		   //dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, toys_item.getImage());
        		   
        		   dialog.show();
        		   
        		   link.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
		                myWebLink.setData(Uri.parse(link.getText().toString()));
		                startActivity(myWebLink);
					}
				});
        		   
        	   }
        	  });
        	  
        	  
   }
    
    final CompoundButton.OnCheckedChangeListener toggleButtonChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        	if (isChecked){
        		titltGallery.setVisibility(View.GONE);
    			gallery.setVisibility(View.GONE);
    			btn_info.setVisibility(View.VISIBLE);
    			btn_info_game.setVisibility(View.VISIBLE);
    			btn_gone_gallery.setWidth(350);
        	}
        	else {
        		titltGallery.setVisibility(View.VISIBLE);
    			gallery.setVisibility(View.VISIBLE);
    			btn_gone_gallery.setWidth(70);
    			btn_info.setVisibility(View.GONE);
    			btn_info_game.setVisibility(View.GONE);
        	}
        }
    };
    
    private int getDrawableId(ImageView iv) {
	    return (Integer) iv.getTag();
	}
    
    public void onCheckChanged(CompoundButton compoundButton, boolean b){
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
    	    Intent i = new Intent(Activity_Toys.this , Activity_Email.class);
			i.putExtra(SUBJECT, "צעצועים לתוכים");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
    
}
