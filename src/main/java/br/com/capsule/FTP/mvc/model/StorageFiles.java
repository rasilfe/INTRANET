package br.com.capsule.FTP.mvc.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageFiles extends Auditable<String>{

    private String category;
    private String name;
    private Long size;
    private byte[] file;

}
