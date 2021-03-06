function format_number(pnumber,decimals){ 
    if (isNaN(pnumber)) { return new String("0.00")}; 
    if (pnumber=='') { return new String("0.00")}; 
    if (pnumber==0) { return new String("0.00")};

    var snum = new String(pnumber); 
    var sec = snum.split('.'); 
    var whole = parseFloat(sec[0]); 
    var result = ''; 

    if(sec.length > 1){ 
        var dec = new String(sec[1]); 
        dec = String(parseFloat(sec[1])/Math.pow(10,(dec.length - decimals))); 
        dec = String(whole + Math.round(parseFloat(dec))/Math.pow(10,decimals)); 
        var dot = dec.indexOf('.'); 
        if(dot == -1){ 
            dec += '.'; 
            dot = dec.indexOf('.'); 
        } 
        while(dec.length <= dot + decimals) { dec += '0'; } 
        result = dec; 
    }else{ 
        var dot; 
        var dec = new String(whole); 
        dec += '.'; 
        dot = dec.indexOf('.'); 
        while(dec.length <= dot + decimals) { dec += '0'; } 
        result = dec; 
    } 
    return result; 
} 


function extractAWB(a_scan){
	var cLabelNum = '';
	var cFormNum ='';
	var sChain='';
	var nLen='';
	var LenOriginal='';
	LenOriginal = a_scan.length;
	sChain = trim(a_scan);

	/* erase '-' */
	   sChain = sChain.replace('-','');

	/* erase "'" */
	   sChain = sChain.replace("'","");

	/* Eliminar 1a. letra y ultima letra (si hay) */
	   /* La primera, es letra? */
	   if (isNaN(sChain.charAt(0))){
		  sChain = sChain.substr(1);
	   }

	/* La ultima, es letra? */
	   if (isNaN(sChain.charAt(sChain.length-1))){
			sChain = sChain.substr(0,sChain.length-1);
	   }

	/* Calcular largo */
	   nlen = sChain.length;

	   if(nlen==12){
		  cLabelNum = sChain;
		  cFormNum = '';

  		  /* MPS viejos */
          // Commented due validation troubles
          //if(cLabelNum.substr(0,1) == '9' && cLabelNum.substr(cLabelNum.length-3,2) == '01'){
			//	cLabelNum = cLabelNum.substr(0,10);
		  //}

	   }else{
	   		if(nlen<=16){
			  cLabelNum = sChain.substr(0,12);
			  cFormNum =  sChain.substr(12,3);
			}else{
			  cLabelNum = sChain.substr(16,3);
			  cFormNum =  sChain.substr(18,3);
			}
		}

	/* Hay distintos largo segun el tipo de formulario:  */
	/* Ver http://home.fedex.com/~shiplink/etn/ntn.htm para actualizar */

	   if (cFormNum == '012' || cFormNum == '020'){
			 cLabelNum = cLabelNum.substr(0,8);
           //alert("1: " + cFormNum);
       }else{
	   		 if(cFormNum == '008' || cFormNum == '014' || cFormNum == '015' || cFormNum == '016' || cFormNum == '021'){
   		         cLabelNum = cLabelNum.substr(0,9);
                    //alert("2: " + cFormNum);
                }else{
				 if (cFormNum == '001' || cFormNum == '003' ||
				  cFormNum == '004' || cFormNum == '017' ||
				  cFormNum == '019' || cFormNum == '022' ||
				  cFormNum == '029' || cFormNum == '032' ||
				  cFormNum == '070' ||
				  cFormNum == '071' || cFormNum == '072' ||
				  cFormNum == '073'){
			   		 /* Largo 10 */
                     //alert("3: " + cFormNum);
                       cLabelNum = cLabelNum.substr(0,10);
				  }else{
	   				  if(cFormNum == '002' || cFormNum == '005' ||
			   			 cFormNum == '006' || cFormNum == '007' ||
			   			 cFormNum == '009' || cFormNum == '010' ||
			   			 cFormNum == '011' || cFormNum == '018' ||
			   			 cFormNum == '023' || cFormNum == '051'){
							/* Largo 11 */
                             //alert("4: " + cFormNum);
                               cLabelNum = cLabelNum.substr(0,11);
			   		  }
			   	  }
	  	      }
	    }

	return trim(cLabelNum);
}

