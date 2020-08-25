mainApp.controller('TableTradeHistory', ['$scope', '$http', '$modal', '$window', '$rootScope',
    function ($scope, $http, $modal, $window, $rootScope) {
        $scope.data_content_trading = [];
        $scope.headers_trading = [];
        $scope.edit_trading = false;
        $scope.create_trading = false;
        loadData();

        $scope.$on('changed_trading', function (event, arg) {
            $scope.data_content_trading = [];
            $scope.headers_trading = [];

            $scope.edit_trading = false;
            $scope.create_trading = false;

            loadData();
        });

        function loadData() {

            $http({
                method: 'GET',
                url: '/trading/get'

            }).then(function successCallback(response) {

                for (let i = 0; i < response.data.length; i++) {
                    $scope.data_content_trading.push(response.data[i]);
                }

                Object.keys(response.data[0]).forEach(function (key) {

                    $scope.headers_trading.push(key);
                });

                console.log($scope.data_content_trading);


            }, function errorCallback(response) {
                console.log(response);
            });
        }

        $scope.reverse = true;

        $scope.sortBy = function (propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
        };


        $scope.toggleSort = function (index) {
            if ($scope.sortColumn === $scope.headers_trading[index]) {
                $scope.reverse = !$scope.reverse;
            }
            $scope.sortColumn = $scope.headers_trading[index];
        }


        $scope.edit = function (content) {
            $scope.content = content;
            $scope.edit_trading = true;
            $scope.create_trading = false;
            $scope.datepicker = content.tradedate;
            $scope.datepicker = new Date(content.tradedate);

            initContentSECID();
        }

        $scope.save = function (content) {

            let trading_json = {};

            trading_json = {

                id: content.id,
                secid: document.getElementById("edit_th_select_secid").value,
                boardid: document.getElementById("edit_th_input_text_boardid").value,
                tradedate: document.getElementById("edit_th_input_data_tradedate").value,
                shortname: document.getElementById("edit_th_input_text_shortname").value,
                numtrades: document.getElementById("edit_th_input_text_numtrades").value,
                value: document.getElementById("edit_th_input_text_value").value,
                open: document.getElementById("edit_th_input_text_open").value,
                low: document.getElementById("edit_th_input_text_low").value,
                high: document.getElementById("edit_th_input_text_high").value,
                legalcloseprice: document.getElementById("edit_th_input_text_legalcloseprice").value,
                waprice: document.getElementById("edit_th_input_text_waprice").value,
                close: document.getElementById("edit_th_input_text_close").value,
                volume: document.getElementById("edit_th_input_text_volume").value,
                marketprice2: document.getElementById("edit_th_input_text_marketprice2").value,
                marketprice3: document.getElementById("edit_th_input_text_marketprice3").value,
                admittedquote: document.getElementById("edit_th_input_text_admittedquote").value,
                mp2VALTRD: document.getElementById("edit_th_input_text_mp2VALTRD").value,
                marketprice3TRADESVALUE: document.getElementById("edit_th_input_text_marketprice3TRADESVALUE").value,
                admittedvalue: document.getElementById("edit_th_input_text_admittedvalue").value,
                waval: document.getElementById("edit_th_input_text_waval").value
            }
            console.log(trading_json);
            $http({

                method: 'PUT',
                url: '/trading/update',
                headers_trading: {"Content-Type": "application/json;charset=UTF-8"},
                data: trading_json

            }).then(function successCallback(response) {
                alert("Изменено");
                console.log("success" + response);

                content.secid = document.getElementById("edit_th_select_secid").value;
                content.boardid = document.getElementById("edit_th_input_text_boardid").value;
                content.tradedate = document.getElementById("edit_th_input_data_tradedate").value;
                content.shortname = document.getElementById("edit_th_input_text_shortname").value;
                content.numtrades = document.getElementById("edit_th_input_text_numtrades").value;
                content.value = document.getElementById("edit_th_input_text_value").value;
                content.open = document.getElementById("edit_th_input_text_open").value;
                content.low = document.getElementById("edit_th_input_text_low").value;
                content.high = document.getElementById("edit_th_input_text_high").value;
                content.legalcloseprice = document.getElementById("edit_th_input_text_legalcloseprice").value;
                content.waprice = document.getElementById("edit_th_input_text_waprice").value;
                content.close = document.getElementById("edit_th_input_text_close").value;
                content.volume = document.getElementById("edit_th_input_text_volume").value;
                content.marketprice2 = document.getElementById("edit_th_input_text_marketprice2").value;
                content.marketprice3 = document.getElementById("edit_th_input_text_marketprice3").value;
                content.admittedquote = document.getElementById("edit_th_input_text_admittedquote").value;
                content.mp2VALTRD = document.getElementById("edit_th_input_text_mp2VALTRD").value;
                content.marketprice3TRADESVALUE = document.getElementById("edit_th_input_text_marketprice3TRADESVALUE").value;
                content.admittedvalue = document.getElementById("edit_th_input_text_admittedvalue").value;
                content.waval = document.getElementById("edit_th_input_text_waval").value;

                $rootScope.$broadcast('changed_merge', 1);

            }, function errorCallback(response) {
                alert("error" + response);
                console.log("error" + response.data);
            });
        }

        $scope.create = function () {

            let info_secur_json = {};

            info_secur_json = {
                id: "",
                secid: document.getElementById("create_th_select_secid").value,
                boardid: document.getElementById("create_th_input_text_boardid").value,
                tradedate: document.getElementById("create_th_input_data_tradedate").value,
                shortname: document.getElementById("create_th_input_text_shortname").value,
                numtrades: document.getElementById("create_th_input_text_numtrades").value,
                value: document.getElementById("create_th_input_text_value").value,
                open: document.getElementById("create_th_input_text_open").value,
                low: document.getElementById("create_th_input_text_low").value,
                high: document.getElementById("create_th_input_text_high").value,
                legalcloseprice: document.getElementById("create_th_input_text_legalcloseprice").value,
                waprice: document.getElementById("create_th_input_text_waprice").value,
                close: document.getElementById("create_th_input_text_close").value,
                volume: document.getElementById("create_th_input_text_volume").value,
                marketprice2: document.getElementById("create_th_input_text_marketprice2").value,
                marketprice3: document.getElementById("create_th_input_text_marketprice3").value,
                admittedquote: document.getElementById("create_th_input_text_admittedquote").value,
                mp2VALTRD: document.getElementById("create_th_input_text_mp2VALTRD").value,
                marketprice3TRADESVALUE: document.getElementById("create_th_input_text_marketprice3TRADESVALUE").value,
                admittedvalue: document.getElementById("create_th_input_text_admittedvalue").value,
                waval: document.getElementById("create_th_input_text_waval").value
            }

            console.log(info_secur_json);
            $http({
                method: 'POST',
                url: '/trading/create',
                headers_trading: {"Content-Type": "application/json;charset=UTF-8"},
                data: info_secur_json

            }).then(function successCallback(response) {
                alert("Создано");
                $rootScope.$broadcast('changed_merge', 1);
                console.log("success create " + response.data);

                $scope.data_content_trading.push(response.data);

            }, function errorCallback(response) {
                if (response.data === 1)
                    alert("Бумага с данным secid уже существует\nПожалуйства введите другое значение.");
                else alert("Ошибка: " + response.data);
            });
        }

        $scope.delete = function (content) {

            let inx;
            if ($window.confirm("Вы хотите удалить: " + content.shortname + "?")) {

                for (let i = 0; i < $scope.data_content_trading.length; i++) {
                    if ($scope.data_content_trading[i].id === content.id) {
                        inx = i;
                        break;
                    }
                }

            } else return;

            $http({
                method: 'DELETE',
                url: '/trading/delete/' + content.id

            }).then(function successCallback(response) {
                alert("Удалено");
                console.log("Удалено");
                $rootScope.$broadcast('changed_merge', 1);
                $scope.data_content_trading.splice(inx, 1);

            }, function errorCallback(response) {
                alert("error" + response);
                console.log("error" + response);
            });
        }

        $scope.openDivCreate = function () {
            $scope.edit_trading = false;
            $scope.create_trading = true;
            initContentSECID();
        }

        function initContentSECID() {
            $http({
                method: 'GET',
                url: '/infosec/get/secid'
            }).then(function successCallback(response) {
                $scope.content_secid = [];
                for (let i = 0; i < response.data.length; i++) {
                    $scope.content_secid.push(response.data[i]);
                    console.log(response.data[i]);
                }
                console.log($scope.content_secid);

            }, function errorCallback(response) {
                console.log("222222");
                console.log(response);
            });
        }
    }]);
