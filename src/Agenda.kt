import Depurar.depurarEmail
import Depurar.depurarNombre
import Depurar.depurarTlf
object Agenda {

    fun menuPrincipal () {
        val agenda = mutableListOf<Contacto>();
        var salirValido : Boolean = false; //Para cuando quiere salir del programa

        while (!salirValido) {
            pintarMenu(); //Pintamos el menu en cada vuelta
            val opcion = readln(); //leemos como un string para ahorrarnos un try catch
            when (opcion) {
                "1" -> {
                    var nombre = depurarNombre();
                    var email = depurarEmail();
                    var tlf = depurarTlf();

                    agenda.add(Contacto(nombre, email, tlf));
                    println("Contacto añadido correctamente!");
                }

                "2" -> {
                    if (agenda.isEmpty()){
                        println("La agenda esta vacia, no se puede muestrar ningun resultado")
                    }else{
                        agenda.sortBy { it.nombre }
                        agenda.forEach {
                            println("Nombre: ${it.nombre} - Teléfono: ${it.telefono} - Email: ${it.email}")

                        }
                    }
                }

                "3" -> {
                    var buscar = ""
                    do {
                        println("Escriba el nombre del contacto para buscar:")
                        buscar = readln().trim().lowercase()
                        if (buscar.isEmpty()){
                            println("No puede estar vacio")
                        }
                    }while(buscar.isEmpty())
                    agenda.forEach {
                        if(buscar in it.nombre){
                            println("Nombre: ${it.nombre} - Teléfono: ${it.telefono} - Email: ${it.email}")
                        }
                    }
                }

                "4" -> {
                    var buscar = ""
                    do {
                        println("Escriba el nombre del contacto para buscar:")
                        buscar = readln().trim().lowercase()
                        if (buscar.isEmpty()){
                            println("No puede estar vacio")
                        }
                    }while(buscar.isEmpty())
                    agenda.forEach {
                        if(buscar in it.nombre){
                            agenda.remove(it)
                        }
                    }
                }

                "0" -> {
                    println("Saliendo del programa...")
                    salirValido = true;
                }
                else -> println("${Depurar.ROJO} Error: opción no válida. ${Depurar.RESET}") //Para el resto de opciones no reconocidas
            }
        }

    }

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