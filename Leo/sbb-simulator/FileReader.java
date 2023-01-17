import java.io.File;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;
import java.util.*;


/**
 * Write a description of class FileReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileReader  
{
    String FILENAME = "highscore.txt";
    /**
     * Constructor for objects of class FileReader
     */
    public FileReader()
    {
    }

    private void createFile(){
        try{
            PrintWriter writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println("0");
            writer.close();
        }catch(Exception e){}
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int readHighscore()
    {
        BufferedReader br = null;
        
        List<String> lines = new ArrayList<String>();
        try{
            InputStream input = getClass().getClassLoader().getResourceAsStream(FILENAME); // open input stream
            br = new BufferedReader(new InputStreamReader(input)); // wrap the stream within a BufferedReader object
        }
        catch (Exception e) { 
            System.out.println("File not found: "+FILENAME); 
            createFile();
            return 0;
        } // for failure to open stream
        // attempt to read in the lines of text
        try{
            String line = null; // sets up a local field for each line of text
            while ((line = br.readLine()) != null)  lines.add(line); // read each line and add them to the 'lines' list
            br.close(); // close the BufferedReader object
        }
        catch (Exception e) {
            try { 
                br.close(); 
            } catch (Exception f) {} 
        } // close file if read error occurred
        
        int score = Integer.parseInt(lines.get(0));
        
        return score;
    }
    
    public void writeHighscore(int score){
        try{
            PrintWriter writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(Integer.toString(score));
            writer.close();
        }catch(Exception e){}
    }
}