function trim(inputString) {
   if (typeof inputString != "string") { return inputString; }
   var retValue = inputString;
   var ch = retValue.substring(0, 1);
   while (ch == " ") {
      retValue = retValue.substring(1, retValue.length);
      ch = retValue.substring(0, 1);
   }
   ch = retValue.substring(retValue.length-1, retValue.length);
   while (ch == " ") {
   	  retValue = retValue.substring(0, retValue.length-1);
      ch = retValue.substring(retValue.length-1, retValue.length);
   }
   while (retValue.indexOf("  ") != -1) {
      retValue = retValue.substring(0, retValue.indexOf("  ")) + retValue.substring(retValue.indexOf("  ")+1, retValue.length);
   }
   return retValue; // Return the trimmed string back to the user
}

function validaAWBNbr(awbNbr){
    if(awbNbr.length!=11 && awbNbr.length!=12) return false;

    if(isNaN(awbNbr)) return false;

    if(awbNbr.length==11){
    	return true;
    }//end if TNT awb length = 11
    
	if(awbNbr.length==12){
		var acum=Number(0);
		var weight=7;
		for(i=10;i>=0;i--){
                switch(weight){
				case 1: weight=3;break;
				case 3: weight=7;break;
				case 7: weight=1;break;
			}
			acum=acum+awbNbr.charAt(i)*weight;
		}
        var veridigit=acum%11;
        if(veridigit==10) veridigit=0;

        if(veridigit==awbNbr.charAt(11)){
          return true;
        }else{ return false;}

    }else{
                if(awbNbr.substr(0,3)!='400') return false;
                else{
                    var remain=awbNbr.substr(3,7);
                    if((Number(remain)%7)==awbNbr.charAt(10)) return true;
                    else return false;
                }
	}
}

/*Ground traking number calculation process*/
function validaGndTrakNbr(trakNbr){
	var acum        = Number(0);
	var acum2       = Number(0);
	var acum3       = Number(0);
	var checkDigit  = Number(0);

	if(trakNbr.length < 15) return false;

    if(isNaN(trakNbr)) return false;
    //Starting with position 2, add digits in the even numbered positions:

    for(i=13;i>=0;i=i-2){
		acum = parseInt(acum) + parseInt(trakNbr.charAt(i));
	}
	//Multiply the result by three
    acum=acum*3;

    //Starting with position 3, sum the add numbered digits...
	for(i=12;i>=0;i=i-2){
		acum2 = parseInt(acum2) + parseInt(trakNbr.charAt(i));
	}
    //Add the two sums together...
    acum3 = acum + acum2;
    //Now substract this sum from the next highest multiple of ten...
    checkDigit = (((parseInt(acum3/10))+1)*10) - acum3;

    if(checkDigit==10) checkDigit=0;
    //The difference is teh check digit.
    if(checkDigit == parseInt(trakNbr.charAt(14))) return true;
    else return false;
}

function validaMod11(val){
        val=val.replace(/-/g,'');
	if(isNaN(val)) return false;

        var acum=Number(0);
	var weight=7;
	for(i=val.length-2;i>=0;i--){
			switch(weight){
				case 2: weight=3;break;
				case 3: weight=4;break;
				case 4: weight=5;break;
				case 5: weight=6;break;
				case 6: weight=7;break;
				case 7: weight=2;break;
			}
			acum=acum+val.charAt(i)*weight;
	}

	var veridigit=11-(acum%11);
	if(veridigit==10 || veridigit==11) veridigit=0;

	if(veridigit==val.charAt(val.length-1)) return true;
	else return false;
}


function validateUSDate( strValue ) {
  var objRegExp = /(\d{2})\/(\d{2})\/(\d{4})/gi

  //check to see if in correct format
  if(document.all && !objRegExp.test(strValue)){
    return false; //doesn't match pattern, bad date
  }else{

    var strSeparator = strValue.substring(2,3) //find date separator
    var arrayDate = strValue.split(strSeparator); //split date into month, day, year
   //create a lookup for months not equal to Feb.
    var arrayLookup = { '01' : 31 , '03' : 31 , '04' : 30 , '05' : 31 , '06' : 30 , '07' : 31 , '08' : 31 , '09' : 30 , '10' : 31 , '11' : 30 , '12' : 31};

    var intMonth = Number(arrayDate[0]);

    if(intMonth<1 || intMonth>12){
		return false;
    }

    var intDay = Number(arrayDate[1]);

    //check if month value and day value agree
    if(arrayLookup[arrayDate[0]] != null) {
      if(intDay <= Number(arrayLookup[arrayDate[0]]) && intDay != 0){
        return true; //found in lookup table, good date
      }
    }


    //check for February
    var intYear = Number(arrayDate[2]);
    if( ((intYear % 4 == 0 && intDay <= 29) || (intYear % 4 != 0 && intDay <=28)) && intDay !=0){
      return true; //Feb. had valid number of days
    }
  }

  return false;
}