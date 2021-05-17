package com.foxminded.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.foxminded.dao.DaoException;
import com.foxminded.dto.Device;
import com.foxminded.service.device.DevicesService;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/devices")
public class DevicesController {

    @Autowired
    private DevicesService service;

    @GetMapping({"", "/"})
    public String action(Map<String, Object> model, @RequestParam Map<String, String> body) {
        String status = body.get("status");
        if (Strings.isEmpty(status)) {
            try {
            	List<Device> list = service.get(new LinkedList<>());
                model.put("entities", list);
            } catch (DaoException e) {
                status = "Error, when reading entities";
            }
        }
        model.put("mode", "list");
        model.put("status", status);
        return "devices";
    }

    @PostMapping({"", "/"})
    public String add(Map<String, Object> model, @RequestParam Map<String, String> body) {
        final String action = body.get("action");
        String status = null;
        if (!Strings.isEmpty(action)) {
            final Device entity = new Device();
            if (!Strings.isEmpty(body.get("id"))) {
                entity.setId(Long.parseLong(body.get("id")));
            }
            try {
            	if (Strings.isEmpty(body.get("name")) || Strings.isEmpty(body.get("address"))) {
            		throw new IllegalArgumentException("Name and address must not be empty");
            	}
                entity.setName(body.get("name"));
                entity.setAddress(body.get("address").trim());
                switch (action) {
                    case ("editAction"):
                        try {
                            service.save(Collections.singletonList(entity));
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
        final Optional<Device> entity = service.get(id.longValue());
        model.put("entity", entity.orElse(null));
        return "devices";
    }

    @GetMapping("/{id}/delete")
    public String delete(Map<String, Object> model, @PathVariable("id") Integer id) throws DaoException {
        model.put("mode", "delete");
        final Optional<Device> entity = service.get(id.longValue());
        model.put("entity", entity.orElse(null));
        return "devices";
    }
}
