package myparrot.list.food;

import java.util.ArrayList;
import java.util.List;

import myparrot.main.MainActivity;


import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
	

public class Activity_Food_List extends Activity implements  OnClickListener {
	
	
	
	private List<Task> listContent;
	private ListviewAdapterWithFilter adapter;
	private EditText filterText;
	private Context context;
	private ListView list;
	private PopupWindow pwindo;
	
	public final static String ColorTheme = "the color themes" ;
	LinearLayout listfood_layout;
	
	int n = 0;
		@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_food_list);
        
        listfood_layout = (LinearLayout) findViewById(R.id.listfood_layout);
        listfood_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        context = this;
        TextWatcher filterTextWatcher = new TextWatcher() {
    		public void afterTextChanged(Editable s) {
    		}
    		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    		}
    		public void onTextChanged(CharSequence s, int start, int before, int count) {
    			adapter.getFilter().filter(s);
    		}
    	};
       
        list = (ListView) findViewById(R.id.listView_food);
        list.setItemsCanFocus(false);
	    
        filterText = (EditText) findViewById(R.id.filter);
		filterText.addTextChangedListener(filterTextWatcher);
		
		listContent = new ArrayList<Task>();
		listContent  = getListContent(listContent,0,true, false);
		adapter      = new ListviewAdapterWithFilter (this, listContent);
		list.setAdapter(adapter);
		
		final String x = "שים לב!!\n\n."+"סימון X - לא אומר חד משמעית שאסור לתוכים לגמריי אלא לפעמים גם לא מומלץ, כמו כן גם אם נותנים לתוכי משהו מהדברים האלה (על אחריותך כמובן) אז לתת במינון ממש קטן!\n\n"+"סימון גולגולת - אומר שחייב לרוץ לווטרינר הקרוב עם מה שהתוכי אכל , זה ממש סכנת מוות לחיים של התוכי יכול להיות מדובר אפילו  ששעותיו ספורות";
		final String tree = "יש לשים לב כשבונים משהו לתוכי מעצים , שהם לא מורעלים לו!";
		
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);        
	    radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            // checkedId is the RadioButton selected
	        	switch (checkedId) {
	        	 
	        	case R.id.byBoth:
                {
                	    listContent = getListContent(listContent, 0 , true , false);
                	    adapter      = new ListviewAdapterWithFilter (context, listContent);
	            		list.setAdapter(adapter);
	            		Toast.makeText(context, x, Toast.LENGTH_LONG).show();
                }
                break;
                case R.id.byOk:
                    {
                    	listContent = getListContent(listContent, 1 , true, false);
                    	adapter    = new ListviewAdapterWithFilter (context, listContent);
                		list.setAdapter(adapter);
                		
                    }
                    break;
                case R.id.byNo:
                    {
                    	listContent = getListContent(listContent , -1 ,true , false);
                    	adapter   = new ListviewAdapterWithFilter (context, listContent);
                		list.setAdapter(adapter);
                		Toast.makeText(context, x, Toast.LENGTH_LONG).show();
                    }
                    break;
                 case R.id.byTree:
	                {
	                	listContent = getListContent(listContent, 1 ,true , true);
	                	adapter   = new ListviewAdapterWithFilter (context, listContent);
	            		list.setAdapter(adapter);
	            		Toast.makeText(context, tree, Toast.LENGTH_LONG).show();
	                } 
	                break;
                
	        	}
	        }
	     });
	    
	    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	TextView txt = (TextView) parent.getChildAt(position - list.getFirstVisiblePosition()).findViewById(R.id.label);
            	String item = txt.getText().toString();
                //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                onItemClickToToastInformation(txt);
            }
        });
 }
		
		
		


		private List<Task> getListContent(List<Task> ret, int i, boolean r , boolean tree){
			if(tree){
				ret = new ArrayList<Task>();
				ret.add(new Task("עץ דובדבן",         "no",R.drawable.no ,R.drawable.b4 ));
				ret.add(new Task("עץ התפוח - רעיל",         "no",R.drawable.no ,R.drawable.b31 ));
				ret.add(new Task("ערער ברושי (עץ ברוש)",         "no",R.drawable.no ,R.drawable.b12 ));
				ret.add(new Task("עץ אלון - האלונים למיניהם",         "no",R.drawable.no ,R.drawable.b20 ));
				ret.add(new Task("אִזְדָּרֶכֶת מְצוּיָה",         "no",R.drawable.no ,R.drawable.b50 ));
				ret.add(new Task("עץ התאנה - שרף העץ",         "no",R.drawable.no ,R.drawable.b69 ));
				ret.add(new Task("עץ אלון",         "no",R.drawable.no ,R.drawable.b92 ));
				ret.add(new Task("עץ קקאו",         "no",R.drawable.no ,R.drawable.b90 ));
				ret.add(new Task("עץ שקד",         "no",R.drawable.no ,R.drawable.b83 ));
				ret.add(new Task("עץ משמש",         "no",R.drawable.noi ,R.drawable.b77 ));
	    		ret.add(new Task("עץ אפרסק, נקטרינה",         "no",R.drawable.noi ,R.drawable.b78 ));
	    		ret.add(new Task("עץ שזיף",         "no",R.drawable.noi ,R.drawable.b79 ));
	    		ret.add(new Task("עץ מנגו",         "no",R.drawable.no ,R.drawable.b80 ));
	    		ret.add(new Task("עץ רימון והקליפה של הרימון",         "no",R.drawable.noi ,R.drawable.b81 ));
	    		ret.add(new Task("עץ קפה ,פולי קפה, קפאין",			"ok",R.drawable.poison ,R.drawable.a32 ));
	    		
				ret.add(new Task("אצטרובל",			"ok",R.drawable.ok ,R.drawable.a14 ));
				ret.add(new Task("דקלי בטל",			"ok",R.drawable.ok ,R.drawable.a22 ));
				ret.add(new Task("עץ שיטה",			"ok",R.drawable.ok ,R.drawable.a24 ));
				ret.add(new Task("משפחת הדקלניים",			"ok",R.drawable.ok ,R.drawable.a27 ));
				ret.add(new Task("במבוק",        "ok",R.drawable.ok ,R.drawable.a9 ));
				ret.add(new Task("אקליפטוס",			"ok",R.drawable.oki ,R.drawable.a36 ));
				ret.add(new Task("עץ גומי",			"ok",R.drawable.ok ,R.drawable.a40 ));
				ret.add(new Task("עץ זית והעלים , ללא הזיתים",			"ok",R.drawable.oki ,R.drawable.a75 ));
				
				
				
	    		
				return ret;
			}
			if(r){
				ret = new ArrayList<Task>();
			}
			if(i < 0){
				ret.add(new Task("נרקיס",          "no",R.drawable.no ,R.drawable.b1 ));
	    		ret.add(new Task("אבוקדו",         "no",R.drawable.poisoni ,R.drawable.b2 ));
	    		ret.add(new Task("אזלאיה",         "no",R.drawable.no ,R.drawable.b3 ));
	    		ret.add(new Task("עץ דובדבן",         "no",R.drawable.no ,R.drawable.b4 ));
	    		ret.add(new Task("ציפור גן עדן",          "no",R.drawable.no ,R.drawable.b5 ));
	    		ret.add(new Task("חציל",         "no",R.drawable.noi ,R.drawable.b6 ));
	    		ret.add(new Task("צנינה קוצנית",         "no",R.drawable.no ,R.drawable.b7 ));
	    		ret.add(new Task("אזליאה סינית",         "no",R.drawable.no ,R.drawable.b8 ));
	    		ret.add(new Task("לפת",          "no",R.drawable.no ,R.drawable.b9 ));
	    		ret.add(new Task("אירוסים למיניהם",         "no",R.drawable.no ,R.drawable.b10 ));
	    		ret.add(new Task("קיסוס (כל הסוגים)",         "no",R.drawable.no ,R.drawable.b11 ));
	    		ret.add(new Task("ערער ברושי (עץ ברוש)",         "no",R.drawable.no ,R.drawable.b12 ));
	    		ret.add(new Task("יקינתטון המים",          "no",R.drawable.no ,R.drawable.b13 ));
	    		ret.add(new Task("שושנת הלבנון / העמקים",         "no",R.drawable.no ,R.drawable.b14 ));
	    		ret.add(new Task("מריחואנה",         "no",R.drawable.poison ,R.drawable.b15 ));
	    		ret.add(new Task("דבקון למיניהם",         "no",R.drawable.no ,R.drawable.b16 ));
	    		ret.add(new Task("ערער גלעיני",          "no",R.drawable.no ,R.drawable.b17 ));
	    		ret.add(new Task("יקִינְתטוֹנית מעורקת",         "no",R.drawable.no ,R.drawable.b18 ));
	    		ret.add(new Task("שׁוֹשַׁנַּת יריחו",         "no",R.drawable.no ,R.drawable.b19 ));
	    		ret.add(new Task("עץ אלון האלונים למיניהם",         "no",R.drawable.no ,R.drawable.b20 ));
	    		ret.add(new Task("הַרְדּוּף הנחלים",          "no",R.drawable.no ,R.drawable.b21 ));
	    		ret.add(new Task("פרח האקלפטוס",         "no",R.drawable.no ,R.drawable.b22 ));
	    		ret.add(new Task("יקִינְתטוֹן תרבותי",         "no",R.drawable.no ,R.drawable.b23 ));
	    		ret.add(new Task("פִילוֹדֶנְדְּרוֹן למיניהם",         "no",R.drawable.no ,R.drawable.b24 ));
	    		ret.add(new Task("תפּוּחַ אֲדָמָה",          "no",R.drawable.noi ,R.drawable.b25 ));
	    		ret.add(new Task("טבק השיח",         "no",R.drawable.no ,R.drawable.b26 ));
	    		ret.add(new Task("טבק",         "no",R.drawable.no ,R.drawable.b27 ));
	    		ret.add(new Task("יקִינְתטוֹן מזרחי",         "no",R.drawable.no ,R.drawable.b28 ));
	    		ret.add(new Task("קפה",         "no",R.drawable.poisoni ,R.drawable.b30 ));
	    		ret.add(new Task("עץ התפוח - רעיל",         "no",R.drawable.noi ,R.drawable.b31 ));
	    		ret.add(new Task("פטרוזיליה",         "no",R.drawable.noi ,R.drawable.b32 ));
	    		ret.add(new Task("זרעי תפוח עץ",         "no",R.drawable.poison ,R.drawable.b33 ));
	    		ret.add(new Task("עגבניה",         "no",R.drawable.poisoni ,R.drawable.b34 ));
	    		ret.add(new Task("דיפנבכיה מנוקדת",         "no",R.drawable.noi ,R.drawable.b35 ));
	    		ret.add(new Task("אֲחִירותֶם הַחרֶשׁ",         "no",R.drawable.no ,R.drawable.b36 ));
	    		ret.add(new Task("בּוּצִין מְפוֹרָץ",         "no",R.drawable.no ,R.drawable.b37 ));
	    		ret.add(new Task("תורמוס",         "no",R.drawable.noi ,R.drawable.b38 ));
	    		ret.add(new Task("אטרופה בלדונה",         "no",R.drawable.no ,R.drawable.b39 ));
	    		ret.add(new Task("אצבעונית ארגמנית",         "no",R.drawable.no ,R.drawable.b40 ));
	    		ret.add(new Task("אקוניטון",         "no",R.drawable.no ,R.drawable.b41 ));
	    		ret.add(new Task("דורבנית סגולה",         "no",R.drawable.no ,R.drawable.b42 ));
	    		ret.add(new Task("דורנטה מצויה",         "no",R.drawable.no ,R.drawable.b43 ));
	    		ret.add(new Task("דטורה",         "no",R.drawable.no ,R.drawable.b44 ));
	    		ret.add(new Task("לנטנה ססגונית",         "no",R.drawable.no ,R.drawable.b45 ));
	    		ret.add(new Task("סולנום זיתני",         "no",R.drawable.no ,R.drawable.b46 ));
	    		ret.add(new Task("רוביניה בת-השיטה",         "no",R.drawable.no ,R.drawable.b47 ));
	    		ret.add(new Task("רוש עקוד",         "no",R.drawable.no ,R.drawable.b48 ));
	    		ret.add(new Task("קיקיון מצוי/שעועית שחורה",         "no",R.drawable.poisoni ,R.drawable.b49 ));
	    		ret.add(new Task("אִזְדָּרֶכֶת מְצוּיָה",         "no",R.drawable.no ,R.drawable.b50 ));
	    		ret.add(new Task("מזונות / דברים מלוחים",         "no",R.drawable.noi ,R.drawable.b51 ));
	    		ret.add(new Task("ירקות ממשפחת הכרובית (כרוב , כרובית , ברוקולי)",         "no",R.drawable.no ,R.drawable.b52 ));
	    		ret.add(new Task("חומר משומר – קופסאות שימורים למינהן",         "no",R.drawable.noi ,R.drawable.b53 ));
	    		ret.add(new Task("שוקולד ודברים מתוקים",         "no",R.drawable.poisoni ,R.drawable.b54 ));
	    		ret.add(new Task("כוסברה",         "no",R.drawable.noi ,R.drawable.b55 ));
	    		ret.add(new Task("שום",         "no",R.drawable.poisoni ,R.drawable.b56 ));
	    		ret.add(new Task("בצל",         "no",R.drawable.poisoni ,R.drawable.b57 ));
	    		ret.add(new Task("דובדבן",         "no",R.drawable.no ,R.drawable.b58 ));
	    		ret.add(new Task("חלבי - מוצרי חלב",         "no",R.drawable.noi ,R.drawable.b59 ));
	    		ret.add(new Task("תבלינים",         "no",R.drawable.noi ,R.drawable.b60 ));
	    		ret.add(new Task("שתיה מתוקה / מוגזת",         "no",R.drawable.noi ,R.drawable.b61 ));
	    		ret.add(new Task("אלכוהול - שתיה חריפה",         "no",R.drawable.poisoni ,R.drawable.b62 ));
	    		ret.add(new Task("שתיה חמה",         "no",R.drawable.no ,R.drawable.b63 ));
	    		ret.add(new Task("פירות יבשים",         "no",R.drawable.noi ,R.drawable.b64 ));
	    		ret.add(new Task("לימון",         "no",R.drawable.no ,R.drawable.b65 ));
	    		ret.add(new Task("נענע",         "no",R.drawable.noi ,R.drawable.b66 ));
	    		ret.add(new Task("מזונות מעובדים - ביסקוויט / קרקרים / עוגיות / עוגות",  "no",R.drawable.no ,R.drawable.b67 ));
	    		ret.add(new Task("חלווה",         "no",R.drawable.noi ,R.drawable.b68 ));
	    		ret.add(new Task("עץ התאנה - שרף העץ",         "no",R.drawable.noi ,R.drawable.b69 ));
	    		ret.add(new Task("אגוזי מקדמיה (אגוז לוז)",         "no",R.drawable.noi ,R.drawable.b70 ));
	    		ret.add(new Task("ערמונים",         "no",R.drawable.no ,R.drawable.b71 ));
	    		ret.add(new Task("בלוט",         "no",R.drawable.poison ,R.drawable.b72 ));
	    		ret.add(new Task("חטיפים - במבה / ביסלי / ביגלה / דוריטוס וכ\'\'ו",         "no",R.drawable.noi ,R.drawable.b73 ));
	    		ret.add(new Task("לחם",         "no",R.drawable.no ,R.drawable.b74 ));
	    		ret.add(new Task("צנוברים",         "no",R.drawable.noi ,R.drawable.b75 ));
	    		ret.add(new Task("שקד מר",         "no",R.drawable.poisoni ,R.drawable.b76 ));
	    		ret.add(new Task("עץ משמש",         "no",R.drawable.poisoni ,R.drawable.b77 ));
	    		ret.add(new Task("עץ אפרסק, נקטרינה",         "no",R.drawable.poisoni ,R.drawable.b78 ));
	    		ret.add(new Task("עץ שזיף",         "no",R.drawable.noi ,R.drawable.b79 ));
	    		ret.add(new Task("עץ מנגו",         "no",R.drawable.no ,R.drawable.b80 ));
	    		ret.add(new Task("עץ רימון והקליפה של הרימון",         "no",R.drawable.noi ,R.drawable.b81 ));
	    		ret.add(new Task("כל סוגי ה פטריות",         "no",R.drawable.no ,R.drawable.b82 ));
	    		ret.add(new Task("עץ שקד",         "no",R.drawable.no ,R.drawable.b83 ));
	    		ret.add(new Task("מלון מר",         "no",R.drawable.no ,R.drawable.b84 ));
	    		ret.add(new Task("גזר לבן",         "no",R.drawable.no ,R.drawable.b85 ));
	    		ret.add(new Task("פרג",         "no",R.drawable.no ,R.drawable.b86 ));
	    		ret.add(new Task("פשתה",         "no",R.drawable.noi ,R.drawable.b87 ));
	    		ret.add(new Task("פולים",         "no",R.drawable.noi ,R.drawable.b88 ));
	    		ret.add(new Task("אגוז מוסקט",         "no",R.drawable.no ,R.drawable.b89 ));
	    		ret.add(new Task("עץ קקאו",         "no",R.drawable.no ,R.drawable.b90 ));
	    		ret.add(new Task("קקטוס",         "no",R.drawable.no ,R.drawable.b91 ));
	    		ret.add(new Task("עץ אלון",         "no",R.drawable.poison ,R.drawable.b92 ));
	    		ret.add(new Task("אגבה",         "no",R.drawable.no ,R.drawable.b93 ));
	    		ret.add(new Task("אלקוסיה",         "no",R.drawable.no ,R.drawable.b94 ));
	    		ret.add(new Task("חמניות",         "no",R.drawable.no ,R.drawable.b95 ));
	    		ret.add(new Task("ערמונית הסוסים",         "no",R.drawable.noi ,R.drawable.b96 ));
	    		ret.add(new Task("אשחר",         "no",R.drawable.no ,R.drawable.b97 ));
	    		ret.add(new Task("זיתים",         "no",R.drawable.no ,R.drawable.b98 ));
	    		ret.add(new Task("קרוטון",         "no",R.drawable.noi ,R.drawable.b99 ));
	    		ret.add(new Task("קיסוס החורש",         "no",R.drawable.noi ,R.drawable.b100 ));
	    		ret.add(new Task("עץ קפה ,פולי קפה, קפאין",			"ok",R.drawable.poison ,R.drawable.a32 ));
	    		ret.add(new Task("בוטנים לא קלויים ולא מלוחים!",			"ok",R.drawable.noi ,R.drawable.a46 ));
	    		
			}
			else if(i > 0 ){
				ret.add(new Task("ציפורני החתול",   "ok",R.drawable.ok ,R.drawable.a1 ));
	    		ret.add(new Task("מנגו",         "ok",R.drawable.oki ,R.drawable.a2 ));
	    		ret.add(new Task("מגנוליה",       "ok",R.drawable.ok ,R.drawable.a3 ));
	    		ret.add(new Task("דשא",         "ok",R.drawable.ok ,R.drawable.a4 ));
	    		ret.add(new Task("היבסקוס",      "ok",R.drawable.ok ,R.drawable.a5 ));
	    		ret.add(new Task("צפורני החתול עבות","ok",R.drawable.ok ,R.drawable.a6 ));
	    		ret.add(new Task("כובע הנזיר",   	"ok",R.drawable.ok ,R.drawable.a7 ));
	    		ret.add(new Task("משפחת השושנים", "ok",R.drawable.ok ,R.drawable.a8 ));
	    		ret.add(new Task("במבוק",        "ok",R.drawable.ok ,R.drawable.a9 ));
	    		ret.add(new Task("היבסקוס משולש",  "ok",R.drawable.ok ,R.drawable.a10 ));
	    		ret.add(new Task("פטוניה",        "ok",R.drawable.ok ,R.drawable.a11 ));
	    		ret.add(new Task("תמר",			"ok",R.drawable.ok ,R.drawable.a12 ));
	    		ret.add(new Task("שרך",			"ok",R.drawable.ok ,R.drawable.a13 ));
	    		ret.add(new Task("אצטרובל",			"ok",R.drawable.oki ,R.drawable.a14 ));
	    		ret.add(new Task("יהודי נודד",			"ok",R.drawable.ok ,R.drawable.a15 ));
	    		ret.add(new Task("דקל ושנגטוניה(מניפה)",	"ok",R.drawable.ok ,R.drawable.a16 ));
	    		ret.add(new Task("חמניות",			"ok",R.drawable.oki ,R.drawable.a17 ));
	    		ret.add(new Task("יוקה",			    "ok",R.drawable.ok ,R.drawable.a18 ));
	    		ret.add(new Task("תלתן לבן",			"ok",R.drawable.ok ,R.drawable.a19 ));
	    		ret.add(new Task("ביגוניה",			"ok",R.drawable.ok ,R.drawable.a20 ));
	    		ret.add(new Task("משפחת הסרפדים",		"ok",R.drawable.ok ,R.drawable.a21 ));
	    		ret.add(new Task("דקלי בטל",			"ok",R.drawable.ok ,R.drawable.a22 ));
	    		ret.add(new Task("סיגלית אפריקאית",		 "ok",R.drawable.ok ,R.drawable.a23 ));
	    		ret.add(new Task("עץ שיטה",			"ok",R.drawable.ok ,R.drawable.a24 ));
	    		ret.add(new Task("בורמליות",			"ok",R.drawable.ok ,R.drawable.a25 ));
	    		ret.add(new Task("משפחת האננסיים",			"ok",R.drawable.ok ,R.drawable.a26 ));
	    		ret.add(new Task("משפחת הדקלניים",			"ok",R.drawable.ok ,R.drawable.a27 ));
	    		ret.add(new Task("סיגל אפריקה",			"ok",R.drawable.ok ,R.drawable.a28 ));
	    		ret.add(new Task("בונגוילאה",			"ok",R.drawable.ok ,R.drawable.a29 ));
	    		ret.add(new Task("תירס - צמח התירס",			"ok",R.drawable.oki ,R.drawable.a30 ));
	    		ret.add(new Task("נדנונית",			"ok",R.drawable.ok ,R.drawable.a31 ));
	    		ret.add(new Task("משפחת הגפניים",			"ok",R.drawable.ok ,R.drawable.a33 ));
	    		ret.add(new Task("כוכבית",			"ok",R.drawable.ok ,R.drawable.a34 ));
	    		ret.add(new Task("משפחת הוורדים",			"ok",R.drawable.ok ,R.drawable.a35 ));
	    		ret.add(new Task("אקליפטוס",			"ok",R.drawable.oki ,R.drawable.a36 ));
	    		ret.add(new Task("תפוח עץ",			"ok",R.drawable.oki ,R.drawable.a37 ));
	    		ret.add(new Task("משפחת השפתניים",			"ok",R.drawable.ok ,R.drawable.a38 ));
	    		ret.add(new Task("תאנה",			"ok",R.drawable.oki ,R.drawable.a39 ));
	    		ret.add(new Task("עץ גומי",			"ok",R.drawable.ok ,R.drawable.a40 ));
	    		ret.add(new Task("אספרגוס",			"ok",R.drawable.oki ,R.drawable.a41 ));
	    		ret.add(new Task("לוע הארי",			"ok",R.drawable.oki ,R.drawable.a42 ));
	    		ret.add(new Task("גרדניה",			"ok",R.drawable.ok ,R.drawable.a43 ));
	    		ret.add(new Task("אגוזים (מלך ופקאן) טבעיים! לא קלויים ולא מלוחים!",			"ok",R.drawable.oki ,R.drawable.a44 ));
	    		ret.add(new Task("שקדים לא קלויים ולא מלוחים!",			"ok",R.drawable.oki ,R.drawable.a45 ));
	    		ret.add(new Task("גרעינים לא קלויים ולא מלוחים!",			"ok",R.drawable.oki ,R.drawable.a47 ));
	    		ret.add(new Task("ענבים",			"ok",R.drawable.oki ,R.drawable.a48 ));
	    		ret.add(new Task("שזיף",			"ok",R.drawable.ok ,R.drawable.a49 ));
	    		ret.add(new Task("אפרסק",			"ok",R.drawable.ok ,R.drawable.a50 ));
	    		ret.add(new Task("אגס",			"ok",R.drawable.ok ,R.drawable.a51 ));
	    		ret.add(new Task("תפוז",			"ok",R.drawable.oki ,R.drawable.a52 ));
	    		ret.add(new Task("קלמנטינה",			"ok",R.drawable.ok ,R.drawable.a53 ));
	    		ret.add(new Task("גזר",			"ok",R.drawable.ok ,R.drawable.a54 ));
	    		ret.add(new Task("מלפפון",			"ok",R.drawable.ok ,R.drawable.a55 ));
	    		ret.add(new Task("אבטיח (ללא גרעינים)",			"ok",R.drawable.oki ,R.drawable.a56 ));
	    		ret.add(new Task("מלון",			"ok",R.drawable.ok ,R.drawable.a57 ));
	    		ret.add(new Task("תות שדה",			"ok",R.drawable.oki ,R.drawable.a58 ));
	    		ret.add(new Task("אורז (מבושל ללא תבלינים)",			"ok",R.drawable.ok ,R.drawable.a59 ));
	    		ret.add(new Task("עוף (מבושל ללא תבלינים)",			"ok",R.drawable.ok ,R.drawable.a60 ));
	    		ret.add(new Task("ביצה מבושלת (קשה אפילו עם הקליפה)",			"ok",R.drawable.oki ,R.drawable.a61 ));
	    		ret.add(new Task("פלפל חריף יבש",			"ok",R.drawable.oki ,R.drawable.a62 ));
	    		ret.add(new Task("חסה",			"ok",R.drawable.ok ,R.drawable.a63 ));
	    		ret.add(new Task("גמבה ופלפל חריף בכל צורה עם הגרעינים",			"ok",R.drawable.oki ,R.drawable.a64 ));
	    		ret.add(new Task("עלי בייבי",			"ok",R.drawable.ok ,R.drawable.a65 ));
	    		ret.add(new Task("קולורבי",			"ok",R.drawable.ok ,R.drawable.a66 ));
	    		ret.add(new Task("בטטה",			"ok",R.drawable.ok ,R.drawable.a67 ));
	    		ret.add(new Task("סלרי",			"ok",R.drawable.ok ,R.drawable.a68 ));
	    		ret.add(new Task("רימון (ללא הקליפה!)",			"ok",R.drawable.ok ,R.drawable.a69 ));
	    		ret.add(new Task("קוקוס וחלב קוקוס",			"ok",R.drawable.ok ,R.drawable.a70 ));
	    		ret.add(new Task("בננה",			"ok",R.drawable.oki ,R.drawable.a71 ));
	    		ret.add(new Task("שומשום",			"ok",R.drawable.ok ,R.drawable.a72 ));
	    		ret.add(new Task("תרד",			"ok",R.drawable.ok ,R.drawable.a73 ));
	    		ret.add(new Task("(-שלד של דיונון)אבן גיר או סבידה",	"ok",R.drawable.oki ,R.drawable.a74 ));
	    		ret.add(new Task("עץ זית והעלים , ללא הזיתים",			"ok",R.drawable.oki ,R.drawable.a75 ));
	    		ret.add(new Task("קטלב",			"ok",R.drawable.ok ,R.drawable.a76 ));
	    		ret.add(new Task("עץ אשור",			"ok",R.drawable.ok ,R.drawable.a77 ));
	    		ret.add(new Task("עצי הדר (לימון, תפוז גמדי, אשכולית, תפוז)",		"ok",R.drawable.ok ,R.drawable.a78 ));
	    		ret.add(new Task("עץ אלם",			"ok",R.drawable.ok ,R.drawable.a79 ));
	    		ret.add(new Task("גפן , ענבים",			"ok",R.drawable.ok ,R.drawable.a80 ));
	    		ret.add(new Task("עץ אשוח",			"ok",R.drawable.ok ,R.drawable.a81 ));
	    		ret.add(new Task("גויאבה",			"ok",R.drawable.ok ,R.drawable.a82 ));
	    		ret.add(new Task("עץ ארז",			"ok",R.drawable.ok ,R.drawable.a83 ));
	    		ret.add(new Task("עץ תמר (דקל)",			"ok",R.drawable.ok ,R.drawable.a84 ));
	    		ret.add(new Task("עץ פפאיה",			"ok",R.drawable.ok ,R.drawable.a85 ));
	    		ret.add(new Task("פפאיה",			"ok",R.drawable.ok ,R.drawable.a86 ));
	    		ret.add(new Task("עץ אגס",			"ok",R.drawable.ok ,R.drawable.a87 ));
	    		ret.add(new Task("רגלת הגינה",			"ok",R.drawable.oki ,R.drawable.a88 ));
	    		ret.add(new Task("סאסאפראס",			"ok",R.drawable.ok ,R.drawable.a89 ));
	    		ret.add(new Task("אגוז קשיו  - טבעי ולא קלוי!",			"ok",R.drawable.ok ,R.drawable.a90 ));
	    		ret.add(new Task("גרעיני דלעת - טבעי ולא מלוח!",			"ok",R.drawable.ok ,R.drawable.a91 ));
	    		ret.add(new Task("פיסטוק - טבעי ולא מלוח!",			"ok",R.drawable.ok ,R.drawable.a92 ));
	    		ret.add(new Task("אפונה בהשרייה",          "no",R.drawable.ok ,R.drawable.a93 ));
			}
			else {
				ret = getListContent(ret, 1 , false , false);
				ret = getListContent(ret, -1 , false , false);
			}
			
			return ret;
		}
		
        private TextWatcher filterTextWatcher = new TextWatcher() {

    		public void afterTextChanged(Editable s) {
    		}

    		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    		}

    		public void onTextChanged(CharSequence s, int start, int before, int count) {
    			adapter.getFilter().filter(s);
    		}

    	};

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
		public void onItemClickToToastInformation(TextView tv){
			String s = tv.getText().toString();
			String t = "";
			switch(s){
			case "אבוקדו":
				t = "אכילת אבוקדו עלולה לגרום לבעיה נשמתית קשה, יש בפרי חומר הניקרא פרסין שהוא רעיל לרוב בעלי-החיים.\n" +
						"הקפוסין, החומר הרעיל שבאבוקדו נמצא בפרי, בזרע, בעלים ובענפים!! \n"+
						"הרעילות משתנה בין זני אבוקדו השונים ובין זני תוכים שונים (הקטנים בדרך כלל רגישים יותר). 	החומר עלול לגרום לפגיעה נשימתית ופגיעה בלב, סימנים קליניים בתוך 12 שעות מהאכילה, מוות תוך 1-2 ימים. \n"+
						"ההרעלה עלולה להיות גם ממנות נמוכות של עשרות גרמים של האבוקדו. כך גם יש להיזהר מפני הזרע שרבים מאיתנו נוהגים להנביט בתוך צינצנות עם מים";
				Toast.makeText(context, t, Toast.LENGTH_SHORT).show();
				break;
			case "תפּוּחַ אֲדָמָה":
				t = "מכיל חומר הקרוי סולנין . חומר זה הינו רעיל לתוכים ולפיכך אסור בתכלית האיסור, ולא כדאי לבצע נסיונות כדי בדוק עד כמה התוכי שלנו עמיד לחומר זה. אסור לתת לתוכים חציל, תפוח-אדמה ובמיוחד עגבניה (בכל צורה שהיא: טרייה, מבושלת, קטשופ, רסק) שבה כמות הסולנין הרעיל היא הגבוהה ביותר.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ התפוח - רעיל":
				t = "העץ עצמו אסור , הפרי מותר ללא הגרעינים!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "פטרוזיליה":
				t = "יש אומרים שמותר לתת את זה ללא הגבלה ביד חופשית, ויש אומרים שזה אסור";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עגבניה":
				t = "מכיל חומר הקרוי סולנין . חומר זה הינו רעיל לתוכים ולפיכך אסור בתכלית האיסור, ולא כדאי לבצע נסיונות כדי בדוק עד כמה התוכי שלנו עמיד לחומר זה. אסור לתת לתוכים חציל, תפוח-אדמה ובמיוחד עגבניה (בכל צורה שהיא: טרייה, מבושלת, קטשופ, רסק) שבה כמות הסולנין הרעיל היא הגבוהה ביותר.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "חציל":
				t = "מכיל חומר הקרוי סולנין . חומר זה הינו רעיל לתוכים ולפיכך אסור בתכלית האיסור, ולא כדאי לבצע נסיונות כדי בדוק עד כמה התוכי שלנו עמיד לחומר זה. אסור לתת לתוכים חציל, תפוח-אדמה ובמיוחד עגבניה (בכל צורה שהיא: טרייה, מבושלת, קטשופ, רסק) שבה כמות הסולנין הרעיל היא הגבוהה ביותר.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "דיפנבכיה מנוקדת":
				t = "הצמח הזה מצוי בהרבה בתים כצמח נוי , יש להשים לב ולמנוע מהתוכי לאכול אותו!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "מזונות / דברים מלוחים":
				t = "אסור חטיפים ומאכלים מלוחים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "חומר משומר – קופסאות שימורים למינהן":
				t = "אסור לתת דברים מקופסאות שימורים! שזה כולל גם כן תירס מקופסא.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "שוקולד ודברים מתוקים":
				t = "הרעלת שוקולד נגרמת עקב טאוברומין וקפאין המצויים בו. הרעילים יותר הם אלו עם רמת קקאו גבוהה יותר (מריר) ורמת סוכר נמוכה יותר. יכול לגרום לפגיעה בכבד, בתאי הדם, נשימה ולב.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "חלבי - מוצרי חלב":
				t = "אסור-תוכים לא יכולים לעכל לקטוז";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "תבלינים":
				t = "לא בצורה חיה ולא בתבשילים!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "שתיה מתוקה / מוגזת":
				t = "אסור לתת משקאות ממותקים או מאכלים ממותקים, תוכים לא בנויים לעכל את זה וזה מזיק ומסוכן";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "פירות יבשים":
				t = "בפירות יבשים ישנו ריכוז סוכרים גבוה שיכול להזיק";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "נענע":
				t = "יש אומרים שמותר ויש אומרים שאסור";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "חלווה":
				t = "לא כדאי לתת לתוכי חלווה, בגלל כמות הסוכר הגבוהה.\n"+
						"חלבה זה בעצם שומשום עם הרבה מאוד סוכר.\n"+
						"השומשום - בריא אבל הסוכר - לא! \n";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ התאנה - שרף העץ":
				t = "אסור לתת את העלים או את הענפים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "אצטרובל":
				t = "כדאי לשטוף אותו לפני, איצטרובל זה משחק מעולה לג\'אקו";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "חמניות":
				t = "מכילים אחוזי שומן גבוהיים ולכן לא מומלץ לתת בצורה חופשית";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "מנגו":
				t = "כמובן במינון, מכיל הרבה סוכר";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "תירס - צמח התירס":
				t = "אפשר את הקלח ואפשר רק את הגרעינים, רק להשים לב כשמבשלים את הקלח לא לבשל אותו עם מלח במים!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "תפוח עץ":
				t = "את גרעיני התפוח אסור לתת!\n עץ התפוח אסור!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "תאנה":
				t = "כדאי לוודא שאתה מוריד את החלק העליון של התאנה (החלק שבו התאנה מתחברת לעץ - בלי השרף)";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "אלכוהול - שתיה חריפה":
				t = "מדכא את תפקוד המוח ועלול לגרום לתרדמת. קוקטיילים של משקאות, בירות ויינות שנשכחו לאחר מסיבה מסוכנים מאוד לתוכים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "תורמוס":
				t = "בזרעים יש רעל שצריך לנטרל אותו";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "לוע הארי":
				t = "אחד הצמחים המומלצים ביותר לתת לתוכי זהו צמח בשרני בעל עלים עגולים קטנים, וגבעולים בצבע אדמדם, צומח בגינות נוי שמושקים בהשקיית יתר. כמו כן - בשדות של ירקות. התוכים אוהבים את זה מאוד, וחשוב יותר - שהוא מזון בריא.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "אגוזי מקדמיה (אגוז לוז)":
				t = "אכילת אגוזים בודדים עלולה לגרום לרעידות ולשיתוק זמני ברגליו של התוכי. חוקרים טרם מצאו את הסיבה לכך.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "אגוזים (מלך ופקאן) טבעיים! לא קלויים ולא מלוחים!":
				t = "מכילים אחוזי שומן גבוהיים ולכן לא מומלץ לתת בצורה חופשית, הצריכה המותרת היא אזוג אחד ליום, ניתן לתת עם קליפה שבורה הם נהנים לפרק אותה.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "שקדים לא קלויים ולא מלוחים!":
				t = "מכילים אחוזי שומן גבוהיים ולכן לא מומלץ לתת בצורה חופשית, הצריכה המותרת היא שקד אחד ליום";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "בוטנים לא קלויים ולא מלוחים!":
				t = "רובם נגועים (גדלים עם פטריות שהרי הם רעילים לתוכים) ועלולים לגרום בעיות עיכול";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "גרעינים לא קלויים ולא מלוחים!":
				t = "מכילים אחוזי שומן גבוהיים ולכן לא מומלץ לתת בצורה חופשית";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "צנוברים":
				t = "מכילים כמות גבוהה של אבץ וברזל";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;	
			case "ענבים":
				t = "מותרים, אבל בצמצום, מכיל אחוז גבוהה של סוכר ויכול לגרום למוות בכמויות גדולות";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "תפוז":
				t = "מותר גם כן לתת לתוכי לאכול את העלים של עץ התפוז, השמן האתרי המצוי בעלי ההדרים מוצאים חן בעיני התוכים.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "אבטיח (ללא גרעינים)":
				t = "כמובן במינון, מכיל הרבה סוכר, וכמו כן להמנע מגרעינים השחורים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "תות שדה":
				t = "מותר אך לא מומלץ בגלל הריסוס שעושים להם, זה גם פחות מומלץ לבני אדם.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "ביצה מבושלת (קשה אפילו עם הקליפה)":
				t = "";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "גמבה ופלפל חריף בכל צורה עם הגרעינים":
				t = "מותר בכל צורה - חי או יבש עם הגרעינים ובלי.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "בננה":
				t = "כמובן במינון, מכיל הרבה סוכר";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "שום":
				t = "הורס את תאי הדם האדומים בתוכים ומוביל לאנמיה ואולי אף לכשל כלייתי, בשל מחסור בהמוגלובין.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "בצל":
				t = "פוגע בהמוגלובין של תוכים. הנזק מצטבר, וטעימות קטנות לאורך זמן עלולות להזיק יותר מאכילה של בצל שלם.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "קפה":
				t = "תרכובת המתילקסנתין שבקפאין עלולה להגביר את קצב פעימות הלב של התוכי ולעורר התקפי עוויתות.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ משמש":
				t = "ענפים, עלים וגרעין רעילים, הפרי עצמו לא בטוח ולא מומלץ.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ אפרסק, נקטרינה":
				t = "ענפים, עלים וגרעין רעילים, הפרי עצמו לא בטוח ולא מומלץ." +"\n"+
						"עצים עם פרי \'\'בית גלעין\'\' הם אינם בטוחים לתוכים, למשל: אפרסק, משמש, נקטרינה, שזיף, דובדבנים. הם מכילים חומר המשחרר ציאניד בעת עיכול.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ שזיף":
				t = "ענפים, עלים וגרעין רעילים, הפרי עצמו לא בטוח ולא מומלץ."+"\n"+
						"עצים עם פרי \'\'בית גלעין\'\' הם אינם בטוחים לתוכים, למשל: אפרסק, משמש, נקטרינה, שזיף, דובדבנים. הם מכילים חומר המשחרר ציאניד בעת עיכול.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ רימון והקליפה של הרימון":
				t = "הקליפה של הרימון, ושורש העץ הינם רעילים. הפרי עצמו והענפים בטוחים.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ שקד":
				t = "העץ והשקד עצמו עלולים לגרום לתגובה אלרגית אצל תוכים מסויימים, לכן לא להפריז בכמות." +
					"אסור בשום אופן לתת שקד מלוח," +
					" קלוי או מעובד לתוכי. רק שקד טבעי רגיל (לא מר), ללא תוספות, ובמינון נמוך מאוד.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "שקד מר":
				t = "נמוכים ורחבים מהשקד המתוק, אסור לתת כאלו לתוכי. השקדים המרים מכילים חומצה ציאנית רעילה.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "פשתה":
				t = "הצמח, הפרח לא מומלצים. זרעי הפשתן שנויים במחלוקת, לא מומלץ בכמויות ובמינון גבוהים.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "פולים":
				t = "שעועית, סויה וכד' - אסור לתת \'\'נא\'\'', אלא רק מושרה או מבושל.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "קיקיון מצוי/שעועית שחורה":
				t = "סימנים: ירידה בלחץ דם, היפותרמיה, כאבי בטן, הקאה, כאב, בחילה, שלשול, אנורקסיה, רעד, חולשה, התמוטטות, דיכאון, צמא.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "אספרגוס":
				t = "סימנים: דלקת עור, עצבנות, פגיעה בלב, מרדים, משתן.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "קרוטון":
				t = "מצוי בהרבה בתים כצמח נוי, יש להשים לב ולהרחיק מהתוכים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "קיסוס החורש":
				t = "מצוי בהרבה בתים כצמח נוי, יש להשים לב ולהרחיק מהתוכים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "עץ זית והעלים , ללא הזיתים":
				t = "הערה: בד\'\'כ השתמשתי " +
					"תמיד בענפים מעצים עם זיתים, פעם אחת בלבד לקחתי ענפים מעץ צעיר ללא זיתים, והתוכי שילשל. על בסיס" +
					" ניסיוני בלבד(של הכותבת) ממליצה להשתמש בענפים מעץ בוגר עם זיתים (כמובן להסיר את הזיתים לפני שמביאים את הענף לתוכי). " +
					"*עדכון: כדאי להשתמש בענפים מעץ עם עלים גדולים ולא קטנים, ושלא יהיו עלים מקופלים כי זה יכול להעיד על מחלה." +
					" וכמו בהערה הקודמת, להשתמש בענפים מעץ שיש עליו זיתים.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "אקליפטוס":
				t = "יש להסיר את הפרחים ואת העלים, בחלק מסוגי האקליפטוס הם נחשבים רעילים (אמנם לא קטלניים). יש להשתמש רק בענפי העץ. לידע כללי: שמן אקליפטוס הוא מרוכז ורעיל ולא למאכל (לבני אדם ולבעלי חיים).";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "רגלת הגינה":
				t = "צמח בעל עלה בשרני וענפים אדומים, מאוד בריא לתוכים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "(-שלד של דיונון)אבן גיר או סבידה":
				t = "מכיל הרבה סידן חיוני ונדרש , חובה בכל כלוב של תוכים/ציפורים";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			
			}
			
		}
		
		
		private void initiatePopupWindow() {
			try {
				
				// We need to get the instance of the LayoutInflater
				LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View layout = inflater.inflate(R.layout.popup_listfood, null);
				pwindo = new PopupWindow(layout, 600, 750 , true);
				pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
				
				//TextView pop_title = (TextView)layout.findViewById(R.id.pop_listfood_title);
				//TextView pop_text = (TextView)layout.findViewById(R.id.pop_listfood_text);
				
				Button btnCancel = (Button) layout.findViewById(R.id.pop_dismiss);
				btnCancel.setOnClickListener(cancel_button_click_listener);
				
				Button btnOk = (Button) layout.findViewById(R.id.pop_dismiss);
				btnOk.setOnClickListener(ok_button_click_listener);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		private OnClickListener cancel_button_click_listener = new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		};
		private OnClickListener ok_button_click_listener = new OnClickListener() {
			public void onClick(View v) {
				pwindo.dismiss();
			}
		};
		
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
	    	    Intent i = new Intent(Activity_Food_List.this , Activity_Email.class);
				i.putExtra(SUBJECT, "רשימת המותר והאסור");
				i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
				startActivity(i);
	       }
	         return true; 
	          default:  
	            return super.onOptionsItemSelected(item);  
	        }
	    }
	    @Override
	    public void onPause(){
	    	super.onPause();
	    	finish();
	    }
	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
	            Log.d(this.getClass().getName(), "back button pressed");
	            Intent imain = new Intent(Activity_Food_List.this, MainActivity.class);
	            startActivity(imain);
	        }
	        return super.onKeyDown(keyCode, event);
	    }
    }

