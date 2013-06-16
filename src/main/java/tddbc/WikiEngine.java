package tddbc;
import java.util.regex.*;
import java.util.*;

public class WikiEngine {

	public String getText(String text) {
		String str = text;
		String regex_h1 = "^=[\t ]*(.+[^\t ]+)[\t ]*=$";
		String regex_h2 = "^==[\t ]*(.+[^\t ]+)[\t ]*==$";
		String regex_italic = "_(.*)_";
		Hashtable<String,String> regexTable = new Hashtable<String,String>();
		regexTable.put("H1", regex_h1);
		regexTable.put("H2", regex_h2);
		regexTable.put("i", regex_italic);
		
		Enumeration<String> keys = regexTable.keys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			Pattern pattern = Pattern.compile(regexTable.get(key));
			Matcher m = pattern.matcher(text);
			if(m.find()) {
				str = "<" + key + ">" + m.group(1) + "</" +key + ">";
				break;
			}
		}
		
		return str;
	}

}
