object Depurar {
    val ROJO = "\u001B[31m"
    val RESET = "\u001B[0m"


    fun depurarNombre () : String{
        var patron= Regex("""[\p{L}\s-]+""")
        var nombre = ""
        do{
            println("Escriba el nombre del contacto:")
            nombre=readln().trim()

            if (!nombre.matches(patron)){
                println("$ROJO $nombre NO ES UN NOMBRE VALIDO, SOLO SE PERMITEN LETRAS, ESPACIOS Y GUIONES$RESET")
            }
        }while (!nombre.matches(patron))

        return nombre

    }

    fun depurarEmail() : String{
        var patron= Regex("""^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$""")
        var email = ""
        do{
            println("Escriba el email del contacto (ej: email@email.com):")
            email=readln().trim()

            if (!email.matches(patron)){
                println("$ROJO $email NO ES UN EMAIL VALIDO, MIRE EL EJEMPLO $RESET")
            }
        }while (!email.matches(patron))

        return email

    }

    fun depurarTlf() : String {

        var patron= Regex("""^6\d{8}$""")
        var numero = ""
        do{
            println("Escriba el email del contacto (ej: 611111111):")
            numero=readln().trim()

            if (!numero.matches(patron)){
                println("$ROJO $numero NO ES UN NUMERO DE TELEFONO VALIDO, MIRE EL EJEMPLO (Debe empezar por 6 y escribirlo todo junto) $RESET")
            }
        }while (!numero.matches(patron))

        return numero
    }
}