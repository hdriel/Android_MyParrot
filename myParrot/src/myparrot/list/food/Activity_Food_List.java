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
		
		final String x = "��� ��!!\n\n."+"����� X - �� ���� �� ������ ����� ������ ������ ��� ������ �� �� �����, ��� �� �� �� ������ ����� ���� ������� ���� (�� ������� �����) �� ��� ������ ��� ���!\n\n"+"����� ������� - ���� ����� ���� �������� ����� �� �� ������ ��� , �� ��� ���� ���� ����� �� ����� ���� ����� ����� �����  ������� ������";
		final String tree = "�� ���� �� ������� ���� ����� ����� , ��� �� ������� ��!";
		
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
				ret.add(new Task("�� ������",         "no",R.drawable.no ,R.drawable.b4 ));
				ret.add(new Task("�� ����� - ����",         "no",R.drawable.no ,R.drawable.b31 ));
				ret.add(new Task("���� ����� (�� ����)",         "no",R.drawable.no ,R.drawable.b12 ));
				ret.add(new Task("�� ���� - ������� �������",         "no",R.drawable.no ,R.drawable.b20 ));
				ret.add(new Task("������������ ��������",         "no",R.drawable.no ,R.drawable.b50 ));
				ret.add(new Task("�� ����� - ��� ���",         "no",R.drawable.no ,R.drawable.b69 ));
				ret.add(new Task("�� ����",         "no",R.drawable.no ,R.drawable.b92 ));
				ret.add(new Task("�� ����",         "no",R.drawable.no ,R.drawable.b90 ));
				ret.add(new Task("�� ���",         "no",R.drawable.no ,R.drawable.b83 ));
				ret.add(new Task("�� ����",         "no",R.drawable.noi ,R.drawable.b77 ));
	    		ret.add(new Task("�� �����, �������",         "no",R.drawable.noi ,R.drawable.b78 ));
	    		ret.add(new Task("�� ����",         "no",R.drawable.noi ,R.drawable.b79 ));
	    		ret.add(new Task("�� ����",         "no",R.drawable.no ,R.drawable.b80 ));
	    		ret.add(new Task("�� ����� ������� �� ������",         "no",R.drawable.noi ,R.drawable.b81 ));
	    		ret.add(new Task("�� ��� ,���� ���, �����",			"ok",R.drawable.poison ,R.drawable.a32 ));
	    		
				ret.add(new Task("�������",			"ok",R.drawable.ok ,R.drawable.a14 ));
				ret.add(new Task("���� ���",			"ok",R.drawable.ok ,R.drawable.a22 ));
				ret.add(new Task("�� ����",			"ok",R.drawable.ok ,R.drawable.a24 ));
				ret.add(new Task("����� ��������",			"ok",R.drawable.ok ,R.drawable.a27 ));
				ret.add(new Task("�����",        "ok",R.drawable.ok ,R.drawable.a9 ));
				ret.add(new Task("��������",			"ok",R.drawable.oki ,R.drawable.a36 ));
				ret.add(new Task("�� ����",			"ok",R.drawable.ok ,R.drawable.a40 ));
				ret.add(new Task("�� ��� ������ , ��� ������",			"ok",R.drawable.oki ,R.drawable.a75 ));
				
				
				
	    		
				return ret;
			}
			if(r){
				ret = new ArrayList<Task>();
			}
			if(i < 0){
				ret.add(new Task("�����",          "no",R.drawable.no ,R.drawable.b1 ));
	    		ret.add(new Task("������",         "no",R.drawable.poisoni ,R.drawable.b2 ));
	    		ret.add(new Task("������",         "no",R.drawable.no ,R.drawable.b3 ));
	    		ret.add(new Task("�� ������",         "no",R.drawable.no ,R.drawable.b4 ));
	    		ret.add(new Task("����� �� ���",          "no",R.drawable.no ,R.drawable.b5 ));
	    		ret.add(new Task("����",         "no",R.drawable.noi ,R.drawable.b6 ));
	    		ret.add(new Task("����� ������",         "no",R.drawable.no ,R.drawable.b7 ));
	    		ret.add(new Task("������ �����",         "no",R.drawable.no ,R.drawable.b8 ));
	    		ret.add(new Task("���",          "no",R.drawable.no ,R.drawable.b9 ));
	    		ret.add(new Task("������� �������",         "no",R.drawable.no ,R.drawable.b10 ));
	    		ret.add(new Task("����� (�� ������)",         "no",R.drawable.no ,R.drawable.b11 ));
	    		ret.add(new Task("���� ����� (�� ����)",         "no",R.drawable.no ,R.drawable.b12 ));
	    		ret.add(new Task("�������� ����",          "no",R.drawable.no ,R.drawable.b13 ));
	    		ret.add(new Task("����� ������ / ������",         "no",R.drawable.no ,R.drawable.b14 ));
	    		ret.add(new Task("��������",         "no",R.drawable.poison ,R.drawable.b15 ));
	    		ret.add(new Task("����� �������",         "no",R.drawable.no ,R.drawable.b16 ));
	    		ret.add(new Task("���� ������",          "no",R.drawable.no ,R.drawable.b17 ));
	    		ret.add(new Task("������������� ������",         "no",R.drawable.no ,R.drawable.b18 ));
	    		ret.add(new Task("����������� �����",         "no",R.drawable.no ,R.drawable.b19 ));
	    		ret.add(new Task("�� ���� ������� �������",         "no",R.drawable.no ,R.drawable.b20 ));
	    		ret.add(new Task("��������� ������",          "no",R.drawable.no ,R.drawable.b21 ));
	    		ret.add(new Task("��� ��������",         "no",R.drawable.no ,R.drawable.b22 ));
	    		ret.add(new Task("����������� ������",         "no",R.drawable.no ,R.drawable.b23 ));
	    		ret.add(new Task("����������������� �������",         "no",R.drawable.no ,R.drawable.b24 ));
	    		ret.add(new Task("������� �������",          "no",R.drawable.noi ,R.drawable.b25 ));
	    		ret.add(new Task("��� ����",         "no",R.drawable.no ,R.drawable.b26 ));
	    		ret.add(new Task("���",         "no",R.drawable.no ,R.drawable.b27 ));
	    		ret.add(new Task("����������� �����",         "no",R.drawable.no ,R.drawable.b28 ));
	    		ret.add(new Task("���",         "no",R.drawable.poisoni ,R.drawable.b30 ));
	    		ret.add(new Task("�� ����� - ����",         "no",R.drawable.noi ,R.drawable.b31 ));
	    		ret.add(new Task("���������",         "no",R.drawable.noi ,R.drawable.b32 ));
	    		ret.add(new Task("���� ���� ��",         "no",R.drawable.poison ,R.drawable.b33 ));
	    		ret.add(new Task("������",         "no",R.drawable.poisoni ,R.drawable.b34 ));
	    		ret.add(new Task("�������� ������",         "no",R.drawable.noi ,R.drawable.b35 ));
	    		ret.add(new Task("���������� �������",         "no",R.drawable.no ,R.drawable.b36 ));
	    		ret.add(new Task("�������� ��������",         "no",R.drawable.no ,R.drawable.b37 ));
	    		ret.add(new Task("������",         "no",R.drawable.noi ,R.drawable.b38 ));
	    		ret.add(new Task("������ ������",         "no",R.drawable.no ,R.drawable.b39 ));
	    		ret.add(new Task("�������� �������",         "no",R.drawable.no ,R.drawable.b40 ));
	    		ret.add(new Task("��������",         "no",R.drawable.no ,R.drawable.b41 ));
	    		ret.add(new Task("������� �����",         "no",R.drawable.no ,R.drawable.b42 ));
	    		ret.add(new Task("������ �����",         "no",R.drawable.no ,R.drawable.b43 ));
	    		ret.add(new Task("�����",         "no",R.drawable.no ,R.drawable.b44 ));
	    		ret.add(new Task("����� �������",         "no",R.drawable.no ,R.drawable.b45 ));
	    		ret.add(new Task("������ �����",         "no",R.drawable.no ,R.drawable.b46 ));
	    		ret.add(new Task("������� ��-�����",         "no",R.drawable.no ,R.drawable.b47 ));
	    		ret.add(new Task("��� ����",         "no",R.drawable.no ,R.drawable.b48 ));
	    		ret.add(new Task("������ ����/������ �����",         "no",R.drawable.poisoni ,R.drawable.b49 ));
	    		ret.add(new Task("������������ ��������",         "no",R.drawable.no ,R.drawable.b50 ));
	    		ret.add(new Task("������ / ����� ������",         "no",R.drawable.noi ,R.drawable.b51 ));
	    		ret.add(new Task("����� ������ ������� (���� , ������ , �������)",         "no",R.drawable.no ,R.drawable.b52 ));
	    		ret.add(new Task("���� ����� � ������� ������� ������",         "no",R.drawable.noi ,R.drawable.b53 ));
	    		ret.add(new Task("������ ������ ������",         "no",R.drawable.poisoni ,R.drawable.b54 ));
	    		ret.add(new Task("������",         "no",R.drawable.noi ,R.drawable.b55 ));
	    		ret.add(new Task("���",         "no",R.drawable.poisoni ,R.drawable.b56 ));
	    		ret.add(new Task("���",         "no",R.drawable.poisoni ,R.drawable.b57 ));
	    		ret.add(new Task("������",         "no",R.drawable.no ,R.drawable.b58 ));
	    		ret.add(new Task("���� - ����� ���",         "no",R.drawable.noi ,R.drawable.b59 ));
	    		ret.add(new Task("�������",         "no",R.drawable.noi ,R.drawable.b60 ));
	    		ret.add(new Task("���� ����� / �����",         "no",R.drawable.noi ,R.drawable.b61 ));
	    		ret.add(new Task("������� - ���� �����",         "no",R.drawable.poisoni ,R.drawable.b62 ));
	    		ret.add(new Task("���� ���",         "no",R.drawable.no ,R.drawable.b63 ));
	    		ret.add(new Task("����� �����",         "no",R.drawable.noi ,R.drawable.b64 ));
	    		ret.add(new Task("�����",         "no",R.drawable.no ,R.drawable.b65 ));
	    		ret.add(new Task("����",         "no",R.drawable.noi ,R.drawable.b66 ));
	    		ret.add(new Task("������ ������� - �������� / ������ / ������ / �����",  "no",R.drawable.no ,R.drawable.b67 ));
	    		ret.add(new Task("�����",         "no",R.drawable.noi ,R.drawable.b68 ));
	    		ret.add(new Task("�� ����� - ��� ���",         "no",R.drawable.noi ,R.drawable.b69 ));
	    		ret.add(new Task("����� ������ (���� ���)",         "no",R.drawable.noi ,R.drawable.b70 ));
	    		ret.add(new Task("�������",         "no",R.drawable.no ,R.drawable.b71 ));
	    		ret.add(new Task("����",         "no",R.drawable.poison ,R.drawable.b72 ));
	    		ret.add(new Task("������ - ���� / ����� / ����� / ������� ��\'\'�",         "no",R.drawable.noi ,R.drawable.b73 ));
	    		ret.add(new Task("���",         "no",R.drawable.no ,R.drawable.b74 ));
	    		ret.add(new Task("�������",         "no",R.drawable.noi ,R.drawable.b75 ));
	    		ret.add(new Task("��� ��",         "no",R.drawable.poisoni ,R.drawable.b76 ));
	    		ret.add(new Task("�� ����",         "no",R.drawable.poisoni ,R.drawable.b77 ));
	    		ret.add(new Task("�� �����, �������",         "no",R.drawable.poisoni ,R.drawable.b78 ));
	    		ret.add(new Task("�� ����",         "no",R.drawable.noi ,R.drawable.b79 ));
	    		ret.add(new Task("�� ����",         "no",R.drawable.no ,R.drawable.b80 ));
	    		ret.add(new Task("�� ����� ������� �� ������",         "no",R.drawable.noi ,R.drawable.b81 ));
	    		ret.add(new Task("�� ���� � ������",         "no",R.drawable.no ,R.drawable.b82 ));
	    		ret.add(new Task("�� ���",         "no",R.drawable.no ,R.drawable.b83 ));
	    		ret.add(new Task("���� ��",         "no",R.drawable.no ,R.drawable.b84 ));
	    		ret.add(new Task("��� ���",         "no",R.drawable.no ,R.drawable.b85 ));
	    		ret.add(new Task("���",         "no",R.drawable.no ,R.drawable.b86 ));
	    		ret.add(new Task("����",         "no",R.drawable.noi ,R.drawable.b87 ));
	    		ret.add(new Task("�����",         "no",R.drawable.noi ,R.drawable.b88 ));
	    		ret.add(new Task("���� �����",         "no",R.drawable.no ,R.drawable.b89 ));
	    		ret.add(new Task("�� ����",         "no",R.drawable.no ,R.drawable.b90 ));
	    		ret.add(new Task("�����",         "no",R.drawable.no ,R.drawable.b91 ));
	    		ret.add(new Task("�� ����",         "no",R.drawable.poison ,R.drawable.b92 ));
	    		ret.add(new Task("����",         "no",R.drawable.no ,R.drawable.b93 ));
	    		ret.add(new Task("�������",         "no",R.drawable.no ,R.drawable.b94 ));
	    		ret.add(new Task("������",         "no",R.drawable.no ,R.drawable.b95 ));
	    		ret.add(new Task("������� ������",         "no",R.drawable.noi ,R.drawable.b96 ));
	    		ret.add(new Task("����",         "no",R.drawable.no ,R.drawable.b97 ));
	    		ret.add(new Task("�����",         "no",R.drawable.no ,R.drawable.b98 ));
	    		ret.add(new Task("������",         "no",R.drawable.noi ,R.drawable.b99 ));
	    		ret.add(new Task("����� �����",         "no",R.drawable.noi ,R.drawable.b100 ));
	    		ret.add(new Task("�� ��� ,���� ���, �����",			"ok",R.drawable.poison ,R.drawable.a32 ));
	    		ret.add(new Task("������ �� ������ ��� ������!",			"ok",R.drawable.noi ,R.drawable.a46 ));
	    		
			}
			else if(i > 0 ){
				ret.add(new Task("������� �����",   "ok",R.drawable.ok ,R.drawable.a1 ));
	    		ret.add(new Task("����",         "ok",R.drawable.oki ,R.drawable.a2 ));
	    		ret.add(new Task("�������",       "ok",R.drawable.ok ,R.drawable.a3 ));
	    		ret.add(new Task("���",         "ok",R.drawable.ok ,R.drawable.a4 ));
	    		ret.add(new Task("�������",      "ok",R.drawable.ok ,R.drawable.a5 ));
	    		ret.add(new Task("������ ����� ����","ok",R.drawable.ok ,R.drawable.a6 ));
	    		ret.add(new Task("���� �����",   	"ok",R.drawable.ok ,R.drawable.a7 ));
	    		ret.add(new Task("����� �������", "ok",R.drawable.ok ,R.drawable.a8 ));
	    		ret.add(new Task("�����",        "ok",R.drawable.ok ,R.drawable.a9 ));
	    		ret.add(new Task("������� �����",  "ok",R.drawable.ok ,R.drawable.a10 ));
	    		ret.add(new Task("������",        "ok",R.drawable.ok ,R.drawable.a11 ));
	    		ret.add(new Task("���",			"ok",R.drawable.ok ,R.drawable.a12 ));
	    		ret.add(new Task("���",			"ok",R.drawable.ok ,R.drawable.a13 ));
	    		ret.add(new Task("�������",			"ok",R.drawable.oki ,R.drawable.a14 ));
	    		ret.add(new Task("����� ����",			"ok",R.drawable.ok ,R.drawable.a15 ));
	    		ret.add(new Task("��� ���������(�����)",	"ok",R.drawable.ok ,R.drawable.a16 ));
	    		ret.add(new Task("������",			"ok",R.drawable.oki ,R.drawable.a17 ));
	    		ret.add(new Task("����",			    "ok",R.drawable.ok ,R.drawable.a18 ));
	    		ret.add(new Task("���� ���",			"ok",R.drawable.ok ,R.drawable.a19 ));
	    		ret.add(new Task("�������",			"ok",R.drawable.ok ,R.drawable.a20 ));
	    		ret.add(new Task("����� �������",		"ok",R.drawable.ok ,R.drawable.a21 ));
	    		ret.add(new Task("���� ���",			"ok",R.drawable.ok ,R.drawable.a22 ));
	    		ret.add(new Task("������ ��������",		 "ok",R.drawable.ok ,R.drawable.a23 ));
	    		ret.add(new Task("�� ����",			"ok",R.drawable.ok ,R.drawable.a24 ));
	    		ret.add(new Task("��������",			"ok",R.drawable.ok ,R.drawable.a25 ));
	    		ret.add(new Task("����� ��������",			"ok",R.drawable.ok ,R.drawable.a26 ));
	    		ret.add(new Task("����� ��������",			"ok",R.drawable.ok ,R.drawable.a27 ));
	    		ret.add(new Task("���� ������",			"ok",R.drawable.ok ,R.drawable.a28 ));
	    		ret.add(new Task("���������",			"ok",R.drawable.ok ,R.drawable.a29 ));
	    		ret.add(new Task("���� - ��� �����",			"ok",R.drawable.oki ,R.drawable.a30 ));
	    		ret.add(new Task("�������",			"ok",R.drawable.ok ,R.drawable.a31 ));
	    		ret.add(new Task("����� �������",			"ok",R.drawable.ok ,R.drawable.a33 ));
	    		ret.add(new Task("������",			"ok",R.drawable.ok ,R.drawable.a34 ));
	    		ret.add(new Task("����� �������",			"ok",R.drawable.ok ,R.drawable.a35 ));
	    		ret.add(new Task("��������",			"ok",R.drawable.oki ,R.drawable.a36 ));
	    		ret.add(new Task("���� ��",			"ok",R.drawable.oki ,R.drawable.a37 ));
	    		ret.add(new Task("����� ��������",			"ok",R.drawable.ok ,R.drawable.a38 ));
	    		ret.add(new Task("����",			"ok",R.drawable.oki ,R.drawable.a39 ));
	    		ret.add(new Task("�� ����",			"ok",R.drawable.ok ,R.drawable.a40 ));
	    		ret.add(new Task("�������",			"ok",R.drawable.oki ,R.drawable.a41 ));
	    		ret.add(new Task("��� ����",			"ok",R.drawable.oki ,R.drawable.a42 ));
	    		ret.add(new Task("������",			"ok",R.drawable.ok ,R.drawable.a43 ));
	    		ret.add(new Task("������ (��� �����) ������! �� ������ ��� ������!",			"ok",R.drawable.oki ,R.drawable.a44 ));
	    		ret.add(new Task("����� �� ������ ��� ������!",			"ok",R.drawable.oki ,R.drawable.a45 ));
	    		ret.add(new Task("������� �� ������ ��� ������!",			"ok",R.drawable.oki ,R.drawable.a47 ));
	    		ret.add(new Task("�����",			"ok",R.drawable.oki ,R.drawable.a48 ));
	    		ret.add(new Task("����",			"ok",R.drawable.ok ,R.drawable.a49 ));
	    		ret.add(new Task("�����",			"ok",R.drawable.ok ,R.drawable.a50 ));
	    		ret.add(new Task("���",			"ok",R.drawable.ok ,R.drawable.a51 ));
	    		ret.add(new Task("����",			"ok",R.drawable.oki ,R.drawable.a52 ));
	    		ret.add(new Task("��������",			"ok",R.drawable.ok ,R.drawable.a53 ));
	    		ret.add(new Task("���",			"ok",R.drawable.ok ,R.drawable.a54 ));
	    		ret.add(new Task("������",			"ok",R.drawable.ok ,R.drawable.a55 ));
	    		ret.add(new Task("����� (��� �������)",			"ok",R.drawable.oki ,R.drawable.a56 ));
	    		ret.add(new Task("����",			"ok",R.drawable.ok ,R.drawable.a57 ));
	    		ret.add(new Task("��� ���",			"ok",R.drawable.oki ,R.drawable.a58 ));
	    		ret.add(new Task("���� (����� ��� �������)",			"ok",R.drawable.ok ,R.drawable.a59 ));
	    		ret.add(new Task("��� (����� ��� �������)",			"ok",R.drawable.ok ,R.drawable.a60 ));
	    		ret.add(new Task("���� ������ (��� ����� �� ������)",			"ok",R.drawable.oki ,R.drawable.a61 ));
	    		ret.add(new Task("���� ���� ���",			"ok",R.drawable.oki ,R.drawable.a62 ));
	    		ret.add(new Task("���",			"ok",R.drawable.ok ,R.drawable.a63 ));
	    		ret.add(new Task("���� ����� ���� ��� ���� �� ��������",			"ok",R.drawable.oki ,R.drawable.a64 ));
	    		ret.add(new Task("��� �����",			"ok",R.drawable.ok ,R.drawable.a65 ));
	    		ret.add(new Task("�������",			"ok",R.drawable.ok ,R.drawable.a66 ));
	    		ret.add(new Task("����",			"ok",R.drawable.ok ,R.drawable.a67 ));
	    		ret.add(new Task("����",			"ok",R.drawable.ok ,R.drawable.a68 ));
	    		ret.add(new Task("����� (��� ������!)",			"ok",R.drawable.ok ,R.drawable.a69 ));
	    		ret.add(new Task("����� ���� �����",			"ok",R.drawable.ok ,R.drawable.a70 ));
	    		ret.add(new Task("����",			"ok",R.drawable.oki ,R.drawable.a71 ));
	    		ret.add(new Task("������",			"ok",R.drawable.ok ,R.drawable.a72 ));
	    		ret.add(new Task("���",			"ok",R.drawable.ok ,R.drawable.a73 ));
	    		ret.add(new Task("(-��� �� ������)��� ��� �� �����",	"ok",R.drawable.oki ,R.drawable.a74 ));
	    		ret.add(new Task("�� ��� ������ , ��� ������",			"ok",R.drawable.oki ,R.drawable.a75 ));
	    		ret.add(new Task("����",			"ok",R.drawable.ok ,R.drawable.a76 ));
	    		ret.add(new Task("�� ����",			"ok",R.drawable.ok ,R.drawable.a77 ));
	    		ret.add(new Task("��� ��� (�����, ���� ����, �������, ����)",		"ok",R.drawable.ok ,R.drawable.a78 ));
	    		ret.add(new Task("�� ���",			"ok",R.drawable.ok ,R.drawable.a79 ));
	    		ret.add(new Task("��� , �����",			"ok",R.drawable.ok ,R.drawable.a80 ));
	    		ret.add(new Task("�� ����",			"ok",R.drawable.ok ,R.drawable.a81 ));
	    		ret.add(new Task("������",			"ok",R.drawable.ok ,R.drawable.a82 ));
	    		ret.add(new Task("�� ���",			"ok",R.drawable.ok ,R.drawable.a83 ));
	    		ret.add(new Task("�� ��� (���)",			"ok",R.drawable.ok ,R.drawable.a84 ));
	    		ret.add(new Task("�� �����",			"ok",R.drawable.ok ,R.drawable.a85 ));
	    		ret.add(new Task("�����",			"ok",R.drawable.ok ,R.drawable.a86 ));
	    		ret.add(new Task("�� ���",			"ok",R.drawable.ok ,R.drawable.a87 ));
	    		ret.add(new Task("���� �����",			"ok",R.drawable.oki ,R.drawable.a88 ));
	    		ret.add(new Task("��������",			"ok",R.drawable.ok ,R.drawable.a89 ));
	    		ret.add(new Task("���� ����  - ���� ��� ����!",			"ok",R.drawable.ok ,R.drawable.a90 ));
	    		ret.add(new Task("������ ���� - ���� ��� ����!",			"ok",R.drawable.ok ,R.drawable.a91 ));
	    		ret.add(new Task("������ - ���� ��� ����!",			"ok",R.drawable.ok ,R.drawable.a92 ));
	    		ret.add(new Task("����� �������",          "no",R.drawable.ok ,R.drawable.a93 ));
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
			case "������":
				t = "����� ������ ����� ����� ����� ������ ���, �� ���� ���� ������ ����� ���� ���� ���� ����-�����.\n" +
						"�������, ����� ����� �������� ���� ����, ����, ����� �������!! \n"+
						"������� ����� ��� ��� ������ ������ ���� ��� ����� ����� (������ ���� ��� ������ ����). 	����� ���� ����� ������ ������� ������ ���, ������ ������� ���� 12 ���� �������, ���� ��� 1-2 ����. \n"+
						"������ ����� ����� �� ����� ������ �� ����� ����� �� �������. �� �� �� ������ ���� ���� ����� ������ ������ ������ ���� ������� �� ���";
				Toast.makeText(context, t, Toast.LENGTH_SHORT).show();
				break;
			case "������� �������":
				t = "���� ���� ����� ������ . ���� �� ���� ���� ������ ������ ���� ������ ������, ��� ���� ���� ������� ��� ���� �� ��� ����� ���� ���� ����� ��. ���� ��� ������ ����, ����-���� ������� ������ (��� ���� ����: �����, ������, �����, ���) ��� ���� ������� ����� ��� ������ �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� ����� - ����":
				t = "��� ���� ���� , ���� ���� ��� ��������!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���������":
				t = "�� ������ ����� ��� �� �� ��� ����� ��� ������, ��� ������ ��� ����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������":
				t = "���� ���� ����� ������ . ���� �� ���� ���� ������ ������ ���� ������ ������, ��� ���� ���� ������� ��� ���� �� ��� ����� ���� ���� ����� ��. ���� ��� ������ ����, ����-���� ������� ������ (��� ���� ����: �����, ������, �����, ���) ��� ���� ������� ����� ��� ������ �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����":
				t = "���� ���� ����� ������ . ���� �� ���� ���� ������ ������ ���� ������ ������, ��� ���� ���� ������� ��� ���� �� ��� ����� ���� ���� ����� ��. ���� ��� ������ ����, ����-���� ������� ������ (��� ���� ����: �����, ������, �����, ���) ��� ���� ������� ����� ��� ������ �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�������� ������":
				t = "���� ��� ���� ����� ���� ���� ��� , �� ����� �� ������ ������ ����� ����!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������ / ����� ������":
				t = "���� ������ ������� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� ����� � ������� ������� ������":
				t = "���� ��� ����� �������� �������! ��� ���� �� �� ���� ������.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������ ������ ������":
				t = "����� ������ ����� ��� ��������� ������ ������� ��. ������� ���� �� ��� �� ��� ���� ����� ���� (����) ���� ���� ����� ����. ���� ����� ������ ����, ���� ���, ����� ���.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� - ����� ���":
				t = "����-����� �� ������ ���� �����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�������":
				t = "�� ����� ��� ��� ��������!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� ����� / �����":
				t = "���� ��� ������ ������� �� ������ �������, ����� �� ������ ���� �� �� ��� ���� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����� �����":
				t = "������ ����� ���� ����� ������ ���� ����� �����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����":
				t = "�� ������ ����� ��� ������ �����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�����":
				t = "�� ���� ��� ����� �����, ���� ���� ����� ������.\n"+
						"���� �� ���� ������ �� ���� ���� ����.\n"+
						"������� - ���� ��� ����� - ��! \n";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� ����� - ��� ���":
				t = "���� ��� �� ����� �� �� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�������":
				t = "���� ����� ���� ����, �������� �� ���� ����� ��\'���";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������":
				t = "������ ����� ���� ������� ���� �� ����� ��� ����� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����":
				t = "����� ������, ���� ���� ����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� - ��� �����":
				t = "���� �� ���� ����� �� �� ��������, �� ����� �� �������� �� ���� �� ���� ���� �� ��� ����!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� ��":
				t = "�� ������ ����� ���� ���!\n �� ����� ����!";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����":
				t = "���� ����� ���� ����� �� ���� ������ �� ����� (���� ��� ����� ������ ��� - ��� ����)";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������� - ���� �����":
				t = "���� �� ����� ���� ����� ����� ������. ��������� �� ������, ����� ������ ������ ���� ����� ������� ���� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������":
				t = "������ �� ��� ����� ����� ����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "��� ����":
				t = "��� ������ �������� ����� ��� ����� ��� ��� ����� ��� ���� ������ �����, �������� ���� �����, ���� ������ ��� ������� ������� ���. ��� �� - ����� �� �����. ������ ������ �� �� ����, ����� ���� - ���� ���� ����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����� ������ (���� ���)":
				t = "����� ������ ������ ����� ����� ������� ������� ���� ������ �� �����. ������ ��� ���� �� ����� ���.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������ (��� �����) ������! �� ������ ��� ������!":
				t = "������ ����� ���� ������� ���� �� ����� ��� ����� ������, ������ ������ ��� ���� ��� ����, ���� ��� �� ����� ����� �� ����� ���� ����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����� �� ������ ��� ������!":
				t = "������ ����� ���� ������� ���� �� ����� ��� ����� ������, ������ ������ ��� ��� ��� ����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������ �� ������ ��� ������!":
				t = "���� ������ (����� �� ������ ���� �� ������ ������) ������� ����� ����� �����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������� �� ������ ��� ������!":
				t = "������ ����� ���� ������� ���� �� ����� ��� ����� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�������":
				t = "������ ���� ����� �� ��� �����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;	
			case "�����":
				t = "������, ��� ������, ���� ���� ����� �� ���� ����� ����� ����� ������� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����":
				t = "���� �� �� ��� ����� ����� �� ����� �� �� �����, ���� ����� ����� ���� ������ ������ �� ����� ������.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����� (��� �������)":
				t = "����� ������, ���� ���� ����, ���� �� ����� �������� �������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "��� ���":
				t = "���� �� �� ����� ���� ������ ������ ���, �� �� ���� ����� ���� ���.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� ������ (��� ����� �� ������)":
				t = "";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� ����� ���� ��� ���� �� ��������":
				t = "���� ��� ���� - �� �� ��� �� �������� ����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����":
				t = "����� ������, ���� ���� ����";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���":
				t = "���� �� ��� ��� ������� ������ ������ ������ ����� �� ���� ������, ��� ����� ����������.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���":
				t = "���� ���������� �� �����. ���� �����, ������� ����� ����� ��� ������ ����� ���� ������ �� ��� ���.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���":
				t = "������ ����������� ������� ����� ������ �� ��� ������ ��� �� ����� ������ ����� �������.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� ����":
				t = "�����, ���� ������ ������, ���� ���� �� ���� ��� �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� �����, �������":
				t = "�����, ���� ������ ������, ���� ���� �� ���� ��� �����." +"\n"+
						"���� �� ��� \'\'��� �����\'\' �� ���� ������ ������, ����: �����, ����, �������, ����, ��������. �� ������ ���� ������ ������ ��� �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� ����":
				t = "�����, ���� ������ ������, ���� ���� �� ���� ��� �����."+"\n"+
						"���� �� ��� \'\'��� �����\'\' �� ���� ������ ������, ����: �����, ����, �������, ����, ��������. �� ������ ���� ������ ������ ��� �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� ����� ������� �� ������":
				t = "������ �� ������, ����� ��� ���� ������. ���� ���� ������� ������.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� ���":
				t = "��� ����� ���� ������ ����� ������ ������ ��� ����� ��������, ��� �� ������ �����." +
					"���� ���� ���� ��� ��� ����," +
					" ���� �� ����� �����. �� ��� ���� ���� (�� ��), ��� ������, ������� ���� ����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "��� ��":
				t = "������ ������ ����� �����, ���� ��� ���� �����. ������ ����� ������ ����� ������ �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����":
				t = "����, ���� �� �������. ���� ����� ������ �������, �� ����� ������� ������� ������.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�����":
				t = "������, ���� ���' - ���� ��� \'\'��\'\'', ��� �� ����� �� �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������ ����/������ �����":
				t = "������: ����� ���� ��, ���������, ���� ���, ����, ���, �����, �����, ��������, ���, �����, ��������, ������, ���.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�������":
				t = "������: ���� ���, ������, ����� ���, �����, ����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "������":
				t = "���� ����� ���� ���� ���, �� ����� �� ������� �������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "����� �����":
				t = "���� ����� ���� ���� ���, �� ����� �� ������� �������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "�� ��� ������ , ��� ������":
				t = "����: ��\'\'� ������� " +
					"���� ������ ����� �� �����, ��� ��� ���� ����� ����� ��� ���� ��� �����, ������ �����. �� ����" +
					" ������� ����(�� ������) ������ ������ ������ ��� ���� �� ����� (����� ����� �� ������ ���� ������� �� ���� �����). " +
					"*�����: ���� ������ ������ ��� �� ���� ������ ��� �����, ���� ���� ���� ������� �� �� ���� ����� �� ����." +
					" ���� ����� ������, ������ ������ ��� ��� ���� �����.";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "��������":
				t = "�� ����� �� ������ ��� �����, ���� ����� ��������� �� ������ ������ (���� �� �������). �� ������ �� ����� ���. ���� ����: ��� �������� ��� ����� ����� ��� ����� (���� ��� ������ ����).";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "���� �����":
				t = "��� ��� ��� ����� ������ ������, ���� ���� ������";
				Toast.makeText(context, t, Toast.LENGTH_LONG).show();
				break;
			case "(-��� �� ������)��� ��� �� �����":
				t = "���� ���� ���� ����� ����� , ���� ��� ���� �� �����/�������";
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
				i.putExtra(SUBJECT, "����� ����� ������");
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

