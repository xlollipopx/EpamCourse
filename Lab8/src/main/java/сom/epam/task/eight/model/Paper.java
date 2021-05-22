package сom.epam.task.eight.model;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Paper")
@XmlSeeAlso({Magazine.class, NewsPaper.class})
public abstract class Paper {
    @XmlAttribute(required = true)
    @XmlID
    private String id;
    @XmlElement(namespace = "http://www.example.com/papers", required = true)
    private String title;
    @XmlElement(namespace = "http://www.example.com/papers", required = true)
    private boolean monthly;
    @XmlElement(namespace = "http://www.example.com/papers", required = true)
    private String color;
    @XmlElement(name = "pages-number", namespace = "http://www.example.com/papers", required = true)
    private int pagesNumber;
    @XmlElement(namespace = "http://www.example.com/papers", required = true)
    private Type type;

    public Paper() {}
    public Paper(String id, String title, boolean monthly, String color, int pagesNumber, Type type) {
        this.id = id;
        this.title = title;
        this.monthly = monthly;
        this.color = color;
        this.pagesNumber = pagesNumber;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Paper paper = (Paper) o;
        return monthly == paper.monthly &&
                pagesNumber == paper.pagesNumber &&
                id.equals(paper.id) &&
                title.equals(paper.title) &&
                color.equals(paper.color) &&
                type == paper.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, monthly, color, pagesNumber, type);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", monthly=" + monthly +
                ", color='" + color + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", type=" + type + " ";
    }
}
