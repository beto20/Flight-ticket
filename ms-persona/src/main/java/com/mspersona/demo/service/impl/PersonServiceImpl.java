package com.mspersona.demo.service.impl;

import com.mspersona.demo.model.dto.PersonRequest;
import com.mspersona.demo.model.dto.PersonResponse;
import com.mspersona.demo.model.mapper.PersonMapper;
import com.mspersona.demo.repository.PersonRepository;
import com.mspersona.demo.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonResponse getPersonByDocument(PersonRequest request) {
        var entity = repository.findByNumeroDocumento(request.getNumeroDocumento());
        if (entity.isPresent()) {
            return PersonMapper.MAPPER.toPersonResponse(entity.get());
        } else {
            return new PersonResponse();
        }
    }
}
