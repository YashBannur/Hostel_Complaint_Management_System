<%
String complaintId =
        request.getParameter("id");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Update Status</title>

<link rel="stylesheet"
href="CSS/update-status.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="container">

    <div class="card">

        <h1>Update Complaint Status</h1>

        <form action="UpdateStatusServlet"
              method="post">

            <input
                type="hidden"
                name="complaintId"
                value="<%= complaintId %>">

            <label>Status</label>

            <select name="status">

                <option value="In Progress">
                    In Progress
                </option>

                <option value="Completed">
                    Completed
                </option>

            </select>

            <button type="submit">

                Update Status

            </button>

        </form>

    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>