/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;



import java.sql.Connection;

public abstract class DBConnectionFactory {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/random_number?autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "password123!";
    
    public static DBConnectionFactory getInstance() {
        return new DBConnectionFactoryImpl();
    }
    
    public abstract Connection getConnection();

    public String getDriverName() {
        return driverName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
}
