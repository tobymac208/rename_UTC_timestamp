
/**
 * Part of this code snippet is from an answer on a Microsoft forum: https://answers.microsoft.com/en-us/windows/forum/all/how-do-i-remove-the-utc-timestamp-from-files/3fc9b862-07cd-464b-8d92-900222486956?page=4
 * However, I had to modify a decent amount of this code to get it to work.
 */

import java.io.File;

public class Main {
    public static void traverse(File base_dir) {
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
                
                if (oldFile.renameTo(newFile)) {
                    System.out.println("File renamed!");
                } else {
                    if(oldFile.delete()){
                        System.out.println("Copy deleted!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String base_dir = "<your base directory>";

        // Pass in a base director.
        File root = new File(base_dir);
        traverse(root);
    }
}