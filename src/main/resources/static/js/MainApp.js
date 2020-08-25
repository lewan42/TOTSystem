// main app.
var mainApp = angular.module('MainApp', ['ui.bootstrap']);

// DIRECTIVE - FILE MODEL
mainApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);


mainApp.directive('mydatepicker', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element) {
            element.datepicker({
                dateFormat: 'yy-mm-dd',
                onSelect: function (date) {
                    scope.date = date;
                    scope.$apply();
                }

            });
        }
    };
});




