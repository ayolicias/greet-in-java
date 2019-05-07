package net.greet.jdbc_test;
import net.greet.GreetedUser;
import net.greet.JdbcGreeted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.sql.*;

import static java.lang.Class.forName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class greetedJdbcTest {

    final String GREET_DATABASE_URL = "jdbc:h2:./target/greetings_db";
    private String FIND_COUNTER_SQL;

    public Connection getConnection( ) throws Exception {

        Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
        return conn;
    }

    @BeforeEach
    public void cleanUpTables( ) {
        try {
            try (Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "")) {
                // delete NAMES that the tests are adding

                conn.createStatement().execute("delete from users where user_name in ('ZEE','YASH')");
            }
        } catch (Exception ex) {
            System.out.println("These test will fail until the users table is created: " + ex);
        }
    }

    @Test
    public void loadJdbcclass( ) {

        try {

            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            fail(e);
        }
    }

    @Test
    public void connectToDatabase( ) {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(GREET_DATABASE_URL, "sa", ""));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void ExecuteSQLStatement( ) {
        try {
            Connection conn = (DriverManager.getConnection(GREET_DATABASE_URL, "sa", ""));
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from  users");
        } catch (Exception e) {
            fail(e);
        }

    }
    @Test
    public void insertUsers( ) throws Exception {
        try {
            Connection conn = (DriverManager.getConnection(GREET_DATABASE_URL, "sa", ""));
            final String INSERT_USERS_SQL = "insert into users(user_name, greet_counter) values (?,?)";
            Statement statement = conn.createStatement();

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

            ResultSet rs = statement.executeQuery("select * from users where user_name = 'AYA'");

            if (rs.next()) {
                assertEquals("AYA", rs.getString("user_name"));
                assertEquals(1, rs.getInt("greet_counter"));
            }
        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void findGreetedUsers( ) throws Exception {
        Connection conn = getConnection();

        try {
            String FIND_COUNTER_SQL = "select * from users";
            PreparedStatement findcounter = conn.prepareStatement(FIND_COUNTER_SQL);

            ResultSet rs = findcounter.executeQuery();

            int greetCounter = 1;
            while (rs.next()) {


                if (greetCounter == 6) {

                    assertEquals(1, rs.getInt("greet_counter"));

                } else if (greetCounter == 2) {
                    assertEquals(1, rs.getInt("greet_counter"));
                }
            }

        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void updateUsers( ) throws Exception {

        try {
            Connection conn = getConnection();
            FIND_COUNTER_SQL = "select * from users";
            final String UPDATE_USERS_NAME_GREET_COUNT = "update users set greet_counter = greet_counter where user_name = ?";

            PreparedStatement updateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
            PreparedStatement findCounter = conn.prepareStatement(FIND_COUNTER_SQL);

            updateCounter.setString(1, "YASH");
            updateCounter.executeUpdate();


            ResultSet rs = findCounter.executeQuery();

            if (rs.next()) {
                assertEquals(1, rs.getInt("greet_counter"));

            } else {
                System.out.println("Should find the user_name in the database");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test

    public void greetedUser( ) throws Exception {

        try {
            Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
            ResultSet rs;

            final String INSERT_USERS_SQL = "insert into users(user_name, greet_counter) values (?,?)";
            PreparedStatement insertName = conn.prepareStatement(INSERT_USERS_SQL);


            insertName.setString(1, "YASH");
            insertName.setInt(2, 1);
            insertName.execute();

            PreparedStatement ps = conn.prepareStatement("select * from users where user_name = ?");

            ps.setString(1, "YASH");
            rs = ps.executeQuery();

            if (rs.next()) {
                assertEquals("YASH", rs.getString("user_name"));
                assertEquals(1, rs.getInt("greet_counter"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void remove( ) throws SQLException {
        try {
            try(Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "")) {
                ResultSet rs;
                // clear greeted names in database!!!
                Statement statement = conn.createStatement();
                statement.addBatch("delete from users where user_name in ('YASH', 'ZEE')");
                statement.executeBatch();

                PreparedStatement ps = conn.prepareStatement("select * from users where user_name = ?");


                ps.setString(1,"{YASH}");
                rs = ps.executeQuery();

                assertEquals("YASH", rs.getString("user_name"));
                assertEquals(1,rs.getInt("greet_counter"));
            }
        } catch(Exception ex) {
            System.out.println("These test will fail until the users table is created: " + ex);
        }
    }

    @Test
    public void reset(){
        try{
            try(Connection conn = DriverManager.getConnection(GREET_DATABASE_URL,"sa", "")){
                ResultSet rs;
                //Reset greeted names in a database
                Statement statement = conn.createStatement();
                conn.createStatement().execute("delete from users where user_name in ('ZEE','YASH')");

                assertEquals("{}","{}",("user_name"));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void help()throws Exception{

        try {
            Connection conn = DriverManager.getConnection(GREET_DATABASE_URL,"sa","");
            Statement statement = conn.createStatement();

            System.out.println("Should Display the information about the App");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    }




