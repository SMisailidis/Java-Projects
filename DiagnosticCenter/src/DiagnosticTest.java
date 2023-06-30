
public abstract class DiagnosticTest {

	private String firstName;
	private String date;
	private boolean result;
	private String type;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DiagnosticTest(String firstName, String date, boolean result, String type) {
	
		this.firstName = firstName;
		this.date = date;
		this.result = result;
		this.type = type;
	}
	
	
	
}
