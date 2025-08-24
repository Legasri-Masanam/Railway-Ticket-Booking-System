# Railway-Ticket-Booking-System
The Railway Ticket Booking System is a Java console application that manages ticket booking, cancellation, RAC, and waiting list. It simulates real railway reservations using OOP concepts in a simple way.
A console-based Railway Ticket Booking System in Java using OOPs and SOLID principles. It supports booking, cancellation, RAC, and Waiting List management.

✨ Features

Booking with berth preferences (auto-allocation if not available).

RAC & Waiting List promotion on cancellation.

Unique Ticket IDs for every passenger.

View All Bookings with confirmed, RAC, and WL details.

🏗️ Class Design

Passenger → Stores passenger details.

TicketSystem → Manages berths, RAC, WL, booking & cancellation.

⚙️ How It Works

If berth available → Confirmed.

Else → RAC.

Else → WL.

Cancellation → RAC promoted to confirmed, WL promoted to RAC.

🚀 Run Instructions
javac Passenger.java TicketSystem.java Main.java
java Main
