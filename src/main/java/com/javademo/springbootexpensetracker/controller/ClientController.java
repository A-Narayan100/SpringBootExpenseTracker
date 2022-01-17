package com.javademo.springbootexpensetracker.controller;

import com.javademo.springbootexpensetracker.entity.Client;
import com.javademo.springbootexpensetracker.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }


    @GetMapping("/clients")
    Collection<Client> clients(){
        return clientRepository.findAll();
    }

    //category/2
    @GetMapping("/client/{id}")
    ResponseEntity<?> getClient (@PathVariable Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }



    @PostMapping("/client")
    ResponseEntity<Client> createCategory(@Valid @RequestBody Client client) throws URISyntaxException{
        Client result= clientRepository.save(client);
        return ResponseEntity.created(new URI("/api/client" + result.getId())).body(result);

    }


    @PutMapping("/client/{id}")
    ResponseEntity<Client> updateCategory(@Valid @RequestBody Client client){
        Client result= clientRepository.save(client);
        return ResponseEntity.ok().body(result);
    }



    @DeleteMapping("/client/{id}")
    ResponseEntity<?> deleteclient(@PathVariable Long id){
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
