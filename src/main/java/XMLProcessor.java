import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import Model.XMLName;
import Model.XMLObject;

public class XMLProcessor {

	public XMLProcessor() {
		// TODO Auto-generated constructor stub
	}

	public static String arrayToXML(List<?> data, String prefix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.size(); i++) {
			sb.append(prefix).append("<" + i + ">\n").append(intanceToXML(data.get(i), prefix + "\t"))
					.append("\n<" + i + ">");
			if (i != data.size() - 1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	public static String intanceToXML(Object data, String prefix) {
		StringBuilder sb = new StringBuilder();
		Field fields[] = data.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			sb.append(prefix).append("<").append(Optional.ofNullable(fields[i].getAnnotation(XMLName.class))
					.map(XMLName::value).orElse(fields[i].getName())).append(">");
			if (fields[i].getAnnotation(XMLObject.class) != null) {
				try {
					sb.append("\n").append(intanceToXML(fields[i].get(data), prefix + "\t")).append("\n");
					sb.append(prefix).append("</").append(fields[i].getName()).append(">");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					sb.append(fields[i].get(data));
					sb.append("</").append(fields[i].getName()).append(">");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (i != fields.length - 1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}
