# Tasca S5.01 Spring boot API rest + Aplicació web

**Descripció:**

En aquesta tasca faràs un CRUD (Create, Read, Update, Delete) que pugui ser cridat com a API Rest i, també, com aplicació web.

Aprendràs a usar correctament els verbs HTTP i a gestionar els codis de resposta.

## NIVELL 1: Exercici aplicació Web CRUD amb MySQL

Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot amb les següents característiques:

![Nivell 1](https://github.com/AnnaSantasusana/Tasca-S5.01/blob/main/Imatges/Captura%20de%20pantalla%202023-03-27%20a%20les%2019.38.08.png)

Tenim una entitat anomenada Sucursal, que disposa de les següents propietats:

-    Integer pk_SucursalID

-    String nomSucursal

-    String paisSucursal

També tenim una DTO anomenada SucursalDTO, que tindrà les mateixes propietats que l’entitat Sucursal, afegint-ne una:

-    String tipusSucursal

Aquesta propietat, en funció del país de la sucursal, haurà d’indicar si és “UE” o “Fora UE”. Per a fer això, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> països), amb els països que formen part de la UE.

Aprofitant l’especificació JPA, hauràs de persistir l’entitat Sucursal a una base de dades MySql, seguint el patró MVC.

    El consell és que SucursalDTO la facis servir al Controller y la Vista, i Sucursal al Repository. La capa de serveis serà l’encarregada de fer la traducció entre les dues.

Per a això, depenent del package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:


         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository

La classe ubicada al paquet controllers (SucursalController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

        http://localhost:9000/sucursal/add

        http://localhost:9000/sucursal/update

        http://localhost:9000/sucursal/delete/{id}

        http://localhost:9000/sucursal/getOne/{id}

        http://localhost:9000/sucursal/getAll

Com pots veure, a l’arxiu application.properties, hauràs de configurar que el port a utilitzar sigui el 9000.

La vista haurà d’estar desenvolupada amb Thymeleaf.

Per tal de fer-la més atractiva, pots usar opcionalment alguna llibreria CSS que t’ho faciliti, com bootstrap, tailwind, material, etc.

## NIVELL 2: Exercici API Rest CRUD amb MySQL

Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot amb les següents característiques:

![Captura de pantalla 2023-03-27 a les 19.51.58.png](/Users/annasantasusanaberch/Repositoris/Respositori_Tasca_S5.01/Imatges/Captura de pantalla 2023-03-27 a les 19.51.58.png)

Tenim una entitat anomenada FlorEntity, que disposa de les següents propietats:

-    Integer pk_FlorID

-    String nomFlor

-    String paisFlor

També tenim una DTO anomenada FlorDTO, que tindrà les mateixes propietats que l’entitat Sucursal, afegint-ne una:

-    String tipusFlor.

Aquesta propietat, en funció del país d'origen de la flor, haurà d’indicar si és “UE” o “Fora UE”. Per a fer això, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> països), amb els països que formen part de la UE.

Aprofitant l’especificació JPA, hauràs de persistir l’entitat FlorEntity a una base de dades MySQL, seguint el patró MVC.

El consell és que FlorDTO la facis servir al Controller, i FlorEntity al Repository. La capa de serveis serà l’encarregada de fer la traducció entre les dues.

Per a això, depenent del package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository

La classe ubicada al paquet controllers (FlorController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

        http://localhost:9001/flor/add

        http://localhost:9001/flor/update

        http://localhost:9001/flor/delete/{id}

        http://localhost:9001/flor/getOne/{id}

        http://localhost:9001/flor/getAll

Com pots veure, a l’arxiu application.properties, hauràs de configurar que el port a usar sigui el 9001.

**Important:**

Hauràs de tenir en compte les bones pràctiques de disseny de les API, fent servir correctament els codis d'error i les respostes en cas d'invocacions incorrectes. (Pots consultar informació sobre ResponseEntity).

Has d’incloure swagger perquè quasevol desenvolupador/a pugui tenir una idea ràpida dels recursos de que disposa l’API.

## NIVELL 3: Exercici API Rest connectada a una altra API Rest

Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot amb les següents característiques:

![Captura de pantalla 2023-03-27 a les 19.57.14.png](/Users/annasantasusanaberch/Repositoris/Respositori_Tasca_S5.01/Imatges/Captura de pantalla 2023-03-27 a les 19.57.14.png)

Fent servir RestTemplate o WebClient, t’hauràs de connectar a l’API que has fet al nivell 2, per cridar i testar totes les peticions que permet aquesta API.

Tingues en compte, que en aquesta tasca del nivell 3, no tens cap referència a cap base de dades, ni necessites fer servir JPA, ja que el teu repositori accedirà a l’API del nivell 2.

No et cal crear una Vista, perquè aquest nivell 3 està previst com una API Rest, però hauràs de crear totes les capes fins al controlador com qualsevol altra aplicació:

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.controllers

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.domain

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.dto

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.services

         cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.repository

La classe controladora, haurà de ser capaç d’atendre les següents peticions:

        http://localhost:9002/flor/clientFlorsAdd

        http://localhost:9002/flor/clientFlorsUpdate

        http://localhost:9002/flor/clientFlorsDelete/{id}

        http://localhost:9002/flor/clientFlorsGetOne/{id}

        http://localhost:9002/flor/clientFlorsAll

Com pots veure, a l’arxiu application.properties, hauràs de configurar que el port a usar sigui el 9002.

Per a provar el nivell 3, hauràs de tenir en marxa l’API del nivell 2. No tindràs problemes, ja que l’API del nivell 3 treballa amb el port 9002 i la del nivell 2 amb el port 9001.

**Important:**

Has d’incloure swagger perquè quasevol desenvolupador/a pugui tenir una idea ràpida dels recursos de que disposa l’API.