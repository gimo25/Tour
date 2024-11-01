package com.jalasoft.client.controller;

import com.jalasoft.client.domain.ClientEntity;
import com.jalasoft.client.domain.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giordano Bortolini
 */
@RestController
@RequestMapping(path = "/client")
public class ClientController {

  @Autowired
  private ClientRepository repository;

  @GetMapping("/all")
  private List<ClientEntity> getAllClients() throws InterruptedException {
    Thread.sleep(4000L);
    return repository.findAll();
  }
}
