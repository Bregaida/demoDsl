package br.com.bdmstyle.dsl;

import br.com.bdmstyle.client.MimeTypes;


public class RequestTypeDsl extends Dsl{

	public RequestTypeDsl(Context ctx) {
		context = ctx;
	}
	
	public ToDsl textPlain(){
		context.requestMimeType = MimeTypes.TEXTPLAIN;
		return new ToDsl(context);
	}
	
	public void json(){
		//todo
	}
	
	public void xml(){
		//todo
	}
	
	
	
}
