package main.dao;
import main.model.User;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import java.sql.*;


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
}