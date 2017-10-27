package com.ynov.function;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ynov.model.Compte;

public class Serialisation {
	private final static Gson builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();;
	
	
	public static String Json(List<Compte> comptes) throws IOException {
		Compte account = new Compte();
		String chaine = "";
		
		for (Compte compte : comptes) {
			chaine += builder.toJson(compte);
			System.out.println(chaine);
		}
		
		return chaine;
	}
	
	
}
