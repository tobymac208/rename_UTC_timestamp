
/**
 * Part of this code snippet is from an answer on a Microsoft forum: https://answers.microsoft.com/en-us/windows/forum/all/how-do-i-remove-the-utc-timestamp-from-files/3fc9b862-07cd-464b-8d92-900222486956?page=4
 * However, I had to modify a decent amount of this code to get it to work.
 */

import java.io.File;

public class Main {
    public static void traverse(File file) {
        File[] listOfFiles = null;

        if (file.isDirectory()) {
            listOfFiles = file.listFiles();
        }

        for (File current_file : listOfFiles){
            // Checks if the current file is actually a directory. If so, be recursive
            if (current_file.isDirectory()) {
                traverse(current_file);
            } else {
                String original = current_file.toString();
                System.out.println(original);
                // Removes the timestamp
                String new_name = original.replaceAll(" \\((.*?)\\)", "");
                System.out.println(new_name);
                
                // Instantiating & initializing files
                File oldFile = new File(original);
                File newFile = new File(new_name);
                
                if (oldFile.renameTo(newFile)) {
                    System.out.println("File renamed!");
                } else {
                    System.out.println("Booh!");
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        // String file = "M:\\FileHistory\\ferna\\DESKTOP-3VEGAHM (4)\\Data\\C\\Users\\ferna\\Downloads\\an-example-of-a-healthy-balanced-meal-plan-2506647 (2021_09_18 17_45_57 UTC).pdf";
        // String newFile = "M:\\FileHistory\\ferna\\DESKTOP-3VEGAHM (4)\\Data\\C\\Users\\ferna\\Downloads\\an-example-of-a-healthy-balanced-meal-plan-2506647.pdf";
        
        File file = new File("M:\\FileHistory\\ferna\\DESKTOP-3VEGAHM (4)\\Data\\C\\Users\\ferna\\Downloads\\an-example-of-a-healthy-balanced-meal-plan-2506647 (2021_09_18 17_45_57 UTC).pdf");
        File newFile = new File("M:\\FileHistory\\ferna\\DESKTOP-3VEGAHM (4)\\Data\\C\\Users\\ferna\\Downloads\\an-example-of-a-healthy-balanced-meal-plan-2506647.pdf");

        if(file.renameTo(newFile)) {
            System.out.println("TESTTESTSETETESTSET!@#!@#");
        }

        // File root = new File("M:\\FileHistory\\ferna\\DESKTOP-3VEGAHM (4)\\Data\\C\\Users\\ferna\\Downloads\\");
        // traverse(root);
    }
}