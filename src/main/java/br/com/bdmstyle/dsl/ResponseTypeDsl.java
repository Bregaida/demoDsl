package br.com.bdmstyle.dsl;


public class ResponseTypeDsl extends Dsl{

	public ResponseTypeDsl(Context ctx) {
		context = ctx;
	}
	
	public void textPlain(){
		//todo
	}
	
	public AsDsl json(){
		return new AsDsl(context);
	}
	
	public void xml(){
		//todo
	}
	
	
	
}
