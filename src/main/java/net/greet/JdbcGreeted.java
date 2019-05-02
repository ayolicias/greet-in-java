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

      final String INSERT_USERS_SQL = "insert into users(user_name, greet_counter) values (?, ?)";

      final String FIND_COUNTER_SQL = "select * from users";
      final String FIND_USER_SQL = "select * from users where user_name = ?";
      final String UPDATE_USERS_NAME_GREET_COUNT = "update users set greet_counter = greet_counter + 1 where user_name = ?";
      final String DELETE_NAMES_SQL = "delete from users";

      PreparedStatement psCreateNewinsertDB;
      PreparedStatement psfindCounter;
      PreparedStatement psupdateCounter;
      PreparedStatement psdeleteAll;
      PreparedStatement psfindUser;

      public JdbcGreeted( ) {
          try {
              psCreateNewinsertDB = conn.prepareStatement(INSERT_USERS_SQL);
              psfindCounter = conn.prepareStatement(FIND_COUNTER_SQL);
              psupdateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
              psdeleteAll = conn.prepareStatement(DELETE_NAMES_SQL);
              psfindUser = conn.prepareStatement(FIND_USER_SQL);
          }
          catch (Exception e){
          }
      }

      @Override
      public void greetUser( String userName, String language ) {

          try {
//              psCreateNewinsertDB.setString(1, userName);

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

      }

      @Override
      public String greeted(){
          try {
              ResultSet resultSet = psfindCounter.executeQuery();
              while (resultSet.next()) {
                  greetMap.put(resultSet.getString("user_name"), resultSet.getInt("greet_counter"));
              }
              return greetMap.toString();
          }
          catch (Exception e) {
//              return greetMap.size();
              System.out.println("Exception");
              return greetMap.toString();
          }
      }

      @Override
      public void findUser(String userName) throws Exception {
          PreparedStatement preparedStatement = conn.prepareStatement ( "select * from users");
          ResultSet rs = preparedStatement.executeQuery ( );

          while ( rs.next ( ) ) {
              rs.getString(userName);
              rs.getInt("greet_counter");

          }
      }

      @Override
      public int totalGreeted( ) {

          return greetMap.size();
      }

      @Override
      public int totalGreeted(String userName) {
          try {
              psfindCounter.setString(1,userName);

              ResultSet rs = psfindCounter.executeQuery();

              if (rs.next());


              else {
//                  System.out.println("");
              }
          }

          catch (SQLException ex){
              ex.printStackTrace();
          }
          return 0;
      }



      @Override
      public String remove( String userName ) {
          return null;
      }

    }


