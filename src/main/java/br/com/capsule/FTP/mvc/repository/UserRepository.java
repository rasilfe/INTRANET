package br.com.capsule.FTP.mvc.repository;

import br.com.capsule.FTP.mvc.model.Contact;
import br.com.capsule.FTP.mvc.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{'info': ?0}", delete = true)
    void deleteBy(Contact info);

    @Query(value = "{'username': ?0}")
    User findByUsername(String username);
}
