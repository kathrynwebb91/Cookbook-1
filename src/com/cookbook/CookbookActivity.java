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
import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;



public class CookbookActivity extends ListActivity {
    
	
	protected TextView textView;
    readFile rd;
    InputStream fos;
    String FILENAME = "./res/raw/recipes";
    Resources myResources;
    static final RecipeList list = new RecipeList();
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  myResources = getResources();
	 
	

		fos = myResources.openRawResource(R.raw.recipes);
	  
		rd = new readFile(fos,list);
	  rd.read();
		
	 /* list.addRecipe(new Recipe("pizza","flour, tomato","bake everything", 1,Recipe.TypeOfMeal.MAIN,30,
			  Recipe.Season.SPRING,"Italia",5f));
	  list.addRecipe(new Recipe("hamburger","bread, meat","bake everything", 1,Recipe.TypeOfMeal.DESSERT,30,
			  Recipe.Season.NULL,"Usa",5f));
	  list.addRecipe(new Recipe("kebab","bread, lupus","bake everything", 1,Recipe.TypeOfMeal.SECOND,10,
			  Recipe.Season.NULL,"turkey",4f));*/
	  
	  RECIPES = new String[] {list.getRecipe(0).getName()+"\nType: "+list.getRecipe(0).getType(),
				list.getRecipe(1).getName()+"\nType: "+list.getRecipe(1).getType(),list.getRecipe(2).getName()+ "\nType: "+list.getRecipe(2).getType()};
	  
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, RECIPES));
	  
	 
	  
	  final ListView lv = getListView();
	  lv.setTextFilterEnabled(true);
	  
	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	      // When clicked, show a toast with the TextView text
	      Toast.makeText(getApplicationContext(), 
	    "Ingredients: "+list.getRecipe(position).getIngredients()+"\nPreparation: "+list.getRecipe(position).getPreparation()
	    +"\nType: "+list.getRecipe(position).getType(),
	          Toast.LENGTH_SHORT).show();
	    	
	    
	    
	    
	   
	    }
	  });
	}
	
	
	 String[] RECIPES = new String[]{"lol"};
	
	
	
	
}
