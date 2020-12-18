package com.example.accessingneo4jdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    List<Account> findByAccountNumber(@Param("accountNumber") String accountNumber);
}
