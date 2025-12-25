<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&eacute;servation de Train</title>
    <link rel="stylesheet" href="acceuilstyle.css">
</head>
<body>
<header>
    <div class="header-container">
        <a href="/" class="logo">
            <img src="https://www.oncf.ma/var/oncf/storage/images/www-oncf-ma/actualites/horaires-al-boraq-special-aid-el-adha-1440/1125656-14-fre-FR/Horaires-al-boraq-special-aid-el-adha-1440.jpg" alt="Al Boraq" class="logo-img">
        </a>
        <nav class="header-nav">
            <ul class="nav-list">
                <li class="nav-item"><a href="https://siana.ma/" class="nav-link active">ACCUEIL</a></li>
                <li class="nav-item"><a href="https://siana.ma/presentation/" class="nav-link">SIANA</a></li>
                <li class="nav-item"><a href="https://siana.ma/rame-grande-vitesse-maroc/" class="nav-link">ACTIVIT&Eacute;S</a></li>
                <li class="nav-item"><a href="https://siana.ma/category/evenements/" class="nav-link">ACTUALIT&Eacute;S</a></li>
                <li class="nav-item"><a href="https://siana.ma/pourquoi-nous-rejoindre/" class="nav-link">CARRI&Egrave;RE</a></li>
                <li class="nav-item"><a href="https://siana.ma/contact/" class="nav-link">CONTACT</a></li>
            </ul>
        </nav>
    </div>
</header>
<div class="background-slider">
    <div class="slide" style="background-image: url('images/boraqm3almoghreb.jpg');"></div>
    <div class="slide" style="background-image: url('images/Rabat Agdal.jpg');"></div>
    <div class="slide" style="background-image: url('images/wiki wki.jpg');"></div>
    <div class="slide" style="background-image: url('images/lastOne.jpg');"></div>
    <div class="slide" style="background-image: url('images/6477884_al-boraq-2.webp');"></div>
    <div class="slide" style="background-image: url('images/Tanger Ville.jpg');"></div>
    <div class="slide" style="background-image: url('images/oncf.jpg');"></div>
    <div class="slide" style="background-image: url('images/OncfBoraq.jpg');"></div>
    <div class="slide" style="background-image: url('images/dascia-kenitra-tgv-detail-takuji.jpg');"></div>
</div>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const slides = document.querySelectorAll(".slide");
        let currentIndex = 0;

        function showNextSlide() {
            const currentSlide = slides[currentIndex];
            const nextIndex = (currentIndex + 1) % slides.length;
            const nextSlide = slides[nextIndex];

            // Définir les classes pour animer la transition
            currentSlide.classList.remove("active");
            currentSlide.classList.add("prev");
            nextSlide.classList.remove("next");
            nextSlide.classList.add("active");

            // Réinitialiser les classes après un petit délai
            setTimeout(() => {
                currentSlide.classList.remove("prev");
                currentSlide.classList.add("next");
            }, 1000);

            currentIndex = nextIndex;
        }

        // Initialisation
        slides[currentIndex].classList.add("active");

        // Lancer le slider toutes les 3 secondes
        setInterval(showNextSlide, 3000);
    });
</script>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        const allerSimpleRadio = document.querySelector('input[value="oneWay"]');
        const allerRetourRadio = document.querySelector('input[value="roundTrip"]');
        const returnDateGroup = document.getElementById('return-date-group');
        const returnDateInput = document.getElementById('return-date');

        allerSimpleRadio.addEventListener('change', function() {
            returnDateGroup.style.transform = 'translateY(50px)';
            returnDateGroup.style.opacity = '0';
            setTimeout(() => {
                returnDateGroup.style.display = 'none';
                returnDateInput.removeAttribute('required');
            }, 300);
        });

        allerRetourRadio.addEventListener('change', function() {
            returnDateGroup.style.display = 'block';
            setTimeout(() => {
                returnDateGroup.style.transform = 'translateY(0)';
                returnDateGroup.style.opacity = '1';
                returnDateInput.setAttribute('required', 'required');
            }, 50);
        });

        const stations = ["CASA VOYAGEURS", "RABAT AGDAL", "KENITRA", "TANGER VILLE"];
        const departSelect = document.getElementById('depart');
        const arriveeSelect = document.getElementById('arrivee');

        // Populate departure stations
        stations.forEach(station => {
            const option = document.createElement('option');
            option.value = station;
            option.textContent = station;
            departSelect.appendChild(option);
        });

        // Update arrival stations when departure is selected
        departSelect.addEventListener('change', function() {
            const selectedDepart = this.value;

            // Clear current arrival options
            arriveeSelect.innerHTML = '<option value="">Choisissez une gare</option>';

            // Add all stations except selected departure
            stations.forEach(station => {
                if (station !== selectedDepart) {
                    const option = document.createElement('option');
                    option.value = station;
                    option.textContent = station;
                    arriveeSelect.appendChild(option);
                }
            });
        });
    });
</script>
<main>
    <div class="hero-section">
        <div class="search-container">
            <h1>HORAIRES</h1>
            <form action="horaires" method="POST" class="search-form">
                <div class="form-row">
                    <div class="form-group">
                        <label for="depart">Gare de d&eacute;part</label>
                        <select id="depart" name="depart" required>
                            <option value="">Choisissez une gare</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="depart-date">D&eacute;part le</label>
                        <input type="datetime-local" id="depart-date" name="departDate" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="arrivee">Gare d'arriv&eacute;e</label>
                        <select id="arrivee" name="arrivee" required>
                            <option value="">Choisissez une gare</option>
                        </select>
                    </div>
                    <div class="form-group" id="return-date-group">
                        <label for="return-date">Retour le</label>
                        <input type="datetime-local" id="return-date" name="returnDate">
                    </div>
                </div>
                <div class="radio-group">
                    <label>
                        <input type="radio" name="tripType" value="roundTrip" checked>
                        Aller-Retour
                    </label>
                    <label>
                        <input type="radio" name="tripType" value="oneWay">
                        Aller simple
                    </label>
                </div>
                <button type="submit" class="search-button">RECHERCHER</button>
            </form>

        </div>
    </div>
</main>
</body>
</html>