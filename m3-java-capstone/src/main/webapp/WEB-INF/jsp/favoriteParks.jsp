<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h3>Favorite Parks</h3>

<div class="parks">
	<c:forEach items="${parksWithSurveys}" var="parkWithSurvey">
		<div class="park">
			<a href="parkDetail?parkCode=${parkWithSurvey.parkCode}">
				<img src="img/parks/${fn:toLowerCase(parkWithSurvey.parkCode)}.jpg" class="thumbnail" />
			</a>
			<div class="parkInfo">
					<h2 class="parkName">
						<a href="parkDetail?parkCode=${parkWithSurvey.parkCode}">
							${parkWithSurvey.parkName}
						</a>
					</h2>
					<div class="favorites">
						<c:if test="${parkWithSurvey.numberOfSurveys == 1}">
							One person favorited this park!
						</c:if>
						<c:if test="${parkWithSurvey.numberOfSurveys > 1}">
							${parkWithSurvey.numberOfSurveys} people favorited this park!
						</c:if>
					</div>
			</div>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />