import java.sql.*;

public class SQLiteConnection {

    private String url;

    public SQLiteConnection(String url){
        this.url = url;
    }

    private String receivedData;

    public boolean makeDMLQuery(String query) {

        Connection conn = null;
        Statement stmt = null;
        int result = 0;

        try {
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:" + this.url);
            conn.setAutoCommit(false);

            stmt = conn.createStatement();

            if(query.contains("SELECT")){
       
                this.receivedData = "";

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    for(int i=1; i<rs.getMetaData().getColumnCount() + 1; i++){
                        result = 1;
                        this.receivedData += (String) rs.getObject(i) + "@";
                    }
                    this.receivedData += "/";
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

    public String getQueryResults(){

        return this.receivedData;
    }

}
