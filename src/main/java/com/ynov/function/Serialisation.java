package com.ynov.function;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ynov.model.Compte;
import com.ynov.model.Transaction;
import com.ynov.model.Virement;

public class Serialisation {
	private final static Gson builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
	
	
	public static String Json(List<Virement> comptes) throws IOException {
		String chaine = "";
		
		chaine += builder.toJson(comptes);
		
		return chaine;
	}
	
	public static String JsonTransaction(List<Transaction> transes) throws IOException {
		String chaine2 = "";
		
		chaine2 += builder.toJson(transes);
		System.out.println(transes);
		return chaine2;
	}
	
	
}
