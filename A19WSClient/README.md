# Cliente de ejemplo AXIS para WS RegistroHostelero 

Este repositorio contiene un cliente java Axis para el WS https://servicios.pre.ertzaintza.eus/A19/registroHostelero/EnvioFichero.

## Instrucciones 🚀

1. Clona o descarga el repositorio
2. Importa el certificado del host servicios.pre.ertzaintza.eus en tu truststore (por defecto %JAVA_HOME%\jre\lib\security\cacerts)
3. Importa el proyecto A19WSClient en Eclipse
4. Ejecuta com.gvdi.a19.RegistroHostelero.negocio.ws.test.ClientTestMain

## Ejecutando las pruebas ⚙️

La ejecucion debe dar como resultado un AxisFault:
```javascript
faultActor: 
 faultNode: 
 faultDetail: 
	{java.io}string:weblogic.rmi.extensions.RemoteRuntimeException: Unexpected Exception
AlojadosException [code=-2,msg=2: - Fecha Entrada Inferior a un mes a la fecha actual.--3: - Fecha Entrada Inferior a un mes a la fecha actual.--4: - Fecha Entrada Inferior a un mes a la fecha actual.--5: - Fecha Entrada Inferior a un mes a la fecha actual.--6: - Fecha Entrada Inferior a un mes a la fecha actual.--7: - Fecha Entrada Inferior a un mes a la fecha actual.--8: - Fecha Entrada Inferior a un mes a la fecha actual.--9: - Fecha Entrada Inferior a un mes a la fecha actual.--10: - Fecha Entrada Inferior a un mes a la fecha actual.--11: - Fecha Entrada Inferior a un mes a la fecha actual.--12: - Fecha Entrada Inferior a un mes a la fecha actual.--]

```
Este error es normal y se corresponde con un error de validación de datos. Dado que el objetivo de este proyecto es realizar una peticion firmada correcta lo daremos por bueno.

## Autor ✒️

* **Javi Azcona** - *Desarrollo* - [jazcona](https://github.com/jazcona)
