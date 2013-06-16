package tddbc;
import java.util.regex.*;
import java.util.*;

public class WikiEngine {

	public String getText(String text) {
		String str = text;
		String regex = "^=[\t ]*(.+[^\t ]+)[\t ]*=$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(text);
		if(m.find()) {
			str = "<H1>" + m.group(1) + "</H1>";
		}
		return str;
	}

}
