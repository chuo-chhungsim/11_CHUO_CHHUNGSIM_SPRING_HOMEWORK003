package com.example.springboothomework003.Exception;

public class NotFoundException extends RuntimeException {
	private final Long id;

	public NotFoundException(Long id) {
		super("Entity with id " + id + " not found");
		this.id = id;
	}
	public Long getId() {
		return id;
	}


}
