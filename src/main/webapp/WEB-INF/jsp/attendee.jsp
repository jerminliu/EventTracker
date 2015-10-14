<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page pageTitle="Add Attendee">
	<div class="row">
		<div class="col-md-8 col-md-offset-2 attendee-form">
			<form:form commandName="attendee">
				<form:input path="eventId" type="hidden" value="${sessionScope.event.id}"/>
				<div class="form-group">
					<label> <spring:message code="attendee.name" /></label>
					<form:input id="txtName" path="name" cssClass="form-control" />
					<form:errors path="name" cssClass="error" element="div" />
				</div>
				<div class="form-group">
					<label> <spring:message code="attendee.email" /></label>
					<form:input id="txtEmail" path="email" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label> <spring:message code="attendee.phone" /></label>
					<form:input id="txtPhone" path="phone" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label> <spring:message code="attendee.gender" /></label>
					<form:input id="txtGender" path="gender" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label> <spring:message code="attendee.company" /></label>
					<form:input id="txtCompany" path="company" cssClass="form-control" />
				</div>
				<input type="submit" class="btn btn-default" value="Submit">
			</form:form>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-info" role="alert">
				<span class="badge">!</span> Please add an attendee to an event.
			</div>
		</div>
	</div>

</t:page>

