package com.foxminded.service.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.dao.DevicesDao;
import com.foxminded.dto.Device;
import com.foxminded.service.infra.AbstractDaoService;

@Service
public class DevicesServiceImpl extends AbstractDaoService<Device, DevicesDao> implements DevicesService {

    @Autowired
    private DevicesDao dao;

    @Override
    protected DevicesDao getDao() {
        return dao;
    }

	@Override
	public List<Device> getByAddress(List<String> addresses) {
		return getDao().getByAddress(addresses);
	}
}
