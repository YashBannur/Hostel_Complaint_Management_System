<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Student Dashboard</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="CSS/student-dashboard.css">
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="navbar">

    <div class="logo">
        Hostel Complaint Management
    </div>

    <a href="LogoutServlet" class="logout-btn">Logout</a>

</div>

<div class="welcome">

    <h1>
        Welcome,
        <%= session.getAttribute("studentName") %>
    </h1>

    <p>
        Room Number:
        <%= session.getAttribute("roomNumber") %>
    </p>

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

        <h3><i class="fa-solid fa-clipboard-list"></i> Register Complaint</h3>

        <p>Submit a new maintenance complaint.</p>

        <a href="register-complaint.jsp">
             Register Complaint
        </a>

    </div>

    <div class="action-card">

        <h3><i class="fa-solid fa-list-check"></i> View My Complaints</h3>

        <p>Track all submitted complaints.</p>

        <a href="ViewComplaintsServlet">View Complaints</a>

    </div>

    <div class="action-card">

        <h3><i class="fa-solid fa-star"></i> Give Feedback</h3>

        <p>Rate completed maintenance work.</p>

        <a href="ViewComplaintsServlet">
            Give Feedback
        </a>

    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>