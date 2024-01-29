package lk.ijse.Model;


import lk.ijse.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public boolean register(UserDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO user VALUES(?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1 , dto.getName());
        pstm.setString(1 , dto.getPsw());

        return pstm.executeUpdate() > 0;
    }

    public boolean login(UserDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE user_name = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,dto.getName());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String pw = resultSet.getString(2);
            if (pw.equals(dto.getPsw())){
                return true;
            }
        }

        return false;
    }
}
