/**
*@author Giulio Muntoni
*@version 1.0
*/
package com.cookbook.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.cookbook.core.Recipe.Season;
import com.cookbook.core.Recipe.TypeOfMeal;

import android.app.Activity;
import android.content.Context;

/**
 * Parse a file from an input stream and generates a list of recipes.
 * @author Giulio
 *
 */
public class readFile  {

	InputStream fos;
	RecipeList list;
	
	
	public readFile(){
		
	}

	/**
	 * Read a file from an InputStream, parse it and generate the RecipeList
	 * @param fos the InputStream
	 * @return the RecipeList reference
	 */
	public RecipeList read(InputStream fos){
		
		this.fos = fos;
		this.list = new RecipeList();
		InputStreamReader input = new InputStreamReader(fos);
		BufferedReader buffreader = new BufferedReader(input);
		int step = 0;
		String line;
		
		String mName = "";
		String mIngredients = "";
		String mPreparation = "";
		int identifier =0;
		TypeOfMeal type= Recipe.TypeOfMeal.MAIN ;
		int cookingTime =0;
		Season season = Recipe.Season.NULL;
		String mRegion = "";
		float mRating =0;
		
		/**
		 * Read every line adding the data to the Recipe class,then add the class to the list
		 */
			try {
				while (( line = buffreader.readLine()) != null) {
					switch (step){
						case 0:
						{
							mName = new String(line);
							step++;
							break;
							
						}
						case 1:
						{
							mIngredients = new String(line);
							step++;
							break;
						}
						case 2:
						{
							mPreparation = new String(line);
							step++;
							break;
						}
						case 3:
						{
							 identifier = Integer.parseInt(line);
							 step++;
							 break;
						}
						case 4:
						{
							 type = Recipe.TypeOfMeal.MAIN;// FAKE! NOT WORKING PRPERLY
							 step++;
							 break;
						}
						case 5:
						{
							 cookingTime = Integer.parseInt(line);
							 step++;
							 break;
						}
						case 6:
						{
							 season = Recipe.Season.SPRING;// FAKE! NOT WORKING PRPERLY
							 step++;
							 break;
						}
						case 7:
						{
							mRegion = new String(line);
							step++;
							break;
						}
						case 8:
						{
							 mRating = Float.parseFloat(line);
							 list.addRecipe(new Recipe(mName,mIngredients,mPreparation,identifier,
				type,cookingTime,season,mRegion,mRating));
							 step++;
							 break;
						}
						case 9:
						{
							
							 step = 0;
							 break;
						}
					}		
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	return this.list;
	
	}
}