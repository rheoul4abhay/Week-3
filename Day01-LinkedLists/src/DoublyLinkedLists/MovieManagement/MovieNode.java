package DoublyLinkedLists.MovieManagement;

public class MovieNode {
    private String title;
    private String director;
    private int yearOfRelease;
    private String rating;
    MovieNode prev, next;

    public MovieNode(String title, String director, int yearOfRelease, String rating){
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = this.prev = null;
    }

    //Getters
    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public int getYearOfRelease(){
        return yearOfRelease;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String newRating){
        rating = newRating;
    }
}
