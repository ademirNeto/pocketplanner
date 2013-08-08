<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuario</title>
</head>

<body>
<f:view>
<h:form>
<h:outputText value="Nome: "/><br/>
<h:inputText value="#{CadastroUsuario.user.name}" />
<br/>
<h:outputText value="E-mail: "/><br/>
<h:inputText value="#{CadastroUsuario.user.email}" />
<br/>
<h:outputText value="Senha: "/><br/>
<h:inputSecret value="#{CadastroUsuario.user.password}" />
<br/><br/>
<h:commandButton value="Salvar" action="#{CadastroUsuario.insert}" />
<h:commandButton value="Voltar" action="#{CadastroUsuario.voltar}" />
</h:form>
</f:view>
</body>
</html>