<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Register Complaint</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="CSS/complaint.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="container">

    <div class="complaint-card">

        <div class="header">

            <h1>Register Complaint</h1>

            <p>
                Welcome,
                <strong>
                    <%= session.getAttribute("studentName") %>
                </strong>
                (Room:
                <%= session.getAttribute("roomNumber") %>)
            </p>

        </div>

        <form action="AddComplaintServlet" method="post">

            <div class="form-group">

                <label>Complaint Category</label>

                <select name="category" required>

                    <option value="">Select Category</option>

                    <option> Electrical </option>

                    <option> Plumbing </option>

                    <option> Internet </option>

                    <option> Furniture </option>

                    <option> Cleaning </option>

                    <option> Other </option>

                </select>

            </div>

            <div class="form-group">

                <label>Priority Level</label>

                <select name="priority" required>

                    <option value="">Select Priority</option>

                    <option>Low</option>

                    <option>Medium</option>

                    <option>High</option>

                </select>

            </div>

            <div class="form-group">

                <label>Description</label>

                <textarea
                    name="description"
                    rows="6"
                    placeholder="Describe the issue clearly..."
                    required></textarea>

            </div>

            <div class="buttons">

                <button type="submit">Submit Complaint</button>

                <a href="StudentDashboardServlet"> Back to Dashboard</a>

            </div>

        </form>

    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>