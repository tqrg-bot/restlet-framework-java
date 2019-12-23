/**
 * Copyright 2005-2019 Talend
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * https://restlet.talend.com/
 * 
 * Restlet is a registered trademark of Talend S.A.
 */

import java.util.List;

import org.restlet.data.MediaType;
import org.restlet.data.Preference;
import org.restlet.data.Reference;
import org.restlet.ext.odata.Query;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

<#list entityContainer.entities?sort as entitySet>
import ${entitySet.type.fullClassName};
</#list>

<#compress>
/**
 * Generated by the generator tool for the OData extension for the Restlet framework.<br>
 * 
<#if metadata.metadataRef??> * @see <a href="${metadata.metadataRef}">Metadata of the target OData service</a></#if>
 * 
 */
</#compress>

public class ${className} extends org.restlet.ext.odata.Service {

    /**
     * Constructor.
     * 
     */
    public ${className}() {
        super("${dataServiceUri}");
    }

<#list entityContainer.entities as entitySet>
    <#assign type=entitySet.type>
    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(${type.fullClassName} entity) throws Exception {
        <#if entityContainer.defaultEntityContainer>addEntity("/${entitySet.name}", entity);<#else>addEntity("/${entityContainer.name}.${entitySet.name}", entity);</#if>
    }

    /**
     * Creates a query for ${type.normalizedName} entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<${type.fullClassName}> create${type.className}Query(String subpath) {
        return createQuery(subpath, ${type.fullClassName}.class);
    }

    <#if (type.blob && type.blobValueRefProperty?? && type.blobValueRefProperty.name??)>
    /**
     * Returns the binary representation of the given media resource.
     * 
     * @param entity
     *            The given media resource.
     * @return The binary representation of the given media resource.
     */
    public Representation getValue(${type.fullClassName} entity) throws ResourceException {
        Reference ref = getValueRef(entity);
        if (ref != null) {
            ClientResource cr = createResource(ref);
            return cr.get();
        }

        return null;
    }

    /**
     * Returns the binary representation of the given media resource.
     * 
     * @param entity
     *            The given media resource.
     * @param acceptedMediaTypes
     *            The requested media types of the representation.
     * @return The given media resource.
     */
    public Representation getValue(${type.fullClassName} entity,
            List<Preference<MediaType>> acceptedMediaTypes)
            throws ResourceException {
        Reference ref = getValueRef(entity);
        if (ref != null) {
            ClientResource cr = createResource(ref);
            cr.getClientInfo().setAcceptedMediaTypes(acceptedMediaTypes);
            return cr.get();
        }

        return null;
    }

    /**
     * Returns the binary representation of the given media resource.
     * 
     * @param entity
     *            The given media resource.
     * @param mediaType
     *            The requested media type of the representation
     * @return The given media resource.
     */
    public Representation getValue(${type.fullClassName} entity, MediaType mediaType)
            throws ResourceException {
        Reference ref = getValueRef(entity);
        if (ref != null) {
            ClientResource cr = createResource(ref);
            return cr.get(mediaType);
        }

        return null;
    }

    /**
     * Returns the reference of the binary representation of the given entity.
     * 
     * @param entity
     *            The media resource.
     * @return The reference of the binary representation of the given entity.
     */
    public Reference getValueRef(${type.fullClassName} entity) {
        if (entity != null) {
            return entity.get${type.blobValueRefProperty.name?cap_first}();
        }

        return null;
    }

    /**
     * Sets the value of the given media entry link.
     * 
     * @param entity
     *            The media entry link which value is to be updated
     * @param blob
     *            The new representation.
     * @throws ResourceException
     */
    public void setValue(${type.fullClassName} entity, Representation blob)
            throws ResourceException {
        Reference ref = entity.get${type.blobValueEditRefProperty.name?cap_first}();

        if (ref != null) {
            ClientResource cr = createResource(ref);
            cr.put(blob);
        }
    }
    </#if>

</#list>
}