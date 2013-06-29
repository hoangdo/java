<%@page pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en" ng-app>
<head>
<meta charset="UTF-8">
<title>Employee Management with Angular JS</title>
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
<script charset="UTF-8"
  src="${pageContext.request.contextPath}/lib/angular/js/angular.js"></script>
<script charset="UTF-8"
  src="${pageContext.request.contextPath}/lib/app/js/controller.js"></script>
</head>
<body ng-controller="PhoneListCtrl">
  <ul>
    <li ng-repeat="phone in phones">{{phone.name}}
      <p>{{phone.snippet}}</p>
    </li>
  </ul>
</body>
</html>