import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class DinnerList {

	private File mealList;
	private ArrayList<String> dinnerList;
	private String meal;
	
	public DinnerList() {
		dinnerList = new ArrayList<String>();
	}
	
	public DinnerList(File mealList) throws FileNotFoundException {
		this.mealList = mealList;
		dinnerList = new ArrayList<String>();
		Scanner fileScan = new Scanner(mealList);
		while(fileScan.hasNextLine()) {
			dinnerList.add(fileScan.nextLine());
		}
		fileScan.close();
	}
	
	public void addMeal(String meal) {
		this.dinnerList.add(meal);
	}
	
	public void removeMeal(int mealIndex) {
		this.dinnerList.remove(mealIndex);
	}
	
	public String getMeal(int mealIndex) {
		this.meal = (String) dinnerList.get(mealIndex);
		return meal;
	}
	
	public int getSize() {
		int size = dinnerList.size();
		return size;
	}
}
