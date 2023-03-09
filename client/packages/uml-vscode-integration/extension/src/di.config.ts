/********************************************************************************
 * Copyright (c) 2021-2022 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/

import { Container, ContainerModule } from 'inversify';
import * as vscode from 'vscode';
import { TYPES, VSCODE_TYPES } from './di.types';
import { UVGlspConnector } from './glsp/connection/uv-glsp-connector';
import { UVGlspServer } from './glsp/connection/uv-glsp-server';
import { UVModelServerClient } from './modelserver/uv-modelserver.client';
import { CommandManager } from './vscode/command/command.manager';
import { DisposableManager } from './vscode/disposable/disposable.manager';
import { EditorProvider } from './vscode/editor/editor.provider';
import { NewFileCommand } from './vscode/new-file/new-file.command';
import { NewFileCreator } from './vscode/new-file/new-file.creator';
import { ThemeManager } from './vscode/theme-manager/theme-manager';
import { WorkspaceWatcher } from './vscode/workspace/workspace.watcher';

export function createContainer(context: vscode.ExtensionContext): Container {
    const vscodeModule = new ContainerModule((bind, unbind, isBound, rebind) => {
        bind(TYPES.GlspServer).to(UVGlspServer).inSingletonScope();
        bind(TYPES.Connector).to(UVGlspConnector).inSingletonScope();

        bind(VSCODE_TYPES.CommandManager).to(CommandManager).inSingletonScope();

        bind(TYPES.ModelServerClient).to(UVModelServerClient).inSingletonScope();

        bind(NewFileCreator).toSelf().inSingletonScope();
        bind(VSCODE_TYPES.Command).to(NewFileCommand);

        bind(VSCODE_TYPES.DisposableManager).to(DisposableManager).inSingletonScope();
        bind(VSCODE_TYPES.Disposable).toService(TYPES.ModelServerClient);
        bind(VSCODE_TYPES.Disposable).toService(TYPES.GlspServer);
        bind(VSCODE_TYPES.Disposable).toService(TYPES.Connector);

        bind(VSCODE_TYPES.EditorProvider).to(EditorProvider).inSingletonScope();

        bind(VSCODE_TYPES.ThemeManager).to(ThemeManager).inSingletonScope();

        bind(VSCODE_TYPES.Watcher).to(WorkspaceWatcher).inSingletonScope();
    });

    const container = new Container({
        skipBaseClassChecks: true
    });

    container.bind(VSCODE_TYPES.ExtensionContext).toConstantValue(context);
    container.load(vscodeModule);

    return container;
}