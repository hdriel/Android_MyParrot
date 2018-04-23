package myparrot.diseases;

import com.example.myparrot.R;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandListAdapter extends BaseExpandableListAdapter {

	private Context context;
    private ArrayList<Parent> parents;

    public ExpandListAdapter(Context context, ArrayList<Parent> parents) {
        this.context = context;
        this.parents = parents;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Child> chList = parents.get(groupPosition).getItems();
        return chList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {

        Child child = (Child) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = 
            (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.diseases_child_item, null);
        }
        
        TextView t_copy = (TextView) convertView.findViewById(R.id.dis_copy);
        TextView t_siptoms = (TextView) convertView.findViewById(R.id.dis_siptoms);
        TextView t_descraption = (TextView) convertView.findViewById(R.id.dis_descreption);
        
        
        t_copy.setText(child.getCopy());
        t_siptoms.setText(child.getSimptom());
        t_descraption.setText(child.getDescreption());
        
        
        
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<Child> chList = parents.get(groupPosition).getItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parents.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return parents.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
    	
    	Parent  group = (Parent) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = 
            (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.dis_parent_item, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.diseas_name);
        tv.setText(group.getName());
        
        
        
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}

