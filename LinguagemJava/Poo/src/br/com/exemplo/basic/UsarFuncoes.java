package br.com.exemplo.basic;
import com.matematica.funcoes.*;

public class UsarFuncoes {

	public static void main(String[] args) {
		// vamos declarar um array de valores
		// do tipo double e passar as funcoes
		double[] valores = {15, 32, 56, 80, 11};
		MFuncoes funcoes =new MFuncoes();
		System.out.println("O resultado da soma é: "+funcoes.soma(valores));
		System.out.println("O resultado da média é: "+funcoes.media(valores));
		System.out.println("O maior valor é: "+funcoes.maximo(valores));

	}

}
