package mum.eud.week1ExtraCredit.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author PatiRam
 *
 */
@Entity
public class Artist {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;
	private String dateOfPlace;
	private String biography;
	@Lob
	private byte[] profilePicture;
	@ManyToMany(mappedBy="artists")
	private List<Movie> movies = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfPlace() {
		return dateOfPlace;
	}
	public void setDateOfPlace(String dateOfPlace) {
		this.dateOfPlace = dateOfPlace;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}
