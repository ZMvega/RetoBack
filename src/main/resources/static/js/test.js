//FUNCIONES AFILIADOS
function leerLaboratorios(){
    $.ajax({
        url : 'http://localhost:8080/api/tests/all',
        type : 'GET',
        dataType : 'json',

        success : function(laboratorio){
            let items=laboratorio.items;
            $("#TbodyLab").empty();
            for(laboratorio of laboratorio) {
                let tablaLaboratorio = document.createElement("tr")
                tablaLaboratorio.innerHTML += "<td><center>"+laboratorio.name+"</center></td>";
                tablaLaboratorio.innerHTML += "<td><center>"+laboratorio.description+"</center></td>";

                tablaLaboratorio.innerHTML += "<td><button onclick='borrarLaboratorio(" + laboratorio.id + ")'>Borrar</button></tr>";

                $("#TbodyLab").append(tablaLaboratorio);
                //tablaAffiliates.append(tablaAffiliates)
            }
        }

    });
}

function guardarLaboratorio(){
    let name=$('#name').val();
    let description=$('#description').val();


    let data={
        name:name,
        description:description
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:8080/api/tests/sign-up',
        type : 'POST',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/json',

        success : function(disfraz){
            console.log(disfraz)
            $('#name').val("");
            $('#description').val("");
        },
        complete : function(){
            leerLaboratorios();
        }
    });
}



function borrarLaboratorio(id){
    let data={
        id:id
    };
    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:8080/api/tests/'+id,
        type : 'DELETE',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/JSON',

        success : function(borrando){
            $('#nombre').val("");
            $('#description').val("");
        },
        complete : function(){
            leerLaboratorios();
        }
    });
}