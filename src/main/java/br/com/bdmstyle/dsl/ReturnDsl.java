package br.com.bdmstyle.dsl;

public class ReturnDsl extends Dsl {
	
	public ReturnDsl(Context ctx) {
		context = ctx;
	}
	
	public ResponseTypeDsl returning(){
		return new ResponseTypeDsl(context);
	}
	
}
