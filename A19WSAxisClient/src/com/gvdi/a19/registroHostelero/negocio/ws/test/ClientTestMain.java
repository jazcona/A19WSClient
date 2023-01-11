/**
 * 
 */
package com.gvdi.a19.registroHostelero.negocio.ws.test;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.xml.rpc.Stub;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;
import org.apache.log4j.PropertyConfigurator;

import com.gvdi.a19.registroHostelero.negocio.ws.EnvioFichero;
import com.gvdi.a19.registroHostelero.negocio.ws.EnvioFicheroResponse;
import com.gvdi.a19.registroHostelero.negocio.ws.Jws;
import com.gvdi.a19.registroHostelero.negocio.ws.JwsServiceSoapBindingQSServiceLocator;

import errors.negocio.oinarri.gvdi.com.BusinessException;

/**
 * The Class ClientTestMain.
 */
public class ClientTestMain {

//	private static final String ENDPOINT = "http://osbcdesa1.ejhsdes.net:9810/Ertzaintza/ALOJADOS/A19/EnvioFichero";
	private static final String ENDPOINT = "https://servicios.pre.ertzaintza.eus/A19/registroHostelero/EnvioFichero";

	private static final String WSDD_PATH = "etc/client_deploy.wsdd";

	private static final String ALIAS = "a19preempresa";
	private static final String PASSWORD = "1";
	private static final String KEYSTORE = "etc/a19preempresa.jks";

