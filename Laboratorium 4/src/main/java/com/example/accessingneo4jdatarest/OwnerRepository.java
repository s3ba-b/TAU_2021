package com.example.accessingneo4jdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "owners", path = "owners")
public interface OwnerRepository extends PagingAndSortingRepository<Owner, Long> {

    List<Owner> findBySurname(@Param("surname") String surname);

}
