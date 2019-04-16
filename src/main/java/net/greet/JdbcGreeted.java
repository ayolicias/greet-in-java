package net.greet;
import java.sql.*;
import java.util.Map;;
import java.util.HashMap;


  abstract class JdbcGreetedUser implements GreetedUser{

    final String INSERT_LANGUAGE_SQL = ("insert into greetedUsers (user_Name, greet_Counter)values (?,?)");
    final String FIND_LANGUAGE_USERNAME_SQL = "select * greet_Count from greetedUser where greet_Count = ?";
    final String UPDATE_LANGUAGE_USERNAME_SQL= "update greetedUsers set greet_Counter = ? where greet_Counter ";

    Connection conn;
    PreparedStatement psCreateNewUsers;
    PreparedStatement psFindGreetCounter;
    PreparedStatement psUpdateGreetCounter;


    public JdbcGreetedUser(){

        try {

            conn = DriverManager.getConnection("jdbc:h2:./target/greetings_db","sa","");
            psCreateNewUsers = conn.prepareStatement(INSERT_LANGUAGE_SQL);
            psFindGreetCounter = conn.prepareStatement(FIND_LANGUAGE_USERNAME_SQL);
            psUpdateGreetCounter = conn.prepareStatement(UPDATE_LANGUAGE_USERNAME_SQL);

        }

        catch (SQLException ex){
                ex.printStackTrace();
        }
    }

    public void greetUser(String userName, String language){

        try{
            psFindGreetCounter.setString(1, userName.toString());
            ResultSet rsuserName = psFindGreetCounter.executeQuery();

            if (!rsuserName.next()){
                psCreateNewUsers.setString(1, userName.toString());
                psCreateNewUsers.setInt(2,1);
                System.out.println(psCreateNewUsers.execute());

            }else{
              int greetCounter = rsuserName.getInt("greet_Counter");
                psUpdateGreetCounter.setInt( 1, ++greetCounter);
                psUpdateGreetCounter.setString(1, userName.toString());
                psUpdateGreetCounter.execute();

            }

        }

        catch(SQLException ex){
            ex.printStackTrace();
        }

    }


    public int totalGreeted() {

        try {
//            psFindGreetCounter.setString();
//            ResultSet rs = psFindGreetCounter.executeQuery();
//
//            if (rs.next());
//
//            return rs.getInt(greet_Counter);

            return greetMap.size();


            public Map< String, Integer > greeted() {
                return greetMap;
            }
        }




        catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
};


