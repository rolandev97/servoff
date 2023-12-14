package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.AppUser;
import com.learning.servof.model.entities.Professions;
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
public class ProfessionsDto implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;

	private List<AppUserDto> appUserDtos;

	public static ProfessionsDto fromEntity(Professions profession) {
		ProfessionsDto professionsDto = new ProfessionsDto();
		professionsDto.setId(profession.getId());
		professionsDto.setNom(profession.getNom());
		professionsDto.setAppUserDtos(profession.getUser().stream()
				.map(AppUserDto::fromEntity).collect(Collectors.toList()));

		return professionsDto;
	}
}
