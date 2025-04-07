package com.application;

import java.util.*;

abstract class Movie {
    private String title;
    private int availableSeats;

    public Movie(String title, int seats) {
        this.title = title;
        this.availableSeats = seats;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() throws Exception {
        if (availableSeats <= 0) {
            throw new Exception("No seats available!");
        }
        availableSeats--;
    }

    public void cancelSeat() {
        availableSeats++;
    }

    public abstract double getPrice();

    public String toString() {
        return title + " | Seats: " + availableSeats + " | Price: ₹" + getPrice();
    }
}

class RegularMovie extends Movie {
    public RegularMovie(String title, int seats) {
        super(title, seats);
    }

    public double getPrice() {
        return 150.0;
    }
}

class PremiumMovie extends Movie {
    public PremiumMovie(String title, int seats) {
        super(title, seats);
    }

    public double getPrice() {
        return 250.0;
    }
}

class Booking {
    private String userName;
    private Movie movie;

    public Booking(String userName, Movie movie) {
        this.userName = userName;
        this.movie = movie;
    }

    public String getUserName() {
        return userName;
    }

    public Movie getMovie() {
        return movie;
    }

    public String toString() {
        return userName + " booked: " + movie.getTitle();
    }
}

class BookingSystem {
    private List<Movie> movies = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public BookingSystem() {
        movies.add(new RegularMovie("Spiderman", 5));
        movies.add(new PremiumMovie("URI:The Surgical Strike", 3));
        movies.add(new RegularMovie("Jawan", 4));
    }

    public void showMovies() {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
    }

    public void bookTicket(int movieIndex, String userName) {
        if (userName.trim().isEmpty()) {
            System.out.println("Name is required to book a ticket.");
            return;
        }
        try {
            Movie movie = movies.get(movieIndex - 1);
            movie.bookSeat();
            bookings.add(new Booking(userName, movie));
            System.out.println("Ticket booked for " + movie.getTitle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelBooking(String userName) {
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getUserName().equalsIgnoreCase(userName)) {
                Movie m = bookings.get(i).getMovie();
                m.cancelSeat();
                bookings.remove(i);
                System.out.println("Booking canceled for " + userName);
                return;
            }
        }
        System.out.println("No booking found for user: " + userName);
    }

    public void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings made yet.");
        } else {
            for (Booking b : bookings) {
                System.out.println(b);
            }
        }
    }
}

class NotificationThread extends Thread {
    public void run() {
        try {
            Thread.sleep(30000);
            System.out.println("\nTip: You can check for new releases every Friday!");
        } catch (InterruptedException e) {
        }
    }
}

public class MovieBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingSystem system = new BookingSystem();

        NotificationThread notifyThread = new NotificationThread();
        notifyThread.setDaemon(true);
        notifyThread.start();

        while (true) {
            System.out.println("\n--- Movie Ticket Booking ---");
            System.out.println("1. View Movies\n2. Book Ticket\n3. Cancel Ticket\n4. View Bookings\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    system.showMovies();
                    break;
                case 2:
                    system.showMovies();
                    System.out.print("Enter movie number: ");
                    int movieIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    system.bookTicket(movieIndex, name);
                    break;
                case 3:
                    System.out.print("Enter your name to cancel: ");
                    String cancelName = sc.nextLine();
                    system.cancelBooking(cancelName);
                    break;
                case 4:
                    system.showBookings();
                    break;
                case 5:
                    System.out.println("Thank you for using Movie Booking App!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
