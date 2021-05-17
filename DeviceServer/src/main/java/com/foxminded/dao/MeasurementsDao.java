package com.foxminded.dao;

import com.foxminded.dto.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsDao extends CrudRepository<Measurement, Long> {
}
