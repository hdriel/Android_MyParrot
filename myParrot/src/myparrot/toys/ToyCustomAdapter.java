package myparrot.toys;

import java.util.ArrayList;

import myparrot.vets.ActivityToCallVets;

import com.example.myparrot.ActivityImageToZoom;
import com.example.myparrot.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class ToyCustomAdapter extends ArrayAdapter<ListModelToys>  {
	          
	         
	         
			/*********** Declare Used Variables *********/
	         private Activity activity_toy;
	         private ArrayList<ListModelToys> toyList;
	         private static LayoutInflater inflater=null;
	         private ViewHolder holder;
	         private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";
	         
	         private ListModelToys country;
	         
	         public ToyCustomAdapter(Activity a ,Context context, int textViewResourceId, ArrayList<ListModelToys> toyList) {
	     		   super(context, textViewResourceId, toyList);
	     		   activity_toy = a;
	     		   this.toyList = new ArrayList<ListModelToys>();
	     		   this.toyList.addAll(toyList);
	     		   inflater = 
	  	                (LayoutInflater)activity_toy.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	     		  }
	         
	         private class ViewHolder {
	        	 public TextView title;
	             public TextView descreption;
	             public TextView link;
	             public ImageView image;
	  		  }
	         
	         /****** Depends upon data size called for each row , Create each ListView row *****/
	         public View getView(final int position, View convertView, ViewGroup parent) {
	              
	             holder = null;
	             if (convertView == null) {
	                 /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
	            	 convertView = inflater.inflate(R.layout.list_item_toys, null);
	            	 /****** View Holder Object to contain tabitem.xml file elements ******/
	                 holder 		    = new ViewHolder();
	                 holder.title 		= (TextView) convertView.findViewById(R.id.toy_title);
	                 holder.descreption = (TextView) convertView.findViewById(R.id.toy_descreption);
	                 holder.link	    = (TextView) convertView.findViewById(R.id.toy_link);
	                 holder.image       = (ImageView)convertView.findViewById(R.id.toy_list_image);
	                /************  Set holder with LayoutInflater ************/
	                 convertView.setTag( holder );
	                 
	                 //country = toyList.get(position);
		             holder.title.setText(toyList.get(position).getTitle() );
	                 holder.descreption.setText( toyList.get(position).getDescreption() );
	                 holder.link.setText(toyList.get(position).getUrl() );
	                 holder.link.setTextColor(0xFF0000FF);
	                 holder.image.setImageResource(toyList.get(position).getImage());
	                 
	                 
	                 
	                 /*
	                 holder.descreption.setOnClickListener( new View.OnClickListener() {  
	        		     public void onClick(View v) {  
	        		    	 Toast.makeText(activity_toy, "לחצת על תיאור הפריט", Toast.LENGTH_LONG).show();
	        		     }  
     		    	 });
	                 holder.title.setOnClickListener( new View.OnClickListener() {  
	        		     public void onClick(View v) {  
	        		    	 Toast.makeText(activity_toy, "לחצת על כותרת הפריט", Toast.LENGTH_LONG).show();
	        		     }  
     		    	 });
	                 */
	             }
	             else 
	            	 holder = (ViewHolder) convertView.getTag();
	             
	             if(toyList.size()<=0)
	             {
	                 holder.title.setText("No Data");
	             }
	             else
	             {
	                 /************  Set Model values in Holder elements ***********/
	                  holder.title.setText( toyList.get(position).getTitle() );
	                  holder.descreption.setText( toyList.get(position).getDescreption() );
	                  holder.link.setText( toyList.get(position).getUrl() );
	                  holder.image.setImageResource(toyList.get(position).getImage());
	             }
	             
	             holder.image.setOnClickListener( new View.OnClickListener() {  
        		     public void onClick(View v) {  
        		    	 Intent im = new Intent(activity_toy , ActivityImageToZoom.class);
     					 im.putExtra(IMAGE_ZOOM, toyList.get(position).getImage());
     					 activity_toy.startActivity(im);
        		     }  
 		    	 });
                 holder.link.setOnClickListener( new View.OnClickListener() {  
        		     public void onClick(View v) {  
        		    	 try{
        		    		 Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	     	                 myWebLink.setData(Uri.parse(holder.link.getText().toString()));
	     	                 activity_toy.startActivity(myWebLink);	 
        		    	 }catch(Exception e){
        		    		 e.printStackTrace();
        		    	 }
        		     }  
 		    	 });
	             return convertView;
	         }
	         
	         private int getDrawableId(ImageView iv) {
	     	    return (Integer) iv.getTag();
	     	}
}
