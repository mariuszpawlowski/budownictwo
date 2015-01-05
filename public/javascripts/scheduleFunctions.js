// JavaScript Document



function setCheckboxes(){
	document.getElementById("srodowiskoPrawomocnaRow").style.display = 'none';
	document.getElementById("mapaZasadniczaRow").style.display = 'none';
	document.getElementById("zapewnienieDostawRow").style.display = 'none';
	document.getElementById("WZDLCPRow").style.display = 'none';
	  
	var ins = document.getElementsByTagName('input');
	for (var i=0; i<ins.length; i++) {
		if (ins[i].getAttribute('type') == 'checkbox') ins[i].checked = true;
	}
	document.getElementById("srodowiskoPrawomocnaCheckBox").checked = false;
	document.getElementById("mapaZasadniczaCheckBox").checked = false;
	document.getElementById("zapewnienieDostawCheckBox").checked = false;
	document.getElementById("WZDLCPCheckBox").checked = false;
}

