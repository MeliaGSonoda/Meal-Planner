
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class WeeklyDinner {

	public static void main(String[] args) {
		
		final File MEAL_LIST = new File("Meals.txt");  //contains a list of possible meals
		ArrayList<String> weeklyMeals = new ArrayList<String>();  //holds randomly selected meals
		int numMeals;  //number of requested meals
		int allMeals;  //size of DinnerList (same as number of means in meals.txt)
		DinnerList dinner;  
		Scanner scan = new Scanner(System.in);
		
		try {
			//create an ArrayList of all meal possibilities from meals.txt
			dinner = new DinnerList(MEAL_LIST);
			for(int i = 0; i < dinner.getSize(); i++){
				System.out.println("(" + i + ") " + dinner.getMeal(i));
			}
			//ask user how many meals they need for the week
			Random rand = new Random();
			System.out.print("How many meals would you like? ");
			numMeals = scan.nextInt();
			
			//get the size of the DinnerList for use with random
			allMeals = dinner.getSize();
			
			for (int i = 0; i < numMeals; i++) {
				int mealIndex = rand.nextInt(allMeals);
				weeklyMeals.add(dinner.getMeal(mealIndex));
				System.out.println(weeklyMeals.get(i));
				dinner.removeMeal(i);  //remove the meal from the ArrayList so it can't be used again
				allMeals--;  //decrease the "size" of the ArrayList
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File not found.");
		}
		scan.close();
	}
}
