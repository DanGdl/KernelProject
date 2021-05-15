package org.mdgd.server.dao;

import org.mdgd.server.dto.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsDao extends CrudRepository<Measurement, Long> {
}
