package br.com.capsule.FTP.mvc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;


@Data
@Document(collection = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends Auditable<String> {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;
    private boolean enable;
    private String profile;
    private Contact info;

    @DBRef
    private List<Company> companies;
}
