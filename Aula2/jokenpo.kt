import kotlin.random.Random

var ptsPlayer1 = 0
var ptsPlayer2 = 0

fun main() {
    var rodada = 1
    
    while( rodada < 6 ) {
        val jogadaPlayer1 = Random.nextInt(0, 3)
        val jogadaPlayer2 = Random.nextInt(0, 3)
        
    	println(" ******** RODADA $rodada ******** ")
        print("P1 => ${ jogada(jogadaPlayer1) }")
        print(" X ")
        println("${ jogada(jogadaPlayer2) } <= P2")
        
        vencedor( jogadaPlayer1, jogadaPlayer2 )
        
        println("PLACAR: Player1 = $ptsPlayer1 | Player2 = $ptsPlayer2")
                
        println("=============================\n")
        
        rodada++
    } // while
    
    if( ptsPlayer1 > ptsPlayer2 ) {
        println("🎉 Vitória do PLAYER 1 🎉")
    } else if( ptsPlayer1 < ptsPlayer2 ) {
        println("✅ Vitória do PLAYER 2 ✅")
    } else {
        println("👍 Terminou com EMPATE 👍")
    }
    
} // main


fun jogada(escolha: Int) : String {
    var result = ""
    when( escolha ) {
        0 -> result = "Pedra💎"
        1 -> result = "Papel🧻"
        2 -> result = "Tesoura✂️"
    }
    return result
}


fun vencedor(jp1: Int, jp2: Int) {
    if( jp1 == jp2 ) {
        println("=> EMPATE")
    } else if(
    	jp1 == 0 && jp2 == 2 ||
        jp1 == 1 && jp2 == 0 ||
        jp1 == 2 && jp2 == 1
    ) {
        println("=> Ponto para PLAYER 1")
        ptsPlayer1++
    } else {
        println("=> Ponto para PLAYER 2")
        ptsPlayer2++
    }
}
