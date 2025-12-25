<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="SDIDproject.Horaire, SDIDproject.Station, SDIDproject.Train" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AlBoraq Voyages</title>
    <link rel="stylesheet" href="voyageursstyle.css">
</head>
<body>
<header class="header">
    <div class="header-left">
        <img src="data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 200 50'%3E%3Ctext x='15' y='35' fill='white' font-family='Arial' font-size='18' font-weight='bold'%3EALBORAQ VOYAGES%3C/text%3E%3C/svg%3E" alt="ALBORAQ VOYAGES" class="logo">
    </div>
    <div class="header-right">
        <div class="language-selector">
            Fran&ccedil;ais
        </div>
        <a href="https://www.oncf-voyages.ma/espace-voyageurs" class="enterprise-space">
            Espace Voyageur
            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <rect x="2" y="7" width="20" height="14" rx="2"/>
                <path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"/>
            </svg>
        </a>
        <div class="user-controls">
            <button class="icon-button">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <circle cx="12" cy="8" r="4"/>
                    <path d="M20 21a8 8 0 1 0-16 0"/>
                </svg>
            </button>
            <button class="icon-button">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <circle cx="9" cy="21" r="1"/>
                    <circle cx="20" cy="21" r="1"/>
                    <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"/>
                </svg>
            </button>
        </div>
    </div>
</header>

<div class="container">
    <h1>Acheter mon billet</h1>
    <p class="intro-text">
        Pour mieux appr&eacute;cier vos voyages, l'ONCF met &agrave; votre disposition chaque jour et &agrave; tout moment de la journ&eacute;e des trains et des autocars vers vos destinations pr&eacute;f&eacute;r&eacute;es.
        <br>
        Ils d&eacute;servent toutes les villes du Royaume avec des trajets directs ou avec correspondances. R&eacute;servez vos billets sans tarder et pensez &agrave; anticiper vos achats pour b&eacute;n&eacute;ficier des meilleurs prix.
        <br>
        Bon voyage sur nos lignes !
    </p>

    <form id="bookingForm" action="voyageurshoraires" method="POST">
        <input type="hidden" id="numAdults" name="numAdults" value="1">
        <input type="hidden" id="numChildren" name="numChildren" value="0">
        <input type="hidden" name="departTime" value="${param.departTime}">
        <div class="form-group">
            <label class="form-label">Mon trajet<span class="required">*</span></label>
            <div class="form-row">
                <div class="input-group">
                    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                        <circle cx="12" cy="12" r="10"/>
                        <path d="M12 8v8m-4-4h8"/>
                    </svg>
                    <select id="departureStation" name="departureStation" onchange="updateDestinations()">
                        <option value="CASA VOYAGEURS" ${param.depart == 'CASA VOYAGEURS' ? 'selected' : ''}>CASA VOYAGEURS</option>
                        <option value="RABAT AGDAL" ${param.depart == 'RABAT AGDAL' ? 'selected' : ''}>RABAT AGDAL</option>
                        <option value="KENITRA" ${param.depart == 'KENITRA' ? 'selected' : ''}>KENITRA</option>
                        <option value="TANGER VILLE" ${param.depart == 'TANGER VILLE' ? 'selected' : ''}>TANGER VILLE</option>
                    </select>
                </div>
                <div class="input-group">
                    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                        <circle cx="12" cy="12" r="10"/>
                        <path d="M12 8v8"/>
                    </svg>
                    <select id="arrivalStation" name="arrivalStation">
                        <option value="TANGER VILLE" ${param.arrivee == 'TANGER VILLE' ? 'selected' : ''}>TANGER VILLE</option>
                        <option value="RABAT AGDAL" ${param.arrivee == 'RABAT AGDAL' ? 'selected' : ''}>RABAT AGDAL</option>
                        <option value="KENITRA" ${param.arrivee == 'KENITRA' ? 'selected' : ''}>KENITRA</option>
                        <option value="CASA VOYAGEURS" ${param.arrivee == 'CASA VOYAGEURS' ? 'selected' : ''}>CASA VOYAGEURS</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="form-group">
                <label class="form-label">Mes dates</label>
                <div class="form-row">
                    <div class="input-group">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                            <rect x="3" y="4" width="18" height="18" rx="2"/>
                            <path d="M16 2v4M8 2v4M3 10h18"/>
                        </svg>
                        <input type="date"
                               id="departDate"
                               name="departDate"
                               value="${not empty modele.dateChoisie ? modele.dateChoisie : param.departDate}">
                    </div>
                    <div class="input-group">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                            <rect x="3" y="4" width="18" height="18" rx="2"/>
                            <path d="M16 2v4M8 2v4M3 10h18"/>
                        </svg>
                        <input type="date" id="returnDate" name="returnDate" placeholder="Mon retour">
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="form-label">Je choisis mon confort</label>
            <div class="comfort-options">
                <label class="comfort-option">
                    <input type="radio" name="comfortClass" value="1re classe">
                    1re classe
                </label>
                <label class="comfort-option">
                    <input type="radio" name="comfortClass" value="2ème classe" checked>
                    2&egrave;me classe
                </label>
            </div>
        </div>

        <div class="form-row">
            <div class="wrapper">
                <label class="form-label">Je choisis le nombre de passagers</label>
                <div class="passenger-selector" onclick="togglePassengerModal()">
                    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                        <circle cx="12" cy="8" r="4"/>
                        <path d="M20 21a8 8 0 1 0-16 0"/>
                    </svg>
                    <div class="passenger-summary">1 Adulte</div>
                </div>

                <div class="passenger-modal" id="passengerModal">
                    <div class="passenger-info">
                        <div>
                            <div class="passenger-label">Adulte</div>
                            <div class="passenger-age">> 15 ans</div>
                        </div>
                        <div class="counter">
                            <button type="button" onclick="updatePassenger('adult', -1)" class="counter-btn minus"></button>
                            <span id="adultCount">1</span>
                            <button type="button" onclick="updatePassenger('adult', 1)" class="counter-btn plus"></button>
                        </div>
                    </div>
                    <div class="passenger-info">
                        <div>
                            <div class="passenger-label">Enfant</div>
                            <div class="passenger-age">< 15 ans</div>
                        </div>
                        <div class="counter">
                            <button type="button" onclick="updatePassenger('child', -1)" class="counter-btn minus"></button>
                            <span id="childCount">0</span>
                            <button type="button" onclick="updatePassenger('child', 1)" class="counter-btn plus"></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <button type="submit" class="search-button">
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" width="20" height="20">
                <circle cx="11" cy="11" r="8"/>
                <path d="M21 21l-4.35-4.35"/>
            </svg>
            Rechercher
        </button>
    </form>
