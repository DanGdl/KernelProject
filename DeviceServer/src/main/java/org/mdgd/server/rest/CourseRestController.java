package org.mdgd.server.rest;

import org.mdgd.server.dao.infra.DaoException;
import org.mdgd.server.dto.Measurement;
import org.mdgd.server.service.MeasurementsService;
import org.mdgd.server.util.CollectionsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
public class CourseRestController {

	@Autowired
	private MeasurementsService service;

	@GetMapping("/rest/course")
	public List<Measurement> readAll() {
		final List<Measurement> entities = new LinkedList<>();
		try {
			entities.addAll(service.get(Collections.emptyList()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

	@GetMapping("/rest/course/{id}")
	public List<Measurement> read(@PathVariable Long id) {
		final List<Measurement> entities = new LinkedList<>();
		try {
			entities.addAll(service.get(Collections.singletonList(id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

	@PostMapping("/rest/course")
	public void update(@RequestBody List<Measurement> entities) {
		if (CollectionsUtil.isEmpty(entities)) return;
		try {
			service.save(entities);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping("/rest/course/{id}/delete")
	public void update(@PathVariable Long id) {
		try {
			service.deleteById(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
