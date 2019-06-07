package com.matematica.funcoes;

public class MFuncoes {
	public double soma(double[] numeros) {
		
		double rs = 0;
		
		for (int i = 0 ; i < numeros.length ; i++)
			rs+= numeros[i];
		return rs;
	}
	public double media(double[] numeros) {
	double rs = 0;
	
	for (int i = 0 ; i < numeros.length ; i++)
		rs+= numeros[i]; 
	return rs/numeros.length;
	}
	public double maximo(double[] numeros) {
		double x = numeros[0];
		
		for (int i = 0 ; i < numeros.length ; i++)
			if (x < numeros[i])
			x = numeros[i]; 
		return x;
		}
	public double minimo(double[] numeros) {
		double x = numeros[0];
		
		for (int i = 0 ; i < numeros.length ; i++)
			if (x > numeros[i])
			x = numeros[i]; 
		return x;
		}
	public double potencia(int b, int e) {
		int rs = b;
		
		for(int i = 1 ; i < e ; i++)
			rs*=b;
		return rs;
		}

}
