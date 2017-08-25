'use strict';

angular.
    module('myUserMaps').
    component('myUserMaps', {
        templateUrl: 'app/user-maps/user-maps.template.html',
        controller: ['ChartInfo', 'Metrics',
            function UserMapsController(ChartInfo, Metrics) {

                var self = this;

                self.chartData = ChartInfo.ChartData.query();
                self.chartOptions = ChartInfo.ChartOptions.get();

                self.nationalityGroups = {};
                self.birthplaceGroups = {};

                self.metrics = Metrics.MetricsList.query(function() {

                    google.charts.load('current', {
                            'packages': ['geochart'],
                            'mapsApiKey': 'AIzaSyAnuubBPo0ChOf3oe2UaZG25dPG_QJQ-BE',
                            'callback': function() {

                                self.mapChart = new google.visualization.GeoChart(document.getElementById('map_div'));

                                self.fillDataTables();
                                self.updateMapChart('nationality-regions');
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

                        if(self.birthplaceGroups[metric.placeOfBirth] === undefined ) {
                            self.birthplaceGroups[metric.placeOfBirth] = 1;
                        } else {
                            self.birthplaceGroups[metric.placeOfBirth]++;
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

                self.updateMapChart = function(chartType = 'nationality-regions') {

                    switch(chartType) {
                        case 'birthplace-markers':
                            self.mapChart.draw(self.birthplaceDataTable, self.chartOptions.markerChart);
                            break;
                        case 'nationality-regions':
                        default:
                            self.mapChart.draw(self.nationalityDataTable, self.chartOptions.regionChart);
                    }
                }
        }]
    })
