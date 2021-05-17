package com.foxminded.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foxminded.dao.DaoException;
import com.foxminded.dto.Device;
import com.foxminded.dto.Measurement;
import com.foxminded.service.device.DevicesService;
import com.foxminded.service.measurement.MeasurementsService;
import com.foxminded.util.CollectionsUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class MeasurementRestController {

	@Autowired
	private MeasurementsService service;

	@Autowired
	private DevicesService devicesService;
	
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
		if (CollectionsUtil.isEmpty(entities)) {
			return;
		}
		try {
			Map<String, List<Measurement>> measurements = new HashMap<>();
			for (Measurement m : entities) {
				if (!measurements.containsKey(m.getSourceAddress())) {
					measurements.put(m.getSourceAddress(), new ArrayList<>());
				}
				measurements.get(m.getSourceAddress()).add(m);
			}
			List<Device> devices = devicesService.getByAddress(new ArrayList<>(measurements.keySet()));
			for (Device d : devices) {
				d.getMeasurements().addAll(measurements.remove(d.getAddress()));
			}
			for (Map.Entry<String, List<Measurement>> e : measurements.entrySet()) {
				devices.add(new Device("Device " + e.getKey(), e.getKey(), e.getValue()));
			}
			service.save(entities);
			devicesService.save(devices);
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
