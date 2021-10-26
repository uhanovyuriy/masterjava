
package ru.javaops.masterjava.xml.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the temp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _City_QNAME = new QName("http://javaops.ru", "City");
    private final static QName _ProjectName_QNAME = new QName("http://javaops.ru", "ProjectName");
    private final static QName _GroupName_QNAME = new QName("http://javaops.ru", "GroupName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: temp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link Payload }
     * 
     */
    public Payload createPayload() {
        return new Payload();
    }

    /**
     * Create an instance of {@link GroupNameType }
     * 
     */
    public GroupNameType createGroupNameType() {
        return new GroupNameType();
    }

    /**
     * Create an instance of {@link Project.Groups }
     * 
     */
    public Project.Groups createProjectGroups() {
        return new Project.Groups();
    }

    /**
     * Create an instance of {@link Group.Users }
     * 
     */
    public Group.Users createGroupUsers() {
        return new Group.Users();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link ProjectNameType }
     * 
     */
    public ProjectNameType createProjectNameType() {
        return new ProjectNameType();
    }

    /**
     * Create an instance of {@link Payload.Cities }
     * 
     */
    public Payload.Cities createPayloadCities() {
        return new Payload.Cities();
    }

    /**
     * Create an instance of {@link Payload.Users }
     * 
     */
    public Payload.Users createPayloadUsers() {
        return new Payload.Users();
    }

    /**
     * Create an instance of {@link Payload.Projects }
     * 
     */
    public Payload.Projects createPayloadProjects() {
        return new Payload.Projects();
    }

    /**
     * Create an instance of {@link Payload.Groups }
     * 
     */
    public Payload.Groups createPayloadGroups() {
        return new Payload.Groups();
    }

    /**
     * Create an instance of {@link Payload.ProjectNames }
     * 
     */
    public Payload.ProjectNames createPayloadProjectNames() {
        return new Payload.ProjectNames();
    }

    /**
     * Create an instance of {@link Payload.GroupNames }
     * 
     */
    public Payload.GroupNames createPayloadGroupNames() {
        return new Payload.GroupNames();
    }

    /**
     * Create an instance of {@link CityType }
     * 
     */
    public CityType createCityType() {
        return new CityType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javaops.ru", name = "City")
    public JAXBElement<CityType> createCity(CityType value) {
        return new JAXBElement<CityType>(_City_QNAME, CityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectNameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javaops.ru", name = "ProjectName")
    public JAXBElement<ProjectNameType> createProjectName(ProjectNameType value) {
        return new JAXBElement<ProjectNameType>(_ProjectName_QNAME, ProjectNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GroupNameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javaops.ru", name = "GroupName")
    public JAXBElement<GroupNameType> createGroupName(GroupNameType value) {
        return new JAXBElement<GroupNameType>(_GroupName_QNAME, GroupNameType.class, null, value);
    }

}
