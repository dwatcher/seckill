angular.module('listApp', []).controller('listCtrl', function($scope, $http) {
    $http.get(seckill.URL.list).then(function successCallback(response) {
        var result = response.data;
        if (result.status == SUCCESS) {
            $scope.seckillList = result.data;
        }
    }, function errorCallback(response) {
        console.log('request fail!');
    });
});
