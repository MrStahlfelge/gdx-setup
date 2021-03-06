/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.setup;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.google.gwt.user.client.Window;

/** Launches the GWT application. */
public class GwtLauncher extends GwtApplication implements LinkWorker {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration gwtApplicationConfiguration = new GwtApplicationConfiguration(GwtApplication.isMobileDevice());
		gwtApplicationConfiguration.padHorizontal = 0;
		gwtApplicationConfiguration.padVertical = 0;
		gwtApplicationConfiguration.disableAudio = true;
		return gwtApplicationConfiguration;
	}

	@Override
	public ApplicationListener createApplicationListener () {
	    SetupUi.linkWorker = this;
		return new SetupUi();
	}
    
    @Override
    public void openLink(boolean newWindow, String URI) {
        if (newWindow) {
            Window.open(URI, "_blank", null);
        } else {
            Window.Location.assign(URI);
        }
    }
}
