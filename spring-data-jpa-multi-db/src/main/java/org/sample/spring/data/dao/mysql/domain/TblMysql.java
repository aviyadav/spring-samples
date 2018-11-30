package org.sample.spring.data.dao.mysql.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_mysql")
public class TblMysql {

    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "CREATED_DATE")
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
