package kosta.action.comm;

public class ActionForward {
	/* 리다이렉트 여부 */
	private boolean isRedirect;
	/* 경로 */
	private String path;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}