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
import { RectangularNodeView, RenderingContext, svg } from '@eclipse-glsp/client';
import { injectable } from 'inversify';
import { VNode } from 'snabbdom';

import { NamedElement } from '../../../elements';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
const JSX = { createElement: svg };

// Due to typing issues (if we create elements we get an JSX.Element in return, not a VNode) we use a workaround and type the VNode elements with any to avoid compiling problems.
// Please also see for example: https://github.com/eclipse/sprotty/issues/178
// All described possible solutions did not work in our case.

@injectable()
export class InteractionOperandNodeView extends RectangularNodeView {
    override render(element: NamedElement, context: RenderingContext): VNode {
        const interactionOperandNode: any = (
            <g class-selected={element.selected} class-mouseover={element.hoverFeedback}>
                <line x1={0} y1={0} x2={element.bounds.width} y2={0} />
                {context.renderChildren(element)}
            </g>
        );

        return interactionOperandNode;
    }
}