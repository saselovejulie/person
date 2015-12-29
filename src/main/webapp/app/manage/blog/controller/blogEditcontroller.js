personApp.controller('blogEditController', function ($scope, $http) {
    'use strict';

    $scope.title;
    $scope.types;
    $scope.tags;
    $scope.content;
    $scope.description;


    console.log(2222)

    $scope.save = function(){
        $http({
            method: 'post',
            type:'json',
            url: '/api/manage/blog/create',
            data:{title:$scope.title, types:$scope.types, tags:$scope.tags, content:$scope.content, description:$scope.description }
        }).error(function (error) {

        }).success(function (data, status) {

            if(data.status == 200){
                alert('success')
            }


        });


    }

});
