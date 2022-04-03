# DATABASE

Database H2 is generated in memory 

to connect the database LOCAL:
http://localhost:8080/seaLife/h2-console (url: jdbc:h2:mem:sealifedb;username: sa;password: [empty])


## SWAGGER 

http://localhost:8080/seaLife/swagger-ui/index.html




## COMMENTAIRES

Bonjour,

Après plusieurs tentatives échouées d'intégrer angular au projet, j’ai du arrêter.

L’idée était de générer un client avec path d’entrée, la création d’une fiche d’observation, avec pour espèce 
et qualité d’identification en dropdown.

Pour le backend, pour une possible évolution de l’application, ajouter des validateurs afin de vérifier 
si certains champs sont rempli ou non selon l’espèce et si c’est un banc de poissons.

Intégrer un sort et Pageable pour la liste des fiches dans la recherche.

Ainsi d’un nouvel endpoint pour récupérer la liste des animaux pour le critère de recherche.

J’ai créé l’application sur base d’un « DB First » une DB H2 in memory (à voir ci dessus pour les crédentials) avec,
une génération des dtos grâce à l’openAPi.

J’ai utilisé le feingClient pour l’api des ilôts. J’ai ajouté le nom de l’ilôt dans la base de donnée lors 
que la création de la fiche pour une question de performance dans les appels du client externe.

Si la recherche nécessite, dans une future évolution du projet, un filtrage sur d’autres champs. Il 
serait intéressant d’utiliser QueryDsl, cela permet de travailler sur base d’un criteriaBuilder.

Evidement, une étape importante serait aussi d'ajouter des unitTest et mocker les services externes

Bonne journée 

