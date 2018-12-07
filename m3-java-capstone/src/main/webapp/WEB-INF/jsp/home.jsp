<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="parks">
	<c:forEach items="${parks}" var="park">
		<div class="park">
			<a href="parkDetail?parkCode=${park.parkCode}">
				<img src="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" class="thumbnail" />
			</a>
			<div class="parkInfo">
				<h2 class="parkName">
					<a href="parkDetail?parkCode=${park.parkCode}">
						${park.parkName}
					</a>
				</h2>
				<div class="parkLocation">${park.state}</div>
				<p class="parkDescription">${park.parkDescription}</p>
				<a class="parkDetails" href="parkDetail?parkCode=${park.parkCode}">Details &raquo;</a>
			</div>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />