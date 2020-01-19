package br.com.capsule.FTP.mvc.model;

import br.com.capsule.FTP.mvc.enums.Envs;
import br.com.capsule.FTP.mvc.enums.Types;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report extends Auditable<String> {

    @Enumerated(EnumType.STRING)
    private Envs env;

    @Enumerated(EnumType.STRING)
    private Types type;

    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;
    private String param7;
    private String param8;
    private String param9;
    private String param10;
    private String obs;

}
