package net.greet.jdbc_test;
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

    public Connection getConnection() throws Exception {

        Connection conn = DriverManager.getConnection( GREET_DATABASE_URL, "sa", "");
        return conn;
    }

    /*
     * insert new user
     * update user count
     * find user by name
     * delete user by name
     * delete all users
     * find all users
     * */

    @BeforeEach
    public void cleanUpTables() {
        try {
            try (Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "")) {
                // delete NAMES that the tests are adding

                Statement statement = conn.createStatement();
                statement.addBatch("delete from users where user_name in ('ZEE','YASH')");
                statement.executeBatch();

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
    public void ExecuteSQLStatement() {
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
    public void insertUsers()throws Exception {
        try {
//            forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(GREET_DATABASE_URL, "sa", ""));
            final String INSERT_USERS_SQL = "insert into users(user_name, greet_counter) values (?,?)";
            Statement statement = conn.createStatement();

            PreparedStatement insertName;
            insertName = conn.prepareStatement(INSERT_USERS_SQL);

            insertName.setString(1,"ZEE");
            insertName.setInt(2, 1);
            insertName.execute();

            insertName.setString(1, "AYA");
            insertName.setInt(2, 1);
            insertName.execute();

            insertName.setString(1, "YASH");
            insertName.setInt(2, 1);
            insertName.execute();

            ResultSet rs = statement.executeQuery("select * from users");

            if (rs.next()){
                //Add rows in the tables
//                assertEquals( "AYA", rs.getString(userName));
                assertEquals(1, rs.getInt( "greet_counter"));
            }
        }

        catch (Exception e) {
            fail (e);
        }

    }

    @Test
    public void findGreetedUsers()throws Exception {

        try {
            Connection conn = getConnection();
            String FIND_COUNTER_SQL = "select * from users";
            PreparedStatement findcounter = conn.prepareStatement(FIND_COUNTER_SQL);

//            findcounter.setInt(1, 3);

            ResultSet rs = findcounter.executeQuery();

            int greetCounter = 1;
//            System.out.println(rs.getString("user_name"));
            while (rs.next()) {


                if (greetCounter == 6) {

//                    assertEquals("AYA", rs.getString("user_name"));
                    assertEquals(1, rs.getInt("greet_counter"));

                }
                else if (greetCounter == 2) {
//                    assertEquals("AYA", rs.getString("user_name"));
                    assertEquals(1, rs.getInt("greet_counter"));
                }


                }

            }
            catch(Exception e){
                fail(e);
            }
        }


            //noinspection deprecation
            public void updateUsers () throws Exception {

                try {

            Connection conn = getConnection();
                    FIND_COUNTER_SQL = "select * from users";
                    final String UPDATE_USERS_NAME_GREET_COUNT = "update users set greet_counter = greet_counter + 1 where user_name = ?";

                    PreparedStatement updateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
                    PreparedStatement findCounter = conn.prepareStatement(FIND_COUNTER_SQL);

                    updateCounter.setString(1, "YASH");
                    updateCounter.executeUpdate();


                    ResultSet rs = findCounter.executeQuery();

                    if (rs.next()) {
                        assertEquals(1, rs.getInt("greet_counter"));

                    }
                    else {
                        System.out.println("Should find the user_name in the database");
                    }
                }
                catch ( Exception e){
                    fail(e);
                }
            }
        }
