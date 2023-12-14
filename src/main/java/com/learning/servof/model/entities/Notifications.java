package com.learning.servof.model.entities;

import com.learning.servof.model.audit.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notifications extends AbstractEntity<String> implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String msg;
	private boolean isView;
	private String type;
	private boolean isList;

	@ManyToOne
	private AppUser user;
	@ManyToOne
	private Quote quote;
	@ManyToOne
	private Comment comment;
	@ManyToOne
	private Problem problem;
}
