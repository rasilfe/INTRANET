package br.com.capsule.FTP.mvc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "company")
public class Company extends Auditable<String> {


    @Id
    private String id;
    @Indexed(unique = true)
    @CNPJ
    private String cnpj;
    private byte[] image;
    @Size(max = 115)
    private String razao;
    private List<Contact> contacts;
    private List<Report> reports;
    private List<StorageFiles> storageFiles;


}
