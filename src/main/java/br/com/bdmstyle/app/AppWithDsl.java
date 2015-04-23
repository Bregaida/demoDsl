package br.com.bdmstyle.app;

import static br.com.bdmstyle.dsl.ClientDsl.send;
import br.com.bdmstyle.client.Response;



public class AppWithDsl {

	public static void main(String[] args) {
		
		Response response = send()
			.post()
			.textPlain()
			.to("https://payment.girosolution.de/girocheckout/api/v2/transaction/status")
				.withParameters()
				.merchantId("3612528")
				.projectId("12103")
				.reference("9dfbd5f1-6445-4dab-92db-3968642e9bae")
			.withKey("CumaVbB5xGac")
				.returning()
				.json()
				.as(Response.class);
			
		
		System.out.println(response);
		
	}
}
