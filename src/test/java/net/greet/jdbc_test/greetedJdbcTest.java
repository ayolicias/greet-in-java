package net.greet.jdbc_test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static java.lang.Class.forName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class greetedJdbcTest {

    final String GREETINGS_DATABASE_URL = "jdbc:h2:./target/greetings_db";

    public Connection getConnection() throws Exception{
        Connection conn = DriverManager.getConnection(GREETINGS_DATABASE_URL,"sa", "");
        return conn;
    }

    @BeforeEach

    public void CleanTable(){
    try{
        try(Connection conn = DriverManager.getConnection(GREETINGS_DATABASE_URL, "sa", "")){
        Statement statement = conn.createStatement();
//        Statement.addBatch("delete from greetedUsers where('Anele') ");
//        Statement.addBatch( "update greetedUsers set greet_Counter = 2 where name = ziya");

        statement.executeBatch();
        }
    }

    catch (Exception ex){
        System.out.println("CleenUp the Table");
    }

    }
    @Test
    public void loadJdbcclass(){

        try{

            forName("org.h2.Driver");
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectToDatabase(){
        try {
            Class.forName("org.h2.Driver");
            Connection conn = (DriverManager.getConnection(GREETINGS_DATABASE_URL, "sa" ,""));
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void ExecuteDataInDataBase(){
        try {
            Connection conn =(DriverManager.getConnection(GREETINGS_DATABASE_URL, "sa", ""));
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from  greetedUsers");
        }
        catch (Exception e){
            System.out.println("Select users from databaseUsers");
        }

    }
    @Test
    public void AddUsersViaMigration(){
        try{
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery ("select greet_count(*) as greet_count from greetedUsers");

            if (rs.next()) {
                //count users
                assertEquals(3, rs.getInt("greet_count"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
