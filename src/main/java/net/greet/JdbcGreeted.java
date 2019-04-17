package net.greet;
import java.sql.*;
import java.util.Map;

 class JdbcGreetedUser implements GreetedUser{

//    final String INSERT_GREETED_USERS = ("insert into greetedUsers (user_name, greet_counter)values (?,?)");
//    final String FIND_GREET_COUNT = "select * greet_count from greetedUser where greet_count = ?";
//    final String UPDATE_GREET_COUNT= "update greetedUsers set greet_counter = ? where greet_counter ";

    Connection conn;
    PreparedStatement psCreateNewUsers;
    PreparedStatement psFindGreetCounter;
    PreparedStatement psUpdateGreetCounter;

    public JdbcGreetedUser(){

        try {

            conn = DriverManager.getConnection("jdbc:h2:./target/greetings_db","sa","");
            psCreateNewUsers = conn.prepareStatement("insert into greetedUsers(user_name,greet_count)values('ziya', 1)");

//            psFindGreetCounter = conn.prepareStatement(FIND_GREET_COUNT);
//            psUpdateGreetCounter = conn.prepareStatement(UPDATE_GREET_COUNT);

        }

        catch (SQLException ex){
                ex.printStackTrace();
        }
    }
    @Override
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

     @Override
     public boolean greeted( ) {
         return false;
     }

     @Override
     public void reset( ) {

     }

     @Override
     public void remove( String s ) {

     }

     @Override
        public int totalGreeted(int greet_Counter){

        try {
            psFindGreetCounter.setInt(1, greet_Counter);
            ResultSet rs = psFindGreetCounter.executeQuery();

            if (rs.next());

//            return rs.getInt(greet_Counter);
//
//            return greetMap.size();
//
//
//            public Map< String, Integer > greeted() {
//                return greetMap;
//            }
        }




        catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
};


