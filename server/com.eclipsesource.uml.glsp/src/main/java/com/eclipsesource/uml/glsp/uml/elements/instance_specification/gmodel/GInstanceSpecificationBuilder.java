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
package com.eclipsesource.uml.glsp.uml.elements.instance_specification.gmodel;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.uml2.uml.InstanceSpecification;

import com.eclipsesource.uml.glsp.core.constants.CoreCSS;
import com.eclipsesource.uml.glsp.uml.elements.named_element.GNamedElementBuilder;
import com.eclipsesource.uml.glsp.uml.gmodel.builder.UmlGCompartmentBuilder;
import com.eclipsesource.uml.glsp.uml.gmodel.provider.GIdContextGeneratorProvider;
import com.eclipsesource.uml.glsp.uml.gmodel.provider.GIdGeneratorProvider;
import com.eclipsesource.uml.glsp.uml.gmodel.provider.GModelMapHandlerProvider;
import com.eclipsesource.uml.glsp.uml.gmodel.provider.GSuffixProvider;

public class GInstanceSpecificationBuilder<TSource extends InstanceSpecification, TProvider extends GSuffixProvider & GIdGeneratorProvider & GIdContextGeneratorProvider & GModelMapHandlerProvider, TBuilder extends GInstanceSpecificationBuilder<TSource, TProvider, TBuilder>>
   extends GNamedElementBuilder<TSource, TProvider, TBuilder> {

   public GInstanceSpecificationBuilder(final TSource source, final TProvider provider, final String type) {
      super(source, provider, type);
   }

   @Override
   protected void prepareAdditionals() {
      super.prepareAdditionals();

      showHeader();
      showBody();
   }

   protected void showHeader() {
      var header = new UmlGCompartmentBuilder<>(source, provider)
         .withHeaderLayout();

      var name = source.getClassifiers().size() == 0 ? source.getName()
         : String.format("%s:%s", source.getName(),
            String.join(",",
               source.getClassifiers().stream()
                  .map(c -> c.getName()).collect(Collectors.toList())));

      header.add(buildName(name, List.of(CoreCSS.FONT_BOLD)));

      add(header.build());
   }

   protected void showBody() {
      var compartment = new UmlGCompartmentBuilder<>(source, provider)
         .withVBoxLayout();

      var slotElements = source.getSlots().stream()
         .map(e -> provider.gmodelMapHandler().handle(e))
         .collect(Collectors.toList());
      compartment.addAll(slotElements);

      add(compartment.build());
   }
}