	/**
	 * Instantiates a new client test main.
	 */
	public ClientTestMain() {
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			/*Descomentar para indicar un trustStore distinto a cacerts "EtzPre.crt ha de estar en nuestro trustStore"*/
//			System.setProperty("javax.net.ssl.trustStore", TRUSTSTORE);
//			System.setProperty("javax.net.ssl.trustStorePassword", TRUSTSTOREPASSWORD);
//			System.setProperty("javax.net.ssl.trustStoreType", "JKS");

			//Debug ssl
			System.setProperty("javax.net.debug", "all");
			
			//Si necesitamos definir un proxy
//			System.setProperty("socksProxyHost", "127.0.0.1");
//			System.setProperty("socksProxyPort", "3130");

			configureLogging();

			new ClientTestMain().enviarFicheroWS();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure logging.
	 */
	public static void configureLogging() {
		Properties p = new Properties();
		p.put("log4j.rootLogger", "INFO, A1");
		p.put("log4j.appender.A1", "org.apache.log4j.ConsoleAppender");
		p.put("log4j.appender.A1.layout", "org.apache.log4j.PatternLayout");
		p.put("log4j.appender.A1.layout.ConversionPattern", "%-4r [%t] %-5p %c %x - %m%n");
		PropertyConfigurator.configure(p);
	}


	public Jws getA19RegistroHosteleroService() throws Exception {
		EngineConfiguration config = new FileProvider(WSDD_PATH);
		JwsServiceSoapBindingQSServiceLocator locator = new JwsServiceSoapBindingQSServiceLocator(config);
		Jws service = (Jws) locator.getJwsServiceSoapBindingQSPort();
		configureStub((Stub) service);
		((Stub) service)._setProperty(Stub.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT);
		return service;
	}
	
	/**
	 * Configure stub.
	 *
	 * @param service
	 *            the service
	 */
	private void configureStub(Stub service) {

		Properties propertiesCert = new Properties();
		propertiesCert.put("org.apache.ws.security.crypto.provider", "org.apache.ws.security.components.crypto.Merlin");
		propertiesCert.put("org.apache.ws.security.crypto.merlin.keystore.type", "JKS");
		propertiesCert.put("org.apache.ws.security.crypto.merlin.file", KEYSTORE);
		propertiesCert.put("org.apache.ws.security.crypto.merlin.keystore.password", PASSWORD);

		service._setProperty("KEY_CRYPTO_PROPERTIES", propertiesCert);
		service._setProperty("action", "Timestamp Signature");
		service._setProperty("SignaturePropRefId", "KEY_CRYPTO_PROPERTIES");
		service._setProperty("signatureKeyIdentifier", "DirectReference");
		service._setProperty("user", ALIAS);
		service._setProperty("passwordCallbackRef", new PWCallback(PASSWORD));
		service._setProperty(org.apache.axis.client.Call.CHECK_MUST_UNDERSTAND, Boolean.FALSE);
	}

	/**
	 * Consultar censo.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void enviarFicheroWS() throws Exception {
		try {
			Jws ws = getA19RegistroHosteleroService();
			String base64File = "MXw0ODAzNjV8SE9URUwgUFJVRUJBfDIwMjMwMTAxfDIzNTh8MTF8DQoyfDYxMzYxODk0WHx8RHwyMDE1MDYyNnxBcGVsbGlkbyAxXzF8QXBlbGxpZG8gMl8xfE5vbWJyZTF8TXwxOTczMDkyNHxFc3Bhw7FhfDIwMTYwMjIyfA0KMnw5NjU3MzYxMVN8fER8MjAxNTA2MjZ8QXBlbGxpZG8gMV8yfEFwZWxsaWRvIDJfMnxOb21icmUyfE18MTk2ODA1MDF8RXNwYcOxYXwyMDE2MDIyMnwNCjJ8MDExNzk0NTVTfHxEfDIwMTUwNjI2fEFwZWxsaWRvIDFfM3xBcGVsbGlkbyAyXzN8Tm9tYnJlM3xNfDE5NzMwOTI0fEVzcGHDsWF8MjAxNjAyMjJ8DQoyfDg1MjgzNDIzS3x8RHwyMDE1MDYyNnxBcGVsbGlkbyAxXzR8QXBlbGxpZG8gMl80fE5vbWJyZTR8TXwxOTg2MDEzMXxFc3Bhw7FhfDIwMTYwMjIyfA0KMnwxMjI3NDEzMkt8fER8MjAxNTA2MjZ8QXBlbGxpZG8gMV81fEFwZWxsaWRvIDJfNXxOb21icmU1fE18MTk3MzA5MjR8RXNwYcOxYXwyMDE2MDIyMnwNCjJ8MDIzNjY1NTVRfHxEfDIwMTUwNjI2fEFwZWxsaWRvIDFfNnxBcGVsbGlkbyAyXzZ8Tm9tYnJlNnxNfDE5ODYwMTMxfEVzcGHDsWF8MjAxNjAyMjJ8DQoyfDU3MzA1MDc4QXx8RHwyMDE1MDYyNnxBcGVsbGlkbyAxXzd8QXBlbGxpZG8gMl83fE5vbWJyZTd8TXwxOTczMDkyNHxFc3Bhw7FhfDIwMTYwMjIyfA0KMnwwMTU5OTk1MkF8fER8MjAxNTA2MjZ8QXBlbGxpZG8gMV84fEFwZWxsaWRvIDJfOHxOb21icmU4fE18MTk4NjAxMzF8RXNwYcOxYXwyMDE2MDIyMnwNCjJ8NDkxNzk0OTVLfHxEfDIwMTUwNjI2fEFwZWxsaWRvIDFfOXxBcGVsbGlkbyAyXzl8Tm9tYnJlOXxNfDE5NzMwOTI0fEVzcGHDsWF8MjAxNjAyMjJ8DQoyfDA2OTA1ODY2Unx8RHwyMDE1MDYyNnxBcGVsbGlkbyAxXzEwfEFwZWxsaWRvIDJfMTB8Tm9tYnJlMTB8TXwxOTg2MDEzMXxFc3Bhw7FhfDIwMTYwMjIyfA0KMnw2NDUzNzYzMUV8fER8MjAxNTA2MjZ8QXBlbGxpZG8gMV8xMXxBcGVsbGlkbyAyXzExfE5vbWJyZTExfE18MTk3MzA5MjR8RXNwYcOxYXwyMDE2MDIyMnw=";
			EnvioFichero ef = new EnvioFichero(base64File, "es", "480501.010");
			EnvioFicheroResponse response = ws.envioFichero(ef);
			System.out.println("Respuesta obtenida: " + response.get_return());
		} catch (BusinessException be) {
			be.printStackTrace();
			if (be.getBusinessErrors() != null) {
				String error = be.getBusinessErrors()[0] != null ? be.getBusinessErrors()[0].toString().trim() : "ERROR_GENERICO";
				System.out.println(error);
			} else {
				System.out.println("ERROR_GENERICO");
			}
		} catch (RemoteException re) {
			re.printStackTrace();
			System.out.println("ERROR_GENERICO");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR_GENERICO");
		}

		System.out.println("# fin");

	}
}
