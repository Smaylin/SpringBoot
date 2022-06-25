package com.talendig.springboottalendig.bbdd.mongo.repository;

import com.talendig.springboottalendig.bbdd.mongo.model.Colegio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ColegioRepository extends MongoRepository<Colegio, String> {
}
