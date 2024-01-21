// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
   	
    fun carregarMatriculas() {        
        for (inscrito in inscritos) println("\t ${inscrito.nome}")
    }
    
    fun carregarConteudos() { 		
        for (conteudo in conteudos) println("\t ${conteudo.nome} (${conteudo.duracao}) hrs")        
    }
    
    fun mostrarFormacao() {
        println("Formacao: $nome")
        println("Nivel: $nivel")
        
        println("Conteudos")
        carregarConteudos()
        
        println("Inscritos")
        carregarMatriculas()
    }
}

class IllegalListSizeException(message: String): Throwable(message)

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    // lista dos conteudos educacionais
    val kotlinConteudoEducacional = listOf(
    	ConteudoEducacional("Introduction", 10),
        ConteudoEducacional("Control Flow", 15),
        ConteudoEducacional("Special Cases", 12),
        ConteudoEducacional("Functional", 25),
        ConteudoEducacional("Collections", 35),
        ConteudoEducacional("Scope Functions", 10),
    )
    
  	// lista dos usuarios    
    val usuarios = listOf(
        Usuario("Phil Anselmo"), 
        Usuario("Dimebag Darrell"), 
        Usuario("Rex Brown"),
        Usuario("Vinnie Paul Abbott")
    )
    
    // validacao da duracao dos conteudos
    val checadoKotlinConteudoEducacional = kotlinConteudoEducacional.filter { conteudo -> conteudo.duracao > 0 }
    if (kotlinConteudoEducacional.size != checadoKotlinConteudoEducacional.size) {
        throw IllegalListSizeException("Um erro ocorreu na declaracao dos conteudos")
    }
    
    // declaracao da formacao
    val formacao = Formacao("Kotlin Back-end", checadoKotlinConteudoEducacional, Nivel.INTERMEDIARIO)
    
    // inclusao dos usuarios na formacao
    for (usuario in usuarios) formacao.matricular(usuario)
    
    // visualizacao da formacao
    formacao.mostrarFormacao()
}
