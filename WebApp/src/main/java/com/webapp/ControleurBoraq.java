package com.webapp;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.mail.util.MailSSLSocketFactory;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Dao.ImplReservation;
import SDIDproject.*;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.stream.Collectors;

@WebServlet(name = "BoraqApp", urlPatterns = {
        "/acceuil", "/horaires", "/voyageursboraq", "/voyageurshoraires",
        "/registerAction", "/loginAction", "/ClientInfo", "/processPayment"
})
public class ControleurBoraq extends HttpServlet {
    private ImplReservation metier;

    @Override
    public void init() throws ServletException {
        metier = new ImplReservation();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Handle GET requests the same as POST requests
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        ModeleBoraq modele = new ModeleBoraq();

        try {
            switch (path) {
                case "/acceuil":
                    handleAcceuil(request, response, modele);
                    break;
                case "/horaires":
                    handleHoraires(request, response, modele);
                    break;
                case "/voyageursboraq":
                    handleVoyageursBoraq(request, response, modele);
                    break;
                case "/voyageurshoraires":
                    handleVoyageursHoraires(request, response, modele);
                    break;
                case "/registerAction":
                    handleRegister(request, response);
                    break;
                case "/loginAction":
                    handleLogin(request, response);
                    break;
                case "/ClientInfo":
                    handleClientInfo(request, response);
                    break;
                case "/processPayment":
                    handleProcessPayment(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "La page demandée est introuvable.");
                    break;
            }
        } catch (SQLException | CompartimentException e) {
            e.printStackTrace();
            modele.setErrorMessage("Une erreur est survenue lors de la récupération des données.");
            request.setAttribute("modele", modele);
            request.getRequestDispatcher("acceuil.jsp").forward(request, response);
        }
    }
       private void handleProcessPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, CompartimentException {
        try {
            // Retrieve payment details from the request parameters
            String nomPorteur = request.getParameter("nom_porteur");
            String numeroCarte = request.getParameter("numero_carte");
            String moisExpirationStr = request.getParameter("mois_expiration");
            String anneeExpirationStr = request.getParameter("annee_expiration");
            String codeVerification = request.getParameter("code_verification");

            // Retrieve hidden fields for id_horaire and price
            String idHoraireStr = request.getParameter("id_horaire");

            // Retrieve the session
            HttpSession session = request.getSession();

            // Retrieve the numAdults, numChildren, selectedClass, and date from the session
            int numAdults = (Integer) session.getAttribute("numAdults");
            int numChildren = (Integer) session.getAttribute("numChildren");
            String selectedClass = (String) session.getAttribute("selectedClass");
            String dateChoisie = (String) session.getAttribute("departDate");

            // Log each parameter to see if they are being passed correctly
            System.out.println("nomPorteur: " + nomPorteur);
            System.out.println("numeroCarte: " + numeroCarte);
            System.out.println("moisExpirationStr: " + moisExpirationStr);
            System.out.println("anneeExpirationStr: " + anneeExpirationStr);
            System.out.println("codeVerification: " + codeVerification);
            System.out.println("idHoraireStr: " + idHoraireStr);
            System.out.println("numAdults: " + numAdults);
            System.out.println("numChildren: " + numChildren);
            System.out.println("selectedClass: " + selectedClass);
            System.out.println("dateChoisie: " + dateChoisie);

            // Validate that all required fields are provided
            if (nomPorteur == null || nomPorteur.isEmpty() ||
                    numeroCarte == null || numeroCarte.isEmpty() ||
                    moisExpirationStr == null || moisExpirationStr.isEmpty() ||
                    anneeExpirationStr == null || anneeExpirationStr.isEmpty() ||
                    codeVerification == null || codeVerification.isEmpty() ||
                    idHoraireStr == null || idHoraireStr.isEmpty() ||
                    selectedClass == null || selectedClass.isEmpty() ||
                    dateChoisie == null || dateChoisie.isEmpty()) {
                logAndForwardError(request, response, "Tous les champs sont obligatoires.");
                return;
            }

            // Convert expiration date fields to integers
            int moisExpiration;
            int anneeExpiration;
            try {
                moisExpiration = Integer.parseInt(moisExpirationStr);
                anneeExpiration = Integer.parseInt(anneeExpirationStr);
            } catch (NumberFormatException e) {
                logAndForwardError(request, response, "La date d'expiration est invalide.");
                return;
            }

            // Validate card details by retrieving the card from the database
            CarteBancaire carteBancaire = metier.getCarteBancaireByNomPorteur(nomPorteur);
            if (carteBancaire == null || !carteBancaire.getNumeroCarte().equals(numeroCarte) ||
                    carteBancaire.getMoisExpiration() != moisExpiration || carteBancaire.getAnneeExpiration() != anneeExpiration ||
                    !carteBancaire.getCodeVerification().equals(codeVerification)) {
                logAndForwardError(request, response, "Détails de la carte invalides.");
                return;
            }

            // Convert hidden fields to appropriate types
            int idHoraire;
            try {
                idHoraire = Integer.parseInt(idHoraireStr);
            } catch (NumberFormatException e) {
                logAndForwardError(request, response, "Informations de réservation invalides.");
                return;
            }

            // Retrieve the email from session or request
            String email = (String) session.getAttribute("email");
            if (email == null) {
                email = request.getParameter("email"); // Get email from form if not logged in
            }

            // Log the email to check if it's being retrieved correctly
            System.out.println("email: " + email);

            // Retrieve the voyageur from the database using the email
            Voyageur voyageur = metier.recherchervoyageurByEmail(email);

            // Log details of the retrieved voyageur
            System.out.println("Voyageur: " + (voyageur != null ? voyageur.getNom() : "null"));

            // Retrieve the train and horaire details
            Horaire horaire = metier.getHoraireById(idHoraire); // Retrieve selected horaire from the database
            if (horaire == null) {
                logAndForwardError(request, response, "Horaire invalide.");
                return;
            }
            Train train = horaire.getTrain(); // Get the train associated with this horaire
            if (train == null) {
                logAndForwardError(request, response, "Train invalide.");
                return;
            }

            // Calculate prices
            double prixAdult = metier.AdultPrix(horaire.getStationDepart(), horaire.getStationArrive());
            double prixEnfant = metier.EnfantPrix(horaire.getStationDepart(), horaire.getStationArrive());

            // Apply class multiplier
            if ("1re classe".equals(selectedClass)) {
                prixAdult *= 1.2;  // 20% more expensive for first class
                prixEnfant *= 1.2;
            }

            // Generate tickets and send emails for each passenger
            int placeNumber = 1;
            int compartimentNumber = "1re classe".equals(selectedClass) ? 1 : 3;

            // Dans handleProcessPayment, modifiez l'appel à sendTicket pour inclure la date:
            // Dans la boucle des tickets:
            for (int i = 0; i < numAdults; i++) {
                sendTicket(voyageur, horaire, train, carteBancaire, prixAdult, selectedClass, email, "adult", placeNumber, compartimentNumber, dateChoisie);
                placeNumber++;
            }
            for (int i = 0; i < numChildren; i++) {
                sendTicket(voyageur, horaire, train, carteBancaire, prixEnfant, selectedClass, email, "child", placeNumber, compartimentNumber, dateChoisie);
                placeNumber++;
            }

            System.out.println("Payment has been successfully processed.");

            // Redirect to the success page
            response.sendRedirect("paymentSuccess.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            logAndForwardError(request, response, "Une erreur est survenue lors du traitement du paiement: " + e.getMessage());
        }
    }

      private void sendTicket(Voyageur voyageur, Horaire horaire, Train train, CarteBancaire carteBancaire, double prix, String selectedClass, String email, String passengerType,int placeNumber, int compartimentNumber, String dateChoisie) throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Add ticket details
            String billetID = String.valueOf(System.currentTimeMillis()) + "-" + placeNumber;
            document.add(new Paragraph("======= Ticket PDF =======\n" +
                    "Ticket #" + billetID +
                    "\nVoyageur: " + voyageur.getNom() +
                    "\nTrain: " + train.getTrainType() + train.getTrainID() +
                    "\nDu: " + horaire.getStationDepart().getStationName() + " A " + horaire.getStationArrive().getStationName() +
                    "\nDate de départ: " + dateChoisie +
                    "\nHeure de départ: " + horaire.getHeureDepart() +
                    "\nHeure d'arrivée: " + horaire.getHeureArrive() +
                    "\nCompartiment: " + compartimentNumber +
                    "\nPlace: " + placeNumber +
                    "\nPrix: " + prix + " DH\n" +
                    "=========================="));
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la génération du PDF: " + e.getMessage());
        } finally {
            document.close();
        }

