Search:
<input ng-model="query">
Sort by:
<select ng-model="orderProp">
  <option value="firstname">First name</option>
  <option value="lastname">Last name</option>
  <option value="emailAddress">Email</option>
</select>


<ul>
  <li
    ng-repeat="customer in customers | filter:query | orderBy:orderProp">
    <a href="#/customer/{{customer.id}}" class="thumb">{{customer.firstname}} {{customer.lastname}}</a> 
    Email addresses:
    <p">{{customer.emailAddress.value}}</p>
  </li>
</ul>