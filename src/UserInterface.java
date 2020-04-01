import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    
    
    /**
     * Displays a welcome message to the user.
     */
    public void welcome() {
        System.out.println("Welcome to the Weather-matic 3000!\n\n");
        
        System.out.println("This application will provide you weather forecasts"
                + " for multiple locations, \rfrom multiple weather services.\n");
        
        System.out.println("You can maintain a 'Location List' of your favorite places "
                + "and get a single \rweather forecast report for all your locations in one report.\n");

    }
    
    /**
     * Prompts the user to select if they would like to use an existing 'Location List',
     * create a new list, or edit an existing list.
     * 
     * While Loop used to continue prompting until a valid response it provided.
     */
    public void selection() {
        System.out.println("\nDo you have an existing 'Location List' you would like to use? "
                + "\rIf not we can build a new one! You may also edit an existing Location List.\n");
        System.out.print("If you have an existing Location List, type 'Y'.  "
                + "\rOtherwise, enter 'N' for New or 'E' to Edit: ");
        
        scan = new Scanner(System.in);
        String initSelection = scan.next();
        
        int validCheck = 0; // Variable used to continue looping until valid response received.
        
        while (validCheck == 0) {
            if (initSelection.toLowerCase().equals("y")) {
                System.out.println("Selected 'Y'");
                validCheck = 1; // switched to '1' to exit while loop
                
                // GO TO: use existing Location List method
                
            } else if (initSelection.toLowerCase().equals("n")) {
                System.out.println("Selected 'N' for New");
                validCheck = 1; // switched to '1' to exit while loop
                
                // GO TO: create new Location List method

            } else if (initSelection.toLowerCase().equals("e")) {
                System.out.println("Selected 'E' for Edit");
                validCheck = 1; // switched to '1' to exit while loop
                
                // GO TO: edit existing Location List method

            } else {
                
                /*
                 * If a valid response is not received, the value of 'validCheck' 
                 * remains 0, and the While Loop continues to loop until a 
                 * valid response is received 
                 */
                System.out.println("\nThat is not a valid selection. Please try again!!");
                System.out.print("Enter 'Y' to use existing 'Location List', 'N' to create a new list, or 'E' to edit your list: ");
                initSelection = scan.next();
            }
        }
    }
    
    /**
     * Method to handle when user input is to use an existing Location List
     */
    public void useExistingList() {
        
    }
    
    /**
     * Method to handle when user input is to create a new Location List
     */
    public void createNewList() {
        
    }
    
    /**
     * Method to handle when user input is to edit an existing Location List
     */
    public void editList() {
        
    }
    
    /**
     * Method looks into Working Directory for files with .txt or .json
     * files. Print a numbered list of the those files. 
     * And creates a HashMap of the files. 
     * <p>
     * Key = number in list <br>
     * Value = filename
     * @return HashMap with numbered filenames
     */
    public HashMap<Integer, String> filesInDir() {
        Path currentPath = Paths.get(""); // obtains the Working Directory
        String s = currentPath.toAbsolutePath().toString(); // converts Working Directory to string
        System.out.println("Within the location <" + s + ">, "
                + "\nthe following potential 'Location List' files were found: ");

        File f = new File(s); // Instantiates the File class 
        String[] fileNames = f.list(); // .list method provides a full list of files at passed location
        
        // Creating HashMap to hold the filenames that match extensions
        HashMap<Integer, String> fileList = new HashMap<Integer, String>();
                
        int num = 1; // Used to create numbered list and the Key for HashMap
        for (int i = 0; i < fileNames.length; i++) {
            String file = fileNames[i];
            
            // Checks each file name to see if it contains the extensions
            if (file.contains(".txt") || file.contains(".json")) {
                System.out.println("   " + num + ". " + file); // prints a numbered list
                fileList.put(num, file); // add filename to HashMap
                num++;
            }
        }
        return fileList;

    }
    
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
//        ui.welcome();
//        ui.selection();
        
        ui.filesInDir();
        
        
    }

}
