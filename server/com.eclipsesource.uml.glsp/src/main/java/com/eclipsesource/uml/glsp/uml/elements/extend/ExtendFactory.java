/********************************************************************************
 * Copyright (c) 2023 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 ********************************************************************************/
package com.eclipsesource.uml.glsp.uml.elements.extend;

import com.eclipsesource.uml.glsp.uml.configuration.di.EdgeConfigurationFactory;
import com.eclipsesource.uml.glsp.uml.elements.extend.gmodel.ExtendEdgeMapper;
import com.eclipsesource.uml.glsp.uml.gmodel.di.GModelMapperFactory;
import com.eclipsesource.uml.glsp.uml.handler.di.EdgeOperationHandlerFactory;
import com.eclipsesource.uml.modelserver.unotation.Representation;

public interface ExtendFactory
   extends EdgeConfigurationFactory, EdgeOperationHandlerFactory, GModelMapperFactory {

   @Override
   ExtendConfiguration edgeConfiguration(Representation representation);

   @Override
   ExtendEdgeMapper gmodel(Representation representation);

   @Override
   ExtendOperationHandler edgeOperationHandler(Representation representation);
}
