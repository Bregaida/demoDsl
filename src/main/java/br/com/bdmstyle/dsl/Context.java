package br.com.bdmstyle.dsl;

import br.com.bdmstyle.client.HttpMethods;
import br.com.bdmstyle.client.MimeTypes;

public class Context {

	public String merchantId,projectId,reference,key,url;
	public MimeTypes requestMimeType,responseMimeType;
	public HttpMethods httpMethod;
	@SuppressWarnings("rawtypes")
	public Class returnClass;
	
}
