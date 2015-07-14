package com.pb.sawdust.geography;

/**
 * The {@code GeographyElement} is a simple {@code GeographicElement} implementation which uses a string for its identifier.
 *
 * @author crf
 *         Started 10/17/11 10:56 AM
 */
public class NamedGeographyElement extends AbstractGeographyElement<String> {

    /**
     * Constructor specifying the name, size, and description for the element.
     *
     * @param name
     *        The element's name (identifier).
     *
     * @param size
     *        The element's size.
     *
     * @param description
     *        The element's description.
     */
    public NamedGeographyElement(String name, double size, String description) {
        super(name,size,description);
    }

    /**
     * Constructor specifying the identifier and size for the element. An empty string will be used for the description.
     *
     * @param name
     *        The element's name (identifier).
     *
     * @param size
     *        The element's size.
     */
    public NamedGeographyElement(String name, double size) {
        this(name,size,"");
    }
}