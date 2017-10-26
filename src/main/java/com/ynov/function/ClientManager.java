package com.ynov.function;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.cj.api.jdbc.Statement;
import  java.sql.Statement;

import com.ynov.model.Client;

public class ClientManager {
	public static final String DB_LOGIN = "root";
	public static final String DB_PASSWD = "";
	
	public static Client loadClientByID(int clientID) {
		Client result = new Client();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque", DB_LOGIN, DB_PASSWD);
			
			
			PreparedStatement stmt = con.prepareStatement("SELECT clientID, nom, prenom, login FROM client where clientID = ?");
			stmt.setInt(1, clientID);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				result.setClientID (rs.getInt("clientID"));
				result.setNom (rs.getString("nom"));
				result.setPrenom (rs.getString("prenom"));
				result.setLogin (rs.getString("login"));
						
				System.out.println("CLient : " + result.toString());
			}
			
			rs.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public static void createClient(String prenom, String nom, String password, String login) {
		Client client = new Client();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque", DB_LOGIN, DB_PASSWD);
			
			
			Statement stmt = con.createStatement();
			String request = "INSERT INTO client (nom, prenom, login, password) VALUES ('"+ nom +"', '"+ prenom +"', '"+ login +"', '"+ password +"')";
			
			stmt.executeUpdate(request);
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
