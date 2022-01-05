
/**
 * Author: Nik Fernandez
 * Part of this code snippet is from an answer on a Microsoft forum: https://answers.microsoft.com/en-us/windows/forum/all/how-do-i-remove-the-utc-timestamp-from-files/3fc9b862-07cd-464b-8d92-900222486956?page=4
 * It was a nice gesture. 
 * However, the code:
 *                    - Woudln't even compile.
 *                    - Was very inefficient.
 *                    - Would only work for one UTC timestamp.
 */

import java.io.File;

public class Main {
    public static void traverse(File base_dir) {
        // First and new subdirectory location.
        System.out.println(base_dir);

        // Create array of current files in this directory. Traverse if not a file.
        for (File current_file : base_dir.listFiles()){
            // Checks if the current file is actually a directory. If so, be recursive
            if (current_file.isDirectory()) {
                traverse(current_file);
            } else {
                String original = current_file.getName();
                // Removes the timestamp
                String new_name = original.replaceAll(" \\((.*?)\\)", "");
                // Instantiating & initializing files
                File oldFile = new File(base_dir + File.separator + original);
                File newFile = new File(base_dir + File.separator + new_name);

                // Make sure the filename is different! Avoids redundant re-runs. //
                if(original.equals(new_name)) System.out.println("Already changed.");
                else if (oldFile.renameTo(newFile)) System.out.println("File renamed!");
                // If none of that, delete the copy of the file
                else {
                    if(oldFile.delete()) System.out.println("Copy deleted!");
                }
            }
        }
    }

    public static void main(String[] args) {
        /** Example base_dir: "D:\\FileHistory\\ferna\\DESKTOP-3VEGAHM\\Data\\C\\Users\\ferna\\" */
        String base_dir = "<your base directory";
	
        // Pass in a base director.
        File root = new File(base_dir);
	if(!root.exists())
	    System.out.println("Needs to be a valid directory.");
	else
            traverse(root);
    }
}
