package com.pmease.gitplex.web.page.repository.source.commit.diff.renderer.image;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.pmease.gitplex.core.model.Repository;
import com.pmease.gitplex.web.page.repository.source.commit.diff.patch.FileHeader;

@SuppressWarnings("serial")
public class AbstractImageDiffPanel extends Panel {
	
	protected final IModel<FileHeader> fileModel;
	protected final IModel<Repository> repositoryModel;
	protected final IModel<String> sinceModel;
	protected final IModel<String> untilModel;
	
	public AbstractImageDiffPanel(String id, 
			IModel<FileHeader> fileModel, 
			IModel<Repository> repositoryModel,
			IModel<String> sinceModel,
			IModel<String> untilModel) {
		
		super(id);
		
		this.fileModel = fileModel;
		this.repositoryModel = repositoryModel;
		this.sinceModel = sinceModel;
		this.untilModel = untilModel;
		
		setOutputMarkupId(true);
	}
	
	protected FileHeader getFile() {
		return fileModel.getObject();
	}
	
	protected Repository getRepository() {
		return repositoryModel.getObject();
	}
	
	protected String getSince() {
		return sinceModel.getObject();
	}
	
	protected String getUntil() {
		return untilModel.getObject();
	}
	
	@Override
	public void onDetach() {
		if (fileModel != null) {
			fileModel.detach();
		}
		
		if (repositoryModel != null) {
			repositoryModel.detach();
		}
		
		if (sinceModel != null) {
			sinceModel.detach();
		}
		
		if (untilModel != null) {
			untilModel.detach();
		}
		
		super.onDetach();
	}
}