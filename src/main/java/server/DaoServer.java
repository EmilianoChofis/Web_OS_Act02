package server;

import utils.MysqlConn;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoServer {

    public boolean saveOperation(String operacion, String num1, String num2, String resultado) {
        boolean result = false;
        try(
                Connection con = MysqlConn.getConnection();
                PreparedStatement pstm = con.prepareStatement("insert into calculadora(operacion,numero_1, numero_2, resultado)values(?,?,?,?);")
        ){
            pstm.setString(1,operacion);
            pstm.setString(2, num1);
            pstm.setString(3, num2);
            pstm.setString(4,resultado);

            result = pstm.executeUpdate()==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
