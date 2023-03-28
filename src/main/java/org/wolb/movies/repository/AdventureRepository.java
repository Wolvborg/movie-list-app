package org.wolb.movies.repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.wolb.movies.model.Adventure;

public interface AdventureRepository extends MongoRepository<Adventure, ObjectId> {
    public List<Adventure> findByCountry(String country);

    public List<Adventure> findByState(String state);
}