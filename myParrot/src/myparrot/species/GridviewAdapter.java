package myparrot.species;


import com.example.myparrot.R;
import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter
{
	private ArrayList<String> listParrot;
	private ArrayList<Integer> listIconParrot;
	private Activity activity;
	
	public GridviewAdapter(Activity activity,ArrayList<String> listParrot, ArrayList<Integer> listIconParrot) {
		super();
		this.listParrot = listParrot;
		this.listIconParrot = listIconParrot;
		this.activity = activity;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listParrot.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return listParrot.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder
	{
		public ImageView imgViewFlag;
		public TextView txtViewTitle;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflator = activity.getLayoutInflater();
		
		if(convertView==null)
		{
			view = new ViewHolder();
			convertView = inflator.inflate(R.layout.species_grid_row, null);
			
			view.txtViewTitle = (TextView) convertView.findViewById(R.id.species_grid_text);
			view.imgViewFlag = (ImageView) convertView.findViewById(R.id.species_grid_image);
			
			convertView.setTag(view);
		}
		else
		{
			view = (ViewHolder) convertView.getTag();
		}
		
		view.txtViewTitle.setText(listParrot.get(position));
		view.imgViewFlag.setImageResource(listIconParrot.get(position));
		
		return convertView;
	}

}
