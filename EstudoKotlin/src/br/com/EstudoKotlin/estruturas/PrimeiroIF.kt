package br.com.EstudoKotlin.estruturas

fun main(args:Array<String>){
	val x = 10
	val y = 30
	val rs = if(x > y){
		println("O valor de x � menor")
		x	
	}
	else{
		println("O valor de y � maior")
		y
	}
	println("O valor de x � $rs e y � $rs")
}
