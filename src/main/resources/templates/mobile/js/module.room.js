define('modules.room.requires', [
    'modules.room.services.messageService',
    'modules.room.controllers.test',
    'modules.room.controllers.bar',
    'modules.room.controllers.build',
    'modules.room.controllers.buildForm',
    'modules.room.controllers.roles',
    'modules.room.controllers.rooms',
    'modules.room.controllers.message',
    'modules.room.controllers.users',
    'modules.room.controllers.home',
    'modules.room.controllers.state',
    'modules.room.controllers.roomType',
    'modules.room.controllers.roomTypeForm',
    'modules.room.controllers.eventSystem',
    'modules.room.controllers.eventRoom',
    'modules.room.controllers.identitySettings',
    'modules.room.controllers.parameterSettings',
    'modules.room.controllers.roomForm',
    'modules.room.controllers.mode',
    'modules.room.controllers.roomRange',
    'modules.room.factories.enumerate',
    'modules.room.filters.imagePath',
    'modules.room.filters.roomStatus'
], function() {
    'use strict';

});
define('modules.room.controllers.bar', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.bar', [
        '$scope',
        '$modal',
        'modules.manageui.configs.linkManager',
        'modules.manageui.services.tabService',
        'modules.room.services.messageService',
        function($scope, $modal, linkManager, tabService, messageService) {
            $scope.service = messageService;

            this.openMessage = function(type) {
                tabService.open(linkManager.get('roommanage').get('roommanage_infomanage'));
                messageService.activeSingle(type);
            };

            this.checkIn = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/CheckIn.html',
                        size: 'sm'
                    });
            };
        }
    ]);
});
define('modules.room.controllers.build', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.build', [
        '$scope',
        '$modal',
        'NgTableParams',
        'modules.setting.services.request',
        'app.services.popupService',
        'app.services.httpService',
        function($scope, $modal, NgTableParams, request, popupService, httpService) {
            var me = this;

            this.tableParams = new NgTableParams();

            this.add = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/manage/BuildForm.html',
                        data: {}
                    }).result
                    .then(function(data) {

                    });
            };

            this.edit = function(id) {
                httpService
                    .get(request.楼栋明细 + '?id=' + id)
                    .then(function(result) {
                        $modal
                            .open({
                                templateUrl: 'views/room/manage/BuildForm.html',
                                data: result
                            }).result
                            .then(function(data) {

                            });
                    });
            };

            this.drop = function(id) {
                popupService
                    .confirm('是否删除？')
                    .ok(function() {

                    });
            };

            httpService
                .get(request.楼栋列表)
                .then(function(result) {
                    $scope.$globalStore.builds = result.Data;
                });
        }
    ]);
});
define('modules.room.controllers.buildForm', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.buildForm', [
        '$scope',
        'NgTableParams',
        'modules.setting.services.request',
        'app.services.httpService',
        function($scope, NgTableParams, request, httpService) {
            var me = this;

            this.floors = function(n) {
                var arr = [];
                for (var i = 1; i <= n; i++) {
                    arr.push(i);
                }
                return arr;
            };
        }
    ]);
});
define('modules.room.controllers.eventRoom', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.eventRoom', [
        '$scope',
        'modules.manageui.factories.tableParameter',
        'modules.setting.services.request',
        function($scope, tableParameter, request) {
            var me = this;

            this.list = [];

            this.tableParams = new tableParameter({});
        }
    ]);
});
define('modules.room.controllers.eventSystem', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.eventSystem', [
        '$scope',
        'modules.manageui.factories.tableParameter',
        'modules.setting.services.request',
        function($scope, tableParameter, request) {
            var me = this;

            this.list = [];

            this.tableParams = new tableParameter({});
        }
    ]);
});
define('modules.room.controllers.home', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.home', [
        '$scope',
        '$state',
        '$appEnvironment',
        '$element',
        'modules.manageui.configs.linkManager',
        'modules.manageui.services.tabService',
        'modules.room.services.messageService',
        function($scope, $state, $appEnvironment, $element, linkManager, tabService, messageService) {
            var me = this;

            $element.find('.widget-column')
                .sortable({
                    connectWith: '.widget-column',
                    handle: '.panel-heading',
                    cancel: ".widget-toggle",
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
define('modules.room.controllers.identitySettings', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.identitySettings', [
        '$scope',
        'NgTableParams',
        'modules.setting.services.request',
        'app.services.httpService',
        function($scope, NgTableParams, request, httpService) {
            var me = this;

            this.list = [];
            this.tableParams = new NgTableParams();
            this.load = function() {
                httpService
                    .get(request.身份表示列表)
                    .then(function(result) {
                        me.list = result.Data;
                    });
            };
            this.selectImage = function(row) {

            };
        }
    ]);
});
define('modules.room.controllers.message', [
    'modules.room.module',
    'jquery-ui'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.message', [
        '$scope',
        'modules.manageui.factories.tableParameter',
        'modules.setting.services.request',
        'modules.room.services.messageService',
        function($scope, tableParameter, request, messageService) {
            $scope.service = messageService;

            this.tableParams = new tableParameter({});

            // $element.find('.messagestore')
            //     .sortable({
            //         connectWith: ".markstore"
            //     });

            // $element.find('.markstore')
            //     .sortable({
            //         connectWith: ".messagestore"
            //     });
        }
    ]);
});
define('modules.room.controllers.mode', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.mode', [
        '$scope',
        '$modal',
        'NgTableParams',
        function($scope, $modal, NgTableParams) {
            this.list = [];
            this.tableParams = new NgTableParams();
            this.add = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/settings/ModeForm.html',
                        size: 'sm'
                    }).result
                    .then(function() {

                    });
            };
        }
    ]);
});
define('modules.room.controllers.parameterSettings', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.parameterSettings', [
        '$scope',
        'modules.setting.services.request',
        'app.services.httpService',
        function($scope, request, httpService) {

        }
    ]);
});
define('modules.room.controllers.roles', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.roles', [
        '$scope',
        '$modal',
        'NgTableParams',
        'modules.setting.services.request',
        'app.services.httpService',
        'app.services.popupService',
        function($scope, $modal, NgTableParams, request, httpService, popupService) {
            var me = this;

            this.tableParams = new NgTableParams();

            this.list = [];

            this.add = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/personal/RoleForm.html'
                    }).result
                    .then(function(result) {

                    });
            };

            this.edit = function(id) {
                $modal
                    .open({
                        templateUrl: 'views/room/personal/RoleForm.html'
                    }).result
                    .then(function(result) {

                    });
            };

            this.authorize = function(id) {
                $modal
                    .open({
                        templateUrl: 'views/room/personal/Authorize.html'
                    });
            };

            this.delete = function(id) {
                popupService
                    .confirm('是否删除？')
                    .ok(function() {

                    });
            };

            httpService
                .get(request.人员类别列表)
                .then(function(result) {
                    me.list = result.Data;
                });
        }
    ]);
});
define('modules.room.controllers.roomForm', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.roomForm', [
        '$scope',
        'app.services.httpService',
        'modules.setting.services.request',
        'modules.room.factories.enumerate',
        function($scope, httpService, request, enumerate) {
            $scope.roomTypes = [];
            httpService
                .get(request.房间类型列表)
                .then(function(result) {
                    $scope.roomTypes = result.Data;
                });
        }
    ]);
});
define('modules.room.controllers.roomRange', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.roomRange', [
        '$scope',
        '$timeout',
        function($scope, $timeout) {
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
        }
    ]);
});
define('modules.room.controllers.roomType', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.roomType', [
        '$scope',
        '$modal',
        'NgTableParams',
        'modules.setting.services.request',
        'app.services.httpService',
        'app.services.popupService',
        function($scope, $modal, NgTableParams, request, httpService, popupService) {
            var me = this;

            this.list = [];

            this.current = {};

            this.tableParams = new NgTableParams();

            this.select = function(row) {
                me.current = $.extend({}, row);
            };

            this.add = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/manage/RoomTypeForm.html',
                        data: {
                            Lines: []
                        }
                    }).result
                    .then(function() {

                    });
            };

            this.edit = function(id) {
                httpService
                    .get(request.房间类型)
                    .then(function(result) {
                        $modal
                            .open({
                                templateUrl: 'views/room/manage/RoomTypeForm.html',
                                data: result
                            }).result
                            .then(function(data) {

                            });
                    });
            };

            this.drop = function(id) {
                popupService
                    .confirm('是否删除？')
                    .ok(function() {
                        me.current = {};
                    });
            };

            httpService
                .get(request.房间类型列表)
                .then(function(result) {
                    me.list = result.Data;
                });
        }
    ]);
});
define('modules.room.controllers.roomTypeForm', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.roomTypeForm', [
        '$scope',
        'NgTableParams',
        'modules.room.factories.enumerate',
        function($scope, NgTableParams, enumerate) {
            var me = this;

            $scope.groups = enumerate.LineGroups;
            $scope.table = new NgTableParams({}, {
                groupBy: 'GroupId',
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
                me.newLine.Group = me.groups[me.newLine.GroupId];
                $scope.data.Lines.push($.extend({}, me.newLine));
                me.newLine = {};
                $scope.table.reload();
            };

            this.applyEditing = function(idx) {
                $scope.data.Lines[idx] = $.extend({}, me.current);
                $scope.table.reload();
                me.cancelEditing();
            };

            this.beginEditing = function(idx) {
                me.editing = idx;
                me.current = $.extend({}, $scope.data.Lines[idx]);
            };

            this.cancelEditing = function() {
                me.editing = -1;
                me.current = {};
            };

            this.removeLine = function(idx) {
                $scope.data.Lines.splice(idx, 1);
                $scope.table.reload();
            };

            this.groups = {};

            $.each($scope.groups, function(idx, item) {
                me.groups[item.Key] = item.Name;
            });
        }
    ]);
});
define('modules.room.controllers.rooms', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.rooms', [
        '$scope',
        '$modal',
        'modules.manageui.factories.tableParameter',
        'modules.setting.services.request',
        'app.services.httpService',
        'app.services.popupService',
        function($scope, $modal, tableParameter, request, httpService, popupService) {
            $scope.current = {};

            this.tableParams = new tableParameter({});

            this.select = function(build, floor) {
                $scope.current.BuildId = build.Id;
                $scope.current.BuildName = build.BuildName;
                $scope.current.Floor = floor;
            };

            this.add = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/manage/RoomForm.html',
                        data: {}
                    }).result
                    .then(function(data) {

                    });
            };

            this.addRange = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/manage/RoomRange.html',
                        data: {
                            NumberStart: 1,
                            NumberEnd: 50
                        }
                    }).result
                    .then(function(data) {

                    });
            };

            this.reset = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/rcu/Reset.html'
                    });
            };
        }
    ]);
});
define('modules.room.controllers.state', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.state', [
        '$scope',
        '$modal',
        'modules.setting.services.request',
        'app.services.httpService',
        function($scope, $modal, request, httpService) {
            var me = this;

            this.builds = [];

            this.rooms = [];

            this.openControl = function(id) {
                $modal
                    .open({
                        templateUrl: 'views/room/RoomControl.html',
                        size: 'lg'
                    });
            };

            this.load = function() {
                httpService
                    .get(request.楼栋列表)
                    .then(function(result) {
                        me.builds = result.Data;
                    });
            };

            this.showComment = function(roomId) {
                $modal
                    .open({
                        templateUrl: 'views/room/Comment.html'
                    });
            };

            $scope.current = null;

            httpService
                .get(request.房间状态列表)
                .then(function(result) {
                    me.rooms = result;
                });
        }
    ]);
});
define('modules.room.controllers.test', [
    'modules.room.module'
], function(module) {
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
define('modules.room.controllers.users', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.controller('modules.room.controllers.users', [
        '$scope',
        '$modal',
        'NgTableParams',
        'modules.setting.services.request',
        'app.services.popupService',
        'app.services.httpService',
        function($scope, $modal, NgTableParams, request, popupService, httpService) {
            var me = this;

            this.tableParams = new NgTableParams();

            this.list = [];

            this.add = function() {
                $modal
                    .open({
                        templateUrl: 'views/room/personal/UserForm.html'
                    }).result
                    .then(function(result) {

                    });
            };

            this.edit = function(id) {
                $modal
                    .open({
                        templateUrl: 'views/room/personal/UserForm.html'
                    }).result
                    .then(function(result) {

                    })
            };

            this.delete = function(id) {
                popupService
                    .confirm('是否删除？')
                    .ok(function() {

                    });
            };

            httpService
                .get(request.用户列表)
                .then(function(result) {
                    me.list = result.Data;
                });
        }
    ]);
});
define('modules.room.factories.enumerate', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.factory('modules.room.factories.enumerate', [
        function() {
            return {
                // LineGroups: {
                //     '1': '灯光',
                //     '2': '调光',
                //     '3': '窗帘',
                //     '4': '新风',
                //     '5': '保险柜'
                // }
                LineGroups: [{
                    Key: '1',
                    Name: '灯光'
                }, {
                    Key: '2',
                    Name: '调光'
                }, {
                    Key: '3',
                    Name: '窗帘'
                }, {
                    Key: '4',
                    Name: '新风'
                }, {
                    Key: '5',
                    Name: '保险柜'
                }]
            };
        }
    ]);
});
define('modules.room.filters.imagePath', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.filter('imagePath', [
        function() {
            return function(input) {
                return 'images/' + input;
            };
        }
    ]);
});
define('modules.room.filters.roomStatus', [
    'modules.room.module'
], function(module) {
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
define('modules.room.services.messageService', [
    'modules.room.module'
], function(module) {
    'use strict';

    module.service('modules.room.services.messageService', [
        function() {
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
        }
    ]);
});