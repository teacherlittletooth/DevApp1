var numero = 0 //Variável global (fora das funções)

fun main() {
    println(numero)
    criaLinha(100)
    somaDez()
    println(numero)
    criaLinha(50)
    somaQuinze()
    println(numero)
    criaLinha(10)
    baskara(1.0, 4.0, 2.0) //Parâmetros posicionais
    baskara(c = 1.0, a = 4.0, b = 2.0) //Parâmetros nomeados
    baskara(b = 6.0, c = 3.0) //Não enviando o parâmetro "a"
}

fun somaDez() {
    numero+=10 // O mesmo que "numero = numero + 10"
}

fun somaQuinze() {
    numero+=15
}

fun criaLinha(quant : Int) {
    var x = ""
    for(i in 0..quant) {
        x+="-"
    }
    println(x)
}

fun baskara(
    a : Double = 1.0, //Valor padrão (caso não seja enviado)
    b : Double,
    c : Double
) {
    val delta = Math.pow(b,2.0) - (4.0 * a * c)    
    val xLinha = (- b + Math.sqrt(delta)) / (2.0 * a)
    val xDuasLinha = (- b - Math.sqrt(delta)) / (2.0 * a)
    println("Delta: $delta")
    println("X' = $xLinha")
    println("X'' = $xDuasLinha")
}
