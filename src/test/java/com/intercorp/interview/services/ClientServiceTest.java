package com.intercorp.interview.services;

import com.intercorp.interview.dto.Client;
import com.intercorp.interview.dto.ClientKpi;
import com.intercorp.interview.dto.ClientResponse;
import com.intercorp.interview.model.ClientEntity;
import com.intercorp.interview.repository.ClientRepository;
import com.intercorp.interview.services.impl.ClientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void shouldReturnAllClients() {
        Date now = new Date();
        int DAYS_OF_LIFE = 28835;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, DAYS_OF_LIFE);

        List<ClientEntity> clientList =new ArrayList<>();
        Client client1 = new Client("Karen","Haag",29,  now);
        Client client2 = new Client("Romina","Haag",24, now);

        clientList.add(new ClientEntity(client1));
        clientList.add(new ClientEntity(client2));

        Mockito.when(clientRepository.findAll()).thenReturn(clientList);

        List<ClientResponse> clients = clientService.getAll();
        assertEquals(2, clients.size());
        assertEquals("Karen", clients.get(0).getName());
        assertEquals("Haag", clients.get(0).getSurname());
        assertEquals(29, clients.get(0).getAge());
        assertEquals(calendar.getTime(), clients.get(1).getDeathDate());
        assertEquals("Romina", clients.get(1).getName());
        assertEquals("Haag", clients.get(1).getSurname());
        assertEquals(24, clients.get(1).getAge());
        assertEquals(calendar.getTime(), clients.get(1).getDeathDate());
    }

    @Test
    public void shouldReturnKpis() {
        List<ClientEntity> clientList =new ArrayList<>();
        List<Integer> ageList =new ArrayList<>();
        Client client1 = new Client("Karen","Haag",30, new Date());
        Client client2 = new Client("Romina","Haag",20, new Date());

        clientList.add(new ClientEntity(client1));
        clientList.add(new ClientEntity(client2));
        ageList.add(30);
        ageList.add(20);

        Mockito.when(clientRepository.getAges()).thenReturn(ageList);

        Optional<ClientKpi> clientKpi = clientService.getClientKpi();
        assertEquals(25.0, clientKpi.get().getAverageAge());
        assertEquals(5.0, clientKpi.get().getStandardDeviation());
    }
}
