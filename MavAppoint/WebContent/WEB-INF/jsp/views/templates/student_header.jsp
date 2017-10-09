<body onload="startTime()">
	<script>
		function startTime() {
			var d = new Date();
			var hours = d.getHours();
			var minutes = d.getMinutes();
			var ampm = hours >= 12 ? 'pm' : 'am';
			hours = hours % 12;
			hours = hours ? hours : 12; // the hour '0' should be '12'
			minutes = minutes < 10 ? '0'+minutes : minutes;
			var strTime = hours + ':' + minutes + ' ' + ampm;
			  
			document.getElementById("time").innerHTML = strTime;
			var t = setTimeout(startTime, 500);
		}
		</script>
	<%@include file="top_header.jsp" %>
			<div>
				<ul class="nav navbar-nav">
				<li><a href="advising"><font style="color:#e67e22" size="3">  Advising </font></a></li>
				<li><a href="appointments"><font style="color:#e67e22" size="3">  Appointments </font></a></li>
				<div class="nav navbar-nav"><font style="position: relative;left: 45vh;color:#e67e22;top: 5px;font-size: larger;">Current University Time:</font></div>
				<li id="time" style="color:#e67e22; left: 33vh;top: 22px;position: relative;font-size: large;"><font style="color:#e67e22"></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><font style="color:#e67e22" size="3"> You are logged in as a Student. </font></a></li>
				<li><a href="logout"><font style="color:#e67e22" size="5"> <span class="glyphicon glyphicon-log-in"></font></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<%@ page import= "uta.mav.appoint.beans.Appointment" %>
	<% Appointment nextAppt = (Appointment)session.getAttribute("studentapp");
	if (nextAppt != null){%>
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
	<div id="inversenavbar" class="container-fluid" style="background-color:#104E8B">
			<div>
				<table class="table">
    			<thead>
        		<tr>
            	<th><font style="color:#e67e22" size="4"><b>Upcoming Advising Appointment:</b></th>
            	<th><font style="color:#e67e22" size="3"><b>Appointment Date</b></th>
				<th><font style="color:#e67e22" size="3"><b>Advising Type</b></th>
				<th><font style="color:#e67e22" size="3"><b>Start Time</b></th>
				<th><font style="color:#e67e22" size="3"><b>End Time</b></th>
				</tr>
    			</thead>
    			<tr>
    				<td>
    				<td><font style="color:#e67e22" size="3"><%=nextAppt.getAdvisingDate()%></td>
					<td><font style="color:#e67e22" size="3"><%=nextAppt.getAppointmentType()%></td>
					<td><font style="color:#e67e22" size="3"><%=nextAppt.getAdvisingStartTime()%></td>
					<td><font style="color:#e67e22" size="3"><%=nextAppt.getAdvisingEndTime()%></td>
					</tr>
				</table>
			</div>
		</div>
	</nav>
	<%}%>
</div>