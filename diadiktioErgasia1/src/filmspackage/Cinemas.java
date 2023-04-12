package filmspackage;

public class Cinemas {
	private String cinemaId;
	private boolean cinemaIs3D;
	private String cinemaNumberOfSeats;

	public Cinemas(String cinemaId, boolean cinemaIs3D, String cinemaNumberOfSeats) {
		this.cinemaId = cinemaId;
		this.cinemaIs3D = cinemaIs3D;
		this.cinemaNumberOfSeats = cinemaNumberOfSeats;
	}
	public Cinemas() {
		
	}
	

	public String getCinemaId() {
		
		return cinemaId;
	}

	public boolean getCinemaIs3D() {
		
		return cinemaIs3D;
	}

	public void setCinemaIs3D(boolean cinemaIs3D) {
		
		this.cinemaIs3D = cinemaIs3D;
	}
	
	public void setCinemaId(String cinemaId) {
		
		this.cinemaId = cinemaId;
	}

	public String getCinemaNumberOfSeats() {
		
		return cinemaNumberOfSeats;
	}

	public void setCinemaNumberOfSeats(String cinemaNumberOfSeats) {
		
		this.cinemaNumberOfSeats = cinemaNumberOfSeats;
	}

}