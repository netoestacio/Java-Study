package br.com.multiDatabases.service;

import br.com.multiDatabases.repository.mongo.entity.Pokemon;
import org.springframework.http.ResponseEntity;


public interface PokemonService {

    ResponseEntity getAllPokemons();
    ResponseEntity getPokemonByNumber(Integer number);
    ResponseEntity insertNewPokemon(Pokemon pkm);

}
