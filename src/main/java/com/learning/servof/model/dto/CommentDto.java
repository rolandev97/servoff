package com.learning.servof.model.dto;


import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	private int id;
	private String content;

	private AppUserDto appUserDto;
	private ProblemDto problemDto;
	private List<NotificationsDto> notificationsDtos;

    public static CommentDto fromEntity(Comment comment) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.content = comment.getContent();
		commentDto.setAppUserDto(AppUserDto.fromEntity(comment.getAppUser()));
		commentDto.setProblemDto(ProblemDto.fromEntity(comment.getProblem()));
		commentDto.setNotificationsDtos(comment.getNotifications().stream()
				.map(NotificationsDto::fromEntity).collect(Collectors.toList()));

		return commentDto;
    }
}
