# ObligatorioSO
Segunda Entrega
Se nos ha contratado para realizar un planificador de corto plazo para un sistema operativo servidor que se instalará en un servidor de mediano porte. 
Pero antes de comenzar el desarrollo, se nos pide que generemos una simulación del mismo como para poderla evaluar su comportamiento. Esto es con el objetivo de validar si el diseño es correcto para este servidor. 
Para que la evaluación del planificador sea lo más realista posible, se nos pide que el mismo contemple (entre otras cosas): 

* Poder ingresar la cantidad de procesadores o cores.
* Poder modificar la cantidad de tiempo que los procesos se encuentran en CPU.
* Poder modificar la prioridad de los mismos en tiempo de ejecución (prioridad de 1 a 99).
* Poder bloquear un proceso en cualquier momento.
* Poder cargar (de alguna forma) múltiples procesos de un solo ingreso
* Poder insertar procesos ya sea del S.O. como de usuario indicando:
* Tiempo total de ejecución
* Cada qué tiempo realiza una E/S (periódica sin modificación)
* Tiempo en que espera por la E/S (puede ser diferente para cada proceso).


En todo momento se deberá visualizar lo siguiente: (enums)
*	Proceso ejecutando en CPU (o en CPUs)
*	Lista de los procesos listos indicando el orden en que ingresaran a CPU.
*	Lista de los procesos bloqueados (indicando si se encuentra bloqueado por el usuario o por una entrada salida) ordenada en cada momento por quien sería el próximo a ser desbloqueado.


Qué entregar?

Se deberá entregar un informe no más de 60 páginas, indicando cada paso que se ha realizado indicando el porqué del mismo. Es decir, justificando cada acción realizada.

Se deberá justificar cada aspecto que el planificador tome en consideración para evaluar quien será el próximo a procesar. 

Entregables: El presente trabajo deberá ser entregado conjuntamente con el 1) informe del análisis, 2) discusión, 3) documentación de la solución propuesta incluido un 4) pseudocódigo, y la 5) demostración que se lograron los resultados esperados, con las 6) conclusiones que le merezca. Los entregables deberán ser subidos a la webasignatura. 


