package com.fruit.service.client;

import com.fruit.converter.CorporationConverter;
import com.fruit.dto.CorporationDTO;
import com.fruit.entity.Corporation;
import com.fruit.manager.CorporationManager;
import com.fruit.service.CorporationLocalService;
import com.fruit.service.api.CorporationRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlei6 on 2016/8/7.
 */
@Service("corporationService")
public class CorporationServiceImpl implements CorporationRemoteService, CorporationLocalService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CorporationManager.class);

    @Autowired
    private CorporationManager corporationManager;

    @Override
//    @Cacheable(cacheNames = "mdc:corporation:username", key = "'/corporationService/remoteGetByAccount/'.concat(#username)")
    public CorporationDTO remoteGet(String id) {
        return CorporationConverter.convertDTO(corporationManager.get(id));
    }

    @Override
//    @Cacheable(cacheNames = "mdc:corporation:name", key = "'/corporationService/remoteFindByName/'.concat(#name)")
    public List<CorporationDTO> remoteFindByName(String name) {
        List<CorporationDTO> corporationDTOs = new ArrayList<>();
        corporationManager.findByName(name).forEach(corporation -> {
            CorporationDTO corporationDTO = CorporationConverter.convertDTO(corporation);
            corporationDTOs.add(corporationDTO);
        });
        return corporationDTOs;
    }

    @Override
//    @Cacheable(cacheNames = "mdc:corporation:contact", key = "'/corporationService/remoteFindByContact/'.concat(#contact)")
    public List<CorporationDTO> remoteFindByContact(String contact) {
        List<CorporationDTO> corporationDTOs = new ArrayList<>();
        corporationManager.findByContact(contact).forEach(corporation -> {
            CorporationDTO corporationDTO = CorporationConverter.convertDTO(corporation);
            corporationDTOs.add(corporationDTO);
        });
        return corporationDTOs;
    }

    @Override
//    @Cacheable(cacheNames = "mdc:corporation:legalPerson", key = "'/corporationService/remoteFindByLegalPerson/'.concat(#legalPerson)")
    public List<CorporationDTO> remoteFindByLegalPerson(String legalPerson) {
        List<CorporationDTO> corporationDTOs = new ArrayList<>();
        corporationManager.findByLegalPerson(legalPerson).forEach(corporation -> {
            CorporationDTO corporationDTO = CorporationConverter.convertDTO(corporation);
            corporationDTOs.add(corporationDTO);
        });
        return corporationDTOs;
    }

    @Override
    public Page<CorporationDTO> remotePage(Pageable pageable, String name, String legalPerson, String contact) {
        Page<Corporation> page = corporationManager.page(pageable, name, legalPerson, contact);
        Converter<Corporation, CorporationDTO> converter = corporation -> CorporationConverter.convertDTO(corporation);
        return page.map(converter);
    }

    @Override
    public CorporationDTO insert(CorporationDTO corporationDTO) {
        return CorporationConverter.convertDTO(corporationManager.save(CorporationConverter.convertEntity(corporationDTO)));
    }

    @Override
//    @CacheEvict(cacheNames = {"mdc:corporation:username", "mdc:corporation:id", "mdc:corporation:name", "mdc:corporation:contact", "mdc:corporation:legalPerson"}, allEntries = true, beforeInvocation = true)
    public CorporationDTO update(CorporationDTO corporationDTO) {
        return CorporationConverter.convertDTO(corporationManager.save(CorporationConverter.convertEntity(corporationDTO)));
    }

    @Override
//    @CacheEvict(cacheNames = {"mdc:corporation:username", "mdc:corporation:id", "mdc:corporation:name", "mdc:corporation:contact", "mdc:corporation:legalPerson"}, allEntries = true, beforeInvocation = true)
    public void batchEnable(List<CorporationDTO> corporationDTOs) {
        List<Corporation> corporations = new ArrayList<>();
        corporationDTOs.forEach(corporationDTO -> {
            Corporation corporation = CorporationConverter.convertEntity(corporationDTO);
            corporations.add(corporation);
        });
        corporationManager.batch(corporations);
    }

    @Override
//    @CacheEvict(cacheNames = {"mdc:corporation:username", "mdc:corporation:id", "mdc:corporation:name", "mdc:corporation:contact", "mdc:corporation:legalPerson"}, allEntries = true, beforeInvocation = true)
    public void batchDisable(List<CorporationDTO> corporationDTOs) {
        List<Corporation> corporations = new ArrayList<>();
        corporationDTOs.forEach(corporationDTO -> {
            Corporation corporation = CorporationConverter.convertEntity(corporationDTO);
            corporations.add(corporation);
        });
        corporationManager.batch(corporations);
    }

    @Override
//    @CacheEvict(cacheNames = {"mdc:corporation:username", "mdc:corporation:id", "mdc:corporation:name", "mdc:corporation:contact", "mdc:corporation:legalPerson"}, allEntries = true, beforeInvocation = true)
    public CorporationDTO delete(CorporationDTO corporationDTO) {
        return CorporationConverter.convertDTO(corporationManager.save(CorporationConverter.convertEntity(corporationDTO)));
    }

    @Override
//    @CacheEvict(cacheNames = {"mdc:corporation:username", "mdc:corporation:id", "mdc:corporation:name", "mdc:corporation:contact", "mdc:corporation:legalPerson"}, allEntries = true, beforeInvocation = true)
    public void batchDelete(List<CorporationDTO> corporationDTOs) {
        List<Corporation> corporations = new ArrayList<>();
        corporationDTOs.forEach(corporationDTO -> {
            Corporation corporation = CorporationConverter.convertEntity(corporationDTO);
            corporations.add(corporation);
        });
        corporationManager.batch(corporations);
    }

    @Override
//    @CacheEvict(cacheNames = "mdc:corporation", allEntries = true, beforeInvocation = true)
    public CorporationDTO adjust(CorporationDTO corporationDTO) {
        return CorporationConverter.convertDTO(corporationManager.save(CorporationConverter.convertEntity(corporationDTO)));
    }
}
