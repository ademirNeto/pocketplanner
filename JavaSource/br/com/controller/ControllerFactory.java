package br.com.controller;

import org.apache.catalina.Context;

import br.com.controller.UserController;
import br.com.model.User;

public final class ControllerFactory {

	public static UserController getUserController() {
		return new UserController();
	}

}
