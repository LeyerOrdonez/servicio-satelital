* crei haber escrito esto ya pero aqui vamos*

# que es esto?
este repositorio es acerca del trabajo llamado "servicio satelital uceva" y aqui queda guardado el proyecto para este fin.
dicho lo anterior procedo a enseñar los entrypoint disponibles

# entrypoints

- http://3.82.128.42:8070/api/servicio-satelital/allData
  
  TYPE : GET
  
  RESULT: listado en formato json de todos los datos que han sido guardados.
  
  KEYS: NONE

  
- http://3.82.128.42:8070/api/servicio-satelital/saveData
  
  TYPE: POST
  
  RESULT: elemento en formato json que ha sido guardado
  
  KEYS: raw file en el cual se encuentre el json del dato a guardar con los argumentos:
  
        "name": "nombre del procesamiento",
        "description": "de que trata que sensores fueron usados",
        "ndwi_img": "imagen en formato {NONE} ",
        "ndti_link": "imagen en formato {NONE}",
        "area": "  area en metros cuadrados de la zona de estudio",
        "date_proccess": " fecha del procesamiento de la imagen en formato AAAA/MM/DD",
        "path_row_src": "locacion formato path and row ",
        "colored_image": "imagen en formato {NONE}"


- http://3.82.128.42:8070/api/servicio-satelital/deleteData/{SPECIALKEY}
  
  TYPE: DELETE
  
  RESULT: json con el elemento que ha sido eliminado
  
  SPECIALKEY: solo requiere el numero identificador del elemento a eliminar 

  
- http://3.82.128.42:8070/api/servicio-satelital/updateData
  
  TYPE: UPDATE
  
  RESULT: json con el elemento que ha sido modificado
  
  KEYS: requiere un raw cuyo contenido es exactamente el mismo del entrypoint [savedata]
  
- http://3.82.128.42:8070/api/servicio-satelital/searchDataById/{SPECIALKEY}
  
  TYPE: GET
  
  RESULT: un dato en formato json con la informacion del {SPECIALKEY}
  
  SPECIALKEY: un numero identificador que pertenece a la expreion regular {id:[0-9]+}
  
- http://3.82.128.42:8070/api/servicio-satelital/searchDataByName/{SPECIALKEY}
  
  TYPE: GET
  
  RESULT: un listado de datos json con las coincidencias parciales en el campo <name> comparado con el SPECIALKEY de la base de datos
  
  SPECIALKEY:  una palabra sin importar mayuscula o minuscula, que se quiera buscar en los nombres de la lista de elementos,  formato regular {name:[a-zA-Z ]+}

# convenciones
{NONE} : aun no he definido el nombre, formato o palabra que va aqui.

{SPECIALKEY} : elemento de vital uso en alguna funcion, url, etc. se describe inmediatamente cual es.

[cualquier palabra] : se está referenciando una palabra, actividad o funcion anterior.

<atr>: un atributo de lo eleemntos de la base de datos
