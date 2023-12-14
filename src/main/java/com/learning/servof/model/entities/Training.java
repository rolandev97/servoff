package com.learning.servof.model.entities;

import com.learning.servof.model.audit.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Training extends AbstractEntity<String> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private Date startingDate;
    private Date endDate;

    @ManyToOne()
    private AppUser user;
    @OneToMany(mappedBy = "training")
    private List<AppFile> appFiles;


}
