/********************************************************************************
 * Copyright (c) 2021-2022 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 ********************************************************************************/
package com.eclipsesource.uml.glsp.uml.elements.operation.gmodel;

import org.eclipse.glsp.graph.GNode;
import org.eclipse.uml2.uml.Operation;

import com.eclipsesource.uml.glsp.uml.gmodel.RepresentationGNodeMapper;
import com.eclipsesource.uml.modelserver.unotation.Representation;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public final class OperationNodeMapper extends RepresentationGNodeMapper<Operation, GNode> {

   @Inject
   public OperationNodeMapper(@Assisted final Representation representation) {
      super(representation);
   }

   @Override
   public GNode map(final Operation source) {
      var builder = new GOperationBuilder<>(source, this, configuration().typeId());

      return builder.build();
   }
}
