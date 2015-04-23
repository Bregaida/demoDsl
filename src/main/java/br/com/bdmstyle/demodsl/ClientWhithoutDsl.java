package br.com.bdmstyle.demodsl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientWhithoutDsl {

	public static void main(String[] args) {

		try (CloseableHttpClient client = HttpClients.createDefault()){
			HttpPost httpPost = new HttpPost("https://payment.girosolution.de/girocheckout/api/v2/transaction/status");
			
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("merchantId", "3612528"));
			parameters.add(new BasicNameValuePair("projectId", "12103"));
			parameters.add(new BasicNameValuePair("reference", "9dfbd5f1-6445-4dab-92db-3968642e9bae"));
			parameters.add(new BasicNameValuePair("hash", "0cba6d51dd37a290105dcf5d146a2cfd"));
			
			httpPost.setEntity(new UrlEncodedFormEntity(parameters));
			CloseableHttpResponse response = client.execute(httpPost);

			String json = EntityUtils.toString(response.getEntity());
			
			// print response
			System.out.println(response.getStatusLine());
			for(Header header:response.getAllHeaders()){
				System.out.println(header.getName() +" = "+header.getValue());
			}
			System.out.println(json);
			
			
			ObjectMapper mapper = new ObjectMapper();
			Result result = mapper.readValue(json, Result.class);
			
			Security.hmacDigest("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
