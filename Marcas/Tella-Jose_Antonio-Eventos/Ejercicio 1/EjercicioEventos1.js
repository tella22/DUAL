function cambiar(name){
    var element = document.getElementById(name);
    var link = document.getElementById(name + "Link");


    if(element.style.display != 'none'){
        element.style.display="none";
        link.textContent = 'Mostrar Contenidos';
    }else {
        element.style.display="inline";
        link.textContent = 'Ocultar Contenidos';
    }
}