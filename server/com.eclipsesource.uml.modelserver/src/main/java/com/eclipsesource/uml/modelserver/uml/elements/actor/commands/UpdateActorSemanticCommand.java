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
package com.eclipsesource.uml.modelserver.uml.elements.actor.commands;

import java.util.List;

import org.eclipse.uml2.uml.Actor;

import com.eclipsesource.uml.modelserver.shared.model.ModelContext;
import com.eclipsesource.uml.modelserver.shared.semantic.BaseUpdateSemanticElementCommand;
import com.eclipsesource.uml.modelserver.uml.elements.classifier.UpdateClassifierSemanticCommand;

public class UpdateActorSemanticCommand extends BaseUpdateSemanticElementCommand<Actor, UpdateActorArgument> {

   public UpdateActorSemanticCommand(final ModelContext context, final Actor semanticElement,
      final UpdateActorArgument updateArgument) {
      super(context, semanticElement, updateArgument);
   }

   @Override
   protected void updateSemanticElement(final Actor semanticElement,
      final UpdateActorArgument updateArgument) {
      include(List.of(new UpdateClassifierSemanticCommand(context, semanticElement, updateArgument)));
   }
}
