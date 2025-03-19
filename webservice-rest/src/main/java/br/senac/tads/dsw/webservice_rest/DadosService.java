package br.senac.tads.dsw.webservice_rest;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DadosService {

    private Map<Integer, DadosDto> dados;

    public DadosService() {
        dados = new HashMap<>();
        dados.put(1, new DadosDto(1, "Fulano da silva", "2000-10-20",
                "fulano@Email.com", "11 99999-9999"));
        dados.put(2, new DadosDto(2, "Ciclano de souza", "1999-05-15", "ciclano@email.com", "11 97777-7777"));
        dados.put(3, new DadosDto(3, "Beltrano dos santos", "2001-02-09", "beltrano@email.com","11 97777-7777"));

    }
    public List<DadosDto> findALL(){
        return new ArrayList<>(dados.values());
    }

    public Optional<DadosDto> findById(Integer id){
        return Optional.ofNullable(dados.get(id));
    }
    }

