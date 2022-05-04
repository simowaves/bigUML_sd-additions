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
package com.eclipsesource.uml.modelserver.commands.activitydiagram.activity;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.eclipsesource.uml.modelserver.commands.activitydiagram.action.SetBehaviorCommand;
import com.eclipsesource.uml.modelserver.commands.commons.notation.RemoveNotationElementCommand;
import com.eclipsesource.uml.modelserver.commands.util.UmlSemanticCommandUtil;

public class RemoveActivityCompoundCommand extends CompoundCommand {

   public RemoveActivityCompoundCommand(final EditingDomain domain, final URI modelUri, final String activityUri) {
      RemoveActivityCommand semanticCmd = new RemoveActivityCommand(domain, modelUri, activityUri);
      semanticCmd.getOwnedElements().forEach(edge -> {
         String elemUri = UmlSemanticCommandUtil.getSemanticUriFragment(edge);
         this.append(new RemoveNotationElementCommand(domain, modelUri, elemUri));
      });
      semanticCmd.getReferencingCallBehaviorActions().forEach(cba -> {
         String elemUri = UmlSemanticCommandUtil.getSemanticUriFragment(cba);
         this.append(new SetBehaviorCommand(domain, modelUri, elemUri, null));
      });
      this.append(semanticCmd);
      this.append(new RemoveNotationElementCommand(domain, modelUri, activityUri));
   }

}