        // Send the PDF to the user's email
        try {
            sendEmailWithAttachment(email, "Détail de la réservation",
                    "Veuillez trouver ci-joint les détails de votre réservation pour " +
                            passengerType + " #" + placeNumber + ".", baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de l'envoi de l'email: " + e.getMessage());
        }

        // Save the reservation in the database
        Reservation reservation = new Reservation(voyageur, train, horaire,
                new Compartiment(1, compartimentNumber), new Place(placeNumber),
                prix, carteBancaire, LocalDate.now());
        try {
            metier.ajouterreservation(reservation);
            System.out.println("Reservation added to database.");
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de l'ajout de la réservation dans la base de données: " + e.getMessage());
        }
    }

    private void logAndForwardError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        System.err.println(errorMessage);
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("paiement.jsp").forward(request, response);
    }

    private void sendEmailWithAttachment(String to, String subject, String body, byte[] attachment) throws Exception {
        String from = "boughaliothmane1@gmail.com";
        final String username = "boughaliothmane1@gmail.com";
        final String password = "cezd ppzc oxln pyzu"; // Replace with your actual app-specific password

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Create a MailSSLSocketFactory and set it to trust all hosts
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Add the PDF attachment
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(attachment, "application/pdf")));
            attachmentBodyPart.setFileName("ReservationDetails.pdf");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Sent message successfully with attachment....");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new Exception("Failed to send email: " + e.getMessage());
        }
    }
    private void handleRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Create a new Voyageur object
        Voyageur voyageur = new Voyageur(firstName + " " + lastName, email, phone, age);

        // Save the user to the database
        metier.ajouterVoyageur(voyageur);

        // Generate a password
        String password = generateVerificationCode(8);

        // Save the authentication details
        metier.ajouterauthentification(email, password);

        // Send an email to the user with the password
        sendEmail(email, "Account Created", "Your account has been successfully created. Your password is: " + password);

        HttpSession session = request.getSession();
        session.setAttribute("email", email);

        // Retrieve id_horaire and price from request parameters
        String idHoraire = request.getParameter("horaireId");
        String price = request.getParameter("totalPrice");

        // Store these values in the session to pass them to the next step
        session.setAttribute("id_horaire", idHoraire);
        session.setAttribute("price", price);

        response.sendRedirect("ClientInfo"); // Redirect to fetch client info
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check the login credentials
        boolean isAuthenticated = metier.verifierauthentification(email, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            // Retrieve id_horaire and price from request parameters
            String idHoraire = request.getParameter("horaireId");
            String price = request.getParameter("totalPrice");

            // Store these values in the session to pass them to the next step
            session.setAttribute("id_horaire", idHoraire);
            session.setAttribute("price", price);

            response.sendRedirect("ClientInfo"); // Redirect to fetch client info
        } else {
            // Redirect to the login page with an error message if not authenticated
            request.setAttribute("errorMessage", "Invalid email or password. Please create an account.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void handleClientInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if (email != null) {
            Voyageur voyageur = metier.recherchervoyageurByEmail(email);
            request.setAttribute("voyageur", voyageur);

            // Retrieve id_horaire and price from the session
            String idHoraire = (String) session.getAttribute("id_horaire");
            String price = (String) session.getAttribute("price");

            // Pass id_horaire and price as request attributes
            request.setAttribute("id_horaire", idHoraire);
            request.setAttribute("price", price);

            request.getRequestDispatcher("paiement.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private void sendEmail(String to, String subject, String body) {
        String from = "boughaliothmane1@gmail.com";
        final String username = "boughaliothmane1@gmail.com";
        final String password = "cezd ppzc oxln pyzu"; // Replace with your actual app-specific password

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        try {
            // Create a MailSSLSocketFactory and set it to trust all hosts
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.socketFactory", sf);

            Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String generateVerificationCode(int length) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    private void handleAcceuil(HttpServletRequest request, HttpServletResponse response, ModeleBoraq modele)
            throws ServletException, IOException, SQLException {
        ArrayList<Station> allStations = metier.affichertoutstations();
        modele.setStations(allStations);
        request.setAttribute("modele", modele);
        request.getRequestDispatcher("acceuil.jsp").forward(request, response);
    }

    private void handleHoraires(HttpServletRequest request, HttpServletResponse response, ModeleBoraq modele)
            throws ServletException, IOException, SQLException {
        String departure = request.getParameter("depart");
        String arrival = request.getParameter("arrivee");
        String departDate = request.getParameter("departDate");
        String departTime = request.getParameter("departTime");
        String returnDate = request.getParameter("returnDate");
        String tripType = request.getParameter("tripType");

        String formattedDepartDate = formatDateString(departDate);
        modele.setDateChoisie(formattedDepartDate);

        modele.setGareDepart(departure);
        modele.setGareArrivee(arrival);

        if (departure == null || arrival == null || departure.isEmpty() || arrival.isEmpty()) {
            modele.setErrorMessage("Veuillez sélectionner des stations de départ et d'arrivée.");
            ArrayList<Station> allStations = metier.affichertoutstations();
            modele.setStations(allStations);
            request.setAttribute("modele", modele);
            request.getRequestDispatcher("acceuil.jsp").forward(request, response);
            return;
        }

        ArrayList<Station> allStations = metier.affichertoutstations();
        Station departStation = null, arriveStation = null;
        for (Station station : allStations) {
            if (station.getStationName().equals(departure)) {
                departStation = station;
            }
            if (station.getStationName().equals(arrival)) {
                arriveStation = station;
            }
        }

        if (departStation == null || arriveStation == null) {
            modele.setErrorMessage("Les stations sélectionnées sont introuvables.");
            modele.setStations(allStations);
            request.setAttribute("modele", modele);
            request.getRequestDispatcher("acceuil.jsp").forward(request, response);
            return;
        }

        LinkedList<Horaire> departHoraires = metier.afficherhoraire(departStation, arriveStation);
        LinkedList<Horaire> filteredDepartHoraires = filterHorairesByDate(departHoraires, departDate);
        modele.setHoraires(filteredDepartHoraires);

        if ("roundTrip".equals(tripType) && returnDate != null && !returnDate.isEmpty()) {
            String formattedReturnDate = formatDateString(returnDate);
            LinkedList<Horaire> returnHoraires = metier.afficherhoraire(arriveStation, departStation);
            LinkedList<Horaire> filteredReturnHoraires = filterHorairesByDate(returnHoraires, returnDate);
            modele.setRetourHoraires(filteredReturnHoraires);
            modele.setRetourDateChoisie(formattedReturnDate);
        }

        if (filteredDepartHoraires.isEmpty()) {
            modele.setErrorMessage("Aucun horaire disponible pour cette sélection.");
        }

        request.setAttribute("modele", modele);
        request.getRequestDispatcher("horaires.jsp").forward(request, response);
    }
    private void handleVoyageursBoraq(HttpServletRequest request, HttpServletResponse response, ModeleBoraq modele)
            throws ServletException, IOException {
        String departure = request.getParameter("depart");
        String arrival = request.getParameter("arrivee");
        String departDate = request.getParameter("departDate");
        String departTime = request.getParameter("departTime");

        // Format the date if it exists
        if (departDate != null && !departDate.isEmpty()) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = inputFormat.parse(departDate);
                departDate = outputFormat.format(date);
            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
            }
        }

        // Set the date in the session
        HttpSession session = request.getSession();
        session.setAttribute("departDate", departDate);

        modele.setGareDepart(departure);
        modele.setGareArrivee(arrival);
        modele.setDateChoisie(departDate);

        request.setAttribute("departTime", departTime);
        request.setAttribute("departDate", departDate);
        request.setAttribute("modele", modele);
        request.getRequestDispatcher("voyageursboraq.jsp").forward(request, response);
    }
    private void handleVoyageursHoraires(HttpServletRequest request, HttpServletResponse response, ModeleBoraq modele)
            throws ServletException, IOException, SQLException {
        String departure = request.getParameter("departureStation");
        String arrival = request.getParameter("arrivalStation");
        String departDate = request.getParameter("departDate");
        String selectedClass = request.getParameter("comfortClass");

        // Set the date in the session
        HttpSession session = request.getSession();
        session.setAttribute("departDate", departDate);

        String numAdultsStr = request.getParameter("numAdults");
        String numChildrenStr = request.getParameter("numChildren");
        int numAdults = numAdultsStr != null ? Integer.parseInt(numAdultsStr) : 0;
        int numChildren = numChildrenStr != null ? Integer.parseInt(numChildrenStr) : 0;

        session.setAttribute("numAdults", numAdults);
        session.setAttribute("numChildren", numChildren);
        session.setAttribute("selectedClass", selectedClass);

        modele.setGareDepart(departure);
        modele.setGareArrivee(arrival);
        modele.setDateChoisie(departDate);

        if (departDate == null || departDate.isEmpty()) {
            modele.setErrorMessage("La date de départ est invalide.");
            request.setAttribute("modele", modele);
            request.getRequestDispatcher("acceuil.jsp").forward(request, response);
            return;
        }

        ArrayList<Station> allStations = metier.affichertoutstations();
        Station departStation = null, arriveStation = null;
        for (Station station : allStations) {
            if (station.getStationName().equals(departure)) {
                departStation = station;
            }
            if (station.getStationName().equals(arrival)) {
                arriveStation = station;
            }
        }

        if (departStation == null || arriveStation == null) {
            modele.setErrorMessage("Les stations sélectionnées sont introuvables.");
            modele.setStations(allStations);
            request.setAttribute("modele", modele);
            request.getRequestDispatcher("acceuil.jsp").forward(request, response);
            return;
        }

        LinkedList<Horaire> departHoraires = metier.afficherhoraire(departStation, arriveStation);
        LinkedList<Horaire> filteredDepartHoraires;
        try {
            filteredDepartHoraires = filterHorairesByDate(departHoraires, departDate);
        } catch (IllegalArgumentException e) {
            modele.setErrorMessage(e.getMessage());
            request.setAttribute("modele", modele);
            request.getRequestDispatcher("acceuil.jsp").forward(request, response);
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        // Parse departDate to LocalDate
        LocalDate horaireDate = LocalDate.parse(departDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for (Horaire horaire : filteredDepartHoraires) {
            LocalTime departureTime = horaire.getHeureDepart().toLocalTime();
            LocalDateTime departureDateTime = LocalDateTime.of(horaireDate, departureTime);

            // Check if the departure is imminent
            boolean isImminent = horaireDate.isEqual(today) && departureDateTime.isAfter(now) && departureDateTime.isBefore(now.plusMinutes(30));
            horaire.setImminent(isImminent);

            double prixAdult = metier.AdultPrix(departStation, arriveStation);
            double prixEnfant = metier.EnfantPrix(departStation, arriveStation);

            if ("1re classe".equals(selectedClass)) {
                prixAdult *= 1.2;
                prixEnfant *= 1.2;
            }

            double totalPrice = (numAdults * prixAdult) + (numChildren * prixEnfant);
            horaire.setTotalPrice(totalPrice);
        }

        modele.setHoraires(filteredDepartHoraires);

        if (filteredDepartHoraires.isEmpty()) {
            modele.setErrorMessage("Aucun horaire disponible pour cette sélection.");
        }

        request.setAttribute("modele", modele);
        request.getRequestDispatcher("voyageurshoraires.jsp").forward(request, response);
    }
    private boolean checkImminent(Horaire horaire) {
        LocalTime now = LocalTime.now();
        LocalTime departureTime = horaire.getHeureDepart().toLocalTime();
        return departureTime.isBefore(now.plusMinutes(30)) && departureTime.isAfter(now);
    }

    private String formatDateString(String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString.split("T")[0]);
            return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format for dateString: " + dateString, e);
        }
    }

    private LinkedList<Horaire> filterHorairesByDate(LinkedList<Horaire> horaires, String dateChoisie) {
        LocalDate chosenDate;
        try {
            if (dateChoisie.contains("T")) {
                chosenDate = LocalDate.parse(dateChoisie.split("T")[0]);
            } else {
                chosenDate = LocalDate.parse(dateChoisie);
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format for dateChoisie: " + dateChoisie, e);
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return horaires.stream()
                .filter(horaire -> {
                    LocalTime horaireTime = LocalTime.parse(horaire.getHeureDepart().toString(), timeFormatter);
                    LocalDateTime horaireDateTime = LocalDateTime.of(chosenDate, horaireTime);
                    return !horaireDateTime.isBefore(currentDateTime);
                })
                .collect(Collectors.toCollection(LinkedList::new));
    }
    @WebServlet("/login")
    public class LoginServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String firstName = request.getParameter("first-name");
            String lastName = request.getParameter("last-name");
            int age = Integer.parseInt(request.getParameter("age"));
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            // Process the login data (e.g., validate user, save user info, etc.)
            // For demonstration, we'll assume the login is always successful

            // Redirect to the payment page
            response.sendRedirect("payment.jsp");
        }
    }
}