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


@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser extends AbstractEntity<String> implements Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lastName;
	private String firstName;
	private String address;
	private String telephone;
	private String email;
	private String password;
	private String bornDate;
	private String imageUrl;
	private boolean statut;

	@OneToMany(mappedBy = "user")
	private List<Training> training;
	@OneToMany(mappedBy = "user")
	private List<ProfessionalExperience> professionalExperiences;
	@ManyToOne()
	private Role role;
	@OneToMany(mappedBy = "user")
	private List<UsersProblems> usersProblems;
	@OneToMany(mappedBy = "user")
	private List<Notifications> notifications;
	@ManyToOne
	private Professions profession;
	@OneToMany(mappedBy = "appUser")
	private List<Comment> comments;
	@OneToMany(mappedBy = "appUser")
	private List<Quote> quotes;


}
