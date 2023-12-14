package com.learning.servof.model.entities;

import com.learning.servof.model.audit.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "problems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problem extends AbstractEntity<String> implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private int statut;
	private Date dateOfResolution;
	private String imageUrl;
	private String title;

	@OneToMany(mappedBy = "problem")
	private List<UsersProblems> usersProblems;
	@OneToMany(mappedBy = "problem")
	private List<AppFile> appFiles;
	@OneToMany(mappedBy = "problem")
	private List<Comment> comments;
	@OneToMany(mappedBy = "problem")
	private List<Quote> quotes;
	@OneToMany(mappedBy = "problem")
	private List<Notifications> notifications;

}
