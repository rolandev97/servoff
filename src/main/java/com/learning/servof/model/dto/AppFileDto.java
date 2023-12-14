package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.AppFile;
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
public class AppFileDto implements Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;
	private int id;
	private String fileUrl;

	private TrainingDto trainingDto;
	private ProblemDto problemDto;

	public static AppFileDto fromEntity(AppFile appFile) {
		AppFileDto appFileDto = new AppFileDto();
		appFileDto.setId(appFile.getId());
		appFileDto.setFileUrl(appFile.getFileUrl());
		appFileDto.setTrainingDto(TrainingDto.fromEntity(appFile.getTraining()));
		appFileDto.setProblemDto(ProblemDto.fromEntity(appFile.getProblem()));

		return appFileDto;
	}
}
