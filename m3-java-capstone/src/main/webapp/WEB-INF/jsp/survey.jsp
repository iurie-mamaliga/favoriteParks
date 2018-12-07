<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h3>What's your favorite park?</h3>
 <c:url value="/survey" var ="surveyFormUrl" />

<div class="survey">
<form:form action="${surveyFormUrl}" method="POST" modelAttribute = "survey" class="form-inline">
	<div class="form-group">
		<form:label path="emailAddress">Email</form:label> 
		<form:input path="emailAddress" class="form-control" />
		<form:errors path="emailAddress" class="error" />
	</div>
	<div class="form-group">
		<form:label path="state">State of Residence</form:label> 
		<form:select path="state" name="state"
			id="state" class="form-control">
			<option>Alabama</option>
			<option>Alaska</option>
			<option>Arizona</option>
			<option>Arkansas</option>
			<option>California</option>
			<option>Colorado</option>
			<option>Connecticut</option>
			<option>Delaware</option>
			<option>Florida</option>
			<option>Georgia</option>
			<option>Hawaii</option>
			<option>Idaho</option>
			<option>Ilinois</option>
			<option>Indiana</option>
			<option>Iowa</option>
			<option>Kansas</option>
			<option>Kentucky</option>
			<option>Louisiana</option>
			<option>Maine</option>
			<option>Maryland</option>
			<option>Massachusetts</option>
			<option>Michigan</option>
			<option>Minnesota</option>
			<option>Mississippi</option>
			<option>Missouri</option>
			<option>Montana</option>
			<option>Nebraska</option>
			<option>Nevada</option>
			<option>New Hampshire</option>
			<option>New Jersey</option>
			<option>New Mexico</option>
			<option>New York</option>
			<option>North Carolina</option>
			<option>North Dakota</option>
			<option>Ohio</option>
			<option>Oklahoma</option>
			<option>Oregon</option>
			<option>Pennsylvania</option>
			<option>Rhode Island</option>
			<option>South Carolina</option>
			<option>South Dakota</option>
			<option>Tennessee</option>
			<option>Texas</option>
			<option>Utah</option>
			<option>Vermont</option>
			<option>Virginia</option>
			<option>Washington</option>
			<option>West Virginia</option>
			<option>Wisconsin</option>
			<option>Wyoming</option>
		</form:select>
	</div>
	<div class="form-group">
		<form:label path="parkCode">Favorite Park</form:label> 
		<form:select path="parkCode" id="parkCode" class="form-control">
			<c:forEach items="${parks}" var="park">
				<option value="${park.parkCode}">${park.parkName}</option>
			</c:forEach>
		</form:select>
	
	</div>
		<div class="form-group">
		<form:label path="activityLevel">Activity Level</form:label> 
		<form:select path="activityLevel" id="activityLevel" class="form-control">
			<option>Inactive</option>
			<option>Sedentary</option>
			<option>Active</option>
			<option>Extremely Active</option>
		</form:select>
	</div>
	<div class="form-group">
		<label>&nbsp;</label> <input type="submit" value="Survey" name="submit" class="btn btn-default" />
	</div>
</form:form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />