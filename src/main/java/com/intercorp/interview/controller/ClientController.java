package com.intercorp.interview.controller;

import com.intercorp.interview.dto.Client;
import com.intercorp.interview.dto.ClientKpi;
import com.intercorp.interview.dto.ClientResponse;
import com.intercorp.interview.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Api(tags = "Client")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    private Logger logger = Logger.getLogger("ClientController");


    @ApiOperation(value = "Create a new client", response=Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PostMapping(value = "/creacliente")
    public ResponseEntity<Client> create(@Valid @RequestBody Client client) {
        logger.info(String.format("Creating a new client: %s %s", client.getName(), client.getSurname()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
    }

    @ApiOperation(value = "Get all clients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @GetMapping(value="/listclientes")
    public ResponseEntity<List<ClientResponse>> getAll(){
        logger.info(String.format("Getting all clients"));
        return ResponseEntity.ok(clientService.getAll());
    }

    @ApiOperation(value = "Get all clients kpi")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @GetMapping(value="/kpideclientes")
    public ResponseEntity<ClientKpi> getClientKpi(){
        logger.info(String.format("Getting client kpis"));
        Optional<ClientKpi> clientKpiOpt = clientService.getClientKpi();
        if (!clientKpiOpt.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientKpiOpt.get());
    }



}
