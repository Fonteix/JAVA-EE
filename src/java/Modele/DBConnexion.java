/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author p1522867
 */
public class DBConnexion {
    
    private String hostname = "134.214.115.116";
    private String database = "p1522867";
    private String username = "p1522867";
    private String password = "260410";
    private Connection cnx;

    public DBConnexion() {
    }
    
    
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String construireUrlJdbc(){
        String urlJdbc;
        urlJdbc = "jdbc:mysql://"+hostname+"/"+database+"?user="+username+"&password="+password;
        return urlJdbc;
    }
    
    public Connection getConnection(){
        if(etablirConnexion()){
            return cnx;
        }
        else{
            return null;
        }
    }
    
    private boolean etablirConnexion(){
        
        boolean statusConnexion= false;
        String urlJdbc;
        
        try {    
            Class.forName("com.mysql.jdbc.Driver");
            urlJdbc=construireUrlJdbc();
            cnx=DriverManager.getConnection(urlJdbc);
            statusConnexion=true;
            } 
        catch (Exception ex) {
            statusConnexion=false;
            System.out.println(ex);
        }
        return statusConnexion;
    }
    
}
