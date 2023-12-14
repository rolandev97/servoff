package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.Notifications;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationsDto implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	private int id;
	private String msg;
	private boolean isView;
	private String type;
	private boolean isList;


	private AppUserDto userDto;
	private QuoteDto quoteDto;
	private CommentDto commentDto;
	private ProblemDto problemDto;

    public static NotificationsDto fromEntity(Notifications notifications) {
		NotificationsDto notificationsDto = new NotificationsDto();
		notificationsDto.setId(notifications.getId());
		notificationsDto.setMsg(notifications.getMsg());
		notificationsDto.isView = notifications.isView();
		notificationsDto.type = notifications.getType();
		notificationsDto.isList = notifications.isList();
		notificationsDto.setUserDto(AppUserDto.fromEntity(notifications.getUser()));
		notificationsDto.setQuoteDto(QuoteDto.fromEntity(notifications.getQuote()));
		notificationsDto.setCommentDto(CommentDto.fromEntity(notifications.getComment()));
		notificationsDto.setProblemDto(ProblemDto.fromEntity(notifications.getProblem()));

		return notificationsDto;
    }
}
