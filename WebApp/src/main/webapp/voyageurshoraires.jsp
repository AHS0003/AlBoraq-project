<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AlBoraq Voyages - Horaires</title>
    <link rel="stylesheet" href="voyageurshorairesstyles.css">
    <script src="voyageurshoraires.js" defer></script>
</head>
<body>
<div class="progress-bar">
    <div class="progress-line"></div>
    <div class="progress-step">
        <div class="step-icon">1</div>
        <span class="step-text">Ma recherche</span>
    </div>
    <div class="progress-step">
        <div class="step-icon">✓</div>
        <span class="step-text">Mon voyage</span>
    </div>
    <div class="progress-step">
        <div class="step-icon">3</div>
        <span class="step-text">Mes coordonnées</span>
    </div>
    <div class="progress-step">
        <div class="step-icon">4</div>
        <span class="step-text">Ma confirmation</span>
    </div>
</div>

<div class="journey-header">
    <h1 class="journey-title">${modele.gareDepart} > ${modele.gareArrivee}</h1>
    <p class="journey-subtitle">Deuxième Classe</p>
</div>

<div class="filter-buttons">
    <button class="filter-button active">Tous les trains</button>
</div>

<c:forEach items="${modele.horaires}" var="horaire">
    <div class="train-card" data-depart-time="${horaire.heureDepart}">
        <div class="train-info">
            <div class="departure-arrival">
                <div>
                    <div class="time">${horaire.heureDepart}</div>
                    <div class="station">${horaire.stationDepart.stationName}</div>
                </div>
                <div class="duration">
                    <div>${horaire.getDuration()}</div>
                    <div>Direct</div>
                </div>
                <div>
                    <div class="time">${horaire.heureArrive}</div>
                    <div class="station">${horaire.stationArrive.stationName}</div>
                </div>
            </div>
            <c:if test="${horaire.imminent}">
                <span class="immediate-departure">Départ imminent</span>
            </c:if>
        </div>
        <div class="price-section">
            <div>
                <div>Prix total</div>
                <div class="price">${horaire.totalPrice} DH</div>
            </div>
            <button class="reserve-button" onclick="reserveTrain(${horaire.id}, ${horaire.totalPrice});">Réserver</button>
        </div>
    </div>
</c:forEach>
<div class="cart-section">
    <div class="cart-icon">🛒</div>
    <h2>Mon panier</h2>
    <div class="cart-content">
        <p>Mon panier est vide.</p>
        <p>Montant total à payer : 0 DH</p>
    </div>
</div>
</body>
</html>