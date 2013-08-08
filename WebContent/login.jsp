<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<f:view>
    	<h:form id = "form">
    	<h:message for="form"/><br />
        <h:outputText value="Faça seu login:"/><br />
        <h:outputText value="E-mail: "/><br/>
        <h:inputText value="#{Login.usuario.email}"/><br />
        <h:outputText value="Senha: "/><br/>
        <h:inputSecret value="#{Login.usuario.password}" redisplay ="true"/><br/>
        <h:commandButton value="Entrar" action="#{Login.logar}" />
        <h:commandButton value="Cadastrar" action="#{Login.cadastrar}" />
    </h:form>
   	</f:view>
</body>
</html>