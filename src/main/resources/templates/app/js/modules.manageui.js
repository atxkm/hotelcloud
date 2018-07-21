define('modules/manageui/filters/integer', ['modules/manageui/module'], function(module) {
  'use strict';
  module.filter('integer', [function() {
    return function(val) {
      return parseInt(val);
    };
  }]);
});
define('modules/manageui/filters/linkAuthorize', ['modules/manageui/module'], function(module) {
  'use strict';
  module.filter('linkAuthorize', [
    '$appEnvironment',
    function($appEnvironment) {
      return function(input) {
        var result = [];
        $.each(input, function(index, item) {
          if (item.authorize && $appEnvironment.session) {
            var isPermission = false;
            $.each($appEnvironment.session.Permissions, function(i, data) {
              if (data === item.authorize) {
                isPermission = true;
                return false;
              }
            });
            if (isPermission) {
              result.push(item);
            }
          } else if ($appEnvironment.session) {
            result.push(item);
          } else {
            result.push(item);
          }
        });
        return result;
      };
    }
  ]);
});
define('modules/manageui/directives/datetimepicker', [
  'modules/manageui/module',
  'smalot-bootstrap-datetimepicker-zhcn'
], function(module) {
  'use strict';
  module.directive('datetimepicker', [
    '$timeout',
    function($timeout) {
      var _link = function($scope, $element, $attrs, $ctrl) {
        $($element).datetimepicker({
          language: 'zh-CN',
          format: 'yyyy-mm-dd hh:ii',
          autoclose: true,
          todayBtn: true,
          startDate: '2013-02-14 10:00',
          minuteStep: 10
        });
      };
      return {
        scope: {
          ngModel: '='
        },
        restrict: 'AE',
        replace: true,
        link: _link,
        templateUrl: 'templates/controls/datetimepicker.html'
      };
    }
  ]);
});
define('modules/manageui/directives/ngRepeated', ['modules/manageui/module'], function(module) {
  'use strict';
  module.directive('ngRepeated', [
    '$timeout',
    function($timeout) {
      var _link = function(scope, element, attr) {
        if (scope.$last === true) {
          $timeout(function() {
            scope.$emit('ngRepeated');
          });
        }
      };
      return {
        restrict: 'A',
        link: _link
      };
    }
  ]);
});
define('modules/manageui/directives/links', ['modules/manageui/module'], function(module) {
  'use strict';
  module.directive('sysLinks', [function() {
    var _link = function($scope, $element, $attrs, $ctrl) {};
    var _controller = function($scope, $element, $attrs) {};
    return {
      scope: {
        sysLinks: '='
      },
      restrict: 'AE',
      replace: true,
      link: _link,
      controller: [
        '$scope',
        '$element',
        '$attrs',
        _controller
      ],
      templateUrl: 'templates/controls/Links.html'
    };
  }]);
});
define('modules/manageui/directives/linkSection', ['modules/manageui/module'], function(module) {
  'use strict';
  module.directive('sysLinkSection', [function() {
    var _link = function($scope, $element, $attrs, $ctrl) {};
    var _controller = function($scope, $element, $attrs, $tab, $tabStore) {
      $scope.openLink = function(link) {
        if ($tabStore[link.id] !== undefined) {
          $tabStore[link.id].active();
        } else {
          $tabStore[link.id] = $tab.open(link);
          $tabStore[link.id].result.then(function() {
            delete $tabStore[link.id];
          });
        }
      };
    };
    return {
      scope: {
        sysLinkSection: '='
      },
      restrict: 'AE',
      replace: true,
      link: _link,
      controller: [
        '$scope',
        '$element',
        '$attrs',
        '$tab',
        '$tabStore',
        _controller
      ],
      templateUrl: 'templates/controls/LinkSection.html'
    };
  }]);
});
define('modules/manageui/directives/linkItem', ['modules/manageui/module'], function(module) {
  'use strict';
  module.directive('sysLinkItem', [function() {
    var _link = function($scope, $element, $attrs, $ctrl) {};
    var _controller = function($scope, $element, $attrs, $tab, $tabStore) {
      $scope.openLink = function(link) {
        if ($tabStore[link.id] !== undefined) {
          $tabStore[link.id].active();
        } else {
          $tabStore[link.id] = $tab.open(link);
          $tabStore[link.id].result.then(function() {
            delete $tabStore[link.id];
          });
        }
      };
    };
    return {
      scope: {
        sysLinkItem: '='
      },
      restrict: 'AE',
      replace: true,
      transclude: true,
      link: _link,
      controller: [
        '$scope',
        '$element',
        '$attrs',
        '$tab',
        '$tabStore',
        _controller
      ],
      templateUrl: 'templates/controls/LinkItem.html'
    };
  }]);
});
define('modules/manageui/factories/tabStack', ['modules/manageui/module'], function(module) {
  'use strict';
  module.factory('$tabStack', [
    '$compile',
    '$rootScope',
    '$$stackedMap',
    function($compile, $rootScope, $$stackedMap) {
      var openedTabs = $$stackedMap.createNew();
      var $tabStack = {};

      function removeTab(tabInstance) {
        var tab = openedTabs.get(tabInstance).value;
        openedTabs.remove(tabInstance);
        removeAfter(tab.tabDomEl, tab.tabContentDomEl, tab.scriptDomEl, tab.tabScope, function() {
          tab.tabScope.$destroy();
          var top = $tabStack.getTop();
          if (top) {
            $tabStack.active(top.key);
          } else {
            $('[role="tablist"] li[head="true"] a').tab('show');
          }
        });
      }

      function removeAfter(tabEl, contentEl, scriptEl, scope, done) {
        tabEl.remove();
        contentEl.remove();
        if (scriptEl)
          scriptEl.remove();
        if (done) {
          done();
        }
      }
      $tabStack.open = function(tabInstance, tab) {
        openedTabs.add(tabInstance, {
          deferred: tab.deferred,
          tabScope: tab.scope
        });
        var tabTailElement = $('[role="tablist"] [head="true"]');
        var tabHostElement = $('.manage-content .manage-tab .tab-content').eq(0);
        var tabElement = angular.element('<li role="presentation">' + '<a href="" data-target="#' + tab.tabkey + '" data-toggle="tab" style="padding-right: 40px"><i class="' + tab.icon + '"></i> <span>' + tab.text + '</span><button type="button" class="close pull-right" aria-label="Close" style="position: absolute; right:15px" ng-click="$close()"><span aria-hidden="true">&times;</span></button></a>' + '</li>');
        tabElement.attr({
          'index': openedTabs.length() - 1
        });
        var tabDomEl = $compile(tabElement)(tab.scope);
        tabTailElement.after(tabDomEl);
        var tabContentElement = angular.element('<div role="tabpanel" class="tab-pane manage-tab-pane" id="' + tab.tabkey + '"></div>');
        var tabContentDomEl;
        var scriptDomEl;
        if (tab.src) {
          tabContentElement.html('<iframe src="' + tab.src + '" frameborder="0" width="100%" height="100%" scrolling="auto"></iframe>');
          tabContentDomEl = tabContentElement;
          tabHostElement.append(tabContentDomEl);
        } else {
          tabContentElement.html(tab.content);
          scriptDomEl = tabContentElement.find('script');
          tabHostElement.append(scriptDomEl);
          tabContentDomEl = $compile(tabContentElement)(tab.scope);
          tabHostElement.append(tabContentDomEl);
        }
        openedTabs.top().value.tabDomEl = tabDomEl;
        openedTabs.top().value.tabContentDomEl = tabContentDomEl;
        if (scriptDomEl)
          openedTabs.top().value.scriptDomEl = scriptDomEl;
        $tabStack.active(tabInstance);
      };
      $tabStack.active = function(tabInstance) {
        var tab = openedTabs.get(tabInstance);
        if (tab) {
          tab.value.tabDomEl.find('a').eq(0).tab('show');
        }
      };
      $tabStack.close = function(tabInstance, result) {
        var tab = openedTabs.get(tabInstance);
        if (tab) {
          tab.value.deferred.resolve(result);
          removeTab(tabInstance);
        }
      };
      $tabStack.dismiss = function(tabInstance, reason) {
        var tab = openedTabs.get(tabInstance);
        if (tab) {
          tab.value.deferred.reject(reason);
          removeTab(tabInstance);
        }
      };
      $tabStack.dismissAll = function(reason) {
        var topTab = this.getTop();
        while (topTab) {
          this.dismiss(topTab.key, reason);
          topTab = this.getTop();
        }
      };
      $tabStack.getTop = function() {
        return openedTabs.top();
      };
      return $tabStack;
    }
  ]);
});
define('modules/manageui/factories/tableParameter', ['modules/manageui/module'], function(module) {
  'use strict';
  module.factory('modules.manageui.factories.tableParameter', [
    'NgTableParams',
    'app.services.httpService',
    function(NgTableParams, httpService) {
      function tableParameter(settings) {
        settings = settings ? settings : {};
        return new NgTableParams({
          count: settings.count ? settings.count : 10
        }, {
          counts: settings.counts ? settings.counts : [10, 25, 50],
          getData: function(params) {
            if (!settings.url) return;

            return httpService.post(settings.url, $.extend({
              page: {
                page: params.page() - 1,
                rows: params.count()
              }
            }, settings.data)).then(function(result) {
              if (result.resultlst && result.resultlst.length > 0) {
                params.total(result.page.total);
                params.generatePagesArray();
                return result.resultlst;
              }
              params.generatePagesArray();
              params.total(0);
              return [];
            }, function() {
              params.total(0);
              params.generatePagesArray();
              return [];
            });
          }
        });
      }
      tableParameter.prototype = {
        constructor: tableParameter
      };
      return tableParameter;
    }
  ]);
});
define('modules/manageui/services/sessionService', ['modules/manageui/module'], function(module) {
  'use strict';
  module.service('modules.manageui.services.sessionService', [
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
        httpService.post('/person/login', {
          loginName: username,
          pwd: password
        }).then(function(result) {
          if ($appEnvironment.session.status === 'Logined') {
            me.checkSession().authenticated(function(session) {
              $appEnvironment.user = result;
              defered.resolve();
            }).unAuthenticated(function() {
              defered.reject();
            });
          }
        }, function(result) {
          defered.reject(result);
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
        $appEnvironment.session = null;
        httpService.get('/person/logout').then(function(result) {
          defered.resolve();
          processModal.close();
        }, function() {
          defered.reject();
          processModal.close();
        });
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
          defered.reject(result);
          processModal.close();
        });
        return defered.promise;
      };
    }
  ]);
});
define('modules/manageui/services/tabService', ['modules/manageui/module'], function(module) {
  'use strict';
  module.service('modules.manageui.services.tabService', [
    '$tab',
    '$tabStore',
    function($tab, $tabStore) {
      this.open = function(tabOptions) {
        if ($tabStore[tabOptions.id] !== undefined) {
          $tabStore[tabOptions.id].active();
        } else {
          $tabStore[tabOptions.id] = $tab.open(tabOptions);
          $tabStore[tabOptions.id].result.then(function() {
            delete $tabStore[tabOptions.id];
          });
        }
        return $tabStore[tabOptions.id];
      };
    }
  ]);
});
define('modules/manageui/controllers/register', ['modules/manageui/module'], function(module) {
  'use strict';
  module.controller('modules/manageui/controllers/register', [
    '$scope',
    'app.services.httpService',
    function($scope, httpService) {
      $scope.machineno = '';
      $scope.regnumber = '';
      this.getCode = function() {
        httpService.post('/softreg/findMachineNumber').then(function(result) {
          $scope.machineno = result.machineno;
          $scope.regnumber = result.regnumber;
        });
      };
      this.regist = function() {
        if (!$scope.agree) {
          alert('请阅读并同意用户协议\uFF1F');
          return;
        }
        httpService.post('/softreg/addSoftreg', {
          username: $scope.username,
          machineno: $scope.machineno,
          regnumber: $scope.regnumber
        });
      };
    }
  ]);
});
define('modules/manageui/controllers/main', ['modules/manageui/module'], function(module) {
  'use strict';
  module.controller('modules.manageui.controllers.main', [
    '$scope',
    '$state',
    '$appConfig',
    '$appEnvironment',
    '$location',
    '$tab',
    '$modal',
    'modules.manageui.configs.linkManager',
    'modules.manageui.services.tabService',
    'app.services.popupService',
    'modules.manageui.services.sessionService',
    function($scope, $state, $appConfig, $appEnvironment, $location, $tab, $modal, linkManager, tabService, popupService, sessionService) {
      var me = this;
      this.menuCollapse = false;
      this.themes = [{
          name: '深蓝',
          value: 'theme-dark'
        },
        {
          name: '紫红',
          value: 'theme-purple'
        },
        {
          name: '军绿',
          value: 'theme-green'
        }
      ];
      this.tabService = tabService;
      this.changeTheme = function(theme) {
        $appEnvironment.theme = theme;
      };
      this.logout = function() {
        popupService.confirm('是否退出\uFF1F').ok(function() {
          sessionService.logout().then(function() {
            $state.go('login');
          });
        });
      };
      this.showUser = function() {
        $modal.open({
          templateUrl: 'modules/manageui/views/UserDetails.html',
          size: 'sm',
          data: {
            Id: $appEnvironment.user.Id
          }
        });
      };
      this.editPicture = function() {
        $modal.open({
          templateUrl: 'modules/manageui/views/UserPicture.html'
        });
      };
      $scope.$appEnvironment = $appEnvironment;
      $scope.$on('ngRepeated', function() {
        $('.metismenu').metisMenu();
      });
      $('[role="tablist"]').sortable({
        items: 'li:not(.ui-state-disabled)',
        axis: 'x'
      });
      $('[role="tablist"]').disableSelection();
      if ($appConfig.session)
        this.links = linkManager.tree();
      else {
        if ($appEnvironment.session && $appEnvironment.session.Status === 'Logined') {
          me.links = linkManager.tree();
        } else {
          sessionService.checkSession().authenticated(function() {
            me.links = linkManager.tree();
          }).unAuthenticated(function() {
            $state.go('login');
          });
        }
      }
    }
  ]);
});
define('modules/manageui/controllers/session', ['modules/manageui/module'], function(module) {
  'use strict';
  module.controller('modules.manageui.controllers.session', [
    '$scope',
    '$state',
    'modules.manageui.services.sessionService',
    function($scope, $state, sessionService) {
      sessionService.checkSession().authenticated(function(session) {
        $state.go('main');
      }).unAuthenticated(function() {
        $state.go('login');
      });
    }
  ]);
});
define('modules/manageui/controllers/login', ['modules/manageui/module'], function(module) {
  'use strict';
  module.controller('modules.manageui.controllers.login', [
    '$scope',
    '$state',
    '$appConfig',
    '$appEnvironment',
    '$element',
    'modules.manageui.services.sessionService',
    function($scope, $state, $appConfig, $appEnvironment, $element, sessionService) {
      var me = this;
      this.login = function() {
        sessionService.login(me.Username, me.Password).success(function() {
          $state.go($('html').attr('data-index'));
        });
      };
      this.register = function() {
        $state.go('register');
      };
    }
  ]);
});
define('modules/manageui/requires', [
  'modules/manageui/filters/integer',
  'modules/manageui/filters/linkAuthorize',
  'modules/manageui/directives/datetimepicker',
  'modules/manageui/directives/ngRepeated',
  'modules/manageui/directives/links',
  'modules/manageui/directives/linkSection',
  'modules/manageui/directives/linkItem',
  'modules/manageui/factories/tabStack',
  'modules/manageui/factories/tableParameter',
  'modules/manageui/services/sessionService',
  'modules/manageui/services/tabService',
  'modules/manageui/controllers/register',
  'modules/manageui/controllers/main',
  'modules/manageui/controllers/session',
  'modules/manageui/controllers/login'
], function() {
  'use strict';
});