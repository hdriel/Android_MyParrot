package myparrot.list.food;

import com.example.myparrot.R;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Task {

	private String label , icon_text;
	private int icon , image ;
    private ImageView image_item, icon_item, ok,no, oki;
    
    
	public Task(String label, String ico , int icon, int image) {
		this.label = label;
		this.icon = icon;
		this.image = image;
		this.icon_text = ico;
	}
	
	public Task(String label, String ico , ImageView icon, ImageView image) {
		this.label = label;
		this.icon_item = icon;
		this.image_item = image;
		this.icon_text = ico;
	}
	
	public String getTitle() {
		return label;
	}

	public void setTitle(String label) {
		this.label = label;
	}
	
	public int getIconInt(){
		return icon;
	}
	public int getImageInt(){
		return image;
	}
	public ImageView getIcon(){
		return icon_item;
	}
	public ImageView getImage(){
		return image_item;
	}
	
	public String getIconText() {
        return icon_text;
	}

}
