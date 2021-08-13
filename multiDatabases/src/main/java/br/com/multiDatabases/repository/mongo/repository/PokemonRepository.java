package br.com.multiDatabases.repository.mongo.repository;

import br.com.multiDatabases.repository.mongo.entity.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, Integer> {
    Pokemon findByNumber(Integer number);
}
