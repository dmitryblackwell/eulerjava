import java.sql.*;

public class ConnectionToDatabase {
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION="description";
    // Connect to Database

    public ConnectionToDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/com/blackwell/data/ProblemsInfo.db");
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Database connected.");
    }
    public String getCell(String columnName,int id) {
        try {
            String sql = "SELECT * FROM problems WHERE id = "+id;
            resultSet= statement.executeQuery(sql);
            return  resultSet.getString(columnName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void closeDB() {
        try {
            conn.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Connection closed.");
    }
}
