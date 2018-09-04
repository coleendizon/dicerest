/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnectionFactoryImpl extends DBConnectionFactory{

	Properties prop = new Properties();
	InputStream input = null;
	
    @Override
    public Connection getConnection() {
        try {
        	input = new FileInputStream("target/config/application.properties");
        	prop.load(input);

        	if(prop.getProperty("use.database").equals("true")){
            Class.forName(prop.getProperty("db.mysql.drivername"));
            Connection conn = 
                    DriverManager.getConnection(prop.getProperty("db.mysql.url"),prop.getProperty("db.mysql.username"), prop.getProperty("db.mysql.password"));
            return conn;
            } else if(prop.getProperty("use.database").equals("false")){
            	return null;
            }
        } 
        	catch (ClassNotFoundException | IOException | SQLException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
