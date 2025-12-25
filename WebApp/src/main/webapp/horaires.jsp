<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="SDIDproject.Horaire, SDIDproject.Station, SDIDproject.Train" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="horairestyle.css">
  <title>Horaires</title>
</head>
<body>
<h1>Horaires des Trains</h1>

<div class="results-bar">
  <div class="info">
    <span>D&eacute;part le : ${modele.dateChoisie}</span>
  </div>
  <div class="info">
    Relation : <span class="highlight">${modele.gareDepart} - ${modele.gareArrivee}</span>
  </div>
</div>

<c:if test="${not empty modele.errorMessage}">
  <p style="color: red;">${modele.errorMessage}</p>
</c:if>

<c:if test="${not empty modele.horaires}">
  <table class="schedule-table">
    <thead>
    <tr>
      <th>D&eacute;part</th>
      <th>Arriv&eacute;e</th>
      <th>Service &agrave; bord</th>
      <th>Gamme</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="horaire" items="${modele.horaires}">
      <tr>
        <td>${horaire.heureDepart}</td>
        <td>${horaire.heureArrive}</td>
        <td><img src="images/clim.png" alt="Service à bord" class="icon"></td>
        <td>
          <c:choose>
            <c:when test="${horaire.train.trainType == 'TLR'}">
              <img src="images/tlr.png" alt="TLR" class="icon">
            </c:when>
            <c:otherwise>
              <img src="https://www.oncf.ma/images/icons/al%20boraq.png?v4.6" alt="Al Boraq" class="icon">
            </c:otherwise>
          </c:choose>
        </td>
        <td><a href="voyageursboraq?depart=${URLEncoder.encode(modele.gareDepart, 'UTF-8')}&arrivee=${URLEncoder.encode(modele.gareArrivee, 'UTF-8')}&departDate=${URLEncoder.encode(modele.dateChoisie, 'UTF-8')}&departTime=${URLEncoder.encode(horaire.heureDepart, 'UTF-8')}" class="buy-button">ACHETER EN LIGNE</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<c:if test="${not empty modele.retourHoraires}">
  <div class="results-bar">
    <div class="info">
      <span>Retour le : ${modele.retourDateChoisie}</span>
    </div>
    <div class="info">
      Relation : <span class="highlight">${modele.gareArrivee} - ${modele.gareDepart}</span>
    </div>
  </div>
  <table class="schedule-table">
    <thead>
    <tr>
      <th>D&eacute;part</th>
      <th>Arriv&eacute;e</th>
      <th>Service &agrave; bord</th>
      <th>Gamme</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="horaire" items="${modele.retourHoraires}">
      <tr>
        <td>${horaire.heureDepart}</td>
        <td>${horaire.heureArrive}</td>
        <td><img src="https://www.thedetailingmafia.com/assets/images/our-services/paint-protection/3.png" alt="Service à bord" class="icon"></td>
        <td>
          <c:choose>
            <c:when test="${horaire.train.trainType == 'TLR'}">
              <img src="images/tlr.png" alt="TLR" class="icon">
            </c:when>
            <c:otherwise>
              <img src="https://www.oncf.ma/images/icons/al%20boraq.png?v4.6" alt="Al Boraq" class="icon">
            </c:otherwise>
          </c:choose>
        </td>
        <td><a href="voyageursboraq?depart=${URLEncoder.encode(modele.gareArrivee, 'UTF-8')}&arrivee=${URLEncoder.encode(modele.gareDepart, 'UTF-8')}&departDate=${URLEncoder.encode(modele.retourDateChoisie, 'UTF-8')}&departTime=${URLEncoder.encode(horaire.heureDepart, 'UTF-8')}" class="buy-button">ACHETER EN LIGNE</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<c:if test="${empty modele.horaires && empty modele.retourHoraires}">
  <p>Aucun horaire disponible pour cette sélection.</p>
</c:if>
</body>
</html>