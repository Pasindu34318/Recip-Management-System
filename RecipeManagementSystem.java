import java.util.ArrayList;
import java.util.Scanner;


class Recipe {
    private String title;
    private String ingredients;
    private String steps;

   
    public Recipe(String title, String ingredients, String steps) {
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    
    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Recipe: " + title + "\nIngredients: " + ingredients + "\nSteps: " + steps + "\n";
    }
}


public class RecipeManagementSystem {
    private static ArrayList<Recipe> recipeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nRecipe Management System");
            System.out.println("1. Add Recipe");
            System.out.println("2. View All Recipes");
            System.out.println("3. Search Recipe by Name");
            System.out.println("4. Delete Recipe");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addRecipe();
                    break;
                case 2:
                    viewAllRecipes();
                    break;
                case 3:
                    searchRecipe();
                    break;
                case 4:
                    deleteRecipe();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   
    private static void addRecipe() {
        System.out.print("Enter recipe title: ");
        String title = scanner.nextLine();

        System.out.print("Enter ingredients (comma-separated): ");
        String ingredients = scanner.nextLine();

        System.out.print("Enter preparation steps: ");
        String steps = scanner.nextLine();

        Recipe recipe = new Recipe(title, ingredients, steps);
        recipeList.add(recipe);
        System.out.println("Recipe added successfully!");
    }

   
    private static void viewAllRecipes() {
        if (recipeList.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            for (int i = 0; i < recipeList.size(); i++) {
                System.out.println((i + 1) + ". " + recipeList.get(i));
            }
        }
    }

   
    private static void searchRecipe() {
        System.out.print("Enter recipe name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Recipe recipe : recipeList) {
            if (recipe.getTitle().equalsIgnoreCase(name)) {
                System.out.println(recipe);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Recipe not found.");
        }
    }

   
    private static void deleteRecipe() {
        System.out.print("Enter recipe name to delete: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < recipeList.size(); i++) {
            if (recipeList.get(i).getTitle().equalsIgnoreCase(name)) {
                recipeList.remove(i);
                System.out.println("Recipe deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Recipe not found.");
        }
    }
}