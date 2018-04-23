package com.example.myparrot;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myparrot.R;


public class ActivityImageToZoom extends Activity {
    
	private static final String IMAGE_ZOOM = "IMAGE TO ZOOM";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_zoom);
        
        ImageView image = (ImageView) findViewById(R.id.activity_image_zoom);
        
        image.setImageResource(getIntent().getIntExtra(IMAGE_ZOOM, 0));
    }
}