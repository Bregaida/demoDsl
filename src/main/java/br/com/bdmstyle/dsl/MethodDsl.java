package br.com.bdmstyle.dsl;

import br.com.bdmstyle.client.HttpMethods;


public class MethodDsl extends Dsl{

	public MethodDsl(Context ctx) {
		context = ctx;
	}
	
	public RequestTypeDsl post(){
		context.httpMethod = HttpMethods.POST;
		return new RequestTypeDsl(context);
	}
	
	public void get(String url){
		//TODO
	}
	
	
	
	
	
	
}
