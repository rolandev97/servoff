package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.AppUser;
import com.learning.servof.model.entities.Comment;
import com.learning.servof.model.entities.Notifications;
import com.learning.servof.model.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto implements Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;
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
	private String confirmPass;
	private MultipartFile multipleFileData;

	private List<TrainingDto> trainingDtos;
	private List<ProfessionalExperienceDto> professionalExperienceDtos;
	private RoleDto roleDto;
	private List<UsersProblemsDto> usersProblemsDtos;
	private List<NotificationsDto> notificationsDtos;
	private ProfessionsDto professionsDto;
	private List<CommentDto> commentDtos;
	private List<QuoteDto> quoteDtos;


	public static AppUserDto fromEntity(AppUser appUser){
		AppUserDto appUserDto = new AppUserDto();
		appUserDto.setId(appUser.getId());
		appUserDto.setAddress(appUser.getAddress());
		appUserDto.statut = appUser.isStatut();
		appUserDto.setEmail(appUser.getEmail());
		appUserDto.setFirstName(appUser.getFirstName());
		appUserDto.setBornDate(appUser.getBornDate());
		appUserDto.setLastName(appUser.getLastName());
		appUserDto.setTelephone(appUser.getTelephone());
		appUserDto.setImageUrl(appUser.getImageUrl());
		appUserDto.setTrainingDtos(appUser.getTraining().stream()
				.map(TrainingDto::fromEntity).collect(Collectors.toList()));
		appUserDto.setProfessionalExperienceDtos(appUser.getProfessionalExperiences().stream()
				.map(ProfessionalExperienceDto::fromEntity).collect(Collectors.toList()));
		appUserDto.setRoleDto(RoleDto.fromEntity(appUser.getRole()));
		appUserDto.setNotificationsDtos(appUser.getNotifications().stream()
				.map(NotificationsDto::fromEntity).collect(Collectors.toList()));
		appUserDto.setProfessionsDto(ProfessionsDto.fromEntity(appUser.getProfession()));
		appUserDto.setCommentDtos(appUser.getComments().stream()
				.map(CommentDto::fromEntity).collect(Collectors.toList()));
		appUserDto.setQuoteDtos(appUser.getQuotes().stream()
				.map(QuoteDto::fromEntity).collect(Collectors.toList()));

		return appUserDto;
	}


}
