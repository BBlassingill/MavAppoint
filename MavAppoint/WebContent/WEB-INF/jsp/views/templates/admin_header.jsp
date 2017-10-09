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
			<div id="navbar">
				<ul class="nav navbar-nav">
				<!--  <li><a href="create_advisor"><font style="color:#e67e22"> Create Advisors </font></a></li>-->
				<li><a href="view_advisors"><font style="color:#e67e22"> View Advisors </font></a></li>
				<li><a href="appointments"><font style="color:#e67e22">Show Department Schedule</font></a></li>
				<div class="nav navbar-nav"><font style="position: relative;left: 34vh;color:#e67e22;top: 5px;font-size: larger;">Current University Time:</font></div>
				<li id="time" style="color:#e67e22; left: 22vh;top: 22px;position: relative;font-size: large;"><font style="color:#e67e22"></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				
				<li><a href="#"><font style="color:#e67e22">You are logged in as an Admin.</font></a></li>
				<li><a href="logout"><span class="glyphicon glyphicon-log-in"><font style="color:#e67e22">Logout</font></a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>