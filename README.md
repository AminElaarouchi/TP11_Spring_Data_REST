# TP11 — Spring Data REST

Projet Maven Java 17 conforme au [TP11 du cours](https://mliaedu.toubkalit.com/student/courses/7/labs/165). Il expose des comptes bancaires et leurs clients avec Spring Data REST, JPA et H2.

## Démarrage

```bash
mvn spring-boot:run
```

Le serveur écoute sur `http://localhost:8082` et l'API commence à `/api`.

| Fonction | Exemple |
| --- | --- |
| Liste paginée et triée | `GET /api/comptes?page=0&size=2&sort=solde,desc` |
| Recherche par type | `GET /api/comptes/search/byType?t=EPARGNE` |
| Projection du solde | `GET /api/comptes/1?projection=solde` |
| Projection mobile | `GET /api/comptes/1?projection=mobile` |
| Relation client → comptes | `GET /api/clients/1/comptes` |
| Relation compte → client | `GET /api/comptes/1/client?projection=clientDetails` |

Les données de démonstration contiennent Amal et Ali, avec trois comptes. La console H2 est sur `/h2-console` (`jdbc:h2:mem:banque`, utilisateur `sa`, mot de passe vide).

## Vérification

```bash
mvn clean test
```

Le TP original utilise `javax.persistence`; ce projet utilise `jakarta.persistence` pour Spring Boot 3.
