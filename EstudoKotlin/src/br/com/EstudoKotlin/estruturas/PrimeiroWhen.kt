package br.com.EstudoKotlin.estruturas

fun main(args:Array<String>){
	val mes = 2
	
	when(mes){
		1->println("Janeiro")
		2->println("Fevereiro")
		3->println("Mar�o")
		4->println("Abril")
		5->println("Maio")
		6->println("Junho")
		else-> println("M�s n�o contemplado")
	}
}
