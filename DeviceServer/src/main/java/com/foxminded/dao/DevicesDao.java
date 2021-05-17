package com.foxminded.dao;

import com.foxminded.dto.Device;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesDao extends CrudRepository<Device, Long> {

	@Query("select u from Device u where u.address in :addresses")
	List<Device> getByAddress(@Param("addresses") List<String> addresses);
}
