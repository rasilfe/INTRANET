package br.com.capsule.FTP.mvc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "company")
public class Company extends Auditable<String> {


    @Id
    private String id;
    @Indexed(unique = true)
    private String cnpj;
    private byte[] image;
    private String razao;
    private List<Contact> contacts;
    private List<Report> reports;
    private List<StorageFiles> storageFiles;


}
