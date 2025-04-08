import kotlin.random.Random

fun main() {
    println(" *** Coach virtual *** ")
    println(" => Frase do dia:")
    
    val sorteio = Random.nextInt(0, 5)
    
    println( frases[sorteio] )
}


//Criando uma lista de frases
val frases = arrayOf(
	"A palavra impossível foi inventada para ser desafiada",
    "Somos capazes de fazer muito mais do que imaginamos!",
    "Que todos os nossos passos nos levem para o que nos faz feliz de verdade.",
    "Hoje é um novo dia. Não fique pensando no ontem.",
    "Quando já havia desistido, tentei mais uma vez."
)
