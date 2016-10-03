package com.fruit.pomegranate.service.client;

import com.fruit.pomegranate.converter.ApplicationConverter;
import com.fruit.pomegranate.dto.ApplicationDTO;
import com.fruit.pomegranate.manager.ApplicationManager;
import com.fruit.pomegranate.service.api.ApplicationRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hanlei6 on 2016/10/4.
 */
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationRemoteService {
    @Autowired
    private ApplicationManager applicationManager;

    @Override
    public ApplicationDTO get(String id) {
        return ApplicationConverter.convertDTO(applicationManager.get(id));
    }

    @Override
    public ApplicationDTO save(ApplicationDTO application) {
        return ApplicationConverter.convertDTO(applicationManager.save(ApplicationConverter.convertEntity(application)));
    }
}
