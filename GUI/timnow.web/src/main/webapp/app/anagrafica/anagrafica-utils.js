//SM_10029
timnow
	.service('AnagraficaUtils', function(){
		return{
			formatDateToString: function(date, format){
				
				var _dateString = null;
				
				if(date && angular.isDate(date)){
					var day = date.getDate();
					var month = date.getMonth()+1; 
					var year = date.getFullYear();
					if(day < 10){
					    day ='0'+day;
					} 

					if(month < 10){
					    month ='0' + month;
					} 
					
					if(!format) {
						format = "";
					}
					
					switch(format.toLowerCase()){
						case 'yyyy-mm-dd':
							_dateString = year +'-'+month+'-'+day;
						break;
						case 'dd/mm/yyyy':
							_dateString = day + '/' +month + '/' + year;
						break;
						case 'mm/dd/yyyy':
							_dateString = month +'/'+ day + '/' + year;
						break;
						default:
							_dateString = day + '/' + month + '/' + year;						
					}				
				}
				
				return _dateString;
			}
		};
});