package com.cookbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.cookbook.core.Recipe;
import com.cookbook.core.RecipeList;
import com.cookbook.core.readFile;

import android.app.Activity;
import android.app.ListActivity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


public class CookbookActivity extends TabActivity {
    @Override	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, MyRecipesActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("recipes").setIndicator("My Recipes",
	                      res.getDrawable(R.drawable.star))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, BookmarkActivity.class);
	    spec = tabHost.newTabSpec("bookmarks").setIndicator("Bookmarks",
	                      res.getDrawable(R.drawable.star))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(1);
	    
	    
	}
	    
}


/*
public class CookbookActivity extends ListActivity {
    
	
	protected TextView textView;
    readFile rd;
    InputStream fos;
    String FILENAME = "./res/raw/recipes";
    Resources myResources;
    RecipeList list;
    
	/** Called when the activity is first created. */
//    @Override
/*	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  myResources = getResources();
	 
*/	
	  /**
	   * Opening the file in the project folder "res/raw/recipes" and generating the input stream
	   */
/*		fos = myResources.openRawResource(R.raw.recipes);
		rd = new readFile();
	  list = rd.read(fos);
		
	*/ 
	  /**
	   * adding the list to the recipeArray used to display it
	   */
/*	  RECIPES = new String[list.size()];
	  for (int i =0; i<list.size();i++){
		  RECIPES[i] = list.getRecipe(i).getName()+"\nType: "+list.getRecipe(i).getType();
	  }
	  
				
	  
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, RECIPES));
	  
	 
	  
	  final ListView lv = getListView();
	  lv.setTextFilterEnabled(true);
	  
	*/  
	  /**
	   * Onclik show the info about the Recipe on a popup message
	   */
/*	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	      // When clicked, show a toast with the TextView text
	      Toast.makeText(getApplicationContext(), 
	    "Ingredients: "+list.getRecipe(position).getIngredients()+"\nPreparation: "+list.getRecipe(position).getPreparation()
	    +"\nType: "+list.getRecipe(position).getType()+"\nRegion: "+list.getRecipe(position).getRegion(),
	          Toast.LENGTH_SHORT).show();
	    	
	    
	    //dididi
	    
	   
	    }
	  });
	}
*/	
	/** need it*/
/*	 String[] RECIPES = new String[]{"lol"};
	
	
	
	
}*/
