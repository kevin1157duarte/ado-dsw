package br.senac.tads.dsw.webservice_rest;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/dados")
public class DadosRestController {
    @Autowired
    private DadosService service;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public String findAll(){
        List<DadosDto> dados = service.findALL();
        try{
            return objectMapper.writeValueAsString(dados);
        }catch (JsonProcessingException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public DadosDto findById(@PathVariable("id")Integer id){
        Optional<DadosDto> optDados = service.findById(id);
        if(!optDados.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optDados.get();
    }

}
