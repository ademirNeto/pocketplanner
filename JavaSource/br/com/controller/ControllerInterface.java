package br.com.controller;

public interface ControllerInterface {

	public Object insert(Object object) throws Exception;

	public Object update(Object object);

	public Object search(Object object);

	public Boolean remove(Object object);

}
