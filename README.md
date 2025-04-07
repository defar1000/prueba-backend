# Prueba Back End

## Enunciado de la prueba

### Franquicias

Se requiere construir un API para manejar una lista de franquicias. Una franquicia se compone por un nombre y un listado de sucursales y, a su vez, una sucursal está compuesta por un nombre y un listado de productos ofertados en la sucursal. Un producto se compone de un nombre y una cantidad de stock.

#### Criterios de Aceptación

1. El proyecto debe ser desarrollado en Spring Boot.
2. Exponer endpoint para agregar una nueva franquicia.
3. Exponer endpoint para agregar una nueva sucursal a una franquicia.
4. Exponer endpoint para agregar un nuevo producto a una sucursal.
5. Exponer endpoint para eliminar un nuevo producto a una sucursal.
6. Exponer endpoint para modificar el stock de un producto.
7. Exponer endpoint que permita mostrar cual es el producto que más stock tiene por sucursal para una franquicia puntual. Debe retornar un listado de productos que indique a que sucursal pertenece.
8. Utilizar sistemas de persistencia de datos como Redis, MySql, MongoDB, Dynamo en algún proveedor de Nube. Queda abierto a libre escogencia.

#### Puntos extra

+ Plus si se empaqueta la aplicación con Docker.
+ Plus si utiliza programación funcional. Reactiva. Queda abierto a libre escogencia.
+ Plus si se expone endpoint que permita actualizar el nombre de una franquicia.
+ Plus si se expone endpoint que permita actualizar el nombre de una sucursal.
+ Plus si se expone endpoint que permita actualizar el nombre de un producto.
+ Plus si se aprovisiona la persistencia de datos con Infraestructura como código como Terraform, Cloudformation, etc. Queda a libre escogencia.
+ Plus si toda la solución se despliega en la nube.

#### Notas Importantes:

+ Se tendrá en cuenta el flujo de trabajo usando git, la prueba debe ser presentada en algún repositorio de código con acceso público, por ejemplo: GitHub, BitBucket, etc.
+ Se debe incluir documentación que permita entender como desplegar la aplicación desde un entorno local. Se sugiere utilizar un archivo README.md.

## Como desplegar

La aplicación puede ser desplegada con docker siguiendo los siguientes pasos:

1. Construir la imagen de la aplicación:
        
    Estando en la raíz del proyecto ejecutar

        docker build -t prueba-backend -f src/main/java/co/com/prueba/deployment/Dockerfile .
2. Ejecutar contenedores:

   Mediante docker-compose se ejecuta tanto la base de datos mongo, como la aplicación, para esto ejecutar

         cd src/main/java/co/com/prueba/deployment
      
   y luego
            
         docker-compose up -d

3. Se puede verificar la ejecución de los dos contenedores ejecutando

        docker ps