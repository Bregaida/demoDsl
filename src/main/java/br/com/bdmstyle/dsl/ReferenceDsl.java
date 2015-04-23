package br.com.bdmstyle.dsl;

public class ReferenceDsl extends Dsl{
	
	public ReferenceDsl(Context ctx) {
		this.context = ctx;
	}
	
	public KeyDsl reference(String reference){
		context.reference = reference;
		return new KeyDsl(context);
	}
	
}
