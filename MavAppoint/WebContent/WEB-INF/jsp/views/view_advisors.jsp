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
  		<h1> View Advisors </h1>
  		<li><a href="create_advisor"><font style="color:#e67e22"> Create New Advisor </font></a></li>
  		<!--  <li><a href="edit_advisor"><font style="color:#e67e22"> Create Advisors </font></a></li>
  		<li><a href="create_advisor"><font style="color:#e67e22"> Create Advisors </font></a></li>-->
  		
  		<div class="container">
	<div class="btn-group">
		<form action="view_advisors" method="post" name="deleteAdvisor">
			<input type=hidden name=delete_button id="delete_button"> <input
				type=hidden name=edit_button id="edit_button">
			<div class="row col-md-16  custyle">
				<table class="table table-striped custab">
					<thead>
						<tr>
							<th>Advisor Name</th>
							<th>Advisor Email</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<%@ page import="java.util.ArrayList"%>
					<%@ page import="uta.mav.appoint.beans.Advisor"%>
					<%@ page import="java.time.*" %>
					<!-- begin processing advisors  -->
					<% ArrayList<Advisor> array = (ArrayList<Advisor>)session.getAttribute("advisors");
		    		if (array != null){%>
						<%for (int i=0;i<array.size();i++){ %>
							<tr>
								<td><%=array.get(i).getPname()%></td>
								<td><%=array.get(i).getAdvisorEmail()%></td>
								
								<td class="text-center"><button type="button" id=button1
									<%=i%> onclick="buttonEdit<%=i%>()">Edit</button></td>
								<td class="text-center"><button type="button" id=button2_
									<%=i%> onclick="buttonDelete<%=i%>()">Delete</button></td>
									
							</tr>
							<script> function buttonDelete<%=i%>(){
												document.getElementById("delete_button").value = "<%=array.get(i).getAdvisorEmail()%>";
												if (validate()) {
													deleteAdvisor.submit();
												}
							}</script>
							
							<script> function buttonEdit<%=i%>(){
											document.getElementById("advisorID").value = "<%=array.get(i).getID()%>";
											document.getElementById("advisorName").value = 	"<%=array.get(i).getPname()%>";
											document.getElementById("advisorEmail").value = "<%=array.get(i).getAdvisorEmail()%>";
											$("#advisorModal").modal();
							}</script>
			</div>
					<%	}
	    			}%>
					<!-- end processing advisors -->
				</table>
		</form>
	</div>
</div>

	</div>
</div>

<form name=editAdvisor action="manage_advisor" onsubmit="return validate2()"
	method="post">
	<div type = "hidden" class="modal fade" id="advisorModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id=addApptTypeLabel">Update
						Advisor</h4>
				</div>
				<div class="modal-body">
					<!--  <input type="hidden" name=id2 id="id2" readonly> <b>Type:</b><input
						type="label" name=apptype id="apptype" readonly><br>-->
					<input type="hidden" name=advisorID id="advisorID" readonly> 
					<b>Advisor Name: </b><input type="label" name=advisorName id="advisorName" ><br>
					<b>Email: </b><input type="label" name=advisorEmail id="advisorEmail" ><br>
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
	return confirm("Are you sure you want to delete this advisor?");
}

function validate2(){
	if (document.getElementById("advisorName").value == ""){
		alert("Name is required.");
		return false;
	}
	
	if (document.getElementById("advisorEmail").value == ""){
		alert("Email is required.");
		return false;
	}
	
}
</script>


<%@include file="templates/footer.jsp" %>