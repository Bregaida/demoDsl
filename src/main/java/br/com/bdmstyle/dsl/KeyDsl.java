package br.com.bdmstyle.dsl;

public class KeyDsl extends Dsl {
	
	public KeyDsl(Context ctx) {
		context = ctx;
	}
	
	public ReturnDsl withKey(String key){
		context.key = key;
		return new ReturnDsl(context);
	}
	
}
