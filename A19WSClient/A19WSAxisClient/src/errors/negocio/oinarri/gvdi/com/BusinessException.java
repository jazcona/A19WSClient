/**
 * BusinessException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package errors.negocio.oinarri.gvdi.com;

public class BusinessException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private java.lang.Object[] businessErrors;

    private java.lang.Object[] businessWarnings;

    public BusinessException() {
    }

    public BusinessException(
           java.lang.Object[] businessErrors,
           java.lang.Object[] businessWarnings) {
        this.businessErrors = businessErrors;
        this.businessWarnings = businessWarnings;
    }


    /**
     * Gets the businessErrors value for this BusinessException.
     * 
     * @return businessErrors
     */
    public java.lang.Object[] getBusinessErrors() {
        return businessErrors;
    }


    /**
     * Sets the businessErrors value for this BusinessException.
     * 
     * @param businessErrors
     */
    public void setBusinessErrors(java.lang.Object[] businessErrors) {
        this.businessErrors = businessErrors;
    }


    /**
     * Gets the businessWarnings value for this BusinessException.
     * 
     * @return businessWarnings
     */
    public java.lang.Object[] getBusinessWarnings() {
        return businessWarnings;
    }


    /**
     * Sets the businessWarnings value for this BusinessException.
     * 
     * @param businessWarnings
     */
    public void setBusinessWarnings(java.lang.Object[] businessWarnings) {
        this.businessWarnings = businessWarnings;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessException)) return false;
        BusinessException other = (BusinessException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessErrors==null && other.getBusinessErrors()==null) || 
             (this.businessErrors!=null &&
              java.util.Arrays.equals(this.businessErrors, other.getBusinessErrors()))) &&
            ((this.businessWarnings==null && other.getBusinessWarnings()==null) || 
             (this.businessWarnings!=null &&
              java.util.Arrays.equals(this.businessWarnings, other.getBusinessWarnings())));
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
        if (getBusinessErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinessErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinessErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBusinessWarnings() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinessWarnings());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinessWarnings(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusinessException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.gvdi.oinarri.negocio.errors", "BusinessException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.gvdi.oinarri.negocio.errors", "BusinessErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:java.util", "ArrayList"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessWarnings");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.gvdi.oinarri.negocio.errors", "BusinessWarnings"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:java.util", "ArrayList"));
        elemField.setNillable(true);
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
