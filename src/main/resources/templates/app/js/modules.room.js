define('modules/room/filters/floorFilter', ['modules/room/module'], function(module) {
  'use strict';
  module.filter('floorFilter', [function() {
    return function(inputArray, state) {
      var newArray = [];
      $.each(inputArray, function(idx, item) {
        if (item.floorbelong === state && item.floorstatus === '0') {
          newArray.push(item);
        }
      });
      return newArray;
    };
  }]);
});
define('modules/room/filters/imagePath', ['modules/room/module'], function(module) {
  'use strict';
  module.filter('imagePath', [function() {
    return function(input) {
      return 'images/' + input;
    };
  }]);
});
define('modules/room/filters/roomStatus', ['modules/room/module'], function(module) {
  'use strict';
  module.filter('roomStatus', [
    '$filter',
    function($filter) {
      return function(list) {
        var result = [];
        var pathfilter = $filter('imagePath');
        $.each(list, function(idx, item) {
          item.DoorStatus = pathfilter(item.DoorStatus);
          item.PersonalStatus = pathfilter(item.PersonalStatus);
          item.CallStatus = pathfilter(item.CallStatus);
          item.RoomStatus = pathfilter(item.RoomStatus);
          item.AlertStatus = pathfilter(item.AlertStatus);
          item.StrongStatus = pathfilter(item.StrongStatus);
          result.push(item);
        });
        return result;
      };
    }
  ]);
});
define('modules/room/factories/enumerate', ['modules/room/module'], function(module) {
  'use strict';
  module.factory('modules.room.factories.enumerate', [function() {
    return {
      LineGroups: [{
          Key: '1',
          Name: '灯光'
        },
        {
          Key: '2',
          Name: '调光'
        },
        {
          Key: '3',
          Name: '窗帘'
        },
        {
          Key: '4',
          Name: '新风'
        },
        {
          Key: '5',
          Name: '保险柜'
        }
      ]
    };
  }]);
});
define('modules/room/factories/stateAdapter', ['modules/room/module'], function(module) {
  'use strict';
  module.factory('modules.room.factories.stateAdapter', [
    '$q',
    '$location',
    '$appConfig',
    function($q, $location, $appConfig) {
      return {
        _socketClient: null,
        connect: function(url) {
          if (this._socketClient != null) {
            this._socketClient.close();
          }
          var me = this;
          var defer = $q.defer();
          var receiveFn;
          var wsurl = function(address) {
            if ($appConfig.serverUrl && $appConfig.serverUrl !== '')
              // return 'ws://' + $appConfig.serverUrl.replace('http://', '') + address;
              return 'ws://118.190.209.65:9876' + address;
            else
              return 'ws://' + $location.host() + ':' + $location.port() + address;
          }(url);
          defer.receive = function(data) {
            if (receiveFn && $.isFunction(receiveFn))
              receiveFn(data);
          };
          defer.promise.onopened = function(fn) {
            if ($.isFunction(fn)) {
              defer.promise.then(fn);
            }
            return defer.promise;
          };
          defer.promise.onreceived = function(fn) {
            if ($.isFunction(fn)) {
              receiveFn = fn;
            }
            return defer.promise;
          };
          defer.promise.onerror = function(fn) {
            if ($.isFunction(fn)) {
              defer.promise['catch'](fn);
            }
            return defer.promise;
          };
          this._socketClient = new WebSocket(wsurl);
          this._socketClient.onopen = function(event) {
            defer.resolve();
          };
          this._socketClient.onmessage = function(event) {
            defer.receive(event.data);
          };
          this._socketClient.onerror = function() {
            defer.reject();
          };
          return defer.promise;
        },
        send: function(params) {
          this._socketClient.send(JSON.stringify(params));
        },
        close: function() {
          if (this._socketClient) {
            this._socketClient.close();
          }
        }
      };
    }
  ]);
});
define('modules/room/services/registerService', ['modules/room/module'], function(module) {
  'use strict';
  module.service('modules/room/services/registerService', [
    'modules.manageui.factories.tableParameter',
    function(tableParameter) {
      var me = this;
      this.tableParams = new tableParameter({
        url: '/enter/findEnterup',
        count: 9,
        counts: [9, 18]
      });
      this.load = function() {
        me.tableParams.reload();
      };
    }
  ]);
});
define('modules/room/services/messageService', ['modules/room/module'], function(module) {
  'use strict';
  module.service('modules.room.services.messageService', [function() {
    var me = this;
    this.actives = {
      call: false,
      checkIn: false,
      room: false,
      message: false
    };
    this.active = function(type, status) {
      if (status !== undefined) {
        me.actives[type] = status;
      } else {
        me.actives[type] = me.actives[type] === true ? false : true;
      }
    };
    this.activeSingle = function(type) {
      $.each(me.actives, function(idx) {
        if (type !== idx) {
          me.actives[idx] = false;
        } else if (me.actives[idx] === false) {
          me.actives[idx] = true;
        }
      });
    };
    this.activeAll = function() {
      $.each(me.actives, function(idx) {
        me.actives[idx] = true;
      });
    };
  }]);
});
define('modules/room/directives/ngPager', ['modules/room/module'], function(module) {
  'use strict';
  module.directive('ngPager', [function() {
    return {
      scope: {
        ngPager: '='
      },
      replace: true,
      template: '<div class="container-fluid"> <div class="ng-table-counts pagination btn-group pull-right"> <button ng-repeat="count in ngPager.settings().counts" type="button" ng-class="{\'active\':ngPager.count()==count}" ng-click="ngPager.count(count)" class="btn btn-default"> <span ng-bind="count"></span> </button> </div> <ul class="pagination ng-table-pagination"> <li ng-class="{\'disabled\': !page.active && !page.current, \'active\': page.current}" ng-repeat="page in pages" ng-switch="page.type"> <a ng-switch-when="prev" ng-click="ngPager.page(page.number)" href="">&laquo;</a> <a ng-switch-when="first" ng-click="ngPager.page(page.number)" href=""><span ng-bind="page.number"></span></a> <a ng-switch-when="page" ng-click="ngPager.page(page.number)" href=""><span ng-bind="page.number"></span></a> <a ng-switch-when="more" ng-click="ngPager.page(page.number)" href="">&#8230;</a> <a ng-switch-when="last" ng-click="ngPager.page(page.number)" href=""><span ng-bind="page.number"></span></a> <a ng-switch-when="next" ng-click="ngPager.page(page.number)" href="">&raquo;</a> </li> </ul> </div>',
      controller: [
        '$scope',
        'ngTableEventsChannel',
        function($scope, ngTableEventsChannel) {
          ngTableEventsChannel.onAfterReloadData(function(pubParams) {
            if ($scope.ngPager)
              $scope.pages = $scope.ngPager.generatePagesArray();
          });
        }
      ]
    };
  }]);
});
define('modules/room/controllers/test', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.test', [
    '$scope',
    '$state',
    '$appEnvironment',
    '$element',
    function($scope, $state, $appEnvironment, $element) {
      var me = this;
    }
  ]);
});
define('modules/room/components/system/bar', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/system/bar', [
    '$scope',
    '$modal',
    'modules.manageui.configs.linkManager',
    'modules.manageui.services.tabService',
    'modules.room.services.messageService',
    'modules/room/services/registerService',
    'app.services.httpService',
    'app.services.popupService',
    function($scope, $modal, linkManager, tabService, messageService, registerService, httpService, popupService) {
      $scope.service = messageService;
      this.openMessage = function(type) {
        tabService.open(linkManager.get('roommanage').get('roommanage_infomanage'));
        messageService.activeSingle(type);
      };
      this.checkIn = function() {
        $modal.open({
          templateUrl: 'modules/room/components/system/checkIn.html',
          size: 'sm'
        }).result.then(function(data) {
          httpService.post('/enter/addEnterup', data).then(function() {
            popupService.information('登记成功');
            registerService.load();
          });
        });
      };
      this.checkOut = function() {
        $modal.open({
          templateUrl: 'modules/room/components/system/checkOut.html',
          size: 'sm'
        });
      };
    }
  ]);
});
define('modules/room/components/system/home', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/system/home', [
    '$scope',
    '$state',
    '$appEnvironment',
    '$element',
    'modules.manageui.configs.linkManager',
    'modules.manageui.services.tabService',
    'modules.room.services.messageService',
    function($scope, $state, $appEnvironment, $element, linkManager, tabService, messageService) {
      var me = this;
      $element.find('.widget-column').sortable({
        connectWith: '.widget-column',
        handle: '.panel-heading',
        cancel: '.widget-toggle',
        placeholder: 'widget-placeholder ui-corner-all'
      });
      $element.disableSelection();
      $scope.service = messageService;
      this.openMessage = function(type) {
        tabService.open(linkManager.get('roommanage').get('roommanage_infomanage'));
        messageService.activeSingle(type);
      };
    }
  ]);
});
define('modules/room/components/system/state', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/system/state', [
    '$scope',
    '$timeout',
    '$modal',
    '$q',
    'modules.room.factories.stateAdapter',
    'app.services.httpService',
    'app.services.popupService',
    function($scope, $timeout, $modal, $q, stateAdapter, httpService, popupService) {
      function toDoReceive(data, obj) {
        console.log('socket接口的参数:', data);

        var defer = $q.defer();
        stateAdapter.connect('/h5ws').onopened(function() {
          stateAdapter.send({
            code: 1,
            data: data
          });
        }).onreceived(function(result) {
          var jsonResult = JSON.parse(result);
          if (jsonResult) {
            defer.resolve(jsonResult.data);
            obj.rooms = jsonResult.data;
            $scope.$apply();
          }
        }).onerror(function() {
          popupService.error('房间状态服务异常');
        });
        return defer.promise;
      }
      $scope.current = null;
      $scope.selectedFloor = [];
      var me = this;
      $scope.$controller = this;
      this.rooms = [];
      this.floors = [];
      this.openControl = function(id) {
        $modal.open({
          templateUrl: 'modules/room/components/system/roomControl.html',
          size: 'lg'
        });
      };
      this.load = function() {
        httpService.post('/buildinghotel/findBuildingHotel').then(function(result) {
          if (result && result.length > 0) {
            $scope.$globalStore.builds = result;
            $scope.current = result[0];
          }
        });
      };
      this.getFloorHotelList = function(building) {
        httpService.get('/floor/findFloorHotelList?buildingId=' + building.buildingId).then(function(floors) {
          if (floors && floors.length > 0) {
            me.floors = floors;
            var floor = floors.find(function(item) {
              return item.floorbelong == 0 && item.floor == 1;
            }) || floors[0];
            me.selectFloor(floor);
          }
        });
      };
      this.showComment = function(roomId) {
        $modal.open({
          templateUrl: 'modules/room/components/system/comment.html',
          data: {
            roomId: roomId
          }
        });
      };
      this.selectFloor = function(floor) {
        // var selected = $scope.selectedFloor.find(function(item) {
        //   return floor.id == item.id;
        // });
        // for (var i = 0; i < $scope.selectedFloor.length; i++) {
        //   var floorId = $scope.selectedFloors[i];
        //   if (floorId == floor.id) {
        //     $scope.selectedFloor.splice(i, 1);
        //     return;
        //   }
        // }
        // $scope.selectedFloor.push(floor.id);
        $scope.selectedFloor = [floor];
      };
      this.getServicePic = function(type) {
        switch (type) {
          case 'Accepted':
            return 'null.png';
          case 'Close':
            return 'CallGrey.png';
          case 'Open':
            return 'CallColor.png';
        }
      };
      this.getRoomStatus = function(type) {
        switch (type) {
          case 'DaiZu':
            return 'null.png';
          case 'YiZu':
            return 'lease.png';
          case 'YuDing':
            return 'CheckoutColor.png';
          case 'WeiXiu':
            return 'Fix.png';
          case 'KongZhi':
            return 'unlease.png';
          case 'ZangFang':
            return 'unclearcolor.png';
        }
      };
      this.getAlertStatus = function(type) {
        switch (type) {
          case 'WuRao':
            return 'UndisturbColor.png';
          case 'QingLi':
            return 'ClearColor.png';
          case 'TuiFang':
            return 'CheckoutColor.png';
        }
      };

      var buildWatched = $scope.$watch(function() {
        return $scope.current;
      }, function(newValue) {
        if (newValue) {
          me.getFloorHotelList(newValue);
        }
        // if ($scope.current && $scope.selectedFloor) {
        //   toDoReceive({
        //     buildingId: $scope.current.buildingId,
        //     // floors: [$scope.selectedFloor.id],
        //     floors: $scope.selectedFloor,
        //   }, $scope.$controller).then(function(result) {
        //     me.rooms = result;
        //   });
        // }
      });

      var floorWatched = $scope.$watch(function() {
        // return $scope.selectedFloor;
        return $scope.selectedFloor.length;
      }, function(newValue) {
        if ($scope.current && newValue > 0) {
          toDoReceive({
            buildingId: $scope.current.buildingId,
            // floors: [$scope.selectedFloor.id]
            floors: $scope.selectedFloor
          }, $scope.$controller).then(function(result) {
            me.rooms = result;
          });
        }
        //  else if (!$scope.current) {
        //   toDoReceive({}, $scope.$controller).then(function(result) {
        //     me.rooms = result;
        //   });
        // }
        me.rooms = [];
      });
      //排序
      $scope.sortFloor = function(item) {
        if (item.floorbelong == 0) {
          return item.floor;
        } else if (item.floorbelong == 1) {
          return -item.floor;
        }
      };
      $scope.$on('$destroy', function() {
        stateAdapter.close();
        if (buildWatched)
          buildWatched();
        if (floorWatched)
          floorWatched();
      });
    }
  ]);
});
define('modules/room/components/system/comment', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/system/comment', [
    '$scope',
    '$timeout',
    '$modal',
    '$q',
    'modules.room.factories.stateAdapter',
    'app.services.httpService',
    'app.services.popupService',
    function($scope, $timeout, $modal, $q, stateAdapter, httpService, popupService) {
      function connectRoom() {
        var defer = $q.defer();
        stateAdapter.connect('/h5ws').onreceived(function(result) {
          var jsonResult = JSON.parse(result);
          if (jsonResult) {
            defer.resolve(jsonResult.data);
          }
        }).onerror(function() {});
        return defer.promise;
      }
      $scope.messages = [];
      $scope.adapter = connectRoom().then(function(data) {});
      $scope.send = function() {
        stateAdapter.send({
          code: 3,
          data: {
            roomId: $scope.$data.roomId,
            content: $scope.message
          }
        });
        $scope.message = '';
      };
      $scope.$on('$destroy', function() {
        stateAdapter.close();
      });
    }
  ]);
});
define('modules/room/components/rcu/rcu', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/rcu/rcu', [
    '$scope',
    '$modal',
    'modules.manageui.factories.tableParameter',
    'app.services.httpService',
    'app.services.ajaxService',
    'app.services.popupService',
    function($scope, $modal, tableParameter, httpService, ajaxService, popupService) {
      var me = this;
      me.current = null;
      $scope.builds = [];
      me.floorParams = {
        floorid: null
      };
      me.type = 'rcu_project';
      $scope.changeType = function(type) {
        me.type = type;
        me.select($scope.builds[0].floors[0]);
      };
      // this.timeTable = new tableParameter({
      //   url: '/rcuSettime/findRunTimeRcu',
      //   data: me.floorParams
      // });
      me.upgrade = function() {};
      me.reset = function() {
        $modal.open({
          templateUrl: 'modules/room/components/rcu/reset.html'
        });
      };
      me.select = function(floor) {
        me.current = floor;
        me.floorParams.floorid = floor.id;
        if (me.type == 'rcu_project') {
          me.tableParams1.reload();
        } else if (me.type == 'rcu_param') {
          me.tableParams2.reload();
        } else if (me.type == 'rcu_time') {
          me.tableParams3.reload();
        }
      };
      me.load = function() {
        $scope.builds = [];
        httpService.post('/floor/allfloor', {}).then(function(result) {
          $.each(result, function(idx, item) {
            var addedbuild = $.grep($scope.builds, function(value) {
              return value.buildingId === item.buildingId;
            });
            if (addedbuild.length > 0) {
              addedbuild[0].floors.push(item);
            } else {
              $scope.builds.push({
                buildingId: item.buildingId,
                buildingName: item.buildingName,
                floors: [item]
              });
            }
          });
          me.current = $scope.builds[0].floors[0];
          me.floorParams.floorid = me.current.id;
          me.tableParams1 = new tableParameter({
            url: '/rcu/findRcu',
            data: me.floorParams
          });
          me.tableParams2 = new tableParameter({
            url: '/rcuSetparam/findRcuSetparam',
            data: me.floorParams
          });
          me.tableParams3 = new tableParameter({
            url: '/rcu/findRcu',
            data: me.floorParams
          });
        });
      };
      me.editProject = function(project) {
        $modal.open({
          templateUrl: 'templates/modal/projectForm.html',
          data: $.extend({}, project)
        }).result.then(function(data) {
          console.log(data);

          // delete data.buildingName;
          // delete data.$$hashKey;
          // ajaxService.post('/roomhotel/modifyRoomHotel', data).then(function(result) {
          //   me.tableParams.reload();
          // });
        });
      };
      me.editParameters = function(parameters) {
        $modal.open({
          templateUrl: 'templates/modal/parametersForm.html',
          data: $.extend({}, parameters)
        }).result.then(function(data) {
          console.log(data);

          // delete data.buildingName;
          // delete data.$$hashKey;
          // ajaxService.post('/roomhotel/modifyRoomHotel', data).then(function(result) {
          //   me.tableParams.reload();
          // });
        });
      };
      me.editTimeSettings = function(timeSettings) {
        $modal.open({
          templateUrl: 'templates/modal/timeSettingsForm.html',
          data: $.extend({}, timeSettings)
        }).result.then(function(data) {
          console.log(data);

          // delete data.buildingName;
          // delete data.$$hashKey;
          // ajaxService.post('/roomhotel/modifyRoomHotel', data).then(function(result) {
          //   me.tableParams.reload();
          // });
        });
      };
    }
  ]);
});
define('modules/room/components/rcu/projectForm', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/rcu/projectForm', [
    '$scope',
    'app.services.httpService',
    function($scope, httpService) {
      $scope.roomTypes = [];
      httpService.post('/roomtype/findRoomtypeHotels', {}).then(function(result) {
        $scope.roomTypes = result;
      });
    }
  ]);
});
define('modules/room/components/rcu/parametersForm', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/rcu/parametersForm', [
    '$scope',
    'app.services.httpService',
    function($scope, httpService) {
      $scope.roomTypes = [];
      httpService.post('/roomtype/findRoomtypeHotels', {}).then(function(result) {
        $scope.roomTypes = result;
      });
    }
  ]);
});
define('modules/room/components/rcu/timeSettingsForm', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/rcu/timeSettingsForm', [
    '$scope',
    'app.services.httpService',
    function($scope, httpService) {

    }
  ]);
});
define('modules/room/components/manage/registers', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/manage/registers', [
    '$scope',
    'modules/room/services/registerService',
    'modules.manageui.factories.tableParameter',
    'app.services.httpService',
    function($scope, registerService, tableParameter, httpService) {
      var me = this;
      this.tableParams = registerService.tableParams;
    }
  ]);
});
define('modules/room/components/manage/build', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.components.manage.build', [
    '$scope',
    '$modal',
    'NgTableParams',
    'app.services.popupService',
    'app.services.ajaxService',
    function($scope, $modal, NgTableParams, popupService, httpService) {
      var me = this;
      this.tableParams = new NgTableParams();
      this.add = function() {
        $modal.open({
          templateUrl: 'modules/room/components/manage/buildForm.html',
          data: {}
        }).result.then(function(data) {
          data.extfloor = data.excludes.join(',');
          data.extsubfloor = data.excsubs.join(',');
          delete data.excludes;
          delete data.excsubs;
          httpService.post('/buildinghotel/addBuildingHotel', data).then(function(result) {
            me.load();
          });
        });
      };
      this.edit = function(build) {
        if (build.extfloor)
          build.excludes = build.extfloor.split(',');
        if (build.extsubfloor)
          build.excsubs = build.extsubfloor.split(',');
        $modal.open({
          templateUrl: 'modules/room/components/manage/buildForm.html',
          data: build
        }).result.then(function(data) {
          data.extfloor = data.excludes.join(',');
          data.extsubfloor = data.excsubs.join(',');
          delete data.excludes;
          delete data.excsubs;
          httpService.post('/buildinghotel/modifyBuildingHotel', {
            buildingId: data.buildingId,
            buildingName: data.buildingName,
            floor: data.floor,
            subFloor: data.subFloor,
            extfloor: data.extfloor,
            extsubfloor: data.extsubfloor
          }).then(function(result) {
            me.load();
          });
        });
      };
      this.drop = function(id) {
        popupService.confirm('是否删除楼栋和房间\uFF1F').ok(function() {
          httpService.post('/buildinghotel/delBuildingHotel', {
            buildingId: id
          }).then(function(result) {
            popupService.information();
            me.load();
          });
        });
      };
      this.default = function(id) {
        popupService.confirm('是否设为默认楼栋\uFF1F').ok(function() {
          // ajaxService.post('/roomhotel/delRoomHotel', {
          //   id: id
          // }).then(function() {
          //   me.tableParams.reload();
          // });
        });
      };
      this.load = function() {
        httpService.post('/buildinghotel/findBuildingHotel', {}).then(function(result) {
          $scope.$globalStore.builds = result;
        });
      };
    }
  ]);
});
define('modules/room/components/manage/buildForm', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules/room/components/manage/buildForm', [
    '$scope',
    'NgTableParams',
    'app.services.httpService',
    'app.services.ajaxService',
    function($scope, NgTableParams, httpService, ajaxService) {
      var me = this;
      $scope.$data = $scope.$data ? $scope.$data : {};
      $scope.$data.excludes = $scope.$data.excludes ? $scope.$data.excludes : [];
      $scope.$data.excsubs = $scope.$data.excsubs ? $scope.$data.excsubs : [];
      this.list = [];
      this.loadFloors = function(buildId) {
        ajaxService.json('/buildinghotel/selectFloorHotelList', JSON.stringify({
          buildingId: buildId
        })).then(function(result) {
          me.list = result;
        });
      };
      this.floors = function(n) {
        var arr = [];
        for (var i = 1; i <= n; i++) {
          arr.push(i + '');
        }
        return arr;
      };
      this.floorChange = function(num) {
        var floorIndex = $scope.$data.excludes.indexOf(num);
        if (floorIndex >= 0) {
          $scope.$data.excludes.splice(floorIndex, 1);
        } else {
          $scope.$data.excludes.push(num);
        }
      };
      this.subChange = function(num) {
        var floorIndex = $scope.$data.excsubs.indexOf(num);
        if (floorIndex >= 0) {
          $scope.$data.excsubs.splice(floorIndex, 1);
        } else {
          $scope.$data.excsubs.push(num);
        }
      };
    }
  ]);
});
define('modules/room/components/manage/roomTypes', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.components.manage.roomTypes', [
    '$scope',
    '$modal',
    '$appConfig',
    'NgTableParams',
    'app.services.ajaxService',
    'app.services.httpService',
    'app.services.popupService',
    function($scope, $modal, $appConfig, NgTableParams, ajaxService, httpService, popupService) {
      var me = this;
      this.list = [];
      this.current = {};
      this.tableParams = new NgTableParams();
      this.select = function(row) {
        ajaxService.post('/roomtype/findRoomtypeHotel', {
          rmtypeid: row.rmtypeid
        }).then(function(result) {
          me.current = $.extend({}, result[0]);
        });
      };
      this.add = function() {
        $modal.open({
          templateUrl: 'modules/room/components/manage/roomTypeForm.html',
          data: {
            Lines: []
          }
        }).result.then(function(data) {
          var bean = {};
          bean.rmtypename = data.rmtypename;
          bean.roomtypeEquipmentVo = data.Lines;
          ajaxService.json('/roomtype/addRoomType', JSON.stringify(bean)).then(function(result) {
            me.load();
          });
        });
      };
      this.edit = function(event, id) {
        event.stopPropagation();
        ajaxService.post('/roomtype/findRoomtypeHotel', {
          rmtypeid: id
        }).then(function(result) {
          var roomType = result[0];
          roomType.Lines = roomType.roomtypeEquipmentVo;
          $modal.open({
            templateUrl: 'modules/room/components/manage/roomTypeForm.html',
            data: roomType
          }).result.then(function(data) {
            var bean = {};
            bean.rmtypeid = data.rmtypeid;
            bean.rmtypename = data.rmtypename;
            bean.roomtypeEquipmentVo = data.Lines;
            ajaxService.json('/roomtype/modifyRoomTypeHotel', JSON.stringify(bean)).then(function(result) {
              me.load();
            });
          });
        });
      };
      this.drop = function(event, id) {
        event.stopPropagation();
        popupService.confirm('是否删除\uFF1F').ok(function() {
          me.current = {};
          ajaxService.post('/roomtype/delRoomTypeHotel', {
            id: id
          }).then(function() {
            me.load();
          });
        });
      };
      this.load = function() {
        ajaxService.post('/roomtype/findRoomtypeHotels', {}).then(function(result) {
          me.list = result;
        });
      };
      this.load();
    }
  ]);
});
define('modules/room/components/manage/roomTypeForm', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.components.manage.roomTypeForm', [
    '$scope',
    'NgTableParams',
    'app.services.ajaxService',
    function($scope, NgTableParams, ajaxService) {
      var me = this;
      $scope.equipments = [];
      $scope.equipmentNames = {};
      $scope.roads = [];
      $scope.roadNames = {};
      $scope.table = new NgTableParams({}, {
        groupBy: 'equid',
        getData: function() {
          $.each($scope.data.Lines, function(idx, item) {
            $scope.data.Lines[idx].idx = idx;
          });
          return $scope.data.Lines;
        }
      });
      $scope.data = $.extend({}, $scope.$data);
      this.newLine = {};
      this.current = {};
      this.editing = -1;
      this.addLine = function() {
        $scope.data.Lines.push($.extend({
          equname: $scope.equipmentNames[me.newLine.equid]
        }, me.newLine));
        me.newLine = {};
        $scope.table.reload();
      };
      this.removeLine = function(idx) {
        $scope.data.Lines.splice(idx, 1);
        $scope.table.reload();
      };
      this.beginEditing = function(idx) {
        me.editing = idx;
        me.current = $.extend({}, $scope.data.Lines[idx]);
      };
      this.applyEditing = function(idx) {
        $scope.data.Lines[idx] = $.extend({
          equname: $scope.equipmentNames[me.current.equid]
        }, me.current);
        $scope.table.reload();
        me.cancelEditing();
      };
      this.cancelEditing = function() {
        me.editing = -1;
        me.current = {};
      };
      this.getEquipment = function(eid) {
        var query = $.grep($scope.equipments, function(item) {
          return item.id === eid;
        });
        return query.length > 0 ? query[0] : {};
      };
      ajaxService.post('/equipment/findEquipmentHotel', {}).then(function(result) {
        $scope.equipments = result;
        $.each(result, function(idx, item) {
          $scope.equipmentNames[item.id] = item.equipmentname;
        });
      });
      ajaxService.post('/electric/findElectricRoad', {}).then(function(result) {
        $scope.roads = result;
        $.each(result, function(idx, item) {
          $scope.roadNames[item.id] = item.elename;
        });
      });
    }
  ]);
});
define('modules/room/controllers/roles', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.roles', [
    '$scope',
    '$modal',
    'NgTableParams',
    'app.services.httpService',
    'app.services.ajaxService',
    'app.services.popupService',
    function($scope, $modal, NgTableParams, httpService, ajaxService, popupService) {
      var me = this;
      this.tableParams = new NgTableParams();
      this.list = [];
      this.add = function() {
        $modal.open({
          templateUrl: 'views/room/personal/RoleForm.html'
        }).result.then(function(data) {
          ajaxService.post('/roleauth/addRoleAuthority', data).then(function() {
            me.load();
          });
        });
      };
      this.edit = function(role) {
        $modal.open({
          templateUrl: 'views/room/personal/RoleForm.html',
          data: $.extend({}, role)
        }).result.then(function(data) {
          ajaxService.post('/roleauth/modifyRoleAuthority', data).then(function() {
            me.load();
          });
        });
      };
      this.authorize = function(id) {
        $modal.open({
          templateUrl: 'views/room/personal/Authorize.html'
        });
      };
      this.drop = function(id) {
        popupService.confirm('是否删除\uFF1F').ok(function() {
          ajaxService.post('/roleauth/delRoleAuthority', {
            'id': id
          }).then(function() {
            me.load();
          });
        });
      };
      this.load = function() {
        httpService.post('/roleauth/findRoleAuthorityList', {}).then(function(result) {
          me.list = result;
        });
      };
    }
  ]);
});
define('modules/room/controllers/rooms', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.rooms', [
    '$scope',
    '$modal',
    'modules.manageui.factories.tableParameter',
    'app.services.httpService',
    'app.services.ajaxService',
    'app.services.popupService',
    function($scope, $modal, tableParameter, httpService, ajaxService, popupService) {
      var me = this;
      $scope.$controller = this;
      $scope.current = null;
      $scope.builds = [];
      this.floorParams = {
        floorid: null
      };
      this.select = function(floor) {
        $scope.current = floor;
        me.floorParams.floorid = floor.id;
        me.tableParams.reload();
      };
      this.add = function() {
        $modal.open({
          templateUrl: 'views/room/manage/RoomForm.html',
          data: {
            floorid: $scope.current.id,
            buildingName: $scope.current.buildingName,
            floorname: $scope.current.floorname
          }
        }).result.then(function(data) {
          console.log(data);
          delete data.buildingName;
          data.floorid = $scope.current.id;
          httpService.post('/roomhotel/addRoomHotel', data).then(function(result) {
            me.tableParams.reload();
          });
        });
      };
      this.addRange = function() {
        $modal.open({
          templateUrl: 'views/room/manage/RoomRange.html',
          data: {
            NumberStart: 1,
            NumberEnd: 10
          }
        }).result.then(function(data) {
          var dataArr = [];
          var len = data.NumberEnd - data.NumberStart;
          for (let i = 0; i <= len; i++) {
            var tempData = {
              floorid: $scope.current.id,
              floorname: $scope.current.floorname,
              rmtypename: data.rmtypename,
              roomip: data.Ip1 + '.' + data.Ip2 + '.' + data.Ip3 + '.' + (data.Ip4s + i),
              roomnum: data.NumberStart + i,
              roomtypeid: data.roomtypeid,
            };
            dataArr.push(tempData);
          }
          console.log(JSON.stringify(dataArr));
          httpService.post('/roomhotel/addRoomHotelBatch', {
            roomHotelList: dataArr
          }).then(function(result) {
            me.tableParams.reload();
          });
        });
      };
      this.edit = function(room) {
        $modal.open({
          templateUrl: 'views/room/manage/RoomForm.html',
          data: $.extend({}, room)
        }).result.then(function(data) {
          delete data.buildingName;
          delete data.$$hashKey;
          ajaxService.post('/roomhotel/modifyRoomHotel', data).then(function(result) {
            me.tableParams.reload();
          });
        });
      };
      this.drop = function(id) {
        popupService.confirm('是否删除\uFF1F').ok(function() {
          ajaxService.post('/roomhotel/delRoomHotel', {
            id: id
          }).then(function() {
            me.tableParams.reload();
          });
        });
      };
      this.load = function() {
        $scope.builds = [];
        httpService.post('/floor/allfloor', {}).then(function(result) {
          $.each(result, function(idx, item) {
            var addedbuild = $.grep($scope.builds, function(value) {
              return value.buildingId === item.buildingId;
            });
            if (addedbuild.length > 0) {
              addedbuild[0].floors.push(item);
            } else {
              $scope.builds.push({
                buildingId: item.buildingId,
                buildingName: item.buildingName,
                floors: [item]
              });
            }
          });
          $scope.current = $scope.builds[0].floors[0];
          me.floorParams.floorid = $scope.current.id;
          me.tableParams = new tableParameter({
            url: '/roomhotel/findRoomHotel',
            data: me.floorParams
          });
        });
      };
    }
  ]);
});
define('modules/room/controllers/roomForm', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.roomForm', [
    '$scope',
    'app.services.httpService',
    'modules.room.factories.enumerate',
    function($scope, httpService, enumerate) {
      $scope.roomTypes = [];
      httpService.post('/roomtype/findRoomtypeHotels', {}).then(function(result) {
        $scope.roomTypes = result;
      });

      $scope.selectType = function(roomtypeid) {
        for (var i = 0; i < $scope.roomTypes.length; i++) {
          var item = $scope.roomTypes[i];
          if (item.rmtypeid == roomtypeid) {
            $scope.$data.rmtypename = item.rmtypename;
            break;
          }
        }
      };
    }
  ]);
});
// define('modules/room/controllers/roomTypeForm', [
//   'modules/room/module',
//   'jquery-ui'
// ], function(module) {
//   'use strict';
//   module.controller('modules.room.controllers.roomTypeForm', [
//     '$scope',
//     function($scope) {

