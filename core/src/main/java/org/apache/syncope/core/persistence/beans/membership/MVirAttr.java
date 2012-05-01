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
package org.apache.syncope.core.persistence.beans.membership;

import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import org.apache.syncope.core.persistence.beans.AbstractAttributable;
import org.apache.syncope.core.persistence.beans.AbstractVirAttr;
import org.apache.syncope.core.persistence.beans.AbstractVirSchema;

@Entity
public class MVirAttr extends AbstractVirAttr {

    private static final long serialVersionUID = 7774760571251641332L;
    @ManyToOne
    private Membership owner;
    @ManyToOne(fetch = FetchType.EAGER)
    private MVirSchema virtualSchema;

    @Override
    public <T extends AbstractAttributable> T getOwner() {
        return (T) owner;
    }

    @Override
    public <T extends AbstractAttributable> void setOwner(T owner) {
        if (!(owner instanceof Membership)) {
            throw new ClassCastException("expected type Membership, found: " + owner.getClass().getName());
        }

        this.owner = (Membership) owner;
    }

    @Override
    public <T extends AbstractVirSchema> T getVirtualSchema() {
        return (T) virtualSchema;
    }

    @Override
    public <T extends AbstractVirSchema> void setVirtualSchema(T virtualSchema) {
        if (!(virtualSchema instanceof MVirSchema)) {
            throw new ClassCastException("expected type MVirSchema, found: " + virtualSchema.getClass().getName());
        }
        this.virtualSchema = (MVirSchema) virtualSchema;
    }

    @Override
    public List<String> getValues() {
        return Collections.EMPTY_LIST;
    }
}
