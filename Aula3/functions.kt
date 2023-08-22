import kotlin.random.Random

var idade = 0 //Variável global

fun main() {
	darBoasVindas(pessoa = "Oscar", 15)
    darBoasVindas("Felipe", 25)
    darBoasVindas("Janaína", 35)
    
    println( "Área do círculo: ${areaDoCirculo(3.5)} m² " )
    println( areaDoTrapezio(bMenor = 2f, altura = 3f, bMaior = 4f) )
    
    for(i in 0..40) {
    	println( escolherFrase() )
    }
}


fun darBoasVindas(pessoa : String, idadeEnv : Int) {
    idade = idadeEnv
    println("Opa $pessoa! Tudo jóia? Você tem $idade anos")
    aniversario()
}

fun aniversario() {
    idade++ // É o mesmo que "idade = idade + 1"
    println("Parabéns! Agora você tem $idade anos!")
}

fun areaDoCirculo(raio : Double) : Double {
    val result = Math.PI * ( Math.pow(raio.toDouble(),2.0) )
    return result
}

fun areaDoTrapezio(
    bMaior : Float,
    bMenor : Float,
    altura : Float) : Float {
    return ((bMaior + bMenor) * altura) / 2
}

fun escolherFrase() : String {
    val option = Random.nextInt(0, 5)
    var frase = ""
    
    when(option) {
        0 -> frase = "Que burro, dá zero pra ele!"
        1 -> frase = "A carne de burro não é transparente."
        2 -> frase = "Se aproveitam de minha nobreza!"
        3 -> frase = "Qual animal que come com o rabo?"
        4 -> frase = "Tudo é culpa do professor linguiça."
        else -> frase = "Sigam-me os bons!"
    }
    return frase
}
