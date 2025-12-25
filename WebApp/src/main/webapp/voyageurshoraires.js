document.addEventListener('DOMContentLoaded', () => {
    const trainCards = document.querySelectorAll('.train-card');

    trainCards.forEach(card => {
        const departTimeString = card.getAttribute('data-depart-time');
        const departTime = new Date(`1970-01-01T${departTimeString}Z`);

        const now = new Date();
        const timeDifference = (departTime - now) / 60000; // Time difference in minutes

        if (timeDifference > 0 && timeDifference <= 15) {
            const imminentSpan = document.createElement('span');
            imminentSpan.classList.add('immediate-departure');
            imminentSpan.textContent = 'Départ imminent';
            card.querySelector('.train-info').prepend(imminentSpan);
        }
    });
});

// Filter functionality
document.querySelector('.filter-button').addEventListener('click', () => {
    document.querySelectorAll('.train-card').forEach(card => {
        card.style.display = 'block';
    });
});

// Search functionality
const searchInput = document.querySelector('.search-input');
searchInput.addEventListener('input', (e) => {
    const searchTerm = e.target.value.toLowerCase();
    const trainCards = document.querySelectorAll('.train-card');

    trainCards.forEach(card => {
        const stations = card.querySelectorAll('.station');
        const matchesSearch = Array.from(stations).some(station =>
            station.textContent.toLowerCase().includes(searchTerm)
        );
        card.style.display = matchesSearch ? 'block' : 'none';
    });
});

// Reservation functionality
function reserveTrain(horaireId, totalPrice) {
    console.log("reserveTrain called with horaireId:", horaireId, "Total Price:", totalPrice);

    // Redirect to login.jsp with total price and horaireId in the query string
    window.location.href = `login.jsp?horaireId=${horaireId}&totalPrice=${totalPrice}`;
}

function updateCart(cartInfo) {
    // Update cart display
    const cartSection = document.querySelector('.cart-section');
    if (cartInfo.items.length > 0) {
        cartSection.innerHTML = `
            <div class="cart-icon">🛒</div>
            <h2>Mon panier</h2>
            ${cartInfo.items.map(item => `
                <div class="cart-item">
                    <p>${item.journey}</p>
                    <p>${item.price} DH</p>
                </div>
            `).join('')}
            <p>Montant total à payer : ${cartInfo.total} DH</p>
        `;
    } else {
        cartSection.innerHTML = `
            <div class="cart-icon">🛒</div>
            <h2>Mon panier</h2>
            <p>Mon panier est vide</p>
            <p>Montant total à payer : 0 DH</p>
        `;
    }
}

function calculatePrice() {
    const adultCount = parseInt(document.getElementById('adultCount').textContent);
    const childCount = parseInt(document.getElementById('childCount').textContent);
    const isFirstClass = document.querySelector('input[name="comfortClass"][value="1re classe"]').checked;

    // Get base prices from data attributes or AJAX call
    let adultBasePrice = parseFloat(document.getElementById('adultPrice').value);
    let childBasePrice = parseFloat(document.getElementById('childPrice').value);

    // Apply first class multiplier if needed
    if (isFirstClass) {
        adultBasePrice *= 1.2;  // 20% more expensive for first class
        childBasePrice *= 1.2;
    }

    const totalPrice = (adultCount * adultBasePrice) + (childCount * childBasePrice);

    // Update display
    document.querySelector('.price').textContent = `${totalPrice.toFixed(2)} DH`;
    document.getElementById('totalPrice').value = totalPrice;
}

// Add event listeners
document.querySelectorAll('input[name="comfortClass"]').forEach(radio => {
    radio.addEventListener('change', calculatePrice);
});