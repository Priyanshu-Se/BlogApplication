<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="d-flex justify-content-between align-items-center mb-3">
  <h2>All Posts</h2>
  <a class="btn btn-primary" href="${pageContext.request.contextPath}/posts/new">+ New Post</a>
</div>

<div class="row">
  <c:forEach var="p" items="${posts}">
    <div class="col-md-4 mb-3">
      <div class="card h-100 shadow-sm">
        <div class="card-body">
          <h5 class="card-title">${p.title}</h5>
          <p class="card-text short-desc">${p.description}</p>
        </div>
        <div class="card-footer d-flex justify-content-between">
          <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/posts/${p.id}">View</a>
          <div>
            <a class="btn btn-sm btn-secondary" href="${pageContext.request.contextPath}/posts/${p.id}/edit">Edit</a>
            <form method="post" action="${pageContext.request.contextPath}/posts/${p.id}/delete" style="display:inline-block;">
              <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Delete this post?')">Delete</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </c:forEach>
</div>

<%@ include file="includes/footer.jsp" %>
