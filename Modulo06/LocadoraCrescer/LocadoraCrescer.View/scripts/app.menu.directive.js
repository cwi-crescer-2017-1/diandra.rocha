locadora.directive('menu', function() {
    return {
        restrict: 'E',
        scope: {
            active: '=active',
            user: '=user',
            logout: '=logout'
        },
        templateUrl: 'views/menu-template'
    };
});