import java.util.*
import kotlin.Exception
import kotlin.NullPointerException

const val PI = 3.1416
fun main(args: Array<String>) {
    /*
    println("Hello World!")
    var dinero: Int = 10
    println(dinero)
    dinero = 5
    println(dinero)
    val nombre = "Orazio"
    println(nombre)
    println(PI)

    //Tipos de datos
    val bool: Boolean = true
    val numeroLargo: Long = 2143254651354231654L
    val doubleNumber: Double = 46843214684.143514
    val floatNumber: Float = 213.1684f
    val shortNumber: Short = 1
    val apellido = "Cappadonna"
    val nombreCompleto = "Mi nombre es $nombre $apellido" // Esto es un template, es como usar fstring en python
    println(nombreCompleto)
    */
    val nombre = "Orazio"
    if (nombre.isNotEmpty()) {
        println("El largo de nuestra variable nombre es ${nombre.length}")
    } else {
        println("La variable nombre esta vacia")
    }

    var message = if (nombre.equals("Joe")) "Hello $nombre" else "I don't Know you" // Esto seria como hacer un if de una linea, casi como un operador ternario

    // Esta seria la forma mas "clasica" o normal de hacerlo
    /*val mensaje: String
    if (nombre.length > 4){
        mensaje = "Tu nombre es largo"
    } else {
        mensaje = "Tu nombre es corto"
    }*/

    // Pero en Kotlin se puede hacer de esta manera, asi no hay que estar declarando la variable antes ni asignandola
    // directamente en cada parte de la condicion
    val mensaje: String = if (nombre.isEmpty()){
        "La variable nombre esta vacia"
    } else if (nombre.length > 4){
        "Tu nombre es largo"
    } else {
        "Tu nombre es corto"
    }

    println(mensaje)

    condicionalWhen()

    ciclosWhileYDoWhile()

    cicloFor()

    nullTryCatch()

    listasEnKotlin()

    ordenListas()

    usoDeMaps()

    usoDeSets()

    val frase = "En platzi nunca paramos de aprender"
    val fraseOrdenada = ejemploFuncion(frase)
    println(fraseOrdenada)
    //println(ejemploFuncion(frase))

    println("Esto es una frase aaaa".funcionExtension())

    usoDeLambdas()

    usoHighOrderFunctions()

    usoDeLet()

    usoDeWith()

    usoDeRun()

    usoDeApply()

    usoDeAlso()

}


/**
 * Esta estructura de control es, basicamente, un switch en otros lenguajes
 */
fun condicionalWhen(){

    //val nombreColor = "Amarillo
    println()
    println()
    println()
    println("###### Seccion del condicional When ######")
    when (val nombreColor = "Azul") { // De esta forma estamos declarando e inicializando la variable directo en el when
        "Amarillo" -> println("El $nombreColor es el color de la alegria")
        "Rojo", "Carmesi" -> println("El $nombreColor simboliza el calor")
        "Verde" -> println("El $nombreColor es el color de la naturaleza")
        else -> println("En este momento no podemos encontrar que simboliza el color $nombreColor")
    }

    /*
    * val pais = "Argentina"

        when(pais) {
            "Argentina" -> {
                println("El idioma de ${pais} es Español");
            } "Alemania" -> {
                println("El idioma de ${pais} es Aleman");
            } "EEUU" -> {
                println("El idioma de ${pais} es Ingles");
            } "Brasil" -> {
                println("El idioma de ${pais} es Portugues");
            } else -> {
                println("No conocemos el idioma");
            }
        }
    * */

    // Ejemplo de como usar rangos con numeros
    /*
    * val edad = 33;

        when(edad) {
            in 0..3 -> {
                println("Tu edad es ${edad} eres un bebe");
            } in 4..11 -> {
                println("Tu edad es ${edad} eres un niño");
            } in 12..18 -> {
                println("Tu edad es ${edad} eres un adolecente");
            } in 19..59 -> {
                println("Tu edad es ${edad} eres un adulto");
            } in 60..99 -> {
                println("Tu edad es ${edad} eres un adulto mayor");
            } else -> {
                println("😲");
            }
    * */
    when (val code = 500) {
        in 200..299 -> println("Todo ha ido bien, codigo: $code")
        in 300..399 -> println("Algo ha fallado, codigo: $code")
        else -> println("El codigo es desconocido (codigo: $code)")
    }
    //println(code) Fuera del when no podria usar la variable code porque estaria fuera del scope

    val tallaZapatos = 46
    val mensaje = when (tallaZapatos) {
        41, 43 -> "Tenemos disponibles zapatos de la talla $tallaZapatos"
        42, 44 -> "Los zapatos de talla $tallaZapatos estan casi agotados"
        45 -> "Queda un ultimo par de la talla $tallaZapatos"
        else -> "La talla $tallaZapatos esta agotada"
    }
    println(mensaje)
}

