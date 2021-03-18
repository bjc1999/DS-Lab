import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) throws Exception {
        String filename = "resources/test.txt";
        readUsingFileReader(filename);
        System.out.println("\n\n");
        readUsingBufferedReader(filename);
        System.out.println("\n\n");
        readUsingFileInputStream(filename);
        System.out.println("\n\n");
        readUsingBufferedInputStream(filename);
    }

    public static void readUsingFileReader(String filename) {
        System.out.println("Read using FileReader\n");
        FileReader reader; 
  
        try {
  
            reader = new FileReader(filename); 
  
            char ch; 
  
            // An integer to store the integer 
            // returned by FileReader#read() method 
            int i = -1; 
  
            // Stores the initial current time 
            long initialTime = System.currentTimeMillis();
            while (true) {
                try {
                    // The read() method of FileReader 
                    // reads one character at a time 
                    // and returns it as an integer 
                    i = reader.read(); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
  
                // When the "End Of File" is reached 
                // the read() method returns -1 
                if (i == -1) 
                    break; 
  
                ch = (char)i; 
                System.out.print(ch);
            } 
  
            // Display and print the time taken 
            System.out.println("\n\nTime taken : "
                               + (System.currentTimeMillis() 
                                  - initialTime)); 
  
            try { 
                reader.close(); 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
        catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } 
    }

    public static void readUsingBufferedReader(String filename) {
        System.out.println("Read using BufferedReader\n");
        FileReader reader; 
  
        try { 
  
            reader = new FileReader(filename); 
  
            // Creating a BufferedReader object (instance) 
            //  that 16Kb in buffer in the memory 
            BufferedReader buffer 
                = new BufferedReader(reader, 16384); 
  
            // Custom input 
            // A string to store the lines 
            String line = ""; 
  
            // Maintaing real time count using 
            // currentTimeMillis() method to get time taken 
            // to read the data 
            long initialTime = System.currentTimeMillis(); 
            while (true) { 
  
                // Try block to check exceptions 
                try { 
  
                    // readLine() method of BufferedReader 
                    // returns 
                    //  a whole line at a time 
                    line = buffer.readLine(); 
                }
                catch (IOException e) {
                    e.printStackTrace(); 
                } 
  
                // When the read head reaches the "End Of 
                // File" the readLine method returns null 
                if (line == null) 
                    break; 
  
                // Prints the line 
                System.out.println(line); 
            } 
  
            // Display the time taken to read the data 
            System.out.println("\nTime taken : "
                               + (System.currentTimeMillis() 
                                  - initialTime)); 

            try { 
                // Close all the streams 
                buffer.close(); 
                reader.close(); 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            }
        }
        catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        }
    }

    public static void readUsingFileInputStream(String filename) {
        System.out.println("Read using FileInputStream\n");
        FileInputStream inputStream; 
  
        try {
  
            inputStream = new FileInputStream(filename); 
  
            char ch; 
  
            // An integer to store the integer 
            // returned by FileReader#read() method 
            int i = -1; 
  
            // Stores the initial current time 
            long initialTime = System.currentTimeMillis();
            while (true) {
                try {
                    // The read() method of FileReader 
                    // reads one character at a time 
                    // and returns it as an integer 
                    i = inputStream.read(); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
  
                // When the "End Of File" is reached 
                // the read() method returns -1 
                if (i == -1) 
                    break; 
  
                ch = (char)i; 
                System.out.print(ch);
            } 
  
            // Display and print the time taken 
            System.out.println("\n\nTime taken : "
                               + (System.currentTimeMillis() 
                                  - initialTime)); 
  
            try { 
                inputStream.close(); 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
        catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        }
    }

    public static void readUsingBufferedInputStream(String filename) {
        System.out.println("Read using BufferedInputStream\n");
        FileInputStream inputStream;
        Scanner scanner;
  
        try { 
  
            inputStream = new FileInputStream(filename);
  
            // Custom input 
            // A string to store the lines 
            String line = ""; 

            // Creating a BufferedReader object (instance) 
            //  that 16Kb in buffer in the memory 
            BufferedInputStream buffer 
                = new BufferedInputStream(inputStream, 16384); 
  
            scanner = new Scanner(buffer);

            // Maintaing real time count using 
            // currentTimeMillis() method to get time taken 
            // to read the data 
            long initialTime = System.currentTimeMillis(); 
            while (scanner.hasNextLine()) { 
  
                // readLine() method of BufferedReader 
                // returns 
                //  a whole line at a time 
                line = scanner.nextLine();
  
                // Prints the line 
                System.out.println(line); 
            } 
  
            // Display the time taken to read the data 
            System.out.println("\nTime taken : "
                               + (System.currentTimeMillis() 
                                  - initialTime)); 

            try { 
                // Close all the streams 
                buffer.close(); 
                inputStream.close();
                scanner.close();
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            }
        }
        catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        }
    }
}
