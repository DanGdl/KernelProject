package com.foxminded.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.foxminded.dao.DaoException;
import com.foxminded.dto.Device;
import com.foxminded.dto.Measurement;
import com.foxminded.service.device.DevicesService;
import com.foxminded.service.measurement.MeasurementsService;
import com.foxminded.util.CollectionsUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/measurements")
public class MeasurementsController {

    @Autowired
    private MeasurementsService service;

    @Autowired
	private DevicesService devicesService;
    
    @GetMapping({"", "/"})
    public String action(Map<String, Object> model, @RequestParam Map<String, String> body) {
        String status = body.get("status");
        if (Strings.isEmpty(status)) {
            try {
                model.put("entities", service.get(new LinkedList<>()));
            } catch (DaoException e) {
                status = "Error, when reading entities";
            }
        }
        model.put("mode", "list");
        model.put("status", status);
        return "measurements";
    }

    @PostMapping({"", "/"})
    public String add(Map<String, Object> model, @RequestParam Map<String, String> body) {
        final String action = body.get("action");
        String status = null;
        if (!Strings.isEmpty(action)) {
            final Measurement entity = new Measurement();
            if (!Strings.isEmpty(body.get("id"))) {
                entity.setId(Long.parseLong(body.get("id")));
            }
            try {
            	// TODO: validate not empty
            	
                entity.setDestinationAddress(body.get("destinationAddress").trim());
                entity.setSourceAddress(body.get("sourceAddress").trim());
                entity.setGasPressure(Integer.parseInt(body.get("gasPressure").trim()));
                entity.setValvesState(Integer.parseInt(body.get("valvesState").trim()));
                entity.setPipeTemperature(Integer.parseInt(body.get("pipeTemperature").trim()));
                entity.setPayload(body.get("payload").trim());

                switch (action) {
                    case ("editAction"):
                        try {
                        	String destination = entity.getDestinationAddress();
                			List<Device> devices = devicesService.getByAddress(new ArrayList<>(Collections.singletonList(destination)));
                			if (CollectionsUtil.isEmpty(devices)) {
                				devices.add(new Device("Device " + destination, destination, Collections.singletonList(entity)));
                			} else {
                				devices.get(0).getMeasurements().add(entity);
                			}
                			service.save(Collections.singletonList(entity));
                			devicesService.save(devices);
                        } catch (DaoException e) {
                            status = "Error, when update entities";
                        }
                        break;
                    case ("deleteAction"):
                        try {
                            service.deleteById(entity.getId());
                        } catch (DaoException e) {
                            status = "Error, when delete entities";
                        }
                        break;
                }
            } catch (Throwable e) {
                e.printStackTrace();
                body.put("status", "Some data is not valid. " + e.getMessage());
            }

        }
        body.put("status", status);
        return action(model, body);
    }

    @GetMapping("/{id}/edit")
    public String edit(Map<String, Object> model, @PathVariable("id") Integer id) throws DaoException {
        model.put("mode", "edit");
        final Optional<Measurement> entity = service.get(id.longValue());
        model.put("entity", entity.orElse(null));
        return "measurements";
    }

    @GetMapping("/{id}/delete")
    public String delete(Map<String, Object> model, @PathVariable("id") Integer id) throws DaoException {
        model.put("mode", "delete");
        final Optional<Measurement> entity = service.get(id.longValue());
        model.put("entity", entity.orElse(null));
        return "measurements";
    }
}
