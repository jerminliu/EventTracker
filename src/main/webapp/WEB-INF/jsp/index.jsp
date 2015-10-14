<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="event" value="${sessionScope.event}" />

<t:page pageTitle="Event Tracker">
<input name="eventId" type="hidden" value="${event.id}">

    <div class="row">
        <div class="col-md-12">
            <ul class="list-group">
                <li class="list-group-item"><a href="event.html?add=true">Add event</a></li>   <!--passing request parameter -->
                <li class="list-group-item"><a href="attendee.html">Add attendee</a></li>
                <li class="list-group-item"><a href="showEvents.html">View all events</a></li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <c:if test="${empty(event)}">
                <div class="alert alert-info" role="alert">
                    <span class="badge">!</span> Please create an event, add an attendee to the event or view all events
                </div>
            </c:if>
        </div>
    </div>

</t:page>

