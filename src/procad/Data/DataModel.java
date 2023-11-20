package procad.Data;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import procad.swing.UIManagerConfiguration.UIManagerConfiguration;

/**
 *
 * @author Marcelo
 * @since 07/11/2023
 */
public class DataModel {
    
    private Connection cn;
    
    private String database = "ProCad";
    private String username = "root";
    private String password = "root";
    
    /**
     * Method to set username of the connection with the database
     * @param username
     * @return 
     */
    public String setUsername(String username) {
        return this.username = username;
    }
 
    /**
     * Method to set password of the connection with the database
     * @param password
     * @return 
     */
    public String setPassword(String password) {
        return this.password = password;
    }
    
    /**
     * Method to set the database in connection string.
     * @param database
     * @return 
     */
    public String setDatabaseInConnectionString(String database) {
        return this.database = database;
    }
    
    public String getDatabaseInConnectionString() {
        return this.database;
    }

    /**
     * Method to stabilish the connection with the database.
     * @return 
     */
    public Connection connect() {
        UIManagerConfiguration.setLanguageConfiguration();
        
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.database, this.username, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar com o banco de dados. Não é possível iniciar o programa.\nContate o desenvolvedor...", "MENSAGEM DE ERRO", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        return cn;
    }
    
    /**
     * Method to close the connection with the database.
     * @return 
     */
    public Connection disconnect() {
        UIManagerConfiguration.setLanguageConfiguration();
        
        try {
            cn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar se desconectar do banco de dados.\nMensagem: " + e.getMessage());
        }
        return cn;
    }
    
}
