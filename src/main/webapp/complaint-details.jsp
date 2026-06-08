<%@ page import="com.hostel.model.Complaint" %>

<%
Complaint complaint =
        (Complaint)
        request.getAttribute("complaint");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Complaint Details</title>

<link rel="stylesheet"
href="CSS/complaint-details.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="container">

    <div class="card">

        <h1>Complaint Details</h1>

        <div class="detail-row">

            <span>Complaint ID</span>

            <span>
                <%= complaint.getComplaintId() %>
            </span>

        </div>

        <div class="detail-row">

            <span>Student ID</span>

            <span>
                <%= complaint.getStudentId() %>
            </span>

        </div>

        <div class="detail-row">

            <span>Category</span>

            <span>
                <%= complaint.getCategory() %>
            </span>

        </div>

        <div class="detail-row">

            <span>Priority</span>

            <span>
                <%= complaint.getPriority() %>
            </span>

        </div>

        <div class="detail-row">

            <span>Worker</span>

            <span>
                <%= complaint.getWorkerName() %>
            </span>

        </div>

        <div class="detail-row">

            <span>Status</span>

            <span>
                <%= complaint.getStatus() %>
            </span>

        </div>

        <div class="detail-row">

            <span>Date & Time</span>

            <span>
                <%= complaint.getCreatedAt() %>
            </span>

        </div>

        <h3>Description</h3>

        <div class="box">

            <%= complaint.getDescription() %>

        </div>

        <h3>Rating</h3>

        <div class="box">

            <%
            int rating =
                    complaint.getRating();

            if(rating > 0){

                for(int i=1;i<=5;i++){

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
            %>

                No Rating Yet

            <%
            }
            %>

        </div>

        <h3>Feedback</h3>

        <div class="box">

            <%

            if(complaint.getFeedback() != null
                    &&
               !complaint.getFeedback().trim().isEmpty()){

            %>

                <%= complaint.getFeedback() %>

            <%

            } else {

            %>

                No Feedback Yet

            <%

            }

            %>

		        </div>
		<a href="ViewAllComplaintsServlet"
		   class="back-btn">
		
		   Back To Complaints
		
		</a>
		
		<a href="ExportComplaintPdfServlet?id=<%= complaint.getComplaintId() %>"
		   class="pdf-btn">
		
		   Export PDF
		
		</a>
    </div>

</div>

</body>
</html>