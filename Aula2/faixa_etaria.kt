fun main() {
    val nome : String
    val idade : Int
    var mensagem : String
    
    nome = "Melissa"
    idade = 10
    mensagem = "Bem vindo $nome! Você tem $idade anos, portanto é"
    
    if(idade >= 0 && idade < 11) {
        mensagem += " criança."
    }
    else if(idade >= 11 && idade < 18) {
        mensagem += " adolescente."
    }
    else if(idade >= 18 && idade < 65) {
        mensagem += " adulto."
    }
    else {
        mensagem += " idoso."
    }
    
    println(mensagem.trim())
}
