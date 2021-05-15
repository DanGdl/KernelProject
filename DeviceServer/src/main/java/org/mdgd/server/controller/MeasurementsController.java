package org.mdgd.server.controller;

import org.apache.logging.log4j.util.Strings;
import org.mdgd.server.dao.infra.DaoException;
import org.mdgd.server.dto.Measurement;
import org.mdgd.server.service.MeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class MeasurementsController {

    @Autowired
    private MeasurementsService service;

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
        return "course";
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
                entity.setDestinationAddress(Integer.parseInt(body.get("destinationAddress")));
                entity.setSourceAddress(Integer.parseInt(body.get("sourceAddress")));
                entity.setGasPressure(Integer.parseInt(body.get("gasPressure")));
                entity.setValvesState(Integer.parseInt(body.get("valvesState")));
                entity.setPipeTemperature(Integer.parseInt(body.get("pipeTemperature")));
                entity.setPayload(body.get("payload"));

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
        final Optional<Measurement> entity = service.get(id.longValue());
        model.put("entity", entity.orElseGet(() -> null));
        return "course";
    }

    @GetMapping("/{id}/delete")
    public String delete(Map<String, Object> model, @PathVariable("id") Integer id) throws DaoException {
        model.put("mode", "delete");
        final Optional<Measurement> entity = service.get(id.longValue());
        model.put("person", entity.orElseGet(() -> null));
        return "course";
    }
}
