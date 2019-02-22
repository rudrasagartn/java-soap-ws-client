package com.webservice;

import static com.webservice.ISoapService.LOCAL_PART_NAME;
import static com.webservice.ISoapService.NAME_SPACE_URI;
import static com.webservice.ISoapService.WEB_SERVICE_URL;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.tempuri.CalculatorSoap;

@SuppressWarnings("restriction")
public class SoapWSClient {

	private CalculatorSoap calculatorSoap;

	public SoapWSClient() throws MalformedURLException {
		super();
		URL url = new URL(WEB_SERVICE_URL);
		QName qname = new QName(NAME_SPACE_URI, LOCAL_PART_NAME);
		Service service = Service.create(url, qname);
		calculatorSoap = service.getPort(CalculatorSoap.class);
	}

	public int add(int a, int b) {
		return calculatorSoap.add(a, b);
	}

	public int subtract(int a, int b) {
		return calculatorSoap.subtract(a, b);
	}

	public int multiply(int a, int b) {
		return calculatorSoap.multiply(a, b);
	}

	public int divide(int a, int b) {
		return calculatorSoap.divide(a, b);
	}
	
	public static void main(String[] args) throws MalformedURLException {
		int a = 4, b = 5;
		System.out.println("Addition of "+a+" with "+b+" --> "+ new SoapWSClient().add(a, b));
		System.out.println("Subtraction of "+b+" with "+a+" --> "+ new SoapWSClient().subtract(b, a));
		System.out.println("Multiplcation of "+a+" with "+b+" --> "+new SoapWSClient().multiply(a, b));
		System.out.println("Division of "+a+" with "+b+" --> "+new SoapWSClient().divide(a, b));
	}
}
