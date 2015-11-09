package com.inoutcorp.cpq.opportunity.dao;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;

import com.inoutcorp.cpq.opportunity.api.IDao;
import com.inoutcorp.cpq.opportunity.entity.base.IEntity;

@SuppressWarnings({ "hiding", "unchecked", "rawtypes" })
public class GenericJpaDao<E extends IEntity, K extends Serializable>
		implements IDao<E, K> {

	protected EntityManager entityManager;

	@PersistenceContext(unitName = "punit")
	@Qualifier("entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public <E extends IEntity> Long saveOrUpdate(E inEntity)
			throws DataAccessException {

		if (inEntity.getDeletedFlag() == null) {
			inEntity.setDeletedFlag(false);
		}

		if (inEntity.getPkey() == null) {
			entityManager.persist(inEntity);
			return (Long) getEntityManager().getEntityManagerFactory()
					.getPersistenceUnitUtil().getIdentifier(inEntity);
		} else {
			getEntityManager().merge(inEntity);
			return inEntity.getPkey();
		}
	}

	public <E extends IEntity> List<E> findAll(Class<E> inEntityClass,
			Boolean deletedFlag, String orderby, Integer pageSize,
			Integer pageNo) {

		Entity entity = inEntityClass.getAnnotation(Entity.class);

		String entityClsName = inEntityClass.getSimpleName();

		if (entity != null) {

			String eName = entity.name();

			if (eName != null && eName.length() > 0) {
				entityClsName = eName;
			}
		}

		String sQuery = "SELECT instance FROM " + entityClsName + " instance ";

		if (deletedFlag != null) {
			if (deletedFlag) {
				sQuery = sQuery + " where instance.deletedFlag IS true";
			} else {
				sQuery = sQuery + " where instance.deletedFlag IS NOT true";
			}
		}

		if (orderby == null) {
			sQuery = sQuery + " order by instance.createdTime asc";
		} else {
			sQuery = sQuery + " order by instance." + orderby;
		}

		Query query = getEntityManager().createQuery(sQuery);

		if (pageSize != null && pageNo != null) {
			query.setMaxResults(pageSize);
			Integer firstResult = (pageNo - 1) * pageSize;
			query.setFirstResult(firstResult);
		}

		return (List<E>) query.getResultList();
	}

	public <E extends IEntity> List<E> findAll(Class<E> inEntityClass,
			Boolean deletedFlag, Integer pageSize, Integer pageNo) {
		return findAll(inEntityClass, deletedFlag, null, pageSize, pageNo);
	}

	public <E extends IEntity> E find(Class<E> inEntityClass, K pKey) {
		return getEntityManager().find(inEntityClass, pKey);
	}

	public void delete(E entity) {
		entity.setDeletedFlag(Boolean.TRUE);
		getEntityManager().merge(entity);
	}

	public void purge(E inEntity) {
		entityManager.remove(inEntity);
	}

	public <E extends IEntity, obj extends Object> List<E> getEntities(
			Class<E> inElementClass, String queryName,
			HashMap<String, obj> criteria) {

		Query qry = entityManager.createNamedQuery(queryName);

		Set<String> keys = criteria.keySet();

		for (String key : keys) {
			qry.setParameter(key, criteria.get(key));
		}

		Object result;

		try {
			result = qry.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return (List<E>) result;
	}

	public <E extends IEntity, obj> E getEntity(Class<E> inElementClass,
			String queryName, HashMap<String, obj> criteria) {

		Query qry = entityManager.createNamedQuery(queryName);

		Set<String> keys = criteria.keySet();

		for (String key : keys) {
			qry.setParameter(key, criteria.get(key));
		}

		Object result;

		try {
			result = qry.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		if (result != null && ((List) result).size() > 0) {
			return (E) (((List) result).get(0));
		} else {
			return null;
		}
	}

	public Integer executeQuery(String queryName,
			Hashtable<String, Object> criteria) {

		Query q = entityManager.createNamedQuery(queryName);

		if (criteria != null) {

			Enumeration<String> keys = criteria.keys();

			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				q.setParameter(key, criteria.get(key));
			}
		}

		return q.executeUpdate();
	}

	public <E extends IEntity> List<E> findAll(Class<E> inEntityClass,
			Boolean deleted, String orderby) {

		Entity entity = inEntityClass.getAnnotation(Entity.class);

		String entityClsName = inEntityClass.getSimpleName();

		if (entity != null) {
			String eName = entity.name();
			if (eName != null && eName.length() > 0) {
				entityClsName = eName;
			}
		}

		String sQuery = "SELECT instance FROM " + entityClsName + " instance ";
		if (deleted != null) {
			if (deleted) {
				sQuery = sQuery + " where instance.deletedFlag IS true";
			} else {
				sQuery = sQuery + " where instance.deletedFlag IS NOT true";
			}
		}

		if (orderby == null) {
			sQuery = sQuery + " order by instance.createdTime asc";
		} else {
			sQuery = sQuery + " order by instance." + orderby;
		}

		Query query = entityManager.createQuery(sQuery);

		return (List<E>) query.getResultList();
	}

	public <E extends IEntity> List<E> findAll(Class<E> inEntityClass,
			Boolean deletedFlag) {
		return findAll(inEntityClass, deletedFlag, null);
	}

	public <E extends IEntity> List<E> runNativeSQL(Class<E> inElementClass,
			String queryName) {
		List<E> values = entityManager.createNativeQuery(queryName,
				inElementClass).getResultList();
		return values;
	}

	public List executeNativeQuery(String query,
			HashMap<String, Object> criteria) {

		Query q = entityManager.createNativeQuery(query);

		Set<String> keys = criteria.keySet();

		for (String key : keys) {
			q.setParameter(key, criteria.get(key));
		}

		return q.getResultList();
	}

	public <E extends IEntity, obj> List<E> getEntities(
			Class<E> inElementClass, String queryName,
			HashMap<String, obj> criteria, Integer pageNumber, Integer pageSize) {

		Query qry = entityManager.createNamedQuery(queryName);

		Set<String> keys = criteria.keySet();

		for (String key : keys) {
			qry.setParameter(key, criteria.get(key));
		}

		if (pageSize != null && pageNumber != null) {
			qry.setMaxResults(pageSize);
			Integer firstResult = (pageNumber - 1) * pageSize;
			qry.setFirstResult(firstResult);
		}

		Object result;

		try {
			result = qry.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return (List<E>) result;
	}

	public <E extends IEntity, O extends Object> List<O> getColumnValues(
			Class<E> inElementClass, String queryName,
			HashMap<String, O> criteria) {

		Query qry = entityManager.createNamedQuery(queryName);

		Set<String> keys = criteria.keySet();

		for (String key : keys) {
			qry.setParameter(key, criteria.get(key));
		}

		Object result = qry.getResultList();

		return (List<O>) result;
	}
}