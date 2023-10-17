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
package com.eclipsesource.uml.glsp.uml.gmodel.builder;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.glsp.graph.DefaultTypes;
import org.eclipse.glsp.graph.GCompartment;
import org.eclipse.glsp.graph.GraphFactory;
import org.eclipse.glsp.graph.builder.AbstractGCompartmentBuilder;
import org.eclipse.glsp.graph.builder.impl.GLayoutOptions;
import org.eclipse.glsp.graph.util.GConstants;

import com.eclipsesource.uml.glsp.core.constants.UmlLayoutConstants;
import com.eclipsesource.uml.glsp.uml.gmodel.provider.GIdContextGeneratorProvider;
import com.eclipsesource.uml.glsp.uml.gmodel.provider.GIdGeneratorProvider;

public class UmlGCompartmentBuilder<TProvider extends GIdGeneratorProvider & GIdContextGeneratorProvider, TBuilder extends UmlGCompartmentBuilder<TProvider, TBuilder>>
   extends AbstractGCompartmentBuilder<GCompartment, TBuilder> {
   protected EObject source;
   protected TProvider provider;

   public UmlGCompartmentBuilder(final EObject source, final TProvider provider) {
      this(source, provider, DefaultTypes.COMPARTMENT);
   }

   public UmlGCompartmentBuilder(final EObject source, final TProvider provider, final String type) {
      super(type);

      this.source = source;
      this.provider = provider;

      this.prepare();
   }

   protected void prepare() {
      this.id(provider.idContextGenerator().getOrCreateId(source));
   }

   public TBuilder withHeaderLayout() {
      this.type(DefaultTypes.COMPARTMENT_HEADER)
         .layout(GConstants.Layout.VBOX)
         .layoutOptions(new GLayoutOptions().hAlign(GConstants.HAlign.CENTER));
      return self();
   }

   public TBuilder withVBoxLayout() {
      var options = new GLayoutOptions()
         .hAlign(GConstants.HAlign.LEFT);
      options.put("hGrab", true);

      this.type(DefaultTypes.COMPARTMENT)
         .layout(GConstants.Layout.VBOX)
         .layoutOptions(options);

      return self();
   }

   public TBuilder withHBoxLayout() {
      var options = new GLayoutOptions()
         .hAlign(GConstants.HAlign.LEFT);

      this.type(DefaultTypes.COMPARTMENT)
         .layout(GConstants.Layout.HBOX)
         .layoutOptions(options);

      return self();
   }

   public TBuilder withFreeformLayout() {
      this.type(DefaultTypes.COMPARTMENT)
         .addArgument("divider", true)
         .layout(UmlLayoutConstants.FREEFORM)
         .layoutOptions(new GLayoutOptions()
            .hAlign(GConstants.HAlign.LEFT)
            .resizeContainer(true));

      return self();
   }

   public TBuilder appendLayoutOptions(final GLayoutOptions options) {
      this.layoutOptions.putAll(options);

      return self();
   }

   public TBuilder clearPadding() {
      this.layoutOptions.putAll(new GLayoutOptions()
         .paddingTop(0.0)
         .paddingRight(0.0)
         .paddingBottom(0.0)
         .paddingLeft(0.0));

      return self();
   }

   @Override
   protected GCompartment instantiate() {
      return GraphFactory.eINSTANCE.createGCompartment();
   }

   @Override
   protected TBuilder self() {
      return (TBuilder) this;
   }
}
