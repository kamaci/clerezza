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
package org.apache.clerezza.sparql.update.impl;

import org.apache.clerezza.IRI;
import org.apache.clerezza.sparql.update.UpdateOperation;

import java.util.Set;

/**
 *
 * @author hasan
 */
public class SimpleUpdateOperation extends BaseUpdateOperation {

    private boolean silent;

    public SimpleUpdateOperation() {
        this.silent = false;
        inputGraphSpec = UpdateOperation.GraphSpec.DEFAULT;
        destinationGraphSpec = UpdateOperation.GraphSpec.DEFAULT;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public boolean isSilent() {
        return silent;
    }

    public void setInputGraph(IRI source) {
        inputGraphSpec = UpdateOperation.GraphSpec.GRAPH;
        inputGraphs.clear();
        inputGraphs.add(source);
    }

    public IRI getInputGraph(IRI defaultGraph) {
        Set<IRI> result = getInputGraphs(defaultGraph, null);
        if (result.isEmpty()) {
            return null;
        } else {
            return result.iterator().next();
        }
    }

    public void setDestinationGraph(IRI destination) {
        destinationGraphSpec = UpdateOperation.GraphSpec.GRAPH;
        destinationGraphs.clear();
        destinationGraphs.add(destination);
    }

    public IRI getDestinationGraph(IRI defaultGraph) {
        Set<IRI> result = getDestinationGraphs(defaultGraph, null);
        if (result.isEmpty()) {
            return null;
        } else {
            return result.iterator().next();
        }
    }
}
