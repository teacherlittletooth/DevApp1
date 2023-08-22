fun main() {
    val listaCarros : Array<String> = arrayOf(
    	"Chevette",
        "Gurgel",
        "Opala",
        "Monza",
        "Fusca",
        "Kombi"
    )
    
    //Varrendo lista #1
    for(i in 0..(listaCarros.size - 1)) {
    	println( listaCarros[i] )
	}
    
    //Varrendo lista #2
    for(i in listaCarros.indices) {
    	println( listaCarros[i] )
	}
    
    //Varrendo lista #3
    listaCarros.forEach{ println(it) }
    
}
