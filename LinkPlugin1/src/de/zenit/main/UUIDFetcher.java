package de.zenit.main;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class UUIDFetcher {
	
	
	
	public static String getUUIDByName(String name) throws IOException {
		Scanner scanner = new Scanner(new URL("https://api.minetools.eu/uuid/"+name).openStream());
        String quellcode = "";
        char quote = '"';
		while(scanner.hasNextLine()){
            quellcode = quellcode + scanner.nextLine();
            
        }
		String array0[] = quellcode.split(quote + "id"+ quote +": " + quote);
		String array1[] = array0[1].split("" + quote);
		String uuidTrim = array1[0];
		
        scanner.close();

		return uuidTrim;
	}
	
	
	public static String convertUUID(String trimmedUUID) throws IllegalArgumentException{
	    if(trimmedUUID == null) throw new IllegalArgumentException();
	    StringBuilder builder = new StringBuilder(trimmedUUID.trim());
	    /* Backwards adding to avoid index adjustments */
	    try {
	        builder.insert(20, "-");
	        builder.insert(16, "-");
	        builder.insert(12, "-");
	        builder.insert(8, "-");
	    } catch (StringIndexOutOfBoundsException e){
	        throw new IllegalArgumentException();
	    }
	 
	    return builder.toString();
	}
	
}