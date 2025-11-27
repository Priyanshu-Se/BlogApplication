<%@ include file="includes/header.jsp" %>

<h2>Edit Post</h2>
<form method="post" action="${pageContext.request.contextPath}/posts/${post.id}">
  <div class="mb-3">
    <label class="form-label">Title</label>
    <input name="title" value="${post.title}" class="form-control" required />
  </div>
  <div class="mb-3">
    <label class="form-label">Description</label>
    <textarea name="description" rows="6" class="form-control" required>${post.description}</textarea>
  </div>
  <button class="btn btn-success">Save</button>
  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/posts/${post.id}">Cancel</a>
</form>

<%@ include file="includes/footer.jsp" %>
