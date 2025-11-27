document.addEventListener('DOMContentLoaded', function() {
  var alerts = document.querySelectorAll('.alert');
  alerts.forEach(function(a){ setTimeout(()=> a.style.display='none', 4000); });
});