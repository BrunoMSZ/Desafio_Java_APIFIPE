package br.com.testeDev.service;

import java.util.List;

public interface IConverteDados {
    <T> T obterDado(String json, Class<T> classe); //devolve algum generico (<T> T)

    <T> List<T> obterLista(String json, Class<T> classe);//obter dado em uma lista
}
