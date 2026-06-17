package com.mspersona.demo.service;

import com.mspersona.demo.model.dto.PersonRequest;
import com.mspersona.demo.model.dto.PersonResponse;

public interface PersonService {
    PersonResponse getPersonByDocument(PersonRequest request);
}
