<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hostel.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Warden Dashboard</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet"href="CSS/warden-dashboard.css">
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="navbar">

    <div class="logo">Hostel Complaint Management</div>
    
    <a href="LogoutServlet" class="logout-btn">Logout</a>

</div>

<div class="welcome">

    <h1>Welcome,<%= session.getAttribute("wardenName") %></h1>

    <p>Warden Dashboard</p>

</div>

<div class="stats">

    <div class="stat-card">
        <h2><%= request.getAttribute("total") %></h2>
        <p>Total Complaints</p>
    </div>

    <div class="stat-card">
        <h2><%= request.getAttribute("pending") %></h2>
        <p>Pending</p>
    </div>

    <div class="stat-card">
        <h2><%= request.getAttribute("inProgress") %></h2>
        <p>In Progress</p>
    </div>

    <div class="stat-card">
        <h2><%= request.getAttribute("completed") %></h2>
        <p>Completed</p>
    </div>

</div>



<div class="actions">

    <div class="action-card">

        <h3>View All Complaints</h3>

        <p>Manage and monitor all complaints.</p>

        <a href="ViewAllComplaintsServlet">Open</a>

    </div>

    <div class="action-card">

        <h3>Worker Management</h3>

        <p>Assign workers and update complaint status.</p>

        <a href="ViewAllComplaintsServlet">Open</a>

    </div>

</div>

<div class="recent-section">

    <div class="recent-header">

        <h2>Recent Complaints</h2>

        <form action="SearchComplaintServlet"
      method="get">

    <select name="category"
            onchange="this.form.submit()">

        <option value="All">All Categories</option>

        <option value="Electrical">Electrical</option>

        <option value="Plumbing">Plumbing</option>

        <option value="Cleaning">Cleaning</option>

        <option value="Furniture">Furniture</option>

        <option value="Internet">Internet</option>

    </select>

</form>

    </div>

    <table class="recent-table">

        <tr>

            <th>Complaint ID</th>

            <th>Category</th>

            <th>Priority</th>

            <th>Status</th>

        </tr>

        <%
        List<Complaint> recentComplaints =
            (List<Complaint>)
            request.getAttribute("recentComplaints");

        for(Complaint complaint : recentComplaints){
        %>

        <tr>

            <td><%= complaint.getComplaintId() %></td>

            <td><%= complaint.getCategory() %></td>

            <td><%= complaint.getPriority() %></td>

            <td>

            <%
            if("Pending".equals(complaint.getStatus())){
            %>

                <span class="pending-badge">
                    Pending
                </span>

            <%
            }
            else if("In Progress".equals(complaint.getStatus())){
            %>

                <span class="progress-badge">
                    In Progress
                </span>

            <%
            }
            else{
            %>

                <span class="completed-badge">
                    Completed
                </span>

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