import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
        
	protected ArrayList<String> names = new ArrayList<>();
	protected ArrayList<int[]> stats = new ArrayList<>();
	
	protected String file;    //= "src\\thebludgers\\Tree.csv"; //Τοποθεσία του αρχείου που θέλουμε να αναγνωστεί
    protected String line = ""; //Αποθηκεύει την γραμμή του αρχείου που βρισκόμαστε
        
    public CSVReader(String fName) {
    
    	this.file = fName; 
    	
    	try
    	{
    		BufferedReader read = new BufferedReader(new FileReader(file));
            while((line = read.readLine()) != null)
            {
            	String[] array = line.split(";");
            	int[] stat = new int[6];
            	
            	names.add(array[0]);
            	
            	for(int i=1; i<=6; i++) {
            		stat[i-1] = Integer.parseInt(array[i]);
            	}
            	
            	stats.add(stat);
            }
            read.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The CSV file was not found, please try again");
        }
        catch(IOException e)
        {
            System.out.println("Input or output error occurred, please try again");
        }
    }
}

