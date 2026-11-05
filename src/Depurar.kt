// Objeto con las funciones que piden y validan los datos del usuario
object Depurar {
    // Código ANSI para escribir en rojo en la consola
    val ROJO = "\u001B[31m"
    // Código ANSI para volver al color normal
    val RESET = "\u001B[0m"


    // Pide el nombre hasta que sea válido y lo devuelve
    fun depurarNombre () : String{
        // Patrón: solo letras, espacios y guiones
        var patron= Regex("""[\p{L}\s-]+""")
        // Variable donde guardamos lo que escribe el usuario
        var nombre = ""
        do{
            println("Escriba el nombre del contacto:")
            // Leemos el nombre y quitamos espacios sobrantes
            nombre=readln().trim()

            // Si no cumple el patrón avisamos del error en rojo
            if (!nombre.matches(patron)){
                println("$ROJO $nombre NO ES UN NOMBRE VALIDO, SOLO SE PERMITEN LETRAS, ESPACIOS Y GUIONES$RESET")
            }
        // Repetimos mientras el nombre no sea válido
        }while (!nombre.matches(patron))

        // Devolvemos el nombre ya validado
        return nombre

    }

    // Pide el email hasta que sea válido y lo devuelve
    fun depurarEmail() : String{
        // Patrón de un email con formato usuario@dominio.ext
        var patron= Regex("""^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$""")
        // Variable donde guardamos lo que escribe el usuario
        var email = ""
        do{
            println("Escriba el email del contacto (ej: email@email.com):")
            // Leemos el email y quitamos espacios sobrantes
            email=readln().trim()

            // Si no cumple el patrón avisamos del error en rojo
            if (!email.matches(patron)){
                println("$ROJO $email NO ES UN EMAIL VALIDO, MIRE EL EJEMPLO $RESET")
            }
        // Repetimos mientras el email no sea válido
        }while (!email.matches(patron))

        // Devolvemos el email ya validado
        return email

    }

    // Pide el teléfono hasta que sea válido y lo devuelve
    fun depurarTlf() : String {

        // Patrón: 9 dígitos y el primero tiene que ser un 6
        var patron= Regex("""^6\d{8}$""")
        // Variable donde guardamos lo que escribe el usuario
        var numero = ""
        do{
            println("Escriba el email del contacto (ej: 611111111):")
            // Leemos el número y quitamos espacios sobrantes
            numero=readln().trim()

            // Si no cumple el patrón avisamos del error en rojo
            if (!numero.matches(patron)){
                println("$ROJO $numero NO ES UN NUMERO DE TELEFONO VALIDO, MIRE EL EJEMPLO (Debe empezar por 6 y escribirlo todo junto) $RESET")
            }
        // Repetimos mientras el número no sea válido
        }while (!numero.matches(patron))

        // Devolvemos el teléfono ya validado
        return numero
    }
}
