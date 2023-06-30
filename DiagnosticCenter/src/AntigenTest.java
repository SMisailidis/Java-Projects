
public class AntigenTest extends DiagnosticTest {

	private int exportTime;

	public int getExportTime() {
		return exportTime;
	}

	public void setExportTime(int exportTime) {
		this.exportTime = exportTime;
	}

	public AntigenTest(String firstName, String date, boolean result, String type, int exportTime) {
		
		super(firstName, date, result, type);
		this.exportTime = exportTime;
		
	}
}