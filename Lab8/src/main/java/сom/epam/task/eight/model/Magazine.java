package сom.epam.task.eight.model;


import javax.xml.bind.annotation.*;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "magazine")
@XmlSeeAlso({ScienceMagazine.class})
public class Magazine extends Paper {
    @XmlElement(name = "glossy", namespace = "http://www.example.com/papers", required = true)
    private boolean glossy;
    @XmlElement(name = "publishing-office", namespace = "http://www.example.com/papers",  required = true)
    private String publishingOffice;

    public Magazine() {}
    public Magazine(String id, String title, boolean monthly, String color, int pagesNumber,
                    Type type, boolean glossy, String publishingOffice) {
        super(id, title, monthly, color, pagesNumber, type);
        this.glossy = glossy;
        this.publishingOffice = publishingOffice;
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    @Override
    public String toString() {
        return "Magazine" + super.toString() +
                "glossy=" + glossy +
                ", publishingOffice='" + publishingOffice + '\'' +
                " } ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Magazine magazine = (Magazine) o;
        return glossy == magazine.glossy &&
                publishingOffice.equals(magazine.publishingOffice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), glossy, publishingOffice);
    }
}