/**
 * Ciclos While y Do While
 */
fun ciclosWhileYDoWhile() {
    println()
    println()
    println()
    println("###### Seccion de los bucles While y Do While ######")

    println("Bucle While con contador")
    var contador = 0
    while (contador < 10) {
        println("Contador = $contador")
        contador++
    }

    println("Bucle Do While")
    println()
    do {
        println("Generando numero aleatorio")
        val numeroAleatorio = (0..100).random() // Forma de generar un numero entero aleatorio entre 0 y 100, ta cool
        println("El numero aleatorio es $numeroAleatorio")
    } while (numeroAleatorio > 50)
    println()
    println("Ciclo Do While terminado")
}

/**
 * Uso de ciclo For, ForEach y algunas Lambdas
 */
fun cicloFor() {

    println()
    println()
    println()
    println("###### Seccion del bucle for ######")

    val listaDeFrutas = listOf("Manzana", "Pera", "Frambuesa", "Durazno")
    println(listaDeFrutas)
    for (fruta in listaDeFrutas) println("Fruta llamada $fruta") // Se puede tambien hacer el for de una linea de esta manera o con las llaves como la forma clasica

    println()
    println()

    println("Uso de forEach con funcion anonima (Lambda)")
    listaDeFrutas.forEach { fruta -> println("Me comere una fruta llamada $fruta") } //Este forEach con las llaves asi es una funcion anonima

    // A continuacion el uso de map
    val caracteresFrutas = listaDeFrutas.map { fruta -> fruta.length }
    println("La lista de los caracteres de frutas es $caracteresFrutas")

    // A continuacion el uso de filter
    val listaFiltrada = caracteresFrutas.filter { caracteresDeFruta -> caracteresDeFruta > 5 }
    println("Lista filtrada: $listaFiltrada")
}

/**
 * Manejo de null y de errores en kotlin con try - catch
 */
fun nullTryCatch() {
    println()
    println()
    println()
    println("###### Seccion del manejo de null y errores con try - catch ######")

    var nombre: String? = null
    //nombre!!.length      Esto claramente va a fallar porque nombre es null, a continuacion la forma segura de hacerlo
    println(nombre?.length) // Esto es una safe-call y va a imprimir directamente "null"

    try {
        nombre!!.length
    } catch (excepcion: NullPointerException) {
        println("Ha ocurrido un error")
    } finally {
        println("Se cerrara la aplicacion")
    }

    println()

    try {
        throw NullPointerException("Referencia nula")
    } catch (excepcion: NullPointerException) {
        println(excepcion)
    } finally {
        println("Se cerrara la aplicacion")
    }

    println()

    // Prueba de try catch
    val primerValor = 10
    val segundoValor = 0
    //val resultado: Int = try { primerValor / segundoValor } catch (error: Exception) { 0 }
    val resultado = try {
        primerValor / segundoValor
    } catch (e: Exception) {
        println(e)
        0
    }
    println(resultado)

    println()
    //Operador Elvis, asignar por defecto una valor a una variable nula
    val nombre2: String? = null
    val caracteresNombre: Int = nombre2?.length ?: 0      // El operador Elvis es ?: y siempre que el valor sea nulo, lo asignara
    println("El nombre tiene $caracteresNombre caracteres")

}

/**
 * Manejo de listas en Kotlin
 */
fun listasEnKotlin() {
    println()
    println()
    println()
    println("###### Seccion de las listas en kotlin ######")

    /*
    * Las listas pertenecen a las familias de las collections, las cuales pueden ser de 2 tipos:
    *
    * Listas mutables:
    * Listas inmutables: Estas son las que no pueden tener elementos modificados, es decir, una vez que se agreguen elementos a estas listas
    * no pueden ser modificados ni eliminados
    * */

    // Lista inmutable
    val listaNombres = listOf<String>("Juan", "Enrique", "Camila")
    println("Lista inmutable")
    println(listaNombres)

    println()
    println()

    // Lista mutable
    val listaVacia = mutableListOf<String>()
    println("Lista mutable")
    println(listaVacia)
    listaVacia.add("Orazio")
    println(listaVacia)

    println()
    println()

    val valorUsandoGet = listaVacia.get(0)  // Tambien se puede usar como en python valor = listaVacia[0]
    println("Obteniendo valor de lista")
    println(valorUsandoGet)

    var primerValor: String? = listaNombres.firstOrNull()
    println(primerValor)

    listaVacia.removeAt(0)
    println(listaVacia)
    primerValor = listaVacia.firstOrNull()
    // Obteniendo valor de lista vacia, sera null
    println(primerValor)

    println()
    println()

    // Removiendo valor con condicional de una linea
    listaVacia.add("Orazio")
    listaVacia.add("Juan")
    listaVacia.add("Sonia")
    listaVacia.add("Sol")
    listaVacia.add("Maria")
    println("Antes del remove: $listaVacia")
    listaVacia.removeIf { palabra -> palabra.length > 4 }
    println("Despues del remove: $listaVacia")

    println()
    println()

    //Uso de array
    val myArray = arrayOf(1,2,3,4)
    println("myArray: $myArray.")
    println("array convertido en lista: ${myArray.toList()}")

    // Si se necesita performance hay que usar arrays, si no listas van bien
}

