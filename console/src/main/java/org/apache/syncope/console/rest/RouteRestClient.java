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
package org.apache.syncope.console.rest;

import java.util.List;
import org.apache.syncope.common.services.RouteService;
import org.apache.syncope.common.to.RouteTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RouteRestClient extends BaseRestClient{
    
    protected static final Logger LOG = LoggerFactory.getLogger(RouteRestClient.class);
    
    public List<RouteTO> readRoutes(){
        return getService(RouteService.class).getRoutes();
    }
    
    public RouteTO readRoute(Long id){
        return getService(RouteService.class).getRoute(id);
    }
    
    public void updateRoute(Long id, String definition){
        RouteTO routeTO = readRoute(id);        
        routeTO.setRouteContent(definition);     
        getService(RouteService.class).importRoute(routeTO.getId(), routeTO);
    }
    
}
