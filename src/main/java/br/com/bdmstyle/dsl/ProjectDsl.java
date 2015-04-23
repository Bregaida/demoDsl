package br.com.bdmstyle.dsl;

public class ProjectDsl extends Dsl {
	
	public ProjectDsl(Context ctx) {
		context = ctx;
	}
	
	public ReferenceDsl projectId(String projectId){
		context.projectId = projectId;
		return new ReferenceDsl(context);
	}
	
}
