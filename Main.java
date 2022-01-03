import java.io.File;

public class Main {
    public static void traverse(File file){
        File[] listOfFiles = null;        

        if(file.isDirectory()){
            listOfFiles = file.listFiles();
        }

        for(int i = 0; listOfFiles != null && i < listOfFiles.length; i++){
            // Checks if the current file is actually a directory. If so, be recursive
            if(listOfFiles[i].isDirectory()) {
                traverse(listOfFiles[i]);
            }else {
                String original = listOfFiles[i].toString();
                System.out.println(original);
                // Removes the timestamp
                String new_name = original.replaceAll(" \\((.*?)\\)", "");
                System.out.println(new_name);

                File oldFile = new File(original);
                File newFile = new File(new_name);

                if(oldFile.renameTo(newFile)){
                    System.out.println("File renamed!");
                }else {
                    System.out.println("The file cannot be renamed.");
                }
            }
        }
    }

    public static void main(String[] args){
        File root = 
        new File("M:\\FileHistory\\ferna\\DESKTOP-3VEGAHM (4)\\Data\\C\\Users\\ferna\\");

        traverse(root);
    }
}