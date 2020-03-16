import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthenticationClient {

	public static final String AUTH_URL = "http://localhost:8080/RestfulWebServiceExample/rest/auth";
	public static final String TOKEN = getToken();
	private static String getToken() {
		// TODO Auto-generated method stub
	RequestBody requestBody = new FormBody.Builder()
			.add("username", "Tran Li")
			.add("password", "12345678")
			.build();
	
	Request request = new Request.Builder()
			.url(AUTH_URL)
			.post(requestBody)
			.build();
	
	OkHttpClient client = new OkHttpClient();
	try (Response response = client.newCall(request).execute()){
		if(!response.isSuccessful()) {
			throw new IOException("Unexpected code: "+response);
		}
		String tokenString = response.body().string();
		System.out.println("Token: "+ tokenString);
		return tokenString;
	} catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}
}
