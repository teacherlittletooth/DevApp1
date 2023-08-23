var numero = 0 //Variável global (acessível a todas as funções)

fun main() {
    println(numero)
    println(criarQuebraDeLinha())
    somarDez()
    println(numero)
    println(criarQuebraDeLinha(quant = 25))
    somarQuinze()
    println(numero)
    println(criarQuebraDeLinha(10))
    baskara(c = 2.0, b = 2.5, a = 2.6) //Parâmetros nomeados
    baskara(b = 3.0, c = 4.5) //Deixando de enviar um parâmetro
}

fun somarDez() {
    numero+=10 //O mesmo que "numero = numero + 10"
}

fun somarQuinze() {
    numero+=15
}

fun criarQuebraDeLinha(
    quant : Int = 20
) : String {
    var a = ""
    for(i in 0..quant) {
        a+="="
    }
    return a
}


fun baskara(
    a : Double = 10.0,
    b : Double,
    c : Double
) {
    val delta = Math.pow(b,2.0) - (4 * a * c)
    println( "X' = " + (- b - delta) / 2 * a )
    println( "X'' = " + (- b + delta) / 2 * a )
}
