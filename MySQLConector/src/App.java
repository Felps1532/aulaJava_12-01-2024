import java.sql.*;

public class App {
    public static void main(String[] args) {
        conectar();
    }
    public static Connection conectar() {
        String status = "Nada aconteceu aqui";
        String mysqlUser = "felps";
        String mysqlPassword = "";
        String mysqlHost = "127.0.0.1";
        String mysqlDb = "mysql_connector";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com sucesso!";
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            status = "Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! Mensagem do servidor: " + e;
        }
        System.out.println(status);
        return conn;
    }
}
