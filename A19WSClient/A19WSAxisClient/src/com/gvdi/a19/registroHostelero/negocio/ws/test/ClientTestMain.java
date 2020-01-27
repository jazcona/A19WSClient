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

	private static final String ALIAS = "a19preyneeds";
	private static final String PASSWORD = "ofitec";
	private static final String KEYSTORE = "etc/a19preyneeds2.jks";

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
			String base64File = "MXw0ODA1MDF8SE9URUwgUFJVRUJBfDIwMTkxMjIxfDIzNTh8MTF8CjJ8NjEzNjE4OTRYfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfMXxBcGVsbGlkbyAyXzF8Tm9tYnJlMXxNfDE5NzMwOTI0fEVzcGHDsWF8MjAxOTEyMjF8CjJ8OTY1NzM2MTFTfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfMnxBcGVsbGlkbyAyXzJ8Tm9tYnJlMnxNfDE5NjgwNTAxfEVzcGHDsWF8MjAxOTEyMjF8CjJ8MDExNzk0NTVTfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfM3xBcGVsbGlkbyAyXzN8Tm9tYnJlM3xNfDE5NzMwOTI0fEVzcGHDsWF8MjAxOTEyMjF8CjJ8ODUyODM0MjNLfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfNHxBcGVsbGlkbyAyXzR8Tm9tYnJlNHxNfDE5ODYwMTMxfEVzcGHDsWF8MjAxOTEyMjF8CjJ8MTIyNzQxMzJLfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfNXxBcGVsbGlkbyAyXzV8Tm9tYnJlNXxNfDE5NzMwOTI0fEVzcGHDsWF8MjAxOTEyMjF8CjJ8MDIzNjY1NTVRfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfNnxBcGVsbGlkbyAyXzZ8Tm9tYnJlNnxNfDE5ODYwMTMxfEVzcGHDsWF8MjAxOTEyMjF8CjJ8NTczMDUwNzhBfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfN3xBcGVsbGlkbyAyXzd8Tm9tYnJlN3xNfDE5NzMwOTI0fEVzcGHDsWF8MjAxOTEyMjF8CjJ8MDE1OTk5NTJBfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfOHxBcGVsbGlkbyAyXzh8Tm9tYnJlOHxNfDE5ODYwMTMxfEVzcGHDsWF8MjAxOTEyMjF8CjJ8NDkxNzk0OTVLfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfOXxBcGVsbGlkbyAyXzl8Tm9tYnJlOXxNfDE5NzMwOTI0fEVzcGHDsWF8MjAxOTEyMjF8CjJ8MDY5MDU4NjZSfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfMTB8QXBlbGxpZG8gMl8xMHxOb21icmUxMHxNfDE5ODYwMTMxfEVzcGHDsWF8MjAxOTEyMjF8CjJ8NjQ1Mzc2MzFFfHxEfDIwMTkwNjI2fEFwZWxsaWRvIDFfMTF8QXBlbGxpZG8gMl8xMXxOb21icmUxMXxNfDE5NzMwOTI0fEVzcGHDsWF8MjAxOTEyMjF8";
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
