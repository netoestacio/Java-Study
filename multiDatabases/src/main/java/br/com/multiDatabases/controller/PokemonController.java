package br.com.multiDatabases.controller;

import br.com.multiDatabases.repository.mongo.entity.Pokemon;
import br.com.multiDatabases.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping
    public ResponseEntity getAllPokemons(){
        return service.getAllPokemons();
    }

    @GetMapping(path = "number")
    public ResponseEntity getByNumber(@RequestParam("number") Integer number){
        return service.getPokemonByNumber(number);
    }

    @PostMapping
    public ResponseEntity insertPokemon(@RequestBody Pokemon pkm){
        return service.insertNewPokemon(pkm);
    }

}
