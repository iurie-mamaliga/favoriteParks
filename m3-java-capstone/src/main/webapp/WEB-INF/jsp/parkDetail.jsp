<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<div class="park single">
	<!--  TODO: update img -->
	<img src="img/parks/${fn:toLowerCase(park.parkCode)}.jpg"
		class="fullSize" />
	<div class="parkInfo">
		<h2 class="parkName">${park.parkName}</h2>
		<div class="parkLocation">${park.state}</div>
		<p class="parkDescription">${park.parkDescription}</p>

		<blockquote class="inspirationalQuote">
			"${park.inspirationalQuote}" <br /> <span
				class="inspirationalQuoteSource">-
				${park.inspirationalQuoteSource}</span>
		</blockquote>

		<table class="parkFacts">
			<tr>
				<td class="label">Entry Fee</td>
				<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${park.entryFee}" type="currency" /></td>
			</tr>
			<tr>
				<td class="label">Acreage</td>
				<td><fmt:formatNumber type="number" value="${park.acreage}" />
				</td>
			</tr>
			<tr>
				<td class="label">Elevation (ft)</td>
				<td><fmt:formatNumber type="number"
						value="${park.elevationInFeet}" /></td>
			</tr>
			<tr>
				<td class="label">Trail Length (mi)</td>
				<td><fmt:formatNumber type="number" maxFractionDigits="1"
						value="${park.milesOfTrail}" /></td>
			</tr>
			<tr>
				<td class="label"># of Campsites</td>
				<td><fmt:formatNumber type="number"
						value="${park.numberOfCampsites}" /></td>
			</tr>
			<tr>
				<td class="label">Climate</td>
				<td>${park.climate}</td>
			</tr>
			<tr>
				<td class="label">Year Founded</td>
				<td>${park.yearFounded}</td>
			</tr>
			<tr>
				<td class="label">Annual Visitors</td>
				<td><fmt:formatNumber type="number"
						value="${park.annualVisitorCount}" /></td>
			</tr>
			<tr>
				<td class="label"># of Animal Species</td>
				<td><fmt:formatNumber type="number"
						value="${park.numberOfAnimalSpecies}" /></td>
			</tr>
		</table>


		<table class="parkForecast">
			<c:forEach items="${weather}" var="w">
				<tr>
					<td><img src="img/weather/${w.forecast}.png" class="weather" /></td>
					<td class="parkForecastDay">
						<c:if test="${w.fiveDayForecastValue == 1}">
							<c:out value="Monday" />
						</c:if>
						<c:if test="${w.fiveDayForecastValue == 2}">
							<c:out value="Tuesday" />
						</c:if>
						<c:if test="${w.fiveDayForecastValue == 3}">
							<c:out value="Wednesday" />
						</c:if>
						<c:if test="${w.fiveDayForecastValue == 4}">
							<c:out value="Thursday" />
						</c:if>
						<c:if test="${w.fiveDayForecastValue == 5}">
							<c:out value="Friday" />
						</c:if>
					</td>
					<td>High: <c:if test="${temperatureUnit == 'C'}">
							<fmt:formatNumber type="number" maxFractionDigits="1"
								value="${ (w.highTemp-32) * 5/9.0 }" />
						</c:if> <c:if test="${temperatureUnit == 'F'}">
							<fmt:formatNumber type="number" maxFractionDigits="1"
								value="${w.highTemp}" />
						</c:if> °${temperatureUnit}
					</td>
					<td>Low: <c:if test="${temperatureUnit == 'C'}">
							<fmt:formatNumber type="number" maxFractionDigits="1"
								value="${ (w.lowTemp-32) * 5/9.0 }" />
						</c:if> <c:if test="${temperatureUnit == 'F'}">
							<fmt:formatNumber type="number" maxFractionDigits="1"
								value="${w.lowTemp}" />
						</c:if> °${temperatureUnit}
					</td>


					<td>
						<ul class="recommendations">
							<c:forEach items="${w.recommendations}" var="recommendation">
								<li>${recommendation}</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<form action="changeTemperatureUnit" method="post"
	class="form-inline changeTemperatureUnit">
	<div class="form-group">
		<input type="hidden" name="parkCode" value="${park.parkCode}" /> <label
			for="category">Change temperature unit</label> <select
			name="temperatureUnit" id="temperatureUnit" class="form-control">
			<option value="F"
				<c:if test = "${temperatureUnit != 'C'}">selected</c:if>>°F</option>
			<option value="C"
				<c:if test = "${temperatureUnit == 'C'}">selected</c:if>>°C</option>
		</select> <input type="submit" name="submit" value="Save"
			class="btn btn-default" />
	</div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />