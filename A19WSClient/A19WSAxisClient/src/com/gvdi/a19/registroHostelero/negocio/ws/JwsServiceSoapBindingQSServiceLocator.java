/**
 * JwsServiceSoapBindingQSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.gvdi.a19.registroHostelero.negocio.ws;

public class JwsServiceSoapBindingQSServiceLocator extends org.apache.axis.client.Service implements com.gvdi.a19.registroHostelero.negocio.ws.JwsServiceSoapBindingQSService {

    public JwsServiceSoapBindingQSServiceLocator() {
    }


    public JwsServiceSoapBindingQSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public JwsServiceSoapBindingQSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for JwsServiceSoapBindingQSPort
    private java.lang.String JwsServiceSoapBindingQSPort_address = "http://osbcpre2.ejhspre.net:9810/Ertzaintza/ALOJADOS/A19/EnvioFichero";

    public java.lang.String getJwsServiceSoapBindingQSPortAddress() {
        return JwsServiceSoapBindingQSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String JwsServiceSoapBindingQSPortWSDDServiceName = "JwsServiceSoapBindingQSPort";

    public java.lang.String getJwsServiceSoapBindingQSPortWSDDServiceName() {
        return JwsServiceSoapBindingQSPortWSDDServiceName;
    }

    public void setJwsServiceSoapBindingQSPortWSDDServiceName(java.lang.String name) {
        JwsServiceSoapBindingQSPortWSDDServiceName = name;
    }

    public com.gvdi.a19.registroHostelero.negocio.ws.Jws getJwsServiceSoapBindingQSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(JwsServiceSoapBindingQSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getJwsServiceSoapBindingQSPort(endpoint);
    }

    public com.gvdi.a19.registroHostelero.negocio.ws.Jws getJwsServiceSoapBindingQSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gvdi.a19.registroHostelero.negocio.ws.JwsServiceSoapBindingStub _stub = new com.gvdi.a19.registroHostelero.negocio.ws.JwsServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getJwsServiceSoapBindingQSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setJwsServiceSoapBindingQSPortEndpointAddress(java.lang.String address) {
        JwsServiceSoapBindingQSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gvdi.a19.registroHostelero.negocio.ws.Jws.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gvdi.a19.registroHostelero.negocio.ws.JwsServiceSoapBindingStub _stub = new com.gvdi.a19.registroHostelero.negocio.ws.JwsServiceSoapBindingStub(new java.net.URL(JwsServiceSoapBindingQSPort_address), this);
                _stub.setPortName(getJwsServiceSoapBindingQSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("JwsServiceSoapBindingQSPort".equals(inputPortName)) {
            return getJwsServiceSoapBindingQSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://ws.negocio.registroHostelero.a19.gvdi.com", "JwsServiceSoapBindingQSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://ws.negocio.registroHostelero.a19.gvdi.com", "JwsServiceSoapBindingQSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("JwsServiceSoapBindingQSPort".equals(portName)) {
            setJwsServiceSoapBindingQSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
