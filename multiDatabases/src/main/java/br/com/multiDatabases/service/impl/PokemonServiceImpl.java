package br.com.multiDatabases.service.impl;

import br.com.multiDatabases.repository.mongo.entity.Pokemon;
import br.com.multiDatabases.repository.mongo.repository.PokemonRepository;
import br.com.multiDatabases.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository repository;

    @Override
    public ResponseEntity getAllPokemons() {
        return new ResponseEntity(repository.findAll(), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity getPokemonByNumber(Integer number) {
        return new ResponseEntity(repository.findByNumber(number), HttpStatus.OK);
    }

    @Override
    public ResponseEntity insertNewPokemon(Pokemon pkm) {
        return new ResponseEntity(repository.save(pkm), HttpStatus.OK);
    }
}
