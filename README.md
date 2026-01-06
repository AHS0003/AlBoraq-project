# 🚅 AL BORAQ - Application de Réservation de Trains

**Al Boraq** est une application web basée sur l'architecture Jakarta EE, conçue pour la gestion et la réservation de billets de train. Ce projet a été développé dans un cadre académique  pour mettre en pratique les concepts de développement logiciel et d'architecture MVC.

L'application offre une solution complète allant de la recherche d'itinéraires à la génération de billets PDF, en passant par une simulation de paiement sécurisée.

## 📋 Table des Matières
- [Fonctionnalités](#-fonctionnalités)
- [Architecture Technique](#-architecture-technique)
- [Conception (UML)](#-conception-uml)
- [Installation et Déploiement](#-installation-et-déploiement)

## 🚀 Fonctionnalités

L'application répond aux besoins essentiels d'un système de billetterie ferroviaire moderne :

* **Espace Voyageur** : Création de compte, authentification et gestion du profil utilisateur.
* **Recherche Avancée** : Sélection des gares de départ/arrivée, dates et type de trajet (Aller simple ou Aller-retour).
* **Réservation de Billets** :
    * Sélection des horaires et consultation des tarifs.
    * Choix de la classe (1ère ou 2ème) et du nombre de passagers.
    * Gestion en temps réel de la disponibilité des places.
* **Paiement Sécurisé** : Interface de simulation de paiement par carte bancaire avec vérification des données.
* **Billetterie PDF** : Génération automatique et visualisation du ticket de transport après validation.
* **Administration** : Gestion des données de référence (Trains, Stations, Horaires) via le Back-end.

## 🛠 Architecture Technique

Le projet repose sur une architecture **MVC (Modèle-Vue-Contrôleur)** rigoureuse, assurant la séparation entre la logique métier, l'accès aux données et l'interface utilisateur.

### Stack Technologique
* **Langage** : Java.
* **Web Framework** : Jakarta EE (Servlets, JSP).
* **Serveur d'Application** : Apache Tomcat.
* **Base de Données** : MySQL.
* **Accès aux Données** : JDBC (Pattern DAO).
* **Gestion de Projet** : Maven.
* **Frontend** : HTML5, CSS3, JSP.

### Structure du Projet
* **Couche WEB** : Contrôleurs (Servlets) et Vues (JSP) pour l'interaction utilisateur.
* **Couche MÉTIER** : Classes représentant la logique applicative (`Train`, `Reservation`, `AlBoraq`).
* **Couche DAO** : Gestion de la persistance et des interactions SQL.

## 📊 Conception (UML)

La modélisation du système s'appuie sur les diagrammes standards :
* **Diagramme de Cas d'Utilisation** : Cartographie des interactions acteurs-système.
* **Diagramme de Classes** : Structure des entités (`Voyageur`, `Billet`, `Trajet`, `CarteBancaire`, etc.).

## ⚙️ Installation et Déploiement

Pour exécuter le projet sur un environnement local :

1.  **Prérequis** :
    * JDK (Java Development Kit) 11+.
    * Apache Tomcat (v9 ou v10).
    * MySQL Server.
    * Maven.

2.  **Configuration** :
    * Clonez le dépôt GitHub.
    * Créez une base de données MySQL locale nommée `Gestion_Reservation`.
    * Configurez la connexion JDBC dans le fichier `src/Dao/dbconnexion.java` avec vos identifiants locaux.

3.  **Lancement** :
    * Compilez le projet : `mvn clean install`.
    * Déployez le fichier `.war` généré sur votre serveur Tomcat.
    * Accédez à l'application via : `http://localhost:8080/Al-Boraq/acceuil`.

---

© 2025 Projet Al Boraq - Tous droits réservés.

