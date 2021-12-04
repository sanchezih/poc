## Questionados

***Questionados*** es una API basada en un conocido juego de preguntas y respuestas, que tiene las siguientes funcionalidades:

1. Cargar categorías y preguntas. Cada pregunta corresponde solo a una categoría y se crea con sus respuestas, de las cuales sólo una es correcta.
2. Traer todas las categorías y todas las preguntas, así como una categoría o una pregunta específicas.
3. Verificar si una respuesta determinada es correcta, conociendo el ID de la respuesta y el ID de la pregunta a la cual corresponde.
4. Traer una pregunta de forma aleatoria.
5. Eliminar una categoría específica.

#### Tecnologías y herramientas utilizadas

1. Java 11
2. Spring Boot
3. Hibernate
4. MySQL

#### Deploy (con Heroku)

https://questionados-api.herokuapp.com/

#### Esquema de la base de datos

![EsquemaQuestionados](https://user-images.githubusercontent.com/79877606/140368878-530aa1a4-c107-46f2-9aa6-a84a1cf2d4a2.png)
