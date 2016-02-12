/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldapp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mantas
 */
public class HelloWorldApp {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
    HelloWorldApp obj = new HelloWorldApp();
    System.out.println(obj.getFile("text.txt"));
}    

private String getFile(String fileName){
    StringBuilder result = new StringBuilder("");
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    
    try (Scanner scanner = new Scanner(file)){
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line).append("/n");
            
        }
        scanner.close();
    }   catch (IOException e){
        e.printStackTrace();
    }
    return result.toString();
}

}