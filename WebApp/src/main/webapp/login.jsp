<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <link rel="stylesheet" href="login.css">
</head>
<body>
<div class="progress-bar">
  <div class="progress-line background"></div>
  <div class="progress-line completed"></div>
  <div class="progress-step">
    <div class="step-icon">1</div>
    <span class="step-text">Ma recherche</span>
  </div>
  <div class="progress-step">
    <div class="step-icon">2</div>
    <span class="step-text">Mon voyage</span>
  </div>
  <div class="progress-step">
    <div class="step-icon">✓</div>
    <span class="step-text">Mes coordonnées</span>
  </div>
  <div class="progress-step">
    <div class="step-icon">4</div>
    <span class="step-text">Ma confirmation</span>
  </div>
</div>
<div class="login-container">
  <h1>Je souhaite</h1>
  <div class="tabs">
    <button class="tab-btn active" onclick="switchTab(event, 'login-tab')">M'identifier</button>
    <button class="tab-btn" onclick="switchTab(event, 'register-tab')">Je crée mon compte</button>
  </div>

  <!-- Display error message if exists -->
  <c:if test="${not empty errorMessage}">
    <div class="error-message">${errorMessage}</div>
  </c:if>

  <!-- Login Form -->
  <div id="login-tab" class="tab-content active">
    <form action="loginAction" method="post">
      <label for="login-email">Email</label>
      <input type="email" id="login-email" name="email" placeholder="Enter your email" required>

      <label for="login-password">Mot de passe</label>
      <input type="password" id="login-password" name="password" placeholder="Enter your password" required>

      <!-- Hidden fields to pass id_horaire and price -->
      <input type="hidden" name="horaireId" value="${param.horaireId}">
      <input type="hidden" name="totalPrice" value="${param.totalPrice}">

      <button type="submit">Se connecter</button>
    </form>
  </div>

  <!-- Registration Form -->
  <div id="register-tab" class="tab-content">
    <form action="registerAction" method="post" onsubmit="return validateRegistrationForm()">
      <input type="hidden" name="horaireId" value="${param.horaireId}">
      <input type="hidden" name="totalPrice" value="${param.totalPrice}">

      <label for="register-first-name">Prénom</label>
      <input type="text" id="register-first-name" name="first-name" placeholder="Enter your first name" required>

      <label for="register-last-name">Nom</label>
      <input type="text" id="register-last-name" name="last-name" placeholder="Enter your last name" required>

      <label for="register-age">Âge</label>
      <input type="number" id="register-age" name="age" placeholder="Enter your age" required>

      <label for="register-email">Email</label>
      <input type="email" id="register-email" name="email" placeholder="Enter your email" required>

      <label for="register-phone">Numéro de téléphone</label>
      <input type="tel" id="register-phone" name="phone" placeholder="Enter your phone number" required>

      <button type="submit">Créer un compte</button>
    </form>
  </div>
</div>
<script>
  // JavaScript pour gérer les onglets
  function switchTab(event, tabId) {
    // Réinitialise les boutons actifs
    const buttons = document.querySelectorAll('.tab-btn');
    buttons.forEach(btn => btn.classList.remove('active'));

    // Cache tous les contenus des onglets
    const tabs = document.querySelectorAll('.tab-content');
    tabs.forEach(tab => tab.classList.remove('active'));

    // Active le bouton et l'onglet correspondant
    event.currentTarget.classList.add('active');
    document.getElementById(tabId).classList.add('active');
  }

  // Client-side validation for the registration form
  function validateRegistrationForm() {
    const firstName = document.getElementById('register-first-name').value.trim();
    const lastName = document.getElementById('register-last-name').value.trim();
    const age = document.getElementById('register-age').value.trim();
    const email = document.getElementById('register-email').value.trim();
    const phone = document.getElementById('register-phone').value.trim();
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!firstName || !lastName || !age || !email || !phone) {
      alert('Tous les champs sont obligatoires.');
      return false;
    }

    if (!emailPattern.test(email)) {
      alert('Veuillez entrer une adresse email valide.');
      return false;
    }

    return true;
  }
</script>
</body>
</html>