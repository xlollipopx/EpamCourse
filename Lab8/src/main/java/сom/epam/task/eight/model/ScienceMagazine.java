package сom.epam.task.eight.model;

import javax.xml.bind.annotation.*;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "science-magazine")
public class ScienceMagazine extends Magazine{
    @XmlElement(name = "impact-factor", namespace = "http://www.example.com/papers", required = true)
    private int impactFactor;

    public ScienceMagazine() {}
    public ScienceMagazine(String id, String title, boolean monthly, String color, int pagesNumber, Type type,
                           boolean glossy, String publishingOffice, int impactFactor) {
        super(id, title, monthly, color, pagesNumber, type, glossy, publishingOffice);
        this.impactFactor = impactFactor;
    }

    public int getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(int impactFactor) {
        this.impactFactor = impactFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ScienceMagazine that = (ScienceMagazine) o;
        return impactFactor == that.impactFactor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), impactFactor);
    }

    @Override
    public String toString() {
        return "ScienceMagazine" + super.toString() +
                "impactFactor=" + impactFactor +
                '}';
    }

}
