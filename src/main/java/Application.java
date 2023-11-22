import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import Model.Address;
import Model.Company;
import Model.User;

public class Application {

	public final static String url = "https://jsonplaceholder.typicode.com/users";

	public static String callHttpRequestByHttpClient(String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		String res = "";
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == HttpURLConnection.HTTP_OK) {
				res = response.body();
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public static Object parseToJSON(String value) {
		return JSONValue.parse(value);
	}

	public static List<User> createListUser(JSONArray data) {
		List<User> users = new ArrayList<User>();
		for (Object user : data) {
			users.add(new User((JSONObject) user));
		}
		return users;
	}

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String data = callHttpRequestByHttpClient(url);
		List<User> users = createListUser((JSONArray) parseToJSON(data));
		File save = new File("./users.xml");
		try {
			FileWriter fs = new FileWriter(save);
			fs.write(XMLProcessor.arrayToXML(users, ""));
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Write file success");
	}

}
