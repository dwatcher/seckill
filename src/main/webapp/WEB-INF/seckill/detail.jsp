<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <%@include file="../common/head.jsp"%>

  <script src="/resources/script/jQuery.js" charset="utf-8"></script>


  <title>秒杀商品列表</title>
</head>
<body>
  <div class="container" ng-app="listApp" ng-controller="listCtrl">
    <div class="panel panel-default text-center">
      <div class="pannel-heading">
        <h1>{{seckill.name}}</h1>
      </div>

      <div class="panel-body">
        <h2 class="text-danger" ng-switch="seckillStatus">
          <%--展示倒计时--%>
          <div ng-switch-when="1">
            <span>距离秒杀开始还有：{{ seckill.startTime - nowTime | timeConvert}}</span>
          </div>
          <div ng-switch-when="2">
            <span>距离秒杀结束还有：{{ seckill.endTime - nowTime| timeConvert}}</span><br>
            <button class="btn btn-success" type="button" ng-click="seckillClick()">秒杀</button>
          </div>
          <div ng-switch-when="3">
            <span>秒杀已结束</span>
          </div>
        </h2>
      </div>
    </div>
  </div>
</body>
<script src="/resources/script/init.js" charset="utf-8"></script>
<script src="http://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>
<script src="http://cdn.bootcss.com/angular.js/1.5.8/angular-cookies.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
  var app = angular.module('listApp', ['ngCookies']);
  app.controller('listCtrl', function($scope, $http, $interval, $cookies, $cookieStore) {
    $.cookie('userPhone', '13505965822', {expires: 7, path: '/app/seckill'});
    $scope.seckillStatus = 1;
    $scope.nowTime = 0;
    $scope.seckillClick = function() {
      if ($scope.md5) {
        $.post(seckill.URL.execution.replace('[seckillId]', ${seckillId}).replace('[md5]', $scope.md5), {}, function(result) {
          console.log(result);
          if (result.status == SUCCESS) {
            console.log('success');

          } else {
          }
        }, 'json');
      }
    }
    $http.get(seckill.URL.now).then(function successCallback(response) {
      $scope.nowTime = response.data.data;
      $interval(function() {
        $scope.nowTime = $scope.nowTime + 1000;
        if ($scope.seckill) {
          if ($scope.seckill.startTime > $scope.nowTime) {
            $scope.seckillStatus = 1;
          } else if($scope.seckill.endTime > $scope.nowTime) {
            if ($scope.seckillStatus != 2) {
              $http.post(seckill.URL.exposer.replace('[seckillId]', ${seckillId})).then(function successCallback(response) {
                $scope.md5 = response.data.data.md5;
              });
            }
            $scope.seckillStatus = 2;
          } else {
            $scope.seckillStatus = 3;
          }
        }
      }, 1000);
    });
    $http.get(seckill.URL.detail.replace('[seckillId]', ${seckillId})).then(function successCallback(response) {
      var result = response.data;
      if (result.status == SUCCESS) {
        $scope.seckill = result.data;
      }
    }, function errorCallback(response) {
      console.log('request fail!');
    });
  });
  app.filter('timeConvert', function() {
    return function(time) {
      var h = parseInt(time/3600000);
      var m = parseInt((time%3600000)/60000);
      var s = parseInt((time%60000)/1000);
      return h+':'+m+':'+s;
    }
  });
</script>
</html>
