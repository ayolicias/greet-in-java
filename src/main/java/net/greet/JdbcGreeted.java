package net.greet;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Class.forName;

public class JdbcGreeted implements GreetedUser {

    Map< String, Integer > greetMap = new HashMap< String, Integer >();


    final String GREET_DATABASE_URL = "jdbc:h2:./target/greetings_db";

    public void loadJdbcclass( ) throws Exception{

        try {
            forName("org.h2.Driver");
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    Connection conn;

    {
        try {

            conn = DriverManager.getConnection("jdbc:h2:./target/greetings_db", "sa", "");


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    final String INSERT_USERS_SQL = "insert into users(user_name, greet_counter) values (?,?)";

    final String FIND_COUNTER_SQL = "select * from users where user_name = ?";
    final String FIND_USER_SQL = "select * from users where user_name = ?";
    final String UPDATE_USERS_NAME_GREET_COUNT = "update users set greet_counter = greet_counter + 1 where user_name = ?";
    final String DELETE_NAMES_SQL = "delete from users";
    final String REMOVE_USERS = "delete from users where user_name = ?";
    final String FIND_HELP_SQL = "select * from users";

    PreparedStatement psCreateNewinsertDB;
    PreparedStatement psfindCounter;
    PreparedStatement psupdateCounter;
    PreparedStatement psdeleteAll;
    PreparedStatement psfindUser;
    PreparedStatement psremove;
    PreparedStatement psfindhelp;


    public JdbcGreeted( ) {
        try {
            psCreateNewinsertDB = conn.prepareStatement(INSERT_USERS_SQL);
            psfindCounter = conn.prepareStatement(FIND_COUNTER_SQL);
            psupdateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
            psdeleteAll = conn.prepareStatement(DELETE_NAMES_SQL);
            psfindUser = conn.prepareStatement(FIND_USER_SQL);
            psremove = conn.prepareStatement(REMOVE_USERS);
            psfindhelp = conn.prepareStatement(FIND_USER_SQL);
        }
        catch (Exception e){
        }
    }

    @Override
    public void greetUser( String userName, String language ) {
        Map< String, Integer > greetMap = new HashMap< String, Integer >();


        try {
            psfindCounter.setString(1, userName);

            ResultSet rs = psfindCounter.executeQuery();

            if (rs.next()) {

                psupdateCounter.setString(1, userName);
                psupdateCounter.execute();

            } else {
//                  int greetCounter = rs.getInt("greet_counter") + 1;
                psCreateNewinsertDB.setString(1, userName);
                psCreateNewinsertDB.setInt(2, 1);
                psCreateNewinsertDB.execute();

//                  psupdateCounter.setInt(2, greetCounter);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public void reset( ) {
        try {
            psdeleteAll.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String greeted() throws Exception{
       return findUsers().toString();



//        try {
//            ResultSet resultSet = psfindCounter.executeQuery();
//            while (resultSet.next()) {
//                greetMap.put(resultSet.getString("user_name"), resultSet.getInt("greet_counter"));
//            }
//            return greetMap.toString();
//        }
//        catch (Exception e) {
////              return greetMap.size();
//            System.out.println("Exception");
//            return greetMap.toString();
//        }
    }

    @Override
    public Map< String, Integer > findUsers() throws Exception {
        Map< String, Integer > greetMap = new HashMap< String, Integer >();

        PreparedStatement preparedStatement = conn.prepareStatement ( "select * from users");
        ResultSet rs = preparedStatement.executeQuery ( );

        while ( rs.next ( ) ) {
           String name = rs.getString("user_name");
            int counter = rs.getInt("greet_counter");
            greetMap.put(name, counter);

        }

        return greetMap;
    }

    @Override
    public int totalGreeted( ) throws Exception {
        return findUsers().size();
    }

    @Override
    public void help() {
        System.out.println("greet followed by the name and the language the user is to be greeted in a specific language, \n");
        System.out.println("greet followed by the name the user is to be greeted in a Default Language,\n");
        System.out.println("greeted should display a list of all users that has been greeted and how many time each user has been greeted,");
        System.out.println("\n" + "greeted followed by a username returns how many times that username have been greeted");
        System.out.println("counter returns a count of how many unique users has been greeted,\n");
        System.out.println("clear deletes of all users greeted and the reset the greet counter to 0,\n");
        System.out.println("clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n");
        System.out.println("exit exits the application,\n");
        System.out.println("help shows a user an overview of all possible commands.\n");
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public String greetedUser( String userName ) throws Exception {
        return userName + "  have been greeted: " + findUsers().get(userName);
    }

//    @Override
//    public int totalGreeted( String userName) {
//        try {
//            psfindCounter.setString(1, userName);
//
//            ResultSet rs = psfindCounter.executeQuery();
//
//            if (rs.next());
//
//
//            else {
////                  System.out.println("");
//            }
//        }
//
//        catch (SQLException ex){
//            ex.printStackTrace();
//        }
//          return 0;
//    }

    @Override
    public String remove(String userName) {
        try {
            psremove.setString(1,userName);
            psremove.execute();

            System.out.println (userName + "has been deleted from database");
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return userName;
    }


}


