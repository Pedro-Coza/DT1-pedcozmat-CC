<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="administrator.challenge.h2" />

<acme:menu-separator />

<acme:form>
	<acme:form-textbox code="administrator.challenge.form.label.title" path="title"/>
	<acme:form-moment code="administrator.challenge.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.challenge.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.challenge.form.label.expert" path="expert"/>
	<acme:form-textbox code="administrator.challenge.form.label.average" path="average"/>
	<acme:form-textbox code="administrator.challenge.form.label.rookie" path="rookie"/>
	<acme:form-money code="administrator.challenge.form.label.expertReward" path="expertReward"/>
	<acme:form-money code="administrator.challenge.form.label.averageReward" path="averageReward"/>
	<acme:form-money code="administrator.challenge.form.label.rookieReward" path="rookieReward"/>
	
	<acme:form-submit test="${command == 'show' }" 
	code="administrator.challenge.form.button.delete"
	action="/administrator/challenge/delete" />
	
	<acme:form-submit test="${command == 'show' }" 
	code="administrator.challenge.form.button.update"
	action="/administrator/challenge/update" />
	
	<acme:form-submit test = "${command == 'create'}"
	code="administrator.challenge.form.button.create" 
	action="/administrator/challenge/create"/>

	<acme:form-submit test="${command == 'delete' }" 
	code="administrator.challenge.form.button.delete"
	action="/administrator/challenge/delete" />
	
	<acme:form-submit test="${command == 'update' }" 
	code="administrator.challenge.form.button.update"
	action="/administrator/challenge/update" />
	
	<acme:form-return code="administrator.challenge.form.button.return"/>	
</acme:form>


