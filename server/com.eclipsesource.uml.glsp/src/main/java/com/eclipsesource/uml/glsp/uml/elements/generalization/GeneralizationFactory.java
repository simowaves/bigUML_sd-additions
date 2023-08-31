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
package com.eclipsesource.uml.glsp.uml.elements.generalization;

import com.eclipsesource.uml.glsp.uml.configuration.di.EdgeConfigurationFactory;
import com.eclipsesource.uml.glsp.uml.elements.generalization.features.GeneralizationPropertyMapper;
import com.eclipsesource.uml.glsp.uml.elements.generalization.gmodel.GeneralizationEdgeMapper;
import com.eclipsesource.uml.glsp.uml.features.property_palette.di.PropertyMapperFactory;
import com.eclipsesource.uml.glsp.uml.gmodel.di.GModelMapperFactory;
import com.eclipsesource.uml.glsp.uml.handler.di.EdgeOperationHandlerFactory;
import com.eclipsesource.uml.modelserver.unotation.Representation;

public interface GeneralizationFactory
   extends EdgeConfigurationFactory, EdgeOperationHandlerFactory, GModelMapperFactory, PropertyMapperFactory {

   @Override
   GeneralizationConfiguration edgeConfiguration(Representation representation);

   @Override
   GeneralizationEdgeMapper gmodel(Representation representation);

   @Override
   GeneralizationOperationHandler edgeOperationHandler(Representation representation);

   @Override
   GeneralizationPropertyMapper elementPropertyMapper(Representation representation);
}