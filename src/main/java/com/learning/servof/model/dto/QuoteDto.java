package com.learning.servof.model.dto;

import com.learning.servof.model.entities.Quote;
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
public class QuoteDto implements Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;
	private int id;
	private String timeProcessing;
	private String price;
	private boolean Status;

	private ProblemDto problemDto;
	private AppUserDto appUserDto;
	private List<NotificationsDto> notificationsDtos;

    public static QuoteDto fromEntity(Quote quote) {
		QuoteDto quoteDto = new QuoteDto();
		quoteDto.setId(quote.getId());
		quoteDto.setTimeProcessing(quote.getTimeProcessing());
		quoteDto.setPrice(quote.getPrice());
		quoteDto.setStatus(quote.isStatus());
		quoteDto.setProblemDto(ProblemDto.fromEntity(quote.getProblem()));
		quoteDto.setAppUserDto(AppUserDto.fromEntity(quote.getAppUser()));
		quoteDto.setNotificationsDtos(quote.getNotifications().stream()
				.map(NotificationsDto::fromEntity).collect(Collectors.toList()));

		return quoteDto;
    }
}
