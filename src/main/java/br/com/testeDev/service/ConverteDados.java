package br.com.testeDev.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.Collections;
import java.util.List;

public class ConverteDados implements IConverteDados{

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDado(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe); //tenta ler e retorna para um classe que ele passou
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe); //constroi uma lista para os dados que enviamos pela api
        try {
            return mapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
