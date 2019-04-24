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

    PreparedStatement psCreateNewinsertDB;
    PreparedStatement psfindCounter;
    PreparedStatement psupdateCounter;
    PreparedStatement psdeleteAll;



    public JdbcGreetedUser() throws SQLException {
        psCreateNewinsertDB = conn.prepareStatement(INSERT_USERS_SQL);
        psfindCounter = conn.prepareStatement(FIND_COUNTER_SQL);
        psupdateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
        psdeleteAll = conn.prepareStatement(DELETE_NAMES_SQL);

    }

    @Override
    public void greetUser(String userName, String language){

        try{
            psCreateNewinsertDB.setString(1, userName);

            ResultSet rs = psfindCounter.executeQuery();

            if (!rs.next()){

                psCreateNewinsertDB.setString(1, userName.toString());
                psCreateNewinsertDB.setInt(2,1);
                psCreateNewinsertDB.execute();

            }

            else{
              int greetCounter = rs.getInt("greetcounter") + 1;

                psupdateCounter.setInt( 1, greetCounter);
                psupdateCounter.setString( 1, userName);
                psupdateCounter.execute();

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
            psfindCounter.setString(1, userName );

            ResultSet rs = psfindCounter.executeQuery();

            if (rs.next());


            else {
                System.out.println("");
            }
        }

        catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
}


