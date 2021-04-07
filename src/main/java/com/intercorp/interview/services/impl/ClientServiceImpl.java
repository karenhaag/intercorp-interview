package com.intercorp.interview.services.impl;

import com.intercorp.interview.dto.Client;
import com.intercorp.interview.dto.ClientKpi;
import com.intercorp.interview.dto.ClientResponse;
import com.intercorp.interview.model.ClientEntity;
import com.intercorp.interview.repository.ClientRepository;
import com.intercorp.interview.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        ClientEntity clientEntity = new ClientEntity(client);
        ClientEntity clientEntitySaved = clientRepository.save(clientEntity);
        return client;
    }

    @Override
    public List<ClientResponse> getAll(){
        List<ClientEntity> clientEntities = clientRepository.findAll();
        List<ClientResponse> clients = clientEntities.stream().map(clientEntity -> new ClientResponse(clientEntity)).collect(Collectors.toList());
        return clients;
    }

    @Override
    public Optional<ClientKpi> getClientKpi(){
        List<Double> ages = clientRepository.getAges().stream().map(age-> new Double(age)).collect(Collectors.toList());
        if (!ages.isEmpty()){
            Double avg = calculateAverage(ages);
            return Optional.of(new ClientKpi(avg,calculateSD(ages,avg)));
        }
        return Optional.empty();
    }

    private static double calculateAverage(List<Double> ages) {
        double sumAges = 0.0;
        int length = ages.size();

        for (Double age : ages) {
            sumAges += age;
        }
        return sumAges / length;
    }
    private static double calculateSD(List<Double> ages, Double avg) {
        double standardDeviation = 0.0;;
        for(double num: ages) {
            standardDeviation += Math.pow(num - avg, 2);
        }
        return Math.sqrt(standardDeviation/ages.size());
    }

}
