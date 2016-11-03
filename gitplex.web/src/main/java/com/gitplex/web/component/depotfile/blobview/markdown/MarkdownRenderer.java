package com.gitplex.web.component.depotfile.blobview.markdown;

import com.gitplex.web.component.depotfile.blobview.BlobRenderer;
import com.gitplex.web.component.depotfile.blobview.BlobViewContext;
import com.gitplex.web.component.depotfile.blobview.BlobViewPanel;
import com.gitplex.web.component.depotfile.blobview.BlobViewContext.Mode;
import com.gitplex.web.component.depotfile.blobview.source.SourceViewPanel;
import com.gitplex.commons.git.Blob;

public class MarkdownRenderer implements BlobRenderer {

	@Override
	public BlobViewPanel render(String panelId, BlobViewContext context) {
		Blob blob = context.getDepot().getBlob(context.getBlobIdent());
		if (context.getBlobIdent().isFile() 
				&& blob.getText() != null 
				&& context.getBlobIdent().path.endsWith(".md")) { 
			if (context.getMark() != null || context.getMode() == Mode.BLAME)
				return new SourceViewPanel(panelId, context);
			else
				return new MarkdownFilePanel(panelId, context);
		} else {
			return null;
		}
	}

}