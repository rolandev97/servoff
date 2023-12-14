package com.learning.servof.model.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.learning.servof.model.audit.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity()
@Getter
@Setter
public class Quote extends AbstractEntity<String> implements Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String timeProcessing;
	private String price;
	private boolean Status;

	@ManyToOne
	private Problem problem;
	@ManyToOne
	private AppUser appUser;
	@OneToMany(mappedBy = "quote")
	private List<Notifications> notifications;

}
