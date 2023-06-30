
public class MolecularTest extends DiagnosticTest {

	private double accuracy;
	
	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public MolecularTest(String firstName, String date, boolean result, String type, double accuracy) {
		
		super(firstName, date, result, type);
		this.accuracy = accuracy;
		
	}
}
