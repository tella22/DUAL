
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* Esta clase es un ejemplo de uso de las clases FileInputStream y BufferedInputStream.
 * Vemos que podemos leer el contenido de un fichero y escribirlo por pantalla. 
 * FileInputStream define un origen de datos desde un fichero. 
 * BufferedInputStream se "monta" sobre el flujo de tipo FileInputStream
 * s�lo para modificar la forma de trabajar con el flujo, a�adi�ndole un Buffer. 
 * Un Buffer es una memoria intermedia, en la que se van escribiendo los datos desde el fichero hasta que se llena. 
 * La aplicaci�n retira(lee) los datos del buffer, en vez de leerlos desde el flujo asociado al fichero. Asi, se reduce 
 * el n�mero de accesos que la aplicaci�n debe hacer al fichero, y eso mejora la eficiencia del programa. Igualmente, cuando
 * se necesita leer un nuevo byte, si el Buffer del flujo est� vac�o, se lee desde fichero todo lo que quepa en el Buffer, en vez de 
 * leer s�lo el byte que necesito. As�, hasta que se agote de nuevo, la aplicaci�n leer� los datos de la memoria y no del fichero, que
 * siempre es m�s lento en comparaci�n con la velocidad de la CPU.
 * Observa que si eliminamos la creaci�n del objeto BufferedInputStream que hemos llamado flujoEntradaConBuffer, y realizamos exactamente 
 * las mismas operaciones directamente sobre el flujo FileInputStream llamado flujoEntrada, todo parece funcionar igual, y de hecho en este
 * ejemplo no es posible apreciar la diferencia. Si el fichero fuera mucho m�s grande y la aplicaci�n necesitara leerlo m�s de una vez entero,
 * s� se podr�a apreciar que la versi�n con BufferedInputStream es m�s eficiente. 
 */
public class EjemploFileInputStream {

	public static void main(String args[]) throws Exception
	  {
	    int tama�o;
	    /*Cualquier operaci�n de Entrada/Salida a ficheros puede generar una IOException, es decir, un error de Entrada/Salida. Puede ser,
	     * por ejemplo, que el fichero no exista, o que el dispositivo no funcione correctamente, o que nuestra aplicaci�n no tenga 
	     * permisos de lectura o escritura sobre el fichero en cuesti�n. Por eso, las sentencias que involucran operaciones sobre ficheros, 
	     * deben ir en un bloque try.
	     */
	    try{
	      /* Creamos un nuevo objeto File, que es la ruta hasta el fichero desde el que queremos leer. Usamos el propio fichero que contiene 
	       * a esta clase, y como ruta ponemos  el directorio Pruebas Java de la unidad C:. En este caso nos hemos preocupado de copiar ah�
	       * el fichero, pero en tu caso puedes usar otra ruta e incluso cualquier otro fichero. 
	       * F�jate en que tenemos que poner dos caracteres \ como separadores en la ruta,  para que no se interprete como un car�cter de 
	       * escape dentro de la cadena. 
	       */  
	      File f = new File("..\\EjemploFileOutputStream\\src\\EjemploFileOutputStream.java");
	      
	      /* Tambi�n podemos usar como separador en la ruta la barra normal, que es el separador usado en entornos Linux. Si sustituyes la 
	       * sentencia anterior por la siguiente, que aparece comentada, el resultado es el mismo. 
	       */
	      
	      //File f = new File("../EjemploFileOutputStream/src/EjemploFileOutputStream.java");

	      /* Construimos un flujo de tipo FileInputStream (un flujo de entrada desde fichero) sobre el objeto File. Es decir, estamos 
	       * conectando nuestra aplicaci�n a un extremo del flujo, por donde van a salir los datos, y "pidiendo" al Sistema Operativo 
	       * que conecte el otro extremo al fichero que indica el path establecido por el objeto File f que hab�amos creado antes. De 
	       * esta forma, el flujo recoger� los datos de ese fichero. 
	       */
	      FileInputStream flujoEntrada = new FileInputStream(f);
	      BufferedInputStream flujoEntradaConBuffer = new BufferedInputStream(flujoEntrada);
	            
	      /*Las tres sentencias anteriores pueden construirse en una s�la sentencia como la que se encuentra dentro de este comentario
	       
	        BufferedInputStream flujoEntradaConBuffer= new BufferedInputStream(
	                                                       new FileInputStream( 
	                                                       new File("..\\EjemploFileOutputStream\\src\\EjemploFileOutputStream.java")));
	       */
	      
	      /* Otra posibilidad es llamar a un constructor de FileInputStream que recibe como par�metro un String, de forma que el objeto File
	       * se cree de forma impl�cita a partir de ese String. 
	       
	       BufferedInputStream flujoEntradaConBuffer= new BufferedInputStream(
	                                                       new FileInputStream("..\\EjemploFileOutputStream\\src\\EjemploFileOutputStream.java"));
	       */
	      
	      /* Consultamos y escribimos el tama�o del fichero en bytes.*/
	      tama�o = flujoEntradaConBuffer.available();
	      System.out.println("Bytes disponibles: " + tama�o);
	      
	      /* Indicamos que vamos a intentar leer 50 bytes del fichero. */
	      System.out.println("Leyendo 50 bytes....");

	      /* Creamos un array de 50 bytes para llenarlo con los 50 bytes que leamos del flujo (realmente del fichero)*/ 
	      byte bytearray[] = new byte[50];
	      
	      /* El m�todo read() de la clase FileInputStream recibe como par�metro un array de byte, y lo llena leyendo bytes desde el flujo.
	       * Devuelve un n�mero entero, que es el n�mero de bytes que realmente se han le�do desde el flujo. Si el fichero tiene menos de 
	       * 50 bytes, no podr� leer los 50 bytes, y escribir� un mensaje indic�ndolo. 
	       */
	      if (flujoEntradaConBuffer.read(bytearray) != 50) {
	        System.out.println("No se pudieron leer 50 bytes");
	      }
	      /* Usamos un constructor adecuado de la clase String, que crea un nuevo String a partir de los bytes le�dos desde el flujo, que 
	       * se almacenaron en el array bytearray, y escribimos ese String. En definitiva, estamos escribiendo el texto que hemos le�do desde
	       * el fichero. 
	       */
	      System.out.println(new String(bytearray, 0, 50));

	      /* El m�todo skip() de la clase FileInputStream nos permite saltarnos un grupo de byte de los que van llegando desde el flujo. 
	       * En este caso, nos saltamos los siguientes 50 bytes.
	       */
	      System.out.println("Ignorando 50 bytes...");
	      flujoEntradaConBuffer.skip(50);

	      /* Volvemos a intentar leer otros 50 bytes desde el flujo de entrada. Si no quedan tantos, lo notificamos, y en cualquier caso
	       * escribimos lo que hemos le�do. 
	       */
	      System.out.println("Leyendo 50 bytes....");
	      if (flujoEntradaConBuffer.read(bytearray) != 50) {
	        System.out.println("No se pudieron leer 50 bytes");
	      }
	      System.out.println(new String(bytearray, 0, 50));

	      /* Finalmente cerramos el flujo.Es importante cerrar los flujos, para liberar ese recurso. Al cerrar el flujo, se comprueba que no 
	       haya quedado ning�n dato en el flujo sin que se haya le�do por la aplicaci�n. */
	      flujoEntradaConBuffer.close();
	     /* Capturamos la excepci�n de Entrada/Salida. El error que puede producirse en este caso es que el fichero no est� accesible, y
	      * es el mensaje que enviamos en tal caso. */ 
	    }catch (IOException e){
	             System.err.println("No se encuentra el fichero");
	    }
	  }

}
