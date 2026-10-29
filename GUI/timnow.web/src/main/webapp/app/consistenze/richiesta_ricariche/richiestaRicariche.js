timnow
    .controller('richiestaRicariche', ['$scope', '$state', '$rootScope', '$log', 'modalService', 'NuovaRicarica', '$filter', 'TaglioRicarica',
        function ($scope, $state, $rootScope, $log, modalService, NuovaRicarica, $filter, TaglioRicarica) {

            $scope.inCarica = false;
//            $scope.time = ["00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", 
//                           "04:00","04:30","05:00", "05:30","06:00","06:30","07:00","07:30","08:00",
//                           "08:30","09:00","09:30","10:00","10:30", "11:00","11:30","12:00","12:30","13:00",
//                           "13:30","14:00","14:30","15:00","15:30","16:00","16:30", "17:00","17:30","18:00",
//                           "18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30",
//                           "23:00","23:30"];


          //******************************tmp temporaneo TODO in anguarJS
            function addZero(num) {
                return (num >= 0 && num < 10) ? "0" + num : num + "";
            }

            function isBefore(value) {
            	var h = value.split(':')[0];
            	var m = value.split(':')[1];
            	
            	if(h === undefined || h === '' || h === null) {
            		return false;
            	} else if (m === undefined || m === '' || m === null){
            		return false;
            	} else {
            		return (h < actualHour) || ( h === actualHour && m < actualMinute);
            	}
            }

            function isAfter(value) {
            	var h = value.split(':')[0];
            	var m = value.split(':')[1];
            	
            	return (h > actualHour) || ( h === actualHour && m > actualMinute);
            }

            var array = ["00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", 
                                       "04:00","04:30","05:00", "05:30","06:00","06:30","07:00","07:30","08:00",
                                       "08:30","09:00","09:30","10:00","10:30", "11:00","11:30","12:00","12:30","13:00",
                                       "13:30","14:00","14:30","15:00","15:30","16:00","16:30", "17:00","17:30","18:00",
                                       "18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30",
                                       "23:00","23:30"];
            var now = new Date();
            var actualHour = addZero(now.getHours());
            var actualMinute = addZero(now.getMinutes());

            //$scope.time = array.filter(isAfter);
            
            //******************************tmp temporaneo TODO in angularJS

            
            
            // MODALE PER MESSAGGIO DI ERRORE
            $scope.errorMessage = function (messageBody) {
                modalService.showModal({}, {
                    headerText: "Avviso",
                    closeButtonText: 'Chiudi',
                    bodyText: messageBody,
                    scope: $scope,
                    type: 'success'
                });
                $scope.caricaPassFive = false;
            };

            $scope.formatDataFine = function(data, giorni) {

                var dataString = $filter('date')(data, 'medium');
                $scope.mydate = new Date(dataString);
                var newdate = $scope.mydate.setDate($scope.mydate.getDate() + parseInt(giorni));
                $rootScope.ricarica.dataFineRicarica = $filter('date')(newdate, "dd/MM/yyyy");
                $rootScope.ricarica.dataFine = $rootScope.ricarica.dataFineRicarica;
            };

            $scope.convertStringToDate = function(){

                if($rootScope.ricarica.taglioRicaricaInGiorni) {
                    if($state.params.getValue && ($state.params.getValue.type === "PROLUNGAMENTO")){
                        $scope.prolungamento = true;
                        var dataIn = $state.params.getValue.dataFineRicarica;
                        var collectionDate = dataIn.substr(6, 4) + "-" + dataIn.substr(3, 2) + "-" + dataIn.substr(0, 2) + "T00:00:00";
                        var date = new Date(collectionDate);

                        $scope.formatDataFine(date, $rootScope.ricarica.taglioRicaricaInGiorni);
                    } else {
                        var InizioRicarica = $rootScope.ricarica.DataInizioRicarica;
                        if(InizioRicarica) {
                            if($rootScope.ricarica.tipologiaAccensioneRicarica === 'NRT'){
                                var today = new Date();
                                $scope.formatDataFine(today, $rootScope.ricarica.taglioRicaricaInGiorni);
                            } else {

                                $scope.formatDataFine(InizioRicarica, $rootScope.ricarica.taglioRicaricaInGiorni);
                            }
                        }
                    }
                }
                if($filter('date')(new Date(), "dd/MM/yyyy") === $filter('date')($rootScope.ricarica.DataInizioRicarica, "dd/MM/yyyy")){
                    if($rootScope.ricarica.OraInizioRicarica && ( $rootScope.ricarica.OraInizioRicarica.replace(/:/gm,'') < $filter('date')(new Date(), "HHmm"))) {
                        $rootScope.ricarica.OraInizioRicarica = null;
                    }

                    $scope.time = array.filter(isAfter);
                } else {
                    $scope.time = array;
                }
            };

            $scope.taglioRicarica = function (offerta) {


                TaglioRicarica.get({offerta: offerta}, function (responce) {
                        $scope.taglioRicarica = responce.data;
                    },
                    function () {
                        $scope.errorMessage("Non e' stato possibile completare l'operazione. Riprova piu' tardi.");
                    }
                );

            };
            if($state.params.ricaricaType && $state.params.ricaricaType.dettaglioAsset) {
                $scope.typeRecharged = "Ricarica";
                $rootScope.ricarica = $state.params.ricaricaType.dettaglioAsset;
                $rootScope.ricarica.tipologiaAccensioneRicarica = $state.params.ricaricaType.tipologia;

                $scope.taglioRicarica($state.params.ricaricaType.dettaglioAsset.offerta);
                //$rootScope.ricarica.taglioRicaricaInGiorni = $state.params.ricaricaType.dettaglioAsset.taglioRicarica;
                if($rootScope.ricarica.tipologiaAccensioneRicarica === 'NRT'){
                    $rootScope.ricarica.DataInizioRicarica = $rootScope.timnowConfigData.config.today;
                    $rootScope.ricarica.tipoLavorazione = "ACCENSIONE";
                } else {
                    $rootScope.ricarica.tipoLavorazione = "SCHEDULAZIONE";
                }
            } else if($state.params.getValue && $state.params.getOption){
                $rootScope.ricarica = $state.params.getOption;
                $rootScope.ricarica.idRicarica = $state.params.getValue.idRicarica;
                $rootScope.ricarica.tipologiaAccensioneRicarica = null;
                $scope.typeRecharged  = $rootScope.ricarica.tipoLavorazione = $state.params.getValue.type;

               // $rootScope.ricarica.taglioRicaricaInGiorni = $state.params.getValue.taglioRicaricaInGiorni;
                $scope.taglioRicarica($state.params.getOption.offerta);

                if($state.params.getValue.type === "ANNULLAMENTO"){
                	//RU_692
                    if($state.params.getValue.tipologiaAccensioneRicarica === "SCHEDULATA" || $state.params.getValue.tipologiaAccensioneRicarica === "PROLUNGATA"){
                        $rootScope.ricarica.DataInizioRicarica = $state.params.getValue.dataInizioRicarica;
                        $rootScope.ricarica.dataFine = $rootScope.ricarica.dataFineRicarica = $state.params.getValue.dataFineRicarica;
                        $rootScope.ricarica.taglioRicaricaInGiorni = $state.params.getValue.taglioRicaricaInGiorni;
                    } else {
                        $scope.errorMessage("Non e' stato possibile Annullare una ricarica " + $state.params.getValue.tipologiaAccensioneRicarica);
                        $state.go('root.consistenze.listaricariche', {"ricaricaType": $rootScope.ricarica});
                    }

                } else {
                    $rootScope.ricarica.DataInizioRicarica = $state.params.getValue.dataFineRicarica.substr(0, 10);
                }
            } else {
                $state.go('root.consistenze.listaricariche');
            }


            $scope.formats = ['dd/MM/yyyy', 'short'];
            $scope.format = $scope.formats[0];

            $scope.dateOptions = {
                //dateDisabled: disabled,
                formatYear: 'yy',
                maxDate: new Date(2500, 5, 22),
                minDate: new Date(),
                startingDay: 1
            };
            // Disable weekend selection
            function disabled(data) {
                var date = data.date, mode = data.mode;
                return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
            }
            $scope.openDP3 = function () {
                $scope.popup_dp3.opened = true;
            };
            $scope.popup_dp3 = {
                opened: false
            };


            $scope.valida = function (form) {
                $scope.caricaPassFive = true;
                var forms = [form];

                angular.forEach(forms, function (formItem) {
                    angular.forEach(formItem && formItem.$error.required,
                        function (field) {
                            field.$setDirty();
                        });
                });
            };


            $scope.changeState = function () {
                $state.go('root.consistenze.listaricariche', {"ricaricaType": $rootScope.ricarica, "getValue": null, "getOption": null });
            };

            $scope.confermaAnnulla = function () {
                modalService.showModal(
                    {},
                    {
                        headerText: "Vuoi annullare la ricarica?",
                        closeButtonText: 'Chiudi',
                        bodyText: "I dati inseriti nella ricarica saranno cancellati.",
                        actionButtonText: 'Continua',
                        scope: $scope,
                        callbackFunction: 'changeState',
                        type: 'success'
                    });
                $scope.caricaPassFive = false;
            };

            $scope.submit = function(){
                $scope.inCarica = true;
                if($rootScope.ricarica.tipologiaAccensioneRicarica === "schedulata"){
                    var dataInizio = $filter('date')( $rootScope.ricarica.DataInizioRicarica, "dd/MM/yyyy");

                    /** @namespace $scope.ricarica.OraInizioRicarica */
                    $rootScope.ricarica.dataInizioRicarica = dataInizio + " " + $scope.ricarica.OraInizioRicarica + ":00";

                    $rootScope.ricarica.dataFineRicarica = $rootScope.ricarica.dataFineRicarica + " " + $scope.ricarica.OraInizioRicarica + ":00";

                } else {
                    if(($rootScope.ricarica.DataInizioRicarica) && (!$scope.prolungamento) && ($rootScope.ricarica.tipologiaAccensioneRicarica !== 'NRT')){
                        $rootScope.ricarica.dataInizioRicarica = $rootScope.ricarica.DataInizioRicarica + " 00:00:00";
                    } else if(($rootScope.ricarica.DataInizioRicarica) && ($scope.prolungamento) && ($rootScope.ricarica.tipologiaAccensioneRicarica !== 'NRT')){
                        $rootScope.ricarica.dataInizioRicarica = $state.params.getValue.dataFineRicarica;
                    } else {
                        $rootScope.ricarica.dataInizioRicarica =  $filter('date')(new Date(), "dd/MM/yyyy HH:mm:ss");
                    }

                    $rootScope.ricarica.dataFineRicarica = $rootScope.ricarica.dataFineRicarica + " " + $rootScope.ricarica.dataInizioRicarica.substr(11, 8);
                }



                NuovaRicarica.save($rootScope.ricarica, function () {
                        $scope.inCarica = false;
                        $scope.errorMessage("La ricarica è andata a buon fine");
                        $scope.changeState();

                    },
                    function () {
                        $scope.inCarica = false;
                        $scope.errorMessage("Non e' stato possibile completare l'operazione. Riprova piu' tardi.");
                    }
                );
            }
    }]);
