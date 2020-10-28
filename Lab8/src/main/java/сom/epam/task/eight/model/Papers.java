package сom.epam.task.eight.model;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "papers", namespace = "http://www.example.com/papers")
public class Papers {
    @XmlElements({
            @XmlElement(name = "magazine", namespace = "http://www.example.com/papers", type = Magazine.class),
            @XmlElement(name = "newspaper", namespace = "http://www.example.com/papers", type = NewsPaper.class),
            @XmlElement(name = "science-magazine", namespace = "http://www.example.com/papers", type = ScienceMagazine.class)})
    private List<Paper> papers = new LinkedList<Paper>();

    public Papers() {}

    public Papers(List<Paper> papers)
    {
        this.papers = papers;
    }

    @XmlTransient
    public List<Paper> getPapers() {
        return papers;
    }

    public void add(Paper paper) {
        papers.add(paper);
    }

}
