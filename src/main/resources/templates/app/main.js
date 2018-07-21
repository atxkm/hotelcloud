(function (options) {
    'use strict';

    var requires = ['app/application'],
        config = {
            urlArgs: options.app.getAttribute('data-args'),
            paths: {
                'patch': 'js/patch',
                'rcss': 'js/app',
                'angular': 'js/app',
                'app': 'js/app',
                'app/application': 'js/app.application'
            },
            shim: {
                'app/application': {
                    deps: ['app']
                }
            }
        };

    initBrowserPatch(config);
    initReference(requires, config, options.references);
    initModules(requires, options);
    initDebug(config, options.noDebugs);
    startup(requires, config);

    function startup(requires, config) {
        require.config(config);
        require(requires, function (application) {
            angular.element(document).ready(function () {
                angular.element(document).find('html')
                    .attr('id', 'ng-app')
                    .attr('ng-app', 'app.application')
                    .attr('data-index', app.getAttribute('data-index'));
                angular.bootstrap(document, ['app.application']);
            });
        });
    }

    function initReference(requires, config, references) {
        for (var name in references) {
            var reference = references[name];
            var referenceType = Object.prototype.toString.call(reference);
            if (referenceType === '[object Object]') {
                config.paths[name] = reference.path;
                if (reference.shim)
                    config.shim[name] = reference.shim;
                if (reference.required) {
                    requires.push(name);
                }
            } else if (referenceType === '[object String]') {
                config.paths[name] = reference;
            }
        }
    }

    function initDebug(config, nonDebugs) {
        var debug = eval(app.getAttribute('data-debug')) ? '' : '.min';
        for (var index in config.paths) {
            var isDebug = true;
            for (var i in nonDebugs) {
                if (nonDebugs[i] === index) {
                    isDebug = false;
                    break;
                }
            }
            config.paths[index] = config.paths[index] + (isDebug ? debug : '');
        }
    }

    function initModules(requires, options) {
        for (var idx in options.requires) {
            requires.push(options.requires[idx]);
        }
    }

    function initBrowserPatch(config) {
        if (document.getElementsByTagName('html')[0].getAttribute('data-html-type') === 'no-js lte-ie8') {
            config.shim.app = {
                deps: ['patch']
            };
            config.shim.rcss = {
                deps: ['patch']
            };
        }
    }
})({
    app: document.getElementById('app'),
    references: {
        // modules
        'web.modules': {
            path: 'js/web.modules',
            shim: {
                deps: ['app/application']
            }
        },

        // requires
        'modules/manageui/requires': {
            path: 'js/modules.manageui',
            shim: {
                deps: ['web.modules']
            }
        },
        'modules/room/requires': {
            path: 'js/modules.room',
            shim: {
                deps: ['web.modules', 'modules/manageui/requires']
            }
        },

        // reference
        'api-check': {
            path: 'js/api-check'
        },
        'metisMenu': {
            path: 'js/metisMenu',
            shim: {
                deps: ['api-check']
            }
        },
        'smalot-bootstrap-datetimepicker': {
            path: 'js/bootstrap-datetimepicker',
            shim: {
                deps: ['app']
            }
        },
        'smalot-bootstrap-datetimepicker-zhcn': {
            path: 'js/bootstrap-datetimepicker.zh-CN',
            shim: {
                deps: ['app', 'smalot-bootstrap-datetimepicker']
            }
        },
        'ng-table': {
            path: 'js/ng-table',
            shim: {
                deps: ['app']
            }
        },
        'jquery-ui': {
            path: 'js/jquery-ui',
            shim: {
                deps: ['app']
            }
        },
        'ui-switch': {
            path: 'js/angular-ui-switch',
            shim: {
                deps: ['app']
            }
        },
        'cropper': {
            path: 'js/cropper',
            shim: {
                deps: ['app']
            }
        },
        'angularjs-slider': {
            path: 'js/rzslider',
            shim: {
                deps: ['app']
            }
        }
    },
    requires: [
        'rcss!css/font-awesome.min.css',
        'rcss!css/bootstrap-datetimepicker.min.css',
        'rcss!css/metisMenu.min.css',
        'rcss!css/ng-table.min.css',
        'rcss!css/angular-ui-switch.min.css',
        'web.modules'
    ],
    noDebugs: [
        'smalot-bootstrap-datetimepicker-zhcn'
    ]
});