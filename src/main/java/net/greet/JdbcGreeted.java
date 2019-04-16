package net.greet;
import java.sql.*;
//import java.sql.connection;


 class JdbcGreeted implements GreetedUser{

    final String INSERT_LANGUAGE_SQL = ("insert into greetedUsers (user_Name, greet_Counter)values (?,?)");
    final String FIND_LANGUAGE_USERNAME_SQL = "select * greet_Count from greetedUser where user_Name = ?";
    final String UPDATE_LANGUAGE_USERNAME_SQL= "update greetedUsers set greete_Counter = ? ";

    Connection conn;
     PreparedStatement CreateNewgreeteduser;
    PreparedStatement FindNewgreetedUsers;
    PreparedStatement UpdateNewgreetedUsers;


    public JdbcGreeted(){

        try {

            conn = DriverManager.getConnection("jdbc:h2:./target/greetings_db","sa","");
            CreateNewgreeteduser = conn.prepareStatement(INSERT_LANGUAGE_SQL);
            FindNewgreetedUsers = conn.prepareStatement(FIND_LANGUAGE_USERNAME_SQL);
            UpdateNewgreetedUsers = conn.prepareStatement(UPDATE_LANGUAGE_USERNAME_SQL);

        }

        catch (SQLException ex){
                ex.printStackTrace();
        }
    }

    public void greetUser( ) {

    }

    public int totalGreeted( ) {
        return 0;
    }
};


