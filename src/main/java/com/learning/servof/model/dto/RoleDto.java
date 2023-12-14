package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.Role;
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
public class RoleDto implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;
	private int id;
	private String role;

	private List<AppUserDto> appUserDtos;

    public static RoleDto fromEntity(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setRole(role.getRole());
		roleDto.setAppUserDtos(role.getUsers().stream()
				.map(AppUserDto::fromEntity).collect(Collectors.toList()));

		return roleDto;
    }
}
