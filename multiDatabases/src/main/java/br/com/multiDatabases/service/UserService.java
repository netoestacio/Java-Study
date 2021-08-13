package br.com.multiDatabases.service;

import br.com.multiDatabases.repository.postgres.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity findAll();
    ResponseEntity findOne(Long id);
    ResponseEntity save(User user);
    ResponseEntity update(Long id, User user);


}
