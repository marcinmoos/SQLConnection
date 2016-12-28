package sqlpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;


public class main {

    static OracleDataSource dane ;


    public static void main(String args[]) {

            try {
            dane = new OracleDataSource();
            dane.setDriverType("thin");
            dane.setUser("addressbook");
            dane.setPassword("12345678");
            dane.setServerName("localhost");
            dane.setPortNumber(1521);
            dane.setDatabaseName("xe");

            Polaczenie DatabaseConnection = Polaczenie.inst(dane);  
            ResultSet a = DatabaseConnection.executeMyQuery("select TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24,MI,SS') from DUAL");
 
            a.next();
            DatabaseConnection.executeMyQuery("INSERT INTO TEST_DATES VALUES(TO_DATE('"+a.getString(1)+"','YYYY-MM-DD  HH24,MI,SS'))");


            
            } catch (SQLException ex) {
                System.out.println("błąd SQL");
            } catch (ClassNotFoundException ex) {
            System.out.println("błąd");
        }
            
            
    }
}
