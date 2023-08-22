import kotlin.random.Random

var anos = 0 //Variável global (fora de qualquer função)

fun main() {
    //Chamando funções
    darBoasVindas()
    
    dizerNomeEIdade(idade = 10, nome = "Pópis")
    dizerNomeEIdade("Kiko", 9)
    dizerNomeEIdade("Chaves", 8)
    
    println( "Área do Trapézio: ${areaDoTrapezio(h = 5.0, a = 3.2, b = 3.3)} m²" )
    println( "Área do Círculo: ${areaDoCirculo(3.8f)} m²" )
}

//Função sem parâmetros e sem retorno
fun darBoasVindas() {
    println("Opa! E aê meu consagrado!")
}

fun escolherAmigo() {
    val option = Random.nextInt(0, 5)
    val sufixo = "Presente de "
    when(option) {
        0 -> println("$sufixo Madruga")
        1 -> println("$sufixo Chiquinha")
        2 -> println("$sufixo Florinda")
        3 -> println("$sufixo Clotilde")
        4 -> println("$sufixo Zenon (Sr. Barriga)")
    }
}

fun presentear() {
    val option = Random.nextInt(0, 5)
    when(option) {
        0 -> println("Ganhou roupas")
        1 -> println("Ganhou brinquedos")
        2 -> println("Ganhou dinheiro")
        3 -> println("Ganhou cartão presente")
        4 -> println("Ganhou parabéns")
    }
    escolherAmigo()
}

fun aniversario() {
    anos++ //Soma 1
    println("Parabéns! Agora você tem $anos anos")
    presentear()
}

//Função com dois parâmetros, sem retorno
fun dizerNomeEIdade(
    nome : String,
    idade : Int
) {
    anos = idade
    println("Olá $nome! Você tem $idade anos.")
    aniversario()
}

//Função com parâmetros e retorno
fun areaDoTrapezio(
    a : Double = 1.0, //Valor padrão
    b : Double = 1.0,
    h : Double = 1.0
) : Double {
    return ((a + b) * h) / 2
}

fun areaDoCirculo(
	raio : Float
) : Float {
    val result = Math.PI * (raio * raio)
    return result.toFloat()
}
