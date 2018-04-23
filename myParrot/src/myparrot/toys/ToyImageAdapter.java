package myparrot.toys;

import com.example.myparrot.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ToyImageAdapter extends BaseAdapter {
	 
	private Context mContext;

	    private Integer[] mImageIds = {
	    		R.drawable.toy_home1,
	            R.drawable.toy_home2,
	            R.drawable.toy_home3,
	            R.drawable.toy_home4,
	            R.drawable.toy_home5,
	            R.drawable.toy_home6,
	            R.drawable.toy_home7,
	            R.drawable.toy_home8,
	            R.drawable.toy_home9,
	            R.drawable.toy_home10
	    };
	    
	public ToyImageAdapter(Context context) 
	    {
	        mContext = context;
	    }

	    public int getCount() {
	        return mImageIds.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }


	    // Override this method according to your need
	    public View getView(int index, View view, ViewGroup viewGroup) 
	    {
	        // TODO Auto-generated method stub
	        ImageView i = new ImageView(mContext);

	        i.setImageResource(mImageIds[index]);
	        i.setLayoutParams(new Gallery.LayoutParams(300, 300));
	    
	        i.setScaleType(ImageView.ScaleType.FIT_XY);

	        return i;
	    }
	    
	    
	}