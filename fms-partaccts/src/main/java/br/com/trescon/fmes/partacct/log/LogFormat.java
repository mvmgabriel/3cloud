package br.com.trescon.fmes.partacct.log;

public class LogFormat {

	public static String print(String text, String traceId, String spanId) {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(traceId).append("]");
		sb.append("[").append(spanId).append("]");
		sb.append(" ").append(text);
		return sb.toString();
	}
	
}
