Un archivo CSV (Comma Separated Values , valores separados por comas) es un archivo de texto que tiene un formato específico que permite manejar una gran cantidad de datos en formato tabla. Es tremendamente sencillo generar una tabla a partir de un documento de texto, con tan solo delimitar cada celda requerida con un carácter delimitador típico (punto y coma, coma, tabulador, etc.). Estos archivos también se utilizan para trasvasar información entre sistemas informáticos. Un ejemplo de ello es la migración de datos de cuentas Google, buzones de correo, etc.

Crea un proyecto nuevo llamada Tarea7A+tunombre.

Abre el fichero adjunto, estudia su contenido (datos de ejemplo inventados) y crea una clase Java (POJO) para guardar los registros del fichero adjunto. Recuerda que una clase POJO es aquella que contiene como mínimo los atributos encapsulados, getters, setters y toString. Estas clases no suelen implementar constructor parametrizado, aunque se puede incluir.

Crea una clase que contenga el método main() y gestione la lectura del fichero adjunto. Si la lectura falla usando Scanner, puedes abrir el fichero adjunto usando la clase BufferedReader, según figura en los apuntes de clase. Ten en cuenta que la codificación que ha usado el sistema Séneca para exportar el fichero ha sido ISO-8859-1. Conforme se vaya leyendo el fichero, carga los registros en una lista de objetos.

Muestra por consola la lista obtenida a partir del fichero, así como el total de profesores existentes en el fichero.

Genera un map para almacenar cuantos profesores hay por cada departamento diferente. Vuelca esta información en otro fichero CSV, llamado "profesoresPorDepartamento.csv", separando los campos con un tabulador.


Guarda en otro fichero CSV los registros de aquellos empleados que hayan trabajado más de 100 días en el curso 20/21. Ten en cuenta que si la fecha de cese está vacía significa que el empleado está en servicio activo.

Las lecturas y escrituras de los ficheros se realizan de forma relativa a la carpeta raíz del proyecto Java. Cuanto más modularizado esté todo mejor.# practica71_Imad
Además incluye una clase, llamada Utils, con los siguientes métodos de clase:
A partir de una lista de empleados y un nombre, indique si hay algún empleado con ese nombre.
A partir de una lista de empleados y un nombre de departamento, indique el número de empleados Coordinadores de ese departamento.
A partir de una lista de empleados y una letra del NIF (char), obtener una nueva lista ordenada alfabéticamente SOLO con los apellidos de los empleados cuyo NIF contenga esa letra.
A partir de una lista de empleados y una fecha, obtener una nueva lista con los NIF (ordenados de forma inversa) de todos los empleados cuya toma de posesión coincida con esa fecha.
En una clase con el método main(), prueba los métodos anteriores.
