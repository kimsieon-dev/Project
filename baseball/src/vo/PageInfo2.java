package vo;

public class PageInfo2 {
	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int listCount;
	private int widthBlock = 5;
	private int pageRows = 10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getWidthBlock() {
		return widthBlock;
	}

	public void setWidthBlock(int widthBlock) {
		this.widthBlock = widthBlock;
	}

	public int getPageRows() {
		return pageRows;
	}

	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	
	
}
