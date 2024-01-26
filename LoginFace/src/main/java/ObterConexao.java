import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ObterConexao {
    
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "usr_oceankeeper";
    private static String usuario = "root";
    private static String senha = "anima123";
    // caso de errado mudar a senha desse programa / senha = 123321

    
    public static Connection Conectar() throws Exception{
        //1. montar a string de conexão
        String url = String.format(
            "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo",
            host, porta, db
        );
        //2. estabelecer o canal de comunicação (conexão) com o SGBD (MySQL)
                    
        return DriverManager.getConnection(url, usuario, senha);
    }
    
    
    
 /*       public static void main(String[]args)
        {
        try {
            Conectar();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            Logger.getLogger(ObterConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }*/
    
    
    }