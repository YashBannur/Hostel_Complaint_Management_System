<%@ page import="java.util.List" %>
<%@ page import="com.hostel.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>My Complaints</title>

<link rel="stylesheet"
href="CSS/my-complaints.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="container">

    <h1>My Complaints</h1>

    <table>

        <tr>

            <th>ID</th>

            <th>Category</th>

            <th>Priority</th>

            <th>Status</th>

            <th>Date & Time</th>
            
            <th>Assigned Worker</th>
            
            
			<th>Action</th>


        </tr>

        <%
        List<Complaint> complaints =(List<Complaint>)request.getAttribute("complaints");

        for(Complaint complaint : complaints){
        %>

        <tr>
            <td><%= complaint.getComplaintId() %></td>

            <td><%= complaint.getCategory() %></td>

            <td><%= complaint.getPriority() %></td>

            <td><%= complaint.getStatus() %></td>

            <td><%= complaint.getCreatedAt() %></td>
            
            <td><%= complaint.getWorkerName() %></td>
			
			<td>
			
			<%
			if("Completed".equals(
			        complaint.getStatus())
			        &&
			   complaint.getRating() == 0){
			%>
			
			    <a href="feedback.jsp?id=<%= complaint.getComplaintId() %>"
			       class="feedback-btn">
			
			       Give Feedback
			
			    </a>
			
			<%
			}
			else if(complaint.getRating() > 0){
			%>
			
			    Feedback Submitted
			
			<%
			}
			else{
			%>
			
			    -
			
			<%
			}
			%>
			
			</td>
            

        </tr>

        <% } %>

    </table>

    <a href="StudentDashboardServlet"
       class="back-btn">

       Back To Dashboard

    </a>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>