//Import all the angular components

import { NgForOf, NgIf } 
    from '@angular/common'; 

import { AfterViewInit, Component, OnDestroy, OnInit } 
    from '@angular/core';

import { Observable, Subject, Subscription } 
    from 'rxjs';

import { takeUntil } 
    from 'rxjs/operators';

import { SwitchUserService } 
    from '../../shared/switchUser.service.ts';

import { AdminActionsService } 
    from '../../shared/adminActions.service.ts';    

import { CommonService } 
    from '../../shared/common.service.ts';
    
@Component({
    selector: 'admin-actions-ng2',
    template:  scriptTmpl("admin-actions-ng2-template"),
    providers: [CommonService]
})
export class AdminActionsComponent implements AfterViewInit, OnDestroy, OnInit {
    private ngUnsubscribe: Subject<void> = new Subject<void>();    
   
    // Switch user
    switchId: string;
    showSwitchUser: boolean;
    switchUserError: boolean;
    
    // Find ids
    csvEmails: string;
    profileList: any;
    showFindIds: boolean;
    showIds: boolean;
    
    // Reset password
    showResetPassword: boolean;
    resetPasswordParams: any;
    showResetPasswordConfirm: boolean;
    
    constructor(
        private switchUserService: SwitchUserService,
        private adminActionsService: AdminActionsService,
        private commonSrvc: CommonService
    ) {
        this.showSwitchUser = false;
        this.switchUserError = false;
        
        this.csvEmails = '';
        this.showFindIds = false;
        this.showIds = false;
        this.profileList = {};
    
        this.showResetPassword = false;
        this.resetPasswordParams = {};
        this.showResetPasswordConfirm = false;
    }    

    switchUser(id): void {
        this.switchUserService.adminSwitchUserValidate(id)
        .pipe(    
            takeUntil(this.ngUnsubscribe)
        )
        .subscribe(
            data => {                
                if(data != null && data.errorMessg == null) {
                    this.switchUserError = false;
                    window.location.replace(getBaseUri() + '/switch-user?username=' + data.id);                    
                } else {
                    this.switchUserError = true;
                }
            },
            error => {
                console.log('admin: switchUser error', error);
                this.switchUserError = true;
            } 
        );
        
    };
    
    findIds(): void {
        this.adminActionsService.findIds( this.csvEmails )
        .pipe(    
            takeUntil(this.ngUnsubscribe)
        )
        .subscribe(
            data => {
                this.showIds = true;
                if(data) {
                    this.profileList = data;
                } else {
                    this.profileList = {};
                }                
            },
            error => {
                console.log('admin: findIds error', error);
            } 
        );
    };
    
    randomString(): void {
        this.commonSrvc.randomString()
        .pipe(    
            takeUntil(this.ngUnsubscribe)
        )
        .subscribe(
            data => {
                this.resetPasswordParams.password = data;
            },
            error => {
                console.log('admin: randomString', error);
            } 
        );
    };
    
    confirmResetPassword(): void {
        if(this.resetPasswordParams != null && this.resetPasswordParams.orcidOrEmail != null && this.resetPasswordParams.password != null) {
            this.showResetPasswordConfirm = true;
        }        
    };
    
    resetPassword(): void {
        console.log('Admin reset password');
        this.adminActionsService.resetPassword( this.resetPasswordParams )
        .pipe(    
            takeUntil(this.ngUnsubscribe)
        )
        .subscribe(
            data => {
                console.log('Just resetted password');
                this.showResetPasswordConfirm = false;
                if(data) {
                    this.resetPasswordParams = data;
                }                
            },
            error => {
                console.log('admin: resetPassword error', error);
            } 
        );        
    };
    
    //Default init functions provided by Angular Core
    ngAfterViewInit() {
        //Fire functions AFTER the view inited. Useful when DOM is required or access children directives
    };

    ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    };

    ngOnInit() {
    }; 
}