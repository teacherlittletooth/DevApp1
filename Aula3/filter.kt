/// Código enviado por S4uszDev <Danilo Leipnitz>

// Criando lista de dados (global)
var listaCarros = mutableListOf(
    "Chevette",
    "Gurgel",
    "Chevi 500",
    "Opala",
    "Monza",
    "Fusca",
    "Kombi"
)

fun main() {

    // Criando lista mutável para filtrar dados da outra lista
    val listaFiltro: MutableList<String> = mutableListOf()

    // Mostrando dados sem filtro
    println("***********LISTA COMPLETA************")
    listaCarros.forEach { println(it) }
    
    //Filtrando
    listaCarros.forEach {
        if (it.lowercase().contains("ch")) {
            listaFiltro.add(it)
        }
    }

    // Mostrando dados da lista de filtro
    println("***********ELEMENTOS FILTRADOS***********")
    listaFiltro.forEach { println(it) }
    
    // Chama apagaElemento após a listagem
    apagaElemento("ch") // Passando o filtro correto

    // Lista após a remoção
    println("*********LISTA APÓS EXCLUSÃO**********")
    listaCarros.forEach { println(it) }
    println("*************************************")
}

fun apagaElemento(filtro: String) {
    listaCarros.removeIf { 
        it.lowercase().contains(filtro)
    }
    println("Elementos excluídos!")
}
