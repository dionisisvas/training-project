'use strict';

angular.
    module('myUserDates').
    component('myUserDates', {
        templateUrl: 'app/user-dates/user-dates.template.html',
        controller: ['$scope',
            function UserDatesController($scope) {

 $scope.itemList = [];

    $scope.onItemClick = function( item ) {
        item.active = !item.active;
        if (item.active) {
            item.activeContent = item.content;
        } else {
            item.activeContent = item.shortContent;
        }
    }

    function setTestData() {
        var testItemList = [
            { date: '8/1/2014', time: '10:27 am', content: 'Macaroon ' },
            { date: '8/1/2014', time: '11:45 am', content: 'Bacon ' },
            { date: '8/3/2014', time: '8:31 am', content: 'Sweet ' },
            { date: '8/16/2014', time: '1:15 pm', content: 'short ' },
            { date: '9/2/2014', time: '1:27 pm', content: 'Sweet ' },
            { date: '9/2/2014', time: '2:06 pm', content: 'Meatball ' },
            { date: '9/2/2014', time: '5:54 pm', content: 'Sweet ' },
            { date: '9/5/2014', time: 'Marriage', content: 't-bone ' }
        ];

        for( var i = 0; i < testItemList.length; i++ ) {
            var item = testItemList[i];
            item.shortContent = item.content.substring(0, 235);
            if (item.content.length > 235) {
                item.shortContent = [item.shortContent, '...'].join('');
            }
            testItemList[i].activeContent = testItemList[i].shortContent;
            testItemList[i].active = false;
        }

        $scope.itemList = testItemList;
    }

    setTestData();

            }]
            })