package myparrot.diseases;

import java.util.ArrayList;

import myparrot.diseases.Child;
import myparrot.diseases.ExpandListAdapter;
import myparrot.diseases.Parent;

import com.example.myparrot.Activity_Email;
import com.example.myparrot.Activity_Food;
import com.example.myparrot.Activity_Training;
import com.example.myparrot.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ExpandableListView.OnGroupExpandListener;


public class Activity_Diseases extends Activity {

	private ArrayList<Child> ch_list;
 	private ExpandListAdapter ExpAdapter;
    private ArrayList<Parent> ExpListItems;
    private ExpandableListView ExpandList;
    private Context context;
    private TextView link , title;
    private LinearLayout lay_link;
    private int c = 0;
    
    public final static String ColorTheme = "the color themes" ;
	LinearLayout diseas_layouy;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_diseases);
        
        diseas_layouy = (LinearLayout) findViewById(R.id.diseases_layout);
        diseas_layouy.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        
        context = this;
        
        ExpandList = (ExpandableListView) findViewById(R.id.dis_exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(context , ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        
        ExpandList.setOnGroupExpandListener(new OnGroupExpandListener() {
            int previousItem = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousItem )
                	ExpandList.collapseGroup(previousItem );
                previousItem = groupPosition;
            }
        });
        
        
        lay_link = (LinearLayout)findViewById(R.id.dis_layout_link);
        title = (TextView) findViewById(R.id.dis_title);
        title.setOnClickListener(new OnClickListener() {
        	
            public void onClick(View v) {
            	c++;
            	if(c%2 == 0)
            		lay_link.setVisibility(View.GONE);
            	else
            		lay_link.setVisibility(View.VISIBLE);
             }
        });
        
        link = (TextView) findViewById(R.id.dis_link);
        link.setTextColor(Color.BLUE);
        link.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(link.getText().toString()));
                startActivity(myWebLink);
             }
        });
        
    }

    
    public ArrayList<Parent> SetStandardGroups() {
    	
        ArrayList<Parent> list = new ArrayList<Parent>();
        
        String diseases[] = {
        		"מחלת המקור והנוצות - Psittacine Beak & Feather Disease Viirus",
        		"פוליומה - Poliona Virus",
        		"מחלת הפצ\'קו - Pacheco`s Parrot Disease",
        		"כלמידיה (דררת) - Chlamydia Pcittaci",
        		"סלמונלה - Salmonella",
        		"מיקופלסמה - Mycoplasma spp",
        		"פיסטיקוזיס - PSITTACOSIS",
        		"סלמונלה  - SALMONELLOSIS",
        		"פסאדוטוברקולוזיס - PSEUDOTUBERCULOSIS",
        		"שחפת ושחפת העור - TUBERCULOSIS"
        };
        
        
        //Child c = new Child(copy, descreption, simptom, image);
        String copy1 = "העברה והדבקה מציפור אחת לשניה דרך האויר מגע ישיר בין ציפורים, הפרשות מפתח הביב (לשלשת), כלי אוכל ואבק נוצות. ";
        String siptoms1 = 
        		"סימנים הקליניים:" +
        		" איבוד נוצות, התפתחות לקויה של הנוצות, פגיעה במקור (נגעים, צמיחת יתר), פגיעה במערכת החיסון," +
        		" דכאון ואיבוד משקל. ציפור שהיא נשאית למחלה או שהמחלה נמצאת בשלבי דגירה לא מראה סימנים קליניים," +
        		" ולכן הדרך היחידה לבדוק נשאות היא בבדיקת DNA במעבדה.לצורך אבחון במעבדתנו, יש לשלוח דגימת דם או נוצות" +
        		" (נוצות - בשלב הסימנים הקליניים בלבד)."
        		;
        String descreption1 = 
        		"המחלה תועדה לראשונה אצל קקדואים בטבע בערבות אוסטרליה, " +
        		"אך עם השנים החלו דיווחים על מינים שונים (בעיקר אוסטרלים ואפריקאים) אשר בהם נמצאה המחלה. גורם המחלה הוא נגיף ממשפחת ה-" +
        		" circovirus , אשר חי בבסיס הנוצות, אבק הנוצות, בדם הציפור ובמקור." +
        		" בשנה האחרונה, התגלו כ- 15 זנים שונים של הנגיף, אך עדיין לא ידועה מידת אלימותו של כל זן." +
        		" ציפור שנדבקה עלולה לשאת את הנגיף במשך שנים רבות עד להתפרצות סימנים קליניים." +
        		" רמת ההדבקה והסימנים הקליניים תלויים בזן הנגיף, מין הציפור," +
        		" גילה והמצב החיסוני בו מצויה הציפור. הנגיף פוגע בייצור הנוצות, במערכת החיסון, במוח, בכבד ובדם." +
        		" ברוב המקרים המחלה סופנית ונובעת בעיקר מכשל חיסוני." ;
        Child diseas1 = new Child(copy1 ,descreption1 ,siptoms1 );
        
        String copy2 = "דרכי העברה: אבק נוצות, לשלשת, אויר, מגע ישיר וחומרים נגועים";
        String siptoms2 = 
        		"הסימנים הקליניים כוללים אובדן תנועתיות בזפק, פליטת מזון, נפיחות הבטן," +
        		" דכאון, איבוד תאבון, איבוד משקל, שלשולים, פגיעה בניצוי, קשיי נשימה, דימומים פנימיים ומוות." +
        		" ציפור ששרדה את הוירוס נשארת נשאית לכל ימי חייה ומידת הפצת הנגיף משתנה בין הציפורים הנגועות." +
        		"אין אפשרות לדעת אם הציפור נשאית ללא בדיקת מעבדה. אנו ממליצים לבדוק כל ציפור המוכנסת ללהקה " +
        		"או לריבוי ולשמור את הציפור מבודדת עד הגעת התשובות.לצורך אבחון במעבדתנו יש לשלוח דגימת דם";
        String descreption2 = 
        		"גורם המחלה הוא נגיף, הפוגע כמעט בכל מיני הציפורים. המחלה משפיעה בעיקר על גוזלים ומובילה למוות תוך 48 " +
        		"שעות מרגע הופעת הסימנים הקליניים של הגוזלים הנגועים.";
        Child diseas2 = new Child(copy2 ,descreption2 ,siptoms2 );
        
        String copy3 = "";
        String siptoms3 =
        		"סימנים נוספים: דכאון, איבוד תאבון, פליטת מזון, הפרשות מהאף, דלקת לחמית העין וסימנים עצביים." +
        		" הסימנים פורצים לרב בזמן עקה (סטרס) לצורך אבחון במעבדה צריך לשלוח דגימת דם או swab מהפרשות העיניים ומערכת" +
        		" העיכול.";
        String descreption3 = 
        		"גורם המחלה הוא נגיף ההרפס." +
        		" תקופת דגירה קצרה של כ- 48 שעות, ומשך המחלה 5 ימים ועד מספר שבועות. מהלך המחלה לרב חריף," +
        		" אקוטי ומסוכן: זיהום הגורם למוות פתאומי, כשלרוב זהו הסימן היחיד. מחלת הפצ\'קו, או נגיף ההרפס," +
        		" בד\'\'כ מתפרץ בשעת סטרס (עקה) או כאשר תנאי המחייה הם לא טובים והתזונה ירודה.צמחלת הפאצ\'קו נחשבת" +
        		" כבלתי ניתנת לריפוי וזאת בעיקר משום שהיא מתפרצת במהירות, זמנה קצר והתוכי מת במהירות. אומנם, קיימת תרופה" +
        		" (antiviral acyclovir) שעשויה לעזור, אבל רק בחלק מהמקרים והטיפול די מורכב." +
        		" הדרך הטובה ביותר הייא למנוע את התפרצות המחלה ע\'\'י שמירה בלתי מתפשרת על ניקיון הכלוב וסביבתו," +
        		" בדיקת התוכי לפני הקנייה ואם יש חשש למחלה, לא להכניס את התוכי לבית.";
        Child diseas3 = new Child(copy3 ,descreption3 ,siptoms3 );
        
        String copy4 = ".העברת החיידק מציפור לציפור מתרחשת דרך הפרשות הציפור," +
        		" האויר ואבק נוצות, בנוסף יכולה להיות העברה מהאם הנגועה לעובר בביצה."+"\n"+"\n"+
        		"המחלה עלולה לעבור לאדם ולכן חשוב לוודא שהציפור שברשותכם אינה נשאית או חולה! ";
        String siptoms4 = 
        		"הסימנים הקליניים הנפוצים כוללים:" + "\n"+
        		"- שלשולים (צהבהבים), סימני מערכת הנשימה (הפרשות מהעיניים והאף, קשיי נשימה)." +"\n"+
        		"- חוסר תאבון.- רזון." +"\n"+
        		"- טמפרטורת גוף נמוכה." +"\n"+
        		"- סימור נוצות" ;
        String descreption4 = 
        		"גורם המחלה הוא חיידק Chlamydia Pcittaci, " +
        		"שחי כטפיל בתוך תאי הציפור.סימני המחלה מופיעים בעיקר במצבי עקה של הציפור, " +
        		"אך הציפור יכולה להיות נשאית ולהפריש את החיידק גם אם היא לא מראה סימנים קליניים במשך שנים רבות" +
        		".הרעלן המופרש מהחיידק פוגע בעיקר בכבד ובכליות. " +
        		"לצורך אבחון המחלה יש לשלוח למעבדה דגימת דם, swab מהפרשות הביב או העיניים"
        		;
        Child diseas4 = new Child(copy4 ,descreption4 ,siptoms4 );
        
        String copy5 = "";
        String siptoms5 = 
        		"סימנים קליניים" +"\n"+
        		" - חולשה," +"\n"+
        		" חוסר תאבון ושלשול." +"\n"+
        		" במקרים כרונים לעיתים נראה דלקת פרקים, " +"\n"+
        		"דלקת לחמית העין ונזק לאיברים פנימיים (כבד, טחול, כליה או לב)."+"\n"+"\n"+
        		"המחלה עלולה לעבור לאדם ולכן חשוב לוודא שהציפור שברשותכם אינה נשאית או חולה!";
        String descreption5 = 
        		"גורם המחלה הוא חיידק - G. ההדבקה בין ציפור אחת לשניה בעיקר דרך האויר," +
        		" הפרשות עיניים לשלשת ואבק נוצות." +
        		" יכולה להתרחש ההעברה מהאם לביצה," +
        		" או מגע ישיר בין ציפורים." +
        		" ברמת נגיעות גבוהה יכולה להיות תמותת עוברים. ";
        Child diseas5 = new Child(copy5 ,descreption5 ,siptoms5 );
        
        String copy6 = "";
        String siptoms6 = 
        		".סימנים קלינים: החיידק יכול לגרום למחלת נשימה " +
        		"(שיעול, הפרשות מהאף, הצטברות הפרשות סביבהעיניים וקשיי נשימה)" +
        		", פגיעה בייצור ביצים, פגיעה בגדילה ודלקת לחמית העין. " ;
        String descreption6 = 
        		"גורם המחלה הוא חיידק - G תקופת דגירת החיידק שבוע עד 3 שבועות," +
        		" הדבקה לרב מתרחשת דרך האויר כאשר גורם מסייע הוא צפיפות רבה בין פרטים" +
        		"ישנן ציפורים שנשארות נשאיות עד להתפרצות המחלה לרב במצבי עקה (סטרם)" +
        		".לצורך אבחון במעבדתנו מומלץ לשלוח דגימת דם או swab מהפרשות עיניים או אף. ";
        Child diseas6 = new Child(copy6 ,descreption6 ,siptoms6);
        
        
        String copy7 = 
        		"המחלה הזאת מדביקה גם בני אדם!"+"\n"+
        		"הדרך הנפוצה ביותר להדבקות במחלה היא ע\'\'י שאיפה של אבק נוצות המכיל את החיידק. לכן כאשר מנקים את הכלוב, חשוב להרטיב את התחתית למניעת שאיפת אבק הנוצות לריאות. חשוב ללבוש מסכה לפנים ואפילו מגן עיניים במיוחד אם מדובר בציפורים שיובאו לאחרונה. המחלה עלולה לעבור גם ע\'\'י נשיכות של ציפור חולה. לציפור חולה אין סימני מחלה מיוחדים ומוגדרים, הם יכולים להתבטא בנוצות נפוחות, שלשול ירוק ונשימה כבדה. כמו כן, דמעות ונזלת בציפור. הציפורים עלולות למות בתוך ימים ספורים או לסבול מהמחלה מספר שבועות, לאבד משקל ולמות. ציפורים אחרות עשויות להראות סימנים קלים של המחלה, להבריא ואז להפוך לנשאיות של המחלה למשך חודשים ואפילו שנים.";
        String siptoms7 = "";
        String descreption7 = 
        		"למרות שדובר רבות במחלה זו בשנים האחרונות, בעלי תוכים עדיין אינם לוקחים אותה ברצינות הראויה." +
        		" לדוגמה, אפשר לקחת את המקרה שבו מחברת המאמר ואחד הטכנאים שלה נדבקו במחלה תוך " +
        		"כדי עבודה בגן החיות הלונדוני למרות שהשתמשו במסכות לפנים, כפפות גומי ואמצעי מיגון אחרים." +
        		" עשרה ימים לאחר שתוכי אשר חלה במחלה מת, חלו בה גם הם. סימני המחלה היו חום גבוה- 40.50C," +
        		" רעידות חזקות וכאבי ראש חזקים. " +
        		"המחלה לא התפשטה לאנשים אחרים כפי שהיה קורה במחלת השפעת. הרופאים לא חשדו בפיסטיקוזיס " +
        		"ולכן לא נתנו לה את הטיפול המתאים למחלה (המחלה טופלה באמפיצילין). אצל הטכנאי שאף הוא נדבק," +
        		" המחלה אובחנה מהר יותר והוא הגיב טוב יותר לטיפול תאים שכלל אנטיביוטיקה מסוג טטראציקלין.";
        
        Child diseas7 = new Child(copy7 ,descreption7 ,siptoms7 );
        
        String copy8 = "המחלה הזאת מדביקה גם בני אדם!";
        String siptoms8 = "";
        String descreption8 = 
        		"זהו זיהום בקטריאלי נפוץ של " +
        		"הפיסטיקוזיס במיוחד בציפורים שנלכדו ויובאו לאחרונה. המחלה נגרמת ע\'\'י מספר גדול ושונה של" +
        		" סוגי סלמונלה למרות שרבים מהסוגים הללו באופן נורמאלי אינם מזיקים לציפורים או לבני אדם." +
        		" בדיקות שגרתיות שנעשו לציפורים שמתו בזמן ההסגר, גילו רמות גבוהות של זיהום סלמונלה. Salmonella " +
        		"typhimurium היא הנפוצה והמסוכנת ביותר בין סוגי הסלמונלה." +
        		" סוגים שונים שלה קיימים בבעלי חוליות כולל ציפורים, יונקים וזוחלים. היא גורמת לזיהום " +
        		"של המעיים ולדלקת בהם. הקיבה עלולה גם היא להיות מושפעת בדלקת (גסטריטיס). " +
        		"לעיתים האורגניזם של הסלמונלה חודר למחזור הדם וגורם לזיהום ולחום כמו במקרה של הפיסטיקוזיס." +
        		" ציפורים עשויות להישאר בריאות תוך כדי שהן נושאות את נגיף הסלמונלה ולהדביק אחרים." +
        		"  בניגוד למקרה הפיסטיקוזיס, גם בני האדם עשויים להישאר בריאים ולשאת את הנגיף."
        		;
        Child diseas8 = new Child(copy8 ,descreption8 ,siptoms8 );
        
        String copy9 = "המחלה הזאת מדביקה גם בני אדם!";
        String siptoms9 = 
        		"הסימנים הקליניים של המחלה אינם ברורים. ניתן לזהות את המחלה רק ע\'\'י ניתוח שלאחר המוות וע\'\'י " +
        		"בדיקות בקטריאליות. אצל ציפורים המחלה תתבטא תמיד בזיהום הדם ותגרום לפצעי נמק" +
        		" לבנים על הכבד והטחול. פגיעה זו דומה מאוד לפגיעת מחלת השחפת ומכאן שם המחלה." +
        		" אצל האדם הפגיעה יכולה להיחשב בטעות כדלקת התוספתן מכיוון שהבקטריה חודרת " +
        		"לעיתים קרובות לבלוטות הלימפה של הבטן סמוך לתוספתן. דבר זה נפוץ במיוחד אצל ילדים." +
        		" לעיתים רחוקות יותר, הבקטריה חודרת לעור ולעיתים נדירות גורמת לזיהום הדם.";
        String descreption9 = 
        		"מחלת הפסאדוטוברקולוזיס נגרמת ע\'\'י בקטריה בשם pseudotuberculosis Yersinia. " +
        		"היא נפוצה במיוחד בכנרים, טוקנים, קופים ומכרסמים. המחלה לא נפוצה באופן יחסי בציפורים ממשפחת ה- " +
        		"psittacine ונראה שהיא דיי נדירה בתוכונים. המחלה פוגעת לעיתים באדם.דרכי ההדבקות " +
        		"הם כמו במקרה של הסלמונלה, בנוסף ניתן להידבק מסריטות ושפשופים של העור.עכברים, " +
        		"עכברושים וציפורי בר הם הגורמים להדבקות במחלה ע\'\'י זיהום מוצרי מאכל בהפרשותיהם.";
        Child diseas9 = new Child(copy9 ,descreption9 ,siptoms9 );
        
        String copy10 = "המחלה הזאת מדביקה גם בני אדם!";
        String siptoms10 = "";
        String descreption10 = 
        		"למחלת הטוברקולוזיס (שחפת) שלושה ענפים: שחפת באדם, שחפת בבעלי חיים כמו פרות ושחפת בעופות- " +
        		"בתוכים מסוימים כמו אמזונות ולורים יש את השוני הנדיר שגורם להם להיות רגישים באופן טבעי לבקטריית השחפת" +
        		" (מהסוג הפוגע בבני האדם). ככל הנראה, הם מסוגלים להיפגע גם משחפת הפוגע בבהמות. בתחילת המאה, " +
        		"השחפת הייתה נפוצה יותר באדם מאשר היום. המקרים הספורים של הדבקות ציפורים בשחפת האדם קרו בגן החיות " +
        		"ששם כנראה נדבקו הציפורים מהמבקרים בגן. המודעות למחלות העוברות מחיות לבני האדם הייתה נמוכה" +
        		" אז ולכן היו נותנים לבני האדם להאכיל את החיות באוכל שהביאו מהבית ושיכול היה להיות מזוהם במחלות." +
        		" באופן מפתיע אין שום עדות שפורסמה על ציפורים שהדביקו בני אדם. " +
        		"שחפת של עופות גורמת בציפור לאדישות, נוצות מלוכלכות, איבוד הדרגתי של המשקל ולעיתים אף שלשול." +
        		" תוכי שנדבק בשחפת אדם מפתח יובש וקשקשים בעור או עור דמוי גבינה בפנים ומסביב למקור." +
        		" מקרים שבהם בני אדם נדבקו בשחפת עופות הם מאוד נדירים וחמורים." +
        		" אנשים שחלו סבלו מאובדן משקל ולעיתים אף מתו. יתר המחלות שהוזכרו לעיל נדירות מאוד." +
        		" תוכים שחולים במחלות אלו עלולים להדביק בני אדם, אך כמעט ולא קימת עדות לכך.";
        Child diseas10 = new Child(copy10 ,descreption10 ,siptoms10 );
        
        
        for (int i = 0 ; i < diseases.length ; i++) {
            Parent prnt = new Parent();
            prnt.setName(diseases[i]);

            ch_list = new ArrayList<Child>();
            switch(i){
            case 0: 
            	ch_list.add(diseas1);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 1: 
            	ch_list.add(diseas2);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 2: 
            	ch_list.add(diseas3);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 3: 
            	ch_list.add(diseas4);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 4: 
            	ch_list.add(diseas5);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 5:
            	ch_list.add(diseas6);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 6: 
            	ch_list.add(diseas7);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 7: 
            	ch_list.add(diseas8);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 8: 
            	ch_list.add(diseas9);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;
            
            case 9: 
            	ch_list.add(diseas10);
            	prnt.setItems(ch_list);
                list.add(prnt);
            break;

            default: 
            	break;		            
            }
        }
        
        return list;
        
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
    	    Intent i = new Intent(Activity_Diseases.this , Activity_Email.class);
			i.putExtra(SUBJECT, "מחלות");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}
