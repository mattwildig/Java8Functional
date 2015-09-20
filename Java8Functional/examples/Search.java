package examples;

import java.util.List;

public class Search {
	/*
	String find(List<String> stringsToSearch, String stringToFind){
		String found= null;
		for( String string : stringsToSearch ){
			if ( string.equals(stringToFind)){
				found = string;
				break;
			}
		}
		return found;
	}*/

	String find(List<String> stringsToSearch, String stringToFind){
		return stringsToSearch.stream().findFirst().orElse(null);
	}

}
