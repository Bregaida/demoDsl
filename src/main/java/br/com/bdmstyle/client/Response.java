package br.com.bdmstyle.client;

public class Response {

	public String reference,merchantTxId,backendTxId,amount,currency,resultPayment,resultAVS,rc,msg;

	@Override
	public String toString() {
		return "Result [reference=" + reference + ", merchantTxId="
				+ merchantTxId + ", backendTxId=" + backendTxId + ", amount="
				+ amount + ", currency=" + currency + ", resultPayment="
				+ resultPayment + ", resultAVS=" + resultAVS + ", rc=" + rc
				+ ", msg=" + msg + "]";
	}

}
