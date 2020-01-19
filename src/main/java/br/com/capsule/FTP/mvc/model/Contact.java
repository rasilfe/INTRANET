package br.com.capsule.FTP.mvc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact extends Auditable<String> {

    private byte[] image;
    @Indexed
    private String name;
    private String phone;
    private String cellphone;
    private String skype;
    private String role;
    private String email;
    private String dateOfBirth;
}
