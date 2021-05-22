package сom.epam.task.eight.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "type")
@XmlEnum
public enum  Type {
    @XmlEnumValue("MAGAZINE")
    MAGAZINE,
    @XmlEnumValue("NEWSPAPER")
    NEWSPAPER,
    @XmlEnumValue("BOOKLET")
    BOOKLET
}