//     }
//   ]);
// });
define('modules/room/controllers/message', [
  'modules/room/module',
  'jquery-ui'
], function(module) {
  'use strict';
  module.controller('modules.room.controllers.message', [
    '$scope',
    'modules.manageui.factories.tableParameter',
    'modules.room.services.messageService',
    function($scope, tableParameter, messageService) {
      $scope.service = messageService;
      this.tableParams = new tableParameter({});
    }
  ]);
});
define('modules/room/controllers/users', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.users', [
    '$scope',
    '$modal',
    'NgTableParams',
    'app.services.popupService',
    'app.services.httpService',
    'app.services.ajaxService',
    function($scope, $modal, tableParameter, popupService, httpService, ajaxService) {
      var me = this;
      this.list = [];
      this.add = function() {
        $modal.open({
          templateUrl: 'views/room/personal/UserForm.html'
        }).result.then(function(data) {
          data.personRoleRelationAuthoritys = [{
            roleCode: data.roleId
          }];
          ajaxService.json('/personauth/addRoleAuthority', JSON.stringify(data)).then(function() {
            popupService.information('添加成功');
            me.load();
          });
        });
      };
      this.edit = function(user) {
        if (user.personRoleRelationAuthoritys && user.personRoleRelationAuthoritys.length > 0)
          user.roleId = user.personRoleRelationAuthoritys[0].roleCode;
        $modal.open({
          templateUrl: 'views/room/personal/UserForm.html',
          data: user
        }).result.then(function(data) {
          data.personRoleRelationAuthoritys = [{
            roleCode: data.roleId
          }];
          ajaxService.json('/personauth/modifyPersonAuthority', JSON.stringify(data)).then(function() {
            popupService.information('添加成功');
            me.load();
          });
        });
      };
      this.changePassword = function(id) {
        $modal.open({
          templateUrl: 'views/room/personal/UserPassword.html',
          size: 'sm'
        }).result.then(function(data) {});
      };
      this.drop = function(id) {
        popupService.confirm('是否删除\uFF1F').ok(function() {
          ajaxService.post('/personauth/delPersonAuthority', {
            id: id
          }).then(function() {
            popupService.information('删除成功');
            me.load();
          });
        });
      };
      this.load = function() {
        httpService.post('/personauth/findPersonAuthorityList', {}).then(function(result) {
          me.list = result;
        });
      };
    }
  ]);
});
define('modules/room/controllers/eventRoom', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.eventRoom', [
    '$scope',
    'modules.manageui.factories.tableParameter',
    'app.services.httpService',
    function($scope, tableParameter, httpService) {
      var me = this;
      this.roomQueries = {
        warntype: 1,
        warnStartTime: null,
        warnEndTime: null,
        buildingName: null
      };
      this.list = [];
      this.tableParams = new tableParameter({
        url: '/warning/findWarningList',
        data: me.roomQueries
      });
      this.queryRoomEvent = function() {};
      httpService.post('/buildinghotel/findBuildingHotel', {}).then(function(result) {
        $scope.$globalStore.builds = result;
      });
      this.changeWarntype = function(type) {
        console.log(type);

        this.warntype = type;
      };
    }
  ]);
});
define('modules/room/controllers/eventSystem', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.eventSystem', [
    '$scope',
    'modules.manageui.factories.tableParameter',
    'app.services.httpService',
    function($scope, tableParameter, httpService) {
      var me = this;
      this.roomQueries = {
        warntype: 2,
        warnStartTime: null,
        warnEndTime: null,
        buildingName: null
      };
      this.list = [];
      this.tableParams = new tableParameter({
        url: '/warning/findWarningList',
        data: me.roomQueries
      });
    }
  ]);
});
define('modules/room/controllers/identitySettings', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.identitySettings', [
    '$scope',
    'modules.manageui.factories.tableParameter',
    'app.services.popupService',
    'app.services.httpService',
    function($scope, tableParameter, popupService, httpService) {
      var me = this;
      this.newItem = {};
      this.list = [];
      this.onoffTypes = [
        '红外感应',
        'TIMIC',
        'MIFARE'
      ];
      this.tableParams = new tableParameter({
        url: '/identifier/findIdentifierSet'
      });
      this.selectImage = function(row) {};
      this.add = function() {
        httpService.post('/identifier/addIdentifierSet', me.newItem).then(function() {
          me.tableParams.reload();
        });
      };
      this.drop = function(row) {
        popupService.confirm('是否删除\uFF1F').ok(function() {
          httpService.post('/identifier/delIdentifierSet', {
            id: row.id
          }).then(function() {
            me.tableParams.reload();
          });
        });
      };
    }
  ]);
});
define('modules/room/controllers/parameterSettings', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.parameterSettings', [
    '$scope',
    'app.services.httpService',
    'app.services.popupService',
    function($scope, httpService, popupService) {
      var me = this;
      this.list = [];
      this.orgList = [];
      this.add = function() {};
      this.remove = function() {};
      this.edit = function() {};
      this.valueUp = function(val) {
        var result = $.isNumeric(val) ? val : parseInt(val, 10);
        return result - -1;
      };
      this.valueDown = function(val) {
        var result = $.isNumeric(val) ? val : parseInt(val, 10);
        return result - 1;
      };
      this.save = function() {
        httpService.post('/setval/modifyEquipmentSetval', me.orgList).then(function(result) {
          popupService.information('保存成功');
        });
      };
      this.load = function() {
        httpService.post('/setval/findEquipmentSetval').then(function(result) {
          me.orgList = result;
          var categories = [];
          $.each(result, function(idx, item) {
            if (categories.indexOf(item.topparamtype) < 0) {
              categories.push(item.topparamtype);
            }
          });
          var categoryList = [];
          $.each(categories, function(idx, item) {
            var current = {
              topparamtype: item,
              result: []
            };
            $.each(result, function(i, par) {
              if (par.topparamtype === item) {
                current.result.push(par);
              }
            });
            categoryList.push(current);
          });
          $.each(categoryList, function(idx, item) {
            var groups = [];
            $.each(item.result, function(i, g) {
              if (groups.indexOf(g.parambelongtype) < 0) {
                groups.push(g.parambelongtype);
              }
            });
            item.groups = [];
            $.each(groups, function(i, g) {
              var current = {
                parambelongtype: g,
                parameters: []
              };
              $.each(item.result, function(j, h) {
                if (h.parambelongtype === g) {
                  current.parameters.push(h);
                }
              });
              item.groups.push(current);
            });
            delete item.result;
          });
          me.list = categoryList;
        });
      };
    }
  ]);
});
define('modules/room/controllers/mode', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.mode', [
    '$scope',
    '$modal',
    'modules.manageui.factories.tableParameter',
    'app.services.popupService',
    'app.services.httpService',
    function($scope, $modal, tableParameter, popupService, httpService) {
      var me = this;
      this.list = [];
      this.tableParams = new tableParameter({
        url: '/defaultval/findDefaultvalList'
      });
      this.add = function() {
        $modal.open({
          templateUrl: 'views/room/settings/ModeForm.html',
          size: 'sm'
        }).result.then(function(data) {
          httpService.post('/defaultval/addDefaultval', data).then(function(result) {
            me.tableParams.reload();
          });
        });
      };
      this.edit = function(row) {
        $modal.open({
          templateUrl: 'views/room/settings/ModeForm.html',
          size: 'sm',
          data: $.extend({}, row)
        }).result.then(function(data) {
          httpService.post('/defaultval/modifyDefaultval', data).then(function(result) {
            me.tableParams.reload();
          });
        });
      };
      this.drop = function(row) {
        popupService.confirm('是否删除\uFF1F').ok(function() {
          httpService.post('/defaultval/delDefaultval', {
            modelid: row.modelid
          }).then(function(result) {
            me.tableParams.reload();
          });
        });
      };
      this.off = function(row) {
        popupService.confirm('是否关闭设备\uFF1F').ok(function() {
          // httpService.post('/defaultval/delDefaultval', {
          //   modelid: row.modelid
          // }).then(function(result) {
          //   me.tableParams.reload();
          // });
        });
      };
    }
  ]);
});
define('modules/room/controllers/roomRange', ['modules/room/module'], function(module) {
  'use strict';
  module.controller('modules.room.controllers.roomRange', [
    '$scope',
    'app.services.httpService',
    function($scope, httpService) {
      var me = this;
      this.ignores = [];
      this.rooms = function(start, end) {
        if (start && end) {
          $scope.$data.Ip4e = $scope.$data.Ip4s + end - start;
          var arr = [];
          for (var i = start; i <= end; i++) {
            arr.push(i);
          }
          return arr;
        }
        return [];
      };
      this.ignore = function(num) {
        var idx = me.ignores.indexOf(num);
        if (idx < 0) {
          me.ignores.push(num);
        } else {
          me.ignores.splice(idx, 1);
        }
      };

      $scope.roomTypes = [];
      httpService.post('/roomtype/findRoomtypeHotels', {}).then(function(result) {
        $scope.roomTypes = result;
      });

      $scope.selectType = function(roomtypeid) {
        for (var i = 0; i < $scope.roomTypes.length; i++) {
          var item = $scope.roomTypes[i];
          if (item.rmtypeid == roomtypeid) {
            $scope.$data.rmtypename = item.rmtypename;
            break;
          }
        }
      };
    }
  ]);
});
define('modules/room/requires', [
  'modules/room/filters/floorFilter',
  'modules/room/filters/imagePath',
  'modules/room/filters/roomStatus',
  'modules/room/factories/enumerate',
  'modules/room/factories/stateAdapter',
  'modules/room/services/registerService',
  'modules/room/services/messageService',
  'modules/room/directives/ngPager',
  'modules/room/controllers/test',
  'modules/room/components/system/bar',
  'modules/room/components/system/home',
  'modules/room/components/system/state',
  'modules/room/components/system/comment',
  'modules/room/components/rcu/rcu',
  'modules/room/components/rcu/projectForm',
  'modules/room/components/rcu/parametersForm',
  'modules/room/components/rcu/timeSettingsForm',
  'modules/room/components/manage/registers',
  'modules/room/components/manage/build',
  'modules/room/components/manage/buildForm',
  'modules/room/components/manage/roomTypes',
  'modules/room/components/manage/roomTypeForm',
  'modules/room/controllers/roles',
  'modules/room/controllers/rooms',
  'modules/room/controllers/message',
  'modules/room/controllers/users',
  'modules/room/controllers/eventSystem',
  'modules/room/controllers/eventRoom',
  'modules/room/controllers/identitySettings',
  'modules/room/controllers/parameterSettings',
  'modules/room/controllers/roomForm',
  'modules/room/controllers/mode',
  'modules/room/controllers/roomRange'
], function() {
  'use strict';
});