<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="card">
  <div class="card-body">
    <h2>${post.title}</h2>
    <p class="text-muted">Author: ${post.user != null ? post.user.username : 'Unknown'}</p>
    <hr/>
    <p>${post.description}</p>
  </div>
  <div class="card-footer">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/posts">Back</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/posts/${post.id}/edit">Edit</a>
  </div>
</div>

<%@ include file="includes/footer.jsp" %>
