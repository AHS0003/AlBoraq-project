<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Demande de Paiement</title>
  <link rel="stylesheet" href="stylepaiement.css">
  <script>
    // Script pour afficher la date et l'heure actuelles
    function afficherDateEtHeure() {
      const options = {
        weekday: 'long',
        month: 'long',
        day: 'numeric',
        year: 'numeric',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit',
      };

      const maintenant = new Date();
      const dateHeure = maintenant.toLocaleDateString('fr-FR', options);

      document.getElementById('date-heure').textContent = dateHeure;
    }

    window.onload = afficherDateEtHeure;
  </script>
</head>
<body>
<div class="progress-bar">
  <div class="progress-line"></div>
  <div class="progress-step">
    <div class="step-icon">1</div>
    <span class="step-text">Ma recherche</span>
  </div>
  <div class="progress-step">
    <div class="step-icon">2</div>
    <span class="step-text">Mon voyage</span>
  </div>
  <div class="progress-step">
    <div class="step-icon">3</div>
    <span class="step-text">Mes coordonnées</span>
  </div>
  <div class="progress-step">
    <div class="step-icon">✓</div>
    <span class="step-text">Ma confirmation</span>
  </div>
</div>

<div class="container">
  <h1>Demande de paiement</h1>
  <p class="date" id="date-heure"></p> <!-- La date et l'heure seront insérées ici -->
  <div class="content">
    <!-- Section de paiement -->
    <div class="section payment-details">
      <h2>Détail de paiement</h2>
      <form action="processPayment" method="post">
        <div class="payment-method">
          <label>Méthode de paiement :</label>
          <div>
            <input type="radio" id="card" name="payment" checked>
            <label for="card">Carte bancaire</label>
          </div>
          <img src="images/png-clipart-mastercard-mastercard.png" alt="Visa & Mastercard">
        </div>
        <label>Nom du porteur de la carte</label>
        <input type="text" name="nom_porteur" placeholder="Nom complet" required>

        <label>Numéro de carte de paiement</label>
        <input type="text" name="numero_carte" placeholder="Numéro de la carte" required>

        <label>Date d'expiration</label>
        <div class="expiry-date">
          <select name="mois_expiration" required>
            <option value="01">01</option>
            <option value="02">02</option>
            <option value="03">03</option>
            <option value="04">04</option>
            <option value="05">05</option>
            <option value="06">06</option>
            <option value="07">07</option>
            <option value="08">08</option>
            <option value="09">09</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
          </select>
          <select name="annee_expiration" required>
            <option value="2025">2025</option>
            <option value="2026">2026</option>
            <option value="2027">2027</option>
            <option value="2028">2028</option>
          </select>
        </div>

        <label>Code de vérification</label>
        <input type="text" name="code_verification" placeholder="CVV" required>

        <div class="terms">
          <input type="checkbox" name="terms" required>
          <label>J'ai lu et accepté <a href="#">les conditions générales d'utilisation</a>.</label>
        </div>

        <!-- Hidden fields to pass id_horaire and price -->
        <input type="hidden" name="id_horaire" value="${id_horaire}">
        <input type="hidden" name="price" value="${price}">
        <input type="hidden" name="classe" value="${classe}">
        <input type="hidden" name="numAdults" value="${numAdults}">
        <input type="hidden" name="numChildren" value="${numChildren}">
        <button type="submit">Payer</button>
      </form>
    </div>
    <!-- Section de droite -->
    <div class="section order-details">
      <h2>Détail de la commande</h2>
      <p><strong>Identifiant :</strong> 4E77...</p>
      <p><strong>Montant :</strong> <c:out value="${price}"/> DH</p>

      <h2>Détail Marchand</h2>
      <p><strong>Nom du marchand :</strong> ONCF (600000298)</p>

      <h2>Informations du Client</h2>
      <p><strong>Nom :</strong> <c:out value="${voyageur.nom}"/></p>
      <p><strong>Âge :</strong> <c:out value="${voyageur.age}"/></p>
      <p><strong>Tél :</strong> <c:out value="${voyageur.numero}"/></p>
      <p><strong>E-mail :</strong> <c:out value="${voyageur.email}"/></p>
    </div>
    <!-- Success message display -->
    <c:if test="${not empty successMessage}">
      <div class="success-message">${successMessage}</div>
    </c:if>

    <!-- Error message display -->
    <c:if test="${not empty errorMessage}">
      <div class="error-message">${errorMessage}</div>
    </c:if>
  </div>
</div>
</body>
</html>