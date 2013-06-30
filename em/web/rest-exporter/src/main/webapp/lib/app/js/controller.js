function CustomerListController($scope, $http) {
	$http.get('../../service/customer').success(function(data) {
		$scope.customers = data.content;
	});

	$scope.orderProp = 'firstname';
}

function CustomerDetailController($scope, $routeParams, $http) {
	  $http.get('../../service/customer/' + $routeParams.customerId).success(function(data) {
	    $scope.customer = data;
	  });
	}