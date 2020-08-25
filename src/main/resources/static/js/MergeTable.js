mainApp.controller('MergeTable', ['$scope', '$http', function ($scope, $http) {
    $scope.data_content_merge_table = [];
    $scope.headers_merge_table = [];

    loadData();


    $scope.$on('changed_merge', function (event, arg) {
        $scope.data_content_merge_table = [];
        $scope.headers_merge_table = [];
        loadData();
    });

    function loadData() {

        $http({
            method: 'GET',
            url: '/merge/table/get'

        }).then(function successCallback(response) {

            console.log(response.data);

            for (let i = 0; i < response.data.length; i++) {
                $scope.data_content_merge_table.push(response.data[i]);
            }

            Object.keys(response.data[0]).forEach(function (key) {
                $scope.headers_merge_table.push(key);
            });

        }, function errorCallback(response) {
            console.log(response);
        });
    }


    $scope.sortBy = function (propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };


    $scope.toggleSort = function (index) {
        if ($scope.sortColumn === $scope.headers_merge_table[index]) {
            $scope.reverse = !$scope.reverse;
        }
        $scope.sortColumn = $scope.headers_merge_table[index];
    }

}]).filter('dateRange', function () {
    let formatStr = 'yy-mm-dd';
    return function (data_content_merge_table, fromDate, toDate) {
        if (fromDate && toDate) {
            let filtered = [];
            angular.forEach(data_content_merge_table, function (items) {
                console.log('a', items.tradedate);

                if ((new Date(items.tradedate).getTime() - 18000000) >= new Date(fromDate).getTime() && (new Date(items.tradedate).getTime() - 18000000) <= new Date(toDate).getTime()) {
                    filtered.push(items);
                    console.log("PUSH: " + items);
                }
            });
            return filtered;

        } else if (fromDate) {
            let filtered = [];
            angular.forEach(data_content_merge_table, function (items) {
                console.log('a', items.tradedate);

                if ((new Date(items.tradedate).getTime() - 18000000) >= new Date(fromDate).getTime()) {
                    filtered.push(items);
                    console.log("PUSH: " + items);
                }
            });
            return filtered;

        } else if (toDate) {
            let filtered = [];
            angular.forEach(data_content_merge_table, function (items) {
                console.log('a', items.tradedate);

                if ((new Date(items.tradedate).getTime() - 18000000) <= new Date(toDate).getTime()) {
                    filtered.push(items);
                    console.log("PUSH: " + items);
                }
            });
            return filtered;

        } else
            return data_content_merge_table;
    }
})
