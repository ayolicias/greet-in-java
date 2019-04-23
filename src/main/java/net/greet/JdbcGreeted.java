package net.greet;
import java.sql.*;
import java.util.Map;

import static java.lang.Class.forName;

class JdbcGreetedUser implements GreetedUser{

     final String DATABASE_URL = "jdbc:h2:./target/greetings_db";

    public void loadJdbcclass() {

        try {

            forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
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


    final String INSERT_USERS_SQL = "insert into users (user_name, greet_counter)values (?,?)";

    final String FIND_COUNTER_SQL = "select * greet_count from users where user_name = ?";

    final String UPDATE_USERS_NAME_GREET_COUNT= "update users set greet_counter = ? where user_name ";

    final String DELETE_NAMES_SQL = "delete from users";

    PreparedStatement insertDB;
    PreparedStatement findCounter;
    PreparedStatement updateCounter;
    PreparedStatement deleteAll;



    public JdbcGreetedUser() throws SQLException {
        insertDB = conn.prepareStatement(INSERT_USERS_SQL);
        findCounter = conn.prepareStatement(FIND_COUNTER_SQL);
        updateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
        deleteAll = conn.prepareStatement(DELETE_NAMES_SQL);

    }

    @Override
    public void greetUser(String userName, String language){

        try{
            insertDB.setString(1, userName);

            ResultSet rs = findCounter.executeQuery();

            if (!rs.next()){

                insertDB.setString(1, userName.toString());
                insertDB.setInt(2,1);
                insertDB.execute();

            }

            else{
              int greetCounter = rs.getInt("greetcounter");

                updateCounter.setInt( 1, ++greetCounter);
                updateCounter.setString( 1, userName);
                updateCounter.execute();

            }

        }

        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

     @Override
     public int greeted( ) {
         return greeted();
     }

     @Override
     public void reset( ) {

     }

     @Override
     public void remove( String s ) {

     }

     @Override
        public int totalGreeted(String userName){

        try {
            findCounter.setString(1, userName );

            ResultSet rs = findCounter.executeQuery();

            if (rs.next());


            else {
                System.out.println("user in in the database");
            }
        }

        catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
}


