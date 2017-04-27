"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var country_service_1 = require('../providers/country.service');
var AddTravelComponent = (function () {
    function AddTravelComponent(countryService) {
        this.countryService = countryService;
        this.title = 'Travel Companion';
    }
    AddTravelComponent.prototype.getCountries = function () {
        var _this = this;
        this.countryService.getCountriesMock().then(function (countries) { return _this.countries = countries; });
    };
    AddTravelComponent.prototype.ngOnInit = function () {
        this.getCountries();
    };
    AddTravelComponent = __decorate([
        core_1.Component({
            selector: 'tc-app',
            templateUrl: 'app/views/addtravel.view.html',
            styleUrls: ['app/styles/addtravel.style.css'],
            providers: [country_service_1.CountryService]
        }), 
        __metadata('design:paramtypes', [country_service_1.CountryService])
    ], AddTravelComponent);
    return AddTravelComponent;
}());
exports.AddTravelComponent = AddTravelComponent;
//# sourceMappingURL=addtravel.component.js.map