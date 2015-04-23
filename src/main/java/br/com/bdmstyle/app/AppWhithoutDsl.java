package br.com.bdmstyle.app;

import br.com.bdmstyle.client.Client;
import br.com.bdmstyle.client.Request;



public class AppWhithoutDsl {

	public static void main(String[] args) {

		Request request = new Request();
		
		request.url = "https://payment.girosolution.de/girocheckout/api/v2/transaction/status";
		request.merchantId = "3612528";
		request.projectId = "12103";
		request.reference = "9dfbd5f1-6445-4dab-92db-3968642e9bae";
		request.key = "CumaVbB5xGac";
		
		Client clientWhithoutDsl = new Client();
	
		System.out.println(clientWhithoutDsl.execute(request));
		
	}
}
