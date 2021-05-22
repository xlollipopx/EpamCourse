package сom.epam.task.eight.model;

import javax.xml.bind.annotation.*;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "news-paper")
public class NewsPaper extends Paper {
    @XmlElement(name = "subscription-index", namespace = "http://www.example.com/papers", required = true)
    private int subscriptionIndex;

    public NewsPaper() {}
    public NewsPaper(String id, String title, boolean monthly, String color, int pagesNumber, Type type, int subscriptionIndex) {
        super(id, title, monthly, color, pagesNumber, type);
        this.subscriptionIndex = subscriptionIndex;
    }

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(int subscriptionIndex) {
        this.subscriptionIndex = subscriptionIndex;
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
        NewsPaper newsPaper = (NewsPaper) o;
        return subscriptionIndex == newsPaper.subscriptionIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subscriptionIndex);
    }

    @Override
    public String toString() {
        return "NewsPaper" + super.toString() +
                "subscriptionIndex=" + subscriptionIndex +
                '}';
    }

}