/***
 * Seccion de ordenamiento de listas en kotlin
 */
fun ordenListas() {
    println()
    println()
    println()
    println("###### Seccion de ordenamiento de listas en Kotlin ######")

    val numerosLoteria = listOf(22, 1, 42, 35, 75, 34, 26, 9, 63)
    println(numerosLoteria)

    //Asi ordenara de menor a mayor
    val numerosSorted = numerosLoteria.sorted()
    println("Numeros ordenados menor a mayor: $numerosSorted")

    val numerosSortedDescending = numerosLoteria.sortedDescending()
    println("Numeros ordenados mayor a menor: $numerosSortedDescending.")

    val ordenarPorMultiplos = numerosLoteria.sortedBy { numero -> numero < 50 }
    println("Numeros ordenados por condicion: $ordenarPorMultiplos")

    val numerosAleatorios = numerosLoteria.shuffled()
    println("Orden aleatorio: $numerosAleatorios")

    val numerosReversed = numerosLoteria.reversed()
    println("Lista al reves: $numerosReversed")

    // Se pueden usar distintas lineas pero lo que va a devolver el map sera la ultima linea
    val mensajesNumeros = numerosLoteria.map { numero -> "Tu numero de loteria es $numero" }
    println(mensajesNumeros)

    val numFiltered = numerosLoteria.filter { numero -> numero > 50 }
    println("Los numeros mayores a 50: $numFiltered")

    val numerosReduce = numerosLoteria.reduce { suma, i -> suma + i }
    println("Uso de reduce: $numerosReduce")
}

/***
 * Uso de maps en Kotlin, son basicamente como diccionarios en python, pues son colecciones de llave : valor, y ya se
 * vera como se utilizan
 */
fun usoDeMaps() {
    println()
    println()
    println()
    println("###### Seccion de uso de maps en Kotlin ######")

    val edadSuperHeroes = mapOf(
        "Iron-Man" to 35,
        "Spider-Man" to 23,
        "Captain America" to 99
    )
    println(edadSuperHeroes)

    val edadesMutables = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Wolverine" to 30
    )
    println(edadesMutables)

    println()
    println()

    edadesMutables.put("Hulk", 28)
    println(edadesMutables)
    edadesMutables["HawkEye"] = 26
    println(edadesMutables)

    println()
    println("La edad de HawkEye es: ${edadesMutables["HawkEye"]}")

    edadesMutables.remove("HawkEye")
    println("HawkEye eliminado: $edadesMutables")

    println("Los super heroes restantes son: ${edadesMutables.keys}")
}

/***
 * Uso de sets en Kotlin, son basicamente como sets en python, pues son colecciones que no pueden repetir elementos
 */
fun usoDeSets() {
    println()
    println()
    println()
    println("###### Seccion de uso de sets en Kotlin ######")

    // Esto sera un set inmutable
    val vocalesRepetidas: Set<Char> = setOf('a', 'e', 'i', 'o', 'i', 'u', 'a', 'a', 'e', 'u')
    println(vocalesRepetidas)

    val numerosFav = mutableSetOf(1,2,3,4,3,2,4,1,1,2,3,2,4,1,1,4,2,3,3,1,2,5,1,2,3,2,1,1,1,1,2,3,2,3,2,3)
    println(numerosFav)
    numerosFav.add(4)
    numerosFav.add(6)
    println(numerosFav)
    numerosFav.remove(5)
    println(numerosFav)

    val valorDelSet: Int? = numerosFav.firstOrNull { numero -> numero > 2 }
    println(valorDelSet)
}

