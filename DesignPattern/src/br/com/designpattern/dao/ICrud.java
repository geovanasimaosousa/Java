package br.com.designpattern.dao;

import java.util.List;

public interface ICrud<T> {
	boolean cadastro(T obj);
	List<T> buscar();
	T busncar(int id);
	boolean atualizar(T obj);
	boolean apagar (int id);

}
