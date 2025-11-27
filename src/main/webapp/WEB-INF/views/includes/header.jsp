<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Blog Application</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/posts">BlogApp</a>
    <div>
      <a class="btn btn-light" href="${pageContext.request.contextPath}/posts/new">Create Post</a>
    </div>
  </div>
</nav>
<div class="container mt-4">
<c:if test="${not empty message}">
  <div class="alert alert-success">${message}</div>
</c:if>
<c:if test="${not empty error}">
  <div class="alert alert-danger">${error}</div>
</c:if>
