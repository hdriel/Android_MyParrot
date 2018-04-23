package myparrot.list.food;

import java.util.List;


import com.example.myparrot.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListviewAdapterWithFilter extends BaseAdapter implements IFilteredListListener<Task>, IFilterableItem<Task> {

	private Context context;
	private List<Task> list;
	private ListFilter<Task> filter;
	private Boolean filterByTitle;
	
	private TextView label ;

	public ListviewAdapterWithFilter(Context context, List<Task> listContent) {
		this.context = context;
		this.list = listContent;
		this.filterByTitle = true;
		this.filter = new ListFilter<Task>(list, this, this, this);
	}

	// ------------------------
	// --------BaseAdapter
	// ------------------------

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("ViewHolder") //TODO
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.list_item_food, parent, false);
		
		Task task = list.get(position);
		
	    label = (TextView) itemView.findViewById(R.id.label);
		ImageView icon = (ImageView) itemView.findViewById(R.id.icon);
		ImageView image = (ImageView) itemView.findViewById(R.id.images);
		
		label.setText(task.getTitle());
		icon.setImageResource(task.getIconInt());
		image.setImageResource(task.getImageInt());
		
		return itemView;
	}

	public void changeFilterType(Boolean filterByTitle) {
		//We change the criterion for filtering
		this.filterByTitle = filterByTitle;
		//We have to notify filter component that filters has changed
		this.filter.filterTypeChanged();
	}

	@Override
	public Filter getFilter() {
		return filter;
	}

	@Override
	public void onSearchResult(List<Task> objects) {
		list = objects;
	}

	@Override
	public String getStringForFilter(Task item) {
		//This gets the String for filters.
		//Depending on our UI events, business logic etc. it should
		//return the appropriate String to filter for.
		
		if (filterByTitle) {
			return item.getTitle();
		} else {
			return item.getIconText();
		}
	}
	
	
}