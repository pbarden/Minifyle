/**********************************************************************
*	Program:    Minifyle
* 	Purpose:    Removes white-space from CSS files.
*	Programmer: @pbarden	
*	Created:    01/15/2019
*
***********************************************************************/
package minifyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Minifyle {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the file path: (Press ENTER when done)");
        String name = keyboard.next();

        String line;
        String fileContent = "";      

        try {
            FileReader fileReader = new FileReader(name);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                File outFile =  new File(name.substring(0, name.length()-4) + "-min.css");
                
                try (PrintWriter out = new PrintWriter(outFile)) {
                    System.out.println("File contents: ");
                    while((line = bufferedReader.readLine()) != null) {
                        System.out.print(line.replaceAll("\\s", ""));
                        fileContent += line.replaceAll("\\s", "");
                    }
                    out.print(fileContent);
                }
                catch(IOException e) {
                    System.out.println("File not be created: Permission denied.");
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not in directory.");
        }
        catch(IOException ex) {
            System.out.println("File type not supported.");
        }
        finally {
            System.out.println("\nClosing program...");
        }
    }  
}  
