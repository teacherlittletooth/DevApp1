var numero = 0 //Variável global (fora de qualquer função)

fun main() {
   println(numero)
   somaDez()
   	desenhaLinha(numero)
    println( desenhaLinha2(numero) )
   println(numero)
   somaQuinze()
   	desenhaLinha(numero)
    println( desenhaLinha2(numero) )
   println(numero)
   
   bhaskara(1.0, 4.0, 2.0) //Usando parâmetros POSICIONAIS
   bhaskara(b = 8.0, a = 2.0, c = 4.0) //Usando parâmetros NOMEADOS
   bhaskara(c = 4.0, b = 6.0) 
}

fun somaDez() {
    numero+=10 //O mesmo que "numero = numero + 10"
}

fun somaQuinze() {
    numero+=15
}

fun desenhaLinha(numero : Int) {
    var linha = ""
    for(i in 1..numero) {
        linha+="-"
    }
    println(linha)
}

fun desenhaLinha2(numero : Int) : String {
    var linha = ""
    for(i in 1..numero) {
        linha+="="
    }
    return linha
}

fun bhaskara(
    a : Double = 1.0, //Valor padrão (opcional)
    b : Double,
    c : Double
) {
   val delta = (b * b) - (4 * a * c)
   val x1 = (- b - Math.sqrt(delta) ) / 2 * a
   val x2 = (- b + Math.sqrt(delta) ) / 2 * a
   println("X' = $x1")
   println("X'' = $x2")
}
