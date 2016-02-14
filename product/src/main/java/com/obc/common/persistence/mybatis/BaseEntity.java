package com.obc.common.persistence.mybatis;

import java.io.Serializable;

public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1563341629492140901L;

	private Long id;// 主键通用

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
