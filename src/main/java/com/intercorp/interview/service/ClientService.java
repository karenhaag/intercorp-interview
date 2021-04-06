package com.intercorp.interview.service;

import com.intercorp.interview.dto.Client;
import com.intercorp.interview.dto.ClientKpi;
import com.intercorp.interview.dto.ClientResponse;

import java.util.List;
import java.util.Optional;


public interface ClientService {

    Client create(Client client);

    List<ClientResponse> getAll();

    Optional<ClientKpi> getClientKpi();

}
