package net.greet.jdbc_test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class greetedJdbcTest {

    final String DATABASE_URL = "jdbc:h2:./target/greetings_java";

    @BeforeEach
    public void cleanUpTables() {

        try {
            try (Connection conn = DriverManager.getConnection(DATABASE_URL, "sa", "")) {
                // delete NAMES that the tests are adding

                Statement statement = conn.createStatement();
//                statement.addBatch("delete from users where name in ('ZEE','AYA','YASH')");
//                statement.executeBatch();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void loadJdbcclass() {

        try {

            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectToDatabase() {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(DATABASE_URL, "sa", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ExecuteDataInDataBase() {
        try {
            Connection conn = (DriverManager.getConnection(DATABASE_URL, "sa", ""));
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from  greetedUsers");
        } catch (Exception e) {
            System.out.println("Select users from databaseUsers");
        }

    }

    @Test
    public void insertIntDb() {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(DATABASE_URL, "sa", ""));
            final String INSERT_USERS_SQL = "insert into users(userName, greet_Counter)values (?, ?)";

            PreparedStatement insertName;
            insertName = conn.prepareStatement(INSERT_USERS_SQL);
            insertName.setString(1, "ZEE");
            insertName.setInt(2, 1);
            insertName.execute();

            insertName.setString(1, "AYA");
            insertName.setInt(2, 1);
            insertName.execute();

            insertName.setString(1, "YASH");
            insertName.setInt(2, 1);
            insertName.execute();


        } catch (ClassNotFoundException e) {
            fail( e );
        }


    }
}
