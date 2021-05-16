package com.foxminded.dao;

import com.foxminded.domain.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesDao extends CrudRepository<Device, Long> {
}
