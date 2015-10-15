<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<t:page pageTitle="All events" useAngular="true" useJQuery="true">
	<div class="row">
		<div class="col-md-12">

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Event</th>
						<th>Date</th>
						<th>Location</th>
						<th>Number of attendees</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allEvents}" varStatus="loop">
						<tr>
						<td>${allEvents[loop.index].name}</td>
						<td>${allEvents[loop.index].date}</td>
						<td>${allEvents[loop.index].location}</td>
						<!-- td>${fn:length(allEvents[loop.index].attendees)}</td> -->
						<td>${fn:length(allEvents[loop.index].attendees)}</td>
						<td>
                        <!-- <form method="post" action="${pageContext.request.contextPath}/setCurrent.html" > -->
                        <form:form commandName="eventDetails" > 
                            <input type="hidden" name="eventId" value="${allEvents[loop.index].id}">
                            <button class="btn btn-primary btn-sm">Set as current</button>
                        </form:form>
                    	</td>
                    	</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<a href="${pageContext.request.contextPath}/" class="btn btn-default">Go
				back</a>
		</div>
	</div>

	<input id="input-current_event_id" type="hidden"
		value="${currentEventId}">
</t:page>

