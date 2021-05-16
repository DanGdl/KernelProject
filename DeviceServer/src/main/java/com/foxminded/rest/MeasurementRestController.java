package com.foxminded.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foxminded.dao.DaoException;
import com.foxminded.domain.Measurement;
import com.foxminded.service.measurement.MeasurementsService;
import com.foxminded.util.CollectionsUtil;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
public class MeasurementRestController {

	@Autowired
	private MeasurementsService service;

	@GetMapping("/rest/measurements")
	public List<Measurement> readAll() {
		final List<Measurement> entities = new LinkedList<>();
		try {
			entities.addAll(service.get(Collections.emptyList()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

	@GetMapping("/rest/measurements/{id}")
	public List<Measurement> read(@PathVariable Long id) {
		final List<Measurement> entities = new LinkedList<>();
		try {
			entities.addAll(service.get(Collections.singletonList(id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

	@PostMapping("/rest/measurements")
	public void update(@RequestBody List<Measurement> entities) {
		if (CollectionsUtil.isEmpty(entities)) return;
		try {
			service.save(entities);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping("/rest/measurements/{id}/delete")
	public void update(@PathVariable Long id) {
		try {
			service.deleteById(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
