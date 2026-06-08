<%String complaintId =request.getParameter("id");%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Feedback</title>

<link rel="stylesheet"
href="CSS/feedback.css">
<link rel="stylesheet" href="CSS/common.css">
</head>

<body>

<div class="container">

    <div class="card">

        <h1>Submit Feedback</h1>

        <form action="SubmitFeedbackServlet"
              method="post">

            <input
                type="hidden"
                name="complaintId"
                value="<%= complaintId %>">

			            <label>Rating</label>
			
			<div class="rating">
			
			    <input type="radio" id="star5" name="rating" value="5" required>
			    <label for="star5">★</label>
			
			    <input type="radio" id="star4" name="rating" value="4">
			    <label for="star4">★</label>
			
			    <input type="radio" id="star3" name="rating" value="3">
			    <label for="star3">★</label>
			
			    <input type="radio" id="star2" name="rating" value="2">
			    <label for="star2">★</label>
			
			    <input type="radio" id="star1" name="rating" value="1">
			    <label for="star1">★</label>
			
			</div>

            <label>Feedback</label>

            <textarea
                name="feedback"
                rows="5"
                required>
            </textarea>

            <button type="submit">

                Submit Feedback

            </button>

        </form>

    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>