package com.gvdi.a19.registroHostelero.negocio.ws.test;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class PWCallback implements CallbackHandler {
	 private String password;

	 public PWCallback(String password)
	    {
	        this.password = null;
	        this.password = password;
	    }

	    public void handle(Callback callbacks[])
	        throws IOException, UnsupportedCallbackException
	    {
	        for(int i = 0; i < callbacks.length; i++)
	            if(callbacks[i] instanceof WSPasswordCallback)
	            {
	                WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
	                pc.setPassword(password);
	            } else
	            {
	                throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
	            }

	    }

}
