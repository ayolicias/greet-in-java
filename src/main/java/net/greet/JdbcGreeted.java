package net.greet;
import java.sql.*;

import static java.lang.Class.forName;

  public class JdbcGreeted implements GreetedUser {

      final String GREET_DATABASE_URL = "jdbc:h2:./target/greetings_db";

      public void loadJdbcclass( ) {

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

      final String INSERT_USERS_SQL = "insert into users(user_name, greet_counter) values (?, ?)";

      final String FIND_COUNTER_SQL = "select *  from users";
      final String FIND_NAME_SQL = "select * from users where user_name =?";
      final String FIND_USER_SQL = "select * from users where user_name = ?";

      final String UPDATE_USERS_NAME_GREET_COUNT = "update users set greet_counter = greet_counter + 1 where user_name = ?";

      final String DELETE_NAMES_SQL = "delete from users";

      PreparedStatement psCreateNewinsertDB;
      PreparedStatement psfindCounter;
      PreparedStatement psupdateCounter;
      PreparedStatement psdeleteAll;
      PreparedStatement psfindName;
      PreparedStatement psfindUser;

      public JdbcGreeted( ) throws SQLException {
          assert conn != null;
          psCreateNewinsertDB = conn.prepareStatement(INSERT_USERS_SQL);
          psfindCounter = conn.prepareStatement(FIND_COUNTER_SQL);
          psupdateCounter = conn.prepareStatement(UPDATE_USERS_NAME_GREET_COUNT);
          psdeleteAll = conn.prepareStatement(DELETE_NAMES_SQL);
          psfindName = conn.prepareStatement(FIND_NAME_SQL);
          psfindUser = conn.prepareStatement(FIND_USER_SQL);
      }

      @Override
      public void greetUser( String userName, String language ) {

          try {
              psCreateNewinsertDB.setString(1, userName);

              ResultSet rs = psfindCounter.executeQuery();

              if (!rs.next()) {

                  psCreateNewinsertDB.setString(1, userName.toString());
                  psCreateNewinsertDB.setInt(2, 1);
                  psCreateNewinsertDB.execute();

              } else {
                  int greetCounter = rs.getInt("greet_counter") + 1;

                  psupdateCounter.setInt(1, greetCounter);
                  psupdateCounter.setString(1, userName);
                  psupdateCounter.execute();

              }

          } catch (SQLException ex) {
              ex.printStackTrace();
          }

      }

      @Override
      public void reset( ) {

      }

      @Override
      public int greeted( ){

          return 0;
      }

      @Override
      public void findUser( String userName ) {
//
//          try {
//              psfindUser.setString(1, userName);
//
//              ResultSet rs = psfindUser.executeQuery();
//
//              if (rs.next()) {
//                  //Add to map
//                  Map< String, Integer > Map = new HashMap<>();
//                  int greet_counter;
//                  String user_name;
////
////                  Map.put(rs.getString("user_name"));
////                  Map.put(rs.getInt("greet_counter"));
////
////                  psfindUser.setString(1, userName.toString());
////                  psfindUser.setInt(2, 1);
//                  psfindUser.execute();
//
//              }
//
//          } catch (Exception e) {
//              e.printStackTrace();
//          }
      }

      @Override
      public int totalGreeted( ) {

          return this.totalGreeted();
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


