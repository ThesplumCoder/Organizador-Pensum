# ORGANIZADOR DE PENSUM UNIVERSITARIO
## Concepto
Este aplicación lo que nos permite es hacer la estructuración semestre por semestre de las materias que un estudiante va a matricular. Ayudando en los casos en que un estudiante pierda una materia y se atrase pueda pedir la reestructuración de esa planeación y saber a futuro como se va a ir desarrollando la matrícula de cada semestre.

## Limitaciones
+ No puede llevar un record histórico de las materias perdidas.
+ No tiene los horarios ni profesores encargados de cada materia.
+ Las estructuraciones no pueden especificar materias electivas porque estas dependen de cada semestre.
+ Las estructuraciones no pueden especificar materias de contexto porque estas son muy variadas.

## Modelo de datos
+ Materia
  + Nombre
  + Código
  + Créditos
  + Requisitos
+ Semestre
  + Número
  + Periodo