package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
import com.learning.servof.model.entities.Training;
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
public class TrainingDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String content;
    private Date startingDate;
    private Date endDate;
    private MultipartFile[] certificationsFiles;

    private AppUserDto appUserDto;
    private List<AppFileDto> appFilesDtos;


    public static TrainingDto fromEntity(Training training) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setId(training.getId());
        trainingDto.setContent(training.getContent());
        trainingDto.setStartingDate(training.getStartingDate());
        trainingDto.setEndDate(training.getStartingDate());
        trainingDto.setAppFilesDtos(training.getAppFiles().stream()
                .map(AppFileDto::fromEntity).collect(Collectors.toList()));
        trainingDto.setAppUserDto(AppUserDto.fromEntity(training.getUser()));
        return trainingDto;
    }
}
