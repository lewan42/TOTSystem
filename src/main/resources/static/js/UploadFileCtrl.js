mainApp.controller('UploadFileController', function ($scope, $http, $rootScope) {

    $scope.uploadResult = "";

    $scope.myForm = {
        description: "",
        files: []
    }

    $scope.doUploadFile = function () {

        var url = "/rest/uploadMultiFiles";

        var data = new FormData();

        data.append("description", $scope.myForm.description);
        for (i = 0; i < $scope.myForm.files.length; i++) {
            data.append("files", $scope.myForm.files[i]);
        }

        var config = {
            transformRequest: angular.identity,
            transformResponse: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        }

        $http.post(url, data, config).then(
            // Success
            function (response) {
                alert(response.data);
                $rootScope.$broadcast('changed_seruce', 1);
                $rootScope.$broadcast('changed_trading', 1);
                $rootScope.$broadcast('changed_merge', 1);
            },
            // Error
            function (response) {
                alert("Ошибка добавления данных");
            });
    };
});