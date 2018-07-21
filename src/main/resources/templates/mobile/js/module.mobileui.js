define('modules.mobileui.requires', [
    'modules.mobileui.directives.mobileTitle',
    'modules.mobileui.controllers.login',
    'modules.mobileui.controllers.mobilemain',
    'modules.mobileui.controllers.service',
    'modules.mobileui.controllers.tv',
    'modules.mobileui.controllers.index',
    'modules.mobileui.controllers.hotel',
    'modules.mobileui.controllers.air',
    'modules.mobileui.controllers.curtains',
    'modules.mobileui.controllers.light',
    'modules.mobileui.services.sessionService',
    'modules.mobileui.services.rcu',
], function() {
    'use strict';
});
define('modules.mobileui.controllers.login', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.login', [
        '$scope',
        '$state',
        'modules.mobileui.services.sessionService',
        'app.services.popupService',
        function($scope, $state, sessionService, popupService) {
            var me = this;
            me.Username = '18612984078';
            me.Password = 'hotel123456';
            me.login = function() {
                sessionService.login(me.Username, me.Password).success(function() {
                    $state.go('index');
                }).error(function(error) {
                    popupService.error(error);
                });
            };
        }
    ]);
});
define('modules.mobileui.controllers.index', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.index', [
        '$scope',
        '$state',
        '$appConfig',
        '$appEnvironment',
        'modules.mobileui.services.sessionService',
        'modules.manageui.configs.linkManager',
        'app.services.httpService',
        'app.services.popupService',
        function($scope, $state, $appConfig, $appEnvironment, sessionService, linkManager, httpService, popupService) {
            var me = this;
            $scope.Title = '客房控制';

            if ($appConfig.session)
                this.links = linkManager.tree();
            else {
                if ($appEnvironment.session && $appEnvironment.session.status === 'Logined') {
                    me.links = linkManager.tree();
                } else {
                    sessionService.checkSession().authenticated(function() {
                        me.links = linkManager.tree();
                    }).unAuthenticated(function() {
                        $state.go('mobilelogin');
                    });
                }
            }

            var user = localStorage.user;
            if (user) {
                user = JSON.parse(user);
                httpService.post('/roomequ/findHotelEqu', {
                    // roomid: user.roomid
                    roomid: 1
                }).then(data => {
                    console.log(data);
                });
            }

            me.openTheDoor = function() {
                httpService.post('/rcu/sendRcuCommand', {
                    "hostname": "192.168.1.129", //地址
                    "order": 0, //RCU指令
                    "address": 58, //RCU地址枚举
                    "dataString": 1 //数据
                }).then(data => {
                    if (data.success) {
                        popupService.information('开锁成功');
                    } else {

                    }
                });
            };

            me.exit = function() {
                sessionService.logout().then(function(data) {
                    $state.go('mobilelogin');
                });
            };
        }
    ]);
});
define('modules.mobileui.controllers.hotel', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.hotel', [
        '$scope',
        '$state',
        '$appConfig',
        '$appEnvironment',
        'modules.mobileui.services.sessionService',
        'modules.manageui.configs.linkManager',
        'app.services.httpService',
        function($scope, $state, $appConfig, $appEnvironment, sessionService, linkManager, httpService) {
            var me = this;
            $scope.Title = '房间内部';
        }
    ]);
});
define('modules.mobileui.controllers.air', [
    'modules.mobileui.module',
    'mobiscroll'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.air', [
        '$scope',
        '$element',
        'modules.mobileui.services.rcu',
        function($scope, $element, rcu) {
            var me = this;

            me.ctrlAir = function(address, data, callback) {
                rcu.send(0, address, data).then(function(data) {
                    if (data.success && callback) {
                        callback(data);
                    }
                });
            };

            var opt = {
                select: {
                    preset: 'select'
                }
            };

            var myopt = $.extend(opt.select, {
                theme: 'android-ics light',
                mode: 'scroller',
                display: 'inline',
                rows: 5,
                formatResult: function(result) {
                    let wendu = result[0].replace('_', '');
                    me.ctrlAir(80, wendu);
                }
            });
            $element.find('.air-number-bg select').val('').scroller('destroy').scroller(myopt);

            // 打开关闭空调
            me.switchAir = function() {
                var status = me.airStatus ? 0 : 1;
                me.ctrlAir(81, status, function(data) {
                    me.airStatus = !me.airStatus;
                });
            };

            // 上下扫风
            me.u2d = function() {
                var status = me.u2dStatus ? 0 : 1;
                me.ctrlAir(81, status, function(data) {
                    me.u2dStatus = !me.u2dStatus;
                });
            };

            // 左右扫风
            me.l2r = function() {
                var status = me.l2rStatus ? 0 : 1;
                me.ctrlAir(81, status, function(data) {
                    me.l2rStatus = !me.l2rStatus;
                });
            };
        }
    ]);
});
define('modules.mobileui.controllers.light', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.light', [
        '$scope',
        'modules.mobileui.services.rcu',
        'app.services.popupService',
        function($scope, rcu, popupService) {
            var me = this;

            me.tCtrl = false; //总控
            me.changeT = function() {
                me.tCtrl = !me.tCtrl;
            };

            $scope.opts = {
                hidePointerLabels: true,
                hideLimitLabels: true,
                floor: 0,
                ceil: 100
            };

            $scope.lights = [{
                value: 100
            }, {
                value: 100
            }, {
                value: 100
            }];

            $scope.$on('slideEnded', function() {
                for (var i = 0; i < $scope.lights.length; i++) {
                    rcu.send(0, 130 + i, $scope.lights[i].value).then(function(data) {
                        
                    });
                }
            });
        }
    ]);
});
define('modules.mobileui.controllers.curtains', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.curtains', [
        '$scope',
        'modules.mobileui.services.rcu',
        'app.services.popupService',
        function($scope, rcu, popupService) {
            var me = this;

            $scope.open = function(idx) {
                me.send(idx, 1);
            };

            $scope.close = function(idx) {
                me.send(idx, 2);
            };

            $scope.stop = function(idx) {
                me.send(idx, 0);
            };

            me.send = function(idx, data) {
                rcu.send(0, idx, data).then(function(data) {
                    if (data.success) {
                        popupService.information('指令发送成功');
                    }
                });
            };
        }
    ]);
});
define('modules.mobileui.controllers.mobilemain', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.mobilemain', [
        '$scope',
        '$state',
        '$appConfig',
        '$appEnvironment',
        'modules.mobileui.services.sessionService',
        'modules.manageui.configs.linkManager',
        function($scope, $state, $appConfig, $appEnvironment, sessionService, linkManager) {
            var me = this;

            if ($appConfig.session)
                this.links = linkManager.tree();
            else {
                if ($appEnvironment.session && $appEnvironment.session.Status === 'Logined') {
                    me.links = linkManager.tree();
                } else {
                    sessionService.checkSession().authenticated(function() {
                        me.links = linkManager.tree();
                    }).unAuthenticated(function() {
                        $state.go('mobilelogin');
                    });
                }
            }

        }
    ]);
});
define('modules.mobileui.controllers.service', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.service', [
        '$scope',
        'modules.mobileui.services.rcu',
        'app.services.popupService',
        function($scope, rcu, popupService) {
            var me = this;

            me.send = function(str) {
                var address;
                switch (str) {
                    case 'shaohou':
                        address = 67;
                        break;
                    case 'qingli':
                        address = 69;
                        break;
                    case 'wurao':
                        address = 65;
                        break;
                    case 'xiyi':
                        address = 74;
                        break;
                    case 'jiaoche':
                        address = 76;
                        break;
                    case 'diancan':
                        address = 75;
                        break;
                }
                rcu.send(0, address, 1).then(function(data) {
                    if (data.success) {
                        popupService.information('通知成功');
                    }
                });
            }
        }
    ]);
});
define('modules.mobileui.controllers.tv', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.controller('modules.mobileui.controllers.tv', [
        '$scope',
        function($scope) {
            var me = this;

            $scope.numbers = [
                '1',
                '2',
                '3',
                '4',
                '5',
                '6',
                '7',
                '8',
                '9',
                '*',
                '0',
                '#'
            ];

            this.test = function() {
                alert('aaaa');
            };
        }
    ]);
});
define('modules.mobileui.directives.mobileTitle', [
    'modules.mobileui.module'
], function(module) {
    'use strict';

    module.directive('mobileTitle', [
        '$rootScope',
        '$state',
        '$timeout',
        function($rootScope, $state, $timeout) {
            var _link = function(scope, element, attrs) {
                $rootScope.$on('$stateChangeSuccess', function(event, toState) {
                    $timeout(function() {
                        element.html((toState.data && toState.data.title) ? toState.data.title : '');
                    });
                });
                element.html(($state.$current.data && $state.$current.data.title) ? $state.$current.data.title : '');
            };

            return {
                restrict: 'A',
                link: _link
            };
        }
    ]);
});
define('modules.mobileui.services.sessionService', ['modules.mobileui.module'], function(module) {
    'use strict';
    module.service('modules.mobileui.services.sessionService', [
        '$q',
        '$modal',
        '$appEnvironment',
        'app.services.httpService',
        function($q, $modal, $appEnvironment, httpService) {
            var me = this;
            me.login = function(username, password) {
                var defered = $q.defer();
                defered.promise.success = function(fn) {
                    defered.promise.then(function() {
                        fn();
                    });
                    return defered.promise;
                };
                defered.promise.error = function(fn) {
                    defered.promise.then(null, function(error) {
                        fn(error);
                    });
                    return defered.promise;
                };
                httpService.post('/personmobile/login', {
                    loginName: username,
                    pwd: password
                }).then(function(result) {
                    if ($appEnvironment.session.status === 'Logined') {
                        $appEnvironment.user = result;
                        localStorage.user = JSON.stringify(result);
                        localStorage.mobile = username;
                        // defered.resolve();
                        me.checkSession().authenticated(function(session) {
                            defered.resolve();
                        }).unAuthenticated(function() {
                            defered.reject();
                        });
                    }
                }, function(result) {
                    // defered.reject(result);
                    defered.resolve();
                });
                return defered.promise;
            };
            me.logout = function() {
                var defered = $q.defer();
                defered.promise.success = function(fn) {
                    defered.promise.then(function() {
                        fn();
                    });
                    return defered.promise;
                };
                var processModal = $modal.open({
                    template: '<div><div class="modal-body"><p>退出中...</p></div></div>',
                    size: 'sm',
                    backdrop: 'static'
                });
                var mobile = localStorage.mobile;
                if (mobile) {
                    // httpService.post('/enter/delEnterup', {
                    //     guestmobile: mobile
                    // }).then(function (result) {
                    //     $appEnvironment.session = null;
                    //     localStorage.removeItem('user');
                    //     localStorage.removeItem('mobile');
                    //     defered.resolve();
                    //     processModal.close();
                    // }, function () {
                    //     defered.reject();
                    //     processModal.close();
                    // });
                    $appEnvironment.session = null;
                    localStorage.removeItem('user');
                    localStorage.removeItem('mobile');
                    defered.resolve();

                } else {
                    localStorage.removeItem('user');
                    localStorage.removeItem('mobile');
                    processModal.close();
                    defered.resolve();
                }
                return defered.promise;
            };
            me.checkSession = function() {
                var defered = $q.defer();
                defered.promise.authenticated = function(fn) {
                    defered.promise.then(function(result) {
                        fn(result);
                    });
                    return defered.promise;
                };
                defered.promise.unAuthenticated = function(fn) {
                    defered.promise.then(null, function() {
                        fn();
                    });
                    return defered.promise;
                };
                defered.promise.error = function(fn) {
                    defered.promise.then(null, function(error) {
                        fn(error);
                    });
                    return defered.promise;
                };
                var processModal = $modal.open({
                    template: '<div><div class="modal-body"><p>会话检测...</p></div></div>',
                    size: 'sm',
                    backdrop: 'static'
                });
                httpService.post('/person/checkloggedwithoutname', {}).then(function(result) {
                    if ($appEnvironment.session.status === 'Logined') {
                        defered.resolve(result.data);
                    } else {
                        defered.reject();
                    }
                    processModal.close();
                }, function(result) {
                    defered.resolve(null);
                    defered.reject(result);
                    processModal.close();
                });
                return defered.promise;
            };
        }
    ]);
});
define('modules.mobileui.services.rcu', ['modules.mobileui.module'], function(module) {
    'use strict';
    module.service('modules.mobileui.services.rcu', [
        '$q',
        'app.services.httpService',
        'app.services.popupService',
        function($q, http, popup) {
            var me = this;

            me.send = function(order, address, data) {
                var defered = $q.defer();
                http.post('/rcu/sendRcuCommand', {
                    "hostname": "192.168.1.129", //地址
                    "order": order, //RCU指令
                    "address": address, //RCU地址枚举
                    "dataString": data //数据
                }).then(data => {
                    defered.resolve(data);
                }, error => {
                    popup.error('操作失败，请重试！');
                    defered.reject(error);
                });
                return defered.promise;
            };

        }
    ]);
});