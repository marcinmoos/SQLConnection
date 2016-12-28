package sqlpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;


public class Polaczenie {
    
        private static Polaczenie inst;
        Connection polaczenie;
    
        public static Polaczenie inst(OracleDataSource dane) throws ClassNotFoundException, SQLException{
        if(inst == null){
            inst = new Polaczenie(dane);
        }
        return inst;
        }
        
        private Polaczenie(OracleDataSource dane) throws ClassNotFoundException, SQLException{
            Class.forName("oracle.jdbc.pool.OracleDataSource");
            polaczenie = dane.getConnection();
        }

        int executeMyUpdate(String query) throws SQLException{
            return polaczenie.createStatement().executeUpdate(query);
        }

	ResultSet executeMyQuery(String query) throws SQLException {
            return polaczenie.createStatement().executeQuery(query);
	}

}