declare var $: any;
declare var colorbox: any;
declare var getBaseUri: any;
declare var om: any;

import * as angular from 'angular';
import {NgModule} from '@angular/core';

// This is the Angular 1 part of the module
export const internalConsortiumCtrl = angular.module('orcidApp').controller(
    'internalConsortiumCtrl',
    [
        '$compile', 
        '$scope', 
        function manageConsortiumCtrl(
            $compile,
            $scope
        ) {    
            $scope.consortium = null;
            $scope.showFindModal = false;

            $scope.closeModal = function() {
                $.colorbox.close();
            };

            $scope.confirmUpdateConsortium = function() {
                $.colorbox({
                    html : $compile($('#confirm-modal-consortium').html())($scope),
                    scrolling: true,
                    onLoad: function() {
                        $('#cboxClose').remove();
                    }
                });

                $.colorbox.resize({width:"450px" , height:"175px"});
            };

            $scope.findConsortium = function() {
                $.ajax({
                    url: getBaseUri()+'/manage-members/find-consortium.json?id=' + encodeURIComponent($scope.salesForceId),
                    type: 'GET',
                    dataType: 'json',
                    success: function(data){
                        $scope.consortium = data;
                        $scope.$apply();
                    }
                }).fail(function(error) {
                    // something bad is happening!
                    console.log("Error finding the consortium");
                });
            };

            $scope.toggleFindConsortiumModal = function() {
                $scope.showFindModal = !$scope.showFindModal;
            };
            
            $scope.updateConsortium = function() {
                $.ajax({
                    url: getBaseUri()+'/manage-members/update-consortium.json',
                    contentType: 'application/json;charset=UTF-8',
                    type: 'POST',
                    dataType: 'json',
                    data: angular.toJson($scope.consortium),
                    success: function(data){
                        $scope.$apply(function(){
                            if(data.errors.length == 0){
                                $scope.consortium = null;
                                $scope.success_edit_member_message = om.get('manage_member.edit_member.success');
                            } else {
                                $scope.consortium = data;
                            }
                        });
                        $scope.closeModal();
                    }
                }).fail(function(error) {
                    // something bad is happening!
                    console.log("Error updating the consortium");
                });
            };
        }
    ]
);

// This is the Angular 2 part of the module
@NgModule({})
export class internalConsortiumCtrlNg2Module {}