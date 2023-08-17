///Jokenpô de máquinas:
///Um número randômico é utilizado para
///escolher as jogadas
import kotlin.random.Random

fun main() {
    //Declaração de variáveis
    val escolhaJogador 	: Int
    val escolhaCpu 		: Int
    
    /* Regras do jogo
     1 - PEDRA, 2 - PAPEL, 3 - TESOURA
     1 GANHA DE 3
     2 GANHA DE 1
     3 GANHA DE 2
    */
    
    //Atribuição de valores às variáveis
    escolhaJogador = Random.nextInt(1,4)
    escolhaCpu = Random.nextInt(1,4)
    
    //Mostrando as escolhas
    when(escolhaJogador) {
        1 -> println("Jogador escolheu PEDRA")
        2 -> println("Jogador escolheu PAPEL")
        3 -> println("Jogador escolheu TESOURA")
    }
    
    when(escolhaCpu) {
        1 -> println("Máquina escolheu PEDRA")
        2 -> println("Máquina escolheu PAPEL")
        3 -> println("Máquina escolheu TESOURA")
    }
    
    //Verificando quem venceu
    if((escolhaJogador == 1 && escolhaCpu == 3) ||
       (escolhaJogador == 2 && escolhaCpu == 1) ||
       (escolhaJogador == 3 && escolhaCpu == 2)) {
        println("Jogador venceu!")
    }
    else if(escolhaJogador == escolhaCpu) {
        println("Empate!")
    }
    else {
        println("Máquina venceu!")
    }
    
}
