import java.sql.*;
import java.util.ArrayList;

public class SQLiteConnection {

    private ArrayList<String> receivedData = new ArrayList<String>();

    public boolean makeDMLQuery(String query) {

        Connection conn = null;
        Statement stmt = null;
        int result = 0;

        try {
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Windows 10\\Desktop\\Programming\\Projects\\Java-Projects\\BankSimulator\\Cards.db");
            conn.setAutoCommit(false);

            stmt = conn.createStatement();

            if(query.contains("SELECT")){
       
                this.receivedData.clear();

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {

                    for(int i=1; i<rs.getMetaData().getColumnCount() + 1; i++){
                        result = 1;
                        this.receivedData.add((String) rs.getObject(i));
                    }
                }
            }
            else{
                result = stmt.executeUpdate(query);
            }

            stmt.close();
            conn.commit();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(result == 1){
            return true;
        }
        return false;
    }

    public ArrayList<String> getQueryResults(){

        return this.receivedData;
    }

}
