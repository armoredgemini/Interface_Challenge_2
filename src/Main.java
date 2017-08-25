import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ac003588 on 8/23/2017.
 */
public class Main {
    public static void main(String[] args) {
        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        saveObject(werewolf);
        // You can't call werewolf.getStrength, because werewolf is an ISavable
        // You have to instruct Java that werewolf is of a Monster class
        System.out.println("Strength = " + ((Monster) werewolf).getStrength() );

    }

    public static ArrayList readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
    public static void saveObject(ISaveable objectToSave) {
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}
