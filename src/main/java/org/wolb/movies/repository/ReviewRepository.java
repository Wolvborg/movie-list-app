package org.wolb.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.wolb.movies.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
