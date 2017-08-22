'use strict';

angular.
    module('myUserMaps').
    component('myUserMaps', {
        templateUrl: 'app/user-maps/user-maps.template.html',
        controller: ['Metrics',
            function UserMapsController(Metrics) {

                var self = this;

                self.nationalityGroups = {};
                self.birthplaceGroups = {};

                self.metrics = Metrics.MetricsList.query(function() {

                    google.charts.load('current', {
                            'packages': ['geochart'],
                            'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY',
                            'callback': function() {

                                self.mapChart = new google.visualization.GeoChart(document.getElementById('map_div'));

                                self.fillDataTables();
                                self.updateMapChart('region_chart');
                            }
                        });
                });

                self.fillDataTables = function() {

                    angular.forEach(self.metrics, function(metric, key) {

                        if(self.nationalityGroups[metric.nationality] === undefined ) {
                            self.nationalityGroups[metric.nationality] = 1;
                        } else {
                            self.nationalityGroups[metric.nationality]++;
                        }

                        if(self.birthplaceGroups[metric.place_of_birth] === undefined ) {
                            self.birthplaceGroups[metric.place_of_birth] = 1;
                        } else {
                            self.birthplaceGroups[metric.place_of_birth]++;
                        }
                    });

                    self.nationalityDataTable = new google.visualization.DataTable();
                    self.nationalityDataTable.addColumn('string', 'Nationality');
                    self.nationalityDataTable.addColumn('number', 'Population');
                    for(var key in self.nationalityGroups) {
                        self.nationalityDataTable.addRow([key, self.nationalityGroups[key]]);
                    }

                    self.birthplaceDataTable = new google.visualization.DataTable();
                    self.birthplaceDataTable.addColumn('string', 'Place of birth');
                    self.birthplaceDataTable.addColumn('number', 'Population');
                    for(var key in self.birthplaceGroups) {
                        self.birthplaceDataTable.addRow([key, self.birthplaceGroups[key]]);
                    }
                }

                self.updateMapChart = function(chartType = 'region_chart') {

                    switch(chartType) {
                        case 'marker_chart':
                            self.mapChart.draw(self.birthplaceDataTable, {displayMode: 'markers'});
                            break;
                        case 'region_chart':
                        default:
                            self.mapChart.draw(self.nationalityDataTable);

                    }
                }
        }]
    })
