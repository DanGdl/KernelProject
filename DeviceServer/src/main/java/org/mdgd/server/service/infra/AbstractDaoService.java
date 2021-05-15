package org.mdgd.server.service.infra;

import org.mdgd.server.dao.infra.DaoException;
import org.mdgd.server.util.CollectionsUtil;
import org.mdgd.server.util.Streams;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDaoService<T, D extends CrudRepository<T, Long>> implements DaoService<T> {

	@Override
	public void save(List<T> entities) throws DaoException {
		if (CollectionsUtil.isEmpty(entities)) {
			return;
		}
		getDao().saveAll(entities);
	}

	protected abstract D getDao();

	@Override
	public List<T> get(List<Long> ids) throws DaoException {
		ids = Streams.filterNonNullToList(ids);
		return Streams.filterNonNullToList(CollectionsUtil.isEmpty(ids) ? getDao().findAll() : getDao().findAllById(ids));
	}

	@Override
	public Optional<T> get(Long id) throws DaoException {
		if (id == null) {
			return Optional.empty();
		}
		return getDao().findById(id);
	}

	@Override
	public void delete(List<T> entities) throws DaoException {
		if (CollectionsUtil.isEmpty(entities)) {
			return;
		}
		getDao().deleteAll(entities);
	}

	@Override
	public void deleteById(Long id) throws DaoException {
		if (id == null) {
			return;
		}
		getDao().deleteById(id);
	}
}
