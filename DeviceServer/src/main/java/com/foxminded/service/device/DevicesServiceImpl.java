package com.foxminded.service.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.dao.DevicesDao;
import com.foxminded.domain.Device;
import com.foxminded.service.infra.AbstractDaoService;

@Service
public class DevicesServiceImpl extends AbstractDaoService<Device, DevicesDao> implements DevicesService {

    @Autowired
    private DevicesDao dao;

    @Override
    protected DevicesDao getDao() {
        return dao;
    }
}
