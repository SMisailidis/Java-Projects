import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DiagnosticCenter {

	private ArrayList<DiagnosticTest> tests = new ArrayList<>();
	private ArrayList<MolecularTest> molecular = new ArrayList<>();
	private ArrayList<AntigenTest> antigen = new ArrayList<>();
	
	public ArrayList<MolecularTest> getMolecular() {
		return molecular;
	}

	public void setMolecular(ArrayList<MolecularTest> molecular) {
		this.molecular = molecular;
	}

	public ArrayList<AntigenTest> getAntigen() {
		return antigen;
	}

	public void setAntigen(ArrayList<AntigenTest> antigen) {
		this.antigen = antigen;
	}

	private ArrayList<String> names = new ArrayList<>();
	

	public ArrayList<DiagnosticTest> getTests() {
		return tests;
	}

	public void setTests(ArrayList<DiagnosticTest> tests) {
		this.tests = tests;
	}
	
	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public DiagnosticCenter() {
		
		this.tests = tests;
		this.names = names;
		this.molecular = molecular;
		this.antigen = antigen;
		
		names = addNames(tests, names);
	}
	
	public void addTest(DiagnosticTest test){
		
		tests.add(test);
	}
	
	public ArrayList<String> addNames(ArrayList<DiagnosticTest> test, ArrayList<String> names) {
		
		for(int i=0; i<test.size();i++) {
			names.add(test.get(i).getFirstName());
		}
		
		return names;
	}
	
	public void checkForTest(ArrayList<String> names) {
	
		Collections.sort(names);
		
		try 
		{
	
			File TestedPeople = new File("");
			FileWriter writer = new FileWriter("TestedPeople.txt");
			
			String typeOfTest;
			
			int index=0;
			
			for(String name : names) {
				
				for(int i=0;i<tests.size();i++) {
					
					if(name.equals(tests.get(i).getFirstName())) {
						index = i;
					}
					
				}
				
				if(tests.get(index) instanceof MolecularTest) {
					typeOfTest = "Molecular";
					molecular.add((MolecularTest)tests.get(index));
				}
				else {
					typeOfTest = "Antigen";
					antigen.add((AntigenTest)tests.get(index));
				}
				
				if(name.equals(tests.get(index).getFirstName())) {
					writer.write(name + " has performed a test with the following information: ");
					writer.write(System.lineSeparator());
					
					if(typeOfTest.equals("Molecular")) {
						writer.write(typeOfTest + " Test, date: " + tests.get(index).getDate() + 
								", " + "Result: " + tests.get(index).isResult() +
								", " +  "Type: " + tests.get(index).getType() +
								", " +  "Accuracy: " + molecular.get(molecular.indexOf(tests.get(index))).getAccuracy() + "\n");
					}
					else {
					 
						writer.write(typeOfTest + " Test, date: " + tests.get(index).getDate() + 
								", " + "Result: " + tests.get(index).isResult() +
								", " +  "Type: " + tests.get(index).getType() +
								", " +  "Time: " + antigen.get(antigen.indexOf(tests.get(index))).getExportTime() + "\n");
					}
				}
				else{
					writer.write(name + " has not performed any test");
					writer.write(System.lineSeparator());
				}
				
				writer.write("----------\n");
			}
			
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(names);	
	}

}
