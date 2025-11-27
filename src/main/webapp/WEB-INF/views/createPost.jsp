<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Create Post</h2>
<form method="post" action="${pageContext.request.contextPath}/posts">
  <div class="mb-3">
    <label class="form-label">Title</label>
    <input name="title" class="form-control" required />
  </div>
  <div class="mb-3">
    <label class="form-label">Description</label>
    <textarea name="description" rows="6" class="form-control" required></textarea>
  </div>
  <div class="mb-3">
    <label class="form-label">Username</label>
    <input name="username" class="form-control" placeholder="author username" required />
  </div>
  <button class="btn btn-success">Create</button>
  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/posts">Cancel</a>
</form>

<%@ include file="includes/footer.jsp" %>
