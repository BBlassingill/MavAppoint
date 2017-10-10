<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
	<label><font color="#e67e22" size="5"> Create New Appointment Type: </label>
			
	<form action="create_appointment_type" method="post" name="appt_type_form" onsubmit="return false;">
		<div class="form-group">
					<label for="emailAddress"><font color="#e67e22" size="4">Email Address</label><br>
		 			<input type="text" style="width:350px;" class="form-control" id="emailAddress"
		 				placeholder="advisor@uta.edu">
				</div>
				<div>
					<label for="type"><font color="#e67e22" size="4">Type</label><br>
		 			<input type="text" style="width:350px;"class="form-control" id="type"
		 				placeholder="Advising Appointment">
				</div>
				<div>
					<label for="duration"><font color="#e67e22" size="4">Duration</label><br>
		 			<input type="text" style="width:350px;"class="form-control" id="duration">
				</div>
				<input type="submit" value="submit" onclick="javascript:FormSubmit();">
	</form>			 	
	<label id="result"><font color="#e67e22" size="4"></font></label>
	<script> function FormSubmit(){
									var email = document.getElementById("emailAddress").value;									
									var type = document.getElementById("type").value;
									var duration = document.getElementById("duration").value;
									//out.println("Email: " + email + " Type: " + type + " Duration: " + duration);
									var params = ('emailAddress='+email+'&type='+type+'&duration='+duration);
									var xmlhttp;
									xmlhttp = new XMLHttpRequest();
									xmlhttp.onreadystatechange=function(){
										if (xmlhttp.readyState==4){
											document.getElementById("result").innerHTML = xmlhttp.responseText;	
										}
									}
									xmlhttp.open("POST","create_appointment_type",true);
									xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
									xmlhttp.setRequestHeader("Content-length",params.length);
									xmlhttp.setRequestHeader("Connection","close");
									xmlhttp.send(params);
									document.getElementById("result").innerHTML = "Attempting to create new Appointment Type...";
								}
								</script>
<%@include file="templates/footer.jsp" %>