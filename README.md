# Gestion des Employés

Application client lourd de gestion des ressources humaines développée en Java avec JavaFX, dans le cadre du BTS SIO option SLAM.

---

## Description

Application de bureau permettant à une agence web de gérer ses employés. Elle offre un CRUD complet, une authentification, une recherche avancée, ainsi que des fonctionnalités d'export et de visualisation statistique.

---

## Fonctionnalités

- **Authentification** : connexion sécurisée avec login et mot de passe
- **Gestion des employés** : ajout, modification, suppression et consultation
- **Fiche employé** : affichage détaillé avec photo de profil
- **Recherche** : recherche par texte sur tous les champs + filtre par département
- **Export CSV** : export de la liste des employés au format CSV
- **Diagramme** : visualisation statistique par civilité (PieChart)
- **Déconnexion** : retour à la page d'authentification

---

## Technologies utilisées

- **Java 17**
- **JavaFX 17** — interface graphique
- **SQLite** — base de données locale (via sqlite-jdbc 3.45.1.0)
- **Maven** — gestion des dépendances
- **IntelliJ IDEA** — environnement de développement
- **Git / GitHub** — gestion de versions

---

## Architecture du projet

```
src/main/java/ludmi/projet/
├── app/
│   └── Main.java                  # Point d'entrée de l'application
├── controller/
│   ├── AuthenticationController.java
│   ├── MainController.java
│   ├── AddEmployeController.java
│   ├── EditEmployeController.java
│   ├── FicheEmployeController.java
│   └── ChartController.java
├── model/
│   └── Employe.java               # Modèle de données
├── database/
│   └── DatabaseConnection.java    # Accès à la base de données SQLite
└── services/

src/main/resources/
├── fxml/                          # Vues JavaFX
├── css/                           # Feuilles de style
└── par_defaut.png                 # Image par défaut employé
```

---

## Base de données

Deux tables SQLite :

**`employe`**
| Colonne | Type |
|---|---|
| id | INTEGER PRIMARY KEY AUTOINCREMENT |
| prenom | TEXT |
| nom | TEXT |
| poste | TEXT |
| departement | TEXT |
| salaire | REAL |
| contrat | TEXT |
| dateRecrutement | TEXT |
| civilite | TEXT |
| image | TEXT |

**`user`**
| Colonne | Type |
|---|---|
| id | INTEGER PRIMARY KEY AUTOINCREMENT |
| user | TEXT UNIQUE |
| password | TEXT |

---

## Prérequis

- Java 17 ou supérieur
- Maven 3.x
- IntelliJ IDEA (recommandé)

---

## Installation

1. Cloner le dépôt :
```bash
git clone https://github.com/millazph9/gestion-employe.git
```

2. Ouvrir le projet dans IntelliJ IDEA

3. Laisser Maven télécharger les dépendances automatiquement

4. Lancer l'application via Maven :
```bash
mvn javafx:run
```

---

## Identifiants par défaut

| Login | Mot de passe |
|---|---|
| admin | admin10 |

---

## Auteur

**Ludmilla Zephir** — BTS SIO SLAM — Session 2026
