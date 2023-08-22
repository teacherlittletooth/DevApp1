//Criando lista de dados (global)
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
    
    //Criando lista mutável para filtrar dados da outra lista
    var listaFiltro : MutableList<String> = mutableListOf()
    
    listaCarros.forEach{
        if(it.toLowerCase().contains("ch")) {
            listaFiltro.add(it)
        }
    }
    
    //Mostrando dados da lista de filtro
    listaFiltro.forEach{ println(it) }
    
    apagaElemento("")
}


fun apagaElemento(filtro : String) {
    listaCarros.forEach{
        if(it.toLowerCase().contains(filtro)) {
            listaCarros.remove(it)
            println("Elemento excluído...")
        }
    }
    listaCarros.forEach{ println(it) }
}
