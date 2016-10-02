package com.fruit.pomegranate.repository;

import com.fruit.pomegranate.entity.Corporation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hanlei6 on 2016/7/15.
 */
@Repository
public interface CorporationRepository extends BaseRepository<Corporation, String>, JpaSpecificationExecutor {

    List<Corporation> findByNameLike(String name);

    List<Corporation> findByContactLike(String contact);

    List<Corporation> findByLegalPersonLike(String legalPerson);
}
