package myparrot.species;


import java.util.ArrayList;
import java.util.Arrays;

import myparrot.stands.ActivityToCall;
import myparrot.stands.Activity_Stands;
import myparrot.stands.ImageAdapter;

import com.example.myparrot.ActivityImageToZoom;
import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ActivityItemToCall extends Activity{
	
	private ImageView imageView;
	private GridView  gridview;
	private TextView title_name, price_yad, price_normal, length , weight ,
	         description ,size , food, life , other, sizer;
	private TextView  t_length , t_weight ,t_price,
    		t_description ,t_size , t_food, t_life , pop_title, pop_text;
	private Intent i, intent;
	private Context c;
	private PopupWindow pwindo;
	
	protected static final String EXTRA_RES_ID_IMAGE = "POS";
	public static final String EXTRA_RES_ID = "name";
	private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";
	public final static String ColorTheme = "the color themes" ;
	LinearLayout itemSpecies_layout;
	
	private ArrayList<Integer> cockatail = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.cockatiel1, R.drawable.cockatiel2,
				  R.drawable.cockatiel3, R.drawable.cockatiel4,
				  R.drawable.cockatiel5, R.drawable.cockatiel6,
				  R.drawable.cockatiel7, R.drawable.cockatiel8,
				  R.drawable.cockatiel9, R.drawable.cockatiel10
				));
	private ArrayList<Integer> jako = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.jako1 , R.drawable.jako2,R.drawable.jako3,
				  R.drawable.jako4 , R.drawable.jako5,R.drawable.jako6,
				  R.drawable.jako7 , R.drawable.jako8,R.drawable.jako9,
				  R.drawable.jako10 , R.drawable.jako11
				));
	private ArrayList<Integer> tucon = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.tucon1, R.drawable.tucon2,R.drawable.tucon3,
				  R.drawable.tucon4, R.drawable.tucon5,R.drawable.tucon6, 
				  R.drawable.tucon7, R.drawable.tucon8,R.drawable.tucon9, 
				  R.drawable.tucon10, R.drawable.tucon11,R.drawable.tucon12
				));
	private ArrayList<Integer> cockatoo = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.cockatoo1,  R.drawable.cockatoo2, R.drawable.cockatoo3,
				  R.drawable.cockatoo4,  R.drawable.cockatoo5,
				  R.drawable.cockatoo7,  R.drawable.cockatoo8, R.drawable.cockatoo9,
				  R.drawable.cockatoo10, R.drawable.cockatoo11,R.drawable.cockatoo12,
				  R.drawable.cockatoo13, R.drawable.cockatoo14 
				));
	private ArrayList<Integer> drara = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.drara1, R.drawable.drara2, R.drawable.drara3, R.drawable.drara4, R.drawable.drara5,
				  R.drawable.drara6, R.drawable.drara7, R.drawable.drara8,R.drawable.drara9, R.drawable.drara10,
				  R.drawable.drara11,R.drawable.drara12, R.drawable.drara13
				));
	private ArrayList<Integer> conure = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.conure1, R.drawable.conure2,R.drawable.conure3,
				  R.drawable.conure4, R.drawable.conure5,R.drawable.conure6,
				  R.drawable.conure7, R.drawable.conure8,R.drawable.conure9,
				  R.drawable.conure10, R.drawable.conure11,R.drawable.conure12,
				  R.drawable.conure13, R.drawable.conure14, R.drawable.conure15
				));
	private ArrayList<Integer> hara = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.hara1, R.drawable.hara2,R.drawable.hara3,
				  R.drawable.hara4, R.drawable.hara5,R.drawable.hara6,
				  R.drawable.hara7, R.drawable.hara8,R.drawable.hara9,
				  R.drawable.hara10, R.drawable.hara11,R.drawable.hara12, R.drawable.hara13
				));
	private ArrayList<Integer> love = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.love1, R.drawable.love2,R.drawable.love3,
				  R.drawable.love4, R.drawable.love5,R.drawable.love6,
				  R.drawable.love7, R.drawable.love8,R.drawable.love9,
				  R.drawable.love10, R.drawable.love11,R.drawable.love12
				));
	
	private ArrayList<Integer> lory = new ArrayList<Integer>(
			Arrays.asList(
				  R.drawable.lory1, R.drawable.lory2,R.drawable.lory3,
				  R.drawable.lory4, R.drawable.lory5,R.drawable.lory6,
				  R.drawable.lory7, R.drawable.lory8,R.drawable.lory9,
				  R.drawable.lory10, R.drawable.lory11,R.drawable.lory12,
				  R.drawable.lory13, R.drawable.lory14,R.drawable.lory15,
				  R.drawable.lory16, R.drawable.lory17
				));
	
	public static final String JAKO = "ג\'אקו", TOCON= "תוכון" , COCKOTAIL = "קוקטייל" , 
			   DRARA = "דררה" , CONURE = "קוניור", COCKATOO = "קאקדו", 
			   LOVE_BIRD = "תוכי אהבה", ARA = "ארה", LORY = "לורי";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.species_item_activity);
        
        itemSpecies_layout = (LinearLayout) findViewById(R.id.speItem_layout);
        itemSpecies_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        
        Log.d("מסך הזנים: ", "התחילה השיטה onCreate");
        
        c = this;
        
        t_length       = (TextView) findViewById(R.id.spe_item_t_lenght); 
        length         = (TextView) findViewById(R.id.spe_item_length);
        
        t_weight       = (TextView) findViewById(R.id.spe_item_t_wieght);
	    weight         = (TextView) findViewById(R.id.spe_item_weight);
		
	    t_description  = (TextView) findViewById(R.id.spe_item_t_description);
		description    = (TextView) findViewById(R.id.spe_item_description);
	    
		t_food         = (TextView) findViewById(R.id.spe_item_t_food);
	    food	       = (TextView) findViewById(R.id.spe_item_food);
	    
	    t_life         = (TextView) findViewById(R.id.spe_item_t_life);
	    life           = (TextView) findViewById(R.id.spe_item_life);
        
	    t_price		   = (TextView) findViewById(R.id.spe_item_t_price);
	    price_normal   = (TextView) findViewById(R.id.spe_item_price_normal);
	    price_yad      = (TextView) findViewById(R.id.spe_item_price_yad);
	    
	    t_size = (TextView) findViewById(R.id.spe_item_t_size);
	    size           = (TextView) findViewById(R.id.spe_item_size);
	    
	    title_name     = (TextView) findViewById(R.id.spe_item_name);
        other          = (TextView) findViewById(R.id.spe_item_others);
        
	    sizer          = (TextView) findViewById(R.id.spe_item_sizer);
	    imageView      = (ImageView)findViewById(R.id.spe_item_image);
	    gridview       = (GridView) findViewById(R.id.spe_item_grid);
	    
	    
	    size.setTextColor(Color.parseColor("#3333CC"));
	    t_length.setTextColor(Color.parseColor("#00688B"));
	    t_weight.setTextColor(Color.parseColor("#00688B"));
	    t_description.setTextColor(Color.parseColor("#00688B"));
	    t_food.setTextColor(Color.parseColor("#00688B"));
	    t_life.setTextColor(Color.parseColor("#00688B"));
	    t_price.setTextColor(Color.parseColor("#00688B"));
	    title_name.setTextColor(Color.parseColor("#00688B"));
	    t_size.setTextColor(Color.parseColor("#00688B"));
	    
	    Log.d("מסך הזנים: ", "עבר את ההגדרות של הטקסטים");
	    
	    // Get the Intent used to start this Activity
				intent = getIntent();
				
				switch(intent.getStringExtra(Activity_Species.EXTRA_RES_ID)){
				case JAKO:{
					title_name.setText("ג\'אקו");
					other.setText("סוגי ג\'אקו: תימנה, קונגו");
					sizer.setText("התוכי מוגדר כ: תוכי בינוני");
					description.setText("אפור עם זנב אדום. המקור שחור. זנבו אדום, בולט במיוחד על רקע יתר חלקי הגוף. צבעו של הג'אקו בד\'\'כ אפור בהיר, אך ניתן לראות לפעמים גם גוונים כהים יותר. בפנים ישנו אזור לבן, מחוסר נוצות. נוצות הראש בהירות יותר בקצותיהן, להבדיל מנוצות הבטן שכהות יותר בקצותיהן. הגב התחתון אפור בהיר. הזנב והנוצות הצמודות אליו – אדומים. המקור שחור, העין צהובה בהירה והרגליים אפורות כהות. חד-צורתיות מינית, לא ניתן להבדיל בין זכר לנקבה ע\'\'פ סימנים חיצוניים. הצעירים נראים זהים להוריהם, מלבד 3 הבדלים: חלק מנוצות הזנב (במבט מלמטה) אפורות, קצה הזנב צבוע באדום כהה יותר יחסית לשאר הזנב והעיניים אפורות. ");
					size.setText("60x60x120 ס\'\'מ");
					length.setText("35 ס\'\'מ");
					weight.setText("400 גרם");
					price_normal.setText("1,500-2,000 ₪");
					price_yad.setText("2,000-3,000 ₪");
					food.setText("זרעים, אגוזים, ירקות, פירות וכופתיות. תערובת זרעים של חריע, חמנייה, אורז, חיטה, שיבולת שועל ומגוון רחב של סוגי דוחן. באביב ובקיץ רצוי להוסיף זרעים מונבטים. צנוברים (אצטרובל), בוטנים, ממגוון של פירות וירקות, כמו: ענבים, תאנים, אפרסקים ותפוחים. תירס חצי-בשל. ורד הבר, צמחים ירוקים (ורד השן, כוכבית, וכו'), מזון ביצים. לג'אקו יש נטייה לבנות לעצמו תזונה לא מאוזנת ולהשמין ולכן יש להקפיד שלא להלעיט אותו במזונות עתירים שומן. ");
					life.setText("50-80 שנה");
					imageView.setImageResource(R.drawable.im_jako);
					imageView.setTag(R.drawable.im_jako);
					gridview.setAdapter(new ImageAdapter(this, jako));
				}break;
				case TOCON:{
					title_name.setText("תוכון");
					other.setText("סוגי תוכונים: אנגלי, אוסטרלי, אנגלי עם צ\'ופ, ראש חום");
					sizer.setText("התוכי מוגדר כ: תוכי קטן");
					description.setText("התוכון היא הציפור הנפוצה ביותר בעולם בין ציפורי המחמד, הוא עמיד והטיפול בו קל מאוד. לתוכונים אישיות מקסימה והם מופיעים בשלל צבעים ומוטציות. התוכון איננו מרעיש, אינו מלכלך את סביבתו ורמת האינטליגנציה שלו מאפשרת לו להפוך ל\'\'אחד מהמשפחה\'\'. התוכון היא ציפור אידיאלית למגדל המתחיל משום שהוא אינו זקוק להרבה טיפול וכן הוא מתרבה בקלות.");
					size.setText("60x60x120 ס\'\'מ");
					length.setText("19 ס\'\'מ");
					weight.setText("30 גרם");
					price_normal.setText("25-40 ₪");
					price_yad.setText("60-90 ₪");
					food.setText("התוכונים אוכלי כל. אפשר לתת להם הכל חוץ מאבוקדו, שוקולד ולא מומלץ להרבות בפירות וירקות. בירקות מומלץ לתת שעועית, אפונה, כרובית, ברוקולי. מוצרי חלב ובשר: עוף, מוצרי חלב, בשר, דגים וביצים. רצוי להוסיף אבקת וויטמינים שאותה ניתן לפזר על ירקות. ");
					life.setText("5-9 שנים");
					imageView.setImageResource(R.drawable.im_tucon);
					imageView.setTag(R.drawable.im_tucon);
					gridview.setAdapter(new ImageAdapter(this, tucon));
				}break;
				case DRARA:{
					title_name.setText("דררה");
					other.setText("סוגי דררה: דררה ירוקה/כחולה/צהובה ,דררה ראש שיזיף");
					sizer.setText("התוכי מוגדר כ: תוכי בינוני");
					description.setText("תוכי בגודל בינוני, שצבעו הכללי ירוק בהיר, זנבו ארוך ומקורו אדום. לזכר סנטר שחור וצווארון שחור דק הנמתח לעבר עורף וורוד-כתום. קולני מאוד ומתלהק. הקריאה האופיינית \'\'קיאק\'\' (kee-ak) חזק וצווחני, מזכיר בז. הצללית מובהקת, עם זנב ארוך במיוחד וכנפיים צרות, מחודדות וקונטרסטיות (אברות התעופה ירוקות כהות, מנוגדות לסוככות שצבען ירוק בהיר). מעוף הדררה מהיר וישר, לעיתים מתנדנד מצד לצד, לקראת נחיתה גולשת בכנפיים מושפלות. מעוף הלהקה עשוי להיות תזזיתי עם שינויי כיוון פתאומיים. לעיתים מתקהלות סביב עופות אחרים (דוגמת מיני אנפה או עקב), ורודפות אחריהם באוויר. מקננת ביישובים כפריים, עמקים ומישורים עם עצים גבוהים ומטעים. מזונה - זרעים, אגוזים, אצטרובלים ופירות.");
					size.setText("2.5x1x2 מטר");
					length.setText("22-40 ס\'\'מ");
					weight.setText("120-140 גרם");
					price_normal.setText("150-200 ₪");
					price_yad.setText("300-400 ₪");
					food.setText("הדררות ניזונות מחלקי צמחים שונים, כגון זרעים, גרגרים, פירות, פקאן ,פרחים, נקטר (בעיקר מפרחי סלמליה ואריתריה). לאחר הרבייה, בחלק מהאזורים של הודו, הדררות, בקבוצות ענק, מלקטות מזון בשדות ובמטעים, כגון דוחן, אורז, תירס, קפה ופירות שונים. לעתים קרובות הן גורמות נזק ניכר לשדות ולמטעים אלה. בשבי תזונת הדררה מורכבת מתערובת גרעינים (גרעיני חמנית, כוסמת, סוגי דוחן שונים, שיבולת שועל, חיטה, קנביס, מונבטים), מגוון של פירות (תפוחים, בננות, תאנים, ענבים, אוכמניות ועוד), ירקות (ורד הבר, תירס חצי מבושל, גזר, גמבה, מלפפון ועוד), סוגי צמחים (שן הארי, כוכבית ופרחים שונים) ומזונות שונים (מזון ביצים, לחם מרוכך, ביסקוויטים כחטיף).");
					life.setText("45-50 שנה");
					imageView.setImageResource(R.drawable.im_drara);
					imageView.setTag(R.drawable.im_drara);
					gridview.setAdapter(new ImageAdapter(this, drara));
				}break;
				case COCKOTAIL:{
					title_name.setText("קוקטייל");
					other.setText("סוגי קוקטייל: אפור, צהוב, לבן");
					sizer.setText("התוכי מוגדר כ: תוכי קטן");
					description.setText("תוכי קוקוטייל (Nymphicus hollandicus) ימצא לרוב באזורים יבשים או יבשים למחצה ביבשת אוסטרליה. רוב גופם של תוכי קוקטיל אפור זנבם ארוך ועל ראשם מתנוססת ציצת נוצות דקה. לזכר צאוור ולחיים צהובים עם כתם כתום ולנקבה ראש אפור ברובו עם כתם צהוב.");
					size.setText("50x50x66 ס\'\'מ");
					length.setText("25-33 ס\'\'מ");
					weight.setText("80-120 גרם");
					price_normal.setText("100-130 ₪");
					price_yad.setText("250-350 ₪");
					food.setText("הקוקטייל אוכל הכל אך חשוב להימנע מהגשת אבוקדו, שוקולד ואלכוהול. הקוקטייל אוכל כופתיות, גרעינים, זרעים, פירות ירקות, מוצרי חלב ובשר, אגוזים עשירים בחלבונים שומנים ומינרלים. על מתקן המים תמיד להיות נקי ומלא במים טריים. חשוב להביא לקוקטייל מינרלים המסייעים לבריאותו ולבניית עצמותיו, וחלבונים שמסייעים בייצור חומצות אמיניות לא חיוניות שאותן אינו יכול לייצר לבד. בנוסף חשוב להביא וויטמינים, פחמימות ולגוון בסוגי האוכל המוגשים ולא להגיש רק גרעינים וזרעים. יש למקם בכלוב הקוקטייל אבן מינרלים וויטמינים. ");
					life.setText("8-14 שנה");
					imageView.setImageResource(R.drawable.im_cockatiel);
					imageView.setTag(R.drawable.im_cockatiel);
					gridview.setAdapter(new ImageAdapter(this, cockatail));
				}break;
				case COCKATOO:{
					title_name.setText("קאקדו");
					other.setText("סוגי קאקדו: גאלה,אמברלה,דוקופס, גופין, מייג\'ר מיטשל, ציצית צהובה, עין חשופה, דקלים, ציטרון");
					sizer.setText("התוכי מוגדר כ: תוכי גדול");
					description.setText("הקקדו הוא מהעופות הידועים והמוכרים ביותר בעולם, תוכי אשר משמש בעיקר לנוי ולגידול ביתי. ישנם כמה וכמה סוגים של תוכי קקדו בעולם, אשר שונים אחד מהשני בהופעתם החיצונית ובמאפיינים רבים אחרים, אך מקורם של כולם הוא מאינדונזיה, אוסטרליה וחלקו הדרום מזרחי של כדור הארץ באופן כללי. תוכי קקדו מגיע בדרך כלל למשקל של סביב חצי קילוגרם, אך לעיתים גם ליותר מזה. תוכי הקקדו הם תוכים מאוד נפוצים, אהובים ופופולאריים, בעיקר בשל היופי שהם מכניסים לבית. עם זאת, רבים מהם לא מסתגלים לחיי השבי כמובן ולכן, חשוב מאוד לשכן אותם בכלובים המתאימים לנתונים שלהם ולסביבה הטבעית שבה הם חיים. ישנם כמה סוגים של תוכי קקדו אשר מסוגלים 'לדבר', ברמה כזו או אחרת, עם בני אדם. למעשה, מדובר בחיקוי של הקולות של סביבתם, אם כי ישנם תוכים (כמו האפרור האפריקני, שהוא סוג של תוכי אשר נקרא גם ג'אקו) שיכולים ללמד את עצמם לדבר, מבלי שילמדו זאת מהמגדל שלהם, על פי משפטים חוזרים או מילים חוזרות שנשמעות בבית. ישנם תוכים שיכלים ללמוד עד 700 מילים שונות. תוכי הקקדו לא מגיעים, לרוב לרמה כזו של לימוד, אך הם בהחלט יכולים לחזור על מספר מסוים של מילים לאחר תקופה ממושכת בבית. מדובר בציפורים אינטליגנטיות למדי ולכן הן מהוות אטרקציה בפני עצמה, ולו רק מהמובן הזה. חשוב לזכור ולהיות מודע לכך שישנם מספר סוגים של תוכי קקדו שנמצאים בסכנת הכחדה. כך נכון למשל לגבי קקדו שחור צהוב-זנב, או לגבי קקדו קורלה ארוכת מקור. ישנם עוד כמה וכמה סוגים שנחשבים נדירים מאוד.");
					size.setText("2x2x6 מטר");
					length.setText("30-45 ס\'\'מ");
					weight.setText("200-550 גרם");
					price_normal.setText("3,000-4,000 ₪");
					price_yad.setText("4,500-5,000 ₪");
					food.setText("כופתיות ,חמניות, חיטה, שיבולת שועל,גרעינים שחורים לתוכים,פירות,ירקות");
					life.setText("40 שנה ויותר");
					imageView.setImageResource(R.drawable.im_cockatoo2);
					imageView.setTag(R.drawable.im_cockatoo2);
					gridview.setAdapter(new ImageAdapter(this, cockatoo));
				}break;
				case CONURE:{
					title_name.setText("קוניור");
					other.setText("סוגי קוניור: שמש, ג\'ינג\'י, כחול, שחור ראש, רד מאסק, פרלי, מצח תפוז, פטגוניה, דאסקי, ג\'אנדיה, גריןצ\'יק כחול/ילו-סיידר/קינמון, בלאק קייפ");
					sizer.setText("התוכי מוגדר כ: תוכי קטן");
					description.setText("קוניור השמש מגיע אלינו בעיקר מ-צרפת וברזיל. תוכים חברותיים מאוד החיים בלהקה של 6-30 פרטים בלהקה. אוהבים להיות בטבע על עצים קירחים ושיחים, לא יהיה קשה לאתר אותם בטבע, הם רעשניים, צבעוניים ואורכם מגיע עד ל- 30 ס\'\'מ. ראשם כתום, זנבם כחול ירוק וצהוב, נוצות התעופה בצבע קובלט, הבטן צהובה וכתומה וצבע הכנפיים בצבע צהוב לוהט, כשהם צעירים הכנפיים ירוקות ויקבלו את צבע הצהוב רק בגיל שנה. מרעישים בעיקר בשעות הבוקר ואחר הצוהריים כאשר נעים, נהנים מאוד מרחצה עם כל הלהקה. ניזונים מזרעים, פקעות ופירות, בעיקר סברס. לא רואים אותם הרבה על האדמה, מעדיפים להיות בגובה ויורדים לאדמה בתדירות נמוכה. \n כחיית מחמד: תוכי נאמן, חברותי, לא בררן וגם לא חושש ופחדן. צריך לשמור עליו, מכיוון שהם אוהבים לכרסם הרבה דברים מעץ, מקורם החזק יכול לעמוד בזה. זקוקים להרבה תשומת לב. לספק להם פעם שבוע צלחת רדודה עם מים פושרים שיתרחצו, זה חשוב מאוד לקוניורי השמש. רעשניים, אבל אפשר להסתדר עם זה. 	דעה אישית:אם אתם לא אוהבים הרבה רעש אל תיקנו,אם אתם לא חושבים שיש לכם זמן בשבילו אל תיקנו.");
					size.setText("80x80x100 ס\'\'מ");
					length.setText("24-35 ס\'\'מ");
					weight.setText("100-150 גרם");
					price_normal.setText("500-600 ₪");
					price_yad.setText("700-1,000 ₪");
					food.setText("תערובת זרעים מועשרת לתוכים בינוניים/  גדולים שכוללת הרבה שומנים יחסית, תערובת השרייה, כופתיות לתוכים בינוניים, פירות וירקות, ביצה קשה מפוררת (עם הקליפה), זרעים של עשבים, פרחים וחרקים קטנים. ");
					life.setText("20-30 שנים");
					imageView.setImageResource(R.drawable.im_conure2);
					imageView.setTag(R.drawable.im_conure2);
					gridview.setAdapter(new ImageAdapter(this, conure));
				}break;
				case ARA:{
					title_name.setText("ארה");
					other.setText("סוגי ארה: יקינטוני ,בלו&גולד, גרין ווינג, נוביליס, סקארלט,ילוו קולר");
					sizer.setText("התוכי מוגדר כ: תוכי גדול");
					description.setText("מבנה הגוף יכול להיות מקטן ועד גדול תלוי בסוג הארה. בדרך כלל הזנב מהווה כחצי מאורך הגוף וזאת על מנת לשמור על שיוויי משקל בעת התעופה. \n המקור בדרך כלל כהה לעיתים אצל מינים מסויימים ניתן לראות עיגול צבעוני סביב העין ובסיס המקור דבר זה בא לידי ביטוי בעיקר אצל הארות הגדולות.\n הארה הוא תוכי סקרן ומלא חיים, ככזה יהיה על בעליו לספק לו שפע של משחקים וגירויים אשר יעשירו את עולמו, כמו כן הארה ידרוש מנה גדושה של תשומת לב בכל יום ואם לא ייקבל אותה הוא יכעס ויביע את כעסו ע\'\'י נסיונות נשיכה, היחס אל הארה יהיה כמו אל ילד קטן והתנהגותו איננה רחוקה מכך. \n כושר הדיבור של הארה אינו מן המובחרים בנמצא אך יכולתו לחקות צלילים אשר מושמעים בסביבתו היומיומית היא מעולה והוא ילמד מהר מאוד לחקות את צלצול הטלפון שלכם ופעמון הדלת.");
					size.setText("104x71x172 ס\'\'מ");
					length.setText("1 מטר");
					weight.setText("1,500 גרם");
					price_normal.setText("");
					price_yad.setText("");
					food.setText("הארה הוא תוכי אשר מוציא הרבה אנרגיה ולכן תזונתו צרכיה להיות מועשרת ומותאמת לסוג. בטבע הארות ניזונים בעיקר מסוגים שונים של אגוזים ופירות, לפעמים גם בשר כשיש בנמצא, בשבי הרבה בעלים מתפתים לפנק את הארה שלהם בכמות בלתי נדלת של אגוזים, האגוז הוא מקור שומן ואנרגיה מצוין אך אין להגזים שכן דבר זה יכול לגרום לעודף שומן אצל התוכי ואף לתחלואה. המזון המומלץ ביותר הן הכופתיות המותאמות לארה שכן התוכי חייב לאכול את כל הכופתית ואינו יכול לבחור לעצמו רק את המועדף עליו, כך אנו יודעים שהתוכי קיבל את כל הדרוש לו תזונתית ויכולים להיות רגועים, כמובן שכפינוק או צ\'ופר אפשר לתת מספר אגוזים מצומצם ביום.");
					life.setText("50-70 שנים");
					imageView.setImageResource(R.drawable.im_hara);
					imageView.setTag(R.drawable.im_hara);
					gridview.setAdapter(new ImageAdapter(this, hara));
				}break;
				case LOVE_BIRD:{
					title_name.setText("תוכי/ציפור אהבה");
					other.setText("סוגי תוכי אהבה: בלאק מסקט, פישר,בלאק צ\'יק, ניאסה, פיצ\' פייס, רד פייס, לוטיניו, אלבינו");
					sizer.setText("התוכי מוגדר כ: תוכי קטן");
					description.setText("ציפורי אהבה הנם תוכים קטנים החיים בזוגות קבועים שאין להפריד ביניהם אלא אם כן אחד פוגע בשני. ואז יש לבדוק בעצמך ולהתייעץ עם וטרינר, אם ומתי להחזירם להיות יחד. הציפורים צבעוניות ויפות, ובמשך הזמן מכירות את מטפליהן. מהנה מאוד לעקוב אחר הזוגיות ביניהן שלעיתים מאוד משעשעת וגם נוגעת ללב."+"אלו ציפורי מחמד מאד מומלצות לגידול וזאת בתנאי שהם גדלים כציפורים מהאכלת יד. אז הם יכולים להיות נחמדים וחברותיים. לציפורי האהבה צעירות אישיות אהובה וחברותית מאד. הבוגרים נחשבים כקשים יותר לאילוף וידועים בקטטות הם מנהלים עם בני הזוג שלהם.   " +"\n"+ " חשוב לדעת! \n תוכים אלה עלולים להיות מאד תוקפניים כלפי חבריהם ואפילו להרוג אחד את השני. הם לא יכולים לחיות בכלוב עם תוכונים או תוכים אחרים.");
					size.setText("100x60x80 ס\'\'מ");
					length.setText("15-18 ס\'\'מ");
					weight.setText("43-83 גרם");
					price_normal.setText("40-70 ₪");
					price_yad.setText("80-100 ₪");
					food.setText("האכלת ציפור האהבה הנה דבר פשוט ביותר ומתבססת בעיקרה על מבחר סוגי זרעים. ציפורי האהבה שחיות בטבע ניזונות בעיקר מסוגים שונים של זרעים, גרעינים, פירות יער, גרעיני חמניה ועוד. בגידול בייתי קיימות כמה חברות שמייצרות מזון במספר רמות לציפור אהבה, החל ממזון פרימיום תוצרת חוץ, ועד מזון פשוט באריזה מקומית. לא מומלץ לתת לציפור האהבה ירקות לא ירוקים, מחשש לשלשולים וקלקולי קיבה. כמו-כן, ירקות ופירות עשויים למשוך ברחשים ומלכלכים את הכלוב. כן אפשר להאכיל את התוכי בקטניות (להשרות לילה לפני במקרר), פריכיות מכל סוג כופתאות (מעין בונזו לתוכים, שהתוכי אוהב אך אין לאפשר שיותר מ-50% ממזונו יהיו כופתאות). מומלץ להוסיף מדי פעם: גזר, תלתן, פלפל, נבטים, תפוח עץ ועלי חסה. בשום אופן אל תאכילו את הציפור שלכם במזון הכולל שוקולד או אבוקדו שהם מסוכנים לחייה וכמובן שאלכוהול גם הוא מסוכן. ניתן לצ\'פר את ציפור האהבה בחטיפים יעודיים ותוספי מזון." + 
						         "\n ויטמינים וחטיפים : כמו כולנו, גם ציפור האהבה שלנו אוהבת להתפנק ולקבל צ´ופרים וחטיפים. החטיף הנפוץ והמוכר הוא מקלות דבש, המגיעים במבחר טעמים. כל החטיפים מכילים תוספת של ויטמינים, אבל אם רואים שינוי בהתנהגות של ציפור האהבה או שינוי בנוצות מומלץ להוסיף ויטמינים. תוספת ויטמינים חשובה במיוחד.");
					life.setText("8-15 שנים");
					imageView.setImageResource(R.drawable.im_love);
					imageView.setTag(R.drawable.im_love);
					gridview.setAdapter(new ImageAdapter(this, love));
				}break;
				
				case LORY:{
					title_name.setText("לורי");
					other.setText("סוגי לורי: אדום, קשת, שחור, דובנבונד, קוקונט, צ\'טרינג, סווינסון, ילו סטריק, ילו ביב, ויולט, ווברי, גרין נייף, בלו סטריק, בלאק קייפ, אדוארד, דאסקי, גולדיס.");
					sizer.setText("התוכי מוגדר כ: תוכי קטן");
					description.setText(
							"התנהגות ומבנה חברתי : בדרך כלל אפשר לראותם בזוגות, אך לפעמים עפים בלהקות תוך השמעת צריחות רמות. הזוגות מגנים בתוקפנות על הטריטוריה שלהם מפני לורים אחרים אך גם מפני ציפורים אחרות, כולל כאלו הגדולות מהם, כמו העקעק האוסטרלי."+
							"מלא שמחת חיים ובעלי מראה מרתק. הלורי הוא תוכי מרשים בצבעיו, טוב באופיו ודורש המון אהבה ותשומת לב. לא מומלץ לרכוש את הלורי בתור תוכי מדבר אם כי יש לו יכולת דיבור אך זו במידה מועטה ביחס לתוכים כמו הג'אקו או הארה. ככלל התוכים הלורי רועש אם כי לא בצורה בלתי נסבלת. יש לנהוג איתו בחכמה ולמגר את התופעה מגיל צעיר. חיסרון מרכזי אצל הלורי הוא הטלת הצואה. מאחר והלורי ניזון ממזון נוזלי המבוסס על צוף פרחים וסוכרים, צואתו גם היא נוזלית, ואינה מוטלת בצורה אנכית אלא קדימה ,אחורה ולצדדים, מה שגורם לבעיית לכלוך לא קטנה. כאשר התוכי מוחתם ברמה גבוהה ניתן ללמד אותו מספר מילים ואף כמה תרגילי אילוף בסיסיים."
					);
					size.setText("100x60x80 ס\'\'מ");
					length.setText("24-30 ס\'\'מ");
					weight.setText("150-250 גרם");
					price_normal.setText("700-1000 ₪");
					price_yad.setText("1000-2000 ₪");
					food.setText( "פרחים, פירות וצוף. בשבי זקוקים לתמיסה נוזלית מיוחדת שתאפשר להם להשלים חוסרים שהם מקבלים בטבע באופן זמין ונגיש");
					life.setText("15-20 שנה");
					imageView.setImageResource(R.drawable.im_lory);
					imageView.setTag(R.drawable.im_lory);
					gridview.setAdapter(new ImageAdapter(this, lory));
				}break;
				
				default:
					break;
				}
			
				Log.d("מסך הזנים: ", "עבר את ההגדרות של הזנת התמונות והנתונים בטבלה");
				
				size.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						try {
							switch(intent.getStringExtra(Activity_Species.EXTRA_RES_ID)){
							case TOCON:
							case LOVE_BIRD:{
								Intent intent = new Intent(ActivityItemToCall.this,	ActivityImageToZoom.class);
								intent.putExtra(IMAGE_ZOOM, R.drawable.cage_small);
								startActivity(intent);
							}
							case LORY:
							case COCKOTAIL:
							case CONURE:{
								Intent intent = new Intent(ActivityItemToCall.this,	ActivityImageToZoom.class);
								intent.putExtra(IMAGE_ZOOM, R.drawable.cage_cockatail);
								startActivity(intent);
							}break;
							
							case "JAKO":
							case DRARA:{
								Intent intent = new Intent(ActivityItemToCall.this,	ActivityImageToZoom.class);
								intent.putExtra(IMAGE_ZOOM, R.drawable.cage_big);
								startActivity(intent);
							}
							break;
							case COCKATOO:
							case ARA:{
								Intent intent = new Intent(ActivityItemToCall.this,	ActivityImageToZoom.class);
								intent.putExtra(IMAGE_ZOOM, R.drawable.cage_big2);
								startActivity(intent);
							}
							default:
								break;
							}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				});	
				
		// Set an setOnItemClickListener on the GridView
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(ActivityItemToCall.this,	ActivityImageToZoom.class);
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(IMAGE_ZOOM, (int) id);
				// Start the ImageViewActivity
				startActivity(intent);
			}
		});
		
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(ActivityItemToCall.this,	ActivityImageToZoom.class);
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(IMAGE_ZOOM, getDrawableId(imageView) );
				// Start the ImageViewActivity
				startActivity(intent);				
			}
		});
		
		Log.d("מסך הזנים: ", "עבר את ההגדרות של לחיצה על תמונות");
		
		try{
			t_description.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow(t_description , description);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרת התיאור", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		try{
			t_food.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow(t_food, food);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרת התזונה", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		try{
			t_length.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow(t_length , length);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרות האורך", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		try{
			t_life.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow(t_life , life);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרת התוחלת חיים", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		try{
			t_weight.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow(t_weight , weight);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרת המשקל", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		try{
			t_price.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String text_prev_price = price_yad.getText().toString(); 
					price_yad.setText(
							"האכלת יד: " +price_yad.getText().toString() +"\n\n"+
							"רגיל   : " + price_normal.getText().toString() );
					initiatePopupWindow(t_price , price_yad);
					price_yad.setText(text_prev_price);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרת המחיר", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		
		try{
			title_name.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow( title_name , other);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרת סוגים שונים", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
			
		try{
			t_size.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow(t_size , size);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "לא הצליחה הלחיצה על הכותרת גודל הכלוב המומלץ", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		Log.d("מסך הזנים: ", "עבר את ההגדרות של לחיצת כותרת לתצוגה");
		
}
	
	private void initiatePopupWindow(TextView title, TextView text) {
		try {
			
			Log.d("מסך הזנים: ", "השיטה initiatePopupWindow הופעלה");
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup, null);
			pwindo = new PopupWindow(layout, 600, 750 , true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
			
			Log.d("מסך הזנים: ", "השיטה initiatePopupWindow הופעלה עבר בהצלחה את הגדרת הinflater");
			
			pop_title = (TextView)layout.findViewById(R.id.pop_title);
			pop_title.setText(title.getText().toString());
			pop_text = (TextView)layout.findViewById(R.id.pop_text);
			pop_text.setText(text.getText().toString());
			Log.d("מסך הזנים: ", "השיטה initiatePopupWindow הופעלה עבר בהצלחה הגדרת הטקסטים בחלון קופץ");
			
			Button btnDismiss = (Button) layout.findViewById(R.id.pop_dismiss);
			btnDismiss.setOnClickListener(cancel_button_click_listener);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private OnClickListener cancel_button_click_listener = new OnClickListener() {
		public void onClick(View v) {
			pwindo.dismiss();
		}
	};

	
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
    	    Intent i = new Intent(ActivityItemToCall.this , Activity_Email.class);
			i.putExtra(SUBJECT, "טבלת מידע על התוכי");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}
