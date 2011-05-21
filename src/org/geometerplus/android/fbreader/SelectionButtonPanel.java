/*
 * Copyright (C) 2007-2011 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader;

import org.geometerplus.fbreader.fbreader.ActionCode;
import org.geometerplus.fbreader.fbreader.FBReaderApp;
import org.geometerplus.zlibrary.ui.android.R;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class SelectionButtonPanel extends SeveralButtonsPanel {
    SelectionButtonPanel(FBReaderApp fbReader) {
        super(fbReader);
    }

    @Override
	public void createControlPanel(FBReader activity, RelativeLayout root, ControlPanel.Location location) {
		super.createControlPanel(activity, root, location);
        addButton(ActionCode.SELECTION_COPY_TO_CLIPBOARD, true, R.drawable.selection_copy);
        addButton(ActionCode.SELECTION_SHARE, true, R.drawable.selection_share);
        addButton(ActionCode.SELECTION_OPEN_IN_DICTIONARY, true, R.drawable.selection_dictionary);
        addButton(ActionCode.SELECTION_ADD_BOOKMARK, true, R.drawable.selection_bookmark);
        addButton(ActionCode.SELECTION_HIDE_PANEL, true, R.drawable.selection_bookmark);
    }
    
    public void move(int selectionStartY, int selectionEndY) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
              RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        int verticalPosition; 
        int screenHeight = ((View)myControlPanel.getParent()).getHeight();
        if (screenHeight - selectionEndY > myControlPanel.getHeight() + 10)
            verticalPosition = RelativeLayout.ALIGN_PARENT_BOTTOM;
        else if (selectionStartY > myControlPanel.getHeight() + 10)
            verticalPosition = RelativeLayout.ALIGN_PARENT_TOP;
        else
            verticalPosition = RelativeLayout.CENTER_VERTICAL; 

        layoutParams.addRule(verticalPosition);
        myControlPanel.setLayoutParams(layoutParams);
    }
}
