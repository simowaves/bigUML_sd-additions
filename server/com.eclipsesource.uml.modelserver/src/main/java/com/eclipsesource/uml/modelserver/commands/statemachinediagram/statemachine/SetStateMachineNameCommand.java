/********************************************************************************
 * Copyright (c) 2021 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 ********************************************************************************/
package com.eclipsesource.uml.modelserver.commands.statemachinediagram.statemachine;

import com.eclipsesource.uml.modelserver.commands.commons.semantic.UmlSemanticElementCommand;
import com.eclipsesource.uml.modelserver.commands.util.UmlSemanticCommandUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.StateMachine;

public class SetStateMachineNameCommand extends UmlSemanticElementCommand {

   protected String semanticUriFragment;
   protected String newName;

   public SetStateMachineNameCommand(final EditingDomain domain, final URI modelUri, final String semanticUriFragment,
      final String newName) {
      super(domain, modelUri);
      this.semanticUriFragment = semanticUriFragment;
      this.newName = newName;
   }

   @Override
   protected void doExecute() {
      StateMachine stateMachineToRename = UmlSemanticCommandUtil.getElement(umlModel, semanticUriFragment,
         StateMachine.class);
      stateMachineToRename.setName(newName);
   }

}