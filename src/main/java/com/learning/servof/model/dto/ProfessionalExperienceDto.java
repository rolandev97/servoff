package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.ProfessionalExperience;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalExperienceDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String content;
    private Date startingDate;
    private Date endDate;

    private AppUserDto appUserDto;

    public static ProfessionalExperienceDto fromEntity(ProfessionalExperience professionalExperience) {
        ProfessionalExperienceDto professionalExperienceDto = new ProfessionalExperienceDto();
        professionalExperienceDto.setId(professionalExperience.getId());
        professionalExperienceDto.setContent(professionalExperience.getContent());
        professionalExperienceDto.setStartingDate(professionalExperience.getStartingDate());
        professionalExperienceDto.setEndDate(professionalExperience.getEndDate());
        professionalExperienceDto.setAppUserDto(AppUserDto.fromEntity(professionalExperience.getUser()));

        return professionalExperienceDto;
    }
}
