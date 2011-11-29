/**
*@author Giulio Muntoni
*@version 1.0
*/

package com.cookbook.core;

import java.util.Vector;


/** 
 * Class representing a list of Recipes classes
 * @author Giulio
 *
 */
public class RecipeList {

	/** 
	 * The Vector storing the references to Recipes instances 
	 * */
	protected Vector<Recipe> list;
	
	/**
	 * Constructor
	 */
	public RecipeList(){
		list = new Vector<Recipe>();
	}
	
	public void addRecipe(Recipe recipe){
		list.add(recipe);
	}
	
	/**
	 * Removes the instance of Recipe from the list
	 * @deprecated We should overload this function with other kind of input as recipe name,index etc
	 * @param recipe
	 */
	public void removeRecipe(Recipe recipe){
		list.remove(recipe);
	}
	/**
	 * Removes all elements putting the size of the vector at 0
	 */
	public void clearList(){
		list.removeAllElements();
	}
	
	/**
	 * TO-DO
	 */
	public void mergeList(){
	
	}
	
	public Recipe getRecipe(int index){
		return list.get(index);
	}
	
	/**
	 * Find if the list contains the same instance of recipes, it doesn't check
	 * if the two classes have the same values
	 * @param recipe
	 * @return
	 */
	public boolean contains(Recipe recipe){
		return list.contains(recipe);
	}
	
	/**
	 * TO-DO
	 */
	public void orderAlphabetical(){
	
	}
	
	public int size(){
		return list.size();
	}
	
	
	
}
