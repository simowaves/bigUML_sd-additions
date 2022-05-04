package com.eclipsesource.uml.modelserver.commands.usecasediagram.usecase;

import com.eclipsesource.uml.modelserver.commands.commons.notation.UmlNotationElementCommand;
import com.eclipsesource.uml.modelserver.commands.util.UmlNotationCommandUtil;
import com.eclipsesource.uml.modelserver.unotation.Shape;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;

public class RemoveUseCaseShapeCommand extends UmlNotationElementCommand {

    protected final Shape shapeToRemove;

    public RemoveUseCaseShapeCommand(final EditingDomain domain, final URI modelUri, final String semanticProxy) {
        super(domain, modelUri);
        this.shapeToRemove = UmlNotationCommandUtil.getNotationElement(modelUri, domain, semanticProxy, Shape.class);
    }

    @Override
    protected void doExecute(){
        umlDiagram.getElements().remove(shapeToRemove);
    }
}