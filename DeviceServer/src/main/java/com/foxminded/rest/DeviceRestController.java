package com.foxminded.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foxminded.dao.DaoException;
import com.foxminded.dto.Device;
import com.foxminded.service.device.DevicesService;
import com.foxminded.util.CollectionsUtil;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
public class DeviceRestController {

	@Autowired
	private DevicesService service;

	@GetMapping("/rest/devices")
	public List<Device> readAll() {
		final List<Device> entities = new LinkedList<>();
		try {
			entities.addAll(service.get(Collections.emptyList()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

	@GetMapping("/rest/devices/{id}")
	public List<Device> read(@PathVariable Long id) {
		final List<Device> entities = new LinkedList<>();
		try {
			entities.addAll(service.get(Collections.singletonList(id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

	@PostMapping("/rest/devices")
	public void update(@RequestBody List<Device> entities) {
		if (CollectionsUtil.isEmpty(entities)) {
			return;
		}
		try {
			service.save(entities);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping("/rest/devices/{id}/delete")
	public void update(@PathVariable Long id) {
		try {
			service.deleteById(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
