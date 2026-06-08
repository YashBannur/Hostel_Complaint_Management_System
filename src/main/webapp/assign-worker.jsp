<%
String complaintId =
        request.getParameter("id");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Assign Worker</title>

<link rel="stylesheet"
href="CSS/assign-worker.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="container">

    <div class="card">

        <h1>Assign Worker</h1>

        <form action="AssignWorkerServlet"
              method="post">

            <input
                type="hidden"
                name="complaintId"
                value="<%= complaintId %>">

            <label>
                Worker Name
            </label>

            <input
                type="text"
                name="workerName"
                placeholder="Enter Worker Name"
                required>

            <label>
                Status
            </label>

            <select name="status">

                <option value="Pending">
                    Pending
                </option>

                <option value="In Progress">
                    In Progress
                </option>

                <option value="Completed">
                    Completed
                </option>

            </select>

            <button type="submit">

                Update Complaint

            </button>

        </form>

    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>