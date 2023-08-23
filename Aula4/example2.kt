var numero = 0 //Variável global (fora de qualquer função)

fun main() {
	println(numero)
    	somaCinco()
    		desenhaLinha(numero)
    println(numero)
    	somaDez()
        	desenhaLinha(numero)
    println(numero)
    	somaCinco()
    		desenhaLinha(numero)
    
    //Usando parâmetros posicionais
    println( calculaPerimetro(2.0, 3.0, 4.0, 5.0) )
    
    //Usando parãmetros nomeados
    println( calculaPerimetro(lb = 3.0, ld = 5.0) )
    println( calculaPerimetro(ld = 3.0, la = 5.0, lb = 10.0) )
}

fun somaCinco() {
    numero+=5 //O mesmo que "numero = numero + 5"
}

fun somaDez() {
    numero+=10
}

fun desenhaLinha(q : Int) {
    var linha = ""
    for(i in 0..q) {
       linha+="-" 
    }
    println(linha)
}

fun calculaPerimetro(
    la : Double = 1.0, //Valor padrão
    lb : Double,
    lc : Double = 2.0,
    ld : Double
) : Double {
    return (la + lb + lc + ld)
}
