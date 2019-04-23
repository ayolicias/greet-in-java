package net.greet.jdbc_test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static java.lang.Class.forName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class greetedJdbcTest {

    final String GREET_DATABASE_URL = "jdbc:h2:./target/greet_db";

    public Connection getConnection() throws Exception {

        Connection conn = DriverManager.getConnection( GREET_DATABASE_URL, "sa", "");
        return conn;
    }

    @BeforeEach

    public void cleanUpTables() {

        try {
            try (Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "")) {
                // delete NAMES that the tests are adding

                Statement statement = conn.createStatement();
//                statement.addBatch("delete from users where name in ('ZEE','AYA','YASH')");
//                statement.executeBatch();

            }
        }
        catch(Exception ex) {
            System.out.println("These test will fail until the users table is created: " + ex);
        }
    }


    @Test
    public void loadJdbcClass() {

        try {

            Class.forName("org.h2.Driver");
        }
        catch (ClassNotFoundException e) {
            fail(e);
        }
    }

    @Test
    public void connectToDatabase() {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(GREET_DATABASE_URL, "sa", ""));
        }
        catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void ExecuteDataInDataBase() {
        try {
//            forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(GREET_DATABASE_URL, "sa", ""));
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from  users");
        }
        catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void insertUsers() {
        try {
//            forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(GREET_DATABASE_URL, "sa", ""));
            final String INSERT_USERS_SQL = "insert into users(user_name, greet_counter)values (?, ?)";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select user_name from users");

            if (rs.next()){
                //Add rows in the tables
                assertEquals( 3, rs.getInt( "user_name"));
            }



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
        }

        catch (Exception e) {
            fail (e);
        }

    }

    @Test

    public void findGreetedUsers(){

        try {
            Connection conn = getConnection();
            final String FIND_COUNTER_SQL = "select *greet_counter from users where user_name = ZEE";
            PreparedStatement findcounter = conn.prepareStatement(FIND_COUNTER_SQL);
            findcounter.setInt( 1,4);

            ResultSet rs = findcounter.executeQuery();

            int greetCounter = 0;

            while (rs.next());



        }

        catch (Exception e){
            fail(e);
        }
    }
}
