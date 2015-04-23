package br.com.bdmstyle.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import br.com.bdmstyle.client.Response;
import br.com.bdmstyle.client.Security;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Sucks {
	
	   public static void main(String[] args) {
		
		try (CloseableHttpClient client = HttpClients.createDefault()){
			HttpPost httpPost = new HttpPost("https://payment.girosolution.de/girocheckout/api/v2/transaction/status");
			
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("merchantId", "3612528"));
			parameters.add(new BasicNameValuePair("projectId", "12103"));
			parameters.add(new BasicNameValuePair("reference", "9dfbd5f1-6445-4dab-92db-3968642e9bae"));
			parameters.add(new BasicNameValuePair("hash", Security.hmacDigest("3612528121039dfbd5f1-6445-4dab-92db-3968642e9bae","CumaVbB5xGac")));
			
			httpPost.setEntity(new UrlEncodedFormEntity(parameters));
			CloseableHttpResponse response = client.execute(httpPost);

			String json = EntityUtils.toString(response.getEntity());
			
			if(!getHash(response).equals(Security.hmacDigest(json,"CumaVbB5xGac")))
				throw new RuntimeException("invalid hash");
						
			System.out.println(new ObjectMapper().readValue(json, Response.class)); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getHash(CloseableHttpResponse response) {
		return response.getHeaders("hash")[0].getValue();
	}
	
}
