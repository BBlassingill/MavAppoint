<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
<style>
.custab {
	border: 1px solid #ccc;
	padding: 5px;
	margin: 5% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
	background-color: #e67e22;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}
</style>

<div class="container">
	<div class="jumbotron">
  		<h1> View Appointment Types </h1>
  		<li><a href="create_appointment_type"><font style="color:#e67e22"> Create New Appointment Type </font></a></li>
  		
  		<div class="container">
	<div class="btn-group">
		<form action="view_appointment_types" method="post" name="deleteAppointmentType">
			<input type=hidden name=type_to_delete id="type_to_delete">
			<input type=hidden name=duration_to_delete id="duration_to_delete">
			<input type=hidden name=userid_to_delete id="userid_to_delete">    
			<input type=hidden name=edit_button id="edit_button">
			<div class="row col-md-16  custyle">
				<table class="table table-striped custab">
					<thead>
						<tr>
							<th>Advisor</th>
							<th>Appointment Type</th>
							<th>Duration</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<%@ page import="java.util.ArrayList"%>
					<%@ page import="uta.mav.appoint.beans.AppointmentType"%>
					<%@ page import="java.time.*" %>
					<!-- begin processing appointment types  -->
					<% ArrayList<AppointmentType> array = (ArrayList<AppointmentType>)session.getAttribute("appointmentTypes");
		    		if (array != null){%>
						<%for (int i=0;i<array.size();i++){ %>
							<tr>
								<td><%=array.get(i).getAdvisor()%>
								<td><%=array.get(i).getType()%></td>
								<td><%=array.get(i).getDuration()%></td>
								
								<td class="text-center"><button type="button" id=button1
									<%=i%> onclick="buttonEdit<%=i%>()">Edit</button></td>
								<td class="text-center"><button type="button" id=button2_
									<%=i%> onclick="buttonDelete<%=i%>()">Delete</button></td>
									
							</tr>
							<script> function buttonDelete<%=i%>(){
												document.getElementById("userid_to_delete").value = "<%=array.get(i).getUserId()%>";
												document.getElementById("type_to_delete").value = "<%=array.get(i).getType()%>";
												document.getElementById("duration_to_delete").value = "<%=array.get(i).getDuration()%>";
												if (validate()) {
													deleteAppointmentType.submit();
												}
							}</script>
							
							<script> function buttonEdit<%=i%>(){
											document.getElementById("userid_to_edit").value = "<%=array.get(i).getUserId()%>";
											document.getElementById("type_to_edit").value = "<%=array.get(i).getType()%>";
											document.getElementById("duration_to_edit").value = "<%=array.get(i).getDuration()%>";
											document.getElementById("old_type").value = "<%=array.get(i).getType()%>";
											$("#apptTypeModal").modal();
							}</script>
			</div>
					<%	}
	    			}%>
					<!-- end processing appointment types -->
				</table>
		</form>
	</div>
</div>

	</div>
</div>

<form name=editAppointmentType action="manage_appointment_type" onsubmit="return validate2()"
	method="post">
	<div type = "hidden" class="modal fade" id="apptTypeModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id=addApptTypeLabel">Update
						Appointment Type</h4>
				</div>
				<div class="modal-body">
					<!--  <input type="hidden" name=id2 id="id2" readonly> <b>Type:</b><input
						type="label" name=apptype id="apptype" readonly><br>-->
					<input type="hidden" name=userid_to_edit id="userid_to_edit" readonly>
					<input type="hidden" name=old_type id="old_type" readonly>
					<b>Appointment Type: </b><input type="label" name=type_to_edit id="type_to_edit" ><br>
					<b>Duration: </b><input type="label" name=duration_to_edit id="duration_to_edit" ><br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Close</button>
					<input type="submit" value="Submit">
				</div>
			</div>
		</div>
	</div>
</form>

<script>
function validate() {
	return confirm("Are you sure you want to delete this appointment type?");
}

function validate2(){
	if (document.getElementById("appointment_type").value == ""){
		alert("Appointment Type is required.");
		return false;
	}
	
	if (document.getElementById("duration").value == ""){
		alert("Duration is required.");
		return false;
	}
	
}
</script>


<%@include file="templates/footer.jsp" %>