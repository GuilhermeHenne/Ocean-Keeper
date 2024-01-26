/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    private static final String host = "localhost";
    private static final String porta = "3306";
    private static final String db = "db_pessoas";
    private static final String usuario = "root";
    private static final String senha = "anima123";
    private static final String url = "jdbc:mysql:http//localhost:3306//db_pessoa";
    
    
    public static Connection createConnectionToMySQL() throws Exception{
        //Class.forName ("")
        return DriverManager.getConnection(url, usuario, senha);
        
    }
    
}
