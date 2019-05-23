package net.greet;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Class.forName;

public class JdbcGreeted implements GreetedUser {

    Map< String, Integer > greetMap = new HashMap< String, Integer >();
    final String GREET_DATABASE_URL = "jdbc:h2:./target/greetings_db";


    Connection conn;


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


    public JdbcGreeted() {
        try {
            conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");

            psCreateNewinsertDB = conn.prepareStatement(INSERT_USERS_SQL);
            psfindCounter = conn.prepareStatement(FIND_COUNTER_SQL);
            psupdateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
            psdeleteAll = conn.prepareStatement(DELETE_NAMES_SQL);
            psfindUser = conn.prepareStatement(FIND_USER_SQL);
            psremove = conn.prepareStatement(REMOVE_USERS);
            psfindhelp = conn.prepareStatement(FIND_HELP_SQL);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String greetUser( String userName, String language ) {
        String UserName = userName;
        Map< String, Integer > greetMap = new HashMap< String, Integer >();
        try {
            psfindCounter.setString(1, UserName);

            ResultSet rs = psfindCounter.executeQuery();

            if (rs.next()) {

                psupdateCounter.setString(1, UserName);
                psupdateCounter.execute();

            } else {
                psCreateNewinsertDB.setString(1, UserName);
                psCreateNewinsertDB.setInt(2, 1);
                psCreateNewinsertDB.execute();
            }

            return Languages.valueOf(language).getGreets() + UserName;
        } catch (SQLException | IllegalArgumentException ex) {

            return "dumela " + UserName;

        }
    }

    @Override
    public String greeted() {
       return findUsers().toString();
    }

    @Override
    public Map< String, Integer > findUsers()  {
        try {
            Map< String, Integer > greetMap = new HashMap< String, Integer >();

            PreparedStatement preparedStatement = conn.prepareStatement("select * from users");
            ResultSet rs = preparedStatement.executeQuery();

            while ( rs.next() ) {
                String name;
                name = rs.getString("user_name");
                int counter = rs.getInt("greet_counter");
                greetMap.put(name, counter);

            }

            return greetMap;
        }
        catch (Exception e){
            return greetMap;
        }
    }

    @Override
    public String totalGreeted() {
        return String.valueOf(findUsers().size());
    }

    @Override
    public String reset() {
        try {
            psdeleteAll.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "All names deleted";
    }

    @Override
    public String greetedUser( String userName ) {
        return userName + "  have been greeted: " + findUsers().get(userName);
    }

    @Override
    public String remove(String userName) {
        try {
            psremove.setString(1,userName);
            psremove.execute();

            return (userName + " has been deleted from database");
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return (userName + " has been deleted from database");
    }
    @Override
    public String help() {
      return "help shows a user an overview of all possible commands\n" +
              "greet followed by the name and the language the user is to be greeted in a specific language, \n " +
              "greet followed by the name the user is to be greeted in a Default Language,\n " +
              "greeted should display a list of all users that has been greeted and how many time each user has been greeted\n " +
              "greeted followed by a username returns how many times that username have been greeted\n " +
              "counter returns a count of how many unique users has been greeted,\n " +
              "clear deletes of all users greeted and the reset the greet counter to 0,\n " +
              "clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n " +
              "exit exits the application,\n ";
    }

    @Override
    public String exit( ) {
        try {

            System.exit(0);
            return "exits the application";

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "exits the application";
    }
}


