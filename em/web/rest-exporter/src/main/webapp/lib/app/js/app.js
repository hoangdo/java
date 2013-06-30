angular.module('customerMgmt', []).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/customer', {
				templateUrl : 'partials/customerList',
				controller : CustomerListController
			}).when('/customer/:customerId', {
				templateUrl : 'partials/customerDetail',
				controller : CustomerDetailController
			}).otherwise({
				redirectTo : '/customer'
			});
		} ]);