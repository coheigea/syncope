/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.common.rest.api.service;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.syncope.common.lib.to.SAML2IdPEntityTO;
import org.apache.syncope.common.rest.api.RESTHeaders;

/**
 * REST operations for SAML 2.0 IdP metadata.
 */
@Tag(name = "SAML 2.0")
@SecurityRequirements({
    @SecurityRequirement(name = "BasicAuthentication"),
    @SecurityRequirement(name = "Bearer") })
@Path("saml2/idp")
public interface SAML2IdPEntityService extends JAXRSService {

    String DEFAULT_OWNER = "Syncope";

    /**
     * Returns the SAML 2.0 IdP entities.
     *
     * @return SAML 2.0 IdP entities
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, RESTHeaders.APPLICATION_YAML, MediaType.APPLICATION_XML })
    List<SAML2IdPEntityTO> list();

    /**
     * Returns the SAML 2.0 IdP entity matching the given key.
     *
     * @param key key of requested SAML 2.0 IdP entity
     * @return SAML 2.0 IdP entity with matching key
     */
    @GET
    @Path("{key}")
    @Produces({ MediaType.APPLICATION_JSON, RESTHeaders.APPLICATION_YAML, MediaType.APPLICATION_XML })
    SAML2IdPEntityTO get(@NotNull @PathParam("key") String key);

    /**
     * Store the entity to finalize the generation process.
     *
     * @param entityTO entity to be created
     */
    @POST
    @Path("{key}")
    @Consumes({ MediaType.APPLICATION_JSON, RESTHeaders.APPLICATION_YAML, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, RESTHeaders.APPLICATION_YAML, MediaType.APPLICATION_XML })
    void set(@NotNull SAML2IdPEntityTO entityTO);
}
