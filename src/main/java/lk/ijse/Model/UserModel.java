package lk.ijse.Model;


import lk.ijse.Dto.UserDto;
import lk.ijse.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
