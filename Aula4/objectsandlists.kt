//Criando uma lista de Produtos vazia
var listaProdutos : MutableList<Produtos> = mutableListOf()

fun main() {
   //Criando produto
   val queijo = Produtos("Queijo prato", 42.90, 100)
   //Adicionando produto na listaProdutos
   listaProdutos.add(queijo)
   val carne = Produtos("Costela bovina", 32.90, 50)
   listaProdutos.add(carne)
   val farinha = Produtos("Farinha trigo", 5.75, 200)
   listaProdutos.add(farinha)
   val tomate = Produtos("Tomate gaúcho", 5.59, 300)
   listaProdutos.add(tomate)
   val batata = Produtos("Batata rosa", 4.49, 350)
   listaProdutos.add(batata)
   
   //Mostrar todos os produtos
   mostrarProdutos()
}


data class Produtos(
    //Atributos da classe
    var produto : String,
    var preco : Double,
    var quantidade : Int
)

fun mostrarProdutos() {
    println("*** LISTA DE PRODUTOS ***")
    listaProdutos.forEach{
        println( "${it.produto} \t | \tR$ ${it.preco} \t | \t ${it.quantidade}" )
    }
}
