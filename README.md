🛍️ Supermercado La Florida - Sistema de Gestión de Productos 🛒

¡Bienvenido al sistema de gestión de productos del Supermercado La Florida!
Este programa en Java permite gestionar productos dentro de una tienda: agregar, eliminar, editar precios y visualizar información útil sobre ellos.

📋 Características principales
🔹 Menú interactivo por consola.
🔹 Registro detallado de productos.
🔹 Control de productos perecederos y vencidos.
🔹 Eliminación por ID único.
🔹 Visualización ordenada y clara.

⚙️ Tecnologías utilizadas

Java 17+

java.util.Scanner

java.time.LocalDate

Programación orientada a objetos (POO)

🚀 Cómo funciona

📌 Menú principal
Cuando ejecutas el programa, verás el siguiente menú:

markdown
Copiar
Editar

===== 👋Bienvenido al Supermercado La Florida👋 =====

¿Qué quieres hacer?: 
  1. ➕ Agregar producto al sistema
  2. ➖ Eliminar producto del sistema por ID
  3. 💱 Editar Precio
  4. 👀 Mostrar la lista de productos agregados
  5. ❌ Salir del sistema


1️⃣ Agregar producto
Al agregar un producto, se solicita:

ID 🆔

Nombre ✍️

Proveedor 🚚

Categoría ℹ️

Descripción 🗣️

Fotografías 📷🖼️

Precio 💲

Cantidad en bodega 📦

📅 Fecha de ingreso (se registra automáticamente)

🍎 ¿Es perecedero?

Si sí, se solicita la fecha de vencimiento.

Si la fecha ya pasó, el producto se marcará como ⚠️ VENCIDO.



2️⃣ Eliminar producto
Muestra todos los productos con su ID.

Solicita el ID del producto a eliminar.

Si el ID es válido, se elimina ✅.

Si no existe, se muestra un error ❌.



3️⃣ Editar precio
Permite cambiar el precio de un producto:

Muestra productos con número y precio actual.

Solicita número del producto y nuevo precio.

Aplica el cambio directamente ✅.



4️⃣ Mostrar productos
Imprime todos los productos agregados con la siguiente información:

📄 Nombre, ID, descripción, categoría, proveedor

📅 Fecha de ingreso y vencimiento

📦 Cantidad y precio

⚠️ Estado del producto: VENCIDO o Vigente



🧠 Lógica destacada
✅ Verificación automática de vencimiento
Cuando se registra un producto perecedero, el sistema compara la fecha de vencimiento con la actual (LocalDate.now()) y marca si ya está vencido.

java
Copiar
Editar
this.vencido = fechaVencimiento.isBefore(LocalDate.now());
✅ Perecederos sin vencimiento → no permitido
Solo los productos marcados como perecederos tienen una fecha de vencimiento.
