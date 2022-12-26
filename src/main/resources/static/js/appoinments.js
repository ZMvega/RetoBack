//FUNCIONES CITAS
function leerCitas(){
    $.ajax({
        url : 'http://localhost:8080/api/appoinments/all',
        type : 'GET',
        dataType : 'json',

        success : function(citas){
            let items=citas.items;
            $("#TbodyCitas").empty();
            for(citas of citas) {
                let tablaCitas = document.createElement("tr")
                tablaCitas.innerHTML += "<td><center>"+citas.date+"</center></td>";
                tablaCitas.innerHTML += "<td><center>"+citas.hour+"</center></td>";
                tablaCitas.innerHTML += "<td><center>"+citas.idAffiliate.name+"</center></td>";
                tablaCitas.innerHTML += "<td><center>"+citas.idTest.name+"</center></td>";

                tablaCitas.innerHTML += "<td><button onclick='borrarCita(" + citas.id + ")'>Borrar</button></tr>";

                $("#TbodyCitas").append(tablaCitas);
                //tablaAffiliates.append(tablaAffiliates)
            }
        }

    });
}

function guardarCitas(){
    let date=$('#date').val();
    let hour=$('#hour').val();
    let idTest=$('#idTest').val();
    let idAffiliate=$('#idAffiliate').val();


    let data={
        date:date,
        hour:hour,
        idTest:idTest,
        idAffiliate:idAffiliate
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:8080/api/appoinments/sign-up',
        type : 'POST',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/json',


        success : function(disfraz){
            console.log(disfraz)
            $('#date').val("");
            $('#hour').val("");
            $('#idTest').val("");
            $('#idAffiliate').val("");
        },
        complete : function(){
            leerCitas();
        }
    });
}



function borrarCita(id){
    let data={
        id:id
    };
    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:8080/api/appoinments/'+id,
        type : 'DELETE',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/JSON',

        success : function(borrando){
            $('#date').val("");
            $('#hour').val("");
            $('#idAffiliate').val("");
            $('#idTest').val("");
        },
        complete : function(){
            leerCitas();
        }
    });
}