package com.luis.pereira.panquecasdafamilia.controller;

import com.luis.pereira.panquecasdafamilia.model.ClientEntity;
import com.luis.pereira.panquecasdafamilia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<ClientEntity>> findAll (){
        return new ResponseEntity<List<ClientEntity>>(
                (List<ClientEntity>) this.clientRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientEntity> findById(@PathVariable ("id_client") long id_client) {
        if(this.clientRepository.findById(id_client).isPresent()){
            return new ResponseEntity<ClientEntity>(
                    this.clientRepository.findById(id_client).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<ClientEntity>(HttpStatus.NOT_FOUND);
    }

    //@PostMapping
    public ResponseEntity<ClientEntity> register
            (@RequestBody ClientEntity clientEntity) {
        return new ResponseEntity<ClientEntity> (
                this.clientRepository.save(clientEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientEntity> update (@PathVariable("id_client") long id_client,
                                                        @RequestBody ClientEntity clientEntity) throws Exception {

        if(id_client == 0 || !this.clientRepository.existsById(id_client)){
            throw  new Exception("client not found");

        }
        return new ResponseEntity<ClientEntity>(
                this.clientRepository.save(clientEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientEntity> delete (@PathVariable("id_client") long id_client ){
        this.clientRepository.deleteById(id_client);
        return new ResponseEntity<ClientEntity>(new HttpHeaders(), HttpStatus.OK);
    }
}
