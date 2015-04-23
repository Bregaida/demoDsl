package br.com.bdmstyle.client;

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

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
	
	public Response execute(Request request) {

		try (CloseableHttpClient client = HttpClients.createDefault()){
			HttpPost httpPost = new HttpPost(request.url);
			
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("merchantId", request.merchantId));
			parameters.add(new BasicNameValuePair("projectId", request.projectId));
			parameters.add(new BasicNameValuePair("reference", request.reference));
			parameters.add(new BasicNameValuePair("hash", Security.hmacDigest(request.merchantId+request.projectId+request.reference,request.key)));
			
			httpPost.setEntity(new UrlEncodedFormEntity(parameters));
			CloseableHttpResponse response = client.execute(httpPost);

			String json = EntityUtils.toString(response.getEntity());
			
			if(!getHash(response).equals(Security.hmacDigest(json,request.key)))
				throw new RuntimeException("invalid hash");
						
			return new ObjectMapper().readValue(json, Response.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getHash(CloseableHttpResponse response) {
		return response.getHeaders("hash")[0].getValue();
	}
	
}
