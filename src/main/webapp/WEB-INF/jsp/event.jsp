<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:page pageTitle="Update Event">
	<div class="row">
		<div class="col-md-8 col-md-offset-2 event-form">
			<form:form commandName="event">

				<div class="form-group">
					<label>Event Name</label>
					<form:input id="txtName" path="name" cssClass="form-control" />
					<form:errors path="name" cssClass="error" element="div" />
				</div>

				<div class="form-group">
					<label>Date</label>
					<form:input id="txtDate" path="date" cssClass="form-control"
						placeholder="${dateInputFormat}" />
					<form:errors path="date" cssClass="error" element="div" />
				</div>

				<div class="form-group">
					<label>Location</label>
					<form:input id="txtLocation" path="location"
						cssClass="form-control" />
					<form:errors path="location" cssClass="error" element="div" />
				</div>

				<div class="form-group">
					<label>Duration</label>
					<form:input id="txtDuration" path="duration"
						cssClass="form-control" />
					<form:errors path="duration" cssClass="error" element="div" />
				</div>

				<div class="form-group">
					<label>Website</label>
					<form:input id="txtUrl" path="url" cssClass="form-control" />
					<form:errors path="url" cssClass="error" element="div" />
				</div>
				<input type="submit" class="btn btn-default" value="Submit">

			</form:form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-info" role="alert">
				<span class="badge">!</span> Please create an event.
			</div>
		</div>
	</div>

</t:page>

