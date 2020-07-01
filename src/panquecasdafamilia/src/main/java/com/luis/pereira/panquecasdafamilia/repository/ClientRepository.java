package com.luis.pereira.panquecasdafamilia.repository;

import com.luis.pereira.panquecasdafamilia.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long>{}
