package com.idat.vuelos.client;


import com.idat.vuelos.model.dto.PersonRequest;
import com.idat.vuelos.model.dto.PersonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PersonClient", url = "http://localhost:8081/api/v1/persons")
public interface PersonClient {

    @PostMapping
    PersonResponse getPerson(@RequestBody PersonRequest request);
}
