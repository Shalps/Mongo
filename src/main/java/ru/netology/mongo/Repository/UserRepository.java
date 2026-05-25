package ru.netology.mongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.netology.mongo.model.User;

import java.util.List;

public interface UserRepository  extends MongoRepository<User,String> {
    List<User> findByName(String name);
    List<User> findByAge(Integer age);
}
