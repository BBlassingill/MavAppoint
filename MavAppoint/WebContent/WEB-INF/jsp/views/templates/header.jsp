<%@include file="top_header.jsp" %>
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
			<div>
				<ul class="nav navbar-nav">
				<li><a href="advising"><font style="color:#e67e22">Advising</font> </a></li>
				<div class="nav navbar-nav"><font style="position: relative;left: 58vh;color:#e67e22;top: 5px;font-size: larger;">Current University Time:</font></div>
				<li id="time" style="color:#e67e22; left: 46vh;top: 22px;position: relative;font-size: large;"><font style="color:#e67e22"></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				
				<li><a href="register"><span class="glyphicon glyphicon-user"><font style="color:#e67e22">Register</font></a></li>
				<li><a href="help"><span class="glyphicon glyphicon-user"><font style="color:#e67e22">Help</font></a></li>
				<li><a href="login"><span class="glyphicon glyphicon-log-in"><font style="color:#e67e22">Login</font></a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>