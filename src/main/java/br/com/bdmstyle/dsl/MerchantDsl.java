package br.com.bdmstyle.dsl;

public class MerchantDsl extends Dsl{
	
	public MerchantDsl(Context ctx) {
		this.context = ctx;
	}
	
	public ProjectDsl merchantId(String merchantId){
		context.merchantId = merchantId;
		return new ProjectDsl(context);
	}
	
}
