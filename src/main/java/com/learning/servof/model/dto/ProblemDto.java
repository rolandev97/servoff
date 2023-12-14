package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.Problem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDto implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private int statut;
	private Date dateOfResolution;
	private String title;
	private MultipartFile[] multipartFilesData;

	private List<UsersProblemsDto> usersProblemsDtos;
	private List<AppFileDto> appFileDtos;
	private List<CommentDto> commentsDtos;
	private List<QuoteDto> quotesDtos;
	private List<NotificationsDto> notificationsDtos;

	public static ProblemDto fromEntity(Problem problem){
		ProblemDto problemDto = new ProblemDto();
		problemDto.setId(problem.getId());
		problemDto.setDescription(problem.getDescription());
		problemDto.setStatut(problem.getStatut());
		problemDto.setDateOfResolution(problem.getDateOfResolution());
		problemDto.setTitle(problem.getTitle());
		problemDto.setCommentsDtos(problem.getComments().stream()
				.map(CommentDto::fromEntity).collect(Collectors.toList()));
		problemDto.setAppFileDtos(problem.getAppFiles().stream()
				.map(AppFileDto::fromEntity).collect(Collectors.toList()));
		problemDto.setQuotesDtos(problem.getQuotes().stream()
				.map(QuoteDto::fromEntity).collect(Collectors.toList()));
		problemDto.setNotificationsDtos(problem.getNotifications().stream()
				.map(NotificationsDto::fromEntity).collect(Collectors.toList()));

		return problemDto;
	}

}
