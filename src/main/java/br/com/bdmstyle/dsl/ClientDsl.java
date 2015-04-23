package br.com.bdmstyle.dsl;


public class ClientDsl {
	
	public static MethodDsl send(){
		Context context = new Context();
		return new MethodDsl(context);
	}
	
}
