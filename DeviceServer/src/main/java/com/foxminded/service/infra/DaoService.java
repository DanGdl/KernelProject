package com.foxminded.service.infra;

import java.util.List;
import java.util.Optional;

import com.foxminded.dao.DaoException;

public interface DaoService<T> {
	void save(List<T> entities) throws DaoException;

	List<T> get(List<Long> ids) throws DaoException;

	Optional<T> get(Long id) throws DaoException;

	void delete(List<T> entities) throws DaoException;

	void deleteById(Long id) throws DaoException;
}
