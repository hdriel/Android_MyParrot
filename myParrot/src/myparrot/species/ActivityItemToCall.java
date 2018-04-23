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
	
	public static final String JAKO = "�\'���", TOCON= "�����" , COCKOTAIL = "�������" , 
			   DRARA = "����" , CONURE = "������", COCKATOO = "�����", 
			   LOVE_BIRD = "���� ����", ARA = "���", LORY = "����";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.species_item_activity);
        
        itemSpecies_layout = (LinearLayout) findViewById(R.id.speItem_layout);
        itemSpecies_layout.setBackgroundResource(getIntent().getIntExtra(ColorTheme, 0));
        
        
        Log.d("��� �����: ", "������ ����� onCreate");
        
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
	    
	    Log.d("��� �����: ", "��� �� ������� �� �������");
	    
	    // Get the Intent used to start this Activity
				intent = getIntent();
				
				switch(intent.getStringExtra(Activity_Species.EXTRA_RES_ID)){
				case JAKO:{
					title_name.setText("�\'���");
					other.setText("���� �\'���: �����, �����");
					sizer.setText("����� ����� �: ���� ������");
					description.setText("���� �� ��� ����. ����� ����. ���� ����, ���� ������ �� ��� ��� ���� ����. ���� �� ��'��� ��\'\'� ���� ����, �� ���� ����� ������ �� ������ ���� ����. ����� ���� ���� ���, ����� �����. ����� ���� ������ ���� ��������, ������ ������ ���� ����� ���� ��������. ��� ������ ���� ����. ���� ������� ������� ���� � ������. ����� ����, ���� ����� ����� �������� ������ ����. ��-������� �����, �� ���� ������ ��� ��� ����� �\'\'� ������ ��������. ������� ����� ���� �������, ���� 3 ������: ��� ������ ���� (���� �����) ������, ��� ���� ���� ����� ��� ���� ����� ���� ���� �������� ������. ");
					size.setText("60x60x120 �\'\'�");
					length.setText("35 �\'\'�");
					weight.setText("400 ���");
					price_normal.setText("1,500-2,000 �");
					price_yad.setText("2,000-3,000 �");
					food.setText("�����, ������, �����, ����� ��������. ������ ����� �� ����, ������, ����, ����, ������ ���� ������ ��� �� ���� ����. ����� ����� ���� ������ ����� �������. ������� (�������), ������, ������ �� ����� ������, ���: �����, �����, ������� �������. ���� ���-���. ��� ���, ����� ������ (��� ���, ������, ���'), ���� �����. ��'��� �� ����� ����� ����� ����� �� ������ ������� ���� �� ������ ��� ������ ���� ������� ������ ����. ");
					life.setText("50-80 ���");
					imageView.setImageResource(R.drawable.im_jako);
					imageView.setTag(R.drawable.im_jako);
					gridview.setAdapter(new ImageAdapter(this, jako));
				}break;
				case TOCON:{
					title_name.setText("�����");
					other.setText("���� �������: �����, �������, ����� �� �\'��, ��� ���");
					sizer.setText("����� ����� �: ���� ���");
					description.setText("������ ��� ������ ������ ����� ����� ��� ������ �����, ��� ���� ������� �� �� ����. �������� ������ ������ ��� ������� ���� ����� ��������. ������ ����� �����, ���� ����� �� ������ ���� ������������ ��� ������ �� ����� �\'\'��� �������\'\'. ������ ��� ����� �������� ����� ������ ���� ���� ���� ���� ����� ����� ��� ��� ����� �����.");
					size.setText("60x60x120 �\'\'�");
					length.setText("19 �\'\'�");
					weight.setText("30 ���");
					price_normal.setText("25-40 �");
					price_yad.setText("60-90 �");
					food.setText("�������� ����� ��. ���� ��� ��� ��� ��� �������, ������ ��� ����� ������ ������ ������. ������ ����� ��� ������, �����, ������, �������. ����� ��� ����: ���, ����� ���, ���, ���� ������. ���� ������ ���� ��������� ����� ���� ���� �� �����. ");
					life.setText("5-9 ����");
					imageView.setImageResource(R.drawable.im_tucon);
					imageView.setTag(R.drawable.im_tucon);
					gridview.setAdapter(new ImageAdapter(this, tucon));
				}break;
				case DRARA:{
					title_name.setText("����");
					other.setText("���� ����: ���� �����/�����/����� ,���� ��� �����");
					sizer.setText("����� ����� �: ���� ������");
					description.setText("���� ����� ������, ����� ����� ���� ����, ���� ���� ������ ����. ���� ���� ���� �������� ���� �� ����� ���� ���� �����-����. ����� ���� ������. ������ ��������� \'\'����\'\' (kee-ak) ��� �������, ����� ��. ������ ������, �� ��� ���� ������ ������� ����, ������� ����������� (����� ������ ������ ����, ������� ������� ����� ���� ����). ���� ����� ���� ����, ������ ������ ��� ���, ����� ����� ����� ������� �������. ���� ����� ���� ����� ������ �� ������ ����� ��������. ������ ������� ���� ����� ����� (����� ���� ���� �� ���), ������� ������ ������. ����� �������� ������, ����� �������� �� ���� ������ ������. ����� - �����, ������, ��������� ������.");
					size.setText("2.5x1x2 ���");
					length.setText("22-40 �\'\'�");
					weight.setText("120-140 ���");
					price_normal.setText("150-200 �");
					price_yad.setText("300-400 �");
					food.setText("������ ������� ����� ����� �����, ���� �����, ������, �����, ���� ,�����, ���� (����� ����� ������ ��������). ���� ������, ���� �������� �� ����, ������, ������� ���, ������ ���� ����� �������, ���� ����, ����, ����, ��� ������ �����. ����� ������ �� ������ ��� ���� ����� ������� ���. ���� ����� ����� ������ ������� ������� (������ �����, �����, ���� ���� �����, ������ ����, ����, �����, �������), ����� �� ����� (������, �����, �����, �����, �������� ����), ����� (��� ���, ���� ��� �����, ���, ����, ������ ����), ���� ����� (�� ����, ������ ������ �����) ������� ����� (���� �����, ��� �����, ���������� �����).");
					life.setText("45-50 ���");
					imageView.setImageResource(R.drawable.im_drara);
					imageView.setTag(R.drawable.im_drara);
					gridview.setAdapter(new ImageAdapter(this, drara));
				}break;
				case COCKOTAIL:{
					title_name.setText("�������");
					other.setText("���� �������: ����, ����, ���");
					sizer.setText("����� ����� �: ���� ���");
					description.setText("���� �������� (Nymphicus hollandicus) ���� ���� ������� ����� �� ����� ����� ����� ��������. ��� ���� �� ���� ������ ���� ���� ���� ��� ���� ������� ���� ����� ���. ���� ����� ������ ������ �� ��� ���� ������ ��� ���� ����� �� ��� ����.");
					size.setText("50x50x66 �\'\'�");
					length.setText("25-33 �\'\'�");
					weight.setText("80-120 ���");
					price_normal.setText("100-130 �");
					price_yad.setText("250-350 �");
					food.setText("�������� ���� ��� �� ���� ������ ����� ������, ������ ��������. �������� ���� �������, �������, �����, ����� �����, ����� ��� ����, ������ ������ �������� ������ ��������. �� ���� ���� ���� ����� ��� ���� ���� �����. ���� ����� �������� ������� �������� �������� ������� �������, �������� �������� ������ ������ ������� �� ������� ����� ���� ���� ����� ���. ����� ���� ����� ���������, ������� ������ ����� ����� ������� ��� ����� �� ������� ������. �� ���� ����� �������� ��� ������� ���������. ");
					life.setText("8-14 ���");
					imageView.setImageResource(R.drawable.im_cockatiel);
					imageView.setTag(R.drawable.im_cockatiel);
					gridview.setAdapter(new ImageAdapter(this, cockatail));
				}break;
				case COCKATOO:{
					title_name.setText("�����");
					other.setText("���� �����: ����,������,������, �����, ����\'� �����, ����� �����, ��� �����, �����, ������");
					sizer.setText("����� ����� �: ���� ����");
					description.setText("����� ��� ������� ������� �������� ����� �����, ���� ��� ���� ����� ���� ������� ����. ���� ��� ���� ����� �� ���� ���� �����, ��� ����� ��� ����� ������� �������� ���������� ���� �����, �� ����� �� ���� ��� ����������, �������� ����� ����� ����� �� ���� ���� ����� ����. ���� ���� ���� ���� ��� ����� �� ���� ��� �������, �� ������ �� ����� ���. ���� ����� �� ����� ���� ������, ������ �����������, ����� ��� ����� ��� ������� ����. �� ���, ���� ��� �� ������� ���� ���� ����� ����, ���� ���� ���� ���� ������� �������� ������� ���� ������� ������ ��� �� ����. ���� ��� ����� �� ���� ���� ��� ������� '����', ���� ��� �� ����, �� ��� ���. �����, ����� ������ �� ������ �� ������, �� �� ���� ����� (��� ������ ��������, ���� ��� �� ���� ��� ���� �� �'���) ������� ���� �� ���� ����, ���� ������ ��� ������ ����, �� �� ������ ������ �� ����� ������ ������� ����. ���� ����� ������ ����� �� 700 ����� �����. ���� ����� �� ������, ���� ���� ��� �� �����, �� �� ����� ������ ����� �� ���� ����� �� ����� ���� ����� ������ ����. ����� �������� ������������ ���� ���� �� ����� ������� ���� ����, ��� �� ������ ���. ���� ����� ������ ���� ��� ����� ���� ����� �� ���� ���� ������� ����� �����. �� ���� ���� ���� ���� ���� ����-���, �� ���� ���� ����� ����� ����. ���� ��� ��� ���� ����� ������� ������ ����.");
					size.setText("2x2x6 ���");
					length.setText("30-45 �\'\'�");
					weight.setText("200-550 ���");
					price_normal.setText("3,000-4,000 �");
					price_yad.setText("4,500-5,000 �");
					food.setText("������� ,������, ����, ������ ����,������� ������ ������,�����,�����");
					life.setText("40 ��� �����");
					imageView.setImageResource(R.drawable.im_cockatoo2);
					imageView.setTag(R.drawable.im_cockatoo2);
					gridview.setAdapter(new ImageAdapter(this, cockatoo));
				}break;
				case CONURE:{
					title_name.setText("������");
					other.setText("���� ������: ���, �\'���\'�, ����, ���� ���, �� ����, ����, ��� ����, �������, �����, �\'�����, �����\'�� ����/���-�����/������, ���� ����");
					sizer.setText("����� ����� �: ���� ���");
					description.setText("������ ���� ���� ����� ����� �-���� ������. ����� �������� ���� ����� ����� �� 6-30 ����� �����. ������ ����� ���� �� ���� ������ ������, �� ���� ��� ���� ���� ����, �� �������, �������� ������ ���� �� �- 30 �\'\'�. ���� ����, ���� ���� ���� �����, ����� ������ ���� �����, ���� ����� ������ ���� ������� ���� ���� ����, ���� ������ ������� ������ ������ �� ��� ����� �� ���� ���. ������� ����� ����� ����� ���� �������� ���� ����, ����� ���� ����� �� �� �����. ������� ������, ����� ������, ����� ����. �� ����� ���� ���� �� �����, ������� ����� ����� ������� ����� ������� �����. \n ����� ����: ���� ����, ������, �� ���� ��� �� ���� �����. ���� ����� ����, ������ ��� ������ ����� ���� ����� ���, ����� ���� ���� ����� ���. ������ ����� ����� ��. ���� ��� ��� ���� ���� ����� �� ��� ������ �������, �� ���� ���� �������� ����. �������, ��� ���� ������ �� ��. 	��� �����:�� ��� �� ������ ���� ��� �� �����,�� ��� �� ������ ��� ��� ��� ������ �� �����.");
					size.setText("80x80x100 �\'\'�");
					length.setText("24-35 �\'\'�");
					weight.setText("100-150 ���");
					price_normal.setText("500-600 �");
					price_yad.setText("700-1,000 �");
					food.setText("������ ����� ������ ������ ��������/  ������ ������ ���� ������ �����, ������ ������, ������� ������ ��������, ����� ������, ���� ��� ������ (�� ������), ����� �� �����, ����� ������ �����. ");
					life.setText("20-30 ����");
					imageView.setImageResource(R.drawable.im_conure2);
					imageView.setTag(R.drawable.im_conure2);
					gridview.setAdapter(new ImageAdapter(this, conure));
				}break;
				case ARA:{
					title_name.setText("���");
					other.setText("���� ���: �������� ,���&����, ���� �����, �������, ������,���� ����");
					sizer.setText("����� ����� �: ���� ����");
					description.setText("���� ���� ���� ����� ���� ��� ���� ���� ���� ����. ���� ��� ���� ����� ���� ����� ���� ���� �� ��� ����� �� ������ ���� ��� ������. \n ����� ���� ��� ��� ������ ��� ����� �������� ���� ����� ����� ������ ���� ���� ����� ����� ��� �� �� ���� ����� ����� ��� ����� �������.\n ���� ��� ���� ���� ���� ����, ���� ���� �� ����� ���� �� ��� �� ������ �������� ��� ������ �� �����, ��� �� ���� ����� ��� ����� �� ����� �� ��� ��� ��� �� ����� ���� ��� ���� ����� �� ���� �\'\'� ������� �����, ���� �� ���� ���� ��� �� ��� ��� ��������� ����� ����� ���. \n ���� ������ �� ���� ���� �� �������� ����� �� ������ ����� ������ ��� ������� ������� ��������� ��� ����� ���� ���� ��� ���� ����� �� ����� ������ ���� ������ ����.");
					size.setText("104x71x172 �\'\'�");
					length.setText("1 ���");
					weight.setText("1,500 ���");
					price_normal.setText("");
					price_yad.setText("");
					food.setText("���� ��� ���� ��� ����� ���� ������ ���� ������ ����� ����� ������ ������� ����. ���� ����� ������� ����� ������ ����� �� ������ ������, ������ �� ��� ���� �����, ���� ���� ����� ������ ���� �� ���� ���� ����� ���� ���� �� ������, ����� ��� ���� ���� ������� ����� �� ��� ������ ��� ��� �� ���� ����� ����� ���� ��� ����� ��� �������. ����� ������ ����� �� �������� �������� ���� ��� ����� ���� ����� �� �� ������� ����� ���� ����� ����� �� �� ������ ����, �� ��� ������ ������ ���� �� �� ����� �� ������� ������� ����� ������, ����� ������� �� �\'��� ���� ��� ���� ������ ������ ����.");
					life.setText("50-70 ����");
					imageView.setImageResource(R.drawable.im_hara);
					imageView.setTag(R.drawable.im_hara);
					gridview.setAdapter(new ImageAdapter(this, hara));
				}break;
				case LOVE_BIRD:{
					title_name.setText("����/����� ����");
					other.setText("���� ���� ����: ���� ����, ����,���� �\'��, �����, ���\' ����, �� ����, �������, ������");
					sizer.setText("����� ����� �: ���� ���");
					description.setText("������ ���� ��� ����� ����� ����� ������ ������ ���� ������ ������ ��� �� �� ��� ���� ����. ��� �� ����� ����� �������� �� ������, �� ���� ������� ����� ���. �������� �������� �����, ����� ���� ������ �� �������. ���� ���� ����� ��� ������� ������ ������� ���� ������ ��� ����� ���."+"��� ������ ���� ��� ������� ������ ���� ����� ��� ����� �������� ������ ��. �� �� ������ ����� ������ ���������. ������� ����� ������ ������ ����� �������� ���. ������� ������ ����� ���� ������ ������� ������ �� ������ �� ��� ���� ����.   " +"\n"+ " ���� ����! \n ����� ��� ������ ����� ��� �������� ���� ������ ������ ����� ��� �� ����. �� �� ������ ����� ����� �� ������� �� ����� �����.");
					size.setText("100x60x80 �\'\'�");
					length.setText("15-18 �\'\'�");
					weight.setText("43-83 ���");
					price_normal.setText("40-70 �");
					price_yad.setText("80-100 �");
					food.setText("����� ����� ����� ��� ��� ���� ����� ������� ������ �� ���� ���� �����. ������ ����� ����� ���� ������� ����� ������ ����� �� �����, �������, ����� ���, ������ ����� ����. ������ ����� ������ ��� ����� �������� ���� ����� ���� ������ ����, ��� ����� ������� ����� ���, ��� ���� ���� ������ ������. �� ����� ��� ������ ����� ����� �� ������, ���� �������� ������� ����. ���-��, ����� ������ ������ ����� ������ �������� �� �����. �� ���� ������ �� ����� ������� (������ ���� ���� �����), ������� ��� ��� ������� (���� ����� ������, ������ ���� �� ��� ����� ����� �-50% ������ ���� �������). ����� ������ ��� ���: ���, ����, ����, �����, ���� �� ���� ���. ���� ���� �� ������ �� ������ ���� ����� ����� ������ �� ������ ��� ������� ����� ������ �������� �� ��� �����. ���� ��\'�� �� ����� ����� ������� ������� ������ ����." + 
						         "\n �������� ������� : ��� �����, �� ����� ����� ���� ����� ������ ����� ������� �������. ����� ����� ������ ��� ����� ���, ������� ����� �����. �� ������� ������ ����� �� ��������, ��� �� ����� ����� �������� �� ����� ����� �� ����� ������ ����� ������ ��������. ����� �������� ����� ������.");
					life.setText("8-15 ����");
					imageView.setImageResource(R.drawable.im_love);
					imageView.setTag(R.drawable.im_love);
					gridview.setAdapter(new ImageAdapter(this, love));
				}break;
				
				case LORY:{
					title_name.setText("����");
					other.setText("���� ����: ����, ���, ����, ��������, ������, �\'�����, ��������, ��� �����, ��� ���, �����, �����, ���� ����, ��� �����, ���� ����, ������, �����, ������.");
					sizer.setText("����� ����� �: ���� ���");
					description.setText(
							"������� ����� ����� : ���� ��� ���� ������ ������, �� ������ ���� ������ ��� ����� ������ ����. ������ ����� �������� �� ��������� ���� ���� ����� ����� �� �� ���� ������� �����, ���� ���� ������� ���, ��� ����� ��������."+
							"��� ���� ���� ����� ���� ����. ����� ��� ���� ����� ������, ��� ������ ����� ���� ���� ������ ��. �� ����� ����� �� ����� ���� ���� ���� �� �� �� �� ����� ����� �� �� ����� ����� ���� ������ ��� ��'��� �� ����. ���� ������ ����� ���� �� �� �� ����� ���� �����. �� ����� ���� ����� ����� �� ������ ���� ����. ������ ����� ��� ����� ��� ���� �����. ���� ������ ����� ����� ����� ������ �� ��� ����� �������, ����� �� ��� ������, ����� ����� ����� ����� ��� ����� ,����� �������, �� ����� ������ ����� �� ����. ���� ����� ����� ���� ����� ���� ���� ���� ���� ����� ��� ��� ������ ����� �������."
					);
					size.setText("100x60x80 �\'\'�");
					length.setText("24-30 �\'\'�");
					weight.setText("150-250 ���");
					price_normal.setText("700-1000 �");
					price_yad.setText("1000-2000 �");
					food.setText( "�����, ����� ����. ���� ������ ������ ������ ������ ������ ��� ������ ������ ��� ������ ���� ����� ���� �����");
					life.setText("15-20 ���");
					imageView.setImageResource(R.drawable.im_lory);
					imageView.setTag(R.drawable.im_lory);
					gridview.setAdapter(new ImageAdapter(this, lory));
				}break;
				
				default:
					break;
				}
			
				Log.d("��� �����: ", "��� �� ������� �� ���� ������� �������� �����");
				
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
		
		Log.d("��� �����: ", "��� �� ������� �� ����� �� ������");
		
		try{
			t_description.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					initiatePopupWindow(t_description , description);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "�� ������ ������ �� ������ ������", Toast.LENGTH_SHORT).show();
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
			Toast.makeText(c, "�� ������ ������ �� ������ ������", Toast.LENGTH_SHORT).show();
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
			Toast.makeText(c, "�� ������ ������ �� ������� �����", Toast.LENGTH_SHORT).show();
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
			Toast.makeText(c, "�� ������ ������ �� ������ ������ ����", Toast.LENGTH_SHORT).show();
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
			Toast.makeText(c, "�� ������ ������ �� ������ �����", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		try{
			t_price.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String text_prev_price = price_yad.getText().toString(); 
					price_yad.setText(
							"����� ��: " +price_yad.getText().toString() +"\n\n"+
							"����   : " + price_normal.getText().toString() );
					initiatePopupWindow(t_price , price_yad);
					price_yad.setText(text_prev_price);
				}
			});
		}catch(Exception e){
			Toast.makeText(c, "�� ������ ������ �� ������ �����", Toast.LENGTH_SHORT).show();
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
			Toast.makeText(c, "�� ������ ������ �� ������ ����� �����", Toast.LENGTH_SHORT).show();
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
			Toast.makeText(c, "�� ������ ������ �� ������ ���� ����� ������", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		Log.d("��� �����: ", "��� �� ������� �� ����� ����� ������");
		
}
	
	private void initiatePopupWindow(TextView title, TextView text) {
		try {
			
			Log.d("��� �����: ", "����� initiatePopupWindow ������");
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup, null);
			pwindo = new PopupWindow(layout, 600, 750 , true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
			
			Log.d("��� �����: ", "����� initiatePopupWindow ������ ��� ������ �� ����� �inflater");
			
			pop_title = (TextView)layout.findViewById(R.id.pop_title);
			pop_title.setText(title.getText().toString());
			pop_text = (TextView)layout.findViewById(R.id.pop_text);
			pop_text.setText(text.getText().toString());
			Log.d("��� �����: ", "����� initiatePopupWindow ������ ��� ������ ����� ������� ����� ����");
			
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
			i.putExtra(SUBJECT, "���� ���� �� �����");
			i.putExtra(ColorTheme, getIntent().getIntExtra(ColorTheme, 0));
			startActivity(i);
       }
         return true; 
          default:  
            return super.onOptionsItemSelected(item);  
        }
    }
}
