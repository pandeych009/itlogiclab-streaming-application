package com.itlogiclab.microservice.streaming.common.domain.valueobject;

import java.util.Objects;

public abstract class BaseId<T> {

	private T value;

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseId other = (BaseId) obj;
		return Objects.equals(value, other.value);
	}
}
