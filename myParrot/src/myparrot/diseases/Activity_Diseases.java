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
        		"���� ����� ������� - Psittacine Beak & Feather Disease Viirus",
        		"������� - Poliona Virus",
        		"���� ���\'�� - Pacheco`s Parrot Disease",
        		"������� (����) - Chlamydia Pcittaci",
        		"������� - Salmonella",
        		"��������� - Mycoplasma spp",
        		"���������� - PSITTACOSIS",
        		"�������  - SALMONELLOSIS",
        		"���������������� - PSEUDOTUBERCULOSIS",
        		"���� ����� ���� - TUBERCULOSIS"
        };
        
        
        //Child c = new Child(copy, descreption, simptom, image);
        String copy1 = "����� ������ ������ ��� ����� ��� ����� ��� ���� ��� �������, ������ ���� ���� (�����), ��� ���� ���� �����. ";
        String siptoms1 = 
        		"������ ��������:" +
        		" ����� �����, ������� ����� �� ������, ����� ����� (�����, ����� ���), ����� ������ ������," +
        		" ����� ������ ����. ����� ���� ����� ����� �� ������ ����� ����� ����� �� ���� ������ �������," +
        		" ���� ���� ������ ����� ����� ��� ������ DNA ������.����� ����� ��������, �� ����� ����� �� �� �����" +
        		" (����� - ���� ������� �������� ����)."
        		;
        String descreption1 = 
        		"����� ����� ������� ��� ������� ���� ������ ��������, " +
        		"�� �� ����� ���� ������� �� ����� ����� (����� �������� ���������) ��� ��� ����� �����. ���� ����� ��� ���� ������ �-" +
        		" circovirus , ��� �� ����� ������, ��� ������, ��� ������ ������." +
        		" ���� �������, ����� �- 15 ���� ����� �� �����, �� ����� �� ����� ���� ������� �� �� ��." +
        		" ����� ������ ����� ���� �� ����� ���� ���� ���� �� �������� ������ �������." +
        		" ��� ������ �������� �������� ������ ��� �����, ��� ������," +
        		" ���� ����� ������� �� ����� ������. ����� ���� ������ ������, ������ ������, ����, ���� ����." +
        		" ���� ������ ����� ������ ������ ����� ���� ������." ;
        Child diseas1 = new Child(copy1 ,descreption1 ,siptoms1 );
        
        String copy2 = "���� �����: ��� �����, �����, ����, ��� ���� ������� ������";
        String siptoms2 = 
        		"������� �������� ������ ����� �������� ����, ����� ����, ������ ����," +
        		" �����, ����� �����, ����� ����, �������, ����� ������, ���� �����, ������� ������� �����." +
        		" ����� ����� �� ������ ����� ����� ��� ��� ���� ����� ���� ����� ����� ��� �������� �������." +
        		"��� ������ ���� �� ������ ����� ��� ����� �����. ��� ������� ����� �� ����� ������� ����� " +
        		"�� ������ ������ �� ������ ������ �� ���� �������.����� ����� �������� �� ����� ����� ��";
        String descreption2 = 
        		"���� ����� ��� ����, ����� ���� ��� ���� ��������. ����� ������ ����� �� ������ ������� ����� ��� 48 " +
        		"���� ���� ����� ������� �������� �� ������� �������.";
        Child diseas2 = new Child(copy2 ,descreption2 ,siptoms2 );
        
        String copy3 = "";
        String siptoms3 =
        		"������ ������: �����, ����� �����, ����� ����, ������ ����, ���� ����� ���� ������� ������." +
        		" ������� ������ ��� ���� ��� (����) ����� ����� ������ ���� ����� ����� �� �� swab ������� ������� ������" +
        		" ������.";
        String descreption3 = 
        		"���� ����� ��� ���� �����." +
        		" ����� ����� ���� �� �- 48 ����, ���� ����� 5 ���� ��� ���� ������. ���� ����� ��� ����," +
        		" ����� ������: ����� ����� ����� ������, ������ ��� ����� �����. ���� ���\'��, �� ���� �����," +
        		" ��\'\'� ����� ���� ���� (���) �� ���� ���� ������ �� �� ����� ������� �����.����� ����\'�� �����" +
        		" ����� ����� ������ ���� ����� ���� ���� ������ �������, ���� ��� ������ �� �������. �����, ����� �����" +
        		" (antiviral acyclovir) ������ �����, ��� �� ���� ������� ������� �� �����." +
        		" ���� ����� ����� ���� ����� �� ������� ����� �\'\'� ����� ���� ������ �� ������ ����� �������," +
        		" ����� ����� ���� ������ ��� �� ��� �����, �� ������ �� ����� ����.";
        Child diseas3 = new Child(copy3 ,descreption3 ,siptoms3 );
        
        String copy4 = ".����� ������ ������ ������ ������ ��� ������ ������," +
        		" ����� ���� �����, ����� ����� ����� ����� ���� ������ ����� �����."+"\n"+"\n"+
        		"����� ����� ����� ���� ���� ���� ����� ������� �������� ���� ����� �� ����! ";
        String siptoms4 = 
        		"������� �������� ������� ������:" + "\n"+
        		"- ������� (�������), ����� ����� ������ (������ �������� ����, ���� �����)." +"\n"+
        		"- ���� �����.- ����." +"\n"+
        		"- �������� ��� �����." +"\n"+
        		"- ����� �����" ;
        String descreption4 = 
        		"���� ����� ��� ����� Chlamydia Pcittaci, " +
        		"��� ����� ���� ��� ������.����� ����� ������� ����� ����� ��� �� ������, " +
        		"�� ������ ����� ����� ����� ������� �� ������ �� �� ��� �� ���� ������ ������� ���� ���� ����" +
        		".����� ������ ������� ���� ����� ���� �������. " +
        		"����� ����� ����� �� ����� ������ ����� ��, swab ������� ���� �� �������"
        		;
        Child diseas4 = new Child(copy4 ,descreption4 ,siptoms4 );
        
        String copy5 = "";
        String siptoms5 = 
        		"������ �������" +"\n"+
        		" - �����," +"\n"+
        		" ���� ����� ������." +"\n"+
        		" ������ ������ ������ ���� ���� �����, " +"\n"+
        		"���� ����� ���� ���� ������� ������� (���, ����, ���� �� ��)."+"\n"+"\n"+
        		"����� ����� ����� ���� ���� ���� ����� ������� �������� ���� ����� �� ����!";
        String descreption5 = 
        		"���� ����� ��� ����� - G. ������ ��� ����� ��� ����� ����� ��� �����," +
        		" ������ ������ ����� ���� �����." +
        		" ����� ������ ������ ���� �����," +
        		" �� ��� ���� ��� �������." +
        		" ���� ������ ����� ����� ����� ����� ������. ";
        Child diseas5 = new Child(copy5 ,descreption5 ,siptoms5 );
        
        String copy6 = "";
        String siptoms6 = 
        		".������ ������: ������ ���� ����� ����� ����� " +
        		"(�����, ������ ����, ������� ������ ����������� ����� �����)" +
        		", ����� ������ �����, ����� ������ ����� ����� ����. " ;
        String descreption6 = 
        		"���� ����� ��� ����� - G ����� ����� ������ ���� �� 3 ������," +
        		" ����� ��� ������ ��� ����� ���� ���� ����� ��� ������ ��� ��� �����" +
        		"���� ������� ������� ������ �� �������� ����� ��� ����� ��� (����)" +
        		".����� ����� �������� ����� ����� ����� �� �� swab ������� ������ �� ��. ";
        Child diseas6 = new Child(copy6 ,descreption6 ,siptoms6);
        
        
        String copy7 = 
        		"����� ���� ������ �� ��� ���!"+"\n"+
        		"���� ������ ����� ������� ����� ��� �\'\'� ����� �� ��� ����� ����� �� ������. ��� ���� ����� �� �����, ���� ������ �� ������ ������ ����� ��� ������ ������. ���� ����� ���� ����� ������ ��� ������ ������ �� ����� �������� ������ �������. ����� ����� ����� �� �\'\'� ������ �� ����� ����. ������ ���� ��� ����� ���� ������� ��������, �� ������ ������ ������ ������, ����� ���� ������ ����. ��� ��, ����� ����� ������. �������� ������ ���� ���� ���� ������ �� ����� ������ ���� ������, ���� ���� �����. ������� ����� ������ ������ ������ ���� �� �����, ������ ��� ����� ������� �� ����� ���� ������ ������ ����.";
        String siptoms7 = "";
        String descreption7 = 
        		"����� ����� ���� ����� �� ����� ��������, ���� ����� ����� ���� ������ ���� ������� ������." +
        		" ������, ���� ���� �� ����� ��� ����� ����� ���� ������� ��� ����� ����� ��� " +
        		"��� ����� ��� ����� �������� ����� ������� ������ �����, ����� ���� ������ ����� �����." +
        		" ���� ���� ���� ����� ��� ��� ����� ��, ��� �� �� ��. ����� ����� ��� ��� ����- 40.50C," +
        		" ������ ����� ����� ��� �����. " +
        		"����� �� ������ ������ ����� ��� ���� ���� ����� �����. ������� �� ���� ����������� " +
        		"���� �� ���� �� �� ������ ������ ����� (����� ����� ����������). ��� ������ ��� ��� ����," +
        		" ����� ������ ��� ���� ���� ���� ��� ���� ������ ���� ���� ����������� ���� ����������.";
        
        Child diseas7 = new Child(copy7 ,descreption7 ,siptoms7 );
        
        String copy8 = "����� ���� ������ �� ��� ���!";
        String siptoms8 = "";
        String descreption8 = 
        		"��� ����� �������� ���� �� " +
        		"����������� ������ �������� ������ ������ �������. ����� ����� �\'\'� ���� ���� ����� ��" +
        		" ���� ������� ����� ����� ������� ���� ����� ������� ���� ������ �������� �� ���� ���." +
        		" ������ ������� ����� �������� ���� ���� �����, ���� ���� ������ �� ����� �������. Salmonella " +
        		"typhimurium ��� ������ �������� ����� ��� ���� ��������." +
        		" ����� ����� ��� ������ ����� ������ ���� �������, ������ �������. ��� ����� ������ " +
        		"�� ������ ������ ���. ����� ����� �� ��� ����� ������ ����� (��������). " +
        		"������ ��������� �� �������� ���� ������ ��� ����� ������ ����� ��� ����� �� �����������." +
        		" ������� ������ ������ ������ ��� ��� ��� ������ �� ���� �������� ������� �����." +
        		"  ������ ����� �����������, �� ��� ���� ������ ������ ������ ����� �� �����."
        		;
        Child diseas8 = new Child(copy8 ,descreption8 ,siptoms8 );
        
        String copy9 = "����� ���� ������ �� ��� ���!";
        String siptoms9 = 
        		"������� �������� �� ����� ���� ������. ���� ����� �� ����� �� �\'\'� ����� ����� ����� ��\'\'� " +
        		"������ ����������. ��� ������� ����� ����� ���� ������ ��� ������ ����� ���" +
        		" ����� �� ���� ������. ����� �� ���� ���� ������ ���� ����� ����� �� �����." +
        		" ��� ���� ������ ����� ������ ����� ����� ������� ������ �������� ����� " +
        		"������ ������ ������� ������ �� ���� ���� �������. ��� �� ���� ������ ��� �����." +
        		" ������ ������ ����, ������� ����� ���� ������� ������ ����� ������ ���.";
        String descreption9 = 
        		"���� ����������������� ����� �\'\'� ������ ��� pseudotuberculosis Yersinia. " +
        		"��� ����� ������ ������, ������, ����� ��������. ����� �� ����� ����� ���� �������� ������ �- " +
        		"psittacine ����� ���� ��� ����� ��������. ����� ����� ������ ����.���� ������� " +
        		"�� ��� ����� �� ��������, ����� ���� ������ ������� �������� �� ����.������, " +
        		"�������� ������� �� �� ������� ������� ����� �\'\'� ����� ����� ���� ����������.";
        Child diseas9 = new Child(copy9 ,descreption9 ,siptoms9 );
        
        String copy10 = "����� ���� ������ �� ��� ���!";
        String siptoms10 = "";
        String descreption10 = 
        		"����� ������������ (����) ����� �����: ���� ����, ���� ����� ���� ��� ���� ����� ������- " +
        		"������ ������� ��� ������� ������ �� �� ����� ����� ����� ��� ����� ������ ����� ���� �������� �����" +
        		" (����� ����� ���� ����). ��� �����, �� ������� ������ �� ����� ����� ������. ������ ����, " +
        		"����� ����� ����� ���� ���� ���� ����. ������ ������� �� ������ ������� ����� ���� ��� ��� ����� " +
        		"��� ����� ����� �������� �������� ���. ������� ������ ������� ����� ���� ���� ����� �����" +
        		" �� ���� ��� ������ ���� ���� ������ �� ����� ����� ������ ����� ������ ��� ����� ����� ������." +
        		" ����� ����� ��� ��� ���� ������� �� ������� ������� ��� ���. " +
        		"���� �� ����� ����� ������ �������, ����� ��������, ����� ������ �� ����� ������� �� �����." +
        		" ���� ����� ����� ��� ���� ���� ������� ���� �� ��� ���� ����� ����� ������ �����." +
        		" ����� ���� ��� ��� ����� ����� ����� �� ���� ������ �������." +
        		" ����� ���� ���� ������ ���� ������� �� ���. ��� ������ ������� ���� ������ ����." +
        		" ����� ������ ������ ��� ������ ������ ��� ���, �� ���� ��� ���� ���� ���.";
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
			i.putExtra(SUBJECT, "�����");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}
