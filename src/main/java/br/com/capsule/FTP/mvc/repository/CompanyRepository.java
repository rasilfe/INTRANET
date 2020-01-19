package br.com.capsule.FTP.mvc.repository;

import br.com.capsule.FTP.mvc.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
}
