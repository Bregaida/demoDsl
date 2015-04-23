package br.com.bdmstyle.dsl;

public class ToDsl extends Dsl {

	public ToDsl(Context ctx) {
		context = ctx;
	}

	public WithDsl to(String url) {
		context.url = url;
		return new WithDsl(context);
	}

}
