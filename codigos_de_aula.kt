import kotlin.random.Random

fun main() {
    println(" *** Cantada da Hora! *** ")
    
    val sorteio = Random.nextInt(0, cantadas.size)
    
    println( cantadas[sorteio].cantada )
    print("Esta cantada poderá ser usada em: ")
    println( cantadas[sorteio].momento )
    
    println("\n ==> Mostrando todas as cantadas <==")
    
    var contador = 1
    cantadas.forEach{
        print("$contador)")
        print("${ it.cantada } / ${ it.momento } \n\n")
        contador++
    }
    
    cantadas.forEachIndexed{ num, obj ->
        print(num + 1)
        print(" - Cantada: ")
        println(obj.cantada)
        print("Momento: ")
        println(obj.momento)
    }
}

// Lista de cantadas
val cantadas = arrayOf(
	Cantada(
        momento = "Primeiro encontro",
    	cantada = "Você tem um mapa? Porque eu me perdi no brilho dos seus olhos.",
    ),
    Cantada(
        cantada = "Você não é pescoço, mas mexeu com a minha cabeça.",
        momento = "Conversa informal"
	),
    Cantada(
        cantada = "Se você fosse um sanduíche, seu nome seria x-princesa!",
		momento = "Nunca"
    ),
    Cantada(
        cantada = "Você é tão gata que se eu te matar de amor ainda sobram mais 6 vidas.",
		momento = "Conhecendo os pais dela"
    ),
    Cantada(
        cantada = "Perdi meu número de telefone, me empresta o seu?",
		momento = "No coletivo"
    ),
    Cantada(
        cantada = "Você não usa calcinha, você usa um para-quedas!",
        momento = "No bingo"
	)
)


data class Cantada(
	var cantada : String,
    var momento : String
)
