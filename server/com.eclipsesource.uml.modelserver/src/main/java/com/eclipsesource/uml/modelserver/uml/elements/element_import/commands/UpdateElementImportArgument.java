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
package com.eclipsesource.uml.modelserver.uml.elements.element_import.commands;

import java.util.Optional;

import org.eclipse.uml2.uml.VisibilityKind;

import com.eclipsesource.uml.modelserver.uml.elements.element.UpdateElementArgument;

public class UpdateElementImportArgument extends UpdateElementArgument {
   protected VisibilityKind visibilityKind;

   protected String alias;

   public Optional<VisibilityKind> visibilityKind() {
      return Optional.ofNullable(visibilityKind);
   }

   public Optional<String> alias() {
      return Optional.ofNullable(alias);
   }

   public static Builder<?> by() {
      return new Builder<>();
   }

   public static class Builder<TArgument extends UpdateElementImportArgument>
      extends UpdateElementArgument.Builder<TArgument> {

      public Builder<TArgument> visibilityKind(final VisibilityKind value) {
         argument.visibilityKind = value;
         return this;
      }

      public Builder<TArgument> alias(final String value) {
         argument.alias = value;
         return this;
      }
   }
}
