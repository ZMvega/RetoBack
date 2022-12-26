//FUNCIONES AFILIADOS
function leerAfiliados(){
    $.ajax({
        url : 'http://localhost:8080/api/affiliates/all',
        type : 'GET',
        dataType : 'json',

        success : function(afiliados){
            let items=afiliados.items;
            $("#TbodyAfiliados").empty();
            for(afiliados of afiliados) {
                let tablaAffiliates = document.createElement("tr")
                tablaAffiliates.innerHTML += "<td><center>"+afiliados.name+"</center></td>";
                tablaAffiliates.innerHTML += "<td><center>"+afiliados.age+"</center></td>";
                tablaAffiliates.innerHTML += "<td><center>"+afiliados.email+"</center></td>";

                tablaAffiliates.innerHTML += "<td><button onclick='borrarAfiliado(" + afiliados.id + ")'>Borrar</button></tr>";

                $("#TbodyAfiliados").append(tablaAffiliates);
                //tablaAffiliates.append(tablaAffiliates)
            }
        }

    });
}

function guardarAfiliado(){
    let nombre=$('#name').val();
    let age=$('#age').val();
    let email=$('#email').val();


    let data={
        name:name,
        age:age,
        email:email
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:8080/api/affiliates/sign-up',
        type : 'POST',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/json',

        success : function(disfraz){
            console.log(disfraz)
            $('#name').val("");
            $('#email').val("");
            $('#age').val("");
        },
        complete : function(){
            leerAfiliados();
        }
    });
}



function borrarAfiliado(id){
    let data={
        id:id
    };
    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:8080/api/affiliates/'+id,
        type : 'DELETE',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/JSON',

        success : function(borrando){
            $('#nombre').val("");
            $('#age').val("");
            $('#email').val("");
        },
        complete : function(){
            leerAfiliados();
        }
    });
}