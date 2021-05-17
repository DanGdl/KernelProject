package com.foxminded.service.device;

import java.util.List;

import com.foxminded.dto.Device;
import com.foxminded.service.infra.DaoService;

public interface DevicesService extends DaoService<Device> {

	List<Device> getByAddress(List<String> addresses);
}
