package com.htu.petclinichtu.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.htu.petclinichtu.models.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Number> {
	protected Map<Long, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public T save(T t) {
		if (t != null) {
			if (t.getId() == null) {
				t.setId(getNextId());
			}
			map.put(t.getId(), t);
		} else {
			throw new RuntimeException("Object cannot be null");
		}
		return t;
	}

	public void deleteById(ID id) {
		map.remove(id);
	}

	public void delete(T t) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(t));
	}

	private Long getNextId() {
		Long nextId = null;
		
		try {
		nextId = Collections.max(map.keySet()) + 1;
		}catch(NoSuchElementException e){
			nextId=0L;
		}
		return nextId;
	}
}
