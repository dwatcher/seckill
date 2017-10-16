<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/2
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <%@include file="common/head.jsp"%>

  <script src="/resources/script/jQuery.js" charset="utf-8"></script>
  <script src="/resources/script/seckillList.js" charset="utf-8"></script>

  <title>秒杀商品列表</title>
</head>
<body>
  <div class="container" ng-app="listApp" ng-controller="listCtrl">
      <div class="panel panel-default">
          <div class="panel-heading text-center">
              <h2>秒杀列表</h2>
          </div>
          <div class="panel-body">
              <table class="table table-hover">
                  <thead>
                  <tr>
                      <th>名称</th>
                      <th>库存</th>
                      <th>开始时间</th>
                      <th>结束时间</th>
                      <th>创建时间</th>
                      <th>详情页</th>
                  </tr>
                  </thead>
                  <tbody>
                    <tr ng-repeat="list in seckillList">
                      <td>{{list.name}}</td>
                      <td>{{list.number}}</td>
                      <td>{{list.startTime | date:"yyyy-MM-dd HH:mm:ss"}}</td>
                      <td>{{list.endTime | date:"yyyy-MM-dd HH:mm:ss"}}</td>
                      <td>{{list.createTime | date:"yyyy-MM-dd HH:mm:ss"}}</td>
                      <td><a class="btn btn-info" href="/seckill/{{list.seckillId}}/detail" target="_blank">详情</a></td>
                    </tr>
                  </tbody>
              </table>
          </div>
      </div>
  </div>
</body>
<script type="text/javascript">

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
</script>
</html>
