<h1>{{customer.firstname}} {{customer.lastname}}</h1>
 
<p>{{customer.emailAddress.value}}</p>
 
<ul class="customer-thumbs">
  <li ng-repeat="address in customer.addresses">
    Street: <p>{{address.street}}</p>
    City: <p>{{address.city}}</p>
    Country: <p>{{address.country}}</p>
  </li>
</ul>