# Cliente de ejemplo AXIS para WS ALQVEHICULOS 

Este repositorio contiene un cliente java Axis para el WS https://servicios.pre.ertzaintza.eus/Ertzaintza/ALQVEHICULOS/A58/v2/EnvioFichero.

## Instrucciones 🚀

1. Clona o descarga el repositorio
2. Importa el certificado del host servicios.pre.ertzaintza.eus en tu truststore (por defecto %JAVA_HOME%\jre\lib\security\cacerts)
3. Importa el proyecto A58WSClient en Eclipse
4. Ejecuta com.gvdi.a58.alquilerVehiculos.negocio.ws.test.ClientTestMain

## Ejecutando las pruebas ⚙️

El XML con los datos a de los alquileres a comunicar se encuentra definido en el fichero _ws.properties_ en la propiedad _ws.cdataXML_.
La ejecucion debe dar como resultado:
```javascript
Respuesta obtenida
NumRegistros: 0
CodError: ERR_007
DescEs: Código sede alquiler no corresponde a una sede activa de la empresa
DescEu: Alokatze egoitzaren kodea ez dator bat enpresaren egoitza aktibo batekin
```
Este error es normal y se corresponde con un error de validación debido a que el código de la sede de entrega no se corresponde con ninguno de los códigos de la empresa. Dado que el objetivo de este proyecto es realizar una peticion firmada correcta lo daremos por bueno.

## Autor ✒️

* **Javi Azcona** - *Desarrollo* - [jazcona](https://github.com/jazcona)
