package br.com.trescon.fmes.accsyncfail.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionUtilities {

	public static String extractPrintStackTrace(Exception e){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		StringBuilder sb = new StringBuilder();
		sb.append("/** ************************************************************************************ ").append("\n");
		sb.append("/** Exception occured at " + df.format(new Date())).append("\n");
		sb.append("/** ************************************************************************************ ").append("\n");
		sb.append("/** STACKTRACE { ").append("\n");
		sb.append("/** ").append("\n");
        sb.append(errors.toString()).append("\n");
		sb.append("/** ").append("\n");
		sb.append("/** }").append("\n");
		sb.append("/** ************************************************************************************ ");
		
		return sb.toString();
	}
	
}