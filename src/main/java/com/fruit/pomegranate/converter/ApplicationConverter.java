package com.fruit.pomegranate.converter;

import com.fruit.pomegranate.dto.ApplicationDTO;
import com.fruit.pomegranate.entity.Application;
import org.springframework.beans.BeanUtils;

/**
 * Created by hanlei6 on 2016/9/30.
 */
public class ApplicationConverter {
    public static ApplicationDTO convertDTO(Application application) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        BeanUtils.copyProperties(application, applicationDTO, "menus");
        return applicationDTO;
    }

    public static Application convertEntity(ApplicationDTO applicationDTO) {
        Application application = new Application();
        BeanUtils.copyProperties(applicationDTO, application);
        return application;
    }
}
