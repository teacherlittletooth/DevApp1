//Criando classe para geração de objetos
data class Desenhos(
    //Atributos da classe
    var desenho : String,
    var classificacao : Int,
    var genero : String
)

//Criando lista/array vazio
var listaDesenhos : MutableList<Desenhos> = mutableListOf()

//Criando método/função para cadastrar Desenhos
fun cadastra(
    des : String,
    classif : Int,
    gen : String
) {
   //Criando objeto com valores passados por parâmetro
   var novoDesenho = Desenhos(desenho = des, classificacao = classif, genero = gen)
   //Adicionando novo objeto na lista de desenhos
   listaDesenhos.add(novoDesenho)
   println("Cadastro realizado!")
}

fun lista() {
    println("***LISTA DE DESENHOS***")
    listaDesenhos.forEach{
        println("${it.desenho} \t\t ${it.classificacao} \t\t ${it.genero}")
    }
}

fun main() {
	cadastra(
        des = "Scooby Doo",
        classif = 10,
        gen = "Aventura"
    )
    
    cadastra(
        des = "Coragem - O cão covarde",
        classif = 12,
        gen = "Comédia/Terror"
    )
    
    cadastra(
        des = "Cavaleiros dos Zodíaco",
        classif = 14,
        gen = "Ação"
    )
    
    lista()
}
