package mainpackage;

public class Films {
	private int filmId;
	private String filmTitle;
	private String filmCategory;
	private String filmDescription;

	public Films(int filmId, String filmTitle, String filmCategory, String filmDescription) {
		this.filmId = filmId;
		this.filmTitle = filmTitle;
	 	this.filmCategory = filmCategory;
	 	this.filmDescription = filmDescription;
	}
	
	public int getFilmId() {
		return filmId;
	 }

	public String getFilmTitle() {
		return filmTitle;
	}

	public String getFilmCategory() {
		return filmCategory;
	}

	public String getFilmDescription() {
		return filmDescription;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public void setFilmCategory(String filmCategory) {
		this.filmCategory = filmCategory;
	}

	public void setFilmDescription(String description) {
		this.filmDescription = description;
	}
	
}
