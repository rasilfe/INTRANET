package br.com.capsule.FTP.mvc.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Calendar;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedBy
    protected U createdBy;
    @CreatedDate
    protected Calendar createdDate;
    @LastModifiedBy
    protected U lastModifiedBy;
    @LastModifiedDate
    protected Calendar lastModifiedDate;

}