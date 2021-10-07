/* EZFileWrite is a class created to simplify file output in Java. 
 * 
 * 2018 Matthew Phillips */

package FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EZFileWrite{
	// Fields
	private PrintWriter out;
	private String file;
	private ArrayList<String> data;
	private boolean isOpen;
	
	public EZFileWrite(String filename){
		file = filename;
		data = new ArrayList<String>();
		isOpen = false;		
	}
	
	/* Write a line to the file buffer */
	public void writeLine(String line){
		data.add(line);
	}
	
	/* Get size of n */
	public int getNumLines(){
		return data.size();
	}
	
	/* Commit changes to file */
	public void saveFile(){
		if(isOpen)			return;
		openWrite();
		for(int i = 0; i < data.size(); i++)
			writeFileLine(data.get(i));
		close();
	}
	
	/* Helper method...*/
	private void writeFileLine(String line){
		if(!isOpen)			return;
		out.println(line);
	}
	
	/* Helper method...*/
	private void openWrite(){
		try {
			out = new PrintWriter(new FileWriter(file,false));
		} catch (IOException e) {isOpen = false; return;}
		isOpen = true;
	}
	
	/* Closes a file */
	private void close(){
		if(!isOpen)			return;
		out.close();
		isOpen = false;
	}
	
	/* Check to see if a filename exists...*/
    public static boolean doesFileExist(String filename){
    	BufferedReader in2;
    	try{
    		in2 = new BufferedReader(new FileReader(filename));
    	}catch(IOException e){
    		return false;
    	}
    	// Close it
    	try {
			in2.close();
		} catch (IOException e) {}
    	return true;
    }
}