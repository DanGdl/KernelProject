package com.foxminded.service.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.dao.MeasurementsDao;
import com.foxminded.domain.Measurement;
import com.foxminded.service.infra.AbstractDaoService;

@Service
public class MeasurementsServiceImpl extends AbstractDaoService<Measurement, MeasurementsDao> implements MeasurementsService {

    @Autowired
    private MeasurementsDao dao;

    @Override
    protected MeasurementsDao getDao() {
        return dao;
    }
}
