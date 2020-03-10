
package filewriterexample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileWriterExample {

    public static void main(String[] args) throws IOException {
        
        File file = new File("C:\\Users\\HP\\list.txt");
        if(!file.exists()) {
            file.createNewFile();
            System.out.println("File created");
        }
        
        try(FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name");
            String name = scanner.nextLine();
            System.out.println("Enter your age");
            int age = scanner.nextInt();
            System.out.println("Enter your gender");
            String gender = scanner.next();
            
            bufferWriter.write("Name\n");
            bufferWriter.write(name + "\t\t");
            bufferWriter.write(age + "\t\t");
            bufferWriter.write(gender + "\t\t");
            bufferWriter.write(LocalTime.now() + "\t\t");
            bufferWriter.newLine();
        } catch(InputMismatchException ie) {
            System.out.println("Enter a digit");
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
}
