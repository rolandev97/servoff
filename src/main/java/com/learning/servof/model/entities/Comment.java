package com.learning.servof.model.entities;

import com.learning.servof.model.audit.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends AbstractEntity<String> implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private int sender;
	private int receiver;

	@ManyToOne
	private AppUser appUser;
	@ManyToOne
	private Problem problem;
	@OneToMany(mappedBy = "comment")
	private List<Notifications> notifications;
	
}
