package org.mdgd.server.service;

import org.mdgd.server.dao.MeasurementsDao;
import org.mdgd.server.dto.Measurement;
import org.mdgd.server.service.infra.AbstractDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementsServiceImpl extends AbstractDaoService<Measurement, MeasurementsDao> implements MeasurementsService {

    @Autowired
    private MeasurementsDao dao;

    @Override
    protected MeasurementsDao getDao() {
        return dao;
    }
}
