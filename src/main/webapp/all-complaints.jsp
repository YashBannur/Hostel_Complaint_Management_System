<%@ page import="java.util.List" %>
<%@ page import="com.hostel.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>All Complaints</title>

<link rel="stylesheet"
href="CSS/all-complaints.css">
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="container">

    <div class="header">

        <h1>All Complaints</h1>

        <a href="WardenDashboardServlet"
           class="back-btn">

           Dashboard

        </a>

    </div>

    <table>

        <tr>

            <th>ID</th>

            <th>Student ID</th>

            <th>Category</th>

            <th>Priority</th>

            <th>Worker</th>
			
			<th>Status</th>
			
			<th>Rating</th>
			
			<th>View Details</th>
			
			<th>Action</th>

        </tr>

        <%

        List<Complaint> complaints =
                (List<Complaint>)
                request.getAttribute("complaints");

        for(Complaint complaint : complaints){

        String statusClass =
                complaint.getStatus()
                         .trim()
                         .replace(" ", "-")
                         .toLowerCase();

        %>

        <tr class="<%= statusClass %>">

    <td><%= complaint.getComplaintId() %></td>

    <td><%= complaint.getStudentId() %></td>

    <td><%= complaint.getCategory() %></td>

    
    <td><%= complaint.getPriority() %></td>
    
    <td><%= complaint.getWorkerName() %></td>


    <!-- Status -->

    <td>

        <span class="status-badge <%= statusClass %>-badge">

            <%= complaint.getStatus() %>

        </span>

    </td>

    <!-- Rating -->

    <td>

    <%
    int rating = complaint.getRating();

    if(rating > 0){

        for(int i = 1; i <= 5; i++){

            if(i <= rating){
    %>

                <i class="fa-solid fa-star"
                   style="color:gold;"></i>

    <%
            }
            else{
    %>

                <i class="fa-regular fa-star"
                   style="color:gray;"></i>

    <%
            }
        }

    } else {

        for(int i = 1; i <= 5; i++){
    %>

            <i class="fa-regular fa-star"
               style="color:gray;"></i>

    <%
        }
    }
    %>

    </td>

    

 <td>

    <a href="ViewComplaintServlet?id=<%= complaint.getComplaintId() %>"
       class="details-btn">

       View Details

    </a>

</td>

    <td>

    <%

    if("Not Assigned".equals(
            complaint.getWorkerName())) {

    %>

        <a href="assign-worker.jsp?id=<%= complaint.getComplaintId() %>"
           class="assign-btn">

           Assign Worker

        </a>

    <%

    }
    else if(!"Completed".equals(
            complaint.getStatus())) {

    %>

        <a href="update-status.jsp?id=<%= complaint.getComplaintId() %>"
           class="update-btn">

           Update Status

        </a>

    <%

    }
    else {

    %>

        <button
            class="completed-btn"
            disabled>

            Completed

        </button>

    <%

    }

    %>

    </td>

</tr>

        <%

        }

        %>

    </table>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>