</div>

<script>
    const MAX_PASSENGERS = 9;

    function togglePassengerModal() {
        const modal = document.getElementById('passengerModal');
        modal.classList.toggle('active');
    }
    
    function updateDestinations() {
        const departureStation = document.getElementById('departureStation').value;
        const arrivalStation = document.getElementById('arrivalStation');
        const allStations = ['CASA VOYAGEURS', 'RABAT AGDAL', 'KENITRA', 'TANGER VILLE'];

        // Clear existing options
        arrivalStation.innerHTML = '';

        // Add only stations that aren't the departure station
        allStations.forEach(station => {
            if (station !== departureStation) {
                const option = document.createElement('option');
                option.value = station;
                option.textContent = station;
                if(station === '${param.arrivee}') {
                    option.selected = true;
                }
                arrivalStation.appendChild(option);
            }
        });
    }

    function updatePassenger(type, change) {
        const countElement = document.getElementById(type + 'Count');
        let currentCount = parseInt(countElement.textContent);
        const newCount = currentCount + change;

        const minLimit = type === 'adult' ? 1 : 0;

        if (newCount >= minLimit && newCount <= MAX_PASSENGERS) {
            countElement.textContent = newCount;

            const minusButton = countElement.previousElementSibling;
            if (minusButton) {
                minusButton.disabled = newCount <= minLimit;
            }

            document.getElementById('numAdults').value = document.getElementById('adultCount').textContent;
            document.getElementById('numChildren').value = document.getElementById('childCount').textContent;

            updatePassengerSummary();
        }
    }

    function updatePassengerSummary() {
        const adultCount = parseInt(document.getElementById('adultCount').textContent);
        const childCount = parseInt(document.getElementById('childCount').textContent);
        const summaryElement = document.querySelector('.passenger-summary');

        let summary = [];
        if (adultCount > 0) {
            summary.push(`${adultCount} Adulte${adultCount > 1 ? 's' : ''}`);
        }
        if (childCount > 0) {
            summary.push(`${childCount} Enfant${childCount > 1 ? 's' : ''}`);
        }

        summaryElement.textContent = summary.join(', ');
    }

    // Close modal when clicking outside
    document.addEventListener('DOMContentLoaded', function() {
        updateDestinations();

        // Updated date handling
        const departDateInput = document.getElementById('departDate');
        const dateFromServer = '${modele.dateChoisie}' || '${param.departDate}';

        if (departDateInput && dateFromServer) {
            try {
                // Split the date string (expecting dd/mm/yyyy format)
                const [day, month, year] = dateFromServer.split('/');
                if (day && month && year) {
                    // Create the yyyy-mm-dd format required by the date input
                    const formattedDate = `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`;
                    departDateInput.value = formattedDate;
                }
            } catch (e) {
                console.error('Error formatting date:', e);
            }
        }

        // Rest of your initialization code remains the same
        const adultMinusButton = document.getElementById('adultCount').previousElementSibling;
        const childMinusButton = document.getElementById('childCount').previousElementSibling;

        if (adultMinusButton) {
            adultMinusButton.disabled = document.getElementById('adultCount').textContent <= 1;
        }
        if (childMinusButton) {
            childMinusButton.disabled = document.getElementById('childCount').textContent <= 0;
        }

        updatePassengerSummary();
    });
</script>
</body>
</html>