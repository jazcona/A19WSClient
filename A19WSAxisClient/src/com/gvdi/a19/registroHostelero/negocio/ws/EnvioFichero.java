/**
 * EnvioFichero.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.gvdi.a19.registroHostelero.negocio.ws;

public class EnvioFichero  implements java.io.Serializable {
    private java.lang.String fichero;
    private java.lang.String language;
    private java.lang.String nombreFichero;

    public EnvioFichero() {
    }

    public EnvioFichero(
           java.lang.String fichero,
           java.lang.String language,
           java.lang.String nombreFichero) {
           this.fichero = fichero;
           this.language = language;
           this.nombreFichero = nombreFichero;
    }


    /**
     * Gets the fichero value for this EnvioFichero.
     * 
     * @return fichero
     */
    public java.lang.String getFichero() {
        return fichero;
    }


    /**
     * Sets the fichero value for this EnvioFichero.
     * 
     * @param fichero
     */
    public void setFichero(java.lang.String fichero) {
        this.fichero = fichero;
    }


    /**
     * Gets the language value for this EnvioFichero.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this EnvioFichero.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the nombreFichero value for this EnvioFichero.
     * 
     * @return nombreFichero
     */
    public java.lang.String getNombreFichero() {
        return nombreFichero;
    }


    /**
     * Sets the nombreFichero value for this EnvioFichero.
     * 
     * @param nombreFichero
     */
    public void setNombreFichero(java.lang.String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnvioFichero)) return false;
        EnvioFichero other = (EnvioFichero) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fichero==null && other.getFichero()==null) || 
             (this.fichero!=null &&
              this.fichero.equals(other.getFichero()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.nombreFichero==null && other.getNombreFichero()==null) || 
             (this.nombreFichero!=null &&
              this.nombreFichero.equals(other.getNombreFichero())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFichero() != null) {
            _hashCode += getFichero().hashCode();
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getNombreFichero() != null) {
            _hashCode += getNombreFichero().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnvioFichero.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://ws.negocio.registroHostelero.a19.gvdi.com", ">envioFichero"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fichero");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.negocio.registroHostelero.a19.gvdi.com", "fichero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.negocio.registroHostelero.a19.gvdi.com", "language"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFichero");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.negocio.registroHostelero.a19.gvdi.com", "nombreFichero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
