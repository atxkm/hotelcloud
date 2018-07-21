define('modules/manageui/configs', ['app/application'], function (application) {
    'use strict';
    return angular.module('modules.manageui.configs', [
        'ui.bootstrap',
        'ui.router'
    ]);
});
define('modules/manageui/configs/factories', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.factory('modules.manageui.configs.factories.httpSession', [function () {
            return {
                request: function (configs) {
                    return configs;
                },
                requestError: function (err) {
                    return err;
                },
                response: function (response) {
                    return response;
                },
                responseError: function (err) {
                    return err;
                }
            };
        }]);
});
define('modules/manageui/configs/provide', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.config([
        '$provide',
        function ($provide) {
            $provide.constant('$appStates', {});
            $provide.constant('$tabStore', {});
        }
    ]);
});
define('modules/manageui/configs/state', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.config([
        '$stateProvider',
        '$appStates',
        function ($stateProvider, $appStates) {
            var stateFn = $stateProvider.state;
            $stateProvider.state = function (state, options) {
                stateFn(state, options);
                $appStates[state] = options;
            };
        }
    ]).run([
        '$rootScope',
        '$tabStore',
        function ($rootScope, $tabStore) {
            $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
                if (fromState.name === 'main' || fromState.name.indexOf('main.') === 0) {
                    $.each($tabStore, function (idx, item) {
                        item.dismiss();
                        delete $tabStore[idx];
                    });
                }
            });
        }
    ]);
});
define('modules/manageui/configs/routes', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.config([
        '$urlRouterProvider',
        '$stateProvider',
        function ($urlRouterProvider, $stateProvider) {
            $stateProvider.state('session', {
                url: '/session',
                templateUrl: 'views/manageui/Session.html',
                dependencies: ['modules/manageui/requires']
            });
            $stateProvider.state('login', {
                url: '/login',
                templateUrl: 'views/manageui/Login.html',
                dependencies: ['modules/manageui/requires'],
                data: { title: '登录' }
            });
            $stateProvider.state('lock', {
                url: '/lock',
                templateUrl: 'views/manageui/Lock.html',
                dependencies: ['modules/manageui/requires'],
                data: { title: '锁定' }
            });
            $stateProvider.state('register', {
                url: '/register',
                templateUrl: 'views/manageui/Register.html',
                dependencies: ['modules/manageui/requires'],
                data: { title: '注册' }
            });
            $stateProvider.state('forgot', {
                url: '/forgot',
                templateUrl: 'views/manageui/Forgot.html',
                dependencies: ['modules/manageui/requires'],
                data: { title: '密码找回' }
            });
            $stateProvider.state('main', {
                url: '/main',
                templateUrl: 'views/manageui/Main.html',
                dependencies: [
                    'jquery-ui',
                    'metisMenu',
                    'modules/manageui/requires'
                ],
                data: { title: '管理系统' }
            });
        }
    ]);
});
define('modules/manageui/configs/linkManager', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.provider('modules.manageui.configs.linkManager', [function () {
            var that = this;
            var defaultOrder = 65535;
            var _links = {};
            this.add = function (link) {
                return _links[link.id] = _links[link.id] ? $.extend(_links[link.id], link) : $.extend(link, createLink(link.order));
            };
            this.get = function (id) {
                return _links[id];
            };
            this.$get = function () {
                return {
                    get: that.get,
                    tree: function () {
                        return buildTree(_links);
                    },
                    links: _links
                };
            };
            function createLink(order) {
                var linkObject = {
                    _links: {},
                    _root: that,
                    order: order || order <= 0 ? order : defaultOrder
                };
                linkObject.add = function (sl) {
                    this._links[sl.id] = $.extend(sl, createLink(sl.order));
                    return this;
                };
                linkObject.get = function (id) {
                    return this._links[id];
                };
                linkObject.root = function () {
                    return that;
                };
                return linkObject;
            }
            function buildTree(links) {
                var result = [];
                for (var id in links) {
                    var tree = links[id];
                    tree.links = buildTree(tree._links);
                    result.push(tree);
                }
                result.sort(orderBy('order'));
                return result;
            }
            function orderBy(name) {
                if (!name)
                    return function () {
                        return -1;
                    };
                return function (o, p) {
                    var a, b;
                    if (typeof o === 'object' && typeof p === 'object' && o && p) {
                        a = o[name];
                        b = p[name];
                        if (a === b) {
                            return 0;
                        }
                        if (typeof a === typeof b) {
                            return a < b ? -1 : 1;
                        }
                        return typeof a < typeof b ? -1 : 1;
                    } else {
                        throw '菜单排序异常';
                    }
                };
            }
        }]);
});
define('modules/manageui/configs/tab', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.provider('$tab', [function () {
            var $tabProvider = {
                $get: [
                    '$injector',
                    '$rootScope',
                    '$q',
                    '$http',
                    '$templateCache',
                    '$controller',
                    '$tabStack',
                    function ($injector, $rootScope, $q, $http, $templateCache, $controller, $tabStack) {
                        var $tab = {};
                        function getTemplatePromise(options) {
                            if (!options.template && !options.templateUrl)
                                return '';
                            return options.template ? $q.when(options.template) : $http.get(angular.isFunction(options.templateUrl) ? options.templateUrl() : options.templateUrl, { cache: $templateCache }).then(function (result) {
                                return result.data;
                            });
                        }
                        function getResolvePromises(resolves) {
                            var promisesArr = [];
                            angular.forEach(resolves, function (value) {
                                if (angular.isFunction(value) || angular.isArray(value)) {
                                    promisesArr.push($q.when($injector.invoke(value)));
                                }
                            });
                            return promisesArr;
                        }
                        function resolveDependencies(dependencies) {
                            if (typeof dependencies === 'string') {
                                dependencies = [dependencies];
                            }
                            return [
                                '$q',
                                function ($q) {
                                    var defer = $q.defer();
                                    require(dependencies, function () {
                                        defer.resolve(arguments);
                                    });
                                    return defer.promise;
                                }
                            ];
                        }
                        $tab.open = function (tabOptions) {
                            var tabResultDeferred = $q.defer();
                            var tabOpenedDeferred = $q.defer();
                            var tabInstance = {
                                result: tabResultDeferred.promise,
                                opened: tabOpenedDeferred.promise,
                                close: function (result) {
                                    $tabStack.close(tabInstance, result);
                                },
                                dismiss: function (reason) {
                                    $tabStack.dismiss(tabInstance, reason);
                                },
                                active: function () {
                                    $tabStack.active(tabInstance);
                                }
                            };
                            tabOptions = angular.extend({}, $tabProvider.options, tabOptions);
                            tabOptions.resolve = tabOptions.resolve || {};
                            tabOptions.resolve.$deps = resolveDependencies(tabOptions.dependencies);
                            var templateAndResolvePromise = $q.all([getTemplatePromise(tabOptions)].concat(getResolvePromises(tabOptions.resolve)));
                            templateAndResolvePromise.then(function resolveSuccess(tplAndVars) {
                                var tabScope = (tabOptions.scope || $rootScope).$new();
                                tabScope.$close = tabInstance.close;
                                tabScope.$dismiss = tabInstance.dismiss;
                                var ctrlInstance, ctrlLocals = {};
                                var resolveIter = 1;
                                if (tabOptions.controller) {
                                    ctrlLocals.$scope = tabScope;
                                    ctrlLocals.$tabInstance = tabInstance;
                                    angular.forEach(tabOptions.resolve, function (value, key) {
                                        ctrlLocals[key] = tplAndVars[resolveIter++];
                                    });
                                    ctrlInstance = $controller(tabOptions.controller, ctrlLocals);
                                    if (tabOptions.controllerAs) {
                                        tabScope[tabOptions.controllerAs] = ctrlInstance;
                                    }
                                }
                                $tabStack.open(tabInstance, {
                                    scope: tabScope,
                                    deferred: tabResultDeferred,
                                    content: tplAndVars[0],
                                    tabTemplateUrl: tabOptions.tabTemplateUrl,
                                    tabkey: tabOptions.id ? tabOptions.id.split('.').join('_') : '',
                                    text: tabOptions.text,
                                    icon: tabOptions.icon,
                                    src: tabOptions.src
                                });
                            }, function resolveError(reason) {
                                tabResultDeferred.reject(reason);
                            });
                            templateAndResolvePromise.then(function () {
                                tabOpenedDeferred.resolve(true);
                            }, function () {
                                tabOpenedDeferred.reject(false);
                            });
                            return tabInstance;
                        };
                        return $tab;
                    }
                ]
            };
            return $tabProvider;
        }]);
});
define('modules/manageui/configs/httpConfig', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.config([
        '$provide',
        '$httpProvider',
        function ($provide, $httpProvider) {
            $provide.decorator('app.factories.httpDataHandler', [
                '$delegate',
                '$rootScope',
                '$modal',
                '$appEnvironment',
                function ($delegate, $rootScope, $modal, $appEnvironment) {
                    function errorModal(response, $rootScope, $modal) {
                        var scope = $rootScope.$new();
                        scope.$data = {};
                        if (response.data.Message) {
                            scope.$data.text = response.data.Message;
                        } else {
                            scope.$data.text = '发生错误\uFF01';
                        }
                        $modal.open({
                            templateUrl: 'templates/modal/Error.html',
                            scope: scope
                        });
                    }
                    $delegate.doResponse = function (response, defer) {
                        response.data = response.data ? response.data : {};
                        $appEnvironment.session = response.data.Session ? response.data.Session : {
                            Status: 'NoLogin',
                            Version: null
                        };
                        if (response.data.Success === false) {
                            $delegate.doError(response, defer);
                        } else {
                            defer.resolve(response.data.Data ? response.data.Data : response.data);
                        }
                    };
                    $delegate.doError = function (response, defer) {
                        response.data = response.data ? response.data : {};
                        $appEnvironment.session = response.data.Session ? response.data.Session : {
                            Status: 'NoLogin',
                            Version: null
                        };
                        errorModal(response, $rootScope, $modal);
                        defer.reject(response.data.Message ? response.data.Message : response.data);
                    };
                    return $delegate;
                }
            ]);
            $httpProvider.interceptors.push('modules.manageui.configs.factories.httpSession');
        }
    ]);
});
define('modules/manageui/configs/popupConfig', ['modules/manageui/configs'], function (configs) {
    'use strict';
    configs.config([
        '$provide',
        function ($provide) {
            $provide.decorator('app.services.popupService', [
                '$delegate',
                '$q',
                '$modal',
                function ($delegate, $q, $modal) {
                    $delegate.confirm = function (text, size) {
                        var defered = $q.defer();
                        defered.promise.ok = function (fn) {
                            defered.promise.then(fn);
                            return defered.promise;
                        };
                        defered.promise.cancel = function (fn) {
                            defered.promise['catch'](fn);
                            return defered.promise;
                        };
                        $modal.open({
                            templateUrl: 'templates/modal/Confirm.html',
                            size: size ? size : 'sm',
                            data: { text: text ? text : '是否确认操作\uFF1F' }
                        }).result.then(function () {
                            defered.resolve();
                        }, function () {
                            defered.reject();
                        });
                        return defered.promise;
                    };
                    return $delegate;
                }
            ]);
        }
    ]);
});
define('modules/manageui/module', [
    'app/application',
    'modules/manageui/configs/factories',
    'modules/manageui/configs/provide',
    'modules/manageui/configs/state',
    'modules/manageui/configs/routes',
    'modules/manageui/configs/linkManager',
    'modules/manageui/configs/tab',
    'modules/manageui/configs/httpConfig',
    'modules/manageui/configs/popupConfig'
], function (application) {
    'use strict';
    application.requires.push('modules.manageui');
    return angular.module('modules.manageui', [
        'ui.router',
        'modules.manageui.configs'
    ]).config([
        '$sceDelegateProvider',
        function ($sceDelegateProvider) {
            $sceDelegateProvider.resourceUrlWhitelist([
                'self',
                'http://www.baidu.com/**'
            ]);
        }
    ]).run([
        '$appEnvironment',
        function ($appEnvironment) {
            $appEnvironment.user = {
                Username: '未知用户',
                Rolename: '未知类别'
            };
        }
    ]);
});
define('modules/room/configs', ['app/application'], function (application) {
    'use strict';
    return angular.module('modules.room.configs', []);
});
define('modules/room/configs/menus', ['modules/room/configs'], function (configs) {
    'use strict';
    configs.config([
        'modules.manageui.configs.linkManagerProvider',
        function (linkManagerProvider) {
            linkManagerProvider.add({
                id: 'roomstate',
                text: '房态显示',
                icon: 'fa fa-camera fa-fw',
                templateUrl: 'views/room/State.html',
                dependencies: ['modules/room/requires']
            });
            linkManagerProvider.add({
                id: 'roommanage',
                text: '信息管理',
                icon: 'fa fa-comments fa-fw'
            }).add({
                id: 'roommanage_infomanage',
                text: '消息管理',
                templateUrl: 'views/room/manage/Message.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'roommanage_search',
                text: '事件查询',
                templateUrl: 'views/room/manage/EventLog.html',
                dependencies: ['modules/room/requires']
            });
            linkManagerProvider.add({
                id: 'roomsettings',
                text: '房间管理',
                icon: 'fa fa-building fa-fw'
            }).add({
                id: 'roomsettings_build',
                text: '楼栋',
                templateUrl: 'views/room/manage/Build.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'roomsettings_category',
                text: '房间类型',
                templateUrl: 'views/room/manage/RoomTypes.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'roomsettings_no',
                text: '房间设置',
                templateUrl: 'views/room/manage/Room.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'roomsettings_rcusettings',
                text: 'RCU设置',
                templateUrl: 'views/room/rcu/RCU.html',
                dependencies: ['modules/room/requires']
            });
            linkManagerProvider.add({
                id: 'systemSettings',
                text: '系统设置',
                icon: 'fa fa-cog fa-fw'
            }).add({
                id: 'systemSettings_role',
                text: '人员类别管理',
                templateUrl: 'views/room/personal/Roles.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'systemSettings_user',
                text: '人员管理',
                templateUrl: 'views/room/personal/Users.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'systemSettings_identity',
                text: '身份识别设置',
                templateUrl: 'views/room/settings/Identity.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'systemSettings_params',
                text: '客房参数',
                templateUrl: 'views/room/settings/Parameters.html',
                dependencies: ['modules/room/requires']
            }).add({
                id: 'systemSettings_mode',
                text: '设备模式',
                templateUrl: 'views/room/settings/Mode.html',
                dependencies: ['modules/room/requires']
            });
            linkManagerProvider.add({
                id: 'help',
                text: '系统帮助',
                icon: 'fa fa-question-circle fa-fw'
            }).add({
                id: 'help_register',
                text: '注册信息',
                templateUrl: 'views/help/Register.html'
            }).add({
                id: 'help_tl',
                text: '图例说明',
                templateUrl: 'views/help/Legend.html'
            }).add({
                id: 'help_help',
                text: '使用帮助',
                templateUrl: 'views/help/Document.html'
            });
        }
    ]);
});
define('modules/room/configs/provide', ['modules/room/configs'], function (configs) {
    'use strict';
    configs.config([
        '$provide',
        function ($provide) {
            $provide.constant('$globalStore', {
                builds: [],
                roomTypes: []
            });
        }
    ]).config([
        '$provide',
        function ($provide) {
            $provide.decorator('$rootScope', [
                '$delegate',
                '$globalStore',
                function ($delegate, $globalStore) {
                    $delegate.$globalStore = $globalStore;
                    return $delegate;
                }
            ]);
        }
    ]);
});
define('modules/room/module', [
    'app/application',
    'modules/room/configs/menus',
    'modules/room/configs/provide',
    'ui-switch',
    'ng-table'
], function (application) {
    'use strict';
    application.requires.push('modules.room');
    return angular.module('modules.room', [
        'ui.router',
        'uiSwitch',
        'ngTable',
        'modules.manageui',
        'modules.room.configs'
    ]).config([
        '$urlRouterProvider',
        '$stateProvider',
        function ($urlRouterProvider, $stateProvider) {
            $urlRouterProvider.otherwise('/login');
            $stateProvider.state('main.roomhome', {
                url: '/roomhome',
                dependencies: [
                    'modules/room/requires',
                    'modules/setting/requires'
                ],
                views: {
                    'home': { templateUrl: 'views/room/Home.html' },
                    'bar': { templateUrl: 'views/room/Bar.html' }
                }
            });
        }
    ]).run([
        '$globalStore',
        function ($appEnvironment) {
            $appEnvironment.user = {
                Username: '未知用户',
                Rolename: '未知类别'
            };
        }
    ]);
});
define('modules/setting/module', ['app/application'], function (application) {
    'use strict';
    application.requires.push('modules.setting');
    return angular.module('modules.setting', []);
});
define('web', [
    'modules/manageui/module',
    'modules/room/module',
    'modules/setting/module'
], function () {
    'use strict';
});