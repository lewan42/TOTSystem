mainApp.controller('ViewTables', ['$scope', '$http', '$modal', '$window', '$rootScope',
    function ($scope, $http, $modal, $window, $rootScope) {
        $scope.data_content = [];
        $scope.headers = [];
        $scope.edit_info_secure = false;
        $scope.create_info_secure = false;
        loadData();

        $scope.$on('changed_seruce', function (event, arg) {
            $scope.data_content = [];
            $scope.headers = [];

            $scope.edit_info_secure = false;
            $scope.create_info_secure = false;

            loadData();
        });


        function loadData() {
            $http({
                method: 'GET',
                url: '/infosec/get'

            }).then(function successCallback(response) {

                for (let i = 0; i < response.data.length; i++) {
                    $scope.data_content.push(response.data[i]);
                }

                Object.keys(response.data[0]).forEach(function (key) {

                    $scope.headers.push(key);
                });

                console.log($scope.data_content);

            }, function errorCallback(response) {
                console.log(response);
            });
        }

        $scope.propertyName = 'id';
        $scope.reverse = true;
        $scope.content_secid = [];

        $scope.sortBy = function (propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
        };


        $scope.toggleSort = function (index) {
            if ($scope.sortColumn === $scope.headers[index]) {
                $scope.reverse = !$scope.reverse;
            }
            $scope.sortColumn = $scope.headers[index];
        }

        $scope.edit = function (content) {
            $scope.content = content;
            $scope.edit_info_secure = true;
            $scope.create_info_secure = false;
        }

        $scope.save = function (content) {

            let info_secur_json = {};

            info_secur_json = {
                id: content.id,
                secid: content.secid,
                th: content.th,
                shortname: document.getElementById("edit_secure_input_shortname").value,
                regnumber: document.getElementById("edit_secure_input_regnumber").value,
                name: document.getElementById("edit_secure_input_name").value,
                isin: document.getElementById("edit_secure_input_isin").value,
                is_traded: document.getElementById("edit_secure_input_is_traded").value,
                emitent_id: document.getElementById("edit_secure_input_emitent_id").value,
                emitent_title: document.getElementById("edit_secure_input_emitent_title").value,
                emitent_inn: document.getElementById("edit_secure_input_emitent_inn").value,
                emitent_okpo: document.getElementById("edit_secure_input_emitent_okpo").value,
                gosreg: document.getElementById("edit_secure_input_gosreg").value,
                type: document.getElementById("edit_secure_input_type").value,
                group: document.getElementById("edit_secure_input_group").value,
                primary_boardid: document.getElementById("edit_secure_input_primary_boardid").value,
                marketprice_boardid: document.getElementById("edit_secure_input_marketprice_boardid").value
            }
            console.log(info_secur_json);
            $http({

                method: 'PUT',
                url: '/infosec/update',
                headers: {"Content-Type": "application/json;charset=UTF-8"},
                data: info_secur_json

            }).then(function successCallback(response) {
                alert("success" + response);
                console.log("Изменено");
                $rootScope.$broadcast('changed_trading', 1);
                $rootScope.$broadcast('changed_merge', 1);
                content.shortname = document.getElementById("edit_secure_input_shortname").value;
                content.regnumber = document.getElementById("edit_secure_input_regnumber").value;
                content.name = document.getElementById("edit_secure_input_name").value;
                content.isin = document.getElementById("edit_secure_input_isin").value;
                content.is_traded = document.getElementById("edit_secure_input_is_traded").value;
                content.emitent_id = document.getElementById("edit_secure_input_emitent_id").value;
                content.emitent_title = document.getElementById("edit_secure_input_emitent_title").value;
                content.emitent_inn = document.getElementById("edit_secure_input_emitent_inn").value;
                content.emitent_okpo = document.getElementById("edit_secure_input_emitent_okpo").value;
                content.gosreg = document.getElementById("edit_secure_input_gosreg").value;
                content.type = document.getElementById("edit_secure_input_type").value;
                content.group = document.getElementById("edit_secure_input_group").value;
                content.primary_boardid = document.getElementById("edit_secure_input_primary_boardid").value;
                content.marketprice_boardid = document.getElementById("edit_secure_input_marketprice_boardid").value;

            }, function errorCallback(response) {
                alert("Ошибка: " + response);
                console.log("Ошибка: " + response.data);
            });
        }

        $scope.create = function () {

            if (!checkValidName(document.getElementById("create_secure_input_name").value))
                return;

            let info_secur_json = {};

            info_secur_json = {
                id: "",
                secid: document.getElementById("create_secure_input_secid").value,
                th: [],
                shortname: document.getElementById("create_secure_input_shortname").value,
                regnumber: document.getElementById("create_secure_input_regnumber").value,
                name: document.getElementById("create_secure_input_name").value,
                isin: document.getElementById("create_secure_input_isin").value,
                is_traded: document.getElementById("create_secure_input_is_traded").value,
                emitent_id: document.getElementById("create_secure_input_emitent_id").value,
                emitent_title: document.getElementById("create_secure_input_emitent_title").value,
                emitent_inn: document.getElementById("create_secure_input_emitent_inn").value,
                emitent_okpo: document.getElementById("create_secure_input_emitent_okpo").value,
                gosreg: document.getElementById("create_secure_input_gosreg").value,
                type: document.getElementById("create_secure_input_type").value,
                group: document.getElementById("create_secure_input_group").value,
                primary_boardid: document.getElementById("create_secure_input_primary_boardid").value,
                marketprice_boardid: document.getElementById("create_secure_input_marketprice_boardid").value
            }

            console.log(info_secur_json);
            $http({
                method: 'POST',
                url: '/infosec/create',
                headers: {"Content-Type": "application/json;charset=UTF-8"},
                data: info_secur_json

            }).then(function successCallback(response) {
                alert("Создано");
                $rootScope.$broadcast('changed_trading', 1);
                $rootScope.$broadcast('changed_merge', 1);
                console.log("success create " + response.data);

                $scope.data_content.push(response.data);

            }, function errorCallback(response) {
                if (response.data === 1)
                    alert("Бумага с данным secid уже существует\nПожалуйства введите другое значение.");
                else alert("Ошибка: " + response.data);
            });
        }

        $scope.delete = function (content) {

            let inx;
            if ($window.confirm("Вы хотите удалить: " + content.name + "?")) {

                for (let i = 0; i < $scope.data_content.length; i++) {
                    if ($scope.data_content[i].id === content.id) {
                        inx = i;
                        break;
                    }
                }

            } else return;

            $http({
                method: 'DELETE',
                url: '/infosec/delete/' + content.id

            }).then(function successCallback(response) {
                alert("Удалено");
                $rootScope.$broadcast('changed_trading', 1);
                $rootScope.$broadcast('changed_merge', 1);
                console.log("success" + response);
                $scope.data_content.splice(inx, 1);

            }, function errorCallback(response) {
                alert("Ошибка: " + response);
                console.log("Ошибка:" + response);
            });
        }

        $scope.openDivCreate = function () {
            $scope.edit_info_secure = false;
            $scope.create_info_secure = true;
        }

        function checkValidName(name) {
            if (!/^[0-9А-Яа-я\s]+$/.test(name)) {
                alert("Поле name должно содержать только кириллицу, цифры и пробел");
                return false;
            }
            return true;
        }
    }]);
