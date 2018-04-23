package myparrot.toys;

import android.widget.ImageView;

public class ListModelToys {
    
    private  String Title="";
    private  String Descreption="";
	private  int Image;
    private  String Url="";
     
    public ListModelToys(String Title, String Descreption, int Image , String Url) {
		// TODO Auto-generated constructor stub
    	this.Title = Title;
    	this.Descreption = Descreption;
    	this.Image = Image;
    	this.Url = Url;
	}
    
    public ListModelToys() {
		// TODO Auto-generated constructor stub
	}
    
    /*********** Set Methods ******************/
     
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    
    public void setDescreption(String descreption) {
		Descreption = descreption;
	} 
    
    public void setImage(int Image1)
    {
        this.Image = Image;
    }
     
    public void setUrl(String Url)
    {
        this.Url = Url;
    }
     
    /*********** Get Methods ****************/
     
    public String getTitle()
    {
        return this.Title;
    }
    
    public String getDescreption() {
		return Descreption;
	}
    
    public int getImage()
    {
        return this.Image;
    }
 
    public String getUrl()
    {
        return this.Url;
    }    
}
