package dev.artsman.poc.hexagonal.arch.adapter.outbound.repository;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.entity.CustomerEntity;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, UUID> {}
