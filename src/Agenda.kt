// Importamos las funciones de validación para usarlas directamente
import Depurar.depurarEmail
import Depurar.depurarNombre
import Depurar.depurarTlf
// Objeto que gestiona la agenda y su menú
object Agenda {

    // Función que muestra el menú y ejecuta la opción elegida
    fun menuPrincipal () {
        // Lista mutable donde se guardan todos los contactos
        val agenda = mutableListOf<Contacto>();
        var salirValido : Boolean = false; //Para cuando quiere salir del programa

        // Bucle principal: se repite hasta que el usuario elige salir
        while (!salirValido) {
            pintarMenu(); //Pintamos el menu en cada vuelta
            val opcion = readln(); //leemos como un string para ahorrarnos un try catch
            // Según la opción elegida hacemos una cosa u otra
            when (opcion) {
                // Opción 1: añadir un contacto
                "1" -> {
                    // Pedimos y validamos cada dato
                    var nombre = depurarNombre();
                    var email = depurarEmail();
                    var tlf = depurarTlf();

                    // Creamos el contacto y lo guardamos en la lista
                    agenda.add(Contacto(nombre, email, tlf));
                    println("Contacto añadido correctamente!");
                }

                // Opción 2: listar todos los contactos
                "2" -> {
                    // Si no hay contactos avisamos al usuario
                    if (agenda.isEmpty()){
                        println("La agenda esta vacia, no se puede muestrar ningun resultado")
                    }else{
                        // Ordenamos la lista alfabéticamente por nombre
                        agenda.sortBy { it.nombre }
                        // Mostramos cada contacto en una línea
                        agenda.forEach {
                            println("Nombre: ${it.nombre} - Teléfono: ${it.telefono} - Email: ${it.email}")

                        }
                    }
                }

                // Opción 3: buscar contactos por nombre
                "3" -> {
                    var buscar = ""
                    // Pedimos el texto a buscar hasta que no esté vacío
                    do {
                        println("Escriba el nombre del contacto para buscar:")
                        // Pasamos a minúsculas y quitamos espacios sobrantes
                        buscar = readln().trim().lowercase()
                        if (buscar.isEmpty()){
                            println("No puede estar vacio")
                        }
                    }while(buscar.isEmpty())
                    // Mostramos los contactos cuyo nombre contiene el texto buscado
                    agenda.forEach {
                        if(buscar in it.nombre){
                            println("Nombre: ${it.nombre} - Teléfono: ${it.telefono} - Email: ${it.email}")
                        }
                    }
                }

                // Opción 4: eliminar contactos por nombre
                "4" -> {
                    var buscar = ""
                    // Pedimos el texto a buscar hasta que no esté vacío
                    do {
                        println("Escriba el nombre del contacto para buscar:")
                        // Pasamos a minúsculas y quitamos espacios sobrantes
                        buscar = readln().trim().lowercase()
                        if (buscar.isEmpty()){
                            println("No puede estar vacio")
                        }
                    }while(buscar.isEmpty())
                    // Borramos de la lista los contactos cuyo nombre contiene el texto
                    agenda.forEach {
                        if(buscar in it.nombre){
                            agenda.remove(it)
                        }
                    }
                }

                // Opción 0: salir del programa
                "0" -> {
                    println("Saliendo del programa...")
                    // Cambiamos la bandera para que termine el bucle
                    salirValido = true;
                }
                else -> println("${Depurar.ROJO} Error: opción no válida. ${Depurar.RESET}") //Para el resto de opciones no reconocidas
            }
        }

    }

    // Muestra por pantalla las opciones del menú
    fun pintarMenu () {  //Pintamos el menu
        println("===== AGENDA DE CONTACTOS =====\n" +
                "1. Añadir contacto\n" +
                "2. Listar contactos\n" +
                "3. Buscar contacto\n" +
                "4. Eliminar contacto\n" +
                "0. Salir\n" +
                "Seleccione una opción:")
    }

}
