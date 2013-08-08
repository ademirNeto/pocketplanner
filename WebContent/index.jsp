<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Principal</title>
</head>
<body>
<f:view>
<h:outputText value="Bem Vindo ao Pocket Planner!"/><br/>
        <h:outputText value="Usuário: "/><br/>
        <h:outputText value="#{Login.usuario.email}"/><br/>
        </f:view>
</body>
</html>
