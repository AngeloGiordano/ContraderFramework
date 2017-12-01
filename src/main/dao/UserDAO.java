package main.dao;
import main.model.User;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class UserDAO {
private final String query_insertuser="insert into users (idUser,username,password,firstname,lastname,dateofbirth,cf,businessname,vat,municipality,cap,city,address,telephone,role) values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,\"local\")";


public UserDAO(){

        }
        public boolean insertUser(User user){
            Connection connection = ConnectionSingleton.getInstance();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query_insertuser);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getFirstname());
                preparedStatement.setString(4, user.getLastname());
                preparedStatement.setString(5, user.getDateofbirth());
                preparedStatement.setString(6, user.getCf());
                preparedStatement.setString(7, user.getBusinessname());
                preparedStatement.setString(8, user.getVat());
                preparedStatement.setString(9, user.getMunicipality());
                preparedStatement.setString(10, user.getCap());
                preparedStatement.setString(11,user.getCity());
                preparedStatement.setString(12,user.getAddress());
                preparedStatement.setString(13,user.getTelephone());

                return preparedStatement.execute();
            }
            catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }


        }

        public List<User> getAlluser(){
            List<User> users= new ArrayList<>();
            Connection connection = ConnectionSingleton.getInstance();
            String var="local";
            String query_user="SELECT * from users WHERE role=\""+var+"\"";
            try{
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query_user);
                while (resultSet.next()) {
                    int idUser = resultSet.getInt("idUser");
                    String username = resultSet.getString("username");
                    String password = "*******";
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String dateofbirth = resultSet.getString("dateofbirth");
                    String cf = resultSet.getString("cf");
                    String businessname = resultSet.getString("businessname");
                    String vat = "*******";
                    String municipality = resultSet.getString("municipality");
                    String cap = resultSet.getString("cap");
                    String city = resultSet.getString("city");
                    String address = resultSet.getString("address");
                    String telephone = resultSet.getString("telephone");
                    String role = resultSet.getString("role");
                    users.add(new User(idUser, username, password, firstname, lastname, dateofbirth, cf, businessname, vat, municipality, cap, city, address, telephone, role));
                }




                } catch (SQLException e) {
                e.printStackTrace();
            } return users;
        }
        }
