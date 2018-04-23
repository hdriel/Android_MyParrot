package myparrot.vets;

import com.example.myparrot.Activity_Email;
import com.example.myparrot.R;

import java.util.ArrayList;

import myparrot.toys.Activity_Toys;
import myparrot.toys.Toys_info_activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.RelativeLayout;

	public class Activity_Vets extends Activity
	{
		
		final static String CITY = "name_of_city"; 
		final static String CLINIC = "name_of_clinic"; 
		final static String HOURS = "Hours_information"; 
		final static String NOTE = "note"; 
		final static String PHONE = "num_of_phone"; 
		final static String ADRESS = "the adress";
		final static String LINK = "the link";
		final static String IMAGE = "image_of_clinic";
		private Context context;
		
		private ArrayList<Child> ch_list;
	 	private ExpandListAdapter ExpAdapter;
	    private ArrayList<Parent> ExpListItems;
	    private ExpandableListView ExpandList;

	    public final static String ColorTheme = "the color themes" ;
	    public final static String ColorThemechild = "the color themes of child list" ;
		public final static String ColorThemeparent = "the color themes of parent list" ;
		
	    RelativeLayout vets;
		
		    @Override
		    protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.layout_vet);
		        
		        context = this;
		        
		        vets = (RelativeLayout) findViewById(R.id.vet_layout);
		        vets.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
		        
		        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
		        ExpListItems = SetStandardGroups();
		        ExpAdapter = new ExpandListAdapter(context , ExpListItems ,getIntent().getIntExtra(ColorThemeparent, 0) ,getIntent().getIntExtra(ColorThemechild, 0));
		        ExpandList.setAdapter(ExpAdapter);
		        
		        
		        ExpandList.setOnChildClickListener(new OnChildClickListener(){
					@Override
					public boolean onChildClick(ExpandableListView parent,  View v, int groupPosition, int childPosition, long id) {
						
						Child item= (Child)parent.getExpandableListAdapter().getChild(groupPosition, childPosition);
						//Child item = ch_list.get(groupPosition);
						
						Intent i = new Intent(context , ActivityToCallVets.class);
						i.putExtra(CITY, item.getCity());
						i.putExtra(CLINIC, item.getClinic());
						i.putExtra(HOURS, item.getHours());
						i.putExtra(NOTE, item.getNote());
						i.putExtra(PHONE, item.getPhone());
						i.putExtra(ADRESS, item.getAdress());
						i.putExtra(LINK, item.getLink());
						i.putExtra(IMAGE, item.getImage());
						
						i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
						
						startActivity(i);
						// TODO Auto-generated method stub
						return true;
					}
		        });
		        
		        
		        
		        
		        // Listview Group click listener
		        ExpandList.setOnGroupClickListener(new OnGroupClickListener() {
		            @Override
		            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
		                return false;
		            }
		        });
		        
		        ExpandList.setOnGroupExpandListener(new OnGroupExpandListener() {
		            int previousItem = -1;
		            @Override
		            public void onGroupExpand(int groupPosition) {
		            	
		            	//ExpandList.getChildAt(groupPosition).setBackgroundResource(getIntent().getIntExtra(ColorThemechild, 0));
		                
		            	if(groupPosition != previousItem )
		                	ExpandList.collapseGroup(previousItem );
		                previousItem = groupPosition;
		            }
		        });
		         
		        
}

		    public ArrayList<Parent> SetStandardGroups() {
		    	String city_dimona="������" , city_beer_sheva = "��� ���",city_tell_aviv="�� ����" , city_reashon ="����� �����", city_ranana="�����" ,   city_jerosalem = "�������" , city_haifa ="����" , city_zihron = "����� ����";
		        String[] cities = {city_dimona, city_beer_sheva , city_tell_aviv ,city_reashon , city_ranana ,city_jerosalem ,city_haifa ,city_zihron}; 

		        
		        ArrayList<Parent> list = new ArrayList<Parent>();
		        
		        //Child(String city, String clinic, String hours, String note,
		    	//		String phone, String adress, String link, int image)

		        String hoursD1 = "�\'- �\' 9:00 - 20:00"+"\n"+"�\' 9:00 - 14:00"  ;
		        Child Dimona1 = new Child("������" , "�\'\'� ���� ����-����� ��������" ,hoursD1 ,"������ ����","050-545-8258" , " ����� ����� (����� ���� ����) ����� ������ ��� ����" ,"http://www.dragur.zapweb.co.il" ,R.drawable.beer_sheva2);

		        String hoursB1 = "�\'- �\' 8:30 - 18:00"+"\n"+"�\' 8:30 - 13:00"  ;
		        Child BeerSheva1 = new Child("��� ���" , "��� ������ ��������" ,hoursB1 ,"���� ����� ���� ���� ���� ���� ����� ����� ��� ������� ������� �\'\'� �� ����� ���� �������� ����" ,"08-646-0514" , "���� �� ���, ��� ���" ,"http://www.vethosp.co.il" ,R.drawable.beer_sheva1);
		        String hoursB2 = "�\'- �\' 10:00 - 20:00"+"\n"+"�\' 10:00 - 13:00"  ;
		        Child BeerSheva2 = new Child("��� ���" , "����� �������� �\'\'� ����" ,hoursB2 ,"������ ������ �����, �� ��� ����� �� ������ ���� ���" +"\n"+ "������ ������ ���� ����� ������� �����: 03-6106666 ���� 1791 ��: 03-7561474","08-6421848" , "����� ����� 2 ,��� ���" ,"http://www.barnea4pets.co.il" ,R.drawable.beer_sheva2);

		        
		        String hoursT1 = "���� �\', �\', �\', �\' \t	17:00 - 20:00" +"\n"+ "��� �\' \t	9:00 - 12:00"+ "\n"+"��� ���� \t	9:00 - 14:00";
		        Child TelAviv1 = new Child("�� ����" , "������� ���" ,hoursT1 ,"����� 24 ����! ����� ����� ������." ,"072-322-4687" , "�� 83 �� ����" ,"http://www.my-vet.co.il" ,R.drawable.tell_aviv1);
		        Child TelAviv2 = new Child("�� ����" , "�\'\'� ���� �����" ,"7 ���� �����, 24 ���� �����" ,"" ,"03-566-0045" , "��������� 107 ,�� ����" ,"http://www.petholim.co.il" ,R.drawable.tell_aviv2);

		        Child reashon1 = new Child("����� �����" , "��� ������ ��������� ������������" ,"7 ���� �����, 24 ���� �����" ,"","072-322-4107" , "��� ������ 70 ,����� �����" ,"http://www.vethospital.huji.ac.il/index.php" ,R.drawable.reashon1);
		        
		        String hoursR1 = "�\'- �\' 8:30-20:00"+"\n"+"�\' 8:30-16:00" ;
		        Child ranana1 = new Child("�����" , "��� ������ ������ ������ ���" ,hoursR1 ,"����� ����� ��� ��� ������ ����." ,"09-774-8753" , "����� 240, �����" ,"http://www.tukivet.co.il" ,R.drawable.ranana1);

		        String hoursJe1 = "�\'- �\': 11:00 - 12:30 , 17:30 - 19:45"+"\n"+"�\': 09:00 - 11:30"  ;
		        Child jerosalem1 = new Child("�������" , "�\'\'� ���� ����� ������" ,hoursJe1 ,"����� ������ ���� ����."+"\n"+"������ ������ ����� ��������� ������: 02-676-8989","02-582-4537" , "����� 23 �.����� �.������ , �������" ,"http://www.docblank.zapweb.co.il" ,R.drawable.jerosalem2);
		        String hoursJe2 = "�\'- �\': 08:30 - 10:00  , 15:30 - 19:30"+"\n"+"�\': 13:00 - 14:30"  ;
		        Child jerosalem2 = new Child("�������" , "�\'\'� ���� �����" ,hoursJe2 ,"������ ������ ����� ������� ��������� ������: 02-582-4537.","02-676-8989" , "����� 218 , �������" ,"http://www.docblank.zapweb.co.il" ,R.drawable.jerosalem1);

		        String hoursHo1 = "�\'- �\': 10:00 - 12:00, 16:30 - 19:30"+"\n"+"�\': 10:00 - 14:00"  ;
		        Child HofAcarmel1 = new Child("����" , "������ ����" ,hoursHo1 ,"������ ������ ������ 24 ���� �����.","054-521-8621" , "�.�. ��� ����� ��� ����" ,"http://www.vet-hakfar.zapages.co.il" ,R.drawable.zihron1);
		        Child Haifal1 = new Child("����" , "�\'\'� ���� ��- ��" ,"7 ���� �����, 24 ���� �����" ,"" ,"054-631-3331" , "��\' �����  56 , ����" ,"http://www.itaibarshai.zapages.co.il" ,R.drawable.haifa1);

		        String hoursZi1 = "�\'- �\': 8:00 - 20:00"+"\n"+"�\': 8:00 - 14:00"  ;
		        Child Zihron1 = new Child("����� ����" , "�\'\'� �� �����" ,hoursZi1 ,"����� ��� ����� ����,����� 24 ���� �����","04-629-1010" , "���� 2 ����� ���� �����, ����� ����" ,"http://www.gal-hayot.com" ,R.drawable.zihron1);

		        
		        
		        for (int i = 0 ; i < cities.length ; i++) {
		            Parent prnt = new Parent();
		            prnt.setName(cities[i]);

		            ch_list = new ArrayList<Child>();
		            switch(i){
		            case 0: // ������
		            	ch_list.add(Dimona1);
		            	prnt.setItems(ch_list);
		                list.add(prnt);
		            break;
		            
		            case 1: // ��� ���
		            	ch_list.add(BeerSheva1);
		            	ch_list.add(BeerSheva2);
		            	prnt.setItems(ch_list);
		                list.add(prnt);
		            break;
		            
		            case 2: // �� ����
		            	ch_list.add(TelAviv1);
		            	ch_list.add(TelAviv2);
		            	prnt.setItems(ch_list);
		                list.add(prnt);
		            break;
		            
		            case 3: // ����� �����
		            	ch_list.add(reashon1);
		            	prnt.setItems(ch_list);
		                list.add(prnt);
		            break;
		            
		            case 4: // �����
		            	ch_list.add(ranana1);
		            	prnt.setItems(ch_list);
		                list.add(prnt);
		            break;
		            
		            case 5: // �������
		            	ch_list.add(jerosalem1);
		            	ch_list.add(jerosalem2);
		            	prnt.setItems(ch_list);
		                list.add(prnt);
		            break;
		            
		            case 6: // ����
		            	ch_list.add(HofAcarmel1);
		            	ch_list.add(Haifal1);
		            	prnt.setItems(ch_list);
		                list.add(prnt);
		            break;
		            
		            case 7: // ����� ����
		            	ch_list.add(Zihron1);
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
		    	    Intent i = new Intent(Activity_Vets.this , Activity_Email.class);
					i.putExtra(SUBJECT, "�������� ����� ���");
					i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
					startActivity(i);
		       }
		         return true; 
		          default:  
		            return super.onOptionsItemSelected(item);  
		        }
		    }		
}