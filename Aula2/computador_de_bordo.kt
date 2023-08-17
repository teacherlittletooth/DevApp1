fun main() {
    //Declarações de variáveis
    val precoPorLitro : Double
    val autonomia : Double
    val modelo : String
    val kilometragem : Double
    val abastecimento : Double
    
    //Atribuindo valores
    precoPorLitro = 5.39
    modelo = "Fiat Uno"
    autonomia = 15.0
    abastecimento = 5.0

    //Cálculo de quanto poderá rodar
    kilometragem = (abastecimento / precoPorLitro) * autonomia
    
    println("O $modelo, que tem autonomia de $autonomia km/l \n" +
            "vai andar $kilometragem km se abastecer \n" +
            "$abastecimento reais.")
    
    if(kilometragem < 5) {
        println("Será que chega em casa?")
    }
    else if(kilometragem >= 5 && kilometragem < 10) {
        println("Já dá pra ir no mercado.")
    }
    else if(kilometragem >= 10 && kilometragem < 40) {
        println("Já dá pra ir à praia.")
    }
    else {
        println("Tanque cheio!")
    }
    
}
