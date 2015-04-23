package br.com.bdmstyle.dsl;

import br.com.bdmstyle.client.Client;
import br.com.bdmstyle.client.Request;
import br.com.bdmstyle.client.Response;


public class AsDsl extends Dsl {
	
	public AsDsl(Context ctx) {
		context = ctx;
	}
	
	@SuppressWarnings("rawtypes")
	public Response as(Class clazz){
		context.returnClass = clazz;

		Request request = new Request();
		
		request.url = context.url;
		request.merchantId = context.merchantId;
		request.projectId = context.projectId;
		request.reference = context.reference;
		request.key = context.key;
		return new Client().execute(request);
	}
	
}
