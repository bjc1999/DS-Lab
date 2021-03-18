import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Write {
    public static void main(String[] args) {
        String filename = "resources/output.txt";
        String[] data = readUsingBufferedReader("resources/text.txt");
        
        writeUsingFileWriter(filename, data);
        writeUsingBufferedWriter(filename, data);
        writeUsingFileOutputStream(filename, data);
        writeUsingBufferedOutputStream(filename, data);

        testFileReaderWriter("resources/img.jpg", "resources/output-imgChar.jpg");
        testStreamReaderWriter("resources/img.jpg", "resources/output-imgByte.jpg");
    }
    
    public static void writeUsingFileWriter(String filename, String[] data) {
        filename = editFilename(filename, "-FileWriter");
        FileWriter fr = null;
        try {
            fr = new FileWriter(filename);
            long initialTime = System.nanoTime();

            for(String line: data)
                fr.write(line+"\n");

            System.out.println("\n\nTime taken (FileWriter) : "
                + (System.nanoTime() 
                   - initialTime));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeUsingBufferedWriter(String filename, String[] data) {
        filename = editFilename(filename, "-BufferedWriter");
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(filename);
            br = new BufferedWriter(fr, 16384);
            long initialTime = System.nanoTime();

            for(String line: data){
                br.write(line+"\n");
            }

            System.out.println("\n\nTime taken (BufferedWriter) : "
                + (System.nanoTime() 
                   - initialTime));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeUsingFileOutputStream(String filename, String[] data) {
        filename = editFilename(filename, "-FileOutputStream");
        FileOutputStream os = null;
        PrintWriter pw = null;
        try {
            os = new FileOutputStream(filename);
            pw = new PrintWriter(os);
            long initialTime = System.nanoTime();

            for (String line: data)
                pw.write(line+"\n");

            System.out.println("\n\nTime taken (FileOutputStream) : "
                + (System.nanoTime()
                   - initialTime));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                pw.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeUsingBufferedOutputStream(String filename, String[] data) {
        filename = editFilename(filename, "-BufferedOutputStream");
        FileOutputStream os = null;
        BufferedOutputStream bs = null;
        PrintWriter pw = null;
        try {
            os = new FileOutputStream(filename);
            bs = new BufferedOutputStream(os, 27000);
            pw = new PrintWriter(bs);
            long initialTime = System.nanoTime();

            for (String line: data)
                pw.write(line+"\n");
            
            System.out.println("\n\nTime taken (BufferedOutputStream) : "
                + (System.nanoTime()
                   - initialTime));

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                pw.close();
                os.close();
                bs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String editFilename(String filename, String s) {
        int dot = filename.lastIndexOf(".");
        return filename.substring(0, dot) + s + filename.substring(dot);
    }

    public static void testFileReaderWriter(String input, String output) {
        FileReader reader; 
  
        try { 
            reader = new FileReader(input); 
            BufferedReader buffer 
                = new BufferedReader(reader, 16384); 
            
            FileWriter fr = new FileWriter(output);
            BufferedWriter br = new BufferedWriter(fr, 16384);

            int line = 0; 
            while (true) { 
                try { 
  
                    line = buffer.read(); 
                }
                catch (IOException e) {
                    e.printStackTrace(); 
                } 
  
                if (line == -1) 
                    break; 

                br.write(line);
            }
            
            try { 
                buffer.close(); 
                reader.close(); 
                br.close();
                fr.close();
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            }
        }
        catch (IOException e) { 
            e.printStackTrace(); 
        }
    }

    public static void testStreamReaderWriter(String input, String output) {
        FileInputStream reader; 
  
        try { 
            reader = new FileInputStream(input); 
            BufferedInputStream buffer 
                = new BufferedInputStream(reader, 16384); 
            
            FileOutputStream fr = new FileOutputStream(output);
            BufferedOutputStream br = new BufferedOutputStream(fr, 16384);

            int line = 0; 
            while (true) { 
                try { 
  
                    line = buffer.read(); 
                }
                catch (IOException e) {
                    e.printStackTrace(); 
                } 
  
                if (line == -1) 
                    break; 

                br.write(line);
            }
            
            try { 
                buffer.close(); 
                reader.close(); 
                br.close();
                fr.close();
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            }
        }
        catch (IOException e) { 
            e.printStackTrace(); 
        }
    }

    public static String[] readUsingBufferedReader(String filename) {
        String[] data = null;
        String dataStr = "";
        FileReader reader; 
  
        try { 
            reader = new FileReader(filename); 
            BufferedReader buffer 
                = new BufferedReader(reader, 16384); 
            String line = ""; 
            while (true) { 
                try { 
  
                    line = buffer.readLine(); 
                }
                catch (IOException e) {
                    e.printStackTrace(); 
                } 
  
                if (line == null) 
                    break; 
  
                dataStr += line + "\n"; 
            }

            try { 
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

        data = dataStr.split("\n");
        return data;
    }
}