fun ejemploFuncion(frase: String) : String {
    println()
    println()
    println()
    println("###### Seccion de uso de funciones en Kotlin ######")

    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0) {
        frase.uppercase()
    } else {
        frase.lowercase()
    }
}

fun String.funcionExtension(): String {
    return this.plus(this.reversed())
}

fun usoDeLambdas() {
    println()
    println()
    println()
    println("###### Seccion de uso de lambdas en Kotlin ######")
    val myLambda: (String) -> Int = {
        it.length
    }

    val caracteres = myLambda("Hola soy una lambda")
    println(caracteres)
    println(myLambda("Hola estoy dentro de una lamdba"))

    val saludos = listOf("Hola", "Hello", "Ciao")

    val longitudSaludos = saludos.map(myLambda) // En vez de hacer entre llaves la funcion anonima, se le puede pasar una lambda entre parentesis
    println(longitudSaludos)
}

fun usoHighOrderFunctions() {
    println()
    println()
    println()
    println("###### Seccion de uso de high order functions en Kotlin ######")

    //La funcion principal, es decir, la superFuncion, es la que se encargara de ejecutar esta lambda
    val largoValorInicial = superFuncion(valorInicial = "Hola!", block = {
        valor -> valor.length
    })
    println(largoValorInicial)

    val lambda: () -> String = functionInception("Enrique")
    val valorLambda: String = lambda()
    println(valorLambda)
}

fun superFuncion(valorInicial: String, block: (String) -> Int) : Int {
    return block(valorInicial)
}

fun functionInception(nombre: String) : () -> String {
    return {
        "Hola desde la lambda $nombre"
    }
}

/***
 * El uso de Let nos permite que, junto con las safe-calls, ejecutar un codigo solo cuando una variable nullable
 * no es nula, para asi evitar un NullPointerException
 */
fun usoDeLet() {
    println()
    println()
    println()
    println("###### Seccion de uso de high order functions en Kotlin ######")

    var nombre : String? = null
    nombre?.let {
        valor -> println("El nombre no es nulo, es $valor")
    }

    nombre = "Giuseppe"
    nombre?.let {
            valor -> println("El nombre no es nulo, es $valor")
    }
}

/***
 * El with nos permite acceder directamente a las propiedades de una variable que le pasamos como parametro, para evitar
 * llamar a la variable en repetidas ocasiones o usar directamente sus propiedades
 */
fun usoDeWith() {
    println()
    println()
    println()
    println("###### Seccion de uso de With ######")
    val colores = listOf("Azul", "Amarillo", "Rojo")
    with(colores) {
        println("Nuestros colores son $this")
        println("La cantidad de colores que hay en esta lista es de $size")
    }
}

/***
 * Run nos permite ejecutar una serie de operaciones luego de declarar una variable
 */
fun usoDeRun() {
    println()
    println()
    println()
    println("###### Seccion de uso de Run ######")
    val moviles = mutableListOf("Samsung S22", "Iphone 13", "Google Pixel 2XL", "Google Pixel 4a")
        .run {
            removeIf { movil -> movil.contains("Google") }
            this
        }
    println(moviles)
}

/***
 * Apply nos permite realizar operaciones sobre una variable y luego devolver el valor, al contrario que run
 */
fun usoDeApply() {
    println()
    println()
    println()
    println("###### Seccion de uso de Apply ######")
    val moviles = mutableListOf("Samsung S22", "Iphone 13", "Google Pixel 2XL", "Google Pixel 4a")
        .apply {
            removeIf { movil -> movil.contains("Google") }
        }
    println(moviles)

    var colores: MutableList<String>? = null

    // Al ser nulo, no se va a imprimir nada ni generara un error de NullPointerException
    colores?.apply {
        println("Nuestros colores son $this")
        println("La cantidad de colores es $size") // Actua como si fuera el with
    }

    colores = mutableListOf("Amarillo", "Verde", "Rojo", "Azul")

    // Al ser nulo, no se va a imprimir nada ni generara un error de NullPointerException
    colores?.apply {
        println("Nuestros colores son $this")
        println("La cantidad de colores es $size") // Actua como si fuera el with
    }
}

/***
 * Also nos permite obtener una variable, luego ejecutar un codigo con esa variable y luego devolverla como
 * parametro para que pueda volver a ser utilizada por una funcion mas adelante
 */
fun usoDeAlso() {
    println()
    println()
    println()
    println("###### Seccion de uso de Also ######")
    val moviles = mutableListOf("Samsung S22", "Iphone 13", "Google Pixel 2XL", "Google Pixel 4a")
        .also {
            lista -> println("El valor original de la lista es: $lista")
        }.asReversed()
    println(moviles)
}