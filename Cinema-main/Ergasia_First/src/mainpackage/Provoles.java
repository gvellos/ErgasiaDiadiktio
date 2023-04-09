package mainpackage;

public class Provoles {
	int provoliID;
	String provoliFilm;
	String provoliCinema;
	String provoliStartDate;
	String provoliEndDate;
	int provoliNumberOfReservations;
	boolean  provoliIsAvailable;
	
	public Provoles(int provoliID, String provoliFilm, String provoliCinema, String provoliStartDate, String provoliEndDate, int provoliNumberOfReservations, boolean provoliIsAvailable) {
        this.provoliID = provoliID;
        this.provoliFilm = provoliFilm;
        this.provoliCinema = provoliCinema;
        this.provoliStartDate = provoliStartDate;
        this.provoliEndDate = provoliEndDate;
        this.provoliNumberOfReservations = provoliNumberOfReservations;
        this.provoliIsAvailable = provoliIsAvailable;
    }
	
	public int getProvoliID() {
		return provoliID;
	}
	
	public String getProvoliFilm() {
		return provoliFilm;
	}
	
	public String getProvoliCinema() {
		return provoliCinema;
	}
	
	public String getProvoliStartDate() {
		return provoliStartDate;
	}
	
	public String getProvoliEndDate() {
		return provoliEndDate;
	}
	
	public int getProvoliNumberOfReservations() {
		return provoliNumberOfReservations;
	}
	
	public boolean getProvoliIsAvailable() {
		return provoliIsAvailable;
	}

	
	public void setProvoliID(int provoliID) {
        this.provoliID = provoliID;
    }
	
	public void setProvoliFilm(String provoliFilm) {
        this.provoliFilm = provoliFilm;
    }
	
	public void setProvoliCinema(String provoliCinema) {
        this.provoliCinema = provoliCinema;
    }
	
	public void setProvoliStartDate(String provoliStartDate) {
        this.provoliStartDate = provoliStartDate;
    }
	
	public void setProvoliEndDate(String provoliEndDate) {
        this.provoliEndDate = provoliEndDate;
    }
	
	public void setProvoliNumberOfReservations(int provoliNumberOfReservations) {
        this.provoliNumberOfReservations = provoliNumberOfReservations;
    }
	
	public void setProvoliIsAvailable(boolean provoliIsAvailable) {
        this.provoliIsAvailable = provoliIsAvailable;
    }
	
	
}
