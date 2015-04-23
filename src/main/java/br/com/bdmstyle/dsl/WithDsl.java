package br.com.bdmstyle.dsl;

public class WithDsl extends Dsl {

	public WithDsl(Context ctx) {
		context = ctx;
	}

	public MerchantDsl withParameters() {
		return new MerchantDsl(context);
	}

}
