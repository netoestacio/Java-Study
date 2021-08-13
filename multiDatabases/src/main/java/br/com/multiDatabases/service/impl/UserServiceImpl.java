package br.com.multiDatabases.service.impl;

import br.com.multiDatabases.repository.postgres.entity.User;
import br.com.multiDatabases.repository.postgres.repository.UserRepository;
import br.com.multiDatabases.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public ResponseEntity findAll() {
        ResponseEntity resposta = null;
        try{
            List<User> lista = repository.findAll();
            if(lista.size() > 0){
                resposta =  new ResponseEntity(lista, HttpStatus.OK);
            }else{
                resposta =  new ResponseEntity("Valores nao encontrados", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            resposta =  new ResponseEntity("Erro de Servidor: "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resposta;
    }

    @Override
    public ResponseEntity findOne(Long id) {
        ResponseEntity resposta = null;
        try{
            Optional<User> user = repository.findById(id);
            if(user.isPresent()){
                resposta =  new ResponseEntity(user.get(), HttpStatus.OK);
            }else{
                resposta =  new ResponseEntity("Usuario não encontrado", HttpStatus.OK);
            }
        }catch (Exception e){
            resposta =  new ResponseEntity("Erro de Servidor: "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resposta;
    }

    @Override
    public ResponseEntity save(User user) {
        ResponseEntity resposta = null;
        try{
           User usr = repository.save(user);
            if(user.getId() > 0){
                resposta =  new ResponseEntity(usr, HttpStatus.OK);
            }else{
                resposta =  new ResponseEntity("Usuario não cadastrado", HttpStatus.OK);
            }
        }catch (Exception e){
            resposta =  new ResponseEntity("Erro de Servidor: "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resposta;
    }

    @Override
    public ResponseEntity update(Long id, User user) {
        ResponseEntity resposta = null;
        try{
            User usr = repository.saveAndFlush(user);
            if(user.getId() > 0){
                resposta =  new ResponseEntity(usr, HttpStatus.OK);
            }else{
                resposta =  new ResponseEntity("Usuario não cadastrado", HttpStatus.OK);
            }
        }catch (Exception e){
            resposta =  new ResponseEntity("Erro de Servidor: "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resposta;
    }
}
