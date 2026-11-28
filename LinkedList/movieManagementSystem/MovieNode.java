package LinkedList.movieManagementSystem;

public class MovieNode {
    String title;
    String director;
    int releaseYear;
    double rating;
    MovieNode prev;
    MovieNode next;

    public MovieNode(String title, String director, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.format("Title: %-20s | Director: %-18s | Year: %d | Rating: %.1f/10",
                title, director, releaseYear, rating);
    }
}