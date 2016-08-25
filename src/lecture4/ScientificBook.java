package lecture4;

import lecture2.Book;

/**
 * Created by mpividori on 24/08/16.
 */
public class ScientificBook extends Book {

    private String area;
    private boolean proceedings = false;

    public ScientificBook(String title, String author, int numOfPages, String[] topics, String ISBN, String area) {
        super(title, author, numOfPages, ISBN);
        this.area = area;
    }

    public ScientificBook(Book book, String area) {
        super(book);
        this.area = area;
    }

    public static boolean equals(Object o1, Object o2) {
        if (!Book.equals(o1, o2)) return false;
        if (!(o1 instanceof ScientificBook) || !(o2 instanceof ScientificBook) ) return false;

        ScientificBook sb1 = (ScientificBook) o1; ScientificBook sb2 = (ScientificBook) o2;
        if (!sb1.getArea().equals(sb2.getArea())) return false;
        return sb1.isProceedings() == sb2.isProceedings();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return ScientificBook.equals(this, o);
    }

    @Override
    public String toString() {
        return "Scientific" +
                super.toString().substring(0, super.toString().length() - 1) +
                ", area='" + area + '\'' +
                ", proceedings=" + proceedings + '\'' +
                '}';
    }

    public boolean superEquals(Book other) {
        return super.equals(other);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setProceedings() {
        this.proceedings = true;
    }

    public boolean isProceedings() {
        return proceedings;
    }
}
