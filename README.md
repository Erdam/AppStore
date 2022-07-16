# AppStore

#### Bienvenido a AppStore.
Se quiere construir una aplicación para manejar un AppStore de juegos. 
Esta aplicación debe permitir manejar 4 juegos y contar con la posibilidad de compra y venta de licencias de los mismos.

Cada juego se caracteriza por tener:

- Nombre, que es único.
- Categoría a la que pertenece. Puede ser: rompecabezas, acción o deporte.
- Tamaño: memoria que ocupa en kilobytes (KB).
- Precio de la unidad en pesos.
- Cantidad de licencias disponibles.
- Cantidad de licencias vendidas.
- Imagen del juego.

Adicionalmente, el programa debe permitir calcular posibles descuentos para clientes que desean comprar licencias de juego en un volumen alto.
En este caso, debido a las políticas de ventas y mercadeo, las promociones vigentes son las siguientes:

1. Si el comprador solicita al menos 25 licencias de juegos de rompecabezas sin importar la cantidad de juegos que solicite de otras categorías,
se dará el 20% de descuento sobre el valor total del pedido.
2. Si el comprador solicita al menos 20 licencias de juegos de deportes y 15 licencias de juegos de acción, 
se dará el 15% de descuento sobre el valor total del pedido.
Si en una compra se cumplen ambas condiciones, sólo se aplica la primera promoción que aplique.

El programa debe permitir:

1. Visualizar la información detallada de cada juego.
2. Comprar licencias de un juego.
3. Vender licencias de un juego.
4. Consultar el juego más vendido.
5. Consultar los descuentos aplicados por un volumen de compra.


#### Requerimientos Funcionales
------------------------------------------------------------------------------------------------------
**Nombre** 
R1 – Visualizar la información detallada de cada juego.

**Resumen**

Permite visualizar la información (categoría, tamaño, precio, 
unidades disponibles, unidades vendidas e imágenes) de todos los juegos de la tienda.

**Entrada**

Ninguna

**Resultado** 

Se muestra la información detallada de cada uno de los juegos de la tienda.

------------------------------------------------------------------------------------------------------
**Nombre** R2 – Comprar licencias de un juego
**Resumen** Permite realizar la compra de una cantidad de licencias de un juego específico.
**Entrada**
Nombre del juego.
Cantidad de licencias a comprar.
**Resultado** La cantidad de licencia del juego aumenta en el número específico,
sí el juego no estaba disponible, vuelve a estarlo.

------------------------------------------------------------------------------------------------------
**Nombre** R3 – Vender licencias de un juego.
**Resumen** Permite realizar la venta de una cantidad de licencias de un juego específico.
**Entrada**
Nombre del juego.
Cantidad de licencias a vender.
**Resultado** En caso de tener una cantidad de licencias disponibles mayor o igual a las que se quieren vender,
se disminuye la cantidad de unidades del juego. Si la cantidad de licencias disponibles después de la venta queda en 0, 
el juego deja de estar disponible en la interfaz.
En caso de no tener una cantidad suficiente de licencias disponibles para la venta, no se realizará la venta.


------------------------------------------------------------------------------------------------------
**Nombre** R4 – Consultar el juego más vendido.
**Resumen**
Consultar cuál es el juego más vendido.
**Entrada**
Ninguna.
**Resultado** Nombre del juego con más licencias vendidas.
En el caso de que no se haya vendido ningún juego no se muestra nada.


------------------------------------------------------------------------------------------------------
**Nombre**
R5 – Consultar los descuentos aplicados por un volumen de compra.
**Resumen**
Calcula los descuentos que aplican para ventas de licencias dadas las cantidades de productos a comprar.
empresa. 
**Entrada**
Cantidad de licencias solicitadas del juego1.
Cantidad de licencias solicitadas del juego2.
Cantidad de licencias solicitadas del juego3.
Cantidad de licencias solicitadas del juego4.
**Resultado** Balance del pedido indicando precio total de la compra, valor del descuento y valor total de la compra con el descuento.


------------------------------------------------------------------------------------------------------

#### Directorio
    editor.md/
       	source/
            test/source/
       	data/
        	docs/
            specs/
                 doc/
                   Javadoc/
            api/
        ...
  [YouTube](https://www.youtube.com/user/MrDionicios/videos "youtube